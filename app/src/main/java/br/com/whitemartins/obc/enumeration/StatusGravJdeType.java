package br.com.whitemartins.obc.enumeration;

public enum StatusGravJdeType {
  NAO_ENVIADA(0, "Não enviada para fila"),
  NAO_CONSUMIDA(1, "Não consumida da fila"),
  COMSUMIDA_ERRO(2, "Consumida da fila com erro"),
  VIAGEM_DESCARREGADA(4, "Viagem descarregada"),
  TALONARIO_INVALIDO(5, "Talonario inválido"),
  VIAGEM_INVALIDA(6, "Nota já emitida em outra viagem"),
  IMEI_INVALIDO(7, "IMEI inválido");

  private Integer value;
  private String name;

  StatusGravJdeType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static StatusGravJdeType getByValue(Integer value) {

    for (StatusGravJdeType st : values())
      if (st.getValue().equals(value))
        return st;

    return null;
  }

  public static boolean isSerevreStatus(Integer status) {
    return (status.equals(StatusGravJdeType.VIAGEM_DESCARREGADA.getValue())
      || status.equals(StatusGravJdeType.TALONARIO_INVALIDO.getValue())
      || status.equals(StatusGravJdeType.VIAGEM_INVALIDA.getValue())
      || status.equals(StatusGravJdeType.IMEI_INVALIDO.getValue()));
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

}