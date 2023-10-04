package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "num_serie_cil_pp")
public class NumeroSerieCilPp {

  @Element(name = "num_serie_cil_pp", required = false)
  private String numeroSerie;

  public String getNumeroSerie() {
    return numeroSerie;
  }

  public void setNumeroSerie(String numeroSerie) {
    this.numeroSerie = numeroSerie;
  }
}
