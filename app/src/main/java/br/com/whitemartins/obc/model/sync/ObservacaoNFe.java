package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "observacao")
public class ObservacaoNFe {

  @Element(name = "seq_obs", required = false)
  private Integer sequencial;

  @Element(name = "seq_linha_obs", required = false)
  private Integer sequencialLinha;

  @Element(name = "descricao_obs", required = false)
  private String descricao;

  public Integer getSequencial() {
    return sequencial;
  }

  public void setSequencial(Integer sequencial) {
    this.sequencial = sequencial;
  }

  public Integer getSequencialLinha() {
    return sequencialLinha;
  }

  public void setSequencialLinha(Integer sequencialLinha) {
    this.sequencialLinha = sequencialLinha;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}