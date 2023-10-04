package br.com.whitemartins.obc.print;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.MovimentoIntegracaoType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.StatusCecType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.Patient;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class ReportInvoices extends BaseReports {

  @Override
  public String toString() {
    return "Relatório de Notas Fiscais Emitidas";
  }

  @Override
  protected BasePrinter getPriter() {
    final BasePrinter printer = new BasePrinter() {

      @Override
      protected void doHeader() {
        this._printDefs._width = 831;
        this.titulo = "RELATÓRIO DE NOTAS FISCAIS EMITIDAS " + parcial;
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
        int posValores = 195;
        Long cdCustomer = 0L;
        String linha;

        int col = 38;
        int tam = 30;

        List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().findInvoiceReport(
          UtilHelper.padLeft(GLOBAL.self().getRoute().getNumeroViagem().toString(), '0',
            6));

        for (Invoice invoice : invoices) {

          invoice.getItens().clear();
          invoice.setItens(DatabaseApp.self().getDatabase().invoiceItemDao()
            .findByIdNota(invoice.getId()));

          if (!cdCustomer.equals(invoice.getCdCustomer())) {
            Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);

            Patient patient = Patient.newInstance();
            patient.setCdPaciente(invoice.getCdCustomer());
            patient = patient.isPaciente();

            if (patient != null) {
              addLine(String.format(Locale.getDefault(), "T 7 3 9 %d Cliente: %d - %s",
                posValores, patient.getCdPaciente(), patient.getNome()));

              cdCustomer = patient.getCdPaciente();
            } else {
              addLine(String.format(Locale.getDefault(), "T 7 3 9 %d Cliente: %d - %s",
                posValores, customer.getCdCustomer(), customer.getNome()));

              cdCustomer = customer.getCdCustomer();
            }

            posValores += tam - 10;
          }

          linha = String.format(Locale.getDefault(),
            "T 7 0 62 %d NFe: %d Série: %d   Data Emissão: %s",
            posValores += tam, invoice.getNumero(), invoice.getSerie(),
            UtilHelper.formatDateStr(invoice.getDataEmissao(),
              ConstantsEnum.ddMMyyyy_barra.getValue()));

          addLine(linha);

          linha = String.format(Locale.getDefault(), "T 7 0 62 %d %s",
            posValores += tam,
            "Total NFe R$: " + UtilHelper.formatDoubleString(invoice.getValorTotal(), 2));

          addLine(linha);
          //Rodolfo Pontar HC fase 1

          linha = String.format(Locale.getDefault(), "T 7 0 62 %d %s %s",
            posValores += tam,
            UtilHelper.padRight("Operação: " + invoice.getNomeOperacao(), ' ', col),
            GLOBAL.self().isLiquido() ? "Volume: " +
              UtilHelper.formatDoubleString(invoice.getVolumeCapacidade(), 2) : ""
          );

          addLine(linha);

          //Rodolfo Pontar HC fase 1
          if (ConstantsEnum.YES.getValue().equalsIgnoreCase(invoice.getFlPaciente())) {
            Patient patient = DatabaseApp.self().getDatabase().patientDao()
              .findById(invoice.getCdCustomer());

            if (patient != null)

              linha = String.format(Locale.getDefault(), "T 7 0 62 %d Paciente: %s",
                posValores += tam, patient.getNome());
            else {
              Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);
              linha = String.format(Locale.getDefault(), "T 7 0 62 %d Paciente: %s",
                posValores += tam, customer.getNome());
            }


            addLine(linha);
          }
          //Rodolfo Pontar HC fase 1
          String pagamento = "";

          if (invoice.getValorFatura() > 0)
            pagamento += SuperOperation.getOperation(invoice.getTipoTransacao())
              .isFinalizaPedido() ? "A Prazo, " : "----";
          if (invoice.getValorCheque() > 0)
            pagamento += "Cheque - " + invoice.getNumeroCheque() + ", ";
          if (invoice.getValorDinheiro() > 0)
            pagamento += "Dinheiro, ";
          if (invoice.getValorCredito() > 0)
            pagamento += "Credito, ";
          if (invoice.getValorDebito() > 0)
            pagamento += "Debito, ";

          pagamento = pagamento.trim().substring(0, pagamento.trim().length() - 1);

          if (pagamento.isEmpty())
            pagamento = "----";

          linha = String.format(Locale.getDefault(), "T 7 0 62 %d Pagamento: %s",
            posValores += tam, pagamento);

          addLine(linha);

          linha = String.format(Locale.getDefault(), "T 7 0 62 %d Alteração Preço: %s",
            posValores += tam, invoice.getItens().get(0).getFlPrecoAlterado());

          addLine(linha);

          String tipoStatus = "";

          if ((invoice.getDsMotivo() != null && !invoice.getDsMotivo().isEmpty())
            || invoice.getTipoMovimentoIntegracao().equals(MovimentoIntegracaoType.EVENTO_CANCELAMENTO.getValue())
            || invoice.getStatus().equals(StatusNFeType.PENDENTE_CANCELAMENTO.getValue()))
            tipoStatus = "Cancelamento";

//          if (Travel.emitirNFe) {
          linha = String.format(Locale.getDefault(), "T 7 0 62 %d %s",
            posValores += tam,
            String.format(Locale.getDefault(), "Status %s: %s", tipoStatus,
              StatusNFeType.getNameByValue(invoice.getStatus())));

          addLine(linha);
          StatusCecType statusCecType = StatusCecType.getByValue(UtilHelper
            .convertToIntegerDef(invoice.getStatusNfeImp().substring(0, 1), 1));

          //Rodolfo Pontar HC fase 1
          linha = String.format(Locale.getDefault(), "T 7 0 62 %d Emissão: %s-%s",
            posValores += tam, statusCecType.getName(), //invoice.getStatusNfeImp().substring(1),
            invoice.getNomeStatusImpressaoCec().substring(1)
          );
          //Rodolfo Pontar HC fase 1

          addLine(linha);

          if (SuperOperation.getOperation(invoice.getTipoTransacao()).getOperationType()
            .equals(OperationType.RPS)) {

            Customer customerService = DatabaseApp.self().getDatabase().customerDao()
              .findById(invoice.getCdCustomerService());

            linha = String.format(Locale.getDefault(), "T 7 0 62 %d Cliente Entrega: ",
              posValores += tam);
            addLine(linha);

            linha = String.format(Locale.getDefault(), "T 7 0 62 %d %d-%s ", posValores += tam,
              customerService.getCdCustomer(), customerService.getNome());
            addLine(linha);

            linha = String.format(Locale.getDefault(), "T 7 0 62 %d End: %s ",
              posValores += tam, customerService.getEndereco());
            addLine(linha);

            linha = String.format(Locale.getDefault(), "T 7 0 62 %d Bairro: %s ",
              posValores += tam, customerService.getBairro());
            addLine(linha);

            linha = String.format(Locale.getDefault(), "T 7 0 62 %d CNPJ: %s ",
              posValores += tam, customerService.getCnpj());
            addLine(linha);

            linha = String.format(Locale.getDefault(), "T 7 0 62 %d IE: %s ",
              posValores += tam, customerService.getInscEstadual());
            addLine(linha);
          }
//          }

          addLine(String.format(Locale.getDefault(), "L 10 %d 805 %d 1",
            posValores += tam,
            posValores)
          );
        }
        _printDefs._height = posValores + tam;
      }
    };

    return printer;
  }
}
