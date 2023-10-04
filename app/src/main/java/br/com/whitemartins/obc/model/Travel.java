package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Date;

import br.com.whitemartins.obc.dao.TravelDao;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
@FileInfo(lineLength = 38)
@Root(name = "viagem")
public class Travel extends MockRecord implements Serializable {

  public static final Long serialVersionUID = 1L;

  @PrimaryKey
  @MappingIn(initialPos = 0, finalPos = 8)
  @Element(name = "numeroViagemCorrente", required = false)
  private Long numeroViagem;
  @MappingIn(initialPos = 8, finalPos = 16, dateFormat = "ddMMyyyy")
  @TypeConverters(DateTypeConverter.class)
  @Element(name = "dataViagemCorrente", required = false)
  private Date dataViagem;
  @MappingIn(initialPos = 16, finalPos = 18)
  private Integer sequencia;
  @MappingIn(initialPos = 18, finalPos = 19)
  private String indViagemUsada;

//  @Element(name = "numeroViagemPrincipal", required = false)
//  @Ignore
//  private Long numeroViagemPrincipal;
//  @Ignore
//  @Element(name = "dataViagemPrincipal", required = false)
//  private Date dataViagemPricipal;

  public static Travel newInstance() {
    return new Travel();
  }

  public Long getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(Long numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public Date getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(Date dataViagem) {
    this.dataViagem = dataViagem;
  }

  public Integer getSequencia() {
    return sequencia;
  }

  public void setSequencia(Integer sequencia) {
    this.sequencia = sequencia;
  }

  public String getIndViagemUsada() {
    return indViagemUsada;
  }

  public void setIndViagemUsada(String indViagemUsada) {
    this.indViagemUsada = indViagemUsada;
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
    TravelDao dao = DatabaseApp.self().getDatabase().travelDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    TravelDao dao = DatabaseApp.self().getDatabase().travelDao();
    dao.deleteAll(dao.getAll());
  }

  @NonNull
  @Override
  public String toString() {
    return numeroViagem.toString();
  }
}
