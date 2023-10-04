package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ativacao")
public class XmlAtivacao extends XmlBase {

  @Element(name = "semente", required = false)
  private String semente;

  @Element(name = "dataHoraMediador", required = false)
  private XmlDataMediador XmlDataMediador;

  public static XmlAtivacao newInstance() {
    return new XmlAtivacao();
  }

  public String getSemente() {
    return semente;
  }

  public void setSemente(String semente) {
    this.semente = semente;
  }

  public XmlDataMediador getXmlDataMediador() {
    return XmlDataMediador;
  }

  public void setXmlDataMediador(XmlDataMediador XmlDataMediador) {
    this.XmlDataMediador = XmlDataMediador;
  }
}
