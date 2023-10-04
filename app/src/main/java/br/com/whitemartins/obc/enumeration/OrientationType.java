package br.com.whitemartins.obc.enumeration;

public enum OrientationType {

  LEFT(1),
  RIGHT(2);

  private Integer value;

  OrientationType(final Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
