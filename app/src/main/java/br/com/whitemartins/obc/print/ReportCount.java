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
import br.com.whitemartins.obc.xml.XmlConfig;

public class ReportCount extends BaseReports {

  @Override
  public String toString() {
    return "Relatório de Contagem Física ";
  }

  @Override
  protected BasePrinter getPriter() {
    final BasePrinter printer = new BasePrinter() {

      @Override
      protected void doHeader() {
        this._printDefs._width = 831;
        this.titulo = "RELATÓRIO DE CONTAGEM FÍSICA DE CILINDROS " + parcial;
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
        Double FDCheioT = 0D;
        Double FDVazioT = 0D;
        Double CTCheioT = 0D;
        Double CTVazioT = 0D;
        Double DIFCheioT = 0D;
        Double DIFVazioT = 0D;

        int posValores = 198;
        int tam = 30;
        String linha = "";
        List<Integer> tipoItem = new ArrayList<>();
        tipoItem.add(TypeItemType.GAS.getValue());

        List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().saldoObc(null,
          tipoItem, GLOBAL.self().getRoute().getNumeroViagem());

        for (Saldo saldo : saldos) {
          Item item = DatabaseApp.self().getDatabase().itemDao().find(saldo.getCdItem(),
            saldo.getCapacidade());

          addLine(String.format(Locale.getDefault(), "T 7 0 9 %d   Item: %d - %s",
            posValores, item.getCdCilindro(), item.getDescricaoProduto()));

          addLine(String.format(Locale.getDefault(), "T 7 0 314 %d %s %s %s",
            posValores += tam,
            UtilHelper.padLeft("Cheios", ' ', 11),
            UtilHelper.padLeft("Vazios", ' ', 10),
            UtilHelper.padLeft("Total", ' ', 10))
          );

          addLine(String.format(Locale.getDefault(), "L 313 %d 800 %d 1",
            posValores += tam,
            posValores)
          );

          linha = String.format(Locale.getDefault(), "T 7 0 68 %d %s %s %s %s",
            posValores += tam - 15,
            UtilHelper.padRight("Final do dia OBC", ' ', 20),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualCheios(),
              0), ' ', 10),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualVazios(),
              0), ' ', 10),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualCheios() +
              saldo.getQtdAtualVazios(), 0), ' ', 10)
          );

          addLine(linha);

          linha = String.format(Locale.getDefault(), "T 7 0 68 %d %s %s %s %s",
            posValores += tam,
            UtilHelper.padRight("Contagem", ' ', 20),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCheiosCont(),
              0), ' ', 10),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdVaziosCont(),
              0), ' ', 10),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCheiosCont() +
              saldo.getQtdVaziosCont(), 0), ' ', 10)
          );

          addLine(linha);

          Double difCheio, difVazio;
          difCheio = saldo.getQtdCheiosCont() - saldo.getQtdAtualCheios();
          difVazio = saldo.getQtdVaziosCont() - saldo.getQtdAtualVazios();

          linha = String.format(Locale.getDefault(), "T 7 0 68 %d %s %s %s %s",
            posValores += tam,
            UtilHelper.padRight("Diferença", ' ', 20),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(difCheio, 0), ' ',
              10),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(difVazio, 0), ' ',
              10),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(difCheio + difVazio, 0),
              ' ', 10)
          );

          addLine(linha);

          addLine(String.format(Locale.getDefault(), "L 10 %d 805 %d 3",
            posValores += tam,
            posValores)
          );

          posValores += 15;

          FDCheioT += saldo.getQtdAtualCheios();
          FDVazioT += saldo.getQtdAtualVazios();

          CTCheioT += saldo.getQtdCheiosCont();
          CTVazioT += saldo.getQtdVaziosCont();

          DIFCheioT += difCheio;
          DIFVazioT += difVazio;
        }

        //RODAPÉ
        addLine(String.format(Locale.getDefault(), "T 7 0 50 %d TOTAL GERAL CONTAGEM",
          posValores += 30));

        addLine(String.format(Locale.getDefault(), "T 7 0 314 %d %s %s %s",
          posValores += tam,
          UtilHelper.padLeft("Cheios", ' ', 11),
          UtilHelper.padLeft("Vazios", ' ', 10),
          UtilHelper.padLeft("Total", ' ', 10))
        );

        addLine(String.format(Locale.getDefault(), "L 313 %d 800 %d 1",
          posValores += tam,
          posValores)
        );

        linha = String.format(Locale.getDefault(), "T 7 0 68  %d %s %s %s %s",
          posValores += tam - 15,
          UtilHelper.padRight("Final do dia OBC", ' ', 20),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(FDCheioT, 0), ' ', 10),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(FDVazioT, 0), ' ', 10),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(FDCheioT + FDVazioT, 0),
            ' ', 10)
        );

        addLine(linha);

        linha = String.format(Locale.getDefault(), "T 7 0 68  %d %s %s %s %s",
          posValores += tam,
          UtilHelper.padRight("Contagem", ' ', 20),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(CTCheioT, 0), ' ', 10),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(CTVazioT, 0), ' ', 10),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(CTCheioT + CTVazioT, 0),
            ' ', 10)
        );

        addLine(linha);

        linha = String.format(Locale.getDefault(), "T 7 0 68  %d %s %s %s %s",
          posValores += tam,
          UtilHelper.padRight("Diferença", ' ', 20),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(DIFCheioT, 0), ' ', 10),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(DIFVazioT, 0), ' ', 10),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(DIFCheioT + DIFVazioT, 0),
            ' ', 10)
        );

        addLine(linha);

        _printDefs._height = posValores + 100;
      }
    };

    return printer;
  }
}
