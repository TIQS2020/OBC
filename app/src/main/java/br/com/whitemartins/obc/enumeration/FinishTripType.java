package br.com.whitemartins.obc.enumeration;

public enum FinishTripType {

  ODOMETRO(1, "Odômetro"),
  CONTAGEM_CILINDROS(10, "Contagem Física de Cilindro"),
  CONTAGEM_HC(20, "Contagem Física Homecare"),
  SINCRONISMO_NOTAS(30, "Sincronismo de Notas Fiscais"),
  SINCRONISMO_CECS(40, "Sincronismo de Cecs"),
  EMISSAO_RELATORIO(50, "Emissão de Relatórios"),
  GERAR_ARQUIVOS(60, "Geração de Arquivos"),
  APAGAR_BASE(70, "Apagar Base de Dados")
  ;

  private Integer value;
  private String name;

  FinishTripType(final Integer value, final String name) {
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
