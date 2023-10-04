package br.com.whitemartins.obc.timer;

import android.app.Activity;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.service.CancelInvoiceService;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class CancelInvoiceTimer extends BaseTimer {
  private Invoice invoice;
  private MyCallbackInterface.CallbackVoidInterface finishProcessCallback;

  private MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback =
    new MyCallbackInterface.CallbackBooleanInterface() {

      @Override
      public void execute(Boolean success) {
        running = false;
        finalizadoSucesso = success;

        if (success)
          step++;

        if (step > StepEmissaoType.CONSULTAR.getValue()) {
          running = false;
          CancelInvoiceTimer.this.cancel();
          CancelInvoiceTimer.this.onFinish();
        }
      }
    };

  public CancelInvoiceTimer(Activity activity, long startTime, long interval) {
    super(activity, startTime, interval);
  }

  @Override
  protected String getIdMessageHeader() {
    return activity.get().getString(R.string.cancel_header_message);
  }

  @Override
  protected String getIdMessageStatus() {
    return "";
  }

  @Override
  protected String getIdMessageFooter() {
    return "";
  }

  @Override
  protected void finishTickCallback(Boolean sucesso) {
    if (finishProcessCallback != null)
      finishProcessCallback.execute();

    dismissDialog();

    //    if (!sucesso)
//      DialogHelper.showQuestionMessage(activity.get(),
//        activity.get().getString(R.string.confirmar_text),
//        String.format(activity.get().getString(R.string.msg_nova_tentativa_invoice), "CEC"),
//        new DialogInterface.OnClickListener() {
//          @Override
//          public void onClick(DialogInterface dialogInterface, int i) {
//            step = StepEmissaoType.ENVIAR.getValue();
//            running = false;
//            CancelInvoiceTimer.this.start();
//          }
//        }, new DialogInterface.OnClickListener() {
//          @Override
//          public void onClick(DialogInterface dialogInterface, int i) {
//            dismissDialog();
//          }
//        });
//    else {

//    }
  }

  @Override
  protected void tickCallback(Long ml) {
    String hms = UtilHelper.formatCounterTimeText(ml);

    chrono.setText(hms);

    try {
      if (!running) {
        running = true;

        if (step.equals(StepEmissaoType.ENVIAR.getValue())) {
          txtStatusProgressDialog.setText(String.format(activity.get().getString(R.string.status),
            activity.get().getString(R.string.cancel_invoice)));

          new CancelInvoiceService()
            .setActivity(activity.get())
            .setInvoice(invoice)
            .setFinishExecuteCallback(finishExecuteCallback)
            .execute();

        } else if (step.equals(StepEmissaoType.CONSULTAR.getValue())) {
          txtStatusProgressDialog.setText(String.format(activity.get().getString(R.string.status),
            ActionType.CONSULTAR_CANCELAMENTO.getName()));

          new CancelInvoiceService()
            .setActivity(activity.get())
            .setInvoice(invoice)
            .setFinishExecuteCallback(finishExecuteCallback)
            .execute();
        }
      }
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
    }
  }

  public CancelInvoiceTimer setInvoice(Invoice invoice) {
    this.invoice = invoice;
    return this;
  }

  public CancelInvoiceTimer setFinishProcessCallback(MyCallbackInterface.CallbackVoidInterface finishProcessCallback) {
    this.finishProcessCallback = finishProcessCallback;
    return this;
  }
}
