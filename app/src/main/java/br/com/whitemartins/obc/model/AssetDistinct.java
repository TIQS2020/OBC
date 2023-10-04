package br.com.whitemartins.obc.model;

public class AssetDistinct {
  private Long cdItem;
  private String descricao;
//  private Integer total;

  public Long getCdItem() {
    return cdItem;
  }

  public void setCdItem(Long cdItem) {
    this.cdItem = cdItem;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

//  public Integer getValorTotalProduto() {
//    return total;
//  }
//
//  public void setTotal(Integer total) {
//    this.total = total;
//  }

  @Override
  public String toString() {
    return this.getCdItem() + " " + this.getDescricao();
  }
}
