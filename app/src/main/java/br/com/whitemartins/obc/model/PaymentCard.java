package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

import br.com.whitemartins.obc.dao.PaymentCardDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
@FileInfo(lineLength = 53)
public class PaymentCard extends MockRecord implements Serializable {

  private static final long serialVersionUID = 1L;
  @PrimaryKey
  @NonNull
  @MappingIn(initialPos = 30, finalPos = 44)
  private String cnpj;
  @MappingIn(initialPos = 0, finalPos = 30)
  private String nomeEmpresa;
  @MappingIn(initialPos = 44, finalPos = 45)
  private Integer tipoIntegracao;

  public static PaymentCard newInstance() {
    return new PaymentCard();
  }

  public String getNomeEmpresa() {
    return nomeEmpresa;
  }

  public void setNomeEmpresa(String nomeEmpresa) {
    this.nomeEmpresa = nomeEmpresa;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public Integer getTipoIntegracao() {
    return tipoIntegracao;
  }

  public void setTipoIntegracao(Integer tipoIntegracao) {
    this.tipoIntegracao = tipoIntegracao;
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
    PaymentCardDao dao = DatabaseApp.self().getDatabase().payCardDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    PaymentCardDao dao = DatabaseApp.self().getDatabase().payCardDao();
    dao.deleteAll(dao.getAll());
  }
}
