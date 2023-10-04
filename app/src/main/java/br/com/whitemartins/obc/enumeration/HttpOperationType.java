package br.com.whitemartins.obc.enumeration;

public enum HttpOperationType {
  SYNC(1, "SYNC"),
  ASYNC(2, "ASYNC");

  private Integer value;
  private String name;

  HttpOperationType(final Integer value, final String name) {
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
