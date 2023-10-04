package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.util.UtilHelper;

@Root(name = "NFe")
public class XmlSincronismo extends XmlBase {

  @Element(name = "cd_filial", required = false)
  private String cdFilial;
  @Element(name = "dt_viagem", required = false)
  private String dataViagem;
  @Element(name = "num_viagem", required = false)
  private String numeroViagem;
  @Element(name = "so_dispositivo", required = false)
  private String plataforma;
  @Element(name = "versao", required = false)
  private String versao;

  public static XmlSincronismo newInstance() {
    return new XmlSincronismo();
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

  public String getPlataforma() {
    return plataforma;
  }

  public void setPlataforma(String plataforma) {
    this.plataforma = plataforma;
  }

  public String getVersao() {
    return versao;
  }

  public void setVersao(String versao) {
    this.versao = versao;
  }

  @Override
  public String serialize() {

    cdFilial = GLOBAL.self().getRoute().getCdFilialJde();
    numeroViagem = GLOBAL.self().getRoute().getNumeroViagem().toString();
    dataViagem = UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
      ConstantsEnum.yyyyMMdd.getValue());
    plataforma = GLOBAL.self().getPlataforma();
    versao = GLOBAL.self().getVersao();

    return super.serialize();
  }
}
