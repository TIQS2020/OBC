package br.com.whitemartins.obc.enumeration;

public enum BeginTravelType {

  SUCESSO("0", "Viagem Iniciada com Sucesso."),
  INSUCESSO("1", "Viagem não pode ser Iniciada."),
  REFAZER_VIAGEM("2", "Viagem deverá ser Refeita."),
  FECHAR_VIAGEM("3", "Viagem já descarregada no sistema JDE ou iniciada pelo OBC Windows. Viagem não poderá ser iniciada.");

  private String value;
  private String description;

  BeginTravelType(final String value, final String name) {
    this.value = value;
    this.description = name;
  }

  public String getDescription() {
    return description;
  }

  public String getValue() {
    return value;
  }

  public static BeginTravelType getByValue(String value) {

    for (BeginTravelType st : values())
      if (st.getValue().equals(value))
        return st;

    return INSUCESSO;
  }

}
