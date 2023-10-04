package br.com.whitemartins.obc.print;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.PaymentModeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Code;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.Payment;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

public class ReportPaymentCard extends BaseReports {

  @Override
  public String toString() {
    return "Pagamentos Envolvendo Cartão de Crédito/Débito";
  }


  @Override
  protected BasePrinter getPriter() {

    final BasePrinter printer = new BasePrinter() {

      @Override
      protected void doHeader() {
        this._printDefs._width = 831;
        this.titulo = "PAGAMENTOS ENVOLVENDO CARTÃO DE CRÉDITO/DÉBITO " + parcial;
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
        int tam = 20;
        int variacao = 0;
        String linha = "";

        int i = 0;

        List<Code> bandeiras = DatabaseApp.self().getDatabase().codeDao()
          .find(ConstantsEnum.Y.getValue());

        List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().getAll();

        for (Invoice invoice : invoices) {
          List<Payment> payments = DatabaseApp.self().getDatabase().paymentDao()
            .find(invoice.getId());

          if (payments.isEmpty())
            continue;

          if (i > 0)
            addLine(String.format(Locale.getDefault(), "L 10 %d 805 %d 1",
              posValores += variacao,
              posValores)
            );

          i++;

          SuperOperation OPERACAO = SuperOperation.getOperation(invoice.getTipoTransacao());

          linha = String.format(Locale.getDefault(), "%s %s %s %s",
            "NFe: " + invoice.getNumero(), "Série: " + invoice.getSerie(),
            "Operação: " + OPERACAO.getOperationType().getName(),
            "Valor: " + UtilHelper.formatDoubleString(invoice.getValorTotal(), 2)
          );

          doText(linha, 0, posValores += tam, 0, true, false);

          variacao = 0;
          doText("TIPO DE PAGAMENTO", 0, posValores += 40, 0, true,
            false);

          addLine(String.format(Locale.getDefault(), "L 7 %d 800 %d 1",
            posValores += (tam + 10), posValores));

          if (invoice.getValorDinheiro() > 0) {
            doText("Dinheiro (à vista)", 0, posValores += tam, posValores += tam, false,
              false);

            addLine(String.format(Locale.getDefault(), "L 38 %d 812 %d 1",
              posValores += (tam + 10), posValores));

            linha = String.format(Locale.getDefault(),
              "T 7 0 50 %d Valor Pago R$: %s Valor Troco R$: %s",
              posValores += tam,
              UtilHelper.formatDoubleString(invoice.getValorDinheiro(), 2),
              UtilHelper.formatDoubleString(invoice.getValorTroco(), 2));

            addLine(linha);
            posValores += tam;
          }

          if (invoice.getValorCheque() > 0) {
            doText("Cheque (à vista)", 0, posValores += tam, posValores += tam, false,
              false);

            addLine(String.format(Locale.getDefault(), "L 38 %d 812 %d 1",
              posValores += (tam + 10), posValores));

            linha = String.format(Locale.getDefault(), "T 7 0 50 %d Valor Pago R$: %s",
              posValores += tam,
              UtilHelper.formatDoubleString(invoice.getValorCheque(), 2));

            addLine(linha);

            posValores += tam;
          }

          if (invoice.getValorFatura() > 0) {
            doText("Faturado", 0, posValores += tam, posValores += tam, false,
              false);

            addLine(String.format(Locale.getDefault(), "L 38 %d 812 %d 1",
              posValores += (tam + 10), posValores));

            linha = String.format(Locale.getDefault(), "T 7 0 50 %d Valor Pago R$: %s",
              posValores += tam, UtilHelper.formatDoubleString(invoice.getValorFatura(), 2));

            addLine(linha);
            posValores += tam;
          }

          for (Payment payment : payments) {

            String deb_cred;
            if (PaymentModeType.DEBITO.getValue().equals(payment.getModalidade()))
              deb_cred = "Cartão de Débito";
            else
              deb_cred = "Cartão de Crédito";

            doText(deb_cred, 0, posValores += tam, posValores += tam, false, false);

            addLine(String.format(Locale.getDefault(), "L 38 %d 812 %d 1",
              posValores += tam, posValores));

            linha = String.format(Locale.getDefault(),
              "T 7 0 50 %d Credenciadora: %s Bandeira: %s", posValores += tam,
              UtilHelper.padRight(payment.getCredenciadora(), ' ', 20),
              UtilHelper.padRight(payment.getNomeBandeira(), ' ', 20));
            addLine(linha);

            linha = String.format(Locale.getDefault(),
              "T 7 0 50 %d Valor Pago R$: %s Autorização: %s", posValores += tam,
              UtilHelper.padRight(UtilHelper.formatDoubleString(payment.getValor(), 2),
                ' ', 20),
              UtilHelper.padRight(payment.getNumeroAutorizacao(), ' ', 20));
            addLine(linha);

            if (payments.size() > 0)
              posValores += 15;

            variacao = (tam * 2);
          }
        }

        //Definindo o tamanho da impressão
        _printDefs._height = posValores + 100;
      }
    };

    return printer;
  }

//  public void print() throws ConnectionException, ZebraPrinterLanguageUnknownException {
//
//
//    try {
//      while (printer.isConected())
//        Sleeper.sleep(1000);
//      printer.print();
//    } catch (ConnectionException | ZebraPrinterLanguageUnknownException e) {
//      e.printStackTrace();
//      throw e;
//    }
//  }
}
