package br.com.whitemartins.obc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import br.com.whitemartins.obc.dao.InvoiceDao;
import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.MovimentoIntegracaoType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.OrientationType;
import br.com.whitemartins.obc.enumeration.PrintStatusType;
import br.com.whitemartins.obc.enumeration.StatusGravJdeType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MappingOut;
import br.com.whitemartins.obc.interafce.XmlMapping;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

@Entity
public class Invoice extends MockRecord implements Serializable {

  private static final long serialVersionUID = 1L;

  private static final String NODE_CABECALHO_NFE = "cabecalhoNFe";
  private static final String NODE_DOWNLOADER_NFE = "downloader_NFe";
  private static final String NODE_FORMA_PAGAMENTO_NFE = "forma_pagamento";

  @PrimaryKey(autoGenerate = true)
  @XmlMapping(xmlTagName = "seq_num_nfe", xmlParentTagName = NODE_CABECALHO_NFE)
  private Long id;
  @MappingOut(initialPos = 8, finalPos = 14, orientation = OrientationType.LEFT, charComplete = '0')
  @XmlMapping(xmlTagName = "num_nfe", xmlParentTagName = NODE_CABECALHO_NFE)
  private Long numero;
  @XmlMapping(xmlTagName = "serie_nfe", xmlParentTagName = NODE_CABECALHO_NFE)
  @MappingOut(initialPos = 200, finalPos = 203, orientation = OrientationType.LEFT, charComplete = ' ')
  @org.simpleframework.xml.Element(required = false)
  private Long serie;
  @XmlMapping(xmlTagName = "nf_vnd_ordem", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Long numeroNotaVOR;
  private Long serieNotaVOR;
  @XmlMapping(xmlTagName = "no_order_number", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private String cdPreOrdem;
  @XmlMapping(xmlTagName = "nf_vnd_fut_entrega", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private String numeroFutEntrega;
  @XmlMapping(xmlTagName = "cd_fiscal", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Integer cdFiscal;
  @XmlMapping(xmlTagName = "cnpj_cpf_destino", xmlParentTagName = NODE_CABECALHO_NFE)
  private String cnpjCpfDestino;
  @XmlMapping(xmlTagName = "cnpj_cpf_transp", xmlParentTagName = NODE_CABECALHO_NFE)
  private String cnpjCpfTransp;
  @XmlMapping(xmlTagName = "tipo_operacao", xmlParentTagName = NODE_CABECALHO_NFE)
  private String tipoNota;
  @XmlMapping(xmlTagName = "classe_contribuinte", xmlParentTagName = NODE_CABECALHO_NFE)
  private Integer classeContribuinte;
  //  @MappingOut(initialPos = 203, finalPos = 211, orientation = OrientationType.LEFT, charComplete = '0', dateFormat = "ddMMyyyy")
  private String dataViagemPrincial;
  //  @MappingOut(initialPos = 211, finalPos = 217, orientation = OrientationType.LEFT, charComplete = '0')
  private String numeroViagem;
  //  @MappingOut(initialPos = 217, finalPos = 225, orientation = OrientationType.LEFT, charComplete = '0', dateFormat = "ddMMyyyy")
  private String dataViagem;

  private String nomeOperacao;
  @TypeConverters(DateTypeConverter.class)
  @XmlMapping(xmlTagName = "dt_emissao", xmlParentTagName = NODE_CABECALHO_NFE, dateFormat = "yyyyMMdd")
  private Date dataEmissao;
  @TypeConverters(DateTypeConverter.class)
  @MappingOut(initialPos = 14, finalPos = 28)
  @XmlMapping(xmlTagName = "dt_movimento", xmlParentTagName = NODE_CABECALHO_NFE, dateFormat = "yyyyMMdd HHmmss")
  private Date dataMovimento;
  @XmlMapping(xmlTagName = "dt_vencimento", xmlParentTagName = NODE_CABECALHO_NFE)
  private Date dataVencimento;
  //Valores
  @XmlMapping(xmlTagName = "vl_total_nfe", xmlParentTagName = NODE_CABECALHO_NFE)
  @MappingOut(initialPos = 77, finalPos = 88, orientation = OrientationType.LEFT, charComplete = '0')
  private Double valorTotal;
  @XmlMapping(xmlTagName = "vl_liq_nf", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Double valorLiquido;
  //  private Double valorDesconto;
  @XmlMapping(xmlTagName = "vl_total_prod", xmlParentTagName = NODE_CABECALHO_NFE)
  private Double valorTotalProduto;
  @XmlMapping(xmlTagName = "vl_frete", xmlParentTagName = NODE_CABECALHO_NFE)
  private Double valorFrete;
  @XmlMapping(xmlTagName = "vl_desp_acess", xmlParentTagName = NODE_CABECALHO_NFE)
  private Double valorDespAcessorias;
  @XmlMapping(xmlTagName = "vl_dinheiro", xmlParentTagName = NODE_FORMA_PAGAMENTO_NFE)
  private Double valorDinheiro;
  @XmlMapping(xmlTagName = "vl_troco", xmlParentTagName = NODE_FORMA_PAGAMENTO_NFE)
  private Double valorTroco;
  @XmlMapping(xmlTagName = "vl_fatura", xmlParentTagName = NODE_FORMA_PAGAMENTO_NFE)
  private Double valorFatura;
  @XmlMapping(xmlTagName = "vl_debito", xmlParentTagName = NODE_FORMA_PAGAMENTO_NFE)
  private Double valorDebito;
  @XmlMapping(xmlTagName = "vl_credito", xmlParentTagName = NODE_FORMA_PAGAMENTO_NFE)
  private Double valorCredito;
  @XmlMapping(xmlTagName = "vl_cheque", xmlParentTagName = NODE_FORMA_PAGAMENTO_NFE)
  private Double valorCheque;
  @XmlMapping(xmlTagName = "num_cheque", xmlParentTagName = NODE_FORMA_PAGAMENTO_NFE)
  @MappingOut(initialPos = 39, finalPos = 45, orientation = OrientationType.RIGHT, charComplete = '0')
  private String numeroCheque;
  @XmlMapping(xmlTagName = "uf_veiculo", xmlParentTagName = NODE_CABECALHO_NFE)
  private String ufVeiculo;
  @XmlMapping(xmlTagName = "placa_veiculo", xmlParentTagName = NODE_CABECALHO_NFE)
  private String placaVeiculo;
  @XmlMapping(xmlTagName = "cd_veiculo", xmlParentTagName = NODE_CABECALHO_NFE)
  private String numeroVeiculo;
  @XmlMapping(xmlTagName = "modalidade_frete", xmlParentTagName = NODE_CABECALHO_NFE)
  private Integer modalidadeFrete;
  @XmlMapping(xmlTagName = "nm_espec_volume", xmlParentTagName = NODE_CABECALHO_NFE)
  private String nomeEspecVolume;
  @XmlMapping(xmlTagName = "nm_marca", xmlParentTagName = NODE_CABECALHO_NFE)
  private String nomeMarca;
  @XmlMapping(xmlTagName = "qtd_volume", xmlParentTagName = NODE_CABECALHO_NFE)
  private Integer qtdVolumes;
  @XmlMapping(xmlTagName = "volume_capacidade", xmlParentTagName = NODE_DOWNLOADER_NFE)
//  @MappingOut(initialPos = 88, finalPos = 98, orientation = OrientationType.LEFT, charComplete = '0')
  private Double volumeCapacidade;

  @MappingOut(initialPos = 88, finalPos = 98, orientation = OrientationType.LEFT, charComplete = '0')
  private Double volumeCapacidadeReport;

  @XmlMapping(xmlTagName = "peso_bruto", xmlParentTagName = NODE_CABECALHO_NFE)
  private Double pesoBruto;
  @XmlMapping(xmlTagName = "peso_liq", xmlParentTagName = NODE_CABECALHO_NFE)
  private Double pesoLiquido;
  @XmlMapping(xmlTagName = "tipo_pedido", xmlParentTagName = NODE_CABECALHO_NFE)
  private String tipoPedido;
  @MappingOut(initialPos = 0, finalPos = 8)
  @XmlMapping(xmlTagName = "cd_cliente", xmlParentTagName = NODE_CABECALHO_NFE)
  private Long cdCustomer;
  @XmlMapping(xmlTagName = "ativa_tipo_pagto", xmlParentTagName = NODE_CABECALHO_NFE)
  private String ativaTipoPagto;

  private Integer stepEmissao;
  @XmlMapping(xmlTagName = "chave_acesso", xmlParentTagName = NODE_DOWNLOADER_NFE, suppress = true)
  private String chave;
  @XmlMapping(xmlTagName = "protocolo", xmlParentTagName = NODE_DOWNLOADER_NFE, suppress = true)
  private String protocolo;
  @XmlMapping(xmlTagName = "num_movimento", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private String cdMovimento;
  @XmlMapping(xmlTagName = "cd_pagamento", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private String condicaoPagamento;
  //Impostos
  //ICMS
  @XmlMapping(xmlTagName = "aliq_icms", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Double aliquotaIcms;
  @XmlMapping(xmlTagName = "vl_desconto", xmlParentTagName = NODE_CABECALHO_NFE)
  private Double valorDescontoIcms;
  @XmlMapping(xmlTagName = "vl_icms", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Double valorIcms;
  @XmlMapping(xmlTagName = "base_icms", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Double baseCalculoIcms;
  @XmlMapping(xmlTagName = "tipo_icms", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Integer situacaoTributariaIcms;
  //IPI
  @XmlMapping(xmlTagName = "vl_ipi", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Double valorIpi;
  @XmlMapping(xmlTagName = "base_ipi", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Double baseCalculoIpi;
  @XmlMapping(xmlTagName = "tipo_ipi", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Integer situacaoTributariaIpi;
  @XmlMapping(xmlTagName = "tipo_faturamento", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private String flNovoFaturamento;
  @XmlMapping(xmlTagName = "cd_jde_operadora", xmlParentTagName = NODE_DOWNLOADER_NFE)
  @MappingOut(initialPos = 191, finalPos = 199, orientation = OrientationType.LEFT, charComplete = '0')
  private Long cdOperadora;
  @XmlMapping(xmlTagName = "flag_paciente", xmlParentTagName = NODE_DOWNLOADER_NFE)
  @MappingOut(initialPos = 199, finalPos = 200, charComplete = 'N')
  private String flPaciente;
  @XmlMapping(xmlTagName = "cd_cliente_servico", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Long cdCustomerService;
  @XmlMapping(xmlTagName = "nm_assinador_cec", xmlParentTagName = NODE_DOWNLOADER_NFE, suppress = true)
  private String nomeAssinadorCec;
  @XmlMapping(xmlTagName = "rg_assinador_cec", xmlParentTagName = NODE_DOWNLOADER_NFE, suppress = true)
  private String rgAssinadorCec;
  private Integer tipoMovimentoIntegracao;
  @XmlMapping(xmlTagName = "sem_pagto", xmlParentTagName = NODE_CABECALHO_NFE)
  private String semPagto;
  @XmlMapping(xmlTagName = "stat_grav_jde", xmlParentTagName = NODE_CABECALHO_NFE, suppress = true)
  private Integer statusGravacaoJde;
  @XmlMapping(xmlTagName = "mens_stat_grav_jde", xmlParentTagName = NODE_CABECALHO_NFE, suppress = true)
  private String mensagemGravacaoJde;
  @XmlMapping(xmlTagName = "tipo_transacao", xmlParentTagName = NODE_DOWNLOADER_NFE)
  private Integer tipoTransacao;
  @XmlMapping(xmlTagName = "status_nfe", xmlParentTagName = NODE_DOWNLOADER_NFE, suppress = true)
  private Integer status;

  @XmlMapping(xmlTagName = "status_contigencia", xmlParentTagName = NODE_CABECALHO_NFE, suppress = true)
  private String statusContingencia;
  @XmlMapping(xmlTagName = "mensagem_contingencia", xmlParentTagName = NODE_CABECALHO_NFE, suppress = true)
  private String mensagemContingencia;

  private Integer statusCec;//OnLine OffLine
  @MappingOut(initialPos = 45, finalPos = 76)
  private String nomeTransacao;

  private Integer statusImpressaoCec; //Impresso Não Impresso
  @MappingOut(initialPos = 98, finalPos = 129, orientation = OrientationType.RIGHT, charComplete = ' ')
  private String nomeFormaImpressaoCec; //TODO: não esta preenchido no fim de viagem 1 a 8
  @MappingOut(initialPos = 129, finalPos = 160)
  private String nomeStatus; //TODO: não esta preenchido no fim de viagem CEC - descrição dos numeros
  @MappingOut(initialPos = 160, finalPos = 191) //Impresso Não Impresso
  private String nomeStatusImpressaoCec;
  @MappingOut(initialPos = 76, finalPos = 77)
  private String flPrecoAlterado;
  @MappingOut(initialPos = 28, finalPos = 39, orientation = OrientationType.RIGHT, charComplete = ' ')
  private String nomeTipoPagamento;

  private String cdMotivo;
  private String dsMotivo;
  //@MappingOut(initialPos = 98, finalPos = 129, orientation = OrientationType.RIGHT, charComplete = ' ')
  private String statusNfeImp;
  private String statusReportFile;

  //
  @Ignore
  private List<InvoiceItem> itens;

  public Invoice() {
    itens = new ArrayList<>();
    cdPreOrdem = "";
    flPrecoAlterado = ConstantsEnum.NO.getValue();
    numeroFutEntrega = "";
    numeroNotaVOR = 0L;
    serieNotaVOR = 0L;
    status = StatusNFeType.PENDENTE_ENVIO.getValue();
    dsMotivo = "";
    protocolo = "";
    statusNfeImp = "";
    statusReportFile = "";
    statusImpressaoCec = PrintStatusType.NAO_IMPRESSO.getValue();
    statusCec = PrintStatusType.NAO_IMPRESSO.getValue();
    statusGravacaoJde = StatusGravJdeType.NAO_ENVIADA.getValue();
  }

  public static Invoice newInstance() {
    return new Invoice();
  }

  public boolean isCanceled() {
    return (StatusNFeType.AUTORIZADA.getValue().equals(status)
      && MovimentoIntegracaoType.EVENTO_CANCELAMENTO.getValue().equals(tipoMovimentoIntegracao));
  }

  public boolean isFinalStatus() {
    return StatusNFeType.isFinalStatus(getStatus());
//      (status.equals(StatusNFeType.AUTORIZADA.getValue())
//      || status.equals(StatusNFeType.REJEITADA.getValue())
//      || status.equals(StatusNFeType.PROCESSAMENTO_REJEITADO.getValue())
//      || status.equals(StatusNFeType.DENEGADA.getValue()));
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getNumero() {
    return numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public Long getSerie() {
    return serie;
  }

  public void setSerie(Long serie) {
    this.serie = serie;
  }

  public String getNumeroViagem() {
    return numeroViagem;
  }

  public void setNumeroViagem(String numeroViagem) {
    this.numeroViagem = numeroViagem;
  }

  public Integer getCdFiscal() {
    return cdFiscal;
  }

  public void setCdFiscal(Integer cdFiscal) {
    this.cdFiscal = cdFiscal;
  }

  public String getCnpjCpfDestino() {
    return cnpjCpfDestino;
  }

  public void setCnpjCpfDestino(String cnpjCpfDestino) {
    this.cnpjCpfDestino = cnpjCpfDestino;
  }

  public String getCnpjCpfTransp() {
    return cnpjCpfTransp;
  }

  public void setCnpjCpfTransp(String cnpjCpfTransp) {
    this.cnpjCpfTransp = cnpjCpfTransp;
  }

  public String getTipoNota() {
    return tipoNota;
  }

  public void setTipoNota(String tipoNota) {
    this.tipoNota = tipoNota;
  }

  public Integer getClasseContribuinte() {
    return classeContribuinte;
  }

  public void setClasseContribuinte(Integer classeContribuinte) {
    this.classeContribuinte = classeContribuinte;
  }

  public String getDataViagemPrincial() {
    return dataViagemPrincial;
  }

  public void setDataViagemPrincial(String dataViagemPrincial) {
    this.dataViagemPrincial = dataViagemPrincial;
  }

  public String getDataViagem() {
    return dataViagem;
  }

  public void setDataViagem(String dataViagem) {
    this.dataViagem = dataViagem;
  }

  public String getNomeOperacao() {
    return nomeOperacao;
  }

  public void setNomeOperacao(String nomeOperacao) {
    this.nomeOperacao = nomeOperacao;
  }

  public Date getDataEmissao() {
    return dataEmissao;
  }

  public void setDataEmissao(Date dataEmissao) {
    this.dataEmissao = dataEmissao;
  }

  public Date getDataMovimento() {
    return dataMovimento;
  }

  public void setDataMovimento(Date dataMovimento) {
    this.dataMovimento = dataMovimento;
  }

  public Date getDataVencimento() {
    return dataVencimento;
  }

  public void setDataVencimento(Date dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Double getValorLiquido() {
    return valorLiquido;
  }

  public void setValorLiquido(Double valorLiquido) {
    this.valorLiquido = valorLiquido;
  }

  public String getUfVeiculo() {
    return ufVeiculo;
  }

  public void setUfVeiculo(String ufVeiculo) {
    this.ufVeiculo = ufVeiculo;
  }

  public String getPlacaVeiculo() {
    return placaVeiculo;
  }

  public void setPlacaVeiculo(String placaVeiculo) {
    this.placaVeiculo = placaVeiculo;
  }

  public Integer getModalidadeFrete() {
    return modalidadeFrete;
  }

  public void setModalidadeFrete(Integer modalidadeFrete) {
    this.modalidadeFrete = modalidadeFrete;
  }

  public String getNomeEspecVolume() {
    return nomeEspecVolume;
  }

  public void setNomeEspecVolume(String nomeEspecVolume) {
    this.nomeEspecVolume = nomeEspecVolume;
  }

  public Double getVolumeCapacidade() {
    return volumeCapacidade;
  }

  public void setVolumeCapacidade(Double volumeCapacidade) {
    this.volumeCapacidade = volumeCapacidade;
  }

  public Double getVolumeCapacidadeReport() {
    return volumeCapacidadeReport;
  }

  public void setVolumeCapacidadeReport(Double volumeCapacidadeReport) {
    this.volumeCapacidadeReport = volumeCapacidadeReport;
  }

  public String getNomeMarca() {
    return nomeMarca;
  }

  public void setNomeMarca(String nomeMarca) {
    this.nomeMarca = nomeMarca;
  }

  public Double getValorTotalProduto() {
    return valorTotalProduto;
  }

  public void setValorTotalProduto(Double valorTotalProduto) {
    this.valorTotalProduto = valorTotalProduto;
  }

  public Double getValorFrete() {
    return valorFrete;
  }

  public void setValorFrete(Double valorFrete) {
    this.valorFrete = valorFrete;
  }

  public Double getValorDespAcessorias() {
    return valorDespAcessorias;
  }

  public void setValorDespAcessorias(Double valorDespAcessorias) {
    this.valorDespAcessorias = valorDespAcessorias;
  }

  public Integer getQtdVolumes() {
    return qtdVolumes;
  }

  public void setQtdVolumes(Integer qtdVolumes) {
    this.qtdVolumes = qtdVolumes;
  }

  public Double getPesoBruto() {
    return pesoBruto;
  }

  public void setPesoBruto(Double pesoBruto) {
    this.pesoBruto = pesoBruto;
  }

  public Double getPesoLiquido() {
    return pesoLiquido;
  }

  public void setPesoLiquido(Double pesoLiquido) {
    this.pesoLiquido = pesoLiquido;
  }

  public String getTipoPedido() {
    return tipoPedido;
  }

  public void setTipoPedido(String tipoPedido) {
    this.tipoPedido = tipoPedido;
  }

  public Long getCdCustomer() {
    return cdCustomer;
  }

  public void setCdCustomer(Long cdCustomer) {
    this.cdCustomer = cdCustomer;
  }

  public String getNumeroVeiculo() {
    return numeroVeiculo;
  }

  public void setNumeroVeiculo(String numeroVeiculo) {
    this.numeroVeiculo = numeroVeiculo;
  }

  public String getAtivaTipoPagto() {
    return ativaTipoPagto;
  }

  public void setAtivaTipoPagto(String ativaTipoPagto) {
    this.ativaTipoPagto = ativaTipoPagto;
  }

  public Integer getTipoTransacao() {
    return tipoTransacao;
  }

  public void setTipoTransacao(Integer tipoTransacao) {
    this.tipoTransacao = tipoTransacao;

    OperationType type = OperationType.getByValue(tipoTransacao);
    this.nomeTransacao = type.getIdOperationInvoiceReport().toString() + type.getName();
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
    this.nomeStatus = status.toString() + StatusNFeType.getByValue(status).getName();
  }

  public Integer getStepEmissao() {
    return stepEmissao;
  }

  public void setStepEmissao(Integer stepEmissao) {
    this.stepEmissao = stepEmissao;
  }

  public String getChave() {
    return chave;
  }

  public void setChave(String chave) {
    this.chave = chave;
  }

  public String getProtocolo() {
    return protocolo;
  }

  public void setProtocolo(String protocolo) {
    this.protocolo = protocolo;
  }

  public Double getValorDinheiro() {
    return valorDinheiro;
  }

  public void setValorDinheiro(Double valorDinheiro) {
    this.valorDinheiro = valorDinheiro;
  }

  public Double getValorTroco() {
    return valorTroco;
  }

  public void setValorTroco(Double valorTroco) {
    this.valorTroco = valorTroco;
  }

  public Double getValorFatura() {
    return valorFatura;
  }

  public void setValorFatura(Double valorFatura) {
    this.valorFatura = valorFatura;
  }

  public Double getValorCheque() {
    return valorCheque;
  }

  public void setValorCheque(Double valorCheque) {
    this.valorCheque = valorCheque;
  }

  public String getNumeroCheque() {
    return numeroCheque;
  }

  public void setNumeroCheque(String numeroCheque) {
    this.numeroCheque = numeroCheque;
  }

  public Double getValorIpi() {
    return valorIpi;
  }

  public void setValorIpi(Double valoIpi) {
    this.valorIpi = valoIpi;
  }

  public Double getValorDebito() {
    return valorDebito;
  }

  public void setValorDebito(Double valorDebito) {
    this.valorDebito = valorDebito;
  }

  public Double getValorCredito() {
    return valorCredito;
  }

  public void setValorCredito(Double valorCredito) {
    this.valorCredito = valorCredito;
  }

  public String getCdMovimento() {
    return cdMovimento;
  }

  public void setCdMovimento(String cdMovimento) {
    this.cdMovimento = cdMovimento;
  }

  public String getCondicaoPagamento() {
    return condicaoPagamento;
  }

  public void setCondicaoPagamento(String condicaoPagamento) {
    this.condicaoPagamento = condicaoPagamento;
  }

  public Double getAliquotaIcms() {
    return aliquotaIcms;
  }

  public void setAliquotaIcms(Double aliquotaIcms) {
    this.aliquotaIcms = aliquotaIcms;
  }

  public Long getNumeroNotaVOR() {
    return numeroNotaVOR;
  }

  public void setNumeroNotaVOR(Long numeroNotaVOR) {
    this.numeroNotaVOR = numeroNotaVOR;
  }

  public Long getSerieNotaVOR() {
    return serieNotaVOR;
  }

  public void setSerieNotaVOR(Long serieNotaVOR) {
    this.serieNotaVOR = serieNotaVOR;
  }

  public String getNumeroFutEntrega() {
    if (numeroFutEntrega == null)
      numeroFutEntrega = "";
    return numeroFutEntrega;
  }

  public void setNumeroFutEntrega(String numeroFutEntrega) {
    this.numeroFutEntrega = numeroFutEntrega;
  }

  public String getCdPreOrdem() {
    return cdPreOrdem;
  }

  public void setCdPreOrdem(String cdPreOrdem) {
    this.cdPreOrdem = cdPreOrdem;
  }

  public Double getValorDescontoIcms() {
    return valorDescontoIcms;
  }

  public void setValorDescontoIcms(Double valorDescontoIcms) {
    this.valorDescontoIcms = valorDescontoIcms;
  }

  public Double getValorIcms() {
    return valorIcms;
  }

  public void setValorIcms(Double valorIcms) {
    this.valorIcms = valorIcms;
  }

  public Double getBaseCalculoIcms() {
    return baseCalculoIcms;
  }

  public void setBaseCalculoIcms(Double baseCalculoIcms) {
    this.baseCalculoIcms = baseCalculoIcms;
  }

  public Integer getSituacaoTributariaIcms() {
    return situacaoTributariaIcms;
  }

  public void setSituacaoTributariaIcms(Integer situacaoTributariaIcms) {
    this.situacaoTributariaIcms = situacaoTributariaIcms;
  }

  public Double getBaseCalculoIpi() {
    return baseCalculoIpi;
  }

  public void setBaseCalculoIpi(Double baseCalculoIpi) {
    this.baseCalculoIpi = baseCalculoIpi;
  }

  public Integer getSituacaoTributariaIpi() {
    return situacaoTributariaIpi;
  }

  public void setSituacaoTributariaIpi(Integer situacaoTributariaIpi) {
    this.situacaoTributariaIpi = situacaoTributariaIpi;
  }

  public String getFlNovoFaturamento() {
    return flNovoFaturamento;
  }

  public void setFlNovoFaturamento(String flNovoFaturamento) {
    this.flNovoFaturamento = flNovoFaturamento;
  }

  public Long getCdOperadora() {
    return cdOperadora;
  }

  public void setCdOperadora(Long cdOperadora) {
    this.cdOperadora = cdOperadora;
  }

  public String getFlPaciente() {
    return flPaciente;
  }

  public void setFlPaciente(String flPaciente) {
    this.flPaciente = flPaciente;
  }

  public Long getCdCustomerService() {
    return cdCustomerService;
  }

  public void setCdCustomerService(Long cdCustomerService) {
    this.cdCustomerService = cdCustomerService;
  }

  public String getNomeAssinadorCec() {
    return nomeAssinadorCec;
  }

  public void setNomeAssinadorCec(String nomeAssinadorCec) {
    this.nomeAssinadorCec = nomeAssinadorCec;
  }

  public String getRgAssinadorCec() {
    return rgAssinadorCec;
  }

  public void setRgAssinadorCec(String rgAssinadorCec) {
    this.rgAssinadorCec = rgAssinadorCec;
  }

  public Integer getTipoMovimentoIntegracao() {
    return tipoMovimentoIntegracao;
  }

  public void setTipoMovimentoIntegracao(Integer tipoMovimentoIntegracao) {
    this.tipoMovimentoIntegracao = tipoMovimentoIntegracao;
  }

  public String getSemPagto() {
    return semPagto;
  }

  public void setSemPagto(String semPagto) {
    this.semPagto = semPagto;
  }

  public String getFlPrecoAlterado() {
    return flPrecoAlterado;
  }

  public void setFlPrecoAlterado(String flPrecoAlterado) {
    this.flPrecoAlterado = flPrecoAlterado;
  }

  public String getNomeTipoPagamento() {
    return nomeTipoPagamento;
  }

  public void setNomeTipoPagamento(String nomeTipoPagamento) {
    this.nomeTipoPagamento = nomeTipoPagamento;
  }

  public String getCdMotivo() {
    return cdMotivo;
  }

  public void setCdMotivo(String cdMotivo) {
    this.cdMotivo = cdMotivo;
  }

  public String getStatusContingencia() {
    return statusContingencia;
  }

  public void setStatusContingencia(String statusContingencia) {
    this.statusContingencia = statusContingencia;
  }

  public String getMensagemContingencia() {
    return mensagemContingencia;
  }

  public void setMensagemContingencia(String mensagemContingencia) {
    this.mensagemContingencia = mensagemContingencia;
  }

  public Integer getStatusGravacaoJde() {
    return statusGravacaoJde;
  }

  public void setStatusGravacaoJde(Integer statusGravacaoJde) {
    this.statusGravacaoJde = statusGravacaoJde;
  }

  public String getMensagemGravacaoJde() {
    return mensagemGravacaoJde;
  }

  public void setMensagemGravacaoJde(String mensagemGravacaoJde) {
    this.mensagemGravacaoJde = mensagemGravacaoJde;
  }

  public Integer getStatusImpressaoCec() {
    return statusImpressaoCec;
  }

  public void setStatusImpressaoCec(Integer statusImpressaoCec) {
    this.statusImpressaoCec = statusImpressaoCec;

    if (statusImpressaoCec != null)
      nomeStatusImpressaoCec = statusImpressaoCec.toString() +
        PrintStatusType.getByValue(statusImpressaoCec).getName();
  }

  public Integer getStatusCec() {
    return statusCec;
  }

  public void setStatusCec(Integer statusCec) {
    //Online
    //Offline
    //Contigencia
    //Refeito
    this.statusCec = statusCec;
  }

  public String getNomeTransacao() {
    return nomeTransacao;
  }

  public void setNomeTransacao(String nomeTransacao) {
    this.nomeTransacao = nomeTransacao;
  }

  public String getNomeStatus() {
    return nomeStatus = status.toString() + StatusNFeType.getByValue(status).getName();
  }

  public void setNomeStatus(String nomeStatus) {
    this.nomeStatus = nomeStatus;
  }

  public String getNomeFormaImpressaoCec() {
    return nomeFormaImpressaoCec;
  }

  public void setNomeFormaImpressaoCec(String nomeFormaImpressaoCec) {
    this.nomeFormaImpressaoCec = nomeFormaImpressaoCec;
  }

  public String getNomeStatusImpressaoCec() {
    return statusImpressaoCec.toString() + PrintStatusType.getByValue(statusImpressaoCec).getName();
  }

  public void setNomeStatusImpressaoCec(String nomeStatusImpressaoCec) {
    this.nomeStatusImpressaoCec = nomeStatusImpressaoCec;
  }

  public String getDsMotivo() {
    return dsMotivo;
  }

  public void setDsMotivo(String dsMotivo) {
    this.dsMotivo = dsMotivo;
  }

  public String getStatusNfeImp() {
    if (statusNfeImp == null)
      statusNfeImp = "";
    return statusNfeImp;
  }

  public void setStatusNfeImp(String statusNfeImp) {
    this.statusNfeImp = statusNfeImp;
  }

  public String getStatusReportFile() {
    return statusReportFile;
  }

  public void setStatusReportFile(String statusReportFile) {
    this.statusReportFile = statusReportFile;
  }

  public List<InvoiceItem> getItens() {
    return itens;
  }

  public void setItens(List<InvoiceItem> itens) {
    this.itens = itens;
  }

  public Invoice findById(Long id) {
    Invoice p = DatabaseApp.self().getDatabase().invoiceDao().findById(id);
    List<InvoiceItem> i = DatabaseApp.self().getDatabase().invoiceItemDao().findByIdNota(id);
    p.setItens(i);

    return p;
  }


  @Override
  public void parseLine(String line) {

  }

  @Override
  public void deleteAll() {
    DatabaseApp.self().getDatabase().invoiceDao()
      .deleteAll(DatabaseApp.self().getDatabase().invoiceDao().getAll());
  }

  @Override
  public boolean isValid() {
    return true;
  }

  @Override
  public void save() {
    try {
      InvoiceDao invoiceDao = DatabaseApp.self().getDatabase().invoiceDao();
      Long id = invoiceDao.insert(this);
      this.setId(id);

      for (InvoiceItem invoiceItem : this.getItens()) {
        invoiceItem.setIdNota(id);
        invoiceItem.save();
      }
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public String toString() {

    String evento = MovimentoIntegracaoType.getNameByValue(tipoMovimentoIntegracao);
    SuperOperation operation = SuperOperation.getOperation(tipoTransacao);

    if (OperationType.RPS.getValue().equals(operation.getOperationType().getValue()))
      return String.format(Locale.getDefault(),
        "Recibo: %s %s\nEvento: %s\nStatus: %s",
        cdCustomer.toString() + numero.toString() + serie.toString(),
        operation.getOperationType().getNickName(),
        UtilHelper.padRight(evento, ' ', 15),
        "Status: " + StatusNFeType.getNameByValue(getStatus()));
    else
      return String.format(Locale.getDefault(),
        "Nota: %s %s\nEvento: %s \nStatus: %s",
        numero.toString(), operation.getOperationType().getNickName(),
        UtilHelper.padRight(evento, ' ', 15),
        StatusNFeType.getNameByValue(getStatus()));
  }

  public Document createXmlFile() {
    LogHelper.self().info("[createXmlFile] " + "Iniciado!");

    Map<String, String> tags = new HashMap<>();
    tags.put("cabecalhoNFe", "NFe");
    tags.put("downloader_NFe", "cabecalhoNFe");
    tags.put("detalheNFe", "NFe");
    tags.put("downloader_Detalhe", "detalheNFe");
    tags.put("forma_pagamento", "downloader_NFe");

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    Document document = null;
    try {
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      document = documentBuilder.newDocument();
      Element nfeElement = document.createElement("NFe");
      String imei = GLOBAL.self().getImei();
      Travel travel = DatabaseApp.self().getDatabase().travelDao().findFirst();

      XmlConfig.createNode(document, nfeElement, "cd_filial", GLOBAL.self().getRoute().getCdFilialJde());
      XmlConfig.createNode(document, nfeElement, "dt_viagem", getDataViagem());
      XmlConfig.createNode(document, nfeElement, "num_viagem", getNumeroViagem());
      XmlConfig.createNode(document, nfeElement, "imei", imei);
      XmlConfig.createNode(document, nfeElement, "dt_viagem_princ",
        UtilHelper.formatDateStr(travel.getDataViagem(), ConstantsEnum.yyyyMMdd.getValue()));

      XmlConfig.createNode(document, nfeElement, "num_viagem_princ",
        UtilHelper.padLeft(travel.getNumeroViagem().toString(), '0', 6));
      XmlConfig.createNode(document, nfeElement, "versao", GLOBAL.self().getVersao().replace(".", ""));
      XmlConfig.createNode(document, nfeElement, "so_dispositivo", "Android");

      Field[] fields = getClass().getDeclaredFields();

      for (Field field : fields) {

        if (field.isAnnotationPresent(XmlMapping.class)) {

          field.setAccessible(true);
          XmlMapping annotation = field.getAnnotation(XmlMapping.class);

          //Suprimir as tags desnecessárias
          if (!annotation.suppress()) {

            NodeList nodes = nfeElement.getElementsByTagName(annotation.xmlParentTagName());

            Element parentElement;

            if (nodes.getLength() == 0) {
              parentElement = document.createElement(annotation.xmlParentTagName());

              String parentParentName = tags.get(annotation.xmlParentTagName());

              if (nfeElement.getElementsByTagName(parentParentName).getLength() == 0) {
                Element pElement = document.createElement(parentParentName);
                nfeElement.appendChild(pElement);
                pElement.appendChild(parentElement);
              } else if (!parentParentName.equals(nfeElement.getNodeName())) {
                Node node = nfeElement.getElementsByTagName(parentParentName).item(0);
                node.appendChild(parentElement);
              } else
                nfeElement.appendChild(parentElement);
            } else
              parentElement = (Element) nodes.item(nodes.getLength() - 1);

            Object value = field.get(this);

            if (value == null)
              value = "";

            if (field.getGenericType().equals(Date.class)) {
              if (!value.toString().isEmpty()) {
                value = UtilHelper.formatDateStr(value, annotation.dateFormat());
              }
            }

            XmlConfig.createNode(document, parentElement, annotation.xmlTagName(), value.toString());
          }
        }
      }
      document.appendChild(nfeElement);
      LogHelper.self().info("[createXmlFile] " + "Finalizado com sucesso!");
    } catch (ParserConfigurationException | IllegalAccessException e) {
      LogHelper.self().error("createXmlFile", e);
      e.printStackTrace();
    }

    return document;
  }

  public void parseXML(InputStream is) {
    XmlPullParserFactory parserFactory;
    try {
      parserFactory = XmlPullParserFactory.newInstance();
      XmlPullParser parser = parserFactory.newPullParser();
      parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
      parser.setInput(is, null);

      processParsing(parser);

    } catch (XmlPullParserException | IllegalAccessException e) {
      LogHelper.self().error("[parse] ", e);
      e.printStackTrace();
    } catch (IOException e) {
      LogHelper.self().error("[parse] ", e);
      e.printStackTrace();
    }
  }

  private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException, IllegalAccessException {
    int eventType = parser.getEventType();

    while (eventType != XmlPullParser.END_DOCUMENT) {
      String eltName = "";

      switch (eventType) {
        case XmlPullParser.START_TAG:
          eltName = parser.getName();

          Field[] fields = getClass().getDeclaredFields();

          for (Field field : fields) {
            if (field.isAnnotationPresent(XmlMapping.class)) {
              XmlMapping annotation = field.getAnnotation(XmlMapping.class);

              if (annotation.xmlTagName().equalsIgnoreCase(eltName)) {
                String value = parser.nextText();

                if (field.getGenericType().equals(Integer.class))
                  field.set(this, Integer.parseInt(value));
                else if (field.getGenericType().equals(String.class))
                  field.set(this, value);
                else if (field.getGenericType().equals(Long.class))
                  field.set(this, Long.parseLong(value));
                else if (field.getGenericType().equals(Float.class))
                  field.set(this, Float.parseFloat(value));
                else if (field.getGenericType().equals(Long.class))
                  field.set(this, Long.parseLong(value));
                else if (field.getGenericType().equals(Double.class))
                  field.set(this, Double.parseDouble(value));
                else if (field.getGenericType().equals(Date.class)) {
                  if (value == null || value.isEmpty())
                    value = "";

                  if (value != null && !value.isEmpty()) {
                    Date d = UtilHelper.convertToDate(value, annotation.dateFormat());
                    field.set(this, d);
                  }
                }
              }
            }
          }

          break;
      }

      eventType = parser.next();
    }
  }
}
