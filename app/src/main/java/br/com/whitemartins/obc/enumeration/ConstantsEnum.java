package br.com.whitemartins.obc.enumeration;

public enum ConstantsEnum {
  YES("Y", "Sim"),
  SIM("S", "SIM"),
  NO("N", "Não"),
  A("A", "A"), //Para ler tabela Message
  B("B", "B"), //Para ler tabela Message
  C("C", "C"), //Para ler tabela Message
  D("D", "D"), //Para ler tabela Message
  E("E", "E"), //Para ler tabela Message
  F("F", "F"), //Para ler tabela Message
  H("H", "H"), //Para ler tabela Message
  K("K", "K"), //Para ler tabela Message
  L("L", "L"), //Para ler tabela Message
  M("M", "M"), //Para ler tabela Message
  N("N", "N"), //Para ler tabela Message
  O("O", "O"), //Para ler tabela Message
  R("R", "R"),
  S("S", "S"), //Mensagem do VOR
  W("W", "W"), //Para ler tabela Message
  V("V", "V"), //Para ler tabela Message
  Z("Z", "Z"), //Para ler tabela Message
  Y("Y", "Y"), //Para ler tabela Code
  I("I", "I"), //Para ler tabela Code
  P("P", "P"), //Para ler tabela Code
  _0("0", "0"),
  _1("1", "1"),
  _00("00", "00"),
  _01("01", "01"),
  _02("02", "02"),
  _990("990", "990"),
  HHmmss_ponto("HH:mm:ss", "HH:mm:ss"),
  ddMMyyyy("ddMMyyyy", "ddMMyyyy"),
  ddMMyy_barra("dd/MM/yy", "dd/MM/yy"),
  ddMMyyyy_barra("dd/MM/yyyy", "dd/MM/yyyy"),
  ddMMyyyy_HHmmss("ddMMyyyy HHmmss", "ddMMyyyy HHmmss"),
  ddMMyyyyHHmmss("ddMMyyyyHHmmss", "ddMMyyyy HHmmss"),
  ddMMyyyy_HHmmss_barra("dd/MM/yyyy HH:mm:ss", "dd/MM/yyyy HH:mm:ss"),
  yyyyMMdd("yyyyMMdd", "yyyyMMdd"),
  yyyyMMdd_traco("yyyy-MM-dd", "yyyy-MM-dd"),
  yyyyMMdd_HHmmsss("yyyyMMdd HHmmss", "yyyyMMdd HHmmss"),
  XML_EXTENSION(".xml", ".xml"),
  GRANEL("GRANEL", "GRANEL"),
  CILINDROS("CILINDROS", "CILINDROS"),
  UNIDADES("UNIDADES", "UNIDADES"),
  GEMINI("GEMINI", "GEMINI"),
  WM("WM", "WM"),
  UN("UN", "UN"); //Unidade de Medida Fixa

  private String value;
  private String name;

  ConstantsEnum(final String value, final String name) {
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
