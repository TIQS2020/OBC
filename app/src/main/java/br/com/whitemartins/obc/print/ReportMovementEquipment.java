package br.com.whitemartins.obc.print;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.dao.GenericDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class ReportMovementEquipment extends BaseReports {

  @Override
  public String toString() {
    return "Relatório de Conferência de Equipamento";
  }

  @Override
  protected BasePrinter getPriter() {

    final BasePrinter printer = new BasePrinter() {

      @Override
      protected void doHeader() {
        this._printDefs._width = 831;
        this.titulo = "RELATÓRIO DE CONFERÊNCIA DE EQUIPAMENTO " + parcial;
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

        int posValores = 220, tam = 25, coluna = 13;
        double apl = 0, rcl = 0, saldo, manifestado;

        String linha = "";

        //Colocar os itens reoclhidos
        List<Integer> tipoItem = TypeItemType.build(TypeItemType.EQUIPAMENTO,
          TypeItemType.MISCELANIA);

        List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao()
          .findMovementEquipment(tipoItem, GLOBAL.self().getRoute().getNumeroViagem());

        for (Saldo saldo1 : saldos) {
          Item item = DatabaseApp.self().getDatabase().itemDao().find(saldo1.getCdItem());

          doText(String.format(Locale.getDefault(), "Item: %d - %s", saldo1.getCdItem(),
            item.getDescricaoProduto()), 0, posValores, posValores, true,
            false);

          addLine(String.format(Locale.getDefault(), "L 7 %d 800 %d 1",
            posValores += tam, posValores));

          manifestado = item.getQtdCilindroCheios();

          GenericDao genericDao = new GenericDao();
          InvoiceItem invoiceItem = genericDao.sumQtdInvoiceItem(saldo1.getCdItem(),
            OperationType.APLHC.getValue());

          //Aplicação
          if (invoiceItem != null)
            apl = invoiceItem.getQtdItem();

          //Recolhimento
          invoiceItem = genericDao.sumQtdInvoiceItem(saldo1.getCdItem(),
            OperationType.RCLHC.getValue());

          if (invoiceItem != null)
            rcl = invoiceItem.getQtdItem();

          Invoice invoice = DatabaseApp.self().getDatabase().invoiceDao()
            .findById(invoiceItem.getIdNota());

          if (invoice != null && invoice.isCanceled())
            continue;

          //Gerando saldo
          saldo = manifestado - apl + rcl;

          linha = String.format(Locale.getDefault(), "T 7 0 7 %d%s%s%s%s",
            posValores += tam,
            UtilHelper.padLeft("Manifestado", ' ', coluna),
            UtilHelper.padLeft("Aplicação", ' ', coluna),
            UtilHelper.padLeft("Recolhimento", ' ', coluna),
            UtilHelper.padLeft("Saldo", ' ', coluna)
          );

          addLine(linha);

          addLine(String.format(Locale.getDefault(), "L 007 %d 155 %d 1", posValores += tam,
            posValores)); //Manifestado
          addLine(String.format(Locale.getDefault(), "L 180 %d 310 %d 1", posValores,
            posValores)); //Aplicação
          addLine(String.format(Locale.getDefault(), "L 340 %d 465 %d 1", posValores,
            posValores)); //Recolhimento
          addLine(String.format(Locale.getDefault(), "L 500 %d 623 %d 1", posValores,
            posValores)); //Saldo

          linha = String.format(Locale.getDefault(), "T 7 0 0 %d  %s%s%s%s",
            posValores += tam - 15,
            UtilHelper.padLeft(UtilHelper.formatDoubleString(manifestado, 0), ' ',
              coluna - 1),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(apl, 0), ' ', coluna),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(rcl, 0), ' ', coluna),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo, 0), ' ', coluna)
          );

          addLine(linha);

          posValores += (tam * 2);
        }

        _printDefs._height = posValores + 100;
      }
    };

    return printer;
  }

//  public void print() throws ConnectionException, ZebraPrinterLanguageUnknownException {
//
//
//    try {
//      printer.print();
//    } catch (ConnectionException | ZebraPrinterLanguageUnknownException e) {
//      e.printStackTrace();
//      throw e;
//    }
//  }
}
