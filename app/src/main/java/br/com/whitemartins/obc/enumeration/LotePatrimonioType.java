package br.com.whitemartins.obc.enumeration;

public enum LotePatrimonioType {
  LOTE(1, "Lote"),
  PATRIMONIO(2, "Patrimônio");

  private Integer value;
  private String name;

  LotePatrimonioType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}
