package br.com.whitemartins.obc.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import br.com.whitemartins.obc.BuildConfig;
import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.CecType;
import br.com.whitemartins.obc.enumeration.ConsultType;
import br.com.whitemartins.obc.enumeration.SevereErrorsType;
import br.com.whitemartins.obc.enumeration.StatusCecType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.FileHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConsultaNota;

public class SendInvoiceService extends BaseService {

  protected Invoice invoice;
  protected MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback;

  public SendInvoiceService setFinishExecuteCallback(MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public SendInvoiceService setInvoice(Invoice invoice) {
    this.invoice = invoice;
    return this;
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.ENVIAR_NOTA;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.CONSULTAR_NOTA;
  }

  @Override
  protected boolean doPostSend() {
    invoice.setStatus(StatusNFeType.PROCESSANDO.getValue());
    invoice.save();

    return true;
  }

  @Override
  protected void showExceptionMessage() {

  }

  @Override
  protected boolean doPostConsult(String xml) throws Exception {
    FileHelper.saveFile(xml, UtilHelper.getRetornoConsultaFileName(invoice));
    InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
    invoice.parseXML(is);

    //Despreza a chave para notas rejeitadas
    if (!invoice.getStatus().equals(StatusNFeType.AUTORIZADA.getValue())) {
      invoice.setChave("");

      if (StatusNFeType.isFinalStatus(invoice.getStatus())) {
        invoice.setProtocolo("NFe. " + StatusNFeType.getNameByValue(invoice.getStatus()));
      }
    }

    SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());
    CecType cecType = GLOBAL.self().getCecDanfe(operation, false);
    StatusCecType statusCecType = StatusCecType.CEC_ON;

    if (Integer.parseInt(cecType.getValue()) >= 3)
      statusCecType = StatusCecType.DANFE_ON;

    invoice.setStatusCec(statusCecType.getValue());

    //Coloca em processamento caso o status seja 99 (Status Invalido)
    if (invoice.getStatus().equals(StatusNFeType.STATUS_INVALIDO.getValue()))
      invoice.setStatus(StatusNFeType.PROCESSANDO.getValue());

    //Volta pra pendente de envio caso erro ao consumir da fila
    if (SevereErrorsType.COMSUMIDA_ERRO.getValue().equals(invoice.getStatusGravacaoJde())
        || SevereErrorsType.NAO_CONSUMIDA.getValue().equals(invoice.getStatusGravacaoJde())) {
      invoice.setMensagemGravacaoJde("");
      invoice.setStatus(StatusNFeType.PENDENTE_ENVIO.getValue());
    }

    if (invoice.getStatusNfeImp().isEmpty()) {
      if (invoice.getStatus().equals(StatusNFeType.AUTORIZADA.getValue()))
        invoice.setStatusNfeImp(statusCecType.getValue() + statusCecType.getTypeName());
      else if (StatusNFeType.isFinalStatus(invoice.getStatus()))
        invoice.setStatusNfeImp(statusCecType.getValue() + invoice.getProtocolo());
    }

    //TODO: Retirar essa linha
    if (BuildConfig.DEBUG) {
      invoice.setStatus(StatusNFeType.PENDENTE_ENVIO.getValue());
    }

    invoice.save();

    return validarStatus();
  }

  protected boolean validarStatus() {
    if (invoice.isFinalStatus() || SevereErrorsType.isSevereStatus(invoice.getStatusGravacaoJde())) {
      LogHelper.self().info(TAG, "Salvando nota fiscal: " + invoice.toString());
      return true;
    } else
      return false;
  }

  protected String getRightSendXml() {
    return InvoiceHelper.self().readXml(invoice);
  }

  protected String getRightConsultXml() {
    return XmlConsultaNota.newInstance().getXml(invoice, ConsultType.EMISSAO);
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = true;

    try {
      if (invoice.getStatus().equals(StatusNFeType.PROCESSANDO.getValue()))
        r = consult(getRightConsultXml());
      else
        r = send(getRightSendXml());

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
