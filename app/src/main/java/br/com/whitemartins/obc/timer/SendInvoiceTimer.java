package br.com.whitemartins.obc.timer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

import java.io.File;
import java.io.IOException;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.CecType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.enumeration.SevereErrorsType;
import br.com.whitemartins.obc.enumeration.StatusCecType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.service.SendInvoiceService;
import br.com.whitemartins.obc.util.Constants;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.FileHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.PathHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.CecActivity;
import br.com.whitemartins.obc.views.DatabaseApp;

public class SendInvoiceTimer extends BaseTimer {
  protected Invoice invoice;

  private void performCopy(String fileName) {
    String sourcePath = android.os.Environment.getDataDirectory() + "/data/br.com.whitemartins.obc/databases/" + fileName;
    File source = new File(sourcePath);

    String destinationPath = PathHelper.self().getFilePathLog() + fileName;
    File destination = new File(destinationPath);
    try {
      UtilHelper.copyFile(source, destination);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private UtilHelper.OnOkListener positiveButton = new UtilHelper.OnOkListener() {
    @Override
    public boolean onOkClick(String value) {
      FileHelper.self(activity.get())
          .setOptionType(OptionType.APAGAR_BASE)
          .execute();

      return true;
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface finishExecuteServiceCallback =
      new MyCallbackInterface.CallbackBooleanInterface() {

        @Override
        public void execute(Boolean success) {
          running = false;
          finalizadoSucesso = success;

          if (success)
            step++;

          if (step > StepEmissaoType.CONSULTAR.getValue()) {
            //Buscando o status da nota fiscal depois da mensageria
            invoice = DatabaseApp.self().getDatabase().invoiceDao().findById(invoice.getId());

            if (SevereErrorsType.isSevereStatus(invoice.getStatusGravacaoJde())) {

              performCopy(Constants.DATABASE_NAME);
              performCopy(Constants.DATABASE_NAME + "-shm");
              performCopy(Constants.DATABASE_NAME + "-wal");

              finalizadoSucesso = false;
              SendInvoiceTimer.this.cancel();
              SendInvoiceTimer.this.onFinish();
            }

            if (!StatusNFeType.isFinalStatus(invoice.getStatus()))
              finalizadoSucesso = false;
            else {

              boolean aVista = invoice.getValorFatura() == 0;

              StatusCecType statusCecType = StatusCecType.CEC_ON;
              SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());
              CecType cecType = GLOBAL.self().getCecDanfe(operation, aVista);

              if (Integer.parseInt(cecType.getValue()) >= 3)
                statusCecType = StatusCecType.DANFE_ON;

              if (invoice.getNomeFormaImpressaoCec() == null
                  || invoice.getNomeFormaImpressaoCec().isEmpty())
                invoice.setNomeFormaImpressaoCec(statusCecType.getValue().toString() + statusCecType.getName());

              LogHelper.self().info(TAG, "FINALIZANDO NOTA FISCAL");
              SendInvoiceTimer.this.cancel();
              SendInvoiceTimer.this.onFinish();
            }
          }
        }
      };

  public SendInvoiceTimer(Activity activity, long startTime, long interval) {
    super(activity, startTime, interval);
  }

  @Override
  protected void finishTickCallback(Boolean sucesso) {
    LogHelper.self().info(TAG, "TEMPO ESGOTADO: " + invoice.toString());

    if (!sucesso) {
      if (SevereErrorsType.isSevereStatus(invoice.getStatusGravacaoJde())) {
        GLOBAL.self().getRoute().setBloqViagem(ConstantsEnum.YES.getValue());
        GLOBAL.self().getRoute().save();
        SendInvoiceTimer.this.cancel();

        dismissDialog();

        DialogHelper.showErrorMessageStyled(activity.get(),
            activity.get().getString(R.string.erro_text),
            invoice.getMensagemGravacaoJde(), new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                final String msg = activity.get().getString(R.string.attention) + "\n\n" +
                    activity.get().getString(R.string.lock_trip);

                DialogHelper.showInputPasswordDialog(activity.get(), msg, positiveButton,
                    false);
              }
            });
      } else {
        boolean aVista = invoice.getValorFatura() == 0;

        SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());
        CecType cecType = GLOBAL.self().getCecDanfe(operation, aVista);

        DialogHelper.showQuestionMessage(activity.get(),
            activity.get().getString(R.string.confirmar_text),
            String.format(activity.get().getString(R.string.msg_nova_tentativa_invoice),
                cecType.getName()), new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {

                step = StepEmissaoType.ENVIAR.getValue();
                invoice.setStatus(StatusNFeType.PENDENTE_ENVIO.getValue());
                invoice.save();

                running = false;
                SendInvoiceTimer.this.start();
              }
            }, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                dismissDialog();

                CecType cecType = GLOBAL.self().getCecDanfe(operation, false);
                StatusCecType statusCecType = StatusCecType.CEC_OFF;

                if (Integer.parseInt(cecType.getValue()) >= 3)
                  statusCecType = StatusCecType.DANFE_OFF;

                invoice.setChave("");
                invoice.setProtocolo(statusCecType.getName());
                invoice.setStatusNfeImp(statusCecType.getValue() + statusCecType.getName());
                invoice.setStatusReportFile(statusCecType.getValue() + statusCecType.getTypeName());
                invoice.setStatusCec(statusCecType.getValue());
                invoice.setNomeFormaImpressaoCec(statusCecType.getValue().toString() + statusCecType.getName());
                invoice.save();

                Intent intent = new Intent(activity.get(), CecActivity.class);
                intent.putExtra("invoice", invoice);
                activity.get().startActivity(intent);
                activity.get().finish();
              }
            });
      }
    } else {
      Intent intent = new Intent(activity.get(), CecActivity.class);
      intent.putExtra("invoice", invoice);
      activity.get().startActivity(intent);
      activity.get().finish();
    }
  }

  @Override
  protected void tickCallback(Long ml) {
    String hms = UtilHelper.formatCounterTimeText(ml);

    chrono.setText(hms);

    try {
      if (!running) {
        running = true;

        if (invoice.getStatus().equals(StatusNFeType.PROCESSANDO.getValue()))
          step = StepEmissaoType.CONSULTAR.getValue();

        if (step.equals(StepEmissaoType.ENVIAR.getValue())) {
          invoice.setStepEmissao(StepEmissaoType.ENVIAR.getValue());
          invoice.save();

          txtStatusProgressDialog.setText(String.format(activity.get().getString(R.string.status),
              ActionType.ENVIAR_NOTA.getName()));

          new SendInvoiceService()
              .setInvoice(invoice)
              .setFinishExecuteCallback(finishExecuteServiceCallback)
              .setActivity(activity.get())
              .execute();

        } else if (step.equals(StepEmissaoType.CONSULTAR.getValue())) {
          invoice.setStepEmissao(StepEmissaoType.CONSULTAR.getValue());
          invoice.save();

          txtStatusProgressDialog.setText(String.format(activity.get().getString(R.string.status),
              ActionType.CONSULTAR_NOTA.getName()));

          new SendInvoiceService()
              .setInvoice(invoice)
              .setFinishExecuteCallback(finishExecuteServiceCallback)
              .setActivity(activity.get())
              .execute();
        }
      }
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
    }
  }

  @Override
  protected String getIdMessageHeader() {
    return activity.get().getString(R.string.send_invoice_warning_1);
  }

  @Override
  protected String getIdMessageStatus() {
    return activity.get().getString(R.string.send_invoice);
  }

  @Override
  protected String getIdMessageFooter() {
    return activity.get().getString(R.string.send_invoice_warning_2);
  }

  public SendInvoiceTimer setInvoice(Invoice invoice) {
    this.invoice = invoice;
    return this;
  }
}
