package br.com.whitemartins.obc.enumeration;

public enum OptionType {
  WATTING(-1),
  TESTAR(0),
  RESTAURAR(1),
  CRIAR_BASE(2),
  APAGAR_BASE(3),
  UPDATE(4),
  GET_FILES(5);

  public Integer valor;

  OptionType(Integer valor) {
    this.valor = valor;
  }
}
