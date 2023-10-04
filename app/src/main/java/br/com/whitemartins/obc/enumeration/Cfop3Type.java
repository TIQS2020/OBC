package br.com.whitemartins.obc.enumeration;

import android.support.annotation.Nullable;

public enum Cfop3Type {

  INTERNO_MANUF(0, "Interno Manufaturado"),
  INTERNO_NAO_MANUF(1, "Interno Não Manufaturado"),
  EXTERNO_MANUF(2, "Externo Manufaturado"),
  EXTERNO_NAO_MANUF(3, "Externo Não Manufaturado");

  private Integer value;
  private String name;
  private Integer cfop;

  Cfop3Type(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public Integer getValue() {
    return value;
  }

  @Nullable
  public String getName() {
    for (Cfop3Type e : Cfop3Type.values()) {
      if (this.value == e.value)
        return e.name;
    }
    return null;
  }

  @Nullable
  public Integer getCfop() {
    for (Cfop3Type e : Cfop3Type.values()) {
      if (this.value == e.value)
        return e.cfop;
    }
    return null;
  }

  public void setCfop(Integer cfop) {
    this.cfop = cfop;
  }
}
