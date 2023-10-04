package br.com.whitemartins.obc.enumeration;

public enum CustomerType {

  ORGAO_PUBLICO(1, "Órgão Público");

  private Integer value;
  private String name;

  CustomerType(final Integer value, final String name) {
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
