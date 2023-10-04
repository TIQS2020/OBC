package br.com.whitemartins.obc.print;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.CilinderPropertyType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

public class ReportCharge extends BaseReports {

  @Override
  public String toString() {
    return "Relatório Situação de Carga do Veículo ";
  }

  @Override
  protected BasePrinter getPriter() {
    final BasePrinter printer = new BasePrinter() {

      @Override
      protected void doHeader() {
        this._printDefs._width = 831;
        this.titulo = "RELATÓRIO SITUAÇÃO DE CARGA DO VEÍCULO " + parcial;
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

        int posValores = 198;
        int tam = 30;
        String linha;
        List<Integer> tipoItem = new ArrayList<>();
        tipoItem.add(TypeItemType.GAS.getValue());

        List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().saldoObc(null,
          tipoItem, GLOBAL.self().getRoute().getNumeroViagem());

        for (Saldo saldo : saldos) {
          Item item = DatabaseApp.self().getDatabase().itemDao().find(saldo.getCdItem(),
            saldo.getCapacidade());

          addLine(String.format(Locale.getDefault(), "T 7 0 9 %d   Item: %d - %s",
            posValores, item.getCdItem(), item.getDescricaoProduto()));

          addLine(String.format(Locale.getDefault(), "T 7 0 9  %d   Capacidade: %s %s",
            posValores += tam,
            UtilHelper.padRight(UtilHelper.formatDoubleString(item.getCapacidadeProduto(),
              2), ' ', 10), CilinderPropertyType.getNameByValue(
              item.getTipoPropriedade())));

          addLine(String.format(Locale.getDefault(), "T 7 0 314 %d %s %s",
            posValores += tam,
            UtilHelper.padLeft("Cheios", ' ', 11),
            UtilHelper.padLeft("Vazios", ' ', 10))
          );

          addLine(String.format(Locale.getDefault(), "L 313 %d 800 %d 1",
            posValores += tam,
            posValores)
          );

          linha = String.format(Locale.getDefault(), "T 7 0 68 %d %s %s %s",
            posValores += tam - 10,
            UtilHelper.padRight("Carga", ' ', 20),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCarregadaCheios(),
              0), ' ', 10),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCarregadaVazios(),
              0), ' ', 10)
          );

          addLine(linha);

          linha = String.format(Locale.getDefault(), "T 7 0 68 %d %s %s %s",
            posValores += tam,
            UtilHelper.padRight("Saldo Atual", ' ', 20),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualCheios(), 0), ' ',
              10),
            UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualVazios(), 0), ' ',
              10)
          );

          addLine(linha);

          addLine(String.format(Locale.getDefault(), "L 10 %d 805 %d 3",
            posValores += tam,
            posValores)
          );

          posValores += 15;

          FDCheioT += saldo.getQtdCarregadaCheios();
          FDVazioT += saldo.getQtdCarregadaVazios();

          CTCheioT += saldo.getQtdAtualCheios();
          CTVazioT += saldo.getQtdAtualVazios();
        }

        //RODAPÉ
        addLine(String.format(Locale.getDefault(), "T 7 0 50 %d TOTAL GERAL",
          posValores += 30));

        addLine(String.format(Locale.getDefault(), "T 7 0 314 %d %s %s",
          posValores += tam,
          UtilHelper.padLeft("Cheios", ' ', 11),
          UtilHelper.padLeft("Vazios", ' ', 10))
        );

        addLine(String.format(Locale.getDefault(), "L 313 %d 800 %d 1",
          posValores += tam,
          posValores)
        );

        linha = String.format(Locale.getDefault(), "T 7 0 68  %d %s %s %s",
          posValores += tam,
          UtilHelper.padRight("Carga", ' ', 20),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(FDCheioT, 0), ' ', 10),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(FDVazioT, 0), ' ', 10)
        );

        addLine(linha);

        linha = String.format(Locale.getDefault(), "T 7 0 68  %d %s %s %s",
          posValores += tam,
          UtilHelper.padRight("Saldo Atual", ' ', 20),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(CTCheioT, 0), ' ', 10),
          UtilHelper.padLeft(UtilHelper.formatDoubleString(CTVazioT, 0), ' ', 10)
        );

        addLine(linha);

        _printDefs._height = posValores + 100;
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
