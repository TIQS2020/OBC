package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import br.com.whitemartins.obc.dao.CustomerDao;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
@FileInfo(lineLength = 501)
public class Customer extends MockRecord implements Serializable {
  public static final long serialVersionUID = 1L;

  @PrimaryKey
  @MappingIn(initialPos = 0, finalPos = 8, defaultValue = "0")
  private Long cdCustomer;
  @MappingIn(initialPos = 8, finalPos = 48, defaultValue = "0")
  private String nome;
  @MappingIn(initialPos = 48, finalPos = 88, defaultValue = "0")
  private String endereco;
  @MappingIn(initialPos = 88, finalPos = 118, defaultValue = "0")
  private String bairro;
  @MappingIn(initialPos = 118, finalPos = 148, defaultValue = "0")
  private String cidade;
  @MappingIn(initialPos = 148, finalPos = 150, defaultValue = "0")
  private String uf;
  @MappingIn(initialPos = 150, finalPos = 158, defaultValue = "0")
  private String cep;
  @MappingIn(initialPos = 158, finalPos = 168, defaultValue = "0")
  private String telefone;
  @MappingIn(initialPos = 168, finalPos = 176, dateFormat = "ddMMyyyy")
  @TypeConverters(DateTypeConverter.class)
  private Date dtPesquisa;
  @MappingIn(initialPos = 176, finalPos = 177, defaultValue = "0")
  private Integer situacaoTributariaPis; // 1-Tributável 2-isento 3-Outros
  @MappingIn(initialPos = 177, finalPos = 178, defaultValue = "0")
  private Integer situacaoTributariaCofins; // 1-Tributável 2-isento 3-Outros
  @MappingIn(initialPos = 178, finalPos = 180, defaultValue = "0")
  private String cstPisE;
  @MappingIn(initialPos = 180, finalPos = 182, defaultValue = "0")
  private String cstPisS;
  @MappingIn(initialPos = 182, finalPos = 184, defaultValue = "0")
  private String cstCofinsE;
  @MappingIn(initialPos = 184, finalPos = 186, defaultValue = "0")
  private String cstCofinsS;
  @MappingIn(initialPos = 186, finalPos = 187, defaultValue = "0")
  private String flDistribGas; //Y/N
  @MappingIn(initialPos = 187, finalPos = 188, defaultValue = "N")
  private String flPaciente; //Y/N
  @MappingIn(initialPos = 188, finalPos = 207, defaultValue = "0")
  private String inscEstadual; //Y/N
  @MappingIn(initialPos = 207, finalPos = 208, defaultValue = "0")
  private String tipoCnpjCpf; // 1-CPF 2-CNPJ
  @MappingIn(initialPos = 208, finalPos = 222, defaultValue = "0")
  private String cnpj;
  @MappingIn(initialPos = 223, finalPos = 224, defaultValue = "0")
  private String flPesquisa;
  @MappingIn(initialPos = 224, finalPos = 236, defaultValue = "0")
  private Double limiteCredito;

  @MappingIn(initialPos = 236, finalPos = 244, dateFormat = "ddMMyyyy")
  @TypeConverters(DateTypeConverter.class)
  private Date dtVigencia;
  @MappingIn(initialPos = 244, finalPos = 249, defaultValue = "0")
  private Long cdCiaFiscal;
  @MappingIn(initialPos = 249, finalPos = 250, defaultValue = "0")
  private String flReducaoIcms;

//  @MappingIn(initialPos = 250, finalPos = 251, defaultValue = "0")
//  private String bloquear_venda;

  @MappingIn(initialPos = 8, finalPos = 40, defaultValue = "0")
  private String flCredito;
  @MappingIn(initialPos = 252, finalPos = 253, defaultValue = "N")
  private String flSimplesFaturamento;
  @MappingIn(initialPos = 256, finalPos = 257, defaultValue = "N")
  private String permitirCheque;
  @MappingIn(initialPos = 257, finalPos = 258, defaultValue = "N")
  private String permitirFatura;
  @MappingIn(initialPos = 258, finalPos = 259, defaultValue = "Y")
  private String permitirDinheiro;
//  @MappingIn(initialPos = 260, finalPos = 265, defaultValue = "0")
//  private Double taxa_rotativo;
//  @MappingIn(initialPos = 8, finalPos = 40, defaultValue = "0")
//  private String banco_rotativo;
//  @MappingIn(initialPos = 8, finalPos = 40, defaultValue = "0")
//  private String contrato_rotativo;
//  @MappingIn(initialPos = 8, finalPos = 40, defaultValue = "0")
//  private Double taxa_pontual;
//  @MappingIn(initialPos = 8, finalPos = 40, defaultValue = "0")
//  private String banco_pontual;
//  @MappingIn(initialPos = 8, finalPos = 40, defaultValue = "0")
//  private String contrato_pontual;

  @MappingIn(initialPos = 331, finalPos = 332, defaultValue = "")
  private Integer situacaoTributariaIpi; // 1-Tributável 2-isento 3-Outros
  @MappingIn(initialPos = 332, finalPos = 336, defaultValue = "")
  private String unidResponsaval;
  @MappingIn(initialPos = 336, finalPos = 337, defaultValue = "")
  private String consumidorFinal;
  @MappingIn(initialPos = 337, finalPos = 338, defaultValue = "")
  private Integer classeContrib; // 1 - Contribuinte/Não consumidor, 2 - Não Contribuinte/Consumidor, 3 - Contribuinte/Consumidor)
  @MappingIn(initialPos = 338, finalPos = 339, defaultValue = "0")
  private Integer descontoIcmsOrgaoPublico; //Desconto de órgão público ICMS
  @MappingIn(initialPos = 339, finalPos = 340, defaultValue = "0")
  private Integer situacaoTributariaIcms; // 1-Tributável 2-isento 3-Outros
  @MappingIn(initialPos = 340, finalPos = 341, defaultValue = "0")
  private String flFilialWm;
  @MappingIn(initialPos = 341, finalPos = 371, defaultValue = "")
  private String nomeMotorista;
  @MappingIn(initialPos = 371, finalPos = 401, defaultValue = "")
  private String nomeContato;
  @MappingIn(initialPos = 401, finalPos = 431, defaultValue = "")
  private String cargoContato;
  @MappingIn(initialPos = 431, finalPos = 441, defaultValue = "")
  private String telefoneContato;
  @MappingIn(initialPos = 441, finalPos = 443, defaultValue = "")
  private String flNovoFaturamento;
  @MappingIn(initialPos = 443, finalPos = 451, defaultValue = "0")
  private Long cdJdeOperadora;

  @Ignore
  private Customer customerSevice;

  public Customer() {

  }

  public static Customer newInstance() {
    return new Customer();
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
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

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Date getDtPesquisa() {
    return dtPesquisa;
  }

  public void setDtPesquisa(Date dtPesquisa) {
    this.dtPesquisa = dtPesquisa;
  }

  public Integer getSituacaoTributariaPis() {
    return situacaoTributariaPis;
  }

  public void setSituacaoTributariaPis(Integer situacaoTributariaPis) {
    this.situacaoTributariaPis = situacaoTributariaPis;
  }

  public Integer getSituacaoTributariaCofins() {
    return situacaoTributariaCofins;
  }

  public void setSituacaoTributariaCofins(Integer situacaoTributariaCofins) {
    this.situacaoTributariaCofins = situacaoTributariaCofins;
  }

  public String getCstPisE() {
    return cstPisE;
  }

  public void setCstPisE(String cstPisE) {
    this.cstPisE = cstPisE;
  }

  public String getCstPisS() {
    return cstPisS;
  }

  public void setCstPisS(String cstPisS) {
    this.cstPisS = cstPisS;
  }

  public String getCstCofinsE() {
    return cstCofinsE;
  }

  public void setCstCofinsE(String cstCofinsE) {
    this.cstCofinsE = cstCofinsE;
  }

  public String getCstCofinsS() {
    return cstCofinsS;
  }

  public void setCstCofinsS(String cstCofinsS) {
    this.cstCofinsS = cstCofinsS;
  }

  public String getFlDistribGas() {
    return flDistribGas;
  }

  public void setFlDistribGas(String flDistribGas) {
    this.flDistribGas = flDistribGas;
  }

  public String getFlPaciente() {
    return flPaciente;
  }

  public void setFlPaciente(String flPaciente) {
    this.flPaciente = flPaciente;
  }

  public String getInscEstadual() {
    return inscEstadual;
  }

  public void setInscEstadual(String inscEstadual) {
    this.inscEstadual = inscEstadual;
  }

  public String getTipoCnpjCpf() {
    return tipoCnpjCpf;
  }

  public void setTipoCnpjCpf(String tipoCnpjCpf) {
    this.tipoCnpjCpf = tipoCnpjCpf;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getFlPesquisa() {
    return flPesquisa;
  }

  public void setFlPesquisa(String flPesquisa) {
    this.flPesquisa = flPesquisa;
  }

  public Double getLimiteCredito() {
    return limiteCredito;
  }

  public void setLimiteCredito(Double limiteCredito) {
    this.limiteCredito = limiteCredito;
  }

  public Date getDtVigencia() {
    return dtVigencia;
  }

  public void setDtVigencia(Date dtVigencia) {
    this.dtVigencia = dtVigencia;
  }

  public Long getCdCiaFiscal() {
    return cdCiaFiscal;
  }

  public void setCdCiaFiscal(Long cdCiaFiscal) {
    this.cdCiaFiscal = cdCiaFiscal;
  }

  public String getFlReducaoIcms() {
    return flReducaoIcms;
  }

  public void setFlReducaoIcms(String flReducaoIcms) {
    this.flReducaoIcms = flReducaoIcms;
  }

  public String getFlCredito() {
    return flCredito;
  }

  public void setFlCredito(String flCredito) {
    this.flCredito = flCredito;
  }

  public String getFlSimplesFaturamento() {
    return flSimplesFaturamento;
  }

  public void setFlSimplesFaturamento(String flSimplesFaturamento) {
    this.flSimplesFaturamento = flSimplesFaturamento;
  }

  public String getPermitirCheque() {
    return permitirCheque;
  }

  public void setPermitirCheque(String permitirCheque) {
    this.permitirCheque = permitirCheque;
  }

  public String getPermitirFatura() {
    return permitirFatura;
  }

  public void setPermitirFatura(String permitirFatura) {
    this.permitirFatura = permitirFatura;
  }

  public String getPermitirDinheiro() {
    return permitirDinheiro;
  }

  public void setPermitirDinheiro(String permitirDinheiro) {
    this.permitirDinheiro = permitirDinheiro;
  }

  public Integer getSituacaoTributariaIpi() {
    return situacaoTributariaIpi;
  }

  public void setSituacaoTributariaIpi(Integer situacaoTributariaIpi) {
    this.situacaoTributariaIpi = situacaoTributariaIpi;
  }

  public String getUnidResponsaval() {
    return unidResponsaval;
  }

  public void setUnidResponsaval(String unidResponsaval) {
    this.unidResponsaval = unidResponsaval;
  }

  public String getConsumidorFinal() {
    return consumidorFinal;
  }

  public void setConsumidorFinal(String consumidorFinal) {
    this.consumidorFinal = consumidorFinal;
  }

  public Integer getClasseContrib() {
    return classeContrib;
  }

  public void setClasseContrib(Integer classeContrib) {
    this.classeContrib = classeContrib;
  }

  public Integer getDescontoIcmsOrgaoPublico() {
    return descontoIcmsOrgaoPublico;
  }

  public void setDescontoIcmsOrgaoPublico(Integer descontoIcmsOrgaoPublico) {
    this.descontoIcmsOrgaoPublico = descontoIcmsOrgaoPublico;
  }

  public Integer getSituacaoTributariaIcms() {
    return situacaoTributariaIcms;
  }

  public void setSituacaoTributariaIcms(Integer situacaoTributariaIcms) {
    this.situacaoTributariaIcms = situacaoTributariaIcms;
  }

  public String getFlFilialWm() {
    return flFilialWm;
  }

  public void setFlFilialWm(String flFilialWm) {
    this.flFilialWm = flFilialWm;
  }

  public String getNomeMotorista() {
    return nomeMotorista;
  }

  public void setNomeMotorista(String nomeMotorista) {
    this.nomeMotorista = nomeMotorista;
  }

  public String getNomeContato() {
    return nomeContato;
  }

  public void setNomeContato(String nomeContato) {
    this.nomeContato = nomeContato;
  }

  public String getCargoContato() {
    return cargoContato;
  }

  public void setCargoContato(String cargoContato) {
    this.cargoContato = cargoContato;
  }

  public String getTelefoneContato() {
    return telefoneContato;
  }

  public void setTelefoneContato(String telefoneContato) {
    this.telefoneContato = telefoneContato;
  }

  public String getFlNovoFaturamento() {
    return flNovoFaturamento;
  }

  public void setFlNovoFaturamento(String flNovoFaturamento) {
    this.flNovoFaturamento = flNovoFaturamento;
  }

  public Long getCdJdeOperadora() {
    return cdJdeOperadora;
  }

  public void setCdJdeOperadora(Long cdJdeOperadora) {
    this.cdJdeOperadora = cdJdeOperadora;
  }

  public Customer getCustomerSevice() {
    return customerSevice;
  }

  public void setCustomerSevice(Customer customerSevice) {
    this.customerSevice = customerSevice;
  }

  public void parseLine(String line) {
    this.automaticParseIn(line);
  }

  @Override
  public boolean isValid() {
    return true;
  }

  public void save() {
    CustomerDao dao = DatabaseApp.self().getDatabase().customerDao();
    dao.insert(this);
  }

  @Override
  public void deleteAll() {
    CustomerDao dao = DatabaseApp.self().getDatabase().customerDao();
    dao.deleteAll(dao.getAll());
  }

  @Override
  public String toString() {
    return String.format(Locale.getDefault(), "%s %s\n%s",
      UtilHelper.padRight(cdCustomer.toString(), ' ', 8),
      cnpj, nome);
  }
}