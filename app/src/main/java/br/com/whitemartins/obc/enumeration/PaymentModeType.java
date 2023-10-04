package br.com.whitemartins.obc.enumeration;

public enum PaymentModeType {

  DINHEIRO(1, "Dinheiro"),
  CHEQUE(2, "Cheque"),
  CREDITO(3, "Crédito"),
  DEBITO(4, "Débito");

  private Integer value;
  private String name;

  PaymentModeType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static String getNameByValue(Integer value) {

    for (PaymentModeType st : values())
      if (st.getValue().equals(value))
        return st.getName();

    return null;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}
