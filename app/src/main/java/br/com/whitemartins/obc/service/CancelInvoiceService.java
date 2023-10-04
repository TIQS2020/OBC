package br.com.whitemartins.obc.service;

import android.app.Activity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;

import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.ConsultType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.FileHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlCancelamento;
import br.com.whitemartins.obc.xml.XmlConsultaNota;

public class CancelInvoiceService extends SendInvoiceService {

  private MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback;

  private XmlCancelamento xmlCancelamento;

  public CancelInvoiceService() {
    super();
    xmlCancelamento = XmlCancelamento.newInstance();
  }

  public CancelInvoiceService setFinishExecuteCallback(MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public CancelInvoiceService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.CANCELAR_NOTA;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.CONSULTAR_CANCELAMENTO;
  }

  @Override
  protected void showExceptionMessage() {

  }

  @Override
  protected boolean doPostConsult(String xml) throws Exception {
    FileHelper.saveFile(xml, UtilHelper.getCancelFileName(invoice));
    InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
    invoice.parseXML(is);
    invoice.save();

//    if ((StatusNFeType.AUTORIZADA.getValue().equals(invoice.getStatus())
//      && invoice.getTipoMovimentoIntegracao().equals(MovimentoIntegracaoType.EVENTO_CANCELAMENTO.getValue()))) {
    if (invoice.isCanceled()) {
      InvoiceHelper.self().cancel(invoice);
      LogHelper.self().info(TAG, "Cancelando nota fiscal: " + invoice.toString());
      return true;
    } else if (invoice.isFinalStatus()) {
      LogHelper.self().info(TAG, "Nota não cancelada" + invoice.toString());
      return true;

    } else
      return false;
  }

  @Override
  protected String getRightSendXml() {
    return xmlCancelamento.getXml(invoice);
  }

  @Override
  protected String getRightConsultXml() {
    return XmlConsultaNota.newInstance().getXml(invoice, ConsultType.CANCELAMENTO);
  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (finishExecuteCallback != null)
      finishExecuteCallback.execute(success);
  }
}
