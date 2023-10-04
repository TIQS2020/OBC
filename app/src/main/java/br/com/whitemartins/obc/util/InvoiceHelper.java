package br.com.whitemartins.obc.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.AnswerDao;
import br.com.whitemartins.obc.dao.CodeDao;
import br.com.whitemartins.obc.dao.InvoiceMessageDao;
import br.com.whitemartins.obc.dao.PaymentDao;
import br.com.whitemartins.obc.dao.RastreabilidadeDao;
import br.com.whitemartins.obc.dao.SearchDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.CstType;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.MovimentoIntegracaoType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.enumeration.TaxingType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.enumeration.UfType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Abastecimento;
import br.com.whitemartins.obc.model.Answer;
import br.com.whitemartins.obc.model.Code;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.InvoiceMessage;
import br.com.whitemartins.obc.model.InvoiceNumber;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.model.LotePatrimonio;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.model.Rastreabilidade;
import br.com.whitemartins.obc.model.Search;
import br.com.whitemartins.obc.model.Tax;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.views.InvoiceLostActivity;
import br.com.whitemartins.obc.xml.XmlConfig;

public class InvoiceHelper {

  private static InvoiceHelper _self;
  private Activity activity;

  private Double valorDinheiro;
  private Double valorTroco;
  private Double valorFatura;
  private Double valorCheque;
  private String numeroCheque;
  private Double valorDebito;
  private Double valorCredito;

  private CodeDao codeDao = DatabaseApp.self().getDatabase().codeDao();

  private static InvoiceHelper newInstance() {
    return new InvoiceHelper();
  }

  public static InvoiceHelper self() {
    if (_self == null)
      _self = InvoiceHelper.newInstance();

    return _self;
  }

  public InvoiceHelper setActivity(Activity activity) {
    this.activity = activity;

    return this;
  }

  public InvoiceHelper setValorDinheiro(Double valorDinheiro) {
    this.valorDinheiro = valorDinheiro;
    return this;
  }

  public InvoiceHelper setValorTroco(Double valorTroco) {
    this.valorTroco = valorTroco;
    return this;
  }

  public InvoiceHelper setValorFatura(Double valorFatura) {
    this.valorFatura = valorFatura;
    return this;
  }

  public InvoiceHelper setValorCheque(Double valorCheque) {
    this.valorCheque = valorCheque;
    return this;
  }

  public InvoiceHelper setNumeroCheque(String numeroCheque) {
    this.numeroCheque = numeroCheque;
    return this;
  }

  public InvoiceHelper setValorDebito(Double valorDebito) {
    this.valorDebito = valorDebito;
    return this;
  }

  public InvoiceHelper setValorCredito(Double valorCredito) {
    this.valorCredito = valorCredito;
    return this;
  }

  public Customer getInvoiceCustomer(Invoice invoice) {
    Customer customer = DatabaseApp.self().getDatabase().customerDao()
        .findById(invoice.getCdCustomer());

    if (customer == null)
      customer = DatabaseApp.self().getDatabase().customerDao()
          .findById(invoice.getCdOperadora());

    if (invoice.getCdCustomerService() != null)
      customer = DatabaseApp.self().getDatabase().customerDao()
          .findById(invoice.getCdCustomerService());

    return customer;
  }

  public Invoice create(final SuperOperation operation, final Customer customer,
                        final List<ItemPrice> prices, final PreOrder preOrder,
                        final Customer customerService) {

    LogHelper.self().info("Inicio da criação da NFe");

    try {

      final Invoice invoice = Invoice.newInstance();

      invoice.setProtocolo("");
      invoice.setStatusNfeImp("");

      if (operation.isFinalizaPedido())
        invoice.setSemPagto(ConstantsEnum.NO.getValue());
      else
        invoice.setSemPagto(ConstantsEnum.YES.getValue());

      invoice.setDataEmissao(UtilHelper.currentDateTime(ConstantsEnum.ddMMyyyy.getValue()));
      invoice.setDataMovimento(UtilHelper.currentDateTime(""));
      invoice.setModalidadeFrete(0);

      if (GLOBAL.self().isHomecare()) {
        invoice.setNomeEspecVolume(ConstantsEnum.CILINDROS.getValue());
        invoice.setNomeMarca(ConstantsEnum.WM.getValue());

        if (!prices.get(0).getItem().getTipoItem().equals(TypeItemType.GAS.getValue())) {
          invoice.setNomeEspecVolume(ConstantsEnum.UNIDADES.getValue());
          invoice.setNomeMarca("");
        }
      } else {
        if (GLOBAL.self().isLiquido())
          invoice.setNomeEspecVolume(ConstantsEnum.GRANEL.getValue());
        else
          invoice.setNomeEspecVolume(ConstantsEnum.CILINDROS.getValue());

        if (Integer.valueOf(1).equals(prices.get(0).getItem().getIndRequerFator()))
          invoice.setNomeMarca(ConstantsEnum.GEMINI.getValue());
        else
          invoice.setNomeMarca(ConstantsEnum.WM.getValue());
      }

      invoice.setStatus(StatusNFeType.PENDENTE_ENVIO.ordinal());
      invoice.setStepEmissao(StepEmissaoType.CRIAR.ordinal());

      String nVeiculo = GLOBAL.self().getRoute().getCdFilialJde().substring(3) +
          UtilHelper.padLeft(GLOBAL.self().getRoute().getNumVeiculo(), '0', 4);

      invoice.setNumeroVeiculo(nVeiculo);

      invoice.setPlacaVeiculo(GLOBAL.self().getRoute().getPlacaVeiculo());
      invoice.setUfVeiculo(GLOBAL.self().getRoute().getUfVeiculo());

      invoice.setTipoNota(operation.getTipoNota().getValue());
      invoice.setNomeOperacao(operation.getOperationType().getName());
      invoice.setCdCustomer(customer.getCdCustomer());
      invoice.setDataViagem(UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
          ConstantsEnum.yyyyMMdd.getValue()));
      invoice.setNumeroViagem(UtilHelper.padLeft(GLOBAL.self().getRoute()
          .getNumeroViagem().toString(), '0', 6));

      invoice.setCnpjCpfDestino(customer.getCnpj());
      invoice.setCnpjCpfTransp(GLOBAL.self().getRoute().getCnpjTransp());

      invoice.setValorDinheiro(this.valorDinheiro);
      invoice.setValorTroco(this.valorTroco);
      invoice.setValorCheque(this.valorCheque);
      invoice.setNumeroCheque(this.numeroCheque);
      invoice.setValorDebito(this.valorDebito);
      invoice.setValorCredito(this.valorCredito);
      invoice.setValorFatura(this.valorFatura);

      String nomeTipoPagamento = "";

      if (this.valorDinheiro > 0)
        nomeTipoPagamento = "1Dinheiro";
      else if (this.valorCheque > 0)
        nomeTipoPagamento = "2Cheque";
      else if (this.valorFatura > 0)
        nomeTipoPagamento = operation.isFinalizaPedido() ? "4Prazo" : "0";
      else
        nomeTipoPagamento = "3Deb/Cred";

      invoice.setNomeTipoPagamento(nomeTipoPagamento);

      invoice.setClasseContribuinte(customer.getClasseContrib());
      invoice.setCdMovimento(operation.getCodigoMovimento(invoice, customer));
      invoice.setTipoPedido(operation.getCodigoDocumento(customer).substring(0, 2));
      invoice.setTipoTransacao(operation.getTipoTransacao());
      invoice.setSituacaoTributariaIcms(ItemPrice.getTipoIcmsInvoice(operation, customer));
      invoice.setSituacaoTributariaIpi(ItemPrice.getTipoIpiInvoice(operation, customer));

//      if (OperationType.APL.equals(operation.getOperationType())
//        || OperationType.RCLNF.equals(operation.getOperationType())
//        || OperationType.RCLHC.equals(operation.getOperationType())
//        || OperationType.APLHC.equals(operation.getOperationType())
//      ) {
//        //invoice.setSituacaoTributariaIcms(TaxingType.ISENTO.getValue());
//        invoice.setSituacaoTributariaIpi(TaxingType.ISENTO.getValue());
//      } else if (OperationType.FUT.equals(operation.getOperationType()))
//        invoice.setSituacaoTributariaIpi(TaxingType.OUTROS.getValue());
//      else
//        invoice.setSituacaoTributariaIpi(customer.getSituacaoTributariaIpi());

//      if (CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico()))
//        invoice.setSituacaoTributariaIcms(TaxingType.ISENTO.getValue());

      invoice.setFlNovoFaturamento(customer.getFlNovoFaturamento());
      invoice.setTipoMovimentoIntegracao(MovimentoIntegracaoType.EMISSAO.getValue());

      if (!GLOBAL.self().getInvoiceVOR().isEmpty()) {
        Long notaVor, serieVor;

        notaVor = UtilHelper.convertToLongDef((GLOBAL.self().getInvoiceVOR()
            .split("\\|")[0]), 0);
        serieVor = UtilHelper.convertToLongDef((GLOBAL.self().getInvoiceVOR()
            .split("\\|")[1]), 0);

        invoice.setNumeroNotaVOR(notaVor);
        invoice.setSerieNotaVOR(serieVor);
      }

      if (customerService != null) {
        invoice.setCdCustomerService(customerService.getCdCustomer());
        invoice.setFlNovoFaturamento(customerService.getFlNovoFaturamento());
      } else {
        if (ConstantsEnum._01.getValue().equalsIgnoreCase(customer.getFlNovoFaturamento())
            || ConstantsEnum._02.getValue().equalsIgnoreCase(customer.getFlNovoFaturamento())) {

          invoice.setFlNovoFaturamento(customer.getFlNovoFaturamento());

          if (!OperationType.RPS.equals(operation.getOperationType()))
            invoice.setFlNovoFaturamento("");

          if (ConstantsEnum._01.getValue().equalsIgnoreCase(invoice.getFlNovoFaturamento()))
            invoice.setFlNovoFaturamento("");
        }
      }

      if (GLOBAL.self().isPagtoAtivado())
        invoice.setAtivaTipoPagto("1");
      else
        invoice.setAtivaTipoPagto("0");

      invoice.setFlPaciente(customer.getFlPaciente() == null
          ? ConstantsEnum.NO.getValue()
          : customer.getFlPaciente());

      invoice.setCdOperadora(customer.getCdJdeOperadora());

      if (GLOBAL.self().getPatient() != null) {
        invoice.setCdCustomer(GLOBAL.self().getPatient().getCdPaciente());
        invoice.setCdOperadora(GLOBAL.self().getCustomer().getCdCustomer());
        invoice.setFlPaciente(ConstantsEnum.YES.getValue());
      }

      //Setando o numero da PreOrder no Nota
      invoice.setCdPreOrdem(preOrder.getCdPreOrder().toString());
      invoice.setNumeroFutEntrega(preOrder.getNumeroNotaOrigem());
      //Totais da nota
      Double valorTotalProduto = 0d;
      Double valorTotal = 0d;
      Double valorTotalLiquido = 0d;
      Double valorTotalFrete = 0d;
      Double valorTotalDespesa = 0d;

      //Quantidade de cilindros da nota ex.
      //Volume do gás da nota, quantide de cilindros x capacidade do cilindro
      Double volumeCapacidade = 0d;
//      Double quantidade = 0d;
      Double qtdvolumes = 0D;

      //ICMS
      Double aliquotaIcms = 0d;
      Double baseCalculoIcms = 0d;
      Double valorTotalIcms = 0d;
      Double valorTotalDescontoIcms = 0d;

      //IPI
      Double baseCalculoIpi = 0d;
      Double valorTotalIpi = 0d;
      Double pesoBruto = 0d;
      Double pesoLiquido = 0d;

      List<InvoiceItem> itens = new ArrayList<>();

//
//      if (GLOBAL.self().isLiquido() && prices.size() > 1)
//        while (prices.size() > 1)
//          prices.remove(0);

      LogHelper.self().info("Total de itens da nota fiscal: " + prices.size());

      for (ItemPrice price : prices) {
        invoice.setCdFiscal(operation.getOldCfop(customer, price));

        //Somatorio dos totais da nota
        valorTotalProduto += price.getValorTotalProduto(operation);

        valorTotal += price.getTotalItem(operation, customer);
        valorTotalLiquido += price.getValorLiquido(operation, customer);
        valorTotalFrete += price.getValorTotalFrete(operation);
        valorTotalDespesa += price.getValorTotalDespesa(operation);
        volumeCapacidade += price.getVolume(operation);

        aliquotaIcms = price.getAliquotaIcms(operation, customer);

        if (UfType.PR.getValue().equalsIgnoreCase(GLOBAL.self().getRoute().getUf()))
          baseCalculoIcms += price.getBaseCalculoIcms(operation, customer) +
              price.getValorBaseReducaoIcms(operation, customer);
        else
          baseCalculoIcms += price.getBaseCalculoIcms(operation, customer);

        valorTotalIcms += price.getValorIcms(operation, customer);
        valorTotalDescontoIcms += price.getValorDescontoIcms(operation, customer);

        baseCalculoIpi += price.getBaseCalculoIpi(operation, customer);
        valorTotalIpi += price.getValorIpi(operation, customer);

        pesoLiquido += price.getItem().getPesoLiquido(operation, price.getVolume(operation));
        pesoBruto += price.getItem().getPesoLiquido(operation, price.getVolume(operation)) +
            price.getItem().getPesoCilindro(operation, price.getQuantidadeVendida());

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setReturnCode(operation.getReturnCode());

        //Colocando os dados do cilindro para a devida operacao
        if (OperationType.RCLNF.getValue().equals(operation.getOperationType().getValue())
            || OperationType.APL.getValue().equals(operation.getOperationType().getValue())
            || OperationType.RCLHC.getValue().equals(operation.getOperationType().getValue())
            || OperationType.APLHC.getValue().equals(operation.getOperationType().getValue())
        ) {
          invoiceItem.setCdItem(price.getItem().getCdCilindro());
          invoiceItem.setNomeItem(price.getItem().getDescricaoCilindro());
        } else {
          invoiceItem.setCdItem(price.getItem().getCdItem());
          invoiceItem.setNomeItem(price.getItem().getDescricaoProduto());
        }

        invoiceItem.setQtdItem(price.getQuantidade(operation));
        invoiceItem.setQuantidadeCilindroVendida(price.getQuantidadeVendida());
        invoiceItem.setVolume(price.getVolume(operation));
        qtdvolumes += invoiceItem.getQuantidadeCilindroVendida();

        invoiceItem.setCapacidade(price.getItem().getCapacidadeCilindro());
        invoiceItem.setCfop(operation.getCfop(customer, price));
        invoiceItem.setUnidadeMedida(price.getUnidadeMedida(operation));
        invoiceItem.setValorUnitario(price.getValorUnitario());
        invoiceItem.setValorPrecoUnitarioOriginal(price.getValorUnitario());
        invoiceItem.setValorTotalSeguro(0d);
        invoiceItem.setValorTotal(price.getValorTotalProduto(operation));
        invoiceItem.setValorTotalFrete(price.getValorTotalFrete(operation));
        invoiceItem.setValorDespesasAcessorias(price.getValorTotalDespesa(operation));
        invoiceItem.setClassifFiscal(price.getNcm(operation));
        invoiceItem.setTipoItem(price.getItem().getTipoItem());
        invoiceItem.setInfCilPP(price.getInfCilindroPP());
        invoiceItem.setPedidoCustomer(price.getPedidoCustomer());
        invoiceItem.setItemPedidoCustomer(price.getItemPedidoCustomer());
        invoiceItem.setFlPrecoAlterado(price.getAltPreco());
        invoice.setFlPrecoAlterado(price.getAltPreco());

        invoiceItem.setTipoFaturamento(price.getTipoFaturamento(operation, customer));
        if (customerService != null) {
          invoiceItem.setTipoFaturamento(customerService.getFlNovoFaturamento());

          if (ConstantsEnum._00.getValue().equalsIgnoreCase(invoiceItem.getTipoFaturamento()))
            invoiceItem.setTipoFaturamento("");
        }

        //Quando existir um valor faturado, pegar a condição de pagamento do Price
        if (this.valorFatura > 0)
          invoiceItem.setCondicaoPagamento(price.getCondicaoPagamento(operation));
        else
          invoiceItem.setCondicaoPagamento(ConstantsEnum._990.getValue());

        invoiceItem.setCdMovimento(operation.getCodigoMovimento(invoice, customer));

        Code code = codeDao.find(operation.getCodigoInterno().substring(0, 1),
            UtilHelper.convertToIntegerDef(operation.getCodigoInterno().substring(1, 3), 0));

        if (code != null)
          invoiceItem.setNomeNaturezaOperacao(code.getDescricao());

        code = codeDao.find(ConstantsEnum.I.getValue(),
            UtilHelper.convertToIntegerDef(operation.getCodigoInterno().substring(1, 3), 0),
            operation.getOldCfop(customer, price), operation.getCfop(customer, price));

        if (code != null)
          invoiceItem.setNaturezaOperacao(code.getCfop3() + code.getSufixo());

        //COFINS -------------------------------------
        invoiceItem.setTipoCofins(customer.getSituacaoTributariaCofins());
        invoiceItem.setValorBaseCofins(0D);
        invoiceItem.setAliquotaCofins(0D);
        invoiceItem.setCstCofins(price.getCstCofins(operation, customer));
        invoiceItem.setValorDebitoCofins(0D);
        invoiceItem.setValorBaseCreditoCofins(0D);
        invoiceItem.setValorCreditoCofins(0D);

        if (InvoiceType.SAIDA.equals(operation.getTipoNota()))
          invoiceItem.setValorBaseCofins(price.getBaseCofins(operation, customer));
        else
          invoiceItem.setValorBaseCreditoCofins(price.getBaseCofins(operation, customer));

        code = codeDao.find(ConstantsEnum.I.getValue(),
            UtilHelper.convertToIntegerDef(operation.getCodigoInterno().substring(1, 3), 0),
            operation.getOldCfop(customer, price));

        if (code != null) {
          if (TaxingType.TRIBUTADO.getValue().equals(code.getSituacaoTributariaCofins())) {
            if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaCofins())) {
              if (OperationType.VND.getValue().equals(operation.getOperationType().getValue()))
                invoiceItem.setCstCofins(price.getCstCofins(operation, customer));
              else
                invoiceItem.setCstCofins(InvoiceType.ENTRADA.equals(operation.getTipoNota()) ?
                    CstType._98.getValue() : CstType._99.getValue());

              if (price.getAliquotaCofins(operation, customer) > 0) {
                invoiceItem.setAliquotaCofins(price.getAliquotaCofins(operation, customer));

                if (InvoiceType.SAIDA.equals(operation.getTipoNota()))
                  invoiceItem.setValorDebitoCofins(price.getValorCofins(operation, customer));
                else
                  invoiceItem.setValorCreditoCofins(price.getValorCofins(operation, customer));
              }
            } else {
              invoiceItem.setCstCofins(InvoiceType.ENTRADA.equals(operation.getTipoNota()) ?
                  customer.getCstCofinsE() : customer.getCstCofinsS());
            }
          } else {
            invoiceItem.setTipoCofins(code.getSituacaoTributariaCofins());

            if (!TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaCofins()))
              invoiceItem.setCstCofins(InvoiceType.ENTRADA.equals(operation.getTipoNota()) ?
                  customer.getCstCofinsE() : customer.getCstCofinsS());
            else
              invoiceItem.setCstCofins(code.getCstCofins());
          }

          //PIS -------------------------------------
          invoiceItem.setTipoPis(customer.getSituacaoTributariaPis());
          invoiceItem.setValorBasePis(0D);
          invoiceItem.setAliquotaPis(0D);
          invoiceItem.setValorDebitoPis(0D);
          invoiceItem.setValorBaseCreditoPis(0D);
          invoiceItem.setValorCreditoPis(0D);

          if (InvoiceType.SAIDA.equals(operation.getTipoNota()))
            invoiceItem.setValorBasePis(price.getBasePis(operation, customer));
          else
            invoiceItem.setValorBaseCreditoPis(price.getBasePis(operation, customer));

          if (TaxingType.TRIBUTADO.getValue().equals(code.getSituacaoTributariaPis())) {
            if (TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaCofins())) {
              if (OperationType.VND.getValue().equals(operation.getOperationType().getValue()))
                invoiceItem.setCstPis(price.getCstPis(operation, customer));
              else
                invoiceItem.setCstPis(InvoiceType.ENTRADA.equals(operation.getTipoNota()) ?
                    CstType._98.getValue() : CstType._99.getValue());

              if (price.getAliquotaPis(operation, customer) > 0) {
                invoiceItem.setAliquotaPis(price.getAliquotaPis(operation, customer));

                if (InvoiceType.SAIDA.equals(operation.getTipoNota()))
                  invoiceItem.setValorDebitoPis(price.getValorPis(operation, customer));
                else
                  invoiceItem.setValorCreditoPis(price.getValorPis(operation, customer));
              }
            } else {
              if (!TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaPis()))
                invoiceItem.setCstPis(InvoiceType.ENTRADA.equals(operation.getTipoNota()) ?
                    customer.getCstPisE() : customer.getCstPisS());
            }
          } else {
            invoiceItem.setTipoPis(code.getSituacaoTributariaPis());

            if (!TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaPis()))
              invoiceItem.setCstPis(InvoiceType.ENTRADA.equals(operation.getTipoNota()) ?
                  customer.getCstPisE() : customer.getCstPisS());
            else
              invoiceItem.setCstPis(code.getCstPis());
          }

        }

        //IPI -------------------------------------
        if (code != null) {

//          if (OperationType.APL.equals(operation.getOperationType())
//            || OperationType.RCLNF.equals(operation.getOperationType())
//            || OperationType.RCLHC.equals(operation.getOperationType())
//            || OperationType.APLHC.equals(operation.getOperationType())
//            || OperationType.VOR.equals(operation.getOperationType())
//          )
//            invoiceItem.setTipoIpi( TaxingType.ISENTO.getValue());
//          else
//            invoiceItem.setTipoIpi(customer.getSituacaoTributariaIpi());

          invoiceItem.setTipoIpi(price.getTipoIpi(operation, customer));
          invoiceItem.setValorBaseIpi(price.getBaseCalculoIpi(operation, customer));
          invoiceItem.setCstIpi(code.getCstIpiIsento());
          invoiceItem.setValorIpi(price.getValorIpi(operation, customer));

          code = codeDao.find(ConstantsEnum.P.getValue(),
              UtilHelper.convertToIntegerDef(operation.getCodigoInterno().substring(1, 3), 0),
              operation.getOldCfop(customer, price), operation.getCfop(customer, price));

          if (code != null) {
            Double valorIPI = price.getValorIpi(operation, customer);
            invoiceItem.setAliquotaIpi(price.getAliquotaIpi(operation, customer));

            if (valorIPI.equals(0d))
              invoiceItem.setCstIpi(code.getCstIpiZero());
            else
              invoiceItem.setCstIpi(code.getCstIpiTributado());

            invoiceItem.setValorIpi(valorIPI);

            if (InvoiceType.SAIDA.equals(operation.getTipoNota()))
              invoiceItem.setValorDebitoIpi(valorIPI);
            else
              invoiceItem.setValorCreditoIpi(valorIPI);
          }
        }
        //ICMS -------------------------------------
        invoiceItem.setAliquotaIcms(price.getAliquotaIcms(operation, customer));
        invoiceItem.setTipoIcms(price.getTipoIcms(operation, customer));

        if (UfType.PR.getValue().equalsIgnoreCase(GLOBAL.self().getRoute().getUf()))
          invoiceItem.setValorBaseIcms(UtilHelper.formatDouble(
              price.getBaseCalculoIcms(operation, customer) +
                  price.getValorBaseReducaoIcms(operation, customer), 2));
        else
          invoiceItem.setValorBaseIcms(price.getBaseCalculoIcms(operation, customer));

        invoiceItem.setValorDescontoIcms(price.getValorDescontoIcms(operation, customer));
        invoiceItem.setValorBaseReduzidaIcms(price.getValorBaseReducaoIcms(operation, customer));
        invoiceItem.setValorIcms(price.getValorIcms(operation, customer));

        //Para o CST tabela A, informar apenas a posição do CST
        if (!operation.isRecursivoUPC())
          invoiceItem.setCstAIcms(price.getItem().getCstGas().substring(2));
        else
          invoiceItem.setCstAIcms(price.getItem().getCstCilindro().substring(2));

        //Para o CST tabela B, informar as duas ultimas posições CST
        invoiceItem.setCstBIcms(price.getCstBIcms(operation, invoiceItem, customer));

        if (InvoiceType.SAIDA.equals(operation.getTipoNota()))
          invoiceItem.setValorDebitoIcms(price.getValorIcms(operation, customer));
        else
          invoiceItem.setValorCreditoIcms(price.getValorIcms(operation, customer));

        invoiceItem.setFlAssistenciaTecnica(price.getAssistTecnica());

        invoice.setCondicaoPagamento(invoiceItem.getCondicaoPagamento());
        invoice.setCdMovimento(invoiceItem.getCdMovimento());

        itens.add(invoiceItem);
        LogHelper.self().info(price.toString().trim() + " finalizado");

      }//for

      invoice.setQtdVolumes(qtdvolumes.intValue());
      if (GLOBAL.self().isLiquido())//Zerando para não sair no arquivo de fim de viagem NOTAS_NFE
        invoice.setVolumeCapacidadeReport(volumeCapacidade);
      else
        invoice.setVolumeCapacidadeReport(0D);

      invoice.setVolumeCapacidade(volumeCapacidade);
      invoice.setPesoBruto(UtilHelper.formatDouble(pesoBruto, 2));
      invoice.setPesoLiquido(UtilHelper.formatDouble(pesoLiquido, 2));

      invoice.setAliquotaIcms(UtilHelper.formatDouble(aliquotaIcms, 2));
      invoice.setValorDescontoIcms(UtilHelper.formatDouble(valorTotalDescontoIcms, 2));
      invoice.setValorIcms(UtilHelper.formatDouble(valorTotalIcms, 2));
      invoice.setBaseCalculoIcms(UtilHelper.formatDouble(baseCalculoIcms, 2));

      invoice.setBaseCalculoIpi(UtilHelper.formatDouble(baseCalculoIpi, 2));
      invoice.setValorIpi(UtilHelper.formatDouble(valorTotalIpi, 2));

      invoice.setValorTotal(UtilHelper.formatDouble(valorTotal, 2));
      invoice.setValorLiquido(UtilHelper.formatDouble(valorTotalLiquido, 2));
      invoice.setValorDespAcessorias(UtilHelper.formatDouble(valorTotalDespesa, 2));
      invoice.setValorFrete(UtilHelper.formatDouble(valorTotalFrete, 2));
      invoice.setValorTotalProduto(UtilHelper.formatDouble(valorTotalProduto, 2));

      invoice.setItens(itens);

      RastreabilidadeDao rastreabilidadeDao = DatabaseApp.self().getDatabase().rastreabilidadeDao();

      final List<Rastreabilidade> rastreabilidades =
          rastreabilidadeDao.findByCustomer(customer.getCdCustomer());

      final List<InvoiceMessage> invoiceMessages = InvoiceMessageHelper.self(activity,
          invoice).createMessages();

      DatabaseApp.self().getDatabase().runInTransaction(
          new Runnable() {
            @Override
            public void run() {
              Long numeroNota, serieNota = 0L;

              if (operation.getTipoNota().equals(InvoiceType.SAIDA)) {
                GLOBAL.self().setGeneral(DatabaseApp.self().getDatabase().generalDao().getGeneral());
                numeroNota = GLOBAL.self().getGeneral().getNumeroNotaSaida();
                serieNota = GLOBAL.self().getGeneral().getSerieNotaSaida();
              } else {
                numeroNota = GLOBAL.self().getGeneral().getNumeroNotaEntrada();
                serieNota = GLOBAL.self().getGeneral().getSerieNotaEntrada();
              }

              Invoice nextInvoice = DatabaseApp.self().getDatabase().invoiceDao()
                  .findByTipoNota(operation.getTipoNota().getValue());

              if (nextInvoice != null)
                numeroNota = nextInvoice.getNumero() + 1;

              Invoice lostInvoice = GLOBAL.self().getInvoice();
              if (lostInvoice != null) {
                invoice.setNumero(lostInvoice.getNumero());
                invoice.setSerie(lostInvoice.getSerie());
                invoice.setDataViagem(UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
                    ConstantsEnum.yyyyMMdd.getValue()));
                invoice.setNumeroViagem(UtilHelper.padLeft(lostInvoice.getNumeroViagem(), '0',
                    6));
                invoice.setDataMovimento(lostInvoice.getDataMovimento());

              } else {
                invoice.setNumero(numeroNota);
                invoice.setSerie(serieNota);
              }

              //long numNota = numeroNotaFinal;
              //Salvando a nota e item da nota
              invoice.save();
              LogHelper.self().info("InvoiceHelper", "1.Nota " + invoice.toString());

              long i = 0;

              for (InvoiceItem invoiceItem : invoice.getItens()) {
                invoiceItem.setIdNota(invoice.getId());
                invoiceItem.setSeqItem(++i);
                invoiceItem.setNumeroNota(numeroNota);
                invoiceItem.setSerieNota(invoice.getSerie());
                invoiceItem.save();

                SaldoHelper.self().atualizarSaldoOperation(invoiceItem.getCdItem(),
                    invoiceItem.getCapacidade(), operation, invoiceItem.getQuantidadeCilindroVendida(),
                    preOrder.getNumeroNotaOrigem(), GLOBAL.self().getRoute().getNumeroViagem(),
                    false);
              }

              //Atualizando a rastreabilidade dos itens da nota
              for (Rastreabilidade rastreabilidade : rastreabilidades) {
                rastreabilidade.setIdNota(invoice.getId());
                rastreabilidade.setNumeroNota(invoice.getNumero());
                rastreabilidade.update();
              }

              //Salvando as mensagens da nota
              for (InvoiceMessage invoiceMessage : invoiceMessages) {
                invoiceMessage.setIdNota(invoice.getId());
                invoiceMessage.setNumeroNota(invoice.getNumero());
                invoiceMessage.setSerieNota(invoice.getSerie());
                invoiceMessage.setDataEmissao(invoice.getDataEmissao());
                invoiceMessage.save();
              }

              //Atualizando o id da nota na pesquisa
              Search search = DatabaseApp.self().getDatabase().searchDao().findOne();

              if (search != null) {
                search.setIdNota(invoice.getId());
                search.save();
              }

              //Atualizando o id da nota nos pagamentos
              List<Payment> payments = DatabaseApp.self().getDatabase().paymentDao().find();

              for (Payment payment : payments) {
                payment.setIdNota(invoice.getId());
                payment.save();
              }

              //Atualizando o id da nota no lote/Patrimonio
              List<LotePatrimonio> lotePatrimonios =
                  DatabaseApp.self().getDatabase().lotePatrimonioDao().find();

              for (LotePatrimonio lotePatrimonio : lotePatrimonios) {
                lotePatrimonio.setIdNota(invoice.getId());
                lotePatrimonio.save();
              }

              //Atualizando o id da nota no Abastecimento
              List<Abastecimento> abastecimentos =
                  DatabaseApp.self().getDatabase().abastecimentoDao().find(invoice.getCdCustomer());

              for (Abastecimento abastecimento : abastecimentos) {
                abastecimento.setIdNota(invoice.getId());
                abastecimento.save();
              }

              InvoiceImage invoiceImage = InvoiceImage.newInstance();
              invoiceImage.setIdNota(invoice.getId());
              invoiceImage.setStatus(StatusNFeType.PENDENTE_ENVIO.getValue());
              invoiceImage.save();

              //Atualizando o proximo numero da nota na General
              if (operation.getTipoNota().equals(InvoiceType.SAIDA))
                GLOBAL.self().getGeneral().setNumeroNotaSaida(++numeroNota);
              else
                GLOBAL.self().getGeneral().setNumeroNotaEntrada(++numeroNota);

              GLOBAL.self().getGeneral().save();

              LogHelper.self().info("Fim Nota fiscal: " + invoice.toString());
            }
          }
      );

      createXmlFile(invoice);

      return invoice;
    } catch (Exception e) {
      LogHelper.self().error("InvoceHelper", e);
      e.printStackTrace();
      return null;
    }
  }

  public String readXml(Invoice invoice) {

    File xmlFile = new File(UtilHelper.getInvoiceFileName(invoice));

    if (!xmlFile.exists())
      createXmlFile(invoice);

    xmlFile = new File(UtilHelper.getInvoiceFileName(invoice));

    Reader fileReader;
    try {
      fileReader = new FileReader(xmlFile);

      BufferedReader bufReader = new BufferedReader(fileReader);

      StringBuilder sb = new StringBuilder();
      String line = bufReader.readLine();

      while (line != null) {
        sb.append(line).append("\n");
        line = bufReader.readLine();
      }
      bufReader.close();

      return sb.toString();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

  private void saveFile(Document document, String fileName) {
    try {
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(document);
      StringWriter strWriter = new StringWriter();
      StreamResult result = new StreamResult(strWriter);

      transformer.transform(source, result);
//      File dir = new File(PathHelper.self().getFilePathInvoice());
      File file = new File(fileName);
      UtilHelper.saveFile(strWriter.getBuffer().toString(), file.getPath());

//
//      Transformer transformer = TransformerFactory.newInstance().newTransformer();
//      StringWriter writer = new StringWriter();
//      StreamResult result = new StreamResult(writer);
//      transformer.transform(new DOMSource(document), result);
//
//      File dir = new File(PathHelper.self().getFilePathInvoice());
//      File file = new File(dir, fileName);
//
//      BufferedWriter buf = new BufferedWriter(new FileWriter(file, false));
//      buf.append(writer.toString());
//      buf.newLine();
//      buf.close();
    } catch (Throwable e) {
      LogHelper.self().error("InvoiceHelper", e);
      e.printStackTrace();
    }
  }

  private void createXmlFile(Invoice invoice) {
    SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());

    Document document = invoice.createXmlFile();

    List<InvoiceItem> invoiceItems = DatabaseApp.self().getDatabase().invoiceItemDao()
        .findByIdNota(invoice.getId());
    invoice.setItens(invoiceItems);

    for (InvoiceItem invoiceItem : invoice.getItens()) {

      List<Rastreabilidade> rastreabilidades = DatabaseApp.self().getDatabase()
          .rastreabilidadeDao().findByItem(invoiceItem.getIdNota(), invoiceItem.getCdItem());
      invoiceItem.setRastreabilidades(rastreabilidades);

      document = invoiceItem.createXml(document, document.getDocumentElement());

//      //Criando o Lote/Patrimonio da Nota fiscal
//      LotePatrimonioDao lotePatrimonioDao = DatabaseApp.self().getDatabase().lotePatrimonioDao();
//      List<LotePatrimonio> lotePatrimonios = lotePatrimonioDao.findById(invoice.getId());
//      AssetDao assetDao = DatabaseApp.self().getDatabase().assetDao();
//
//      for (LotePatrimonio lotePatrimonio : lotePatrimonios) {
//        Asset asset = null;// = assetDao.findByNumeroPatrimonio(lotePatrimonio.getNumeroLote().toString());
//
//        if (lotePatrimonio.getTipo().equals(LotePatrimonioType.LOTE.getValue()))
//          document = lotePatrimonio.createXmlLote(document);
//        else {
//          asset = assetDao.findByNumeroPatrimonio(lotePatrimonio.getNumeroLote().toString());
//          document = lotePatrimonio.createXmlPatrimonio(document);
//        }
//
//        if (asset != null)
//          document = asset.createXml(document);
//      }
    }

    //Criando as observações da Nota fiscal
    InvoiceMessageDao invoiceMessageDao = DatabaseApp.self().getDatabase().invoiceMessageDao();
    List<InvoiceMessage> invoiceMessages = invoiceMessageDao.findById(invoice.getId());

    for (InvoiceMessage invoiceMessage : invoiceMessages) {
      document = invoiceMessage.createXml(document, document.getDocumentElement());
    }

    //Criando as pesquisa da Nota fiscal
    SearchDao searchDao = DatabaseApp.self().getDatabase().searchDao();
    Search search = searchDao.findById(invoice.getId());

    if (search != null) {
      document = search.createXml(document, document.getDocumentElement());
      //Criando as respostas da Nota fiscal
      AnswerDao answerDao = DatabaseApp.self().getDatabase().answerDao();
      List<Answer> answers = answerDao.findById(search.getId());

      for (Answer answer : answers) {
        document = answer.createXml(document, document.getDocumentElement());
      }
    }

    //Criando o pagamento da Nota fiscal
    PaymentDao paymentDao = DatabaseApp.self().getDatabase().paymentDao();
    List<Payment> payments = paymentDao.find(invoice.getId());

    if (payments.size() == 0) {
      Element downloaderNFe = (Element) document.getDocumentElement().getElementsByTagName("downloader_NFe").item(0);
      Element pagamentoCartaoElement = document.createElement("pagamento_cartao");
      downloaderNFe.appendChild(pagamentoCartaoElement);
    }

    for (Payment payment : payments) {
      document = payment.createXml(document);
    }

//    //Criando o Lote/Patrimonio da Nota fiscal
//    LotePatrimonioDao lotePatrimonioDao = DatabaseApp.self().getDatabase().lotePatrimonioDao();
//    List<LotePatrimonio> lotePatrimonios = lotePatrimonioDao.findById(invoice.getId());
//
//    for (LotePatrimonio lotePatrimonio : lotePatrimonios) {
//      document = lotePatrimonio.createXmlLote(document);
//    }

    LogHelper.self().info("Iniciando criação do vencimento");

    //Criando a vencimento da Nota fiscal
    createVencimento(document, operation, invoice);

    Element vencimento = (Element) document.getDocumentElement()
        .getElementsByTagName("vencimento").item(0);

    if (vencimento == null) {
      LogHelper.self().info("Recriando vencimento: " + invoice.toString());

      createVencimento(document, operation, invoice);
    }

    vencimento = (Element) document.getDocumentElement()
        .getElementsByTagName("vencimento").item(0);

    if (vencimento == null)
      LogHelper.self().info("Erro na criação do vencimento");
    else
      LogHelper.self().info("Vencimento criado com sucesso");

    saveFile(document, UtilHelper.getInvoiceFileName(invoice));
  }

  private void createVencimento(Document document, SuperOperation operation, Invoice invoice) {

    LogHelper.self().info("Criando vencimento: " + invoice.toString());
    LogHelper.self().info("Finaliza pedido: " + operation.isFinalizaPedido());

    if (operation.isFinalizaPedido()) {

      List<Tax> taxes = DatabaseApp.self().getDatabase().taxDao().findByCondPagtoEmissao(
          invoice.getCondicaoPagamento(), invoice.getDataEmissao());

      Integer count = 0;

      Element vencimentoElement;
      Double vlSomaParcelas = 0d, difValor = 0d;

      LogHelper.self().info("Taxas encontradas: " + taxes.size());

      for (Tax tax : taxes) {
        count++;

        vencimentoElement = document.createElement("vencimento");

        XmlConfig.createNode(document, vencimentoElement, "num_parcela",
            tax.getSeqParcela().toString());

        LogHelper.self().info("Parcela : " + tax.getSeqParcela().toString());

        Double vlCalculo = (invoice.getValorTotal() * tax.getPercentual()) / 100;

        vlCalculo = UtilHelper.formatDouble(vlCalculo, 2);
        vlSomaParcelas += vlCalculo;

        if (count.equals(taxes.size()))
          difValor = invoice.getValorTotal() - vlSomaParcelas;

        if (!difValor.equals(0d))
          vlCalculo += difValor;

        XmlConfig.createNode(document, vencimentoElement, "valor",
            UtilHelper.formatDoubleString(vlCalculo, 2));

        LogHelper.self().info("Tag valor criada: " + vlCalculo);

        XmlConfig.createNode(document, vencimentoElement, "dt_vencimento",
            UtilHelper.formatDateStr(tax.getDtParcela(), "yyyyMMdd"));

        LogHelper.self().info("Tag data criada: " +
            UtilHelper.formatDateStr(tax.getDtParcela(), "yyyyMMdd"));

        document.getDocumentElement().appendChild(vencimentoElement);

        LogHelper.self().info("Criando tag vencimento no XML");
      }

      LogHelper.self().info("Vencimento finalizado");
    }
  }

  public void cancel(final Invoice invoice) {
    try {

      LogHelper.self().info("Iniciando cancelamento da NFe: " + invoice.toString());

      DatabaseApp.self().getDatabase().runInTransaction(new Runnable() {
        @Override
        public void run() {

          if (invoice.getStatus().equals(StatusNFeType.AUTORIZADA.getValue())) {

            invoice.setItens(DatabaseApp.self().getDatabase().invoiceItemDao()
                .findByIdNota(invoice.getId()));
            SaldoHelper.self().atualizarSaldoInvoice(invoice, true);

            List<Rastreabilidade> rastreabilidades = DatabaseApp.self().getDatabase()
                .rastreabilidadeDao().findByNota(invoice.getId());

            rastreabilidades.forEach(rastreabilidade -> {
              rastreabilidade.setLiberado(ConstantsEnum.Y.getValue());
              rastreabilidade.update();
            });

            if (!rastreabilidades.isEmpty())
              LogHelper.self().info("Rastreabildiade liberada: " + invoice.toString());

            List<LotePatrimonio> lotePatrimonios = DatabaseApp.self().getDatabase()
                .lotePatrimonioDao().findById(invoice.getId());

            lotePatrimonios.forEach(lotePatrimonio -> {
              lotePatrimonio.setLiberado(ConstantsEnum.Y.getValue());
              lotePatrimonio.save();
            });

            if (!lotePatrimonios.isEmpty())
              LogHelper.self().info("Lote liberado: " + invoice.toString());
          }
        }
      });

      LogHelper.self().info("Cancelamento finalizado NFe: " + invoice.toString());
    } catch (Exception e) {
      LogHelper.self().error("InvoiceHelper", e);
      e.printStackTrace();

    }
  }

  public boolean showLostInvoices(boolean show) {

    class InvoiceLost {
      private Long numero;
      private Long serie;
      private String tipo;

      private InvoiceLost(Long numero, Long serie, String tipo) {
        this.numero = numero;
        this.serie = serie;
        this.tipo = tipo;
      }


      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceLost that = (InvoiceLost) o;
        return Objects.equals(numero, that.numero) &&
            Objects.equals(serie, that.serie);
      }

      @Override
      public int hashCode() {
        return Objects.hash(numero, serie);
      }

      @NonNull
      @Override
      public String toString() {
        return String.format(Locale.getDefault(), "%s\r%s\r%s",
            UtilHelper.padRight(numero.toString(), ' ', 6),
            UtilHelper.padRight(serie.toString(), ' ', 6),
            tipo);
      }
    }

    try {
      final List<InvoiceLost> invoicesInBuffer = new ArrayList<>();
      final List<InvoiceLost> invoicesOutBuffer = new ArrayList<>();

      Long invoiceFromIn = 0L;
      Long invoiceFromOut = 0L;

      InvoiceNumber invoiceNumber = DatabaseApp.self().getDatabase().invoiceNumberDao().getFirst();

      Long serieE = invoiceNumber.getNumeroSerieEntrada();
      Long serieS = invoiceNumber.getNumeroSerieSaida();

      Invoice invoiceIn = DatabaseApp.self().getDatabase().invoiceDao().findByTipoNota(InvoiceType.ENTRADA.getValue());
      Invoice invoiceOut = DatabaseApp.self().getDatabase().invoiceDao().findByTipoNota(InvoiceType.SAIDA.getValue());

      List<Invoice> invoicesIn = DatabaseApp.self().getDatabase().invoiceDao().findAllByTipoNota(InvoiceType.ENTRADA.getValue());
      List<Invoice> invoicesOut = DatabaseApp.self().getDatabase().invoiceDao().findAllByTipoNota(InvoiceType.SAIDA.getValue());

      if (invoiceIn != null)
        invoiceFromIn = invoiceIn.getNumero();

      if (invoiceOut != null)
        invoiceFromOut = invoiceOut.getNumero();

      if (invoiceFromIn == 0)
        --invoiceFromIn;

      for (Long idx = invoiceNumber.getNumeroNotaFiscalEntrada(); idx <= invoiceFromIn; idx++)
        invoicesInBuffer.add(new InvoiceLost(idx, serieE, "Entrada"));

      if (invoiceFromOut == 0)
        --invoiceFromOut;

      for (Long idx = invoiceNumber.getNuemroNotaFiscalSaida(); idx <= invoiceFromOut; idx++)
        invoicesOutBuffer.add(new InvoiceLost(idx, serieS, "Saída"));

      for (Invoice header : invoicesOut) {
        InvoiceLost invoiceLost = new InvoiceLost(header.getNumero(), header.getSerie(),
            "Saída");

        int idx = invoicesOutBuffer.indexOf(invoiceLost);

        if (idx >= 0)
          invoicesOutBuffer.remove(idx);
      }

      for (Invoice header : invoicesIn) {
        InvoiceLost invoiceLost = new InvoiceLost(header.getNumero(), header.getSerie(),
            "Entrada");
        int idx = invoicesInBuffer.indexOf(invoiceLost);

        if (idx >= 0)
          invoicesInBuffer.remove(idx);
      }

      if (!invoicesInBuffer.isEmpty() || !invoicesOutBuffer.isEmpty()) {

        DialogHelper.showInformationMessage(activity, R.string.informar_text,
            R.string.lost_invoices_1, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {

                ArrayList<String> in = new ArrayList<>();

                for (InvoiceLost invoiceLost : invoicesInBuffer)
                  in.add(invoiceLost.toString());

                ArrayList<String> out = new ArrayList<>();

                for (InvoiceLost invoiceLost : invoicesOutBuffer)
                  out.add(invoiceLost.toString());

                Intent it = new Intent(activity, InvoiceLostActivity.class);
                it.putStringArrayListExtra("in", in);
                it.putStringArrayListExtra("out", out);
                final int REQUEST_LOST_INVOICES = 3;
                activity.startActivityForResult(it, REQUEST_LOST_INVOICES);
              }
            });

        return true;
      } else {
        if (show)
          DialogHelper.showInformationMessage(activity, R.string.informar_text,
              R.string.lost_invoices_2, null);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      LogHelper.self().error("verificarIntegridade", ex);
      //throw ex;
    }
    return false;
  }

}
