package br.com.whitemartins.obc.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import br.com.whitemartins.obc.dao.AssetDao;
import br.com.whitemartins.obc.dao.InvoiceItemDao;
import br.com.whitemartins.obc.dao.LotePatrimonioDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.LotePatrimonioType;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity(primaryKeys = {"idNota", "cdItem", "capacidade"})
public class InvoiceItem extends MockRecord implements Serializable {

  private static final String NODE_DETALHE_NAME = "detalheNFe";
  private static final String NODE_DOWNLOADER_DETALHE_NAME = "downloader_Detalhe";

  @NonNull
  //@XmlMapping(xmlTagName = "seq_num_nfe", xmlParentTagName = NODE_DETALHE_NAME)
  private Long idNota;
  @XmlMapping(xmlTagName = "num_nfe", xmlParentTagName = NODE_DETALHE_NAME)
  private Long numeroNota;
  private Long serieNota;
  @XmlMapping(xmlTagName = "cfop", xmlParentTagName = NODE_DETALHE_NAME)
  private Integer cfop;
  @XmlMapping(xmlTagName = "seq_num_nfe", xmlParentTagName = NODE_DETALHE_NAME)
  private Long seqItem;
  @NonNull
  @XmlMapping(xmlTagName = "cd_item", xmlParentTagName = NODE_DETALHE_NAME)
  private Long cdItem;
  @NonNull
  @XmlMapping(xmlTagName = "no_item_capacity", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private Double capacidade;
  @XmlMapping(xmlTagName = "nm_item", xmlParentTagName = NODE_DETALHE_NAME)
  private String nomeItem;
  @XmlMapping(xmlTagName = "qtd_item", xmlParentTagName = NODE_DETALHE_NAME)
  private Double qtdItem;
  //  @XmlMapping(xmlTagName = "qtd_volume", xmlParentTagName = NODE_DETALHE_NAME)
  private Double volume;
  @XmlMapping(xmlTagName = "umc_item", xmlParentTagName = NODE_DETALHE_NAME)
  private String unidadeMedida;
  @XmlMapping(xmlTagName = "cd_nat_oper", xmlParentTagName = NODE_DETALHE_NAME)
  private String naturezaOperacao;
  @XmlMapping(xmlTagName = "nm_nat_oper", xmlParentTagName = NODE_DETALHE_NAME)
  private String nomeNaturezaOperacao;
  @XmlMapping(xmlTagName = "classif_fiscal", xmlParentTagName = NODE_DETALHE_NAME)
  private Long classifFiscal;
  @XmlMapping(xmlTagName = "cst_a_icms", xmlParentTagName = NODE_DETALHE_NAME)
  private String cstAIcms;
  @XmlMapping(xmlTagName = "cst_b_icms", xmlParentTagName = NODE_DETALHE_NAME)
  private String cstBIcms;
  @XmlMapping(xmlTagName = "cst_ipi", xmlParentTagName = NODE_DETALHE_NAME)
  private String cstIpi;
  @XmlMapping(xmlTagName = "cst_pis", xmlParentTagName = NODE_DETALHE_NAME)
  private String cstPis;
  @XmlMapping(xmlTagName = "cst_cofins", xmlParentTagName = NODE_DETALHE_NAME)
  private String cstCofins;
  @XmlMapping(xmlTagName = "vl_total", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorTotal;
  @XmlMapping(xmlTagName = "vl_base_icms", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorBaseIcms;
  @XmlMapping(xmlTagName = "vl_red_base_icms", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorBaseReduzidaIcms;
  @XmlMapping(xmlTagName = "vl_icms_tribut", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorIcms;
  @XmlMapping(xmlTagName = "vl_dbt_icms", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorDebitoIcms;
  @XmlMapping(xmlTagName = "vl_cdt_icms", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorCreditoIcms;
  @XmlMapping(xmlTagName = "vl_base_icms_st", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorBaseIcmsSt;
  @XmlMapping(xmlTagName = "vl_icms_st", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorIcmsSt;
  @XmlMapping(xmlTagName = "vl_base_ipi", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorBaseIpi;
  @XmlMapping(xmlTagName = "vl_ipi_tribut", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorIpi;
  @XmlMapping(xmlTagName = "vl_dbt_ipi", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorDebitoIpi;
  @XmlMapping(xmlTagName = "vl_cdt_ipi", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorCreditoIpi;
  @XmlMapping(xmlTagName = "vl_base_pis", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorBasePis;
  @XmlMapping(xmlTagName = "vl_dbt_pis", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorDebitoPis;
  @XmlMapping(xmlTagName = "vl_base_cdt_pis", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorBaseCreditoPis;
  @XmlMapping(xmlTagName = "vl_cdt_pis", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorCreditoPis;
  @XmlMapping(xmlTagName = "vl_base_cofins", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorBaseCofins;
  @XmlMapping(xmlTagName = "vl_dbt_cofins", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorDebitoCofins;
  @XmlMapping(xmlTagName = "vl_base_cdt_cofins", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorBaseCreditoCofins;
  @XmlMapping(xmlTagName = "vl_cdt_cofins", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorCreditoCofins;
  @XmlMapping(xmlTagName = "aliq_icms", xmlParentTagName = NODE_DETALHE_NAME)
  private Double aliquotaIcms;
  @XmlMapping(xmlTagName = "aliq_ipi", xmlParentTagName = NODE_DETALHE_NAME)
  private Double aliquotaIpi;
  @XmlMapping(xmlTagName = "aliq_pis", xmlParentTagName = NODE_DETALHE_NAME)
  private Double aliquotaPis;
  @XmlMapping(xmlTagName = "aliq_cofins", xmlParentTagName = NODE_DETALHE_NAME)
  private Double aliquotaCofins;
  @XmlMapping(xmlTagName = "tipo_icms", xmlParentTagName = NODE_DETALHE_NAME)
  private Integer tipoIcms;
  @XmlMapping(xmlTagName = "tipo_ipi", xmlParentTagName = NODE_DETALHE_NAME)
  private Integer tipoIpi;
  @XmlMapping(xmlTagName = "tipo_pis", xmlParentTagName = NODE_DETALHE_NAME)
  private Integer tipoPis;
  @XmlMapping(xmlTagName = "tipo_cofins", xmlParentTagName = NODE_DETALHE_NAME)
  private Integer tipoCofins;
  @XmlMapping(xmlTagName = "vl_total_frete", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorTotalFrete;
  @XmlMapping(xmlTagName = "vl_total_seguro", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorTotalSeguro;
  @XmlMapping(xmlTagName = "vl_desconto", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorDescontoIcms;
  @XmlMapping(xmlTagName = "vl_unitario", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorUnitario; //2 casas decimais
  @XmlMapping(xmlTagName = "vl_desp_acess", xmlParentTagName = NODE_DETALHE_NAME)
  private Double valorDespesasAcessorias; //2 casas decimais
  @XmlMapping(xmlTagName = "fl_alt_preco", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String flPrecoAlterado;
  @XmlMapping(xmlTagName = "vl_prc_unitario", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private Double valorPrecoUnitarioOriginal;//4 casas decimais
  @XmlMapping(xmlTagName = "inf_cil_pp", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String infCilPP;
  @XmlMapping(xmlTagName = "cond_pagamento", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String condicaoPagamento;
  @XmlMapping(xmlTagName = "cd_movimento", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String cdMovimento;
  @XmlMapping(xmlTagName = "no_return_type", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private Integer returnType;
  @XmlMapping(xmlTagName = "cd_ret_op", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String returnCode;
  @XmlMapping(xmlTagName = "no_qty_cyl_sold", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private Double quantidadeCilindroVendida;
  @XmlMapping(xmlTagName = "no_qty_cyl_ordered", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private Double quantidadeCilindroPedida;
  @XmlMapping(xmlTagName = "xped", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String pedidoCustomer;
  @XmlMapping(xmlTagName = "nitemped", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String itemPedidoCustomer;
  @XmlMapping(xmlTagName = "tipo_faturamento", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String tipoFaturamento;
  @XmlMapping(xmlTagName = "at", xmlParentTagName = NODE_DOWNLOADER_DETALHE_NAME)
  private String flAssistenciaTecnica;
  private Integer tipoItem;

  @Ignore
  private List<Rastreabilidade> rastreabilidades;

  public InvoiceItem() {
    returnType = 0;
    flPrecoAlterado = ConstantsEnum.NO.getValue();
    flAssistenciaTecnica = ConstantsEnum.NO.getValue();
    pedidoCustomer = "";
    itemPedidoCustomer = "";
    infCilPP = "";

    valorIpi = 0D;
    valorBaseIpi = 0D;
    valorCreditoIpi = 0D;
    valorDebitoIpi = 0D;

    valorIcms = 0D;
    valorIcmsSt = 0D;
    valorBaseIcms = 0D;
    valorCreditoIcms = 0D;
    valorDebitoIcms = 0D;
    valorDescontoIcms = 0D;
    valorBaseIcmsSt = 0D;

    valorBaseCofins = 0D;
    valorBaseCreditoCofins = 0D;
    valorDebitoCofins = 0D;
    valorBaseCreditoCofins = 0D;
    valorCreditoCofins = 0D;

    valorBaseCreditoPis = 0D;
    valorBasePis = 0D;
    valorCreditoPis = 0D;
    valorDebitoPis = 0D;
  }

  public static InvoiceItem newInstance() {
    return new InvoiceItem();
  }

  @NonNull
  public Long getIdNota() {
    return idNota;
  }

  public void setIdNota(@NonNull Long idNota) {
    this.idNota = idNota;
  }

  public Long getNumeroNota() {
    return numeroNota;
  }

  public void setNumeroNota(Long numeroNota) {
    this.numeroNota = numeroNota;
  }

  public Long getSerieNota() {
    return serieNota;
  }

  public void setSerieNota(Long serieNota) {
    this.serieNota = serieNota;
  }

  public Integer getCfop() {
    return cfop;
  }

  public void setCfop(Integer cfop) {
    this.cfop = cfop;
  }

  @NonNull
  public Long getSeqItem() {
    return seqItem;
  }

  public void setSeqItem(@NonNull Long seqItem) {
    this.seqItem = seqItem;
  }

  @NonNull
  public Long getCdItem() {
    return cdItem;
  }

  public void setCdItem(@NonNull Long cdItem) {
    this.cdItem = cdItem;
  }

  @NonNull
  public Double getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(@NonNull Double capacidade) {
    this.capacidade = capacidade;
  }

  public String getNomeItem() {
    if (nomeItem == null)
      nomeItem = "";
    return nomeItem;
  }

  public void setNomeItem(String nomeItem) {
    this.nomeItem = nomeItem;
  }

  public Double getQtdItem() {
    return qtdItem;
  }

  public void setQtdItem(Double qtdItem) {
    this.qtdItem = qtdItem;
  }

  public Double getVolume() {
    return volume;
  }

  public void setVolume(Double volume) {
    this.volume = volume;
  }

  public String getUnidadeMedida() {
    if (unidadeMedida == null)
      unidadeMedida = "";
    return unidadeMedida;
  }

  public void setUnidadeMedida(String unidadeMedida) {
    this.unidadeMedida = unidadeMedida;
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

  public Long getClassifFiscal() {
    return classifFiscal;
  }

  public void setClassifFiscal(Long classifFiscal) {
    this.classifFiscal = classifFiscal;
  }

  public String getCstAIcms() {
    return cstAIcms;
  }

  public void setCstAIcms(String cstAIcms) {
    this.cstAIcms = cstAIcms;
  }

  public String getCstBIcms() {
    return cstBIcms;
  }

  public void setCstBIcms(String cstBIcms) {
    this.cstBIcms = cstBIcms;
  }

  public String getCstIpi() {
    return cstIpi;
  }

  public void setCstIpi(String cstIpi) {
    this.cstIpi = cstIpi;
  }

  public String getCstPis() {
    return cstPis;
  }

  public void setCstPis(String cstPis) {
    this.cstPis = cstPis;
  }

  public String getCstCofins() {
    return cstCofins;
  }

  public void setCstCofins(String cstCofins) {
    this.cstCofins = cstCofins;
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

  public Double getValorBaseReduzidaIcms() {
    return valorBaseReduzidaIcms;
  }

  public void setValorBaseReduzidaIcms(Double valorBaseReduzidaIcms) {
    this.valorBaseReduzidaIcms = valorBaseReduzidaIcms;
  }

  public Double getValorIcms() {
    return valorIcms;
  }

  public void setValorIcms(Double valorIcms) {
    this.valorIcms = valorIcms;
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

  public Double getValorBaseIcmsSt() {
    return valorBaseIcmsSt;
  }

  public void setValorBaseIcmsSt(Double valorBaseIcmsSt) {
    this.valorBaseIcmsSt = valorBaseIcmsSt;
  }

  public Double getValorIcmsSt() {
    return valorIcmsSt;
  }

  public void setValorIcmsSt(Double valorIcmsSt) {
    this.valorIcmsSt = valorIcmsSt;
  }

  public Double getValorBaseIpi() {
    return valorBaseIpi;
  }

  public void setValorBaseIpi(Double valorBaseIpi) {
    this.valorBaseIpi = valorBaseIpi;
  }

  public Double getValorIpi() {
    return valorIpi;
  }

  public void setValorIpi(Double valorIpi) {
    this.valorIpi = valorIpi;
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

  public Double getValorDescontoIcms() {
    return valorDescontoIcms;
  }

  public void setValorDescontoIcms(Double valorDescontoIcms) {
    this.valorDescontoIcms = valorDescontoIcms;
  }

  public Double getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(Double valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public Double getValorDespesasAcessorias() {
    return valorDespesasAcessorias;
  }

  public void setValorDespesasAcessorias(Double valorDespesasAcessorias) {
    this.valorDespesasAcessorias = valorDespesasAcessorias;
  }

  public String getFlPrecoAlterado() {
    return flPrecoAlterado;
  }

  public void setFlPrecoAlterado(String flPrecoAlterado) {
    this.flPrecoAlterado = flPrecoAlterado;
  }

  public Double getValorPrecoUnitarioOriginal() {
    return valorPrecoUnitarioOriginal;
  }

  public void setValorPrecoUnitarioOriginal(Double valorPrecoUnitarioOriginal) {
    this.valorPrecoUnitarioOriginal = valorPrecoUnitarioOriginal;
  }

  public String getInfCilPP() {
    return infCilPP;
  }

  public void setInfCilPP(String infCilPP) {
    this.infCilPP = infCilPP;
  }

  public String getCondicaoPagamento() {
    return condicaoPagamento;
  }

  public void setCondicaoPagamento(String condicaoPagamento) {
    this.condicaoPagamento = condicaoPagamento;
  }

  public String getCdMovimento() {
    return cdMovimento;
  }

  public void setCdMovimento(String cdMovimento) {
    this.cdMovimento = cdMovimento;
  }

  public Integer getReturnType() {
    return returnType;
  }

  public void setReturnType(Integer returnType) {
    this.returnType = returnType;
  }

  public String getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(String returnCode) {
    this.returnCode = returnCode;
  }

  public Double getQuantidadeCilindroVendida() {
    return quantidadeCilindroVendida;
  }

  public void setQuantidadeCilindroVendida(Double quantidadeCilindroVendida) {
    this.quantidadeCilindroVendida = quantidadeCilindroVendida;
  }

  public Double getQuantidadeCilindroPedida() {
    return quantidadeCilindroPedida;
  }

  public void setQuantidadeCilindroPedida(Double quantidadeCilindroPedida) {
    this.quantidadeCilindroPedida = quantidadeCilindroPedida;
  }

  public String getPedidoCustomer() {
    return pedidoCustomer;
  }

  public void setPedidoCustomer(String pedidoCustomer) {
    this.pedidoCustomer = pedidoCustomer;
  }

  public String getItemPedidoCustomer() {
    return itemPedidoCustomer;
  }

  public void setItemPedidoCustomer(String itemPedidoCustomer) {
    this.itemPedidoCustomer = itemPedidoCustomer;
  }

  public String getTipoFaturamento() {
    return tipoFaturamento;
  }

  public void setTipoFaturamento(String tipoFaturamento) {
    this.tipoFaturamento = tipoFaturamento;
  }

  public String getFlAssistenciaTecnica() {
    return flAssistenciaTecnica;
  }

  public void setFlAssistenciaTecnica(String flAssistenciaTecnica) {
    this.flAssistenciaTecnica = flAssistenciaTecnica;
  }

  public Integer getTipoItem() {
    return tipoItem;
  }

  public void setTipoItem(Integer tipoItem) {
    this.tipoItem = tipoItem;
  }

  public List<Rastreabilidade> getRastreabilidades() {
    return rastreabilidades;
  }

  public void setRastreabilidades(List<Rastreabilidade> rastreabilidades) {
    this.rastreabilidades = rastreabilidades;
  }

  @Override
  public void parseLine(String line) {

  }

  @Override
  public void deleteAll() {
    DatabaseApp.self().getDatabase().invoiceItemDao()
      .deleteAll(DatabaseApp.self().getDatabase().invoiceItemDao().getAll());
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    try {
      InvoiceItemDao invoiceItemDao = DatabaseApp.self().getDatabase().invoiceItemDao();
      invoiceItemDao.insert(this);
    } catch (Exception e) {
      throw e;
    }
  }

  public Document createXml(Document parentDocument, Element rootElment) {
    try {
      Element detalheElement = parentDocument.createElement("detalheNFe");
      rootElment.appendChild(detalheElement);

      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);

          Object value = field.get(this);

          if (value == null)
            value = "";

          if (field.getGenericType().equals(Date.class)) {
            if (!value.toString().isEmpty()) {
              Date d = new Date(value.toString());
              value = UtilHelper.formatDateStr(d, annotation.dateFormat());
            }
          }

          if (detalheElement.getNodeName().equalsIgnoreCase(annotation.xmlParentTagName()))
            XmlConfig.createNode(parentDocument, detalheElement, annotation.xmlTagName(),
              value.toString());
          else {
            NodeList nodes = detalheElement.getElementsByTagName(annotation.xmlParentTagName());

            Element parentElement;

            if (nodes.getLength() == 0) {
              parentElement = parentDocument.createElement(annotation.xmlParentTagName());
              detalheElement.appendChild(parentElement);
            } else
              parentElement = (Element) nodes.item(nodes.getLength() - 1);

            XmlConfig.createNode(parentDocument, parentElement, annotation.xmlTagName(),
              value.toString());

            if (field.getName().equalsIgnoreCase("infCilPP"))
              createInfPP(parentDocument, "inf_cil_pp",
                value.toString()
              );
          }
        }
      }

      for (Rastreabilidade rastreabilidade : rastreabilidades) {
        rastreabilidade.createXml(parentDocument, detalheElement);
      }

      //Criando o Lote/Patrimonio da Nota fiscal
      LotePatrimonioDao lotePatrimonioDao = DatabaseApp.self().getDatabase().lotePatrimonioDao();
      List<LotePatrimonio> lotePatrimonios = lotePatrimonioDao.find(getIdNota(), getCdItem(),
        getCapacidade());

      Element infLoteFabElement = null;

      if (!lotePatrimonios.isEmpty())
        infLoteFabElement = createInfLoteFab(parentDocument, detalheElement);

      AssetDao assetDao = DatabaseApp.self().getDatabase().assetDao();

      for (LotePatrimonio lotePatrimonio : lotePatrimonios) {
        Asset asset;

        if (lotePatrimonio.getTipo().equals(LotePatrimonioType.LOTE.getValue()))
          parentDocument = lotePatrimonio.createXmlLote(parentDocument, infLoteFabElement);
        else {
          asset = assetDao.findByNumeroPatrimonio(lotePatrimonio.getNumeroLote().toString());

          if (asset == null) {
            asset = Asset.newInstace();
            asset.setNumeroPatrimonio(lotePatrimonio.getNumeroLote().toString());
          }

          asset.createXml(parentDocument, detalheElement);
        }
      }

    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }

    return parentDocument;
  }

  private void createInfPP(Document document, String parentNodeName, String cilPpValue) {

    StringBuilder sb = new StringBuilder();
    sb.append(cilPpValue);

    Element nfeElement = document.getDocumentElement();

    NodeList nodes = nfeElement.getElementsByTagName(parentNodeName);

    Element cilPP = (Element) nodes.item(nodes.getLength() - 1);

    while (!"".equals(sb.toString())) {

      if (!sb.toString().substring(0, 15).trim().isEmpty())
        XmlConfig.createNode(document, cilPP, "num_serie_cil_pp",
          sb.toString().substring(0, 15));

      sb = sb.delete(0, 15);
    }
  }

  private Element createInfLoteFab(Document document, Element documentElement) {

    Element downloaderDetalhe = (Element) documentElement.getElementsByTagName("downloader_Detalhe").item(0);
    Element parentElement;

    parentElement = document.createElement("inf_lote_fab");
    downloaderDetalhe.appendChild(parentElement);
    return parentElement;
  }

}
