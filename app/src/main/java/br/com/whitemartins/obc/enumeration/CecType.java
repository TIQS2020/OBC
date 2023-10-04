package br.com.whitemartins.obc.enumeration;

public enum CecType {

  REC_SEM("0", "REC", "Recibo de Entrega ao Cliente", false), //Emitido somente para operação de RPS
  CEC_SEM("1", "CEC", "Canhoto de Entrega ao Cliente", false),
  CEC_COM("2", "CEC", "Canhoto de Entrega ao Cliente", true),
  DANFE_SEM("3", "DANFE", "DANFE Simplificado", false),
  DANFE_COM("4", "DANFE", "DANFE Simplificado", true);

  private String value;
  private String name;
  private String fullname;
  private boolean showValue;

  CecType(final String value, final String name, final String fullname, final boolean showValue) {
    this.value = value;
    this.name = name;
    this.fullname = fullname;
    this.showValue = showValue;
  }

  public static CecType getByValue(String v) {
    for (CecType e : CecType.values()) {
      if (v.equalsIgnoreCase(e.value))
        return e;
    }

    return null;
  }

  public String getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public String getFullname() {
    return fullname;
  }

  public boolean showValue() {
    return showValue;
  }
}
