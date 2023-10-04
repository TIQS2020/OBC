package br.com.whitemartins.obc.service;

import android.app.Activity;

import java.lang.ref.WeakReference;

import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.xml.XmlRecuperaClienteRetorno;


public class RecoveryClientService extends BaseService {

  private final String TAG = "RecoveryClientService";
  XmlRecuperaClienteRetorno xmlRecuperaClienteRetorno = XmlRecuperaClienteRetorno.newInstance();
  private Integer step = 0;
  private String xmlSend = "";
  private String xmlConsult = "";
  private MyCallbackInterface.CallbackXmlRetornoClienteInterface finishExecuteCallback;

  public RecoveryClientService setStep(Integer step) {
    this.step = step;
    return this;
  }

  public RecoveryClientService setFinishExecuteCallback(MyCallbackInterface.CallbackXmlRetornoClienteInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public RecoveryClientService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }

  public RecoveryClientService setXmlSend(String xmlSend) {
    this.xmlSend = xmlSend;
    return this;
  }

  public RecoveryClientService setXmlConsult(String xmlConsult) {
    this.xmlConsult = xmlConsult;
    return this;
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = false;

    try {
      if (step.equals(StepEmissaoType.ENVIAR.getValue()))
        r = send(xmlSend);
      else if (step.equals(StepEmissaoType.CONSULTAR.getValue()))
        r = consult(xmlConsult);

    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
    }

    return r;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (finishExecuteCallback != null)
      finishExecuteCallback.execute(success, xmlRecuperaClienteRetorno);
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.RECUPERAR_CLIENTES;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.RECUPERAR_CLIENTES_CONSULTA;
  }

  @Override
  protected boolean doPostSend() {
    return true;
  }

  @Override
  protected void showExceptionMessage() {

  }

  @Override
  protected boolean doPostConsult(String xml) throws Exception {
    xmlRecuperaClienteRetorno = (XmlRecuperaClienteRetorno) xmlRecuperaClienteRetorno.parse(xml);
    xmlRecuperaClienteRetorno.saveFile(xml);

    return !ConstantsEnum.NO.getValue().equalsIgnoreCase(xmlRecuperaClienteRetorno.getStatus());
  }
}
