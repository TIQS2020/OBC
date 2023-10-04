package br.com.whitemartins.obc.enumeration;

public enum MovimentoIntegracaoType {

  EMISSAO(1, "Emissão"),
//  CANCELAMENTO(2, "Cancelamento"),
//  REPROCESSAMENTO(3, "Reprocessamento"),
//  INUTILIZACAO(4, "Inutilização"),
//  CARTA_CORRECAO(5, "Carta Correção"),
  EVENTO_CANCELAMENTO(6, "Canc.");

  private Integer value;
  private String name;

  MovimentoIntegracaoType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static String getNameByValue(Integer value) {

    for (MovimentoIntegracaoType st : values())
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
