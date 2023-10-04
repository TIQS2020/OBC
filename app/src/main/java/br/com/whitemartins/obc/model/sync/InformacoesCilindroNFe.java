package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;


@Root(name = "inf_cil_pp")
public class InformacoesCilindroNFe {

  @ElementList(name = "num_serie_cil_pp", required = false, inline = true)
  private List<NumeroSerieCilPp> numeroSerieCilPps;

  public InformacoesCilindroNFe() {
    numeroSerieCilPps = new ArrayList<>();
  }

  public List<NumeroSerieCilPp> getNumeroSerieCilPps() {
    return numeroSerieCilPps;
  }

  public void setNumeroSerieCilPps(List<NumeroSerieCilPp> numeroSerieCilPps) {
    this.numeroSerieCilPps = numeroSerieCilPps;
  }
}
