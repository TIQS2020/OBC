package br.com.whitemartins.obc.enumeration;

public enum CilinderPropertyType {

  WM("1", "SAWM"),
  PP("2", "PP");

  private String value;
  private String name;

  CilinderPropertyType(final String value, final String name) {
    this.value = value;
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public static String getNameByValue(String value) {

    for (CilinderPropertyType st : values())
      if (st.getValue().equals(value))
        return st.getName();

    return null;
  }
}
