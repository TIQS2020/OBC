package br.com.whitemartins.obc.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.whitemartins.obc.dao.RouteDao;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.FileInfo;
import br.com.whitemartins.obc.interafce.MappingIn;
import br.com.whitemartins.obc.views.DatabaseApp;

@Entity
@FileInfo(lineLength = 792)
public class Route extends MockRecord implements Serializable {
  private static final long serialVersionUID = 1L;

  @MappingIn(initialPos = 0, finalPos = 4)
  private String cdFilial;
  @MappingIn(initialPos = 4, finalPos = 8)
  private String numAlmoxarifado;
  @PrimaryKey
  @MappingIn(initialPos = 8, finalPos = 14)
  private Integer cdRota;
  @MappingIn(initialPos = 14, finalPos = 19)
  private String numVeiculo;
  @MappingIn(initialPos = 19, finalPos = 23)
  private String numeroMotorista;
  @MappingIn(initialPos = 23, finalPos = 29)
  private Long numeroViagem;
  @MappingIn(initialPos = 29, finalPos = 35)
  private String cdFilialJde;
  @MappingIn(initialPos = 35, finalPos = 40)
  private String cdCompanhia;
  @MappingIn(initialPos = 40, finalPos = 41)
  private String pesquisaHabilitada;
  @MappingIn(initialPos = 41, finalPos = 42)
  private String modeloDoc;
  @MappingIn(initialPos = 42, finalPos = 43)
  private String modeloCec;
  @MappingIn(initialPos = 73, finalPos = 113)
  private String nomeFilial;
  @MappingIn(initialPos = 113, finalPos = 153)
  private String endereco;
  @MappingIn(initialPos = 153, finalPos = 183)
  private String bairro;
  @MappingIn(initialPos = 183, finalPos = 213)
  private String cidade;
  @MappingIn(initialPos = 213, finalPos = 215)
  private String uf;
  @MappingIn(initialPos = 215, finalPos = 224)
  private String cep;
  @MappingIn(initialPos = 224, finalPos = 225)
  private String tipoCnpj;
  @MappingIn(initialPos = 225, finalPos = 239)
  private String cnpj;
  @MappingIn(initialPos = 239, finalPos = 253)
  private String inscEstadual;
  @MappingIn(initialPos = 253, finalPos = 273)
  private String telefone;
  @MappingIn(initialPos = 273, finalPos = 293)
  private String numeroModem;
  @MappingIn(initialPos = 295, finalPos = 296)
  private Integer intervalo;
  @MappingIn(initialPos = 293, finalPos = 295)
  private Integer intervaloTempo;
  //-------------------
  @MappingIn(initialPos = 430, finalPos = 470)
  private String razaoSocial;
  @MappingIn(initialPos = 470, finalPos = 479, decimals = 4)
  private Double valorIndenizacaoAlta;
  @MappingIn(initialPos = 480, finalPos = 489, decimals = 4)
  private Double valorIndenizacaoBaixa;
  @MappingIn(initialPos = 490, finalPos = 499, decimals = 4)
  private Double valorIndenizacaoLS;
  @MappingIn(initialPos = 499, finalPos = 500)
  private String integDI;
  @MappingIn(initialPos = 500, finalPos = 510)
  private String descDesp1;
  @MappingIn(initialPos = 510, finalPos = 520)
  private String descDesp2;
  @MappingIn(initialPos = 520, finalPos = 530)
  private String descDesp3;
  @MappingIn(initialPos = 530, finalPos = 540)
  private String descDesp4;
  @MappingIn(initialPos = 540, finalPos = 541)
  private String adicionarCliente;
  @MappingIn(initialPos = 541, finalPos = 542)
  private String alterarPrecoObc;
  @MappingIn(initialPos = 542, finalPos = 543)
  private String solicitarOdometroParada;
  @MappingIn(initialPos = 543, finalPos = 544)
  private String permitirTroca;
  @MappingIn(initialPos = 544, finalPos = 547)
  private String tipoFilial;
  @MappingIn(initialPos = 547, finalPos = 548)
  private String forcarContagemFisica;
  @MappingIn(initialPos = 548, finalPos = 551)
  private String ultimaContagemSenha;
  @MappingIn(initialPos = 551, finalPos = 552)
  private String imprimirVariacaoPreco;
  @MappingIn(initialPos = 552, finalPos = 560)
  private String senhaComunicacao;
  @MappingIn(initialPos = 568, finalPos = 569)
  private String habilitarImpressora;
  @MappingIn(initialPos = 569, finalPos = 570)
  private String fatiaAutomaticaPreco;
  @MappingIn(initialPos = 570, finalPos = 571)
  private String imprimirPreorderDepois;
  @MappingIn(initialPos = 571, finalPos = 572)
  private String flPrecoPreorder;
  @MappingIn(initialPos = 572, finalPos = 573)
  private Integer statusRastrebilidade;
  @MappingIn(initialPos = 573, finalPos = 574)
  private String tipoImpressao;
  @MappingIn(initialPos = 574, finalPos = 575)
  private String tipoImpressora;
  @MappingIn(initialPos = 575, finalPos = 576)
  private String mostrarDescontoMotorista;
  @MappingIn(initialPos = 576, finalPos = 577)
  private String imprimirQtdNota;
  @MappingIn(initialPos = 597, finalPos = 598)
  private String imprimirContagem;
  @MappingIn(initialPos = 598, finalPos = 599)
  private Integer tipoCargaVeiculo;
  @MappingIn(initialPos = 599, finalPos = 602)
  private String checkDiscoVazio;
  @MappingIn(initialPos = 602, finalPos = 603)
  private String relatorioAuditoria;
  @MappingIn(initialPos = 603, finalPos = 604)
  private String clienteSemServico;
  @MappingIn(initialPos = 604, finalPos = 605)
  private String abatimento; //settlement
  @MappingIn(initialPos = 605, finalPos = 606)
  private String registroNota;
  @MappingIn(initialPos = 606, finalPos = 607)
  private String relatorioDespesas;
  @MappingIn(initialPos = 607, finalPos = 608)
  private String avaliacaoInventario;
  @MappingIn(initialPos = 608, finalPos = 609)
  private String resumoViriacao;
  @MappingIn(initialPos = 609, finalPos = 610)
  private String relatorioData;
  @MappingIn(initialPos = 610, finalPos = 611)
  private String contaPagamento;
  @MappingIn(initialPos = 611, finalPos = 612)
  private String transferencia;
  @MappingIn(initialPos = 612, finalPos = 613)
  private String deposito;
  @MappingIn(initialPos = 613, finalPos = 614)
  private String viagemMultipla;
  @MappingIn(initialPos = 614, finalPos = 615)
  private String medidorVazao;
  @MappingIn(initialPos = 615, finalPos = 616)
  private String obc6110;
  @MappingIn(initialPos = 616, finalPos = 617)
  private String ativarRastreabilidade;
  @MappingIn(initialPos = 617, finalPos = 647)
  private String razaoSocialTransp;
  @MappingIn(initialPos = 647, finalPos = 687)
  private String enderecoTrasnp;
  @MappingIn(initialPos = 687, finalPos = 717)
  private String cidadeTransp;
  @MappingIn(initialPos = 717, finalPos = 719)
  private String estadoTransp;
  @MappingIn(initialPos = 719, finalPos = 726)
  private String placaVeiculo;
  @MappingIn(initialPos = 726, finalPos = 728)
  private String UfVeiculo;
  @MappingIn(initialPos = 728, finalPos = 729)
  private String tipoCnpjTransp;
  @MappingIn(initialPos = 729, finalPos = 743)
  private String cnpjTransp;
  @MappingIn(initialPos = 759, finalPos = 760)
  private String tipoPagamento;
  @MappingIn(initialPos = 774, finalPos = 775)
  private String reimprimirNota;
  @MappingIn(initialPos = 775, finalPos = 776)
  private String remeterPara;
  @MappingIn(initialPos = 776, finalPos = 781)
  private String setupModem;
  @MappingIn(initialPos = 781, finalPos = 782)
  private String tipoDiscagem;
  @MappingIn(initialPos = 782, finalPos = 783)
  private String tipoConexao;
  @MappingIn(initialPos = 783, finalPos = 791, dateFormat = "ddMMyyyy")
  private Date dataViagem;
  @MappingIn(initialPos = 791, finalPos = 792)
//  private String fixoN;
  private String imei;
  private String bloqViagem;

  public Route() {
    this.bloqViagem = "N";
  }

  public String getCdFilial() {
    return cdFilial;
  }

  public void setCdFilial(String cdFilial) {
    this.cdFilial = cdFilial;
  }

  public Integer getCdRota() {
    return cdRota;
  }

  public void setCdRota(Integer cdRota) {
    this.cdRota = cdRota;
  }

  public String getNumAlmoxarifado() {
    return numAlmoxarifado;
  }

  public void setNumAlmoxarifado(String numAlmoxarifado) {
    this.numAlmoxarifado = numAlmoxarifado;
  }

  public String getNumVeiculo() {
    return numVeiculo;
  }

  public void setNumVeiculo(String numVeiculo) {
    this.numVeiculo = numVeiculo;
  }

  public String getNumeroMotorista() {
    return numeroMotorista;
  }

  public void setNumeroMotorista(String numeroMotorista) {
    this.numeroMotorista = numeroMotorista;
  }

  public Long getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(Long numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public String getCdFilialJde() {
    return cdFilialJde;
  }

  public void setCdFilialJde(String cdFilialJde) {
    this.cdFilialJde = cdFilialJde;
  }

  public String getCdCompanhia() {
    return cdCompanhia;
  }

  public void setCdCompanhia(String cdCompanhia) {
    this.cdCompanhia = cdCompanhia;
  }

  public String getPesquisaHabilitada() {
    return pesquisaHabilitada;
  }

  public void setPesquisaHabilitada(String pesquisaHabilitada) {
    this.pesquisaHabilitada = pesquisaHabilitada;
  }

  public String getModeloDoc() {
    return modeloDoc;
  }

  public void setModeloDoc(String modeloDoc) {
    this.modeloDoc = modeloDoc;
  }

  public String getModeloCec() {
    return modeloCec;
  }

  public void setModeloCec(String modeloCec) {
    this.modeloCec = modeloCec;
  }

  public String getNomeFilial() {
    return nomeFilial;
  }

  public void setNomeFilial(String nomeFilial) {
    this.nomeFilial = nomeFilial;
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

  public String getTipoCnpj() {
    return tipoCnpj;
  }

  public void setTipoCnpj(String tipoCnpj) {
    this.tipoCnpj = tipoCnpj;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getInscEstadual() {
    return inscEstadual;
  }

  public void setInscEstadual(String inscEstadual) {
    this.inscEstadual = inscEstadual;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getNumeroModem() {
    return numeroModem;
  }

  public void setNumeroModem(String numeroModem) {
    this.numeroModem = numeroModem;
  }

  public Integer getIntervalo() {
    return intervalo;
  }

  public void setIntervalo(Integer intervalo) {
    this.intervalo = intervalo;
  }

  public Integer getIntervaloTempo() {
    return intervaloTempo;
  }

  public void setIntervaloTempo(Integer intervaloTempo) {
    this.intervaloTempo = intervaloTempo;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public Double getValorIndenizacaoAlta() {
    return valorIndenizacaoAlta;
  }

  public void setValorIndenizacaoAlta(Double valorIndenizacaoAlta) {
    this.valorIndenizacaoAlta = valorIndenizacaoAlta;
  }

  public Double getValorIndenizacaoBaixa() {
    return valorIndenizacaoBaixa;
  }

  public void setValorIndenizacaoBaixa(Double valorIndenizacaoBaixa) {
    this.valorIndenizacaoBaixa = valorIndenizacaoBaixa;
  }

  public Double getValorIndenizacaoLS() {
    return valorIndenizacaoLS;
  }

  public void setValorIndenizacaoLS(Double valorIndenizacaoLS) {
    this.valorIndenizacaoLS = valorIndenizacaoLS;
  }

  public String getIntegDI() {
    return integDI;
  }

  public void setIntegDI(String integDI) {
    this.integDI = integDI;
  }

  public String getDescDesp1() {
    return descDesp1;
  }

  public void setDescDesp1(String descDesp1) {
    this.descDesp1 = descDesp1;
  }

  public String getDescDesp2() {
    return descDesp2;
  }

  public void setDescDesp2(String descDesp2) {
    this.descDesp2 = descDesp2;
  }

  public String getDescDesp3() {
    return descDesp3;
  }

  public void setDescDesp3(String descDesp3) {
    this.descDesp3 = descDesp3;
  }

  public String getDescDesp4() {
    return descDesp4;
  }

  public void setDescDesp4(String descDesp4) {
    this.descDesp4 = descDesp4;
  }

  public String getAdicionarCliente() {
    return adicionarCliente;
  }

  public void setAdicionarCliente(String adicionarCliente) {
    this.adicionarCliente = adicionarCliente;
  }

  public String getAlterarPrecoObc() {
    return alterarPrecoObc;
  }

  public void setAlterarPrecoObc(String alterarPrecoObc) {
    this.alterarPrecoObc = alterarPrecoObc;
  }

  public String getSolicitarOdometroParada() {
    return solicitarOdometroParada;
  }

  public void setSolicitarOdometroParada(String solicitarOdometroParada) {
    this.solicitarOdometroParada = solicitarOdometroParada;
  }

  public String getPermitirTroca() {
    return permitirTroca;
  }

  public void setPermitirTroca(String permitirTroca) {
    this.permitirTroca = permitirTroca;
  }

  public String getTipoFilial() {
    return tipoFilial;
  }

  public void setTipoFilial(String tipoFilial) {
    this.tipoFilial = tipoFilial;
  }

  public String getForcarContagemFisica() {
    return forcarContagemFisica;
  }

  public void setForcarContagemFisica(String forcarContagemFisica) {
    this.forcarContagemFisica = forcarContagemFisica;
  }

  public String getUltimaContagemSenha() {
    return ultimaContagemSenha;
  }

  public void setUltimaContagemSenha(String ultimaContagemSenha) {
    this.ultimaContagemSenha = ultimaContagemSenha;
  }

  public String getImprimirVariacaoPreco() {
    return imprimirVariacaoPreco;
  }

  public void setImprimirVariacaoPreco(String imprimirVariacaoPreco) {
    this.imprimirVariacaoPreco = imprimirVariacaoPreco;
  }

  public String getSenhaComunicacao() {
    return senhaComunicacao;
  }

  public void setSenhaComunicacao(String senhaComunicacao) {
    this.senhaComunicacao = senhaComunicacao;
  }

  public String getHabilitarImpressora() {
    return habilitarImpressora;
  }

  public void setHabilitarImpressora(String habilitarImpressora) {
    this.habilitarImpressora = habilitarImpressora;
  }

  public String getFatiaAutomaticaPreco() {
    return fatiaAutomaticaPreco;
  }

  public void setFatiaAutomaticaPreco(String fatiaAutomaticaPreco) {
    this.fatiaAutomaticaPreco = fatiaAutomaticaPreco;
  }

  public String getImprimirPreorderDepois() {
    return imprimirPreorderDepois;
  }

  public void setImprimirPreorderDepois(String imprimirPreorderDepois) {
    this.imprimirPreorderDepois = imprimirPreorderDepois;
  }

  public String getFlPrecoPreorder() {
    return flPrecoPreorder;
  }

  public void setFlPrecoPreorder(String flPrecoPreorder) {
    this.flPrecoPreorder = flPrecoPreorder;
  }

  public Integer getStatusRastrebilidade() {
    return statusRastrebilidade;
  }

  public void setStatusRastrebilidade(Integer statusRastrebilidade) {
    this.statusRastrebilidade = statusRastrebilidade;
  }

  public String getTipoImpressao() {
    return tipoImpressao;
  }

  public void setTipoImpressao(String tipoImpressao) {
    this.tipoImpressao = tipoImpressao;
  }

  public String getTipoImpressora() {
    return tipoImpressora;
  }

  public void setTipoImpressora(String tipoImpressora) {
    this.tipoImpressora = tipoImpressora;
  }

  public String getMostrarDescontoMotorista() {
    return mostrarDescontoMotorista;
  }

  public void setMostrarDescontoMotorista(String mostrarDescontoMotorista) {
    this.mostrarDescontoMotorista = mostrarDescontoMotorista;
  }

  public String getImprimirQtdNota() {
    return imprimirQtdNota;
  }

  public void setImprimirQtdNota(String imprimirQtdNota) {
    this.imprimirQtdNota = imprimirQtdNota;
  }

  public String getImprimirContagem() {
    return imprimirContagem;
  }

  public void setImprimirContagem(String imprimirContagem) {
    this.imprimirContagem = imprimirContagem;
  }

  public Integer getTipoCargaVeiculo() {
    return tipoCargaVeiculo;
  }

  public void setTipoCargaVeiculo(Integer tipoCargaVeiculo) {
    this.tipoCargaVeiculo = tipoCargaVeiculo;
  }

  public String getCheckDiscoVazio() {
    return checkDiscoVazio;
  }

  public void setCheckDiscoVazio(String checkDiscoVazio) {
    this.checkDiscoVazio = checkDiscoVazio;
  }

  public String getRelatorioAuditoria() {
    return relatorioAuditoria;
  }

  public void setRelatorioAuditoria(String relatorioAuditoria) {
    this.relatorioAuditoria = relatorioAuditoria;
  }

  public String getClienteSemServico() {
    return clienteSemServico;
  }

  public void setClienteSemServico(String clienteSemServico) {
    this.clienteSemServico = clienteSemServico;
  }

  public String getAbatimento() {
    return abatimento;
  }

  public void setAbatimento(String abatimento) {
    this.abatimento = abatimento;
  }

  public String getRegistroNota() {
    return registroNota;
  }

  public void setRegistroNota(String registroNota) {
    this.registroNota = registroNota;
  }

  public String getRelatorioDespesas() {
    return relatorioDespesas;
  }

  public void setRelatorioDespesas(String relatorioDespesas) {
    this.relatorioDespesas = relatorioDespesas;
  }

  public String getAvaliacaoInventario() {
    return avaliacaoInventario;
  }

  public void setAvaliacaoInventario(String avaliacaoInventario) {
    this.avaliacaoInventario = avaliacaoInventario;
  }

  public String getResumoViriacao() {
    return resumoViriacao;
  }

  public void setResumoViriacao(String resumoViriacao) {
    this.resumoViriacao = resumoViriacao;
  }

  public String getRelatorioData() {
    return relatorioData;
  }

  public void setRelatorioData(String relatorioData) {
    this.relatorioData = relatorioData;
  }

  public String getContaPagamento() {
    return contaPagamento;
  }

  public void setContaPagamento(String contaPagamento) {
    this.contaPagamento = contaPagamento;
  }

  public String getTransferencia() {
    return transferencia;
  }

  public void setTransferencia(String transferencia) {
    this.transferencia = transferencia;
  }

  public String getDeposito() {
    return deposito;
  }

  public void setDeposito(String deposito) {
    this.deposito = deposito;
  }

  public String getViagemMultipla() {
    return viagemMultipla;
  }

  public void setViagemMultipla(String viagemMultipla) {
    this.viagemMultipla = viagemMultipla;
  }

  public String getMedidorVazao() {
    return medidorVazao;
  }

  public void setMedidorVazao(String medidorVazao) {
    this.medidorVazao = medidorVazao;
  }

  public String getObc6110() {
    return obc6110;
  }

  public void setObc6110(String obc6110) {
    this.obc6110 = obc6110;
  }

  public String getAtivarRastreabilidade() {
    return ativarRastreabilidade;
  }

  public void setAtivarRastreabilidade(String ativarRastreabilidade) {
    this.ativarRastreabilidade = ativarRastreabilidade;
  }

  public String getRazaoSocialTransp() {
    return razaoSocialTransp;
  }

  public void setRazaoSocialTransp(String razaoSocialTransp) {
    this.razaoSocialTransp = razaoSocialTransp;
  }

  public String getEnderecoTrasnp() {
    return enderecoTrasnp;
  }

  public void setEnderecoTrasnp(String enderecoTrasnp) {
    this.enderecoTrasnp = enderecoTrasnp;
  }

  public String getCidadeTransp() {
    return cidadeTransp;
  }

  public void setCidadeTransp(String cidadeTransp) {
    this.cidadeTransp = cidadeTransp;
  }

  public String getEstadoTransp() {
    return estadoTransp;
  }

  public void setEstadoTransp(String estadoTransp) {
    this.estadoTransp = estadoTransp;
  }

  public String getPlacaVeiculo() {
    return placaVeiculo;
  }

  public void setPlacaVeiculo(String placaVeiculo) {
    this.placaVeiculo = placaVeiculo;
  }

  public String getUfVeiculo() {
    return UfVeiculo;
  }

  public void setUfVeiculo(String ufVeiculo) {
    this.UfVeiculo = ufVeiculo;
  }

  public String getTipoCnpjTransp() {
    return tipoCnpjTransp;
  }

  public void setTipoCnpjTransp(String tipoCnpjTransp) {
    this.tipoCnpjTransp = tipoCnpjTransp;
  }

  public String getCnpjTransp() {
    return cnpjTransp;
  }

  public void setCnpjTransp(String cnpjTransp) {
    this.cnpjTransp = cnpjTransp;
  }

  public String getTipoPagamento() {
    return tipoPagamento;
  }

  public void setTipoPagamento(String tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
  }

  public String getReimprimirNota() {
    return reimprimirNota;
  }

  public void setReimprimirNota(String reimprimirNota) {
    this.reimprimirNota = reimprimirNota;
  }

  public String getRemeterPara() {
    return remeterPara;
  }

  public void setRemeterPara(String remeterPara) {
    this.remeterPara = remeterPara;
  }

  public String getSetupModem() {
    return setupModem;
  }

  public void setSetupModem(String setupModem) {
    this.setupModem = setupModem;
  }

  public String getTipoDiscagem() {
    return tipoDiscagem;
  }

  public void setTipoDiscagem(String tipoDiscagem) {
    this.tipoDiscagem = tipoDiscagem;
  }

  public String getTipoConexao() {
    return tipoConexao;
  }

  public void setTipoConexao(String tipoConexao) {
    this.tipoConexao = tipoConexao;
  }

  public Date getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(Date dataViagem) {


    this.dataViagem = dataViagem;

  }

//  public String getFixoN() {
//    return fixoN;
//  }
//
//  public void setFixoN(String fixoN) {
//    this.fixoN = fixoN;
//  }

  public String getImei() {
    return imei;
  }

  public void setImei(String imei) {
    this.imei = imei;
  }

  public String getBloqViagem() {
    return bloqViagem;
  }

  public void setBloqViagem(String bloqViagem) {
    this.bloqViagem = bloqViagem;
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
    if (isValid()) {
      RouteDao dao = DatabaseApp.self().getDatabase().routeDao();
      dao.insert(this);
    }
  }

  @Override
  public void deleteAll() {
    RouteDao dao = DatabaseApp.self().getDatabase().routeDao();
    List<Route> routes = dao.getAll();
    dao.deleteAll(routes);
  }



}
