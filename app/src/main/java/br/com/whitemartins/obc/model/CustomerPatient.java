package br.com.whitemartins.obc.model;

import java.util.Locale;

import br.com.whitemartins.obc.util.UtilHelper;

public class CustomerPatient {

  private Long codigo;
  private String nome;
  private String cnpj;

  public CustomerPatient(Long codigo, String nome, String cnpj) {
    this.codigo = codigo;
    this.nome = nome;
    this.cnpj = cnpj;
  }

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  @Override
  public String toString() {
    return String.format(Locale.getDefault(), "%s %s\n%s",
      UtilHelper.padRight(getCodigo().toString(), ' ', 8),
      cnpj, nome.trim());
  }
}
