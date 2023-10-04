package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "downloader_NFe")
public class DownloaderNFe {

  @Element(name = "tipo_transacao", required = false)
  private String tipoTransacao;
  @Element(name = "nf_vnd_ordem", required = false)
  private Long numeroNotaVOR;
  @Element(name = "tipo_icms", required = false)
  private int tipoIcms;
  @Element(name = "base_icms", required = false)
  private Double baseCalculoIcms;
  @Element(name = "vl_icms", required = false)
  private Double valorIcms;
  @Element(name = "tipo_ipi", required = false)
  private Integer tipoIpi;
  @Element(name = "base_ipi", required = false)
  private Double baseCalculoIpi;
  @Element(name = "volume_capacidade", required = false)
  private Double volumeCapacidade;
  @Element(name = "num_movimento", required = false)
  private String cdMovimento;
  @Element(name = "vl_ipi", required = false)
  private Double valorIpi;
  @Element(name = "aliq_icms", required = false)
  private Double aliquotaIcms;
  @Element(name = "cd_pagamento", required = false)
  private String condicaoPagamento;
  @Element(name = "vl_liq_nf", required = false)
  private Double valorLiquido;
  @Element(name = "cd_fiscal", required = false)
  private Integer cdFiscal;
  @Element(name = "tipo_movimento_int", required = false)
  private int tipoMovimentoIntegracao;
  @Element(name = "status_nfe", required = false)
  private Integer status;
  @Element(name = "chave_acesso", required = false)
  private String chave;
  @Element(name = "protocolo", required = false)
  private String protocolo;
  @Element(name = "dt_atualizacao", required = false)
  private String dtAtualizacao;
  @Element(name = "status_contigencia", required = false)
  private String statusContigencia;
  @Element(name = "cd_jde_operadora", required = false)
  private Long cdJdeOperadora;
  @Element(name = "flag_paciente", required = false)
  private String flagPaciente;
  @Element(name = "forma_pagamento", required = false)
  private FormaPagamentoNFe formaPagamentoNFe;
  @Element(name = "pagamento_cartao", required = false)
  private PagamentoCartao pagamentoCartao;
  @Element(name = "nf_vnd_fut_entrega", required = false)
  private String numeroFutEntrega;
  @Element(name = "no_order_number", required = false)
  private String numeroOrdem;
  @Element(name = "tipo_faturamento", required = false)
  private String flNovoFaturamento;
  @Element(name = "cd_cliente_servico", required = false)
  private Long cdCustomerService;
  @Element(name = "cd_motivo", required = false)
  private String cdMotivo;

  public String getTipoTransacao() {
    return tipoTransacao;
  }

  public void setTipoTransacao(String tipoTransacao) {
    this.tipoTransacao = tipoTransacao;
  }

  public Long getNumeroNotaVOR() {
    return numeroNotaVOR;
  }

  public void setNumeroNotaVOR(Long numeroNotaVOR) {
    this.numeroNotaVOR = numeroNotaVOR;
  }

  public Double getBaseCalculoIcms() {
    return baseCalculoIcms;
  }

  public void setBaseCalculoIcms(Double baseCalculoIcms) {
    this.baseCalculoIcms = baseCalculoIcms;
  }

  public Double getValorIcms() {
    return valorIcms;
  }

  public void setValorIcms(Double valorIcms) {
    this.valorIcms = valorIcms;
  }

  public Double getBaseCalculoIpi() {
    return baseCalculoIpi;
  }

  public void setBaseCalculoIpi(Double baseCalculoIpi) {
    this.baseCalculoIpi = baseCalculoIpi;
  }

  public Double getVolumeCapacidade() {
    return volumeCapacidade;
  }

  public void setVolumeCapacidade(Double volumeCapacidade) {
    this.volumeCapacidade = volumeCapacidade;
  }

  public String getCdMovimento() {
    return cdMovimento;
  }

  public void setCdMovimento(String cdMovimento) {
    this.cdMovimento = cdMovimento;
  }

  public Double getValorIpi() {
    return valorIpi;
  }

  public void setValorIpi(Double valorIpi) {
    this.valorIpi = valorIpi;
  }

  public Double getAliquotaIcms() {
    return aliquotaIcms;
  }

  public void setAliquotaIcms(Double aliquotaIcms) {
    this.aliquotaIcms = aliquotaIcms;
  }

  public String getCondicaoPagamento() {
    return condicaoPagamento;
  }

  public void setCondicaoPagamento(String condicaoPagamento) {
    this.condicaoPagamento = condicaoPagamento;
  }

  public Integer getCdFiscal() {
    return cdFiscal;
  }

  public void setCdFiscal(Integer cdFiscal) {
    this.cdFiscal = cdFiscal;
  }

  public int getTipoMovimentoIntegracao() {
    return tipoMovimentoIntegracao;
  }

  public void setTipoMovimentoIntegracao(int tipoMovimentoIntegracao) {
    this.tipoMovimentoIntegracao = tipoMovimentoIntegracao;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getChave() {
    return chave;
  }

  public void setChave(String chave) {
    this.chave = chave;
  }

  public String getProtocolo() {
    return protocolo;
  }

  public void setProtocolo(String protocolo) {
    this.protocolo = protocolo;
  }

  public String getDtAtualizacao() {
    return dtAtualizacao;
  }

  public void setDtAtualizacao(String dtAtualizacao) {
    this.dtAtualizacao = dtAtualizacao;
  }

  public String getStatusContigencia() {
    return statusContigencia;
  }

  public void setStatusContigencia(String statusContigencia) {
    this.statusContigencia = statusContigencia;
  }

  public Long getCdJdeOperadora() {
    return cdJdeOperadora;
  }

  public void setCdJdeOperadora(Long cdJdeOperadora) {
    this.cdJdeOperadora = cdJdeOperadora;
  }

  public String getFlagPaciente() {
    return flagPaciente;
  }

  public void setFlagPaciente(String flagPaciente) {
    this.flagPaciente = flagPaciente;
  }

  public FormaPagamentoNFe getFormaPagamentoNFe() {
    return formaPagamentoNFe;
  }

  public void setFormaPagamentoNFe(FormaPagamentoNFe formaPagamentoNFe) {
    this.formaPagamentoNFe = formaPagamentoNFe;
  }

  public PagamentoCartao getPagamentoCartao() {
    return pagamentoCartao;
  }

  public void setPagamentoCartao(PagamentoCartao pagamentoCartao) {
    this.pagamentoCartao = pagamentoCartao;
  }

  public int getTipoIcms() {
    return tipoIcms;
  }

  public void setTipoIcms(int tipoIcms) {
    this.tipoIcms = tipoIcms;
  }

  public Integer getTipoIpi() {
    return tipoIpi;
  }

  public void setTipoIpi(Integer tipoIpi) {
    this.tipoIpi = tipoIpi;
  }

  public Double getValorLiquido() {
    return valorLiquido;
  }

  public void setValorLiquido(Double valorLiquido) {
    this.valorLiquido = valorLiquido;
  }

  public String getNumeroFutEntrega() {
    if (numeroFutEntrega == null)
      numeroFutEntrega = "";
    return numeroFutEntrega;
  }

  public void setNumeroFutEntrega(String numeroFutEntrega) {
    this.numeroFutEntrega = numeroFutEntrega;
  }

  public String getNumeroOrdem() {
    return numeroOrdem;
  }

  public void setNumeroOrdem(String numeroOrdem) {
    this.numeroOrdem = numeroOrdem;
  }

  public String getFlNovoFaturamento() {
    return flNovoFaturamento;
  }

  public void setFlNovoFaturamento(String flNovoFaturamento) {
    this.flNovoFaturamento = flNovoFaturamento;
  }

  public Long getCdCustomerService() {
    return cdCustomerService;
  }

  public void setCdCustomerService(Long cdCustomerService) {
    this.cdCustomerService = cdCustomerService;
  }

  public String getCdMotivo() {
    return cdMotivo;
  }

  public void setCdMotivo(String cdMotivo) {
    this.cdMotivo = cdMotivo;
  }
}

