package br.com.whitemartins.obc.print;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.InvoiceMessageDao;
import br.com.whitemartins.obc.dao.RastreabilidadeDao;
import br.com.whitemartins.obc.enumeration.CecType;
import br.com.whitemartins.obc.enumeration.CnpjCpfTypeEnum;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.InvoiceMessage;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.Rastreabilidade;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

public class Rec extends Cec {

  @Override
  protected BasePrinter getPrint() {
    final BasePrinter printer = new BasePrinter() {
      private Integer posY = 20;
      private Integer posYPrinter = 0;

      @Override
      protected void doHeader() {
        this._printDefs._height = 1200;
        this._printDefs._width = 831;
        this.titulo = CecType.REC_SEM.getFullname().toUpperCase();
        this.filial = GLOBAL.self().getStaticTable().getCdFilial();
        this.numViagem = invoice.getNumeroViagem();
        this.numVeiculo = GLOBAL.self().getStaticTable().getCdVeiculo();
        this.dtViagem =
          UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
            ConstantsEnum.ddMMyyyy_barra.getValue());
      }

      @Override
      protected void doBody() {
        try {
          List<Rastreabilidade> rastreabs = new ArrayList<>();

          List<InvoiceItem> items = invoice.getItens();

          SuperOperation OPERACAO = SuperOperation.getOperation(invoice.getTipoTransacao());

          if (OPERACAO.isRastreavel()) {
            RastreabilidadeDao rastDao = DatabaseApp.self().getDatabase().rastreabilidadeDao();
            rastreabs = rastDao.find(invoice.getId(), UtilHelper.convertToLongDef(
              invoice.getNumeroViagem(), 0), invoice.getCdCustomer());
          }

          Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);

          //Rodolfo Pontar Novo Faturamento
          if ((invoice.getCdCustomerService() != null && invoice.getCdCustomerService() > 0)
            && OPERACAO.getOperationType().getValue().equals(OperationType.RPS.getValue()))
            customer = DatabaseApp.self().getDatabase().customerDao().findById(
              invoice.getCdCustomerService());
          //Rodolfo Pontar Novo Faturamento

          int total = items.size() + (rastreabs.size() / 2);
          _printDefs._height += (total * 10);

          doText(this.titulo, 1, posYPrinter += 30, posY, true, true);

          doText(GLOBAL.self().getRoute().getRazaoSocial(), 1, posYPrinter += 40, posY += 20,
            true, true);

          //----------------------------------------------------------------------------
          doText("DADOS DO RECIBO", 0, posYPrinter += 80, posY += 40, true,
            false);
          doLine(posY += 5, posYPrinter += 20, 823, 1);

          String recibo = String.format(Locale.getDefault(), "Número: %s%d%d",
            invoice.getCdCustomer(), invoice.getNumero(), invoice.getSerie());
          doText(recibo, 0, posYPrinter += 5, posY += 10, false, false);

          String nm_operacao = OPERACAO.getOperationType().getName();
          doText("Operação: " + nm_operacao, 0, posYPrinter += 20, posY += 10, false,
            false);

          String info = String.format(Locale.getDefault(), "Data de Emissão: %s ",
            UtilHelper.formatDateStr(invoice.getDataMovimento(),
              ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue()));

          doText(info, 0, posYPrinter += 20, posY += 10, false, false);
          //----------------------------------------------------------------------------
          doText("DADOS DO EMITENTE", 0, posYPrinter += 50, posY += 30, true,
            false);
          doLine(posY += 5, posYPrinter += 20, 823, 1);

          doText("Nome: " + GLOBAL.self().getRoute().getNomeFilial(), 0, posYPrinter += 5,
            (posY += 10), false, false);

          doText(String.format(Locale.getDefault(), "CNPJ: %s   I.E.: %s   UF: %s",
            UtilHelper.formataCNPJ(GLOBAL.self().getRoute().getCnpj()),
            UtilHelper.formataInscEst(GLOBAL.self().getRoute().getInscEstadual()),
            GLOBAL.self().getRoute().getUf()), 0, posYPrinter += 20, posY += 10,
            false,
            false);
          //----------------------------------------------------------------------------
          doText("DADOS DOS DESTINATÁRIO", 0, posYPrinter += 50, posY += 30, true,
            false);

          doLine(posY += 5, posYPrinter += 20, 823, 1);

          doText("Nome: " + customer.getNome(), 0, posYPrinter += 5, posY += 10, false,
            false);

          if (customer.getTipoCnpjCpf().equalsIgnoreCase(CnpjCpfTypeEnum.CNPJ.getValue()))
            doText(String.format(Locale.getDefault(), "CNPJ: %s   I.E.: %s   UF: %s",
              UtilHelper.formataCNPJ(customer.getCnpj()),
              UtilHelper.formataInscEst(customer.getInscEstadual()), customer.getUf()), 0,
              posYPrinter += 20, (posY += 10), false, false);
          else
            doText(String.format(Locale.getDefault(), "CPF: %s   I.E.: %s   UF: %s",
              UtilHelper.formataCPF(customer.getCnpj()),
              UtilHelper.formataInscEst(customer.getInscEstadual()), customer.getUf()), 0,
              posYPrinter += 20, (posY += 10), false, false);

          //----------------------------------------------------------------------------
          doText("DADOS DOS PRODUTOS", 0, posYPrinter += 50, posY += 30,
            true, false);

          doLine(posY += 5, posYPrinter += 20, 823, 1);

          String format = "%s%s%s";

          String header = String.format(Locale.getDefault(), format,
            UtilHelper.padRight(context.get().getString(R.string.descricao), ' ', 25),
            UtilHelper.padRight(context.get().getString(R.string.un_medida), ' ', 5),
            UtilHelper.padLeft(context.get().getString(R.string.qtd), ' ', 11));

          doText(header, 0, posYPrinter += 5, posY += 10, false, false);
          doLine(posY += 5, posYPrinter += 20, 823, 1);

          for (InvoiceItem invoiceItem : items) {
            int len = invoiceItem.getNomeItem().length();

            if (len > 22)
              len = 22;

            Item item = DatabaseApp.self().getDatabase().itemDao()
              .find(invoiceItem.getCdItem(), invoiceItem.getCapacidade());

            String linhaItem =
              UtilHelper.padRight(item.getDescricaoProduto().substring(0, len), ' ', 25)
                + UtilHelper.padRight(item.getUnidadeMedida().trim(), ' ', 5)
                + UtilHelper.padLeft(String.format(Locale.getDefault(), "%s",
                UtilHelper.formatDoubleString(invoiceItem.getQuantidadeCilindroVendida(),
                  2)), ' ', 11);

            doText(linhaItem, 0, posYPrinter += 5, posY += 15, false, false);
            doLine(posY += 5, posYPrinter += 20, 823, 1);

            posY += 30;
          }

          doText("DADOS DOS ADICIONAIS", 0, posYPrinter += 50, (posY += 20),
            true, false);

          doLine(posY += 5, posYPrinter += 20, 823, 1);

          String texto = String.format("  Filial: %s Viagem: %s Veículo: %s",
            GLOBAL.self().getRoute().getCdFilialJde(),
            GLOBAL.self().getRoute().getNumeroViagem(),
            GLOBAL.self().getRoute().getNumVeiculo());

          doText(texto, 0, posYPrinter += 20, posY += 20, false, false);

          StringBuilder aux_str = new StringBuilder();

          for (int idx = 1; idx <= rastreabs.size(); idx++) {
            Rastreabilidade rastreabilidade = rastreabs.get(idx - 1);

            aux_str.append(rastreabilidade.getNumeroLote()).append(", ");

            if (idx > 0 && idx % 2 == 0) {
              doLine(posY += 5, posYPrinter += 20, 823, 1);
              aux_str = new StringBuilder();
            } else {
              if (idx >= rastreabs.size())
                doText("  Lote: " + aux_str.substring(0,
                  aux_str.toString().trim().length() - 1), 0, posYPrinter += 40, (posY += 50),
                  false, false);
            }
          }

//          String currPed = "";
//
//          for (InvoiceItem item : items) {
//            if (item.getPedidoCustomer().isEmpty())
//              continue;
//
//            if (!currPed.equalsIgnoreCase(item.getPedidoCustomer())) {
//              doText("  Número do Pedido do Cliente: " + item.getPedidoCustomer(), 0,
//                posYPrinter += 30, posY += 15, false, false);
//
//              currPed = item.getPedidoCustomer();
//            }
//
//            String t = String.format("   Item: %s - Sequencial: %s", item.getCdItem(),
//              item.getItemPedidoCustomer());
//
//            doText(t, 0, posYPrinter += 20, posY += 10, false, false);
//          }

          //Fim
          doLine(posY += 5, posYPrinter += 30, 823, 2);

          doText(String.format("  (Documento sem valor fiscal %s)", reprint ? " - Reimpressão" : ""),
            0, posYPrinter += 50, posY += 20, false, false);

//          if (GLOBAL.self().getRoute().getModeloCec().equalsIgnoreCase(
//            DocTypeCecEnum.CEC.getValue()))
//
//            doText(String.format("  (Documento sem valor fiscal %s)", reprint
//                ? " - Reimpressão"
//                : ""),
//              0, posYPrinter += 20, posY += 20, false, false);
//          else if (reprint)
//            doText((reprint ? "  (Documento sem valor fiscal %s) (Reimpressão)" : ""), 0, posYPrinter += 20, posY += 20,
//              false, false);

          InvoiceMessageDao invoiceMessageDao = DatabaseApp.self().getDatabase().invoiceMessageDao();
          List<InvoiceMessage> mensagens = invoiceMessageDao.find(invoice.getId(), ConstantsEnum.YES.getValue());

          for (InvoiceMessage invoiceMessage : mensagens)
            doText(invoiceMessage.getMensagem(), 0, posYPrinter += 30, posY += 20,
              false, false);

          posY += 20;

          doLine(posY += 5, posYPrinter += 30, 823, 2);

          doText("  Recebemos de " + GLOBAL.self().getRoute().getRazaoSocial() + " unidade ",
            0, posYPrinter += 25, posY += 20, false, false);

          doText("  " + GLOBAL.self().getRoute().getNomeFilial() + ", os produtos constantes",
            0, posYPrinter += 25, posY += 20, false, false);

          doText("  no Recibo indicado acima, para prestação de serviço.",
            0, posYPrinter += 25, posY += 20, false, false);

          doBox(posY += 15, 829, posYPrinter += 30);
          doText("  NOME/RG: " + String.format("%s/%s", invoice.getNomeAssinadorCec(),
            invoice.getRgAssinadorCec()), 0, posYPrinter += 6, posY += 15, false,
            false);

          doSignature(UtilHelper.getSignFileName(invoice), posY += 10);

          _printDefs._height = posYPrinter += 25;
        } catch (Exception e) {
          e.printStackTrace();
          LogHelper.self().error("Rec", e);
        }
      }

      @Override
      protected void doFooter(PrinterConnection printerConnection) throws ConnectionException,
        ZebraPrinterLanguageUnknownException {
        try {
          if (!automatic) {
            if (bitmap != null) {
              ZebraPrinter zebraPrinter = printerConnection.getPrinter();
              if (zebraPrinter != null)
                zebraPrinter.printImage(image, 180, 0, 500, 300, false);
              printerConnection.disconnect();
            }
          }
        } catch (ConnectionException | ZebraPrinterLanguageUnknownException e) {
          throw e;
        }
      }
    };

    return printer;
  }

//  public void print() throws ConnectionException, ZebraPrinterLanguageUnknownException {
//
//    try {
//      ImageHelper.self().createCecImage(2000);
//
//      BasePrinter printer = getPrint();
//
//      printer.setPrintImage(true);
//      printer.setAutomatic(automatic);
//      printer.print(invoice);
//
//    } catch (Exception ex) {
//      ex.printStackTrace();
//      throw ex;
//    }
//  }
}
