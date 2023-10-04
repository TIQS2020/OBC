package br.com.whitemartins.obc.enumeration;

public enum ConsultType {
  EMISSAO("01", "Emissão"),
  CANCELAMENTO("02", "Cancelamento");

  private String value;
  private String name;

  ConsultType(final String value, final String name) {
    this.value = value;
    this.name = name;

  }

  public String getValue() {
    return value;
  }
}
