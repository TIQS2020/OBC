package br.com.whitemartins.obc.model.sync;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "lotefab")
public class Lote {

  @Element(name = "lote", required = false)
  private String lote;
//
//  public Lote(@Element(name = "lotefab") String lote) {
//    this.lote = lote;
//  }

  public Lote() {
  }

  public String getLote() {
    return lote;
  }

  public void setLote(String lote) {
    this.lote = lote;
  }

  @Override
  public String toString() {
    return "Lote{" +
      "lote='" + lote + '\'' +
      '}';
  }
}
