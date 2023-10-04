package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.Nonnull;

import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity(primaryKeys = {"numeroViagem", "cdItem", "capacidade"})
public class Saldo extends MockRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  @NonNull
  private Long numeroViagem;
  @NonNull
  private Long cdItem;
  @NonNull
  private Double capacidade;
  private String nomeItem;
  private Integer tipoItem;
  private String tipoPropriedade;
  private Double qtdCarregadaCheios;
  private Double qtdCarregadaVazios;
  private Double qtdAtualCheios;
  private Double qtdAtualVazios;
  private Double qtdCheiosCont;
  private Double qtdVaziosCont;
  private Double qtdVendidos;
  private Double qtdAplicados;
  private Double qtdRecolhidos;
  private Double qtdAplicadosHC;
  private Double qtdRecolhidosHC;
  private Double qtdAplicadosHCCont;
  private Double qtdRecolhidosHCCont;
  private Double qtdTrocados;
  private Double qtdTransferidos;
  private Double qtdComplementados;
  private Double qtdDescarregados;


  public Saldo() {
    cdItem = 0L;
    capacidade = 0D;
    nomeItem = "";
    qtdCarregadaCheios = 0D;
    qtdCarregadaVazios = 0D;
    qtdVendidos = 0D;
    qtdAplicadosHC = 0D;
    qtdAplicadosHCCont = 0D;
    qtdAplicados = 0D;
    qtdRecolhidos = 0D;
    qtdRecolhidosHC = 0D;
    qtdRecolhidosHCCont = 0D;
    qtdTrocados = 0D;
    qtdAtualCheios = 0D;
    qtdAtualVazios = 0D;
    qtdCheiosCont = 0D;
    qtdVaziosCont = 0D;
    qtdTransferidos = 0D;
    qtdComplementados = 0D;
    qtdDescarregados = 0D;
  }

  public static Saldo newInstance() {
    return new Saldo();
  }

  @NonNull
  public Long getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(@NonNull Long numeroViagem) {
    this.numeroViagem = numeroViagem;
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
    return nomeItem;
  }

  public void setNomeItem(String nomeItem) {
    this.nomeItem = nomeItem;
  }

  public Integer getTipoItem() {
    return tipoItem;
  }

  public void setTipoItem(Integer tipoItem) {
    this.tipoItem = tipoItem;
  }

  public String getTipoPropriedade() {
    return tipoPropriedade;
  }

  public void setTipoPropriedade(String tipoPropriedade) {
    this.tipoPropriedade = tipoPropriedade;
  }

  public Double getQtdCarregadaCheios() {
    return qtdCarregadaCheios;
  }

  public void setQtdCarregadaCheios(Double qtdCarregadaCheios) {
    this.qtdCarregadaCheios = qtdCarregadaCheios;
  }

  public Double getQtdCarregadaVazios() {
    return qtdCarregadaVazios;
  }

  public void setQtdCarregadaVazios(Double qtdCarregadaVazios) {
    this.qtdCarregadaVazios = qtdCarregadaVazios;
  }

  public Double getQtdAtualCheios() {
    return qtdAtualCheios;
  }

  public void setQtdAtualCheios(Double qtdAtualCheios) {
    this.qtdAtualCheios = qtdAtualCheios;
  }

  public Double getQtdAtualVazios() {
    return qtdAtualVazios;
  }

  public void setQtdAtualVazios(Double qtdAtualVazios) {
    this.qtdAtualVazios = qtdAtualVazios;
  }

  public Double getQtdCheiosCont() {
    return qtdCheiosCont;
  }

  public void setQtdCheiosCont(Double qtdCheiosCont) {
    this.qtdCheiosCont = qtdCheiosCont;
  }

  public Double getQtdVaziosCont() {
    return qtdVaziosCont;
  }

  public void setQtdVaziosCont(Double qtdVaziosCont) {
    this.qtdVaziosCont = qtdVaziosCont;
  }

  public Double getQtdVendidos() {
    return qtdVendidos;
  }

  public void setQtdVendidos(Double qtdVendidos) {
    this.qtdVendidos = qtdVendidos;
  }

  public Double getQtdAplicados() {
    return qtdAplicados;
  }

  public void setQtdAplicados(Double qtdAplicados) {
    this.qtdAplicados = qtdAplicados;
  }

  public Double getQtdRecolhidos() {
    return qtdRecolhidos;
  }

  public void setQtdRecolhidos(Double qtdRecolhidos) {
    this.qtdRecolhidos = qtdRecolhidos;
  }

  public Double getQtdAplicadosHC() {
    return qtdAplicadosHC;
  }

  public void setQtdAplicadosHC(Double qtdAplicadosHC) {
    this.qtdAplicadosHC = qtdAplicadosHC;
  }

  public Double getQtdRecolhidosHC() {
    return qtdRecolhidosHC;
  }

  public void setQtdRecolhidosHC(Double qtdRecolhidosHC) {
    this.qtdRecolhidosHC = qtdRecolhidosHC;
  }

  public Double getQtdAplicadosHCCont() {
    return qtdAplicadosHCCont;
  }

  public void setQtdAplicadosHCCont(Double qtdAplicadosHCCont) {
    this.qtdAplicadosHCCont = qtdAplicadosHCCont;
  }

  public Double getQtdRecolhidosHCCont() {
    return qtdRecolhidosHCCont;
  }

  public void setQtdRecolhidosHCCont(Double qtdRecolhidosHCCont) {
    this.qtdRecolhidosHCCont = qtdRecolhidosHCCont;
  }

  public Double getQtdTrocados() {
    return qtdTrocados;
  }

  public void setQtdTrocados(Double qtdTrocados) {
    this.qtdTrocados = qtdTrocados;
  }

  public Double getQtdTransferidos() {
    return qtdTransferidos;
  }

  public void setQtdTransferidos(Double qtdTransferidos) {
    this.qtdTransferidos = qtdTransferidos;
  }

  public Double getQtdComplementados() {
    return qtdComplementados;
  }

  public void setQtdComplementados(Double qtdComplementados) {
    this.qtdComplementados = qtdComplementados;
  }

  public Double getQtdDescarregados() {
    return qtdDescarregados;
  }

  public void setQtdDescarregados(Double qtdDescarregados) {
    this.qtdDescarregados = qtdDescarregados;
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
      DatabaseApp.self().getDatabase().saldoDao().insert(this);
  }

  @Override
  public void deleteAll() {
    DatabaseApp.self().getDatabase().saldoDao().deleteAll(DatabaseApp.self().getDatabase()
      .saldoDao().getAll());
  }

  @Nonnull
  @Override
  public String toString() {
    return String.format(Locale.getDefault(), "%s %s %s\n%s",
      UtilHelper.padRight(cdItem.toString(), ' ', 25),
      UtilHelper.padLeft(UtilHelper.formatDoubleString(qtdCarregadaCheios, 0), ' ', 11),
      UtilHelper.padLeft(UtilHelper.formatDoubleString(qtdAtualCheios, 0), ' ', 11),
      nomeItem);
  }
}
