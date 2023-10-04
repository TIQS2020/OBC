package br.com.whitemartins.obc.enumeration;

public enum CstType {
  _00("00"),
  _20("20"),
  _40("40"),
  _50("50"),
  _80("80"),
  _86("86"),
  _90("90"),
  _96("96"),
  _98("98"),
  _99("99")
  ;

  private String value;

  CstType(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

}
