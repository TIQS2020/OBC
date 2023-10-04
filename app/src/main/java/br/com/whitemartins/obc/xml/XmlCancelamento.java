package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.util.UtilHelper;

@Root(name = "NFe")
public class XmlCancelamento extends XmlBase {

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
  @Element(name = "cod_motivo_canc", required = false)
  private String cdMotivo;

  public static XmlCancelamento newInstance() {
    return new XmlCancelamento();
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

  public String getCdMotivo() {
    return cdMotivo;
  }

  public void setCdMotivo(String cdMotivo) {
    this.cdMotivo = cdMotivo;
  }

  public String getXml(Invoice invoice) {
    setCdFilial(GLOBAL.self().getRoute().getCdFilialJde());
    setNumeroViagem(GLOBAL.self().getRoute().getNumeroViagem().toString());
    setDataViagem(UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
      ConstantsEnum.yyyyMMdd.getValue()));
    setNumeroNota(invoice.getNumero().toString());
    setSerieNota(invoice.getSerie().toString());
    setCdMotivo(invoice.getCdMotivo() + " - " + invoice.getDsMotivo());

    return serialize();
  }
}
