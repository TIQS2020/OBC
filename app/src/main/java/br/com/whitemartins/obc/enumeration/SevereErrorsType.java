package br.com.whitemartins.obc.enumeration;

public enum SevereErrorsType {
  NAO_CONSUMIDA(1, "Não consumida da fila"),
  COMSUMIDA_ERRO(2, "Consumida da fila com erro"),
  VIAGEM_DESCARREGADA(4, "Viagem descarregada"),
  TALONARIO_INVALIDO(5, "Talonario inválido"),
  VIAGEM_INVALIDA(6, "Nota já emitida em outra viagem"),
  IMEI_INVALIDO(7, "IMEI inválido");

  private Integer value;
  private String name;

  SevereErrorsType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static SevereErrorsType getByValue(Integer value) {

    for (SevereErrorsType st : values())
      if (st.getValue().equals(value))
        return st;

    return null;
  }

  public static boolean isSevereStatus(Integer status) {
    return (SevereErrorsType.VIAGEM_DESCARREGADA.getValue().equals(status)
      || SevereErrorsType.TALONARIO_INVALIDO.getValue().equals(status)
      || SevereErrorsType.VIAGEM_INVALIDA.getValue().equals(status)
      || SevereErrorsType.IMEI_INVALIDO.getValue().equals(status));
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

}