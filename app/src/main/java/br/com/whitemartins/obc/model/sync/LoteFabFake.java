package br.com.whitemartins.obc.model.sync;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "inf_lote_fab")
public class LoteFabFake {

//  @ElementArray(entry = "lote", required = false)
//  private String[] lotes;
//
//  @ElementArray(entry = "lote", required = false)
//  private String[] inf_lote_fab;

//  @ElementArray(entry = "lote", required = false)
//  private String[] lote;

  @ElementList(entry = "lote", inline = true, required = false)
  private List<String> lote;

  public LoteFabFake() {
    lote = new ArrayList<>();
  }

  public List<String> getLote() {
    return lote;
  }

  public void setLote(List<String> lote) {
    this.lote = lote;
  }

  //  public String[] getLotes() {
//    return lotes;
//  }
//
//  public void setLotes(String[] lotes) {
//    this.lotes = lotes;
//  }
//
//  public String[] getInf_lote_fab() {
//    return inf_lote_fab;
//  }
//
//  public void setInf_lote_fab(String[] inf_lote_fab) {
//    this.inf_lote_fab = inf_lote_fab;
//  }

//  public String[] getLote() {
//    return lote;
//  }
//
//  public void setLote(String[] lote) {
//    this.lote = lote;
//  }
}
