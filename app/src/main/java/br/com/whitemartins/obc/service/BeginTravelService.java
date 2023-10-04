package br.com.whitemartins.obc.service;

import android.app.Activity;

import java.lang.ref.WeakReference;

import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.BeginTravelType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.xml.XmlInicioViagem;
import br.com.whitemartins.obc.xml.XmlInicioViagemRetorno;
import br.com.whitemartins.obc.xml.XmlRetorno;

public class BeginTravelService extends BaseService {

  private XmlInicioViagem xmlInicioViagem = XmlInicioViagem.newInstance();
  private XmlInicioViagemRetorno xmlInicioViagemRetorno = XmlInicioViagemRetorno.newInstance();

  private MyCallbackInterface.CallbackBeginTravelInterface finishExecuteCallback;

  public BeginTravelService setFinishExecuteCallback(MyCallbackInterface.CallbackBeginTravelInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public BeginTravelService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = false;

    try {
      r = send(xmlInicioViagem.serialize());
    } catch (Exception throwable) {
      doPostException(throwable);
      throwable.printStackTrace();
    }

    return r;
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.INICIO_VIAGEM;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.INICIO_VIAGEM;
  }

  @Override
  protected boolean doPostConsult(String is) {
    return true;
  }

  @Override
  protected void showExceptionMessage() {

  }

  @Override
  protected boolean doPostSend() throws Exception {

    try {
      if (!XmlRetorno.self().getConteudoConsulta().isEmpty()) {
        xmlInicioViagemRetorno = (XmlInicioViagemRetorno) xmlInicioViagemRetorno
            .read(XmlRetorno.self().getConteudoConsulta());

        xmlInicioViagemRetorno.saveFile();

        if (!xmlInicioViagemRetorno.getStatus().equalsIgnoreCase(BeginTravelType.SUCESSO.getValue())) {
          doPostException(new Exception(xmlInicioViagemRetorno.getDescricao()));
          return false;
        }

        return true;
      } else
        return true;
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
    }
    return false;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    setTextStatus("");

    if (finishExecuteCallback != null)
      finishExecuteCallback.execute(BeginTravelType.getByValue(xmlInicioViagemRetorno.getStatus()));

//    if (success) {
//      if (finishExecuteCallback != null)
//        finishExecuteCallback.execute(xmlInicioViagemRetorno);
//    } else if (finishExecuteCallback != null)
//      finishExecuteCallback.execute();
  }
}
