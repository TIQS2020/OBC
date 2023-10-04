package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
public class Abastecimento extends MockRecord implements Serializable {
  public static final long serialVersionUID = 1L;

  @PrimaryKey
  private Integer codigo;
  private Long numWM;
  private Long cdCustomer;
  private String numeroSerieTanque;
  private Double capacidadeKG;
  private Double capacidadePol;
  private Double fatorConversao;
  private Double pesoAntes;
  private Double pesoDepois;
  private Double nivelAntes;
  private Double nivelDepois;
  private Double totalDescarga;
  private Double totalCalulado;
  private Double totalNfe;
  private String divergente;
  private Integer tipoCalculo;
  private Long idNota;

  public static Abastecimento newInstance() {
    return new Abastecimento();
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public Long getNumWM() {
    return numWM;
  }

  public void setNumWM(Long numWM) {
    this.numWM = numWM;
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getNumeroSerieTanque() {
    return numeroSerieTanque;
  }

  public void setNumeroSerieTanque(String numeroSerieTanque) {
    this.numeroSerieTanque = numeroSerieTanque;
  }

  public Double getCapacidadeKG() {
    return capacidadeKG;
  }

  public void setCapacidadeKG(Double capacidadeKG) {
    this.capacidadeKG = capacidadeKG;
  }

  public Double getCapacidadePol() {
    return capacidadePol;
  }

  public void setCapacidadePol(Double capacidadePol) {
    this.capacidadePol = capacidadePol;
  }

  public Double getFatorConversao() {
    return fatorConversao;
  }

  public void setFatorConversao(Double fatorConversao) {
    this.fatorConversao = fatorConversao;
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

  public Double getTotalDescarga() {
    return totalDescarga;
  }

  public void setTotalDescarga(Double totalDescarga) {
    this.totalDescarga = totalDescarga;
  }

  public Double getTotalCalulado() {
    return totalCalulado;
  }

  public void setTotalCalulado(Double totalCalulado) {
    this.totalCalulado = totalCalulado;
  }

  public Double getTotalNfe() {
    return totalNfe;
  }

  public void setTotalNfe(Double totalNfe) {
    this.totalNfe = totalNfe;
  }

  public String getDivergente() {
    return divergente;
  }

  public void setDivergente(String divergente) {
    this.divergente = divergente;
  }

  public Integer getTipoCalculo() {
    return tipoCalculo;
  }

  public void setTipoCalculo(Integer tipoCalculo) {
    this.tipoCalculo = tipoCalculo;
  }

  public Long getIdNota() {
    return idNota;
  }

  public void setIdNota(Long idNota) {
    this.idNota = idNota;
  }

  @Override
  public void parseLine(String line) {

  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    if (isValid())
      DatabaseApp.self().getDatabase().abastecimentoDao().insert(this);
  }

  @Override
  public void deleteAll() {
    DatabaseApp.self().getDatabase().abastecimentoDao()
      .deleteAll(DatabaseApp.self().getDatabase().abastecimentoDao().getAll());
  }
}
