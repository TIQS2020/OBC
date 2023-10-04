package br.com.whitemartins.obc.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.CustomerDao;
import br.com.whitemartins.obc.dao.ItemDao;
import br.com.whitemartins.obc.dao.MessageDao;
import br.com.whitemartins.obc.dao.RastreabilidadeDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.CustomerType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TaxingType;
import br.com.whitemartins.obc.enumeration.UfType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.InvoiceMessage;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.Message;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.model.Rastreabilidade;
import br.com.whitemartins.obc.model.Tax;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.views.DatabaseApp;

public class InvoiceMessageHelper {
  private static InvoiceMessageHelper _self;

  private Activity activity;

  private SuperOperation operation;
  private Invoice invoice;
  private MessageDao messageDao = DatabaseApp.self().getDatabase().messageDao();
  private CustomerDao customerDao = DatabaseApp.self().getDatabase().customerDao();
  private RastreabilidadeDao rastreabDao = DatabaseApp.self().getDatabase().rastreabilidadeDao();
  private String addMessage;

  private InvoiceMessageHelper() {
    addMessage = "";
  }

  private static InvoiceMessageHelper newInstace() {
    return new InvoiceMessageHelper();
  }

  public static InvoiceMessageHelper self(Activity activity, Invoice inv) {
    if (_self == null)
      _self = InvoiceMessageHelper.newInstace();

    _self.activity = activity;

    //Setando a operação da nota
    if (inv != null) {
      SuperOperation op = SuperOperation.getOperation(inv.getTipoTransacao());

      _self.init(op, inv);
    }
    return _self;
  }

  public void setAddMessage(String addMessage) {
    this.addMessage = addMessage;
  }

  public void setOperation(SuperOperation operation) {
    this.operation = operation;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  private void init(SuperOperation operation, Invoice invoice) {
    setOperation(operation);
    setInvoice(invoice);
  }

  public InvoiceMessage create(Integer sequencia, Integer linha, String mensagem, String showMessage) {
    InvoiceMessage invoiceMessage = InvoiceMessage.newInstance();

    if (invoice != null) {
      invoiceMessage.setIdNota(invoice.getId());
      invoiceMessage.setNumeroNota(invoice.getNumero());
      invoiceMessage.setSerieNota(invoice.getSerie());
      invoiceMessage.setTipoTransacao(invoice.getTipoTransacao());
      invoiceMessage.setCdCustomer(invoice.getCdCustomer());
      invoiceMessage.setCdRota(GLOBAL.self().getRoute().getCdRota());
      invoiceMessage.setDataEmissao(invoice.getDataEmissao());
    }

    invoiceMessage.setMensagem(mensagem);
    invoiceMessage.setSequencia(sequencia);
    invoiceMessage.setLinha(linha);
    invoiceMessage.setMostrarMsg(showMessage);

    return invoiceMessage;
  }

  public List<InvoiceMessage> createMessages() {
    String msg;

    Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);

    List<InvoiceMessage> invoiceMessages = new ArrayList<>();

    Integer sequencia = 0, linha = -1;

    //Todas as operações menos Vor
    if (operation.isCondicaoPagamento()
        && (!OperationType.VOR.equals(operation.getOperationType()))) {

      List<Tax> taxes = DatabaseApp.self().getDatabase().taxDao().findByCondPagtoEmissao(
          invoice.getCondicaoPagamento(), invoice.getDataEmissao());

      if (!taxes.isEmpty()) {
        Tax tax = taxes.get(0);

        msg = String.format(activity.getString(R.string.cond_pagto), tax.toString());

        invoiceMessages.add(create(++sequencia, 0, msg, ConstantsEnum.NO.getValue()));

        if (invoice.getValorFatura() > 0) {
//          if (GLOBAL.self().getRoute().getDataViagem().equals(UtilHelper.currentDateTime(ConstantsEnum.ddMMyyyy.getValue()))) {

          msg = UtilHelper.formatDateStr(tax.getDtParcela(), ConstantsEnum.ddMMyyyy_barra.getValue());
          invoiceMessages.add(create(++sequencia, 0, msg, ConstantsEnum.NO.getValue()));

          msg = String.format(activity.getString(R.string.num_parc), taxes.size());

          msg += " " + String.format(activity.getString(R.string.entrada),
              UtilHelper.formatDoubleString(invoice.getValorDinheiro() +
                  invoice.getValorCheque(), 2));

          invoiceMessages.add(create(++sequencia, 0, msg, ConstantsEnum.NO.getValue()));
//          }
        }
      }
    }

    //sequencia = 0;

    msg = String.format(activity.getString(R.string.filial_fabrica),
        GLOBAL.self().getRoute().getCdFilialJde()) + " ";

    msg += String.format(activity.getString(R.string.cod_doc),
        operation.getCodigoDocumento(customer)) + " ";

    msg += String.format(activity.getString(R.string.veiculo_rota_viagem),
        GLOBAL.self().getRoute().getNumVeiculo(),
        GLOBAL.self().getRoute().getCdRota(), GLOBAL.self().getRoute().getNumeroViagem());

    invoiceMessages.add(create(++sequencia, 0, msg, ConstantsEnum.NO.getValue()));

    for (String codigoMensagem : operation.getCodigoMensagens()) {

      //Para cada novo codigoMensagem a linha é zerada
      linha = -1;

      Long cdCustomer = null;

      if (ConstantsEnum.K.getValue().equalsIgnoreCase(codigoMensagem)
          || ConstantsEnum.V.getValue().equalsIgnoreCase(codigoMensagem))
        cdCustomer = invoice.getCdCustomer();

      List<Message> mensagens = messageDao.find(codigoMensagem, cdCustomer);

      if (!mensagens.isEmpty())
        sequencia++;

      for (Message message : mensagens) {
        if (!ConstantsEnum.Z.getValue().equalsIgnoreCase(codigoMensagem))
          msg = message.getMensagem();

        //Mensagens e Vnd e FUT
        if (OperationType.VND.equals(operation.getOperationType())
            || OperationType.FUT.equals(operation.getOperationType())) {

          //Message Z somente para Venda e Futura Entrega e Clientes do PR
          if (ConstantsEnum.Z.getValue().equalsIgnoreCase(codigoMensagem)) {
            msg = message.getMensagem();

            if (UfType.PR.getValue().equalsIgnoreCase(GLOBAL.self().getRoute().getUf())
                && ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlReducaoIcms())) {

              if (msg.substring(0, 2).equalsIgnoreCase(GLOBAL.self().getRoute().getUf()))
                msg = message.getMensagem().substring(2);

              Double icms = UtilHelper.formatDouble(invoice.getValorLiquido() * invoice.getAliquotaIcms() / 100 - invoice.getValorIcms(),
                  2);

              msg = msg.replace("&", icms.toString());
            } else
              continue;
          }
        }

        //Mensagens de Vor
        if (OperationType.VOR.equals(operation.getOperationType())) {

          if (msg.substring(0, 2).equalsIgnoreCase(GLOBAL.self().getRoute().getUf())) {
            msg = message.getMensagem().substring(2);

            //Buscando a cia fiscal do cliente da nota Vor
            Customer customerCiaFiscal = customerDao.findById(customer.getCdCiaFiscal());

            msg = msg.replace("&1", invoice.getNumeroNotaVOR().toString().substring(0,
                invoice.getNumeroNotaVOR().toString().length() - 1))
                .replace("&2", invoice.getSerieNotaVOR().toString())
                .replace("&3", UtilHelper.formatDateStr(invoice.getDataEmissao(),
                    ConstantsEnum.ddMMyy_barra.getValue()))
                .replace("&4", customerCiaFiscal.getNome())
                .replace("&5", customerCiaFiscal.getEndereco())
                .replace("&6", customerCiaFiscal.getCidade())
                .replace("&7", customerCiaFiscal.getUf())
                .replace("&8", UtilHelper.formataCNPJ(customerCiaFiscal.getCnpj()))
                .replace("&9", customerCiaFiscal.getInscEstadual());
          }
        }

        if (OperationType.RFH.equals(operation.getOperationType())) {
          if (ConstantsEnum.L.getValue().equalsIgnoreCase(codigoMensagem)) {
            msg = message.getMensagem();

            if (msg.length() > 2 && msg.substring(0, 2).equalsIgnoreCase(GLOBAL.self().getRoute().getUf())) {

              msg = message.getMensagem().substring(2);
            }
          }
        }

        invoiceMessages.add(create(sequencia, ++linha, msg, ConstantsEnum.NO.getValue()));
      }
    }//Mensagens pré configuradas nas operações (Fim)

    InvoiceItem invoiceItem = invoice.getItens().get(0);
    ItemDao dao = DatabaseApp.self().getDatabase().itemDao();
    Item item = dao.find(invoiceItem.getCdItem(), invoiceItem.getCapacidade());

    if (Integer.valueOf(ConstantsEnum._1.getValue()).equals(item.getIndRequerFator())) {
      linha = -1;
      msg = String.format(activity.getString(R.string.poder_calorifico), item.getFatorConversao());
      msg += String.format(activity.getString(R.string.fator_correcao), item.getFatorPcs());

      invoiceMessages.add(create(++sequencia, ++linha, msg, ConstantsEnum.NO.getValue()));
      linha = -1;
    }

    //Message de redução de ICMS para clientes orgão público
    if (operation.isImprimeIcmsRodape()
        && CustomerType.ORGAO_PUBLICO.getValue().equals(customer.getDescontoIcmsOrgaoPublico())
        && TaxingType.TRIBUTADO.getValue().equals(customer.getSituacaoTributariaIcms())) {

      Double valor = invoice.getValorTotal() + invoice.getValorDescontoIcms();
      msg = String.format(activity.getString(R.string.valor_operacao),
          UtilHelper.formatDoubleString(valor, 2));

      msg += " " + String.format(activity.getString(R.string.icms_rodape),
          UtilHelper.formatDoubleString(invoice.getValorDescontoIcms(), 2));

      invoiceMessages.add(create(++sequencia, ++linha, msg, ConstantsEnum.NO.getValue()));
      linha = -1;

      //Buscando mensagem O
      List<Message> messages = messageDao.find(ConstantsEnum.O.getValue(), null);

      if (!messages.isEmpty()) {
        Message message = messages.get(0);
        msg = message.getMensagem();
        invoiceMessages.add(create(++sequencia, ++linha, msg, ConstantsEnum.NO.getValue()));
//        linha = -1;
      }
    }

    //Colocando a nota de futura engtrega na mensagem
    if (!invoice.getNumeroFutEntrega().isEmpty()) {
      linha = -1;
      msg = invoice.getNumeroFutEntrega();
      invoiceMessages.add(create(++sequencia, ++linha, msg, ConstantsEnum.NO.getValue()));
    }

    if (GLOBAL.self().getCustomerService() != null) {
      linha = -1;

      msg = String.format(activity.getString(R.string.customer_service_message),
          GLOBAL.self().getCustomerService().getCdCustomer(), GLOBAL.self().getCustomerService().getNome(),
          GLOBAL.self().getCustomerService().getEndereco(),
          GLOBAL.self().getCustomerService().getBairro(),
          GLOBAL.self().getCustomerService().getCnpj(),
          GLOBAL.self().getCustomerService().getInscEstadual());

      invoiceMessages.add(create(++sequencia, ++linha, msg, ConstantsEnum.NO.getValue()));
    }

//    sequencia++;
    linha = -1;
    Integer value = 1;
    //Colocando a cilindro PP na mensagem
    StringBuilder sb = new StringBuilder();
    for (InvoiceItem i : invoice.getItens()) {

      if (!i.getInfCilPP().isEmpty()) {
        sequencia += value;
        value = 0;
        sb.append(i.getInfCilPP());
        msg = "";

        while (sb.toString().trim().length() > 0) {
          msg += sb.toString().substring(0, 15) + " ";
          sb = sb.delete(0, 15);
        }

        msg = String.format(activity.getString(R.string.cilindo_pp), msg);

        invoiceMessages.add(create(sequencia, ++linha, msg, ConstantsEnum.NO.getValue()));
      }
    }

    //Colocando o pedido do cliente na mensagem
//    sequencia++;
    linha = -1;

    if (!invoice.getItens().get(0).getPedidoCustomer().isEmpty()) {
      String curPed = invoice.getItens().get(0).getPedidoCustomer();

      msg = String.format(activity.getString(R.string.observacao_pedido_cliente), curPed);

      for (InvoiceItem i : invoice.getItens()) {
        if (!curPed.equalsIgnoreCase(i.getPedidoCustomer())) {
          msg = String.format(activity.getString(R.string.observacao_pedido_cliente),
              i.getPedidoCustomer());

          msg += String.format(activity.getString(R.string.observacao_item_pedido_cliente),
              i.getCdItem(), i.getItemPedidoCustomer());

          curPed = i.getPedidoCustomer();
        } else
          msg += String.format(activity.getString(R.string.observacao_item_pedido_cliente),
              i.getCdItem(), i.getItemPedidoCustomer());

        invoiceMessages.add(create(++sequencia, ++linha, msg, ConstantsEnum.NO.getValue()));
        msg = "";
      }
    }

    //Colocando a rastreabilidade na mensagem
    String texto;
    String header_atual = "";

    List<Rastreabilidade> rastreabilidades = rastreabDao.findByCustomer(invoice.getCdCustomer());

    if (!rastreabilidades.isEmpty()) {
      sequencia++;
      linha = -1;
    }

    for (Integer idx = 0; idx < rastreabilidades.size(); idx++) {

      Rastreabilidade rastreabilidade = rastreabilidades.get(idx);

      if (Integer.valueOf(0).equals(idx)
          || !header_atual.equalsIgnoreCase(rastreabilidade.getCdItem().toString()
          + rastreabilidade.getNumeroLote()))


        texto = String.format(Locale.getDefault(), "   Item: %d Lote: %s %s",
            rastreabilidade.getCdItem(), rastreabilidade.getNumeroLote(),
            (GLOBAL.self().isLiquido() ? "" : "Cilindro: " + rastreabilidade.getCdCilindro()));

//        String.format(activity.getString(R.string.lote_rastreab_cilindro),
//          rastreabilidade.getCdItem(), rastreabilidade.getNumeroLote(),
//          rastreabilidade.getCdCilindro());
      else
        texto = rastreabilidade.getCdCilindro();

      invoiceMessages.add(create(sequencia, ++linha, texto, ConstantsEnum.NO.getValue()));

      header_atual = rastreabilidade.getCdItem().toString() + rastreabilidade.getNumeroLote();
    }

    if (!addMessage.isEmpty()) {
      sequencia++;
      linha = -1;

      String[] messges = addMessage.split("_");

      for (String s : messges)
        if (!s.isEmpty())
          invoiceMessages.add(create(sequencia, ++linha, "|" + s,
              ConstantsEnum.YES.getValue()));
    }

    //Limpandpo as mesagens depois de usar
    addMessage = "";

    Patient patient = Patient.newInstance();
    patient.setCdPaciente(invoice.getCdCustomer());
    patient = patient.isPaciente();

    ++sequencia;

    if (patient != null) {

      invoiceMessages.add(create(sequencia, ++linha, "  Cod. Jde do Paciente: " +
          patient.getCdJDEOperadora().toString(), ConstantsEnum.NO.getValue()));

      invoiceMessages.add(create(sequencia, ++linha, "  " + patient.getNome(),
          ConstantsEnum.NO.getValue()));

      invoiceMessages.add(create(sequencia, ++linha,
          String.format("  %s %s", patient.getEndereco(), patient.getBairro()), ConstantsEnum.NO.getValue()));

      invoiceMessages.add(create(sequencia, ++linha,
          String.format("  %s %s-%s", patient.getCidade(), patient.getUF(), patient.getCEP()), ConstantsEnum.NO.getValue()));
    }

    return invoiceMessages;
  }

}
