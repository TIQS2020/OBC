package br.com.whitemartins.obc.service;

import android.app.Activity;

import java.io.IOException;
import java.lang.ref.WeakReference;

import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.SeedHelper;

public class ValidateDeviceService extends BaseService {
  final String HTTP_URL_SEED = HOST + "api/service/valida/semente/%s"; //{imei}

  private MyCallbackInterface.CallbackStringInterface finishExecuteCallback;

  public ValidateDeviceService() {
    //Mudando a url padrão para a de validação da semente
    HTTP_URL_SERVICE = HTTP_URL_SEED;
  }

  public ValidateDeviceService setFinishExecuteCallback(MyCallbackInterface.CallbackStringInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public ValidateDeviceService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = false;

    try {
      r = send(SeedHelper.getSeed());
    } catch (Exception throwable) {
      throwable.printStackTrace();
    }

    return r;
  }

  @Override
  protected void writeOnHeader(String token, ActionType actionType) {
    connection.setDoInput(true);
    connection.setDoOutput(true);
    connection.setRequestProperty("semente", SeedHelper.getSeed());
    connection.setRequestProperty("Content-Type", HTTP_CONTENT_TYPE);
    connection.setRequestProperty("operacao", actionType.getLineName());
  }

  @Override
  protected void writeOnBody(String value) throws IOException {
    //Sobre escrito para que não escreva no body da requisição
  }

  @Override
  protected String getProgressMsg2() {
    LogHelper.self().info(TAG, "Validando Dispositivo...");
    return "Validando Dispositivo...";
  }

  @Override
  protected String getProgressMsg3() {
    LogHelper.self().info(TAG, "Dispositivo validado.");
    return "Dispositivo validado.";
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.VALIDA_SEMENTE;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.VALIDA_SEMENTE;
  }

  @Override
  protected boolean doPostConsult(String is) {
    return true;
  }

  @Override
  protected boolean doPostSend() throws Exception {
    return true;
  }

  @Override
  protected void showExceptionMessage() {

  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (success) {
      if (finishExecuteCallback != null)
        finishExecuteCallback.execute("");
    } else {
      if (exception != null)
        if (finishExecuteCallback != null)
          finishExecuteCallback.execute(exception.getMessage());
    }
  }
}
