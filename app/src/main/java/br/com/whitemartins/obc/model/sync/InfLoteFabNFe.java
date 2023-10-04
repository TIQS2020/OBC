package br.com.whitemartins.obc.model.sync;


import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

@Root(name = "inf_lote_fab")
public class InfLoteFabNFe {

  @ElementArray(name = "lote", required = false)
  private String[] lotes;

  public InfLoteFabNFe() {
//    lotes = new ArrayList<>();
  }

  public String[] getLotes() {
    return lotes;
  }

  public void setLotes(String[] lotes) {
    this.lotes = lotes;
  }

  @Override
  public String toString() {
    return "InfLoteFabNFe{" +
      "lotes=" + lotes +
      '}';
  }
}
