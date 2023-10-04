package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "forma_pagamento")
public class FormaPagamentoNFe {

  @Element(name = "vl_dinheiro", required = false)
  private Double valorDinheiro;
  @Element(name = "vl_troco", required = false)
  private Double valorTroco;
  @Element(name = "vl_fatura", required = false)
  private Double valorFatura;
  @Element(name = "vl_debito", required = false)
  private Double valorDebito;
  @Element(name = "vl_credito", required = false)
  private Double valorCredito;
  @Element(name = "vl_cheque", required = false)
  private Double valorCheque;
  @Element(name = "num_cheque", required = false)
  private String numeroCheque;

  public Double getValorDinheiro() {
    return valorDinheiro;
  }

  public void setValorDinheiro(Double valorDinheiro) {
    this.valorDinheiro = valorDinheiro;
  }

  public Double getValorTroco() {
    return valorTroco;
  }

  public void setValorTroco(Double valorTroco) {
    this.valorTroco = valorTroco;
  }

  public Double getValorFatura() {
    return valorFatura;
  }

  public void setValorFatura(Double valorFatura) {
    this.valorFatura = valorFatura;
  }

  public Double getValorDebito() {
    return valorDebito;
  }

  public void setValorDebito(Double valorDebito) {
    this.valorDebito = valorDebito;
  }

  public Double getValorCredito() {
    return valorCredito;
  }

  public void setValorCredito(Double valorCredito) {
    this.valorCredito = valorCredito;
  }

  public Double getValorCheque() {
    return valorCheque;
  }

  public void setValorCheque(Double valorCheque) {
    this.valorCheque = valorCheque;
  }

  public String getNumeroCheque() {
    return numeroCheque;
  }

  public void setNumeroCheque(String numeroCheque) {
    this.numeroCheque = numeroCheque;
  }
}
