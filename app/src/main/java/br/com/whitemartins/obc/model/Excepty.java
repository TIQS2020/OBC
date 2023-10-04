package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.whitemartins.obc.dao.ExceptyDao;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.enumeration.OrientationType;
import br.com.whitemartins.obc.interafce.MappingOut;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity(primaryKeys = {"cdCustomer", "cdExcept", "dataHoraEntrada"})
public class Excepty extends MockRecord implements Serializable {

  public static final long serialVersionUID = 1L;

  @NonNull
  @MappingOut(initialPos = 0, finalPos = 8, orientation = OrientationType.LEFT, charComplete = '0')
  private Long cdCustomer;
  @MappingOut(initialPos = 16, finalPos = 18, orientation = OrientationType.LEFT, charComplete = '0')
  @NonNull
  private Long cdExcept;
  @TypeConverters(DateTypeConverter.class)
  @MappingOut(initialPos = 18, finalPos = 32, orientation = OrientationType.LEFT, charComplete = '0')
  @NonNull
  private Date dataHoraEntrada;
  @MappingOut(initialPos = 15, finalPos = 16, orientation = OrientationType.LEFT, charComplete = '0')
  private String tipo;
  @MappingOut(initialPos = 8, finalPos = 15, orientation = OrientationType.LEFT, charComplete = '0')
  private Long odometro;
  @TypeConverters(DateTypeConverter.class)
  @MappingOut(initialPos = 32, finalPos = 46, orientation = OrientationType.LEFT, charComplete = '0')
  private Date dataHoraSaida;
  @MappingOut(initialPos = 46, finalPos = 54, orientation = OrientationType.LEFT, charComplete = '0')
  private Long numeroViagem;
  @MappingOut(initialPos = 54, finalPos = 62, orientation = OrientationType.LEFT, charComplete = '0', dateFormat = "ddMMyyyy")
  private Date dataViagem;

  public static Excepty newInstance() {
    return new Excepty();
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public Long getCdExcept() {
    return cdExcept;
  }

  public void setCdExcept(Long cdExcept) {
    this.cdExcept = cdExcept;
  }

  public Date getDataHoraEntrada() {
    return dataHoraEntrada;
  }

  public void setDataHoraEntrada(Date dataHoraEntrada) {
    this.dataHoraEntrada = dataHoraEntrada;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Long getOdometro() {
    return odometro;
  }

  public void setOdometro(Long odometro) {
    this.odometro = odometro;
  }

  public Date getDataHoraSaida() {
    return dataHoraSaida;
  }

  public void setDataHoraSaida(Date dataHoraSaida) {
    this.dataHoraSaida = dataHoraSaida;
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

  public void insere(Long cdCustomer, Long cdExcept, Date dataHoraEntrada, String tipo,
                     Long odometro, Date dataHoraSaida, Long numeroViagem, Date dataViagem) {

    this.cdCustomer = cdCustomer;
    this.cdExcept = cdExcept;
    this.dataHoraEntrada = dataHoraEntrada;
    this.tipo = tipo;
    this.odometro = odometro;
    this.dataHoraSaida = dataHoraSaida;
    this.numeroViagem = numeroViagem;
    this.dataViagem = dataViagem;

    save();
  }

  @Override
  public void parseLine(String line) {
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    if (isValid())
      DatabaseApp.self().getDatabase().exceptDao().insert(this);
  }

  @Override
  public void deleteAll() {
    ExceptyDao dao = DatabaseApp.self().getDatabase().exceptDao();
    List<Excepty> excepties = dao.getAll();
    dao.deleteAll(excepties);
  }

  @Override
  public String toString() {
    return "";
  }


}
