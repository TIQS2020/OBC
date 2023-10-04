package br.com.whitemartins.obc.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum TypeItemType {
  GAS(1, "Gás"),
  EQUIPAMENTO(2, "Equipamento"), //Pede informação de patrimônio ao vender
  CONSUMIVEL(3, "Consumível"), //Pergunta se vai informar o Lote ao aplicar/ Validar com tabela de atvios
  MISCELANIA(4, "Miscelânia");

  private Integer value;
  private String name;

  TypeItemType(final Integer value, final String name) {
    this.value = value;
    this.name = name;
  }

  public static List<Integer> build(TypeItemType... typeItemTypes) {
    List<Integer> types = new ArrayList<>();

    for (TypeItemType typeItemType : typeItemTypes) {
      types.add(typeItemType.getValue());
    }

    return types;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

}
