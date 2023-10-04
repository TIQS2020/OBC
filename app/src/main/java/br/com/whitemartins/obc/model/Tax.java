package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import br.com.whitemartins.obc.dao.TaxDao;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity(primaryKeys = {"condPagto", "dtEmissao", "dtParcela"})
@FileInfo(lineLength = 109)
public class Tax extends MockRecord implements Serializable {

  private static final long serialVersionUID = 1L;
  @MappingIn(initialPos = 0, finalPos = 3)
  @NonNull
  private Integer condPagto;
  @MappingIn(initialPos = 3, finalPos = 33)
  private String descPagto;
  @MappingIn(initialPos = 33, finalPos = 36)
  private Integer seqParcela;
  @MappingIn(initialPos = 36, finalPos = 44, dateFormat = "ddMMyyyy")
  @TypeConverters(DateTypeConverter.class)
  @NonNull
  private Date dtEmissao;
  @MappingIn(initialPos = 44, finalPos = 52, dateFormat = "ddMMyyyy")
  @TypeConverters(DateTypeConverter.class)
  @NonNull
  private Date dtParcela;
  @MappingIn(initialPos = 52, finalPos = 58, decimals = 3)
  private Double percentual;
  @MappingIn(initialPos = 58, finalPos = 59)
  private String indCondPagto;

  public static Tax newInstance() {
    return new Tax();
  }

  public Integer getCondPagto() {
    return condPagto;
  }

  public void setCondPagto(Integer condPagto) {
    this.condPagto = condPagto;
  }

  public String getDescPagto() {
    return descPagto;
  }

  public void setDescPagto(String descPagto) {
    this.descPagto = descPagto;
  }

  public Integer getSeqParcela() {
    return seqParcela;
  }

  public void setSeqParcela(Integer seqParcela) {
    this.seqParcela = seqParcela;
  }

  public Date getDtEmissao() {
    return dtEmissao;
  }

  public void setDtEmissao(Date dtEmissao) {
    this.dtEmissao = dtEmissao;
  }

  public Date getDtParcela() {
    return dtParcela;
  }

  public void setDtParcela(Date dtParcela) {
    this.dtParcela = dtParcela;
  }

  public String getIndCondPagto() {
    return indCondPagto;
  }

  public void setIndCondPagto(String indCondPagto) {
    this.indCondPagto = indCondPagto;
  }

  public Double getPercentual() {
    return percentual;
  }

  public void setPercentual(Double percentual) {
    this.percentual = percentual;
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
    TaxDao dao = DatabaseApp.self().getDatabase().taxDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    TaxDao dao = DatabaseApp.self().getDatabase().taxDao();
    dao.deleteAll(dao.getAll());
  }

  @Override
  public String toString() {
    return String.format(Locale.getDefault(), "%d/%s", getCondPagto(), getDescPagto());
  }
}
