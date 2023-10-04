package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "respostas")
public class RespostaNFe {

  @Element(name = "categorizada", required = false)
  private String categorizada;

  @Element(name = "sequencial", required = false)
  private Integer sequencial;

  @Element(name = "pergunta", required = false)
  private String pergunta;

  @Element(name = "resposta", required = false)
  private String resposta;

  public RespostaNFe() {
//    resposta = new ArrayList<>();
  }

  public String getCategorizada() {
    return categorizada;
  }

  public void setCategorizada(String categorizada) {
    this.categorizada = categorizada;
  }

  public String getPergunta() {
    return pergunta;
  }

  public void setPergunta(String pergunta) {
    this.pergunta = pergunta;
  }

  public String getResposta() {
    return resposta;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }

  @Override
  public String toString() {
    return "NfeResposta [categorizada=" + categorizada + ", pergunta="
      + pergunta + ", resposta=" + resposta + "]";
  }

  public Integer getSequencial() {
    return sequencial;
  }

  public void setSequencial(Integer sequencial) {
    this.sequencial = sequencial;
  }

}
