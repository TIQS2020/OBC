package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

import br.com.whitemartins.obc.dao.MessageDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity()
@FileInfo(lineLength = 80)
public class Message extends MockRecord implements Serializable {
  public static final Long serialVersionUID = 1L;

  @PrimaryKey(autoGenerate = true)
  private Long id;
  @MappingIn(initialPos = 0, finalPos = 1)
  @NonNull
  private String tipoMensagem;
  @MappingIn(initialPos = 1, finalPos = 9)
  @NonNull
  private Long cdCustomer;
  @MappingIn(initialPos = 9, finalPos = 89)
  @NonNull
  private String mensagem;

  public static Message newInstance() {
    return new Message();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTipoMensagem() {
    return tipoMensagem;
  }

  public void setTipoMensagem(String tipoMensagem) {
    this.tipoMensagem = tipoMensagem;
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
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
    MessageDao dao = DatabaseApp.self().getDatabase().messageDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    MessageDao dao = DatabaseApp.self().getDatabase().messageDao();
    dao.deleteAll(dao.getAll());
  }

  public void delete() {
    MessageDao dao = DatabaseApp.self().getDatabase().messageDao();
    dao.delete(this);
  }
}
