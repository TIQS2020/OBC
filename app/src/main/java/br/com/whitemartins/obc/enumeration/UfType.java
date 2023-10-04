package br.com.whitemartins.obc.enumeration;

public enum UfType {

  AC("AC", "Acre"),
  AL("AL", "Alagoas"),
  AP("AP", "Amapá"),
  AM("AM", "Amazonas"),
  BA("BA", "Bahia"),
  CE("CE", "Ceará"),
  DF("DF", "Distrito Federal"),
  ES("ES", "Espirito Santo"),
  GO("GO", "Goiás"),
  MA("MA", "Maranhão"),
  MT("MT", "Mato Grosso"),
  MS("MS", "Mato Grosso do Sul"),
  MG("MG", "Minas Gerais"),
  PA("PA", "Pará"),
  PB("PB", "Paraíba"),
  PR("PR", "Paraná"),
  PE("PE", "Pernambuco"),
  PI("PI", "Piauí"),
  RJ("RJ", "Rio de Janeiro"),
  RN("RN", "Rio Grande do Norte"),
  RS("RS", "Rio Grande do Sul"),
  RO("RO", "Rondônia"),
  RR("RR", "Roraima"),
  SC("SC", "Santa Catarina"),
  SP("SP", "São Paulo"),
  SE("SE", "Sergipe"),
  TO("TO", "Tocantins");

  private String value;
  private String name;

  UfType(String value, String name) {
    this.value = value;
    this.name = name;
  }

  public String getValue() {
    return this.value;
  }

  public String getName() {
    return this.name;
  }

}
