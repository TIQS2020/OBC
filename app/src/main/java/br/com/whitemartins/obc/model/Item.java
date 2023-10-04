package br.com.whitemartins.obc.model;


import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import br.com.whitemartins.obc.dao.ItemDao;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

/**
 * Created by Rodolfo on 31/01/2018.
 */
@Entity(primaryKeys = {"cdItem", "capacidadeProduto", "cdCilindro"})
@FileInfo(lineLength = 349)
public class Item extends MockRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  @NonNull
  @MappingIn(initialPos = 2, finalPos = 10, defaultValue = "0")
  private Long cdItem;
  @NonNull
  @MappingIn(initialPos = 23, finalPos = 28, defaultValue = "0", decimals = 2)
  private Double capacidadeProduto;
  @MappingIn(initialPos = 15, finalPos = 23, defaultValue = "0")
  @NonNull
  private Long cdCilindro;
  @MappingIn(initialPos = 10, finalPos = 15, defaultValue = "0", decimals = 2)
  private Double capacidadeCilindro;
  @MappingIn(initialPos = 29, finalPos = 30)
  private String indCapacVariavel;
  @MappingIn(initialPos = 30, finalPos = 31)
  private String indRecursivoLastro;
  @MappingIn(initialPos = 35, finalPos = 65)
  private String descricaoCilindro;
  @MappingIn(initialPos = 65, finalPos = 95)
  private String descricaoProduto;
  @MappingIn(initialPos = 95, finalPos = 103, defaultValue = "0", decimals = 2)
  private Double qtdCilindroCheios;
  @MappingIn(initialPos = 103, finalPos = 111, defaultValue = "0", decimals = 2)
  private Double qtdCilindroVazios;
  @MappingIn(initialPos = 111, finalPos = 121, defaultValue = "0", decimals = 7)
  private Double fatorConversao;
  @MappingIn(initialPos = 121, finalPos = 125, defaultValue = "0")
  private String estruturaProducao;
  @MappingIn(initialPos = 133, finalPos = 137, defaultValue = "0")
  private Long percode;
  @MappingIn(initialPos = 133, finalPos = 137)
  private Double custoTransferencia;
  @MappingIn(initialPos = 197, finalPos = 198)
  private String tax1;
  @MappingIn(initialPos = 198, finalPos = 199)
  private String tax2;
  @MappingIn(initialPos = 199, finalPos = 200)
  private String tax3;
  @MappingIn(initialPos = 200, finalPos = 201)
  private String indRastreavel;
  @MappingIn(initialPos = 201, finalPos = 202)
  private String indLiquido;
  @MappingIn(initialPos = 202, finalPos = 217, decimals = 4)
  private Double valorIndenizacao;
  @MappingIn(initialPos = 242, finalPos = 245)
  private String cstGas;
  @MappingIn(initialPos = 245, finalPos = 248)
  private String cstCilindro;
  @MappingIn(initialPos = 249, finalPos = 251)
  private String unidadeMedida;
  @MappingIn(initialPos = 258, finalPos = 259)
  private String indLiqGas;
  @MappingIn(initialPos = 268, finalPos = 269)
  private Integer indRequerFator;
  @MappingIn(initialPos = 269, finalPos = 276, decimals = 5)
  private Double fatorPcs;
  @MappingIn(initialPos = 276, finalPos = 283, decimals = 2)
  private String pcsRegistrado;
  @MappingIn(initialPos = 283, finalPos = 293)
  private Long classeNcmCilindro;
  @MappingIn(initialPos = 303, finalPos = 310, decimals = 2)
  private Double pesoCilindro;
  @MappingIn(initialPos = 310, finalPos = 317, decimals = 2)
  private Double pesoLiqUnitario;
  @MappingIn(initialPos = 317, finalPos = 327)
  private Long classeNcmGas;
  @MappingIn(initialPos = 327, finalPos = 328)
  private String tipoPropriedade;
  @MappingIn(initialPos = 335, finalPos = 343)
  private String recursivFrete;
  @MappingIn(initialPos = 343, finalPos = 344)
  private Integer tipoPressao;
  @MappingIn(initialPos = 344, finalPos = 345)
  private String indRastreabilidade;
  //Setando sempre Gás (1) com valor padrão, em viagens HC esse campos vem preenchido
  @MappingIn(initialPos = 346, finalPos = 347, defaultValue = "1")
  private Integer tipoItem;
  @MappingIn(initialPos = 347, finalPos = 348)
  private String indFatorConvPolegadas;
  @MappingIn(initialPos = 348, finalPos = 349)
  private String indProducao;

  //  private List<Price> prices;
//
  public Item() {
    tipoItem = TypeItemType.GAS.getValue();
  }

  public Long getCdItem() {
    return cdItem;
  }

  public void setCdItem(Long cdItem) {
    this.cdItem = cdItem;
  }

  public Double getCapacidadeProduto() {
    return capacidadeProduto;
  }

  public void setCapacidadeProduto(Double capacidadeProduto) {
    this.capacidadeProduto = capacidadeProduto;
  }

  public Long getCdCilindro() {
    return cdCilindro;
  }

  public void setCdCilindro(Long cdCilindro) {
    this.cdCilindro = cdCilindro;
  }

  public Double getCapacidadeCilindro() {
    return capacidadeCilindro;
  }

  public void setCapacidadeCilindro(Double capacidadeCilindro) {
    this.capacidadeCilindro = capacidadeCilindro;
  }

  public String getIndCapacVariavel() {
    return indCapacVariavel;
  }

  public void setIndCapacVariavel(String indCapacVariavel) {
    this.indCapacVariavel = indCapacVariavel;
  }

  public String getIndRecursivoLastro() {
    return indRecursivoLastro;
  }

  public void setIndRecursivoLastro(String indRecursivoLastro) {
    this.indRecursivoLastro = indRecursivoLastro;
  }

  public String getDescricaoCilindro() {
    return descricaoCilindro;
  }

  public void setDescricaoCilindro(String descricaoCilindro) {
    this.descricaoCilindro = descricaoCilindro;
  }

  public String getDescricaoProduto() {
    return descricaoProduto;
  }

  public void setDescricaoProduto(String descricaoProduto) {
    this.descricaoProduto = descricaoProduto;
  }

  public Double getQtdCilindroCheios() {
    return qtdCilindroCheios;
  }

  public void setQtdCilindroCheios(Double qtdCilindroCheios) {
    this.qtdCilindroCheios = qtdCilindroCheios;
  }

  public Double getQtdCilindroVazios() {
    return qtdCilindroVazios;
  }

  public void setQtdCilindroVazios(Double qtdCilindroVazios) {
    this.qtdCilindroVazios = qtdCilindroVazios;
  }

  public Double getFatorConversao() {
    return fatorConversao;
  }

  public void setFatorConversao(Double fatorConversao) {
    this.fatorConversao = fatorConversao;
  }

  public String getEstruturaProducao() {
    return estruturaProducao;
  }

  public void setEstruturaProducao(String estruturaProducao) {
    this.estruturaProducao = estruturaProducao;
  }

  public Long getPercode() {
    return percode;
  }

  public void setPercode(Long percode) {
    this.percode = percode;
  }

  public Double getCustoTransferencia() {
    return custoTransferencia;
  }

  public void setCustoTransferencia(Double custoTransferencia) {
    this.custoTransferencia = custoTransferencia;
  }

  public String getTax1() {
    return tax1;
  }

  public void setTax1(String tax1) {
    this.tax1 = tax1;
  }

  public String getTax2() {
    return tax2;
  }

  public void setTax2(String tax2) {
    this.tax2 = tax2;
  }

  public String getTax3() {
    return tax3;
  }

  public void setTax3(String tax3) {
    this.tax3 = tax3;
  }

  public String getIndRastreavel() {
    return indRastreavel;
  }

  public void setIndRastreavel(String indRastreavel) {
    this.indRastreavel = indRastreavel;
  }

  public String getIndLiquido() {
    return indLiquido;
  }

  public void setIndLiquido(String indLiquido) {
    this.indLiquido = indLiquido;
  }

  public Double getValorIndenizacao() {
    return valorIndenizacao;
  }

  public void setValorIndenizacao(Double valorIndenizacao) {
    this.valorIndenizacao = valorIndenizacao;
  }

  public String getCstGas() {
    return cstGas;
  }

  public void setCstGas(String cstGas) {
    this.cstGas = cstGas;
  }

  public String getCstCilindro() {
    return cstCilindro;
  }

  public void setCstCilindro(String cstCilindro) {
    this.cstCilindro = cstCilindro;
  }

  public String getUnidadeMedida() {
    if (unidadeMedida == null)
      unidadeMedida = "";
    return unidadeMedida;
  }

  public void setUnidadeMedida(String unidadeMedida) {
    this.unidadeMedida = unidadeMedida;
  }

  public String getIndLiqGas() {
    return indLiqGas;
  }

  public void setIndLiqGas(String indLiqGas) {
    this.indLiqGas = indLiqGas;
  }

  public Integer getIndRequerFator() {
    return indRequerFator;
  }

  public void setIndRequerFator(Integer indRequerFator) {
    this.indRequerFator = indRequerFator;
  }

  public Double getFatorPcs() {
    return fatorPcs;
  }

  public void setFatorPcs(Double fatorPcs) {
    this.fatorPcs = fatorPcs;
  }

  public String getPcsRegistrado() {
    return pcsRegistrado;
  }

  public void setPcsRegistrado(String pcsRegistrado) {
    this.pcsRegistrado = pcsRegistrado;
  }

  public Long getClasseNcmCilindro() {
    return classeNcmCilindro;
  }

  public void setClasseNcmCilindro(Long classeNcmCilindro) {
    this.classeNcmCilindro = classeNcmCilindro;
  }

  public Double getPesoCilindro() {
    return pesoCilindro;
  }

  public void setPesoCilindro(Double pesoCilindro) {
    this.pesoCilindro = pesoCilindro;
  }

  public Double getPesoLiqUnitario() {
    return pesoLiqUnitario;
  }

  public void setPesoLiqUnitario(Double pesoLiqUnitario) {
    this.pesoLiqUnitario = pesoLiqUnitario;
  }

  public Long getClasseNcmGas() {
    return classeNcmGas;
  }

  public void setClasseNcmGas(Long classeNcmGas) {
    this.classeNcmGas = classeNcmGas;
  }

  public String getTipoPropriedade() {
    return tipoPropriedade;
  }

  public void setTipoPropriedade(String tipoPropriedade) {
    this.tipoPropriedade = tipoPropriedade;
  }

  public String getRecursivFrete() {
    return recursivFrete;
  }

  public void setRecursivFrete(String recursivFrete) {
    this.recursivFrete = recursivFrete;
  }

  public Integer getTipoPressao() {
    return tipoPressao;
  }

  public void setTipoPressao(Integer tipoPressao) {
    this.tipoPressao = tipoPressao;
  }

  public String getIndRastreabilidade() {
    return indRastreabilidade;
  }

  public void setIndRastreabilidade(String indRastreabilidade) {
    this.indRastreabilidade = indRastreabilidade;
  }

  public Integer getTipoItem() {
    return tipoItem;
  }

  public void setTipoItem(Integer tipoItem) {
    this.tipoItem = tipoItem;
  }

  public String getIndFatorConvPolegadas() {
    return indFatorConvPolegadas;
  }

  public void setIndFatorConvPolegadas(String indFatorConvPolegadas) {
    this.indFatorConvPolegadas = indFatorConvPolegadas;
  }

  public String getIndProducao() {
    return indProducao;
  }

  public void setIndProducao(String indProducao) {
    this.indProducao = indProducao;
  }

  public void parseLine(String line) {
    this.automaticParseIn(line);
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    ItemDao dao = DatabaseApp.self().getDatabase().itemDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    ItemDao dao = DatabaseApp.self().getDatabase().itemDao();
    List<Item> items = dao.getAll();
    dao.deleteAll(items);
  }

  @Override
  public String toString() {
    return String.format("%d - %s", cdItem, descricaoProduto);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Objects.equals(cdItem, item.cdItem) &&
      Objects.equals(capacidadeProduto, item.capacidadeProduto) &&
      Objects.equals(cdCilindro, item.cdCilindro) &&
      Objects.equals(capacidadeCilindro, item.capacidadeCilindro) &&
      Objects.equals(indCapacVariavel, item.indCapacVariavel) &&
      Objects.equals(indRecursivoLastro, item.indRecursivoLastro) &&
      Objects.equals(descricaoCilindro, item.descricaoCilindro) &&
      Objects.equals(descricaoProduto, item.descricaoProduto) &&
      Objects.equals(qtdCilindroCheios, item.qtdCilindroCheios) &&
      Objects.equals(qtdCilindroVazios, item.qtdCilindroVazios) &&
      Objects.equals(fatorConversao, item.fatorConversao) &&
      Objects.equals(estruturaProducao, item.estruturaProducao) &&
      Objects.equals(percode, item.percode) &&
      Objects.equals(custoTransferencia, item.custoTransferencia) &&
      Objects.equals(tax1, item.tax1) &&
      Objects.equals(tax2, item.tax2) &&
      Objects.equals(tax3, item.tax3) &&
      Objects.equals(indRastreavel, item.indRastreavel) &&
      Objects.equals(indLiquido, item.indLiquido) &&
      Objects.equals(valorIndenizacao, item.valorIndenizacao) &&
      Objects.equals(cstGas, item.cstGas) &&
      Objects.equals(cstCilindro, item.cstCilindro) &&
      Objects.equals(unidadeMedida, item.unidadeMedida) &&
      Objects.equals(indLiqGas, item.indLiqGas) &&
      Objects.equals(indRequerFator, item.indRequerFator) &&
      Objects.equals(fatorPcs, item.fatorPcs) &&
      Objects.equals(pcsRegistrado, item.pcsRegistrado) &&
      Objects.equals(classeNcmCilindro, item.classeNcmCilindro) &&
      Objects.equals(pesoCilindro, item.pesoCilindro) &&
      Objects.equals(pesoLiqUnitario, item.pesoLiqUnitario) &&
      Objects.equals(classeNcmGas, item.classeNcmGas) &&
      Objects.equals(tipoPropriedade, item.tipoPropriedade) &&
      Objects.equals(recursivFrete, item.recursivFrete) &&
      Objects.equals(tipoPressao, item.tipoPressao) &&
      Objects.equals(indRastreabilidade, item.indRastreabilidade) &&
      Objects.equals(tipoItem, item.tipoItem) &&
      Objects.equals(indFatorConvPolegadas, item.indFatorConvPolegadas) &&
      Objects.equals(indProducao, item.indProducao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cdItem, capacidadeProduto, cdCilindro, capacidadeCilindro,
      indCapacVariavel, indRecursivoLastro, descricaoCilindro, descricaoProduto, qtdCilindroCheios,
      qtdCilindroVazios, fatorConversao, estruturaProducao, percode, custoTransferencia, tax1, tax2,
      tax3, indRastreavel, indLiquido, valorIndenizacao, cstGas, cstCilindro, unidadeMedida,
      indLiqGas, indRequerFator, fatorPcs, pcsRegistrado, classeNcmCilindro, pesoCilindro,
      pesoLiqUnitario, classeNcmGas, tipoPropriedade, recursivFrete, tipoPressao, indRastreabilidade,
      tipoItem, indFatorConvPolegadas, indProducao);
  }

  public Double getPesoLiquido(SuperOperation operation, Double quantidade) {
    Double v = 0d;

    if (operation.getUnidadeFixa())
      v = capacidadeCilindro * pesoLiqUnitario * quantidade;
    else
      v = pesoLiqUnitario * quantidade;

    return UtilHelper.formatDouble(v, 2);
  }

  public Double getPesoCilindro(SuperOperation operation, Double quantidade) {
    Double v = pesoCilindro * quantidade;

    return UtilHelper.formatDouble(v, 2);
  }
}
