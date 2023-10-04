package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

@Root(name = "OBCFimViagemConsultaResponse")
public class XmlFimViagemRetorno extends XmlBase {

  @Element(name = "status", required = false)
  private String status;

  @Element(name = "descricao", required = false)
  private String descricao;

  public static XmlFimViagemRetorno newInstance() {
    return new XmlFimViagemRetorno();
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
