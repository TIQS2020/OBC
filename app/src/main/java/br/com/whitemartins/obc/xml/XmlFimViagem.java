package br.com.whitemartins.obc.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import br.com.whitemartins.obc.global.GLOBAL;

@Root(name = "obcFimViagem")
public class XmlFimViagem extends XmlBase {

  @Element(name = "codigoFilial", required = false)
  private String codigoFilial;
  @Element(name = "dataViagem", required = false)
  private String dataViagem;
  @Element(name = "numeroViagem", required = false)
  private Long numeroViagem;
  @Element(name = "indicadorViagemRefeita", required = false)
  private String flIndOriginalRefeita;
  @Element(name = "notasEmitidas", required = false)
  private String notas;
  @Element(name = "contagemFisica", required = false)
  private String contagemFisica;
  @Element(name = "contagemHC", required = false)
  private String contagemFisicaHC;
  @Element(name = "situacaoCarga", required = false)
  private String situacaoCarga;
  @Element(name = "movimentacoes", required = false)
  private String movimentacao;
  @Element(name = "movimentacoesHC", required = false)
  private String movimentacaoHc;
  @Element(name = "itemCompHC", required = false)
  private String itemComp;
  @Element(name = "daily", required = false)
  private String daily;
  @Element(name = "except", required = false)
  private String except;
  @Element(name = "talonario")
  private String talonario;

  public static XmlFimViagem newInstance() {
    return new XmlFimViagem();
  }

  public String getCodigoFilial() {
    return codigoFilial;
  }

  public void setCodigoFilial(String codigoFilial) {
    this.codigoFilial = codigoFilial;
  }

  public String getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(String dataViagem) {
    this.dataViagem = dataViagem;
  }

  public Long getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(Long numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public String getFlIndOriginalRefeita() {
    return flIndOriginalRefeita;
  }

  public void setFlIndOriginalRefeita(String flIndOriginalRefeita) {
    this.flIndOriginalRefeita = flIndOriginalRefeita;
  }

  public String getNotas() {
    return notas;
  }

  public void setNotas(String notas) {
    this.notas = notas;
  }

  public String getContagemFisica() {
    return contagemFisica;
  }

  public void setContagemFisica(String contagemFisica) {
    this.contagemFisica = contagemFisica;
  }

  public String getContagemFisicaHC() {
    return contagemFisicaHC;
  }

  public void setContagemFisicaHC(String contagemFisicaHC) {
    this.contagemFisicaHC = contagemFisicaHC;
  }

  public String getSituacaoCarga() {
    return situacaoCarga;
  }

  public void setSituacaoCarga(String situacaoCarga) {
    this.situacaoCarga = situacaoCarga;
  }

  public String getMovimentacao() {
    return movimentacao;
  }

  public void setMovimentacao(String movimentacao) {
    this.movimentacao = movimentacao;
  }

  public String getMovimentacaoHc() {
    return movimentacaoHc;
  }

  public void setMovimentacaoHc(String movimentacaoHc) {
    this.movimentacaoHc = movimentacaoHc;
  }

  public String getItemComp() {
    return itemComp;
  }

  public void setItemComp(String itemComp) {
    this.itemComp = itemComp;
  }

  public String getDaily() {
    return daily;
  }

  public void setDaily(String daily) {
    this.daily = daily;
  }

  public String getExcept() {
    return except;
  }

  public void setExcept(String except) {
    this.except = except;
  }

  public String getTalonario() {
    return talonario;
  }

  public void setTalonario(String talonario) {
    this.talonario = talonario;
  }


  @Override
  public String serialize() {
    codigoFilial = GLOBAL.self().getRoute().getCdFilialJde();
    flIndOriginalRefeita = GLOBAL.self().getGeneral().getFlIndOriginalRefeita();

    return super.serialize();
  }

}
