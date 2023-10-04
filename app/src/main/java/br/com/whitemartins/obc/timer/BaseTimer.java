package br.com.whitemartins.obc.timer;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.model.Invoice;

public abstract class BaseTimer extends CountDownTimer {

  protected String TAG = this.getClass().getSimpleName();

  protected Chronometer chrono;
  protected WeakReference<Activity> activity;
  protected TextView txtStatusProgressDialog;
  Integer step = StepEmissaoType.ENVIAR.getValue();
  boolean finalizadoSucesso = false;
  AlertDialog sendDialog;

  boolean running;

  BaseTimer(Activity activity, long startTime, long interval) {
    super(startTime, interval);

    running = false;
    this.activity = new WeakReference<>(activity);

    createDialog(activity);
  }

  private void createDialog(Activity activity) {
    sendDialog = createSendXmlDialog(activity);

    if (sendDialog != null)
      sendDialog.show();
  }

  void dismissDialog() {
    if (sendDialog != null)
      sendDialog.dismiss();
  }

  //Fim da execução do relogio
  protected abstract void finishTickCallback(Boolean sucesso);

  //Execução do tic tac do relogio
  protected abstract void tickCallback(Long ml);

  protected abstract String getIdMessageHeader();

  protected abstract String getIdMessageStatus();

  protected abstract String getIdMessageFooter();

  void updateMessageStatus() {
    txtStatusProgressDialog.setText(getIdMessageStatus());
  }


  private AlertDialog createSendXmlDialog(Activity activity) {
    if (activity == null)
      return null;
    else {

      final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);

      View viewInflated = LayoutInflater.from(activity)
        .inflate(R.layout.activity_send_progress_dialog, null, false);

      chrono = viewInflated.findViewById(R.id.chrono);

      TextView txtCabecalhoProgressDialog = viewInflated.findViewById(R.id.txtCabecalhoProgressDialog);
      txtCabecalhoProgressDialog.setText(getIdMessageHeader());

      txtStatusProgressDialog = viewInflated.findViewById(R.id.txtStatusProgressDialog);
      txtStatusProgressDialog.setText(getIdMessageStatus());

      TextView txtRodapeProgressDialog = viewInflated.findViewById(R.id.txtRodapeProgressDialog);
      txtRodapeProgressDialog.setVisibility(View.INVISIBLE);
      txtRodapeProgressDialog.setText(getIdMessageFooter());

      dialogBuilder.setView(viewInflated);
      dialogBuilder.setCancelable(false);
      return dialogBuilder.create();
    }
  }

  @Override
  public void onTick(long ml) {
    tickCallback(ml);
  }

  public BaseTimer setInvoice(Invoice invoice) {
    return this;
  }

  @Override
  public void onFinish() {
    running = false;
    finishTickCallback(finalizadoSucesso);
  }
}
