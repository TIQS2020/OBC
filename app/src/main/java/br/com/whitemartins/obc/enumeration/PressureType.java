package br.com.whitemartins.obc.enumeration;

public enum PressureType {
  ALTA(1, "Alta"),
  BAIXA(2, "Baixa");

  private Integer value;
  private String name;

  PressureType(final Integer value, final String name) {
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
