package br.com.whitemartins.obc.model.sync;


import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.BeginTravelType;
import br.com.whitemartins.obc.enumeration.CecType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.LotePatrimonioType;
import br.com.whitemartins.obc.enumeration.PrintStatusType;
import br.com.whitemartins.obc.enumeration.StatusCecType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.enumeration.StepEmissaoType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Abastecimento;
import br.com.whitemartins.obc.model.Answer;
import br.com.whitemartins.obc.model.Code;
import br.com.whitemartins.obc.model.ConversaoLQ;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.InvoiceMessage;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.LotePatrimonio;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.model.PaymentCard;
import br.com.whitemartins.obc.model.Rastreabilidade;
import br.com.whitemartins.obc.model.Search;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.service.InvoiceImageBackgroundService;
import br.com.whitemartins.obc.util.ImageHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

@Root
public class NotasFiscais {

  @Element(name = "cabecalhoNFe")
  private CabecalhoNFe cabecalhoNFe;

  @ElementList(name = "detalheNFe", inline = true)
  private List<DetalheNFe> detalhes;

  @ElementList(name = "vencimento", inline = true, required = false)
  private List<VencimentoNFe> vencimentos;

  @ElementList(name = "observacao", required = false, inline = true)
  private List<ObservacaoNFe> observacoes;

  @Element(name = "pesquisa", required = false)
  private PesquisaNFe pesquisaSatisfacao;

  public NotasFiscais() {
    observacoes = new ArrayList<>();
    detalhes = new ArrayList<>();
    vencimentos = new ArrayList<>();
  }

  @NonNull
  @Override
  public String toString() {
    return String.format(Locale.getDefault(),
      "Nota: %d Série: %d", cabecalhoNFe.getNumero(), cabecalhoNFe.getSerie());
  }

  public CabecalhoNFe getCabecalhoNFe() {
    return cabecalhoNFe;
  }

  public List<DetalheNFe> getDetalhes() {
    return detalhes;
  }

  public List<VencimentoNFe> getVencimentos() {
    return vencimentos;
  }

  public List<ObservacaoNFe> getObservacoes() {
    return observacoes;
  }

  public PesquisaNFe getPesquisaSatisfacao() {
    return pesquisaSatisfacao;
  }

  public void saveAll() throws IOException {

    SuperOperation operation = SuperOperation.getOperation(UtilHelper
      .convertToIntegerDef(cabecalhoNFe.getDownloaderNFe().getTipoTransacao(), 0));

    Invoice invoice = Invoice.newInstance();

    invoice.setDataViagem(getCabecalhoNFe().getDataViagem());

    if (operation.isFinalizaPedido())
      invoice.setSemPagto(ConstantsEnum.NO.getValue());
    else
      invoice.setSemPagto(ConstantsEnum.YES.getValue());

    invoice.setNumero(cabecalhoNFe.getNumero());
    invoice.setDataEmissao(UtilHelper.convertToDate(cabecalhoNFe.getDataEmissao(),
      ConstantsEnum.yyyyMMdd.getValue()));
    invoice.setDataMovimento(UtilHelper.convertToDate(cabecalhoNFe.getDataMovimento(),
      ConstantsEnum.yyyyMMdd_HHmmsss.getValue()));

    invoice.setTipoMovimentoIntegracao(cabecalhoNFe.getTipoMovimentoIntegracao());
    invoice.setTipoTransacao(UtilHelper.convertToIntegerDef(cabecalhoNFe.getDownloaderNFe()
      .getTipoTransacao(), 0));

    invoice.setSerie(cabecalhoNFe.getSerie());
    invoice.setCnpjCpfDestino(cabecalhoNFe.getCnpjCpfDestino());
    invoice.setCnpjCpfTransp(cabecalhoNFe.getCpnjCpfTransp());
    invoice.setDataViagem(cabecalhoNFe.getDataViagem());
    invoice.setNumeroViagem(UtilHelper.padLeft(cabecalhoNFe.getNumeroViagem(), '0', 6));
    invoice.setTipoNota(cabecalhoNFe.getTipoNota());
    invoice.setUfVeiculo(cabecalhoNFe.getUfVeiculo());
    invoice.setPlacaVeiculo(cabecalhoNFe.getPlacaVeiculo());
    invoice.setNumeroVeiculo(cabecalhoNFe.getNumeroVeiculo());
    invoice.setValorLiquido(UtilHelper.formatDouble(cabecalhoNFe.getValorLiquido(), 2));
    invoice.setValorTotal(UtilHelper.formatDouble(cabecalhoNFe.getValorTotal(), 2));
    invoice.setModalidadeFrete(cabecalhoNFe.getModalidadeFrete());
    invoice.setNomeMarca(cabecalhoNFe.getNomeMarca());
    invoice.setModalidadeFrete(cabecalhoNFe.getModalidadeFrete());
    invoice.setValorFrete(UtilHelper.formatDouble(cabecalhoNFe.getValorFrete(), 2));
    invoice.setValorDespAcessorias(UtilHelper.formatDouble(cabecalhoNFe.getValorDespAcessorias(), 2));
    invoice.setValorTotalProduto(UtilHelper.formatDouble(cabecalhoNFe.getValorTotalProduto(), 2));
    invoice.setPesoBruto(cabecalhoNFe.getPesoBruto());
    invoice.setPesoLiquido(cabecalhoNFe.getPesoLiquido());
    invoice.setModalidadeFrete(cabecalhoNFe.getModalidadeFrete());
    invoice.setTipoPedido(cabecalhoNFe.getTipoPedido());
    invoice.setCdCustomer(cabecalhoNFe.getCdCustomer());

    invoice.setAtivaTipoPagto(cabecalhoNFe.getAtivaTipoPagto());
    invoice.setNomeEspecVolume(cabecalhoNFe.getNomeEspecVolume());

    invoice.setChave(cabecalhoNFe.getDownloaderNFe().getChave());
    invoice.setProtocolo(cabecalhoNFe.getDownloaderNFe().getProtocolo());
    invoice.setTipoTransacao(UtilHelper.convertToIntegerDef(cabecalhoNFe.getDownloaderNFe()
      .getTipoTransacao(), 0));

    invoice.setCdFiscal(cabecalhoNFe.getDownloaderNFe().getCdFiscal());
    invoice.setNomeOperacao(operation.getOperationType().getName());
    invoice.setStepEmissao(StepEmissaoType.FINALIZAR.getValue());

    invoice.setNumeroNotaVOR(cabecalhoNFe.getDownloaderNFe().getNumeroNotaVOR());
    invoice.setValorDinheiro(UtilHelper.formatDouble(cabecalhoNFe.getDownloaderNFe().getFormaPagamentoNFe().getValorDinheiro(), 2));
    invoice.setValorTroco(UtilHelper.formatDouble(cabecalhoNFe.getDownloaderNFe().getFormaPagamentoNFe().getValorTroco(), 2));
    invoice.setValorCheque(UtilHelper.formatDouble(cabecalhoNFe.getDownloaderNFe().getFormaPagamentoNFe().getValorCheque(), 2));
    invoice.setNumeroCheque(cabecalhoNFe.getDownloaderNFe().getFormaPagamentoNFe().getNumeroCheque());
    invoice.setValorDebito(UtilHelper.formatDouble(cabecalhoNFe.getDownloaderNFe().getFormaPagamentoNFe().getValorDebito(), 2));
    invoice.setValorCredito(UtilHelper.formatDouble(cabecalhoNFe.getDownloaderNFe().getFormaPagamentoNFe().getValorCredito(), 2));
    invoice.setValorFatura(UtilHelper.formatDouble(cabecalhoNFe.getDownloaderNFe().getFormaPagamentoNFe().getValorFatura(), 2));

    invoice.setAliquotaIcms(cabecalhoNFe.getDownloaderNFe().getAliquotaIcms());
    invoice.setBaseCalculoIcms(cabecalhoNFe.getDownloaderNFe().getBaseCalculoIcms());
    invoice.setValorIcms(UtilHelper.formatDouble(cabecalhoNFe.getDownloaderNFe().getValorIcms(), 2));
    invoice.setSituacaoTributariaIcms(cabecalhoNFe.getDownloaderNFe().getTipoIcms());

    invoice.setValorDescontoIcms(UtilHelper.formatDouble(cabecalhoNFe.getValorDescontoIcms(), 2));
    invoice.setSituacaoTributariaIcms(cabecalhoNFe.getDownloaderNFe().getTipoIcms());

    invoice.setSituacaoTributariaIpi(cabecalhoNFe.getDownloaderNFe().getTipoIpi());
    invoice.setBaseCalculoIpi(cabecalhoNFe.getDownloaderNFe().getBaseCalculoIpi());
    invoice.setValorIpi(UtilHelper.formatDouble(cabecalhoNFe.getDownloaderNFe().getValorIpi(), 2));
    invoice.setCdCustomerService(cabecalhoNFe.getCdCustomerService());
    invoice.setNomeAssinadorCec(cabecalhoNFe.getNomeAssinadorCec().trim());
    invoice.setRgAssinadorCec(cabecalhoNFe.getRgAssinadorCec().trim());
    invoice.setSemPagto(cabecalhoNFe.getSemPagto());
    invoice.setStatusGravacaoJde(cabecalhoNFe.getStatusGravacaoJde());
    invoice.setMensagemGravacaoJde(cabecalhoNFe.getMensagemGravacaoJde());

    if (cabecalhoNFe.getDownloaderNFe().getCdMotivo() != null && !cabecalhoNFe.getDownloaderNFe().getCdMotivo().isEmpty()) {
      invoice.setCdMotivo(cabecalhoNFe.getDownloaderNFe().getCdMotivo().split("\\-")[0].trim());
      invoice.setDsMotivo(cabecalhoNFe.getDownloaderNFe().getCdMotivo().split("\\-")[1].trim());
    }
    invoice.setNumeroFutEntrega(cabecalhoNFe.getDownloaderNFe().getNumeroFutEntrega().trim());
    invoice.setVolumeCapacidade(cabecalhoNFe.getDownloaderNFe().getVolumeCapacidade());
    if (GLOBAL.self().isLiquido())
      invoice.setVolumeCapacidadeReport(cabecalhoNFe.getDownloaderNFe().getVolumeCapacidade());
    invoice.setCdMovimento(cabecalhoNFe.getDownloaderNFe().getCdMovimento());
    invoice.setCondicaoPagamento(cabecalhoNFe.getDownloaderNFe().getCondicaoPagamento());
    invoice.setCdFiscal(cabecalhoNFe.getDownloaderNFe().getCdFiscal());
    invoice.setTipoMovimentoIntegracao(cabecalhoNFe.getDownloaderNFe().getTipoMovimentoIntegracao());
    invoice.setStatus(cabecalhoNFe.getDownloaderNFe().getStatus());

    //Despreza a chave para notas rejeitadas
    if (!invoice.getStatus().equals(StatusNFeType.AUTORIZADA.getValue())) {
      invoice.setChave("");
      invoice.setProtocolo("NFe. " + StatusNFeType.getNameByValue(invoice.getStatus()));
    }

    invoice.setCondicaoPagamento(cabecalhoNFe.getDownloaderNFe().getCondicaoPagamento());
    invoice.setCdOperadora(cabecalhoNFe.getDownloaderNFe().getCdJdeOperadora());
    invoice.setFlPaciente(cabecalhoNFe.getDownloaderNFe().getFlagPaciente());
    invoice.setCdCustomerService(cabecalhoNFe.getDownloaderNFe().getCdCustomerService());
    invoice.setFlNovoFaturamento(cabecalhoNFe.getDownloaderNFe().getFlNovoFaturamento());

    boolean aVista = invoice.getValorFatura() == 0;

    CecType cecType = GLOBAL.self().getCecDanfe(operation, aVista);
    StatusCecType statusCecType = StatusCecType.CEC_REFEITO;

    if (Integer.parseInt(cecType.getValue()) >= 3)
      statusCecType = StatusCecType.DANFE_REFEITO;

    invoice.setStatusCec(statusCecType.getValue());
    invoice.setNomeFormaImpressaoCec(statusCecType.getValue() + statusCecType.getName());
    invoice.setStatusNfeImp(statusCecType.getValue() + invoice.getProtocolo());
    invoice.setStatusReportFile(statusCecType.getValue() + statusCecType.getTypeName());
    invoice.save();

    invoice.setStatusCec(statusCecType.getValue());
    invoice.setStatusImpressaoCec(PrintStatusType.NAO_IMPRESSO.getValue());

    String nomeTipoPagamento = "";

    if (invoice.getValorDinheiro() > 0)
      nomeTipoPagamento = "1Dinheiro";
    else if (invoice.getValorCheque() > 0)
      nomeTipoPagamento = "2Cheque";
    else if (invoice.getValorFatura() > 0)
      nomeTipoPagamento = operation.isFinalizaPedido() ? "4Prazo" : "0";
    else
      nomeTipoPagamento = "3Deb/Cre";

    invoice.setNomeTipoPagamento(nomeTipoPagamento);
    invoice.setFlPrecoAlterado(cabecalhoNFe.getFlPrecoAlterado());

    LogHelper.self().info(getClass().getSimpleName(), "Parse da Nota fiscal finalizado.");

    long i = 0;
    for (DetalheNFe detalheNFe : getDetalhes()) {
      InvoiceItem invoiceItem = InvoiceItem.newInstance();

      invoice.getItens().add(invoiceItem);

      invoiceItem.setSeqItem(++i);
      invoiceItem.setNumeroNota(invoice.getNumero());
      invoiceItem.setSerieNota(invoice.getSerie());
      invoiceItem.setNaturezaOperacao(detalheNFe.getNaturezaOperacao());
      invoiceItem.setNomeNaturezaOperacao(detalheNFe.getNomeNaturezaOperacao());
      invoiceItem.setCfop(detalheNFe.getCfop());
      invoiceItem.setClassifFiscal(UtilHelper.convertToLongDef(detalheNFe
        .getClassificacaoFiscal(), 0));
      invoiceItem.setCdItem(UtilHelper.convertToLongDef(detalheNFe.getCodigoItem(), 0));
      invoiceItem.setNomeItem(detalheNFe.getDescricaoItem());
      invoiceItem.setCapacidade(detalheNFe.getDetalheDownloaderNFe().getCapacidadeItem());
      invoiceItem.setQtdItem(detalheNFe.getQuantidade());
      //invoiceItem.setVolume(detalheNFe.);
      invoiceItem.setUnidadeMedida(detalheNFe.getUnidadeMedidaComercial());
      invoiceItem.setCstAIcms(detalheNFe.getCodigoSituacaoTributariaIcmsA());
      invoiceItem.setCstBIcms(detalheNFe.getCodigoSituacaoTributariaIcmsB());
      invoiceItem.setCstIpi(detalheNFe.getCodigoSituacaoTributariaIpi());
      invoiceItem.setCstPis(detalheNFe.getCodigoSituacaoTributariaPis());
      invoiceItem.setCstIpi(detalheNFe.getCodigoSituacaoTributariaIpi());
      invoiceItem.setCstCofins(detalheNFe.getCodigoSituacaoTributariaCofins());
      invoiceItem.setValorTotal(detalheNFe.getValorTotal());
      invoiceItem.setValorBaseReduzidaIcms(detalheNFe.getValorReducaoBaseIcms());
      invoiceItem.setValorBaseIcms(detalheNFe.getValorBaseIcms());
      invoiceItem.setValorIcms(detalheNFe.getValorTributadoIcms());
      invoiceItem.setValorCreditoIcms(detalheNFe.getValorCreditoIcms());
      invoiceItem.setValorDebitoIcms(detalheNFe.getValorDebitoIcms());
      invoiceItem.setValorBaseIcmsSt(detalheNFe.getValorBaseIcmsST());
      invoiceItem.setValorIcmsSt(detalheNFe.getValorIcmsST());

      invoiceItem.setValorBaseIpi(detalheNFe.getValorBaseIpi());
      invoiceItem.setValorIpi(detalheNFe.getValorTributadoIpi());
      invoiceItem.setValorDebitoIpi(detalheNFe.getValorDebitoIpi());
      invoiceItem.setValorCreditoIpi(detalheNFe.getValorCreditoIpi());

      invoiceItem.setValorBasePis(detalheNFe.getValorBasePis());
      invoiceItem.setValorDebitoPis(detalheNFe.getValorDebitoPis());
      invoiceItem.setValorCreditoPis(detalheNFe.getValorCreditoPis());
      invoiceItem.setValorBaseCreditoPis(detalheNFe.getValorBaseCreditoPis());

      invoiceItem.setValorBaseCofins(detalheNFe.getValorBaseCofins());
      invoiceItem.setValorDebitoCofins(detalheNFe.getValorDebitoCofins());
      invoiceItem.setValorCreditoCofins(detalheNFe.getValorCreditoCofins());
      invoiceItem.setValorBaseCreditoCofins(detalheNFe.getValorBaseCreditoCofins());

      invoiceItem.setAliquotaIcms(detalheNFe.getAliquotaIcms());
      invoiceItem.setAliquotaIpi(detalheNFe.getAliquotaIpi());
      invoiceItem.setAliquotaPis(detalheNFe.getAliquotaPis());
      invoiceItem.setAliquotaCofins(detalheNFe.getAliquotaCofins());

      invoiceItem.setTipoIcms(detalheNFe.getTipoIcms());
      invoiceItem.setTipoIpi(detalheNFe.getTipoIpi());
      invoiceItem.setTipoPis(detalheNFe.getTipoPis());
      invoiceItem.setTipoCofins(detalheNFe.getTipoCofins());

      invoiceItem.setValorTotalFrete(detalheNFe.getValorTotalFrete());
      invoiceItem.setValorTotalSeguro(detalheNFe.getValorTotalSeguro());
      invoiceItem.setValorDescontoIcms(detalheNFe.getValorDesconto());
      invoiceItem.setValorUnitario(detalheNFe.getValorUnitario());
      invoiceItem.setFlPrecoAlterado(detalheNFe.getDetalheDownloaderNFe()
        .getIndicadorAlteracaoPreco());
      invoiceItem.setValorPrecoUnitarioOriginal(detalheNFe.getDetalheDownloaderNFe()
        .getPrecoUnitarioOriginal());
      invoiceItem.setCondicaoPagamento(detalheNFe.getDetalheDownloaderNFe().getCondicaoPagamento());
      invoiceItem.setCdMovimento(detalheNFe.getDetalheDownloaderNFe().getCodigoMovimento());
      invoiceItem.setCondicaoPagamento(detalheNFe.getDetalheDownloaderNFe().getCondicaoPagamento());
      invoiceItem.setQuantidadeCilindroVendida(detalheNFe.getDetalheDownloaderNFe()
        .getQuantidadeCilindrosVendida());
      invoiceItem.setValorDespesasAcessorias(detalheNFe.getValorOutrasDespesasAcessorias());
      invoiceItem.setTipoFaturamento(detalheNFe.getDetalheDownloaderNFe().getTipoFaturamento());

      Item item = DatabaseApp.self().getDatabase().itemDao().find(invoiceItem.getCdItem());
      if (item != null)
        invoiceItem.setTipoItem(item.getTipoItem());

      //Parse dos PPs
      if (!detalheNFe.getDetalheDownloaderNFe().getInformacoesCilindro().getNumeroSerieCilPps().isEmpty()) {
        StringBuilder cilPP = new StringBuilder();

        for (NumeroSerieCilPp s : detalheNFe.getDetalheDownloaderNFe().getInformacoesCilindro().getNumeroSerieCilPps())
          cilPP.append(s.getNumeroSerie());

        invoiceItem.setInfCilPP(cilPP.toString());
      }

      invoice.setFlPrecoAlterado(invoiceItem.getFlPrecoAlterado());
      invoice.getItens().add(invoiceItem);
      LogHelper.self().info(getClass().getSimpleName(), "Parse do Item finalizado.");

      invoice.save();

      if (cabecalhoNFe.getAssinatura() == null || cabecalhoNFe.getAssinatura().isEmpty()) {
        try {
          Bitmap bitmap = ImageHelper.self().doTextSignature(
            "CEC gerado pelo\nprocesso refazer\nviagem", 480, 240);

          ImageHelper.self().saveBitmap(invoice, bitmap, false);

          InvoiceImage invoiceImage = InvoiceImage.newInstance();
          invoiceImage.setStatus(StatusNFeType.PENDENTE_ENVIO.getValue());
          invoiceImage.setIdNota(invoice.getId());
          ImageHelper.self().setBitmapsFromInvoiceAndSave(invoice, invoiceImage);
          GLOBAL.self().getInvoiceImageBackgroundService().addImageToList(invoiceImage);
        } catch (IOException e) {
          LogHelper.self().error("NotasFiscais", e);

          e.printStackTrace();
        }

      } else {
        //Salvando a imagem da assinatura no disco
        ImageHelper.self().getBitpmapFromString(invoice, cabecalhoNFe.getAssinatura());

        InvoiceImage invoiceImage = InvoiceImage.newInstance();
        invoiceImage.setStatus(StatusNFeType.AUTORIZADA.getValue());
        invoiceImage.setIdNota(invoice.getId());
        ImageHelper.self().setBitmapsFromInvoiceAndSave(invoice, invoiceImage);

      }
      LogHelper.self().info(getClass().getSimpleName(),
        "Parse da Imagem da assinatura finalizado.");

      //Parse da Rastreabilidade
      if (detalheNFe.getDetalheDownloaderNFe().getDadosRastreabilidade() != null)
        for (DadosRastreabilidadeNFe dadosRastreabilidadeNFe : detalheNFe.getDetalheDownloaderNFe().getDadosRastreabilidade()) {
          Rastreabilidade rastreabilidade = Rastreabilidade.newInstance();
          rastreabilidade.setCdFilial(GLOBAL.self().getRoute().getCdFilialJde());
          rastreabilidade.setIdNota(invoice.getId());
          rastreabilidade.setNumeroVeiculo(GLOBAL.self().getStaticTable().getCdVeiculo());
          rastreabilidade.setCdFilial(GLOBAL.self().getStaticTable().getCdFilial());
          rastreabilidade.setNumeroNota(invoiceItem.getNumeroNota());
          rastreabilidade.setCdItem(invoiceItem.getCdItem());
          rastreabilidade.setCapacidadeItem(invoiceItem.getCapacidade());
          rastreabilidade.setCdCilindro(UtilHelper.padLeft(dadosRastreabilidadeNFe.getCodigoCilindro(), '0', 9));
          rastreabilidade.setNumeroLote(dadosRastreabilidadeNFe.getNumeroLote());
          rastreabilidade.setCdCustomer(invoice.getCdCustomer());
          rastreabilidade.setNumeroViagem(UtilHelper.convertToLongDef(cabecalhoNFe.getNumeroViagem(), 0));
          rastreabilidade.setDataViagem(UtilHelper.convertToDate(cabecalhoNFe.getDataViagem(),
            ConstantsEnum.yyyyMMdd.getValue()));

          if (invoice.isCanceled())
            rastreabilidade.setLiberado(ConstantsEnum.YES.getValue());
          else
            rastreabilidade.setLiberado(ConstantsEnum.NO.getValue());

          rastreabilidade.save();
        }

      LogHelper.self().info(getClass().getSimpleName(), "Parse da rastreabilidade finalizado.");

      //Parse do patrimônios
      //if (detalheNFe.getDetalheDownloaderNFe().getDetalheDownloaderInfPatrimonioNFes() != null)
      for (DetalheDownloaderInfPatrimonioNFe detalheDownloaderInfPatrimonioNFe : detalheNFe.getDetalheDownloaderNFe().getDetalheDownloaderInfPatrimonioNFes()) {

        LotePatrimonio lotePatrimonio = LotePatrimonio.newInstance();

        lotePatrimonio.setNumeroLote(detalheDownloaderInfPatrimonioNFe.getNumero().trim());
        lotePatrimonio.setIdNota(invoice.getId());
        lotePatrimonio.setCdCustomer(invoice.getCdCustomer());
        lotePatrimonio.setCdFilial(GLOBAL.self().getRoute().getCdFilial());
        lotePatrimonio.setDataViagem(GLOBAL.self().getRoute().getDataViagem());
        lotePatrimonio.setNumeroVeiuclo(GLOBAL.self().getRoute().getNumVeiculo());
        lotePatrimonio.setNumeroViagem(GLOBAL.self().getRoute().getNumeroViagem());
        lotePatrimonio.setCdItem(invoiceItem.getCdItem());
        lotePatrimonio.setCapacidade(invoiceItem.getCapacidade());
        lotePatrimonio.setTipo(LotePatrimonioType.PATRIMONIO.getValue());

        if (invoice.isCanceled())
          lotePatrimonio.setLiberado(ConstantsEnum.YES.getValue());
        else
          lotePatrimonio.setLiberado(ConstantsEnum.NO.getValue());

        lotePatrimonio.save();
      }
      LogHelper.self().info(getClass().getSimpleName(), "Parse do patrimônio finalizado.");

      //Parse do lotes
      if (detalheNFe.getDetalheDownloaderNFe().getInfLotes().getLote() != null)
        for (String loteFabricacao : detalheNFe.getDetalheDownloaderNFe().getInfLotes().getLote()) {

          if (loteFabricacao != null) {

            LotePatrimonio lotePatrimonio = LotePatrimonio.newInstance();

            lotePatrimonio.setNumeroLote(loteFabricacao.trim());
            lotePatrimonio.setIdNota(invoice.getId());
            lotePatrimonio.setCdCustomer(invoice.getCdCustomer());
            lotePatrimonio.setCdFilial(GLOBAL.self().getRoute().getCdFilial());
            lotePatrimonio.setDataViagem(GLOBAL.self().getRoute().getDataViagem());
            lotePatrimonio.setNumeroVeiuclo(GLOBAL.self().getRoute().getNumVeiculo());
            lotePatrimonio.setNumeroViagem(GLOBAL.self().getRoute().getNumeroViagem());
            lotePatrimonio.setCdItem(invoiceItem.getCdItem());
            lotePatrimonio.setCapacidade(invoiceItem.getCapacidade());
            lotePatrimonio.setTipo(LotePatrimonioType.LOTE.getValue());
            lotePatrimonio.setLiberado(ConstantsEnum.NO.getValue());

            lotePatrimonio.save();
          }
        }
      LogHelper.self().info(getClass().getSimpleName(), "Parse do lote finalizado.");

      //Parse do calculpo do volume
      for (DetalheDownloaderCalculoVolumeNFe volumeNFe : detalheNFe.getDetalheDownloaderNFe().getDetalheDownloaderCalculoVolumeNFes()) {

        ConversaoLQ conversaoLQ = DatabaseApp.self().getDatabase().conversionLQDao()
          .find(invoice.getCdCustomer(), volumeNFe.getNumeroWm(), volumeNFe.getNumSerieTanque());

        Abastecimento abastecimento = Abastecimento.newInstance();

        abastecimento.setIdNota(invoice.getId());
        abastecimento.setNumeroSerieTanque(volumeNFe.getNumSerieTanque());
        abastecimento.setTotalNfe(volumeNFe.getTotalNFe());
        abastecimento.setCdCustomer(invoice.getCdCustomer());
        abastecimento.setCapacidadeKG(conversaoLQ.getCapacidadeKG());
        abastecimento.setCapacidadePol(conversaoLQ.getCapacidadePol());
        abastecimento.setFatorConversao(volumeNFe.getFatorConversao());
        abastecimento.setDivergente(volumeNFe.getDivergente());
        abastecimento.setNivelAntes(volumeNFe.getNivelAntes());
        abastecimento.setNivelDepois(volumeNFe.getNivelDepois());
        abastecimento.setPesoAntes(volumeNFe.getPesoAntes());
        abastecimento.setPesoDepois(volumeNFe.getPesoDepois());
        abastecimento.setNumWM(volumeNFe.getNumeroWm());
        abastecimento.setTipoCalculo(volumeNFe.getTipoCalculo());
        abastecimento.setTotalCalulado(volumeNFe.getTotalCalculado());
        abastecimento.setTotalDescarga(volumeNFe.getTotalDescarga());
        abastecimento.setDivergente(volumeNFe.getDivergente());

        abastecimento.save();
      }
      LogHelper.self().info(getClass().getSimpleName(), "Parse do cálculo do volume finalizado.");
    }

    //Parse da observação
    for (ObservacaoNFe observacaoNFe : observacoes) {

      InvoiceMessage invoiceMessage = InvoiceMessage.newInstance();
      invoiceMessage.setTipoTransacao(operation.getTipoTransacao());
      invoiceMessage.setNumeroNota(invoice.getNumero());
      invoiceMessage.setSerieNota(invoice.getSerie());
      invoiceMessage.setCdCustomer(invoice.getCdCustomer());
      invoiceMessage.setIdNota(invoice.getId());
      invoiceMessage.setDataEmissao(invoice.getDataEmissao());
      invoiceMessage.setLinha(observacaoNFe.getSequencialLinha());
      invoiceMessage.setSequencia(observacaoNFe.getSequencial());
      invoiceMessage.setCdRota(GLOBAL.self().getRoute().getCdRota());
      invoiceMessage.setMensagem(observacaoNFe.getDescricao());
      invoiceMessage.setNumeroFutEntrega(invoice.getNumeroFutEntrega());

      if (observacaoNFe.getDescricao().contains("Assistência Técnica:"))
        invoiceMessage.setMostrarMsg(ConstantsEnum.NO.getValue());
      else if (observacaoNFe.getDescricao().contains("|"))
        invoiceMessage.setMostrarMsg(ConstantsEnum.YES.getValue());
      else
        invoiceMessage.setMostrarMsg(ConstantsEnum.NO.getValue());

      invoiceMessage.save();
    }
    LogHelper.self().info(getClass().getSimpleName(), "Parse da observação finalizado.");

    //Parse das informaçãoes de cartão
    for (Cartao cartao : getCabecalhoNFe().getDownloaderNFe().getPagamentoCartao().getDadosCartao()) {

      PaymentCard paymentCard = DatabaseApp.self().getDatabase().payCardDao()
        .findByCnpj(cartao.getCnpj().trim());

      Code code = DatabaseApp.self().getDatabase().codeDao().find(ConstantsEnum.Y.getValue(),
        UtilHelper.convertToIntegerDef(cartao.getBandeira(), 0));

      Payment payment = Payment.newInstance();

      payment.setIdNota(invoice.getId());
      payment.setCnpj(cartao.getCnpj());
      payment.setBandeira(cartao.getBandeira());
      payment.setNomeBandeira(code.getDescricao());
      payment.setCredenciadora(paymentCard.getNomeEmpresa());
      payment.setModalidade(cartao.getModalidade());
      payment.setNumeroAutorizacao(cartao.getNumAutorizacao());
      payment.setValor(cartao.getValor());
      payment.setTipoIntegracao(cartao.getTipoIntegracao());

      payment.save();
    }
    LogHelper.self().info(getClass().getSimpleName(), "Parse do pagamento cartão finalizado.");

    //Parse da observação
    if (pesquisaSatisfacao != null) {
      Search search = Search.newInstance();

      search.setIdNota(invoice.getId());
      search.setCdCustomer(invoice.getCdCustomer());
      search.setCargo(pesquisaSatisfacao.getCargo());
      search.setContato(pesquisaSatisfacao.getContato());
      search.setDtPesquisa(UtilHelper.convertToDate(pesquisaSatisfacao.getDataPesquisa(),
        ConstantsEnum.yyyyMMdd.getValue()));
      search.setMotorista(pesquisaSatisfacao.getMotorista());
      search.setRejeitada(pesquisaSatisfacao.getIndicadorRejeicao());
      search.save();

      LogHelper.self().info(getClass().getSimpleName(), "Parse da pesquisa satisfação finalizado.");

      long id = 0;
      for (RespostaNFe respostaNFe : pesquisaSatisfacao.getRespostas()) {
        Answer answer = Answer.newInstance();

        answer.setId(++id);
        answer.setCategorizada(respostaNFe.getCategorizada());
        answer.setIdPesquisa(search.getId());
        answer.setPergunrta(respostaNFe.getPergunta());
        answer.setResposta(respostaNFe.getResposta());
        answer.save();

        LogHelper.self().info(getClass().getSimpleName(), "Parse da resposta finalizado.");
      }
    }
  }
}
