package br.com.whitemartins.obc.enumeration;

public enum OperationType {
  VND(2, "Venda", "Venda", 1),
  APL(11, "Aplicação", "Aplicação", 2),
  APLHC(11, "Aplicação", "Aplicação", 2),
  RCL(13, "Recolhimento", "Recolhimento", 4),
  RCLNF(13, "Recolhimento", "Recolhimento", 4),
  RCLHC(13, "Recolhimento", "Recolhimento", 4),
  TRC(12, "Ordem de Troca (Baixa S8)", "Ordem Troca", 3),
  FUT(14, "Remessa Futura Entrega", "Rem. Fut Entrega", 5),
  RFH(9, "Remessa Faturamento HC", "Rem. Fat. HC", 6),
  VOR(10, "Remessa Venda Ordem", "Rem. Venda Ordem", 7),
  RPS(19, "Remessa Prestação de Serviço", "Rem. Prest. Serv.", 9),
  TRB(5, "Transbordo", "Transbordo", 0),
  TRF(15, "Transferência entre Unidades", "Transferência", 8),
  CPL(4, "Complemento de Carga", "Complemento", 0);

  private Integer value;
  private String name;
  private String nickName;
  private Integer idOperationInvoiceReport;

  OperationType(final Integer value, final String name, final String nickName,
                final Integer idOperationInvoiceReport) {
    this.value = value;
    this.name = name;
    this.nickName = nickName;
    this.idOperationInvoiceReport = idOperationInvoiceReport;
  }

  public static OperationType getByValue(Integer value) {

    for (OperationType st : values())
      if (st.getValue().equals(value))
        return st;

    return null;
  }

  public Integer getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public String getNickName() {
    return nickName;
  }

  public Integer getIdOperationInvoiceReport() {
    return idOperationInvoiceReport;
  }
}
