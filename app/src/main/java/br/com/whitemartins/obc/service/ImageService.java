package br.com.whitemartins.obc.service;

import java.io.File;
import java.io.IOException;

import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.util.ImageHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConsultaCec;
import br.com.whitemartins.obc.xml.XmlConsultaCecRetorno;
import br.com.whitemartins.obc.xml.XmlEnviaCec;

public class ImageService extends BaseService {

  private InvoiceImage invoiceImage;
  private XmlEnviaCec xmlEnviaCec;
  private XmlConsultaCec xmlConsultaCec;
  private XmlConsultaCecRetorno xmlConsultaCecRetorno;


  private Invoice invoice;
  private MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback;

  public ImageService() {
    xmlEnviaCec = XmlEnviaCec.newInstance();
    xmlConsultaCec = XmlConsultaCec.newInstance();
    xmlConsultaCecRetorno = new XmlConsultaCecRetorno();
  }

  public ImageService setFinishExecuteCallback(MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public ImageService setInvoiceImage(InvoiceImage invoiceImage) {
    this.invoiceImage = invoiceImage;
    invoice = DatabaseApp.self().getDatabase().invoiceDao().findById(invoiceImage.getIdNota());

    File cec = new File(UtilHelper.getCecFileName(invoice));
    File sign = new File(UtilHelper.getSignFileName(invoice));

    if (cec.exists() && invoiceImage.getCec() == null)
      invoiceImage.setCec(ImageHelper.self().encodeBitmapFromByteArray(cec));

    if (sign.exists() && invoiceImage.getAssinatura() == null)
      invoiceImage.setAssinatura(ImageHelper.self().encodeBitmapFromByteArray(sign));

    invoiceImage.save();


    xmlEnviaCec.setCdFilial(GLOBAL.self().getRoute().getCdFilialJde());
    xmlEnviaCec.setDataViagem(invoice.getDataViagem());
    xmlEnviaCec.setNumeroViagem(invoice.getNumeroViagem());
    xmlEnviaCec.setNumeroNota(invoice.getNumero());
    xmlEnviaCec.setDataEmissao(UtilHelper.formatDateStr(invoice.getDataEmissao(),
        ConstantsEnum.yyyyMMdd.getValue()));
    xmlEnviaCec.setNome(invoice.getNomeAssinadorCec());
    xmlEnviaCec.setDocumento(invoice.getRgAssinadorCec());
    xmlEnviaCec.setTipoDocumento("C" + invoice.getTipoNota());
    xmlEnviaCec.setSerieNota(invoice.getSerie());
    xmlEnviaCec.setCec(invoiceImage.getCec());
    xmlEnviaCec.setAssinatura(invoiceImage.getAssinatura());

    xmlConsultaCec.setCdFilial(GLOBAL.self().getRoute().getCdFilialJde());
    xmlConsultaCec.setDataViagem(invoice.getDataViagem());
    xmlConsultaCec.setNumeroViagem(invoice.getNumeroViagem());
    xmlConsultaCec.setNumeroNota(invoice.getNumero());
    xmlConsultaCec.setDataEmissao(UtilHelper.formatDateStr(invoice.getDataEmissao(),
        ConstantsEnum.yyyyMMdd.getValue()));
    xmlConsultaCec.setIndicador(0);
    xmlConsultaCec.setTipoDocumento("C" + invoice.getTipoNota());
    xmlConsultaCec.setSerieNota(invoice.getSerie());

    try {
      xmlEnviaCec.saveFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return this;
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.GRAVA_CEC;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.GRAVA_CEC_CONSULTA;
  }

  @Override
  protected boolean doPostSend() {
    invoiceImage.setStatus(StatusNFeType.PROCESSANDO.getValue());
    invoiceImage.save();
    return true;
  }

  @Override
  protected boolean doPostConsult(String xml) throws Exception {
    xmlConsultaCecRetorno = (XmlConsultaCecRetorno) xmlConsultaCecRetorno.read(xml);
    xmlConsultaCecRetorno.saveFile(xml);

    boolean result = true;

    if (ConstantsEnum.YES.getValue().equals(xmlConsultaCecRetorno.getStatusRetorno()))
      invoiceImage.setStatus(StatusNFeType.IMAGEM_ENVIADA.getValue());
    else //{
//      invoiceImage.setStatus(StatusNFeType.PROCE.getValue());
      result = false;
//    }

    invoiceImage.save();
    LogHelper.self().info(TAG, "Imagem salva no banco: " + invoiceImage.toString());

    return result;
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = true;

    if (xmlEnviaCec.getAssinatura() == null || xmlEnviaCec.getAssinatura().isEmpty()) {
      return false;
    }

    if (invoiceImage.getStatus().equals(StatusNFeType.PENDENTE_ENVIO.getValue()))
      r = send(xmlEnviaCec.serialize());

    if (r) {
      r = consult(xmlConsultaCec.serialize());
    }

    return r;
  }

  @Override
  protected void showExceptionMessage() {

  }

  @Override
  protected void onPostExecute(Boolean success) {

    if (finishExecuteCallback != null)
      finishExecuteCallback.execute(success);
  }
}
