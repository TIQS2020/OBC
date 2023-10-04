package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import br.com.whitemartins.obc.dao.GeneralDao;
import br.com.whitemartins.obc.enumeration.BeginTravelType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
public class General extends MockRecord implements Serializable {

  public static final Long serialVersionUID = 1L;

  @PrimaryKey
  private Long id;
  private Long numeroViagem;
  private Long numeroNotaEntrada;
  private Long serieNotaEntrada;
  private Long numeroNotaSaida;
  private Long serieNotaSaida;
  private Integer contadorSenha;
  private String flIndOriginalRefeita;
  private String beginTravelType;

  public General() {
    id = 1L;
  }

  public static General newInstance() {
    return new General();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(Long numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public Long getNumeroNotaEntrada() {
    return numeroNotaEntrada;
  }

  public void setNumeroNotaEntrada(Long numeroNotaEntrada) {
    this.numeroNotaEntrada = numeroNotaEntrada;
  }

  public Long getSerieNotaEntrada() {
    return serieNotaEntrada;
  }

  public void setSerieNotaEntrada(Long serieNotaEntrada) {
    this.serieNotaEntrada = serieNotaEntrada;
  }

  public Long getNumeroNotaSaida() {
    return numeroNotaSaida;
  }

  public void setNumeroNotaSaida(Long numeroNotaSaida) {
    this.numeroNotaSaida = numeroNotaSaida;
  }

  public Long getSerieNotaSaida() {
    return serieNotaSaida;
  }

  public void setSerieNotaSaida(Long serieNotaSaida) {
    this.serieNotaSaida = serieNotaSaida;
  }

  public Integer getContadorSenha() {
    if (contadorSenha == null)
      contadorSenha = 1;

    return contadorSenha;
  }

  public void setContadorSenha(Integer contadorSenha) {
    this.contadorSenha = contadorSenha;
  }

  public String getFlIndOriginalRefeita() {
    if (flIndOriginalRefeita == null)
      flIndOriginalRefeita = ConstantsEnum.NO.getValue();

    return flIndOriginalRefeita;
  }

  public void setFlIndOriginalRefeita(String flIndOriginalRefeita) {
    this.flIndOriginalRefeita = flIndOriginalRefeita;
  }

  public String getBeginTravelType() {
    return beginTravelType;
  }

  public void setBeginTravelType(String beginTravelType) {
    if (this.beginTravelType == null)
      this.beginTravelType = BeginTravelType.INSUCESSO.getValue();

    this.beginTravelType = beginTravelType;
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
    GeneralDao dao = DatabaseApp.self().getDatabase().generalDao();

    General general = dao.findById(getNumeroViagem());

    if (general != null)
      dao.update(this);
    else
      dao.insert(this);
  }

  @Override
  public void deleteAll() {
    GeneralDao dao = DatabaseApp.self().getDatabase().generalDao();
    dao.deleteAll(dao.getAll());
  }
}
