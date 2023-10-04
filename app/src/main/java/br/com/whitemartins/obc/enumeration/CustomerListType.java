package br.com.whitemartins.obc.enumeration;

public enum CustomerListType {
  TODOS(0),
  TRANSFERENCIA(1),
  INTERCOMPANY(2),
  NORMAL(3);


  private Integer value;

  CustomerListType(final Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}