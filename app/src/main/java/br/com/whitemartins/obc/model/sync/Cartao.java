package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "cartao")
public class Cartao {

  @Element(name = "tipo_integracao", required = false)
  private Integer tipoIntegracao;

  @Element(name = "valor", required = false)
  private Double valor;

  @Element(name = "cnpj", required = false)
  private String cnpj;

  @Element(name = "num_autorizacao", required = false)
  private String numAutorizacao;

  @Element(name = "bandeira", required = false)
  private String bandeira;

  @Element(name = "modalidade", required = false)
  private Integer modalidade;

  public Integer getTipoIntegracao() {
    return tipoIntegracao;
  }

  public void setTipoIntegracao(Integer tipoIntegracao) {
    this.tipoIntegracao = tipoIntegracao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getNumAutorizacao() {
    return numAutorizacao;
  }

  public void setNumAutorizacao(String numAutorizacao) {
    this.numAutorizacao = numAutorizacao;
  }

  public String getBandeira() {
    return bandeira;
  }

  public void setBandeira(String bandeira) {
    this.bandeira = bandeira;
  }

  public Integer getModalidade() {
    return modalidade;
  }

  public void setModalidade(Integer modalidade) {
    this.modalidade = modalidade;
  }

  @Override
  public String toString() {
    return "EnvioNfeRequestCartao [tipoIntegracao=" + tipoIntegracao
      + ", valor=" + valor + ", cnpj=" + cnpj + ", numAutorizacao="
      + numAutorizacao + ", bandeira=" + bandeira + ", modalidade=" + modalidade
      + "]";
  }

}
