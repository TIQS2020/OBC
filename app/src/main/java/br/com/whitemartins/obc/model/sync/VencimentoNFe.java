package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "vencimento")
public class VencimentoNFe {

  @Element(name = "num_parcela", required = false)
  private Integer numero;

  @Element(name = "valor", required = false)
  private Double valor;

  @Element(name = "dt_vencimento", required = false)
  private String dataVencimento;

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getDataVencimento() {
    return dataVencimento;
  }

  public void setDataVencimento(String dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

}