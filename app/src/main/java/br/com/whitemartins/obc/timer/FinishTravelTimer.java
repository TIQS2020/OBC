package br.com.whitemartins.obc.timer;

import android.app.Activity;
import android.content.DialogInterface;

import java.io.File;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.service.FinishTravelService;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.PathHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlFimViagem;

public class FinishTravelTimer extends BaseTimer {

  private XmlFimViagem XmlFimViagem;
  private MyCallbackInterface.CallbackBooleanInterface notifyCallback;

  private MyCallbackInterface.CallbackBooleanInterface finishExecuteServiceCallback =
      new MyCallbackInterface.CallbackBooleanInterface() {

        @Override
        public void execute(Boolean success) {
          running = false;
          finalizadoSucesso = success;

          if (success)
            step++;

          if (step > StepEmissaoType.CONSULTAR.getValue()) {
            running = false;

            finalizadoSucesso = success;

            if (finalizadoSucesso) {
              FinishTravelTimer.this.cancel();
              FinishTravelTimer.this.onFinish();
            }
          }
        }
      };

  public FinishTravelTimer(Activity activity, long startTime, long interval) {
    super(activity, startTime, interval);

    //Deletando lixo do diretório
    File dir = new File(PathHelper.self().getFilePathDownload());
    File[] files = dir.listFiles();
    if (files != null)
      for (File file : files)
        file.delete();
  }

  public FinishTravelTimer setStep(Integer step) {
    this.step = step;
    return this;
  }

  public FinishTravelTimer setNotifyCallback(MyCallbackInterface.CallbackBooleanInterface notifyCallback) {
    this.notifyCallback = notifyCallback;
    return this;
  }

  public FinishTravelTimer setXmlFimViagem(XmlFimViagem xmlFimViagem) {
    this.XmlFimViagem = xmlFimViagem;
    return this;
  }

  @Override
  protected void finishTickCallback(Boolean sucesso) {
    if (sucesso) {
      if (notifyCallback != null)
        notifyCallback.execute(sucesso);
    } else {
      DialogHelper.showQuestionMessage(activity.get(),
          R.string.confirmar_text, R.string.msg_nova_tentativa_fim,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

              step = StepEmissaoType.ENVIAR.getValue();
              running = false;
              FinishTravelTimer.this.start();
            }
          }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              dismissDialog();
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

          txtStatusProgressDialog.setText(String.format(activity.get().getString(R.string.status),
              ActionType.FIM_VIAGEM.getName()));

          new FinishTravelService()
              .setActivity(activity.get())
              .setXmlFimViagem(XmlFimViagem)
              .setStep(step)
              .setFinishExecuteCallback(finishExecuteServiceCallback)
              .execute();

        } else if (step.equals(StepEmissaoType.CONSULTAR.getValue())) {

          txtStatusProgressDialog.setText(String.format(activity.get().getString(R.string.status),
              ActionType.FIM_VIAGEM_CONSULTA.getName()));

          new FinishTravelService()
              .setActivity(activity.get())
              .setStep(step)
              .setXmlFimViagem(XmlFimViagem)
              .setFinishExecuteCallback(finishExecuteServiceCallback)
              .execute();
        }
      }
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
    }
  }

  @Override
  protected String getIdMessageHeader() {
    return activity.get().getString(R.string.finish_travel_header);
  }

  @Override
  protected String getIdMessageStatus() {
    return activity.get().getString(R.string.finish_travel_status);
  }

  @Override
  protected String getIdMessageFooter() {
    return activity.get().getString(R.string.finish_travel_footer);
  }
}
