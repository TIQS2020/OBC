package br.com.whitemartins.obc.enumeration;

public enum InvoiceType {

  ENTRADA("E", "Entrada"),
  SAIDA("S", "Saída");

  private String value;
  private String name;

  InvoiceType(final String value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static String getName(String value) {

    for (InvoiceType t : InvoiceType.values()) {

      if (t.value.equalsIgnoreCase(value))
        return t.getName();
    }

    return "";
  }

  public String getValue() {
    return value;
  }

  public String getName() {
    return name;
  }


}
