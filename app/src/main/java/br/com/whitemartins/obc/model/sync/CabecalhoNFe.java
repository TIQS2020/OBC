package br.com.whitemartins.obc.model.sync;

import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.TypeConverters;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.enumeration.PrintStatusType;
import br.com.whitemartins.obc.model.InvoiceItem;

//@Entity
@Root(name = "cabecalhoNFe")
public class CabecalhoNFe {

  private static final long serialVersionUID = 1L;

  @Element(name = "seq_num_nfe", required = false)
  private Long id;
  @Element(name = "num_nfe", required = false)
  private Long numero;
  @Element(name = "serie_nfe", required = false)
  private Long serie;
  private Long serieNotaVOR;
  @Element(name = "cnpj_cpf_destino", required = false)
  private String cnpjCpfDestino;
  @Element(name = "cnpj_cpf_transp", required = false)
  private String cpnjCpfTransp;
  @Element(name = "tipo_operacao", required = false)
  private String tipoNota;
  private String dataViagemPrincial;
  private String numeroViagem;
  private String dataViagem;
  private String nomeOperacao;
  @TypeConverters(DateTypeConverter.class)
  @Element(name = "dt_emissao", required = false)
  private String dataEmissao;
  @TypeConverters(DateTypeConverter.class)
  @Element(name = "dt_movimento", required = false)
  private String dataMovimento;
  @Element(name = "dt_vencimento", required = false)
  private String dataVencimento;
  //Valores
  @Element(name = "vl_total_nfe", required = false)
  private Double valorTotal;
  @Element(name = "vl_liq_nf", required = false)
  private Double valorLiquido;
  @Element(name = "vl_desconto", required = false)
  private Double valorDesconto;
  @Element(name = "vl_total_prod", required = false)
  private Double valorTotalProduto;
  @Element(name = "vl_frete", required = false)
  private Double valorFrete;
  @Element(name = "vl_desp_acess", required = false)
  private Double valorDespAcessorias;
  @Element(name = "uf_veiculo", required = false)
  private String ufVeiculo;
  @Element(name = "placa_veiculo", required = false)
  private String placaVeiculo;
  @Element(name = "cd_veiculo", required = false)
  private String numeroVeiculo;
  @Element(name = "modalidade_frete", required = false)
  private Integer modalidadeFrete;
  @Element(name = "nm_espec_volume", required = false)
  private String nomeEspecVolume;
  @Element(name = "nm_marca", required = false)
  private String nomeMarca;
  @Element(name = "qtd_volume", required = false)
  private Double qtdVolumes;
  @Element(name = "peso_bruto", required = false)
  private Double pesoBruto;
  @Element(name = "peso_liq", required = false)
  private Double pesoLiquido;
  @Element(name = "tipo_pedido", required = false)
  private String tipoPedido;
  @Element(name = "cd_cliente", required = false)
  private Long cdCustomer;
  @Element(name = "ativa_tipo_pagto", required = false)
  private String ativaTipoPagto;

  private Integer stepEmissao;
  //Impostos
  //ICMS
  private Double valorDescontoIcms;
  //  private Integer situacaoTributariaIcms;
  //IPI
//  @Element(name = "tipo_ipi", required = false)
//  private Integer situacaoTributariaIpi;
  @Element(name = "cd_jde_operadora", required = false)
  private Long cdOperadora;
  @Element(name = "flag_paciente", required = false)
  private String flPaciente;
  @Element(name = "cd_cliente_servico", required = false)
  private Long cdCustomerService;
  @Element(name = "nome", required = false)
  private String nomeAssinadorCec;
  @Element(name = "documento", required = false)
  private String rgAssinadorCec;
  private Integer tipoMovimentoIntegracao;
  @Element(name = "sem_pagto", required = false)
  private String semPagto;
  @Element(name = "stat_grav_jde", required = false)
  private Integer statusGravacaoJde;
  @Element(name = "mens_stat_grav_jde", required = false)
  private String mensagemGravacaoJde;
  private Integer statusCec;//OnLine OffLine
  private String nomeTransacao;
  private Integer statusImpressaoCec; //Impresso Não Impresso
  private String nomeStatus;
  private String nomeFormaImpressaoCec;
  private String nomeStatusCec;
  private String nomeStatusImpressaoCec;
  private String flPrecoAlterado;
  private String nomeTipoPagamento;
  @Element(name = "assinatura", required = false)
  private String assinatura;

  @Element(name = "downloader_NFe")
  private DownloaderNFe downloaderNFe;

  //
  @Ignore
  private List<InvoiceItem> itens;

  public CabecalhoNFe() {
    nomeAssinadorCec = "";
    rgAssinadorCec = "";
    itens = new ArrayList<>();
    serieNotaVOR = 0L;
    statusImpressaoCec = PrintStatusType.NAO_IMPRESSO.getValue();
    statusCec = PrintStatusType.NAO_IMPRESSO.getValue();
  }

  public static CabecalhoNFe newInstance() {
    return new CabecalhoNFe();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public Long getSerie() {
    return serie;
  }

  public void setSerie(Long serie) {
    this.serie = serie;
  }

  public String getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(String numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public String getCnpjCpfDestino() {
    return cnpjCpfDestino;
  }

  public void setCnpjCpfDestino(String cnpjCpfDestino) {
    this.cnpjCpfDestino = cnpjCpfDestino;
  }

  public String getCpnjCpfTransp() {
    return cpnjCpfTransp;
  }

  public void setCpnjCpfTransp(String cpnjCpfTransp) {
    this.cpnjCpfTransp = cpnjCpfTransp;
  }

  public String getTipoNota() {
    return tipoNota;
  }

  public void setTipoNota(String tipoNota) {
    this.tipoNota = tipoNota;
  }

  public String getDataViagemPrincial() {
    return dataViagemPrincial;
  }

  public void setDataViagemPrincial(String dataViagemPrincial) {
    this.dataViagemPrincial = dataViagemPrincial;
  }

  public String getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(String dataViagem) {
    this.dataViagem = dataViagem;
  }

  public String getNomeOperacao() {
    return nomeOperacao;
  }

  public void setNomeOperacao(String nomeOperacao) {
    this.nomeOperacao = nomeOperacao;
  }

  public String getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(String dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public String getDataMovimento() {
    return dataMovimento;
  }

  public void setDataMovimento(String dataMovimento) {
    this.dataMovimento = dataMovimento;
  }

  public String getDataVencimento() {
    return dataVencimento;
  }

  public void setDataVencimento(String dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Double getValorLiquido() {
    return valorLiquido;
  }

  public void setValorLiquido(Double valorLiquido) {
    this.valorLiquido = valorLiquido;
  }

  public String getUfVeiculo() {
    return ufVeiculo;
  }

  public void setUfVeiculo(String ufVeiculo) {
    this.ufVeiculo = ufVeiculo;
  }

  public String getPlacaVeiculo() {
    return placaVeiculo;
  }

  public void setPlacaVeiculo(String placaVeiculo) {
    this.placaVeiculo = placaVeiculo;
  }

  public Integer getModalidadeFrete() {
    return modalidadeFrete;
  }

  public void setModalidadeFrete(Integer modalidadeFrete) {
    this.modalidadeFrete = modalidadeFrete;
  }

  public String getNomeEspecVolume() {
    return nomeEspecVolume;
  }

  public void setNomeEspecVolume(String nomeEspecVolume) {
    this.nomeEspecVolume = nomeEspecVolume;
  }

  public String getNomeMarca() {
    return nomeMarca;
  }

  public void setNomeMarca(String nomeMarca) {
    this.nomeMarca = nomeMarca;
  }

  public Double getValorTotalProduto() {
    return valorTotalProduto;
  }

  public void setValorTotalProduto(Double valorTotalProduto) {
    this.valorTotalProduto = valorTotalProduto;
  }

  public Double getValorFrete() {
    return valorFrete;
  }

  public void setValorFrete(Double valorFrete) {
    this.valorFrete = valorFrete;
  }

  public Double getValorDespAcessorias() {
    return valorDespAcessorias;
  }

  public void setValorDespAcessorias(Double valorDespAcessorias) {
    this.valorDespAcessorias = valorDespAcessorias;
  }

  public Double getQtdVolumes() {
    return qtdVolumes;
  }

  public void setQtdVolumes(Double qtdVolumes) {
    this.qtdVolumes = qtdVolumes;
  }

  public Double getPesoBruto() {
    return pesoBruto;
  }

  public void setPesoBruto(Double pesoBruto) {
    this.pesoBruto = pesoBruto;
  }

  public Double getPesoLiquido() {
    return pesoLiquido;
  }

  public void setPesoLiquido(Double pesoLiquido) {
    this.pesoLiquido = pesoLiquido;
  }

  public String getTipoPedido() {
    return tipoPedido;
  }

  public void setTipoPedido(String tipoPedido) {
    this.tipoPedido = tipoPedido;
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getNumeroVeiculo() {
    return numeroVeiculo;
  }

  public void setNumeroVeiculo(String numeroVeiculo) {
    this.numeroVeiculo = numeroVeiculo;
  }

  public String getAtivaTipoPagto() {
    return ativaTipoPagto;
  }

  public void setAtivaTipoPagto(String ativaTipoPagto) {
    this.ativaTipoPagto = ativaTipoPagto;
  }

//  public String getTipoTransacao() {
//    return tipoTransacao;
//  }
//
//  public void setTipoTransacao(String tipoTransacao) {
//    this.tipoTransacao = tipoTransacao;
//  }

  public Integer getStepEmissao() {
    return stepEmissao;
  }

  public void setStepEmissao(Integer stepEmissao) {
    this.stepEmissao = stepEmissao;
  }

  public DownloaderNFe getDownloaderNFe() {
    return downloaderNFe;
  }

  public void setDownloaderNFe(DownloaderNFe downloaderNFe) {
    this.downloaderNFe = downloaderNFe;
  }

  public Long getSerieNotaVOR() {
    return serieNotaVOR;
  }

  public void setSerieNotaVOR(Long serieNotaVOR) {
    this.serieNotaVOR = serieNotaVOR;
  }

  public Double getValorDescontoIcms() {
    return valorDescontoIcms;
  }

  public void setValorDescontoIcms(Double valorDescontoIcms) {
    this.valorDescontoIcms = valorDescontoIcms;
  }

//  public Integer getSituacaoTributariaIcms() {
//    return situacaoTributariaIcms;
//  }
//
//  public void setSituacaoTributariaIcms(Integer situacaoTributariaIcms) {
//    this.situacaoTributariaIcms = situacaoTributariaIcms;
//  }

//  public Integer getSituacaoTributariaIpi() {
//    return situacaoTributariaIpi;
//  }
//
//  public void setSituacaoTributariaIpi(Integer situacaoTributariaIpi) {
//    this.situacaoTributariaIpi = situacaoTributariaIpi;
//  }

  public Long getCdOperadora() {
    return cdOperadora;
  }

  public void setCdOperadora(Long cdOperadora) {
    this.cdOperadora = cdOperadora;
  }

  public String getFlPaciente() {
    return flPaciente;
  }

  public void setFlPaciente(String flPaciente) {
    this.flPaciente = flPaciente;
  }

  public Long getCdCustomerService() {
    return cdCustomerService;
  }

  public void setCdCustomerService(Long cdCustomerService) {
    this.cdCustomerService = cdCustomerService;
  }

  public String getNomeAssinadorCec() {
    return nomeAssinadorCec;
  }

  public void setNomeAssinadorCec(String nomeAssinadorCec) {
    this.nomeAssinadorCec = nomeAssinadorCec;
  }

  public String getRgAssinadorCec() {
    return rgAssinadorCec;
  }

  public void setRgAssinadorCec(String rgAssinadorCec) {
    this.rgAssinadorCec = rgAssinadorCec;
  }

  public Integer getTipoMovimentoIntegracao() {
    return tipoMovimentoIntegracao;
  }

  public void setTipoMovimentoIntegracao(Integer tipoMovimentoIntegracao) {
    this.tipoMovimentoIntegracao = tipoMovimentoIntegracao;
  }

  public String getSemPagto() {
    return semPagto;
  }

  public void setSemPagto(String semPagto) {
    this.semPagto = semPagto;
  }

  public String getFlPrecoAlterado() {
    return flPrecoAlterado;
  }

  public void setFlPrecoAlterado(String flPrecoAlterado) {
    this.flPrecoAlterado = flPrecoAlterado;
  }

  public String getNomeTipoPagamento() {
    return nomeTipoPagamento;
  }

  public void setNomeTipoPagamento(String nomeTipoPagamento) {
    this.nomeTipoPagamento = nomeTipoPagamento;
  }

  public Integer getStatusGravacaoJde() {
    return statusGravacaoJde;
  }

  public void setStatusGravacaoJde(Integer statusGravacaoJde) {
    this.statusGravacaoJde = statusGravacaoJde;
  }

  public String getMensagemGravacaoJde() {
    return mensagemGravacaoJde;
  }

  public void setMensagemGravacaoJde(String mensagemGravacaoJde) {
    this.mensagemGravacaoJde = mensagemGravacaoJde;
  }

  public Integer getStatusImpressaoCec() {
    return statusImpressaoCec;
  }

  public void setStatusImpressaoCec(Integer statusImpressaoCec) {
    this.statusImpressaoCec = statusImpressaoCec;
  }

  public Double getValorDesconto() {
    return valorDesconto;
  }

  public void setValorDesconto(Double valorDesconto) {
    this.valorDesconto = valorDesconto;
  }

  public Integer getStatusCec() {
    return statusCec;
  }

  public void setStatusCec(Integer statusCec) {
    this.statusCec = statusCec;
  }

  public String getNomeTransacao() {
    return nomeTransacao;
  }

  public void setNomeTransacao(String nomeTransacao) {
    this.nomeTransacao = nomeTransacao;
  }

  public String getNomeStatus() {
    return nomeStatus;
  }

  public void setNomeStatus(String nomeStatus) {
    this.nomeStatus = nomeStatus;
  }

  public String getNomeFormaImpressaoCec() {
    return nomeFormaImpressaoCec;
  }

  public void setNomeFormaImpressaoCec(String nomeFormaImpressaoCec) {
    this.nomeFormaImpressaoCec = nomeFormaImpressaoCec;
  }

  public String getNomeStatusCec() {
    return nomeStatusCec;
  }

  public void setNomeStatusCec(String nomeStatusCec) {
    this.nomeStatusCec = nomeStatusCec;
  }

  public String getNomeStatusImpressaoCec() {
    return nomeStatusImpressaoCec;
  }

  public void setNomeStatusImpressaoCec(String nomeStatusImpressaoCec) {
    this.nomeStatusImpressaoCec = nomeStatusImpressaoCec;
  }

  public String getAssinatura() {
    return assinatura;
  }

  public void setAssinatura(String assinatura) {
    this.assinatura = assinatura;
  }

  public List<InvoiceItem> getItens() {
    return itens;
  }

  public void setItens(List<InvoiceItem> itens) {
    this.itens = itens;
  }


}
