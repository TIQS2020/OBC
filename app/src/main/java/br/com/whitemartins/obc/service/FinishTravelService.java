package br.com.whitemartins.obc.service;

import android.app.Activity;

import java.lang.ref.WeakReference;

import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.xml.XmlConsultaFimViagem;
import br.com.whitemartins.obc.xml.XmlFimViagem;
import br.com.whitemartins.obc.xml.XmlFimViagemRetorno;
import br.com.whitemartins.obc.xml.XmlRetorno;

public class FinishTravelService extends BaseService {

  private XmlFimViagem xmlFimViagem;
  private XmlFimViagemRetorno xmlFimViagemRetorno = XmlFimViagemRetorno.newInstance();
  private XmlConsultaFimViagem xmlConsultaFimViagem = XmlConsultaFimViagem.newInstance();

  private Integer step = StepEmissaoType.ENVIAR.getValue();

  private MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback;

  public FinishTravelService setFinishExecuteCallback(MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public FinishTravelService setStep(Integer step) {
    this.step = step;
    return this;
  }

  public FinishTravelService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }

  public FinishTravelService setXmlFimViagem(XmlFimViagem xmlFimViagem) {
    this.xmlFimViagem = xmlFimViagem;
    return this;
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.FIM_VIAGEM;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.FIM_VIAGEM_CONSULTA;
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
    if (!XmlRetorno.self().getConteudoConsulta().isEmpty()) {

      xmlFimViagemRetorno = (XmlFimViagemRetorno) xmlFimViagemRetorno
        .read(XmlRetorno.self().getConteudoConsulta());
      xmlFimViagemRetorno.saveFile();

      if (xmlFimViagemRetorno.getStatus().equalsIgnoreCase(ConstantsEnum.NO.getValue())) {
        LogHelper.self().info(xmlFimViagemRetorno.getDescricao());
        return false;
      } else if (xmlFimViagemRetorno.getStatus().equalsIgnoreCase(ConstantsEnum.E.getValue())) {
        doPostException(new Exception(xmlFimViagemRetorno.getDescricao()));
        return true;
      }

      return true;
    }

    return false;
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = false;

    try {
      if (step.equals(StepEmissaoType.ENVIAR.getValue()))
        r = send(xmlFimViagem.serialize());
      else
        r = consult(xmlConsultaFimViagem.serialize());
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
    }

    return r;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (finishExecuteCallback != null)
      finishExecuteCallback.execute(success);
  }
}
