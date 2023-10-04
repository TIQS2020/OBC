package br.com.whitemartins.obc.model.sync;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "detalheNFe")
public class DetalheNFe {

  @Element(name = "num_nfe", required = false)
  private String numeroNota;

  @Element(name = "seq_num_nfe", required = false)
  private String sequencial;

  @Element(name = "cfop", required = false)
  private Integer cfop;

  @Element(name = "cd_nat_oper", required = false)
  private String naturezaOperacao;

  @Element(name = "nm_nat_oper", required = false)
  private String nomeNaturezaOperacao;

  @Element(name = "classif_fiscal", required = false)
  private String classificacaoFiscal;

  @Element(name = "cd_item", required = false)
  private String codigoItem;

  @Element(name = "nm_item", required = false)
  private String descricaoItem;

  @Element(name = "umc_item", required = false)
  private String unidadeMedidaComercial;

  @Element(name = "qtd_item", required = false)
  private Double quantidade;

  @Element(name = "cst_a_icms", required = false)
  private String codigoSituacaoTributariaIcmsA;

  @Element(name = "cst_b_icms", required = false)
  private String codigoSituacaoTributariaIcmsB;

  @Element(name = "cst_ipi", required = false)
  private String codigoSituacaoTributariaIpi;

  @Element(name = "cst_pis", required = false)
  private String codigoSituacaoTributariaPis;

  @Element(name = "cst_cofins", required = false)
  private String codigoSituacaoTributariaCofins;

  @Element(name = "vl_total", required = false)
  private Double valorTotal;

  @Element(name = "vl_base_icms", required = false)
  private Double valorBaseIcms;

  @Element(name = "vl_red_base_icms", required = false)
  private Double valorReducaoBaseIcms;

  @Element(name = "vl_icms_tribut", required = false)
  private Double valorTributadoIcms;

  @Element(name = "vl_dbt_icms", required = false)
  private Double valorDebitoIcms;

  @Element(name = "vl_cdt_icms", required = false)
  private Double valorCreditoIcms;

  @Element(name = "vl_base_icms_st", required = false)
  private Double valorBaseIcmsST;

  @Element(name = "vl_icms_st", required = false)
  private Double valorIcmsST;

  @Element(name = "vl_base_ipi", required = false)
  private Double valorBaseIpi;

  @Element(name = "vl_ipi_tribut", required = false)
  private Double valorTributadoIpi;

  @Element(name = "vl_dbt_ipi", required = false)
  private Double valorDebitoIpi;

  @Element(name = "vl_cdt_ipi", required = false)
  private Double valorCreditoIpi;

  @Element(name = "vl_base_pis", required = false)
  private Double valorBasePis;

  @Element(name = "vl_dbt_pis", required = false)
  private Double valorDebitoPis;

  @Element(name = "vl_base_cdt_pis", required = false)
  private Double valorBaseCreditoPis;

  @Element(name = "vl_cdt_pis", required = false)
  private Double valorCreditoPis;

  @Element(name = "vl_base_cofins", required = false)
  private Double valorBaseCofins;

  @Element(name = "vl_dbt_cofins", required = false)
  private Double valorDebitoCofins;

  @Element(name = "vl_base_cdt_cofins", required = false)
  private Double valorBaseCreditoCofins;

  @Element(name = "vl_cdt_cofins", required = false)
  private Double valorCreditoCofins;

  @Element(name = "aliq_icms", required = false)
  private Double aliquotaIcms;

  @Element(name = "aliq_ipi", required = false)
  private Double aliquotaIpi;

  @Element(name = "aliq_pis", required = false)
  private Double aliquotaPis;

  @Element(name = "aliq_cofins", required = false)
  private Double aliquotaCofins;

  @Element(name = "tipo_icms", required = false)
  private Integer tipoIcms;

  @Element(name = "tipo_ipi", required = false)
  private Integer tipoIpi;

  @Element(name = "tipo_pis", required = false)
  private Integer tipoPis;

  @Element(name = "tipo_cofins", required = false)
  private Integer tipoCofins;

  @Element(name = "vl_total_frete", required = false)
  private Double valorTotalFrete;

  @Element(name = "vl_total_seguro", required = false)
  private Double valorTotalSeguro;

  @Element(name = "vl_desconto", required = false)
  private Double valorDesconto;

  @Element(name = "vl_unitario", required = false)
  private Double valorUnitario;

  @Element(name = "vl_desp_acess", required = false)
  private Double valorOutrasDespesasAcessorias;

  @Element(name = "downloader_Detalhe")
  private DetalheDownloaderNFe detalheDownloaderNFe;

  public String getNumeroNota() {
    return numeroNota;
  }

  public void setNumeroNota(String numeroNota) {
    this.numeroNota = numeroNota;
  }

  public String getSequencial() {
    return sequencial;
  }

  public void setSequencial(String sequencial) {
    this.sequencial = sequencial;
  }

  public Integer getCfop() {
    return cfop;
  }

  public void setCfop(Integer cfop) {
    this.cfop = cfop;
  }

  public String getNaturezaOperacao() {
    return naturezaOperacao;
  }

  public void setNaturezaOperacao(String naturezaOperacao) {
    this.naturezaOperacao = naturezaOperacao;
  }

  public String getNomeNaturezaOperacao() {
    return nomeNaturezaOperacao;
  }

  public void setNomeNaturezaOperacao(String nomeNaturezaOperacao) {
    this.nomeNaturezaOperacao = nomeNaturezaOperacao;
  }

  public String getClassificacaoFiscal() {
    return classificacaoFiscal;
  }

  public void setClassificacaoFiscal(String classificacaoFiscal) {
    this.classificacaoFiscal = classificacaoFiscal;
  }

  public String getCodigoItem() {
    return codigoItem;
  }

  public void setCodigoItem(String codigoItem) {
    this.codigoItem = codigoItem;
  }

  public String getDescricaoItem() {
    return descricaoItem;
  }

  public void setDescricaoItem(String descricaoItem) {
    this.descricaoItem = descricaoItem;
  }

  public String getUnidadeMedidaComercial() {
    return unidadeMedidaComercial;
  }

  public void setUnidadeMedidaComercial(String unidadeMedidaComercial) {
    this.unidadeMedidaComercial = unidadeMedidaComercial;
  }

  public Double getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Double quantidade) {
    this.quantidade = quantidade;
  }

  public String getCodigoSituacaoTributariaIcmsA() {
    return codigoSituacaoTributariaIcmsA;
  }

  public void setCodigoSituacaoTributariaIcmsA(String codigoSituacaoTributariaIcmsA) {
    this.codigoSituacaoTributariaIcmsA = codigoSituacaoTributariaIcmsA;
  }

  public String getCodigoSituacaoTributariaIcmsB() {
    return codigoSituacaoTributariaIcmsB;
  }

  public void setCodigoSituacaoTributariaIcmsB(String codigoSituacaoTributariaIcmsB) {
    this.codigoSituacaoTributariaIcmsB = codigoSituacaoTributariaIcmsB;
  }

  public String getCodigoSituacaoTributariaIpi() {
    return codigoSituacaoTributariaIpi;
  }

  public void setCodigoSituacaoTributariaIpi(String codigoSituacaoTributariaIpi) {
    this.codigoSituacaoTributariaIpi = codigoSituacaoTributariaIpi;
  }

  public String getCodigoSituacaoTributariaPis() {
    return codigoSituacaoTributariaPis;
  }

  public void setCodigoSituacaoTributariaPis(String codigoSituacaoTributariaPis) {
    this.codigoSituacaoTributariaPis = codigoSituacaoTributariaPis;
  }

  public String getCodigoSituacaoTributariaCofins() {
    return codigoSituacaoTributariaCofins;
  }

  public void setCodigoSituacaoTributariaCofins(String codigoSituacaoTributariaCofins) {
    this.codigoSituacaoTributariaCofins = codigoSituacaoTributariaCofins;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Double getValorBaseIcms() {
    return valorBaseIcms;
  }

  public void setValorBaseIcms(Double valorBaseIcms) {
    this.valorBaseIcms = valorBaseIcms;
  }

  public Double getValorReducaoBaseIcms() {
    return valorReducaoBaseIcms;
  }

  public void setValorReducaoBaseIcms(Double valorReducaoBaseIcms) {
    this.valorReducaoBaseIcms = valorReducaoBaseIcms;
  }

  public Double getValorTributadoIcms() {
    return valorTributadoIcms;
  }

  public void setValorTributadoIcms(Double valorTributadoIcms) {
    this.valorTributadoIcms = valorTributadoIcms;
  }

  public Double getValorDebitoIcms() {
    return valorDebitoIcms;
  }

  public void setValorDebitoIcms(Double valorDebitoIcms) {
    this.valorDebitoIcms = valorDebitoIcms;
  }

  public Double getValorCreditoIcms() {
    return valorCreditoIcms;
  }

  public void setValorCreditoIcms(Double valorCreditoIcms) {
    this.valorCreditoIcms = valorCreditoIcms;
  }

  public Double getValorBaseIcmsST() {
    return valorBaseIcmsST;
  }

  public void setValorBaseIcmsST(Double valorBaseIcmsST) {
    this.valorBaseIcmsST = valorBaseIcmsST;
  }

  public Double getValorIcmsST() {
    return valorIcmsST;
  }

  public void setValorIcmsST(Double valorIcmsST) {
    this.valorIcmsST = valorIcmsST;
  }

  public Double getValorBaseIpi() {
    return valorBaseIpi;
  }

  public void setValorBaseIpi(Double valorBaseIpi) {
    this.valorBaseIpi = valorBaseIpi;
  }

  public Double getValorTributadoIpi() {
    return valorTributadoIpi;
  }

  public void setValorTributadoIpi(Double valorTributadoIpi) {
    this.valorTributadoIpi = valorTributadoIpi;
  }

  public Double getValorDebitoIpi() {
    return valorDebitoIpi;
  }

  public void setValorDebitoIpi(Double valorDebitoIpi) {
    this.valorDebitoIpi = valorDebitoIpi;
  }

  public Double getValorCreditoIpi() {
    return valorCreditoIpi;
  }

  public void setValorCreditoIpi(Double valorCreditoIpi) {
    this.valorCreditoIpi = valorCreditoIpi;
  }

  public Double getValorBasePis() {
    return valorBasePis;
  }

  public void setValorBasePis(Double valorBasePis) {
    this.valorBasePis = valorBasePis;
  }

  public Double getValorDebitoPis() {
    return valorDebitoPis;
  }

  public void setValorDebitoPis(Double valorDebitoPis) {
    this.valorDebitoPis = valorDebitoPis;
  }

  public Double getValorBaseCreditoPis() {
    return valorBaseCreditoPis;
  }

  public void setValorBaseCreditoPis(Double valorBaseCreditoPis) {
    this.valorBaseCreditoPis = valorBaseCreditoPis;
  }

  public Double getValorCreditoPis() {
    return valorCreditoPis;
  }

  public void setValorCreditoPis(Double valorCreditoPis) {
    this.valorCreditoPis = valorCreditoPis;
  }

  public Double getValorBaseCofins() {
    return valorBaseCofins;
  }

  public void setValorBaseCofins(Double valorBaseCofins) {
    this.valorBaseCofins = valorBaseCofins;
  }

  public Double getValorDebitoCofins() {
    return valorDebitoCofins;
  }

  public void setValorDebitoCofins(Double valorDebitoCofins) {
    this.valorDebitoCofins = valorDebitoCofins;
  }

  public Double getValorBaseCreditoCofins() {
    return valorBaseCreditoCofins;
  }

  public void setValorBaseCreditoCofins(Double valorBaseCreditoCofins) {
    this.valorBaseCreditoCofins = valorBaseCreditoCofins;
  }

  public Double getValorCreditoCofins() {
    return valorCreditoCofins;
  }

  public void setValorCreditoCofins(Double valorCreditoCofins) {
    this.valorCreditoCofins = valorCreditoCofins;
  }

  public Double getAliquotaIcms() {
    return aliquotaIcms;
  }

  public void setAliquotaIcms(Double aliquotaIcms) {
    this.aliquotaIcms = aliquotaIcms;
  }

  public Double getAliquotaIpi() {
    return aliquotaIpi;
  }

  public void setAliquotaIpi(Double aliquotaIpi) {
    this.aliquotaIpi = aliquotaIpi;
  }

  public Double getAliquotaPis() {
    return aliquotaPis;
  }

  public void setAliquotaPis(Double aliquotaPis) {
    this.aliquotaPis = aliquotaPis;
  }

  public Double getAliquotaCofins() {
    return aliquotaCofins;
  }

  public void setAliquotaCofins(Double aliquotaCofins) {
    this.aliquotaCofins = aliquotaCofins;
  }

  public Integer getTipoIcms() {
    return tipoIcms;
  }

  public void setTipoIcms(Integer tipoIcms) {
    this.tipoIcms = tipoIcms;
  }

  public Integer getTipoIpi() {
    return tipoIpi;
  }

  public void setTipoIpi(Integer tipoIpi) {
    this.tipoIpi = tipoIpi;
  }

  public Integer getTipoPis() {
    return tipoPis;
  }

  public void setTipoPis(Integer tipoPis) {
    this.tipoPis = tipoPis;
  }

  public Integer getTipoCofins() {
    return tipoCofins;
  }

  public void setTipoCofins(Integer tipoCofins) {
    this.tipoCofins = tipoCofins;
  }

  public Double getValorTotalFrete() {
    return valorTotalFrete;
  }

  public void setValorTotalFrete(Double valorTotalFrete) {
    this.valorTotalFrete = valorTotalFrete;
  }

  public Double getValorTotalSeguro() {
    return valorTotalSeguro;
  }

  public void setValorTotalSeguro(Double valorTotalSeguro) {
    this.valorTotalSeguro = valorTotalSeguro;
  }

  public Double getValorDesconto() {
    return valorDesconto;
  }

  public void setValorDesconto(Double valorDesconto) {
    this.valorDesconto = valorDesconto;
  }

  public Double getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public Double getValorOutrasDespesasAcessorias() {
    return valorOutrasDespesasAcessorias;
  }

  public void setValorOutrasDespesasAcessorias(Double valorOutrasDespesasAcessorias) {
    this.valorOutrasDespesasAcessorias = valorOutrasDespesasAcessorias;
  }

  public DetalheDownloaderNFe getDetalheDownloaderNFe() {
    return detalheDownloaderNFe;
  }

  public void setDetalheDownloaderNFe(DetalheDownloaderNFe detalheDownloaderNFe) {
    this.detalheDownloaderNFe = detalheDownloaderNFe;
  }

}