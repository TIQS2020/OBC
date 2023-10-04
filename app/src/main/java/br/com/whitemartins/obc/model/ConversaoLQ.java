package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Locale;

import br.com.whitemartins.obc.dao.ConversionLQDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity(primaryKeys = {"cdJDECliente", "numeroSerieTanque"})
@FileInfo(lineLength = 128)
public class ConversaoLQ extends MockRecord implements Serializable {

  public static final Long serialVersionUID = 1L;

  @MappingIn(initialPos = 0, finalPos = 5)
  private Long numeroWM;
  @NonNull
  @MappingIn(initialPos = 5, finalPos = 13)
  private Long cdJDECliente;
  @NonNull
  @MappingIn(initialPos = 13, finalPos = 38)
  private String numeroSerieTanque;
  @MappingIn(initialPos = 38, finalPos = 53, decimals = 2)
  private Double capacidadeKG;
  @MappingIn(initialPos = 53, finalPos = 68, decimals = 2)
  private Double capacidadePol;
  @MappingIn(initialPos = 68, finalPos = 78, decimals = 2)
  private Double fatorConversao;
  @Ignore
  private Double pesoAntes;
  @Ignore
  private Double pesoDepois;
  @Ignore
  private Double diferenca;
  @Ignore
  private Double totalDescarga;

  public ConversaoLQ() {
    pesoAntes = 0D;
    pesoDepois = 0D;
    diferenca = 0D;
    totalDescarga = 0D;
  }

  public static ConversaoLQ newInstance() {
    return new ConversaoLQ();
  }

  public Long getNumeroWM() {
    return numeroWM;
  }

  public void setNumeroWM(Long numeroWM) {
    this.numeroWM = numeroWM;
  }

  public Long getCdJDECliente() {
    return cdJDECliente;
  }

  public void setCdJDECliente(Long cdJDECliente) {
    this.cdJDECliente = cdJDECliente;
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

  public Double getDiferenca() {
    return diferenca;
  }

  public void setDiferenca(Double diferenca) {
    this.diferenca = diferenca;
  }

  public Double getTotalDescarga() {
    return totalDescarga;
  }

  public void setTotalDescarga(Double totalDescarga) {
    this.totalDescarga = totalDescarga;
  }

  @Override
  public void parseLine(String line) {
    this.automaticParseIn(line);
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    ConversionLQDao dao = DatabaseApp.self().getDatabase().conversionLQDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    ConversionLQDao dao = DatabaseApp.self().getDatabase().conversionLQDao();
    dao.deleteAll(dao.getAll());
  }

  @Override
  public String toString() {
    return String.format(Locale.getDefault(), "%s %s %s %s %s",
      UtilHelper.padRight(numeroSerieTanque, ' ', 6),
      UtilHelper.padLeft(pesoAntes.toString(), ' ', 8),
      UtilHelper.padLeft(pesoDepois.toString(), ' ', 8),
      UtilHelper.padLeft(diferenca.toString(), ' ', 8),
      UtilHelper.padLeft(totalDescarga.toString(), ' ', 8));
  }
}
