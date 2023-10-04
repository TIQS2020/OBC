package br.com.whitemartins.obc.model.sync;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;
import java.util.List;

public class PesquisaNFe {
  @Element(name = "motorista", required = false)
  private String motorista;

  @Element(name = "contato", required = false)
  private String contato;

  @Element(name = "cargo", required = false)
  private String cargo;

  @Element(name = "telefone", required = false)
  private String telefone;

  @Element(name = "dt_pesquisa", required = false)
  private String dataPesquisa;

  @Element(name = "hr_pesquisa", required = false)
  private String horaPesquisa;

  @Element(name = "fl_rejeitada", required = false)
  private String indicadorRejeicao;

  @ElementList(name = "respostas", required = false, inline = true)
  private List<RespostaNFe> respostas;

  public PesquisaNFe() {
    respostas = new ArrayList<>();
  }

  public String getMotorista() {
    return motorista;
  }

  public void setMotorista(String motorista) {
    this.motorista = motorista;
  }

  public String getContato() {
    return contato;
  }

  public void setContato(String contato) {
    this.contato = contato;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getDataPesquisa() {
    return dataPesquisa;
  }

  public void setDataPesquisa(String dataPesquisa) {
    this.dataPesquisa = dataPesquisa;
  }

  public String getIndicadorRejeicao() {
    return indicadorRejeicao;
  }

  public void setIndicadorRejeicao(String indicadorRejeicao) {
    this.indicadorRejeicao = indicadorRejeicao;
  }

  public List<RespostaNFe> getRespostas() {
    return respostas;
  }

  public void setRespostas(List<RespostaNFe> respostas) {
    this.respostas = respostas;
  }

  public String getHoraPesquisa() {
    return horaPesquisa;
  }

  public void setHoraPesquisa(String horaPesquisa) {
    this.horaPesquisa = horaPesquisa;
  }

  @Override
  public String toString() {
    return "EnvioNfeRequestPesquisa [motorista=" + motorista + ", contato=" + contato +
      ", cargo=" + cargo + ", telefone=" + telefone + ", dataPesquisa=" + dataPesquisa +
      ", indicadorRejeicao=" + indicadorRejeicao + ", respostas=" + respostas + "]";
  }

}