package br.com.whitemartins.obc.enumeration;

import android.support.annotation.Nullable;

public enum LoadType {
  NULO(0, ""),
  CHEIO(1, "Cheio"),
  VAZIO(2, "Vazio");

  private Integer value;
  private String name;

  LoadType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static String getNameByValue(Integer value) {

    for (LoadType st : values())
      if (st.getValue().equals(value))
        return st.getName();

    return null;
  }

  public Integer getValue() {
    return value;
  }

  @Nullable
  public String getName() {
    return name;
  }
}
