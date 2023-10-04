package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import br.com.whitemartins.obc.enumeration.ConsultType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.util.PathHelper;

@Root(name = "NFe")
public class XmlConsultaNota extends XmlBase {

  private static final String NODE_CABECALHO_NFE = "NFe";

  @Element(name = "tipo_consulta", required = false)
  private String tipoConsulta;
  @Element(name = "cd_filial", required = false)
  private String cdFilial;
  @Element(name = "dt_viagem", required = false)
  private String dataViagem;
  @Element(name = "num_viagem", required = false)
  private String numeroViagem;
  @Element(name = "num_nfe", required = false)
  private String numeroNota;
  @Element(name = "serie_nfe", required = false)
  private String serieNota;
  @Element(name = "tipo_operacao", required = false)
  private String tipoOperacao;
  @Element(name = "imei", required = false)
  private String imei;

  public static XmlConsultaNota newInstance() {
    return new XmlConsultaNota();
  }

  public String getTipoConsulta() {
    return tipoConsulta;
  }

  public void setTipoConsulta(String tipoConsulta) {
    this.tipoConsulta = tipoConsulta;
  }

  public String getCdFilial() {
    return cdFilial;
  }

  public void setCdFilial(String cdFilial) {
    this.cdFilial = cdFilial;
  }

  public String getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(String dataViagem) {
    this.dataViagem = dataViagem;
  }

  public String getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(String numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public String getNumeroNota() {
    return numeroNota;
  }

  public void setNumeroNota(String numeroNota) {
    this.numeroNota = numeroNota;
  }

  public String getSerieNota() {
    return serieNota;
  }

  public void setSerieNota(String serieNota) {
    this.serieNota = serieNota;
  }

  public String getTipoOperacao() {
    return tipoOperacao;
  }

  public void setTipoOperacao(String tipoOperacao) {
    this.tipoOperacao = tipoOperacao;
  }

  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public String getXml(Invoice invoice, ConsultType consultType) {

    setTipoConsulta(consultType.getValue());
    setCdFilial(GLOBAL.self().getRoute().getCdFilialJde());
    setNumeroViagem(invoice.getNumeroViagem());
    setDataViagem(invoice.getDataViagem());
    setNumeroNota(invoice.getNumero().toString());
    setSerieNota(invoice.getSerie().toString());
    setTipoOperacao(invoice.getTipoNota());
    setImei(GLOBAL.self().getImei());

    return serialize();
  }

  @Override
  public void saveFile(String input) throws IOException {
    FileOutputStream outputStream = null;
    File outputFile;
    try {
      File dir = new File(PathHelper.self().getFilePathDownload());
      outputFile = new File(dir, getClass().getSimpleName() + "_" + numeroNota + "_" + serieNota + ".xml");
      outputStream = new FileOutputStream(outputFile);
      outputStream.write(input.getBytes());

    } finally {
      if (outputStream != null) {
        outputStream.flush();
        outputStream.close();
      }
    }
  }
}
