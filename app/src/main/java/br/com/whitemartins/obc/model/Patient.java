package br.com.whitemartins.obc.model;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Locale;

import br.com.whitemartins.obc.dao.PatientDao;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
@FileInfo(lineLength = 58)
public class Patient extends MockRecord implements Serializable {
  @PrimaryKey
  @MappingIn(initialPos = 0, finalPos = 8)
  private Long cdPaciente;
  @MappingIn(initialPos = 8, finalPos = 48)
  private String nome;
  @MappingIn(initialPos = 48, finalPos = 88)
  private String endereco;
  @MappingIn(initialPos = 88, finalPos = 118)
  private String bairro;
  @MappingIn(initialPos = 118, finalPos = 148)
  private String cidade;
  @MappingIn(initialPos = 148, finalPos = 150)
  private String UF;
  @MappingIn(initialPos = 150, finalPos = 158)
  private String CEP;
  @MappingIn(initialPos = 158, finalPos = 168)
  private String telefone;
  @MappingIn(initialPos = 168, finalPos = 176)
  private Long cdJDEOperadora;
  @MappingIn(initialPos = 176, finalPos = 190)
  private String cnpj;
  @MappingIn(initialPos = 190, finalPos = 191)
  private String flDistribGas;
  @MappingIn(initialPos = 191, finalPos = 192, defaultValue = "Y")
  private String precoDiferente;

  public static Patient newInstance() {
    return new Patient();
  }

  public Long getCdPaciente() {
    return cdPaciente;
  }

  public void setCdPaciente(Long cdPaciente) {
    this.cdPaciente = cdPaciente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getUF() {
    return UF;
  }

  public void setUF(String UF) {
    this.UF = UF;
  }

  public String getCEP() {
    return CEP;
  }

  public void setCEP(String CEP) {
    this.CEP = CEP;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Long getCdJDEOperadora() {
    return cdJDEOperadora;
  }

  public void setCdJDEOperadora(Long cdJDEOperadora) {
    this.cdJDEOperadora = cdJDEOperadora;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getFlDistribGas() {
    return flDistribGas;
  }

  public void setFlDistribGas(String flDistribGas) {
    this.flDistribGas = flDistribGas;
  }

  public String getPrecoDiferente() {
    return precoDiferente;
  }

  public void setPrecoDiferente(String precoDiferente) {
    this.precoDiferente = precoDiferente;
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
    PatientDao dao = DatabaseApp.self().getDatabase().patientDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    PatientDao dao = DatabaseApp.self().getDatabase().patientDao();
    dao.deleteAll(dao.getAll());
  }

  public Patient isPaciente() {
    PatientDao dao = DatabaseApp.self().getDatabase().patientDao();
    return dao.findById(this.getCdPaciente());
  }


  @SuppressLint("DefaultLocale")
  @Override
  public String toString() {
    return String.format(Locale.getDefault(), "%s %s\n%s",
      cdPaciente, cnpj, nome);
  }
}
