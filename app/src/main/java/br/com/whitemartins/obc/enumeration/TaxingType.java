package br.com.whitemartins.obc.enumeration;

public enum TaxingType {
  TRIBUTADO(1, "Tributado"),
  ISENTO(2, "Isento"),
  OUTROS(3, "Outros"),
  DESCONTO_ORGAO_PUBLICO(8, "Desconto Orgão Público");

  private Integer value;
  private String name;

  TaxingType(final Integer value, final String name) {
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
