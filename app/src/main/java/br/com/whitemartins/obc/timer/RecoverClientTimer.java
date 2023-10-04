package br.com.whitemartins.obc.timer;

import android.app.Activity;
import android.content.DialogInterface;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.service.RecoveryClientService;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConsultaCliente;
import br.com.whitemartins.obc.xml.XmlRecuperaCliente;
import br.com.whitemartins.obc.xml.XmlRecuperaClienteRetorno;

public class RecoverClientTimer extends BaseTimer {
  private final String TAG = "RecoverClientTimer";
  private Long cdCustomer = 0L;
  private String xmlSend = "";
  private String xmlConsult = "";

  private MyCallbackInterface.CallbackBooleanInterface notifyOwner;

  private MyCallbackInterface.CallbackXmlRetornoClienteInterface finishServiceCallback
    = new MyCallbackInterface.CallbackXmlRetornoClienteInterface() {

    @Override
    public void execute(boolean success, XmlRecuperaClienteRetorno xmlRecuperaClienteRetorno) {
      running = false;

      finalizadoSucesso = false;

      if (success)
        step++;

      if (step > StepEmissaoType.CONSULTAR.getValue()) {
        running = false;

        if (ConstantsEnum.E.getValue().equalsIgnoreCase(xmlRecuperaClienteRetorno.getStatus()))
          DialogHelper.showInformationMessage(activity.get(),
            activity.get().getString(R.string.informar_text),
            String.format(activity.get().getString(R.string.erro_buscar_cliente),
              xmlRecuperaClienteRetorno.getMensagemExplicativa()),

            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                RecoverClientTimer.this.cancel();

                dismissDialog();

                notifyOwner.execute(false);
              }
            });
        else if (ConstantsEnum.F.getValue().equalsIgnoreCase(xmlRecuperaClienteRetorno.getStatus())) {
          DialogHelper.showQuestionMessage(activity.get(),
            activity.get().getString(R.string.informar_text),
            activity.get().getString(R.string.buscar_cliente_nao_concluido),
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                RecoverClientTimer.this.start();
              }
            }, null);
        } else if (ConstantsEnum.NO.getValue().equalsIgnoreCase(xmlRecuperaClienteRetorno.getStatus()))
          DialogHelper.showQuestionMessage(activity.get(),
            activity.get().getString(R.string.informar_text),
            activity.get().getString(R.string.buscar_cliente_nao_concluido),
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                RecoverClientTimer.this.start();
              }
            }, null);
        else if (ConstantsEnum.SIM.getValue().equalsIgnoreCase(xmlRecuperaClienteRetorno.getStatus())) {
          finalizadoSucesso = true;
          RecoverClientTimer.this.cancel();
          RecoverClientTimer.this.onFinish();
        }
      }
    }
  };

  public RecoverClientTimer(Activity activity, long startTime, long interval) {
    super(activity, startTime, interval);
  }

  public RecoverClientTimer setNotifyOwner(MyCallbackInterface.CallbackBooleanInterface notifyOwner) {
    this.notifyOwner = notifyOwner;
    return this;
  }

  @Override
  protected void finishTickCallback(Boolean sucesso) {
    if (sucesso) {
      XmlRecuperaClienteRetorno xmlRecuperaClienteRetorno = XmlRecuperaClienteRetorno.newInstance();
      xmlRecuperaClienteRetorno.parseAndSaveOnDb();

      Customer customer = DatabaseApp.self().getDatabase().customerDao().findById(cdCustomer);
      Patient patient = DatabaseApp.self().getDatabase().patientDao().findById(cdCustomer);
      String msg = "";

      if (customer != null)
        msg = String.format(activity.get().getString(R.string.cliente_recuperado_sucesso),
          customer.getCdCustomer(), customer.getNome());

      if (patient != null)
        msg = String.format(activity.get().getString(R.string.cliente_recuperado_sucesso),
          patient.getCdPaciente(), patient.getNome());

      LogHelper.self().info(TAG, "finishTickCallback " + msg);

      DialogHelper.showOkMessage(activity.get(),
        activity.get().getString(R.string.informar_text), msg,
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            notifyOwner.execute(finalizadoSucesso);
          }
        });

      dismissDialog();

    } else {
      LogHelper.self().info(TAG, "finishTickCallback " + activity.get().getString(R.string.erro_recovery_client));

      DialogHelper.showQuestionMessage(activity.get(),
        R.string.informar_text, R.string.erro_recovery_client, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            if (!sendDialog.isShowing())
              sendDialog.show();

            step = StepEmissaoType.ENVIAR.getValue();
            running = false;

            XmlRecuperaCliente xmlRecuperaCliente = XmlRecuperaCliente.newInstance();
            xmlSend = xmlRecuperaCliente.getXml(cdCustomer);

            XmlConsultaCliente xmlConsultaCliente = XmlConsultaCliente.newInstance();
            xmlConsultaCliente.setGuid(xmlRecuperaCliente.getGuid());
            xmlConsult = xmlConsultaCliente.getXml(cdCustomer);

            RecoverClientTimer.this.start();
          }
        }, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            activity.get().finish();
          }
        });
    }
  }

  @Override
  protected void tickCallback(Long ml) {
    String hms = UtilHelper.formatCounterTimeText(ml);

    chrono.setText(hms);

    try {
      if (!running) {
        running = true;

        if (step.equals(StepEmissaoType.ENVIAR.getValue())) {

          LogHelper.self().info(TAG, "callbackTickInterface envio.");

          txtStatusProgressDialog.setText(String.format(activity.get().getString(R.string.status),
            ActionType.RECUPERAR_CLIENTES.getName()));

          new RecoveryClientService()
            .setXmlSend(xmlSend)
            .setStep(step)
            .setActivity(activity.get())
            .setFinishExecuteCallback(finishServiceCallback)
            .execute();

        } else if (step.equals(StepEmissaoType.CONSULTAR.getValue())) {

          LogHelper.self().info(TAG, "callbackTickInterface consultar.");

          txtStatusProgressDialog.setText(String.format(activity.get().getString(R.string.status),
            ActionType.RECUPERAR_CLIENTES_CONSULTA.getName()));

          new RecoveryClientService()
            .setXmlConsult(xmlConsult)
            .setActivity(activity.get())
            .setStep(step)
            .setFinishExecuteCallback(finishServiceCallback)
            .execute();
        }
      }
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
    }
  }

  public RecoverClientTimer setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;

    XmlRecuperaCliente xmlRecuperaCliente = XmlRecuperaCliente.newInstance();
    xmlSend = xmlRecuperaCliente.getXml(cdCustomer);

    XmlConsultaCliente.self().setGuid(xmlRecuperaCliente.getGuid());
    xmlConsult = XmlConsultaCliente.self().getXml(cdCustomer);

    return this;
  }

  @Override
  protected String getIdMessageHeader() {
    return activity.get().getString(R.string.msg_recuperar_cliente);
  }

  @Override
  protected String getIdMessageStatus() {
    return activity.get().getString(R.string.find_customer);
  }

  @Override
  protected String getIdMessageFooter() {
    return "";
  }

}
