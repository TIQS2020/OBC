package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.IOException;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.util.UtilHelper;

@Root(name = "CONSULTACLIENTES")
public class XmlConsultaCliente extends XmlBase {

  //  private static final String NODE_RECUPERACLIENTES = "CONSULTACLIENTES";
  private static XmlConsultaCliente _self;

  @Element(name = "GUID", required = false)
  private String guid;
  @Element(name = "CODIGOFILIAL", required = false)
  private String cdFilial;
  @Element(name = "DATAVIAGEM", required = false)
  private String dataViagem;
  @Element(name = "NUMVIAGEM", required = false)
  private String numeroViagem;
  @Element(name = "TIPOVIAGEM", required = false)
  private String tipoViagem;
  @Element(name = "CODIGOCLIENTE", required = false)
  private String cdCustomer;
  @Element(name = "IMEI", required = false)
  private String imei;

  public static XmlConsultaCliente newInstance() {
    return new XmlConsultaCliente();
  }

  public static XmlConsultaCliente self() {

    if (_self == null)
      _self = new XmlConsultaCliente();

    return _self;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
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

  public String getTipoViagem() {
    return tipoViagem;
  }

  public void setTipoViagem(String tipoViagem) {
    this.tipoViagem = tipoViagem;
  }

  public String getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(String cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public String getXml(Long cdCustomer) {
    //guid = UUID.randomUUID().toString();
    cdFilial = GLOBAL.self().getRoute().getCdFilialJde();
    numeroViagem = GLOBAL.self().getRoute().getNumeroViagem().toString();
    tipoViagem = GLOBAL.self().getRoute().getTipoCargaVeiculo().toString();
    dataViagem = UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
      ConstantsEnum.yyyyMMdd.getValue());
    this.cdCustomer = cdCustomer.toString();
    imei = GLOBAL.self().getImei();

//    String xml = createXml();
    try {
      saveFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return serialize();
  }


}
