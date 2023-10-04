package br.com.whitemartins.obc.enumeration;

public enum CnpjCpfTypeEnum {

  CNPJ("1", "CNPJ"),
  CPF("2", "CPF");

  private String value;
  private String name;

  CnpjCpfTypeEnum(final String value, final String name) {
    this.value = value;
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}