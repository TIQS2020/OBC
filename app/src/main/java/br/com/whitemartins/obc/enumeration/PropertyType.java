package br.com.whitemartins.obc.enumeration;

import android.support.annotation.Nullable;

public enum PropertyType {
  PRODUZIDO_WM("1", "WM"),
  NAO_PRODUZIDO_WM("2", "PP");

  private String value;
  private String name;

  PropertyType(final String value, final String name) {
    this.value = value;
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  @Nullable
  public String getName() {
    for (PropertyType e : PropertyType.values()) {
      if (this.value == e.value)
        return e.name;
    }
    return null;
  }
}
