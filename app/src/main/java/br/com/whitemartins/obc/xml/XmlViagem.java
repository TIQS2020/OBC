package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "viagem")
public class XmlViagem {

  public static final Long serialVersionUID = 1L;

  @Element(name = "numeroViagemCorrente", required = false)
  private Long numeroViagemCorrente;

  @Element(name = "dataViagemCorrente", required = false)
  private String dataViagemCorrente;

  @Element(name = "numeroViagemPrincipal", required = false)
  private Long numeroViagemPrincipal;

  @Element(name = "dataViagemPrincipal", required = false)
  private String dataViagemPricipal;

  public static XmlViagem newInstance() {
    return new XmlViagem();
  }

  public Long getNumeroViagemCorrente() {
    return numeroViagemCorrente;
  }

  public void setNumeroViagemCorrente(Long numeroViagemCorrente) {
    this.numeroViagemCorrente = numeroViagemCorrente;
  }

  public String getDataViagemCorrente() {
    return dataViagemCorrente;
  }

  public void setDataViagemCorrente(String dataViagemCorrente) {
    this.dataViagemCorrente = dataViagemCorrente;
  }

  public Long getNumeroViagemPrincipal() {
    return numeroViagemPrincipal;
  }

  public void setNumeroViagemPrincipal(Long numeroViagemPrincipal) {
    this.numeroViagemPrincipal = numeroViagemPrincipal;
  }

  public String getDataViagemPricipal() {
    return dataViagemPricipal;
  }

  public void setDataViagemPricipal(String dataViagemPricipal) {
    this.dataViagemPricipal = dataViagemPricipal;
  }
}
