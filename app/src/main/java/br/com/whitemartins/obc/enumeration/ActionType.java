package br.com.whitemartins.obc.enumeration;

public enum ActionType {

  ATIVAR(0, "Ativar Dispositivo.", "ATIVAR", HttpOperationType.SYNC),
  CANCELAR_NOTA(1, "Cancelando Nota Fiscal.", "CANCELAMENTO_NOTA", HttpOperationType.ASYNC),
  ENVIAR_NOTA(2, "Enviando Nota Fiscal.", "ENVIO_NOTA", HttpOperationType.ASYNC),
  CONSULTAR_NOTA(3, "Consultando Nota Fiscal.", "CONSULTA_NOTA", HttpOperationType.SYNC),
  SINCRONIZAR_VIAGEM(4, "Sincronizando de Viagem.", "SINCRONISMO_VIAGEM", HttpOperationType.SYNC),
  VALIDA_TOKEN(5, "Valindando Token.", "VALIDA_TOKEN", HttpOperationType.SYNC),
  PING(6, "Testando Conexão.", "", HttpOperationType.SYNC),
  RECUPERAR_CLIENTES(7, "Recuperando Cliente.", "RECUPERA_CLIENTES", HttpOperationType.ASYNC),
  RECUPERAR_CLIENTES_CONSULTA(8, "Consultando Cliente.", "RECUPERA_CLIENTES_CONSULTA",
    HttpOperationType.SYNC),
  FIM_VIAGEM(9, "Finalizando Viagem", "FIM_VIAGEM", HttpOperationType.ASYNC),
  FIM_VIAGEM_CONSULTA(10, "Consultando Fim da Viagem.", "FIM_VIAGEM_CONSULTA", HttpOperationType.SYNC),
  GRAVA_CEC(11, "Enviando Cec", "GRAVA_CEC", HttpOperationType.ASYNC),
  GRAVA_CEC_CONSULTA(12, "Consultando Cec", "GRAVA_CEC_CONSULTA", HttpOperationType.SYNC),
  INICIO_VIAGEM(11, "Iniciando Viagem", "INICIO_VIAGEM", HttpOperationType.SYNC),
  VALIDA_SEMENTE(12, "Validando Semente", "VALIDA_SEMENTE", HttpOperationType.SYNC),
  CONSULTAR_CANCELAMENTO(13, "Consultando Cancelamento Nota Fiscal.", "CONSULTA_NOTA", HttpOperationType.SYNC);

  private Integer value;
  private String name;
  private String lineName;
  private HttpOperationType httpOperationType;

  ActionType(final Integer value, final String name, final String lineName,
             final HttpOperationType httpOperationType) {
    this.value = value;
    this.name = name;
    this.lineName = lineName;
    this.httpOperationType = httpOperationType;
  }

  public String getLineName() {
    return lineName;
  }

  public String getName() {
    return name;
  }

  public Integer getValue() {
    return value;
  }

  public String getHttpOperationType() {
    return httpOperationType.toString();
  }
}
