package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "dataHoraMediador")
public class XmlDataMediador extends XmlBase {

  @Element(name = "data", required = false)
  private String dataHora;
  @Element(name = "timeShiftSegundos", required = false)
  private Long timeShiftSegundos;

  public static XmlDataMediador newInstance() {
    return new XmlDataMediador();
  }

  public String getDataHora() {
    return dataHora;
  }

  public void setDataHora(String dataHora) {
    this.dataHora = dataHora;
  }

  public Long getTimeShiftSegundos() {
    return timeShiftSegundos;
  }

  public void setTimeShiftSegundos(Long timeShiftSegundos) {
    this.timeShiftSegundos = timeShiftSegundos;
  }
}
