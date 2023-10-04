package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "inf_patrimonio")
public class DetalheDownloaderInfPatrimonioNFe {

  @Element(name = "num_patrimonio", required = false)
  private String numero;
  @Element(name = "serie_patrimonio", required = false)
  private String serie;
  @Element(name = "cod_ativo", required = false)
  private Long codAtivo;
  @Element(name = "desc_ativo", required = false)
  private String descricaoAtivo;


  public DetalheDownloaderInfPatrimonioNFe() {
  }


  public String getNumero() {
    return numero;
  }


  public void setNumero(String numero) {
    this.numero = numero;
  }


  public String getSerie() {
    return serie;
  }


  public void setSerie(String serie) {
    this.serie = serie;
  }


  public Long getCodAtivo() {
    return codAtivo;
  }


  public void setCodAtivo(Long codAtivo) {
    this.codAtivo = codAtivo;
  }


  public String getDescricaoAtivo() {
    return descricaoAtivo;
  }


  public void setDescricaoAtivo(String descricaoAtivo) {
    this.descricaoAtivo = descricaoAtivo;
  }


}
