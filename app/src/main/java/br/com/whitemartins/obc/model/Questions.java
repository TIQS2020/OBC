package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import br.com.whitemartins.obc.dao.QuestionsDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
@FileInfo(lineLength = 343)
public class Questions extends MockRecord implements Serializable {

  public static final Long serialVersionUID = 1L;

  @PrimaryKey
  @MappingIn(initialPos = 0, finalPos = 9)
  private Integer numeroPergunta;
  @MappingIn(initialPos = 9, finalPos = 89)
  private String pergunta;
  @MappingIn(initialPos = 89, finalPos = 98)
  private Integer numeroResposta1;
  @MappingIn(initialPos = 98, finalPos = 128)
  private String resposta1;
  @MappingIn(initialPos = 128, finalPos = 137)
  private Integer numeroResposta2;
  @MappingIn(initialPos = 137, finalPos = 167)
  private String resposta2;
  @MappingIn(initialPos = 167, finalPos = 176)
  private Integer numeroResposta3;
  @MappingIn(initialPos = 176, finalPos = 206)
  private String resposta3;
  @MappingIn(initialPos = 206, finalPos = 215)
  private Integer numeroResposta4;
  @MappingIn(initialPos = 215, finalPos = 245)
  private String resposta4;
  @MappingIn(initialPos = 245, finalPos = 254)
  private Integer numeroResposta5;
  @MappingIn(initialPos = 254, finalPos = 284)
  private String resposta5;
  @MappingIn(initialPos = 284, finalPos = 286)
  private String categorizar;

  public static Questions newInstance() {
    return new Questions();
  }

  public Integer getNumeroPergunta() {
    return numeroPergunta;
  }

  public void setNumeroPergunta(Integer numeroPergunta) {
    this.numeroPergunta = numeroPergunta;
  }

  public String getPergunta() {
    return pergunta;
  }

  public void setPergunta(String pergunta) {
    this.pergunta = pergunta;
  }

  public Integer getNumeroResposta1() {
    return numeroResposta1;
  }

  public void setNumeroResposta1(Integer numeroResposta1) {
    this.numeroResposta1 = numeroResposta1;
  }

  public String getResposta1() {
    return resposta1;
  }

  public void setResposta1(String resposta1) {
    this.resposta1 = resposta1;
  }

  public Integer getNumeroResposta2() {
    return numeroResposta2;
  }

  public void setNumeroResposta2(Integer numeroResposta2) {
    this.numeroResposta2 = numeroResposta2;
  }

  public String getResposta2() {
    return resposta2;
  }

  public void setResposta2(String resposta2) {
    this.resposta2 = resposta2;
  }

  public Integer getNumeroResposta3() {
    return numeroResposta3;
  }

  public void setNumeroResposta3(Integer numeroResposta3) {
    this.numeroResposta3 = numeroResposta3;
  }

  public String getResposta3() {
    return resposta3;
  }

  public void setResposta3(String resposta3) {
    this.resposta3 = resposta3;
  }

  public Integer getNumeroResposta4() {
    return numeroResposta4;
  }

  public void setNumeroResposta4(Integer numeroResposta4) {
    this.numeroResposta4 = numeroResposta4;
  }

  public String getResposta4() {
    return resposta4;
  }

  public void setResposta4(String resposta4) {
    this.resposta4 = resposta4;
  }

  public Integer getNumeroResposta5() {
    return numeroResposta5;
  }

  public void setNumeroResposta5(Integer numeroResposta5) {
    this.numeroResposta5 = numeroResposta5;
  }

  public String getResposta5() {
    return resposta5;
  }

  public void setResposta5(String resposta5) {
    this.resposta5 = resposta5;
  }

  public String getCategorizar() {
    return categorizar;
  }

  public void setCategorizar(String categorizar) {
    this.categorizar = categorizar;
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
    QuestionsDao dao = DatabaseApp.self().getDatabase().questionsDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    QuestionsDao dao = DatabaseApp.self().getDatabase().questionsDao();
    dao.deleteAll(dao.getAll());
  }
}
