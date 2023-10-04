package br.com.whitemartins.obc.enumeration;

public enum ClasseContribType {
  // 1 - Contribuinte/Não consumidor, 2 - Não Contribuinte/Consumidor, 3 - Contribuinte/Consumidor)
  CONTRIB_NAO_CONSUMIDOR(1, "Contribuinte/Não consumidor"),
  NAO_CONTRIB_CONSUMIDOR(2, "Não Contribuinte/Consumidor"),
  CONTRIB_CONSUMIDOR(3, "Contribuinte/Consumidor");

  private Integer value;
  private String name;

  ClasseContribType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
   return name;
  }
}
