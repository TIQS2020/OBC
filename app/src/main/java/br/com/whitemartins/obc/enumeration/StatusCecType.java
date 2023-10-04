package br.com.whitemartins.obc.enumeration;

public enum StatusCecType {
  CEC_ON(1, "CEC Online", "CEC Online"),
  CEC_OFF(2, "CEC Offline", "Emissão Offline"),
  CEC_DPEC(3, "CEC Offline", "CEC Online"),
  CEC_REFEITO(4, "CEC Refeito", "CEC Online"),
  DANFE_ON(5, "DANFE Online", "DANFE Online"),
  DANFE_OFF(6, "DANFE Offline", "DANFE Simplificado em Contingência"),
  DANFE_DPEC(7, "DANFE Offline", "DANFE Online"),
  DANFE_REFEITO(8, "DANFE Refeito", "DANFE Online");

  private Integer value;
  private String name;
  private String typeName;

  StatusCecType(final Integer value, final String name, final String typeName) {
    this.value = value;
    this.name = name;
    this.typeName = typeName;
  }

  public static StatusCecType getByValue(Integer value) {

    for (StatusCecType st : values())
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

  public String getTypeName() {
    return typeName;
  }
}