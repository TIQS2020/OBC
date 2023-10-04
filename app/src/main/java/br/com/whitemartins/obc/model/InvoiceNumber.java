package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import br.com.whitemartins.obc.dao.InvoiceNumberDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
@FileInfo(lineLength = 68)
public class InvoiceNumber extends MockRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  @MappingIn(initialPos = 0, finalPos = 3)
  private Long numeroSerieEntrada;
  @MappingIn(initialPos = 3, finalPos = 4)
  private String tipoNotaEntrada;
  @PrimaryKey
  @MappingIn(initialPos = 4, finalPos = 12)
  private Long numeroNotaFiscalEntrada;
  @MappingIn(initialPos = 12, finalPos = 20)
  private Long numeroMaximoNFEntrada;
  @MappingIn(initialPos = 20, finalPos = 23)
  private Long numeroSerieSaida;
  @MappingIn(initialPos = 23, finalPos = 24)
  private String tipoNotaSaida;
  @MappingIn(initialPos = 24, finalPos = 32)
  private Long nuemroNotaFiscalSaida;
  @MappingIn(initialPos = 32, finalPos = 40)
  private Long numeroMaximoNFSaida;
  @MappingIn(initialPos = 40, finalPos = 41)
  private Long numeroLinhasEntrada;
  @MappingIn(initialPos = 41, finalPos = 42)
  private Long numeroLinhasSaida;

  public Long getNumeroSerieEntrada() {
    return numeroSerieEntrada;
  }

  public void setNumeroSerieEntrada(Long numeroSerieEntrada) {
    this.numeroSerieEntrada = numeroSerieEntrada;
  }

  public String getTipoNotaEntrada() {
    return tipoNotaEntrada;
  }

  public void setTipoNotaEntrada(String tipoNotaEntrada) {
    this.tipoNotaEntrada = tipoNotaEntrada;
  }

  public Long getNumeroNotaFiscalEntrada() {
    return numeroNotaFiscalEntrada;
  }

  public void setNumeroNotaFiscalEntrada(Long numeroNotaFiscalEntrada) {
    this.numeroNotaFiscalEntrada = numeroNotaFiscalEntrada;
  }

  public Long getNumeroMaximoNFEntrada() {
    return numeroMaximoNFEntrada;
  }

  public void setNumeroMaximoNFEntrada(Long numeroMaximoNFEntrada) {
    this.numeroMaximoNFEntrada = numeroMaximoNFEntrada;
  }

  public Long getNumeroSerieSaida() {
    return numeroSerieSaida;
  }

  public void setNumeroSerieSaida(Long numeroSerieSaida) {
    this.numeroSerieSaida = numeroSerieSaida;
  }

  public String getTipoNotaSaida() {
    return tipoNotaSaida;
  }

  public void setTipoNotaSaida(String tipoNotaSaida) {
    this.tipoNotaSaida = tipoNotaSaida;
  }

  public Long getNuemroNotaFiscalSaida() {
    return nuemroNotaFiscalSaida;
  }

  public void setNuemroNotaFiscalSaida(Long nuemroNotaFiscalSaida) {
    this.nuemroNotaFiscalSaida = nuemroNotaFiscalSaida;
  }

  public Long getNumeroMaximoNFSaida() {
    return numeroMaximoNFSaida;
  }

  public void setNumeroMaximoNFSaida(Long numeroMaximoNFSaida) {
    this.numeroMaximoNFSaida = numeroMaximoNFSaida;
  }

  public Long getNumeroLinhasEntrada() {
    return numeroLinhasEntrada;
  }

  public void setNumeroLinhasEntrada(Long numeroLinhasEntrada) {
    this.numeroLinhasEntrada = numeroLinhasEntrada;
  }

  public Long getNumeroLinhasSaida() {
    return numeroLinhasSaida;
  }

  public void setNumeroLinhasSaida(Long numeroLinhasSaida) {
    this.numeroLinhasSaida = numeroLinhasSaida;
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
    InvoiceNumberDao dao = DatabaseApp.self().getDatabase().invoiceNumberDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    InvoiceNumberDao dao = DatabaseApp.self().getDatabase().invoiceNumberDao();
    dao.deleteAll(dao.getAll());
  }
}
