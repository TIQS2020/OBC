package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import br.com.whitemartins.obc.dao._StaticDao;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
public class _StaticTable extends MockRecord implements Serializable {

  public static final Long serialVersionUID = 1L;

  @PrimaryKey(autoGenerate = true)
  private Long id;
  private String semente;
  private String macAddress;
  private String nomeImpressora;
  private String cdFilial;
  private String cdVeiculo;

  public _StaticTable() {
    id = 1L;
    semente = "";
  }

  public static _StaticTable newInstance() {
    return new _StaticTable();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSemente() {
    if (semente == null)
      semente = "";

    return semente;
  }

  public void setSemente(String semente) {
    this.semente = semente;
  }

  public String getMacAddress() {
    if (macAddress == null)
      macAddress = "";
    return macAddress;
  }

  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }

  public String getNomeImpressora() {
    if (nomeImpressora == null)
      nomeImpressora = "";
    return nomeImpressora;
  }

  public void setNomeImpressora(String nomeImpressora) {
    this.nomeImpressora = nomeImpressora;
  }

  public String getCdFilial() {
    if (cdFilial == null)
      cdFilial = "";
    return cdFilial;
  }

  public void setCdFilial(String cdFilial) {
    this.cdFilial = cdFilial;
  }

  public String getCdVeiculo() {
    if (cdVeiculo == null)
      cdVeiculo = "";
    return cdVeiculo;
  }

  public void setCdVeiculo(String cdVeiculo) {
    this.cdVeiculo = cdVeiculo;
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
    _StaticDao dao = DatabaseApp.self().getStaticDatabase().staticDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
//    GeneralDao dao = DatabaseApp.self().getDatabase().generalDao();
//    dao.deleteAll(dao.getAll());
  }
}
