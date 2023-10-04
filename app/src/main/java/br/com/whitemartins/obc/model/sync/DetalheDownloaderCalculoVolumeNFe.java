package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "calculo_volume")
public class DetalheDownloaderCalculoVolumeNFe {

  @Element(name = "numeroWm", required = false)
  private Long numeroWm;
  @Element(name = "tipoCalculo", required = false)
  private Integer tipoCalculo;
  @Element(name = "pesoAntes", required = false)
  private Double pesoAntes;
  @Element(name = "pesoDepois", required = false)
  private Double pesoDepois;
  @Element(name = "numSerieTanque", required = false)
  private String numSerieTanque;
  @Element(name = "nivelAntes", required = false)
  private Double nivelAntes;
  @Element(name = "nivelDepois", required = false)
  private Double nivelDepois;
  @Element(name = "fatorConversao", required = false)
  private Double fatorConversao;
  @Element(name = "totalDescarga", required = false)
  private Double totalDescarga;
  @Element(name = "totalNFe", required = false)
  private Double totalNFe;
  @Element(name = "divergente", required = false)
  private String divergente;
  @Element(name = "totalCalculado", required = false)
  private Double totalCalculado;

  public DetalheDownloaderCalculoVolumeNFe() {
    super();
  }

  public Long getNumeroWm() {
    return numeroWm;
  }

  public void setNumeroWm(Long numeroWm) {
    this.numeroWm = numeroWm;
  }

  public Integer getTipoCalculo() {
    return tipoCalculo;
  }

  public void setTipoCalculo(Integer tipoCalculo) {
    this.tipoCalculo = tipoCalculo;
  }

  public Double getPesoAntes() {
    return pesoAntes;
  }

  public void setPesoAntes(Double pesoAntes) {
    this.pesoAntes = pesoAntes;
  }

  public Double getPesoDepois() {
    return pesoDepois;
  }

  public void setPesoDepois(Double pesoDepois) {
    this.pesoDepois = pesoDepois;
  }

  public String getNumSerieTanque() {
    return numSerieTanque;
  }

  public void setNumSerieTanque(String numSerieTanque) {
    this.numSerieTanque = numSerieTanque;
  }

  public Double getNivelAntes() {
    return nivelAntes;
  }

  public void setNivelAntes(Double nivelAntes) {
    this.nivelAntes = nivelAntes;
  }

  public Double getNivelDepois() {
    return nivelDepois;
  }

  public void setNivelDepois(Double nivelDepois) {
    this.nivelDepois = nivelDepois;
  }

  public Double getFatorConversao() {
    return fatorConversao;
  }

  public void setFatorConversao(Double fatorConversao) {
    this.fatorConversao = fatorConversao;
  }

  public Double getTotalDescarga() {
    return totalDescarga;
  }

  public void setTotalDescarga(Double totalDescarga) {
    this.totalDescarga = totalDescarga;
  }

  public Double getTotalNFe() {
    return totalNFe;
  }

  public void setTotalNFe(Double totalNFe) {
    this.totalNFe = totalNFe;
  }

  public String getDivergente() {
    return divergente;
  }

  public void setDivergente(String divergente) {
    this.divergente = divergente;
  }

  public Double getTotalCalculado() {
    return totalCalculado;
  }

  public void setTotalCalculado(Double totalCalculado) {
    this.totalCalculado = totalCalculado;
  }

  @Override
  public String toString() {
    return "DetalheDownloaderCalculoVolumeNFe [numeroWm="
      + numeroWm + ", tipoCalculo=" + tipoCalculo + ", pesoAntes="
      + pesoAntes + ", pesoDepois=" + pesoDepois
      + ", numSerieTanque=" + numSerieTanque + ", nivelAntes="
      + nivelAntes + ", nivelDepois=" + nivelDepois
      + ", fatorConversao=" + fatorConversao + ", totalDescarga="
      + totalDescarga + ", totalNFe=" + totalNFe + ", divergente="
      + divergente + ", totalCalculado=" + totalCalculado + "]";
  }


}
