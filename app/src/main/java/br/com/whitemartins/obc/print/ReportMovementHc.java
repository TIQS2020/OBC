package br.com.whitemartins.obc.print;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.LotePatrimonio;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class ReportMovementHc extends BaseReports {

  @Override
  public String toString() {
    return "Relatório de Movimentação Homecare";
  }

  @Override
  protected BasePrinter getPriter() {
    final BasePrinter printer = new BasePrinter() {

      @Override
      protected void doHeader() {
        this._printDefs._width = 831;
        this.titulo = "RELATÓRIO DE MOVIMENTAÇÃO HOMECARE " + parcial;
        this.filial = GLOBAL.self().getStaticTable().getCdFilial();
        this.numViagem = GLOBAL.self().getRoute().getNumeroViagem().toString();
        this.numVeiculo = GLOBAL.self().getStaticTable().getCdVeiculo();
        this.dtViagem =
          UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
            ConstantsEnum.ddMMyyyy_barra.getValue());

        super.doHeader();
      }

      @Override
      protected void doBody() {

        int posValores = 200;
        int tam = 25;
        int variacao = 0;
        String linha = "";
        Long itemAtual = 0L;
        Long clienteAtual = 0L;
        Long notaAtual = 0L;
        //String conteudo = "";

        List<InvoiceItem> invoiceItems = DatabaseApp.self().getDatabase().invoiceItemDao()
          .find(TypeItemType.build(TypeItemType.EQUIPAMENTO, TypeItemType.MISCELANIA));

        for (InvoiceItem invoiceItem : invoiceItems) {
          Invoice invoice = DatabaseApp.self().getDatabase().invoiceDao()
            .findById(invoiceItem.getIdNota());

//          Customer customer = DatabaseApp.self().getDatabase().customerDao()
//            .findById(invoice.getCdCustomer());

          Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);

          if (invoice != null && invoice.isCanceled())
            continue;

          SuperOperation OPERACAO = SuperOperation.getOperation(invoice.getTipoTransacao());

          if (!itemAtual.equals(invoiceItem.getCdItem())) {
            doText(String.format(Locale.getDefault(), "Item: %d - %s", invoiceItem.getCdItem(),
              invoiceItem.getNomeItem()), 0, posValores += variacao, 0,
              true, false);

            addLine(String.format(Locale.getDefault(), "L 7 %d 803 %d 1",
              posValores += tam, posValores));

            //Guardando o item para imprimir no cabecalho
            itemAtual = invoiceItem.getCdItem();

            variacao = 0;

            //Forçando a impressão da nota quando mudar o item
            notaAtual = 0L;
            //Forçando a impressão da cliente quando mudar o item
            clienteAtual = 0L;
          }

          if (!clienteAtual.equals(customer.getCdCustomer())) {

            int v = clienteAtual.equals(0L) ? 0 : tam;

            addLine(String.format(Locale.getDefault(), "T 7 0 9 %d Cliente: %d - %s",
              posValores += 15 + v, customer.getCdCustomer(), customer.getNome()));

            clienteAtual = customer.getCdCustomer();
            posValores += 10;
          }

          if (!notaAtual.equals(invoiceItem.getIdNota())) {
            String at = "";

            if (ConstantsEnum.YES.getValue().equalsIgnoreCase(invoiceItem.getFlAssistenciaTecnica()))
              at = "- AT";

            addLine(String.format(Locale.getDefault(),
              "T 7 0 9 %d  NF %s:%s Série:%s Emissão:%s Qtd.:%s %s",
              posValores += tam,
              UtilHelper.padRight(OPERACAO.getOperationType().getName(), ' ', 12),
              UtilHelper.padLeft(invoice.getNumero().toString(), ' ', 6),
              UtilHelper.padLeft(invoice.getSerie().toString(), ' ', 3),
              UtilHelper.formatDateStr(invoice.getDataEmissao(), ConstantsEnum.ddMMyy_barra.getValue()),
              UtilHelper.padLeft(invoiceItem.getQtdItem().toString(), '0', 2),
              at
            ));

            //Guardando a nota para imprimir no cabecalho
            notaAtual = invoiceItem.getIdNota();

            //List<object> ativos = new List<object>();
            //obc_item_ativo_hcDAO obc_item_ativo_hcDAO = new obc_item_ativo_hcDAO(instancia._gerenciadorConexao);

            List<LotePatrimonio> lotePatrimonios = DatabaseApp.self().getDatabase().lotePatrimonioDao()
              .find(invoiceItem.getIdNota(), invoiceItem.getCdItem(), invoiceItem.getCapacidade());

            for (LotePatrimonio lotePatrimonio : lotePatrimonios) {
              addLine(String.format(Locale.getDefault(),
                "T 7 0 9 %d        Patrimônio: %s", posValores += tam,
                lotePatrimonio.getNumeroLote()));
            }

//            if (invoiceItems.size() > 0)
//              posValores += 15;
          }

          variacao = (tam * 2);
        }

//        Definindo o tamanho da impressão
        _printDefs._height = posValores += 100;
      }
    };


    return printer;
  }

//  public void print() throws ConnectionException, ZebraPrinterLanguageUnknownException {
//    try {
//      printer.print();
//    } catch (ConnectionException | ZebraPrinterLanguageUnknownException e) {
//      e.printStackTrace();
//      throw e;
//    }
//  }
}
