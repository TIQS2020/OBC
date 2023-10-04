package br.com.whitemartins.obc.enumeration;

public enum CalculoVolumeType {
  PESO(1, "Peso"),
  NIVEL(2, "Diferença de Nível");

  private Integer value;
  private String name;

  CalculoVolumeType(final Integer value, final String name) {
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
