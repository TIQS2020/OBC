package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import br.com.whitemartins.obc.dao.PriceDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

/**
 * Created by Rodolfo on 01/02/2018.
 */
//@Table

@FileInfo(lineLength = 110)
@Entity(primaryKeys = {"cdCustomer", "cdItem"})
public class Price extends MockRecord implements Serializable {

  private static final long serialVersionUID = 1L;
  @NonNull
  @MappingIn(initialPos = 0, finalPos = 8)
  private Long cdCustomer;
  @NonNull
  @MappingIn(initialPos = 10, finalPos = 18)
  private Long cdItem;
  @MappingIn(initialPos = 18, finalPos = 20)
  private String flNovoFaturamento;
  @MappingIn(initialPos = 23, finalPos = 28, decimals = 2)
  private Double percentualIpi;
  @MappingIn(initialPos = 28, finalPos = 33, decimals = 2)
  private Double percentualIcms;
  @MappingIn(initialPos = 34, finalPos = 39, decimals = 3)
  private Double percReducaoIcms;
  @MappingIn(initialPos = 39, finalPos = 53, decimals = 4)
  private Double precoUnitario;
  @MappingIn(initialPos = 53, finalPos = 67, decimals = 4)
  private Double valorFrete;
  @MappingIn(initialPos = 67, finalPos = 81, decimals = 4)
  private Double valorDespesas;
  @MappingIn(initialPos = 81, finalPos = 85, decimals = 2)
  private Double percentualPis;
  @MappingIn(initialPos = 85, finalPos = 89, decimals = 2)
  private Double percentualCofins;
  @MappingIn(initialPos = 89, finalPos = 91)
  private String cstPis;
  @MappingIn(initialPos = 91, finalPos = 93)
  private String cstCofins;
  @MappingIn(initialPos = 105, finalPos = 107)
  private String situacaoTributaria;
  @MappingIn(initialPos = 107, finalPos = 110)
  private String condicaoFaturamento;

  public static Price newInstance() {
    return new Price();
  }

  public void parseLine(String line) {
    this.automaticParseIn(line);
  }

  public Long getCdCustomer() {
    return this.cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public Long getCdItem() {
    return this.cdItem;
  }

  public void setCdItem(Long cdItem) {
    this.cdItem = cdItem;
  }

  public String getFlNovoFaturamento() {
    return this.flNovoFaturamento;
  }

  public void setFlNovoFaturamento(String flNovoFaturamento) {
    this.flNovoFaturamento = flNovoFaturamento;
  }

  public Double getPercentualIpi() {
    return this.percentualIpi;
  }

  public void setPercentualIpi(Double percentualIpi) {
    this.percentualIpi = percentualIpi;
  }

  public Double getPercentualIcms() {
    return this.percentualIcms;
  }

  public void setPercentualIcms(Double percentualIcms) {
    this.percentualIcms = percentualIcms;
  }

  public Double getPercReducaoIcms() {
    return this.percReducaoIcms;
  }

  public void setPercReducaoIcms(Double percReducaoIcms) {
    this.percReducaoIcms = percReducaoIcms;
  }

  public Double getPrecoUnitario() {
    return this.precoUnitario;
  }

  public void setPrecoUnitario(Double precoUnitario) {
    this.precoUnitario = precoUnitario;
  }

  public Double getValorFrete() {
    return this.valorFrete;
  }

  public void setValorFrete(Double valorFrete) {
    this.valorFrete = valorFrete;
  }

  public Double getValorDespesas() {
    return this.valorDespesas;
  }

  public void setValorDespesas(Double valorDespesas) {
    this.valorDespesas = valorDespesas;
  }

  public Double getPercentualPis() {
    return this.percentualPis;
  }

  public void setPercentualPis(Double percentualPis) {
    this.percentualPis = percentualPis;
  }

  public Double getPercentualCofins() {
    return this.percentualCofins;
  }

  public void setPercentualCofins(Double percentualCofins) {
    this.percentualCofins = percentualCofins;
  }

  public String getCstPis() {
    return this.cstPis;
  }

  public void setCstPis(String cstPis) {
    this.cstPis = cstPis;
  }

  public String getCstCofins() {
    return this.cstCofins;
  }

  public void setCstCofins(String cstCofins) {
    this.cstCofins = cstCofins;
  }

  public String getSituacaoTributaria() {
    return this.situacaoTributaria;
  }

  public void setSituacaoTributaria(String situacaoTributaria) {
    this.situacaoTributaria = situacaoTributaria;
  }

  public String getCondicaoFaturamento() {
    return this.condicaoFaturamento;
  }

  public void setCondicaoFaturamento(String condicaoFaturamento) {
    this.condicaoFaturamento = condicaoFaturamento;
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    PriceDao dao = DatabaseApp.self().getDatabase().priceDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    PriceDao dao = DatabaseApp.self().getDatabase().priceDao();
    List<Price> prices = dao.getAll();
    dao.deleteAll(prices);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Price price = (Price) o;
    return Objects.equals(cdCustomer, price.cdCustomer) &&
      Objects.equals(cdItem, price.cdItem) &&
      Objects.equals(flNovoFaturamento, price.flNovoFaturamento) &&
      Objects.equals(percentualIpi, price.percentualIpi) &&
      Objects.equals(percentualIcms, price.percentualIcms) &&
      Objects.equals(percReducaoIcms, price.percReducaoIcms) &&
      Objects.equals(precoUnitario, price.precoUnitario) &&
      Objects.equals(valorFrete, price.valorFrete) &&
      Objects.equals(valorDespesas, price.valorDespesas) &&
      Objects.equals(percentualPis, price.percentualPis) &&
      Objects.equals(percentualCofins, price.percentualCofins) &&
      Objects.equals(cstPis, price.cstPis) &&
      Objects.equals(cstCofins, price.cstCofins) &&
      Objects.equals(situacaoTributaria, price.situacaoTributaria) &&
      Objects.equals(condicaoFaturamento, price.condicaoFaturamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cdCustomer, cdItem, flNovoFaturamento, percentualIpi,
      percentualIcms, percReducaoIcms, precoUnitario, valorFrete, valorDespesas, percentualPis,
      percentualCofins, cstPis, cstCofins, situacaoTributaria, condicaoFaturamento);
  }
}
