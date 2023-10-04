package br.com.whitemartins.obc.enumeration;

public enum PrintStatusType {

  IMPRESSO(1, "Impresso"),
  NAO_IMPRESSO(2, "Não Impresso"),
  RFEITO(3, "Refeito");

  private Integer value;
  private String name;

  PrintStatusType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static PrintStatusType getByValue(Integer value) {

    for (PrintStatusType st : values())
      if (st.getValue().equals(value))
        return st;

    return null;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}