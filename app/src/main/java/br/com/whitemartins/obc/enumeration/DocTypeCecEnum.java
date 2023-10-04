package br.com.whitemartins.obc.enumeration;

public enum DocTypeCecEnum {

  CEC("0", "CEC"),
  DANFE("1", "DANFE");

  private String value;
  private String name;

  DocTypeCecEnum(final String value, final String name) {
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