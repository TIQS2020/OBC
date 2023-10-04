package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "downloader_Detalhe")
public class DetalheDownloaderNFe {

  @Element(name = "cd_ret_op", required = false)
  private String codigoRetornoOperacao;

  @Element(name = "fl_alt_preco", required = false)
  private String indicadorAlteracaoPreco;

  @Element(name = "vl_prc_unitario", required = false)
  private Double precoUnitario;

  @Element(name = "cond_pagamento", required = false)
  private String condicaoPagamento;

  @Element(name = "cd_movimento", required = false)
  private String codigoMovimento;

  @Element(name = "no_return_type", required = false)
  private String tipoRetorno;

  @Element(name = "no_item_capacity", required = false)
  private Double capacidadeItem;

  @Element(name = "no_qty_cyl_sold", required = false)
  private Double quantidadeCilindrosVendida;

  @Element(name = "no_qty_cyl_ordered", required = false)
  private Double quantidadeCilindrosPedida;

  @Element(name = "mn_list_price", required = false)
  private Double precoUnitarioOriginal;

  @Element(name = "mn_list_price_ext", required = false)
  private Double precoTotalOriginal;

  @Element(name = "mn_total_line_capa", required = false)
  private Double capacidadeTotalVendida;

  @Element(name = "inf_cil_pp", required = false)
  private InformacoesCilindroNFe informacoesCilindro;

  @Element(name = "tipo_faturamento", required = false)
  private String tipoFaturamento;

  @Element(name = "xped", required = false)
  private String xped;

  @Element(name = "nitemped", required = false)
  private String nitemped;

  //  @Element(name = "inf_lote_fab", required = false)
//  private InfLoteFabNFe infLote;

  @Element(name = "inf_lote_fab", required = false)
  private LoteFabFake infLotes;

  @Element(name = "at", required = false)
  private String assistenciaTecnica;

  @ElementList(name = "rastreabilidade", required = false, inline = true)
  private List<DadosRastreabilidadeNFe> dadosRastreabilidade;

  @ElementList(name = "inf_patrimonio", required = false, inline = true)
  private List<DetalheDownloaderInfPatrimonioNFe> detalheDownloaderInfPatrimonioNFes;

  @ElementList(name = "calculo_volume", required = false, inline = true)
  private List<DetalheDownloaderCalculoVolumeNFe> detalheDownloaderCalculoVolumeNFes;

  public DetalheDownloaderNFe() {
    dadosRastreabilidade = new ArrayList<>();
    detalheDownloaderInfPatrimonioNFes = new ArrayList<>();
    detalheDownloaderCalculoVolumeNFes = new ArrayList<>();
    //infLote.setLotes(new ArrayList<>());
  }

  public LoteFabFake getInfLotes() {
    return infLotes;
  }

  public void setInfLotes(LoteFabFake infLotes) {
    this.infLotes = infLotes;
  }

  public String getCodigoRetornoOperacao() {
    return codigoRetornoOperacao;
  }

  public void setCodigoRetornoOperacao(String codigoRetornoOperacao) {
    this.codigoRetornoOperacao = codigoRetornoOperacao;
  }

  public String getIndicadorAlteracaoPreco() {
    return indicadorAlteracaoPreco;
  }

  public void setIndicadorAlteracaoPreco(String indicadorAlteracaoPreco) {
    this.indicadorAlteracaoPreco = indicadorAlteracaoPreco;
  }

  public Double getPrecoUnitario() {
    return precoUnitario;
  }

  public void setPrecoUnitario(Double precoUnitario) {
    this.precoUnitario = precoUnitario;
  }

  public String getCondicaoPagamento() {
    return condicaoPagamento;
  }

  public void setCondicaoPagamento(String condicaoPagamento) {
    this.condicaoPagamento = condicaoPagamento;
  }

  public String getCodigoMovimento() {
    return codigoMovimento;
  }

  public void setCodigoMovimento(String codigoMovimento) {
    this.codigoMovimento = codigoMovimento;
  }

  public String getTipoRetorno() {
    return tipoRetorno;
  }

  public void setTipoRetorno(String tipoRetorno) {
    this.tipoRetorno = tipoRetorno;
  }

  public Double getCapacidadeItem() {
    return capacidadeItem;
  }

  public void setCapacidadeItem(Double capacidadeItem) {
    this.capacidadeItem = capacidadeItem;
  }

  public Double getQuantidadeCilindrosVendida() {
    return quantidadeCilindrosVendida;
  }

  public void setQuantidadeCilindrosVendida(Double quantidadeCilindrosVendida) {
    this.quantidadeCilindrosVendida = quantidadeCilindrosVendida;
  }

  public Double getQuantidadeCilindrosPedida() {
    return quantidadeCilindrosPedida;
  }

  public void setQuantidadeCilindrosPedida(Double quantidadeCilindrosPedida) {
    this.quantidadeCilindrosPedida = quantidadeCilindrosPedida;
  }

  public Double getPrecoUnitarioOriginal() {
    return precoUnitarioOriginal;
  }

  public void setPrecoUnitarioOriginal(Double precoUnitarioOriginal) {
    this.precoUnitarioOriginal = precoUnitarioOriginal;
  }

  public Double getPrecoTotalOriginal() {
    return precoTotalOriginal;
  }

  public void setPrecoTotalOriginal(Double precoTotalOriginal) {
    this.precoTotalOriginal = precoTotalOriginal;
  }

  public Double getCapacidadeTotalVendida() {
    return capacidadeTotalVendida;
  }

  public void setCapacidadeTotalVendida(Double capacidadeTotalVendida) {
    this.capacidadeTotalVendida = capacidadeTotalVendida;
  }

  public InformacoesCilindroNFe getInformacoesCilindro() {
    return informacoesCilindro;
  }

  public void setInformacoesCilindro(InformacoesCilindroNFe informacoesCilindro) {
    this.informacoesCilindro = informacoesCilindro;
  }

  public List<DadosRastreabilidadeNFe> getDadosRastreabilidade() {
    return dadosRastreabilidade;
  }

  public void setDadosRastreabilidade(List<DadosRastreabilidadeNFe> dadosRastreabilidade) {
    this.dadosRastreabilidade = dadosRastreabilidade;
  }

  public String getTipoFaturamento() {
    return tipoFaturamento;
  }

  public void setTipoFaturamento(String tipoFaturamento) {
    this.tipoFaturamento = tipoFaturamento;
  }

  public String getXped() {
    return xped;
  }

  public void setXped(String xped) {
    this.xped = xped;
  }

  public String getNitemped() {
    return nitemped;
  }

  public void setNitemped(String nitemped) {
    this.nitemped = nitemped;
  }

//  public InfLoteFabNFe getInfLote() {
//    return infLote;
//  }
//
//  public void setInfLote(InfLoteFabNFe infLote) {
//    this.infLote = infLote;
//  }

  public String getAssistenciaTecnica() {
    return assistenciaTecnica;
  }

  public void setAssistenciaTecnica(String assistenciaTecnica) {
    this.assistenciaTecnica = assistenciaTecnica;
  }

  public List<DetalheDownloaderInfPatrimonioNFe> getDetalheDownloaderInfPatrimonioNFes() {
    return detalheDownloaderInfPatrimonioNFes;
  }

  public void setDetalheDownloaderInfPatrimonioNFes(List<DetalheDownloaderInfPatrimonioNFe> detalheDownloaderInfPatrimonioNFes) {
    this.detalheDownloaderInfPatrimonioNFes = detalheDownloaderInfPatrimonioNFes;
  }

  public List<DetalheDownloaderCalculoVolumeNFe> getDetalheDownloaderCalculoVolumeNFes() {
    return detalheDownloaderCalculoVolumeNFes;
  }

  public void setDetalheDownloaderCalculoVolumeNFes(List<DetalheDownloaderCalculoVolumeNFe> detalheDownloaderCalculoVolumeNFes) {
    this.detalheDownloaderCalculoVolumeNFes = detalheDownloaderCalculoVolumeNFes;
  }
}