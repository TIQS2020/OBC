package br.com.whitemartins.obc.enumeration;

public enum StepEmissaoType {
  CRIAR(0, "Criada"),
  ENVIAR(1, "Enviada"),
  CONSULTAR(2, "Consultada"),
  IMPRIMIR(3, "Imprimindo"),
  FINALIZAR(5, "Finalizada");

  private Integer value;
  private String name;

  StepEmissaoType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static StepEmissaoType getByValue(Integer value) {

    for (StepEmissaoType st : values())
      if (st.getValue().equals(value))
        return st;

    return CRIAR;
  }

  public Integer getValue() {
    return value;
  }
  public String getName() {
    return name;
  }
}
