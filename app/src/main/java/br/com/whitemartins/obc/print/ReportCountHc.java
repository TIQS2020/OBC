package br.com.whitemartins.obc.print;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class ReportCountHc extends BaseReports {

  @Override
  public String toString() {
    return "Relatório de Contagem Física Homecare";
  }

  @Override
  protected BasePrinter getPriter() {

    final BasePrinter printer = new BasePrinter() {

      @Override
      protected void doHeader() {
        this._printDefs._width = 831;
        this.titulo = "RELATÓRIO DE CONTAGEM FÍSICA HOMECARE " + parcial;
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
        int posValores = 198, tam = 30, col = 16;
        String linha = "";

        List<Integer> tipoItem = new ArrayList<>();
        tipoItem.add(TypeItemType.EQUIPAMENTO.getValue());
        tipoItem.add(TypeItemType.MISCELANIA.getValue());

        List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().saldoObc(null,
          tipoItem, GLOBAL.self().getRoute().getNumeroViagem());

        for (Saldo saldo : saldos) {

          Item item = DatabaseApp.self().getDatabase().itemDao().find(saldo.getCdItem(),
            saldo.getCapacidade());

          addLine(String.format(Locale.getDefault(), "T 7 0 9 %d   Item: %d - %s",
            posValores, item.getCdItem(), item.getDescricaoProduto()));

          addLine(String.format(Locale.getDefault(), "T 7 0 9 %d   Total Manifestado: %s",
            posValores += tam, UtilHelper.formatDoubleString(saldo.getQtdCarregadaCheios(),
              0)));

          addLine(String.format(Locale.getDefault(), "T 7 0 314 %d %s %s",
            posValores += tam,
            UtilHelper.padLeft("Aplicados", ' ', col),
            UtilHelper.padLeft("Recolhidos", ' ', col)
            )
          );

          addLine(String.format(Locale.getDefault(), "L 313 %d 800 %d 1",
            posValores += tam,
            posValores)
          );

          linha = String.format(Locale.getDefault(), "T 7 0 68 %d %s %s %s",
            posValores += tam,
            UtilHelper.padRight("Final do dia OBC", ' ', col),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAplicadosHC(),
              0), ' ', col),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdRecolhidosHC(),
              0), ' ', col)
          );

          addLine(linha);

          linha = String.format(Locale.getDefault(), "T 7 0 68 %d %s %s %s",
            posValores += tam,
            UtilHelper.padRight("Contagem", ' ', col),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAplicadosHCCont(),
              0), ' ', col),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdRecolhidosHCCont(),
              0), ' ', col)
          );

          addLine(linha);

          double apls = saldo.getQtdAplicadosHC() - saldo.getQtdAplicadosHCCont();
          double rcls = saldo.getQtdRecolhidosHC() - saldo.getQtdRecolhidosHCCont();

          linha = String.format(Locale.getDefault(), "T 7 0 68 %d %s %s %s",
            posValores += tam,
            UtilHelper.padRight("Diferença", ' ', col),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(apls, 0), ' ', col),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(rcls, 0), ' ', col)
          );

          addLine(linha);

          addLine(String.format(Locale.getDefault(), "L 10 %d 805 %d 3", posValores += tam,
            posValores)
          );

          posValores += 15;
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
