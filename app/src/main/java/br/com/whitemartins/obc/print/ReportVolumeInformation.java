package br.com.whitemartins.obc.print;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.CalculoVolumeType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Abastecimento;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.xml.XmlConfig;

public class ReportVolumeInformation extends BaseReports {
  @Override
  protected BasePrinter getPriter() {

    final BasePrinter printer = new BasePrinter() {

      Double getTotalM3(List<Abastecimento> abastecimentos) {
        Double acumulado = 0D;

        for (Abastecimento abastecimento : abastecimentos)
          acumulado += abastecimento.getTotalDescarga();

        return acumulado;
      }

      @Override
      protected void doHeader() {
        this._printDefs._width = 831;
        this.titulo = toString() + parcial;
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
        String linha = "";

        Long clienteAtual = 0L;
        Long notaAtual = 0L;
        String tanqueAtual = "";

        addLine("SETSP 2");
        addLine("SETBOLD 1");

        List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().getAll();

        for (Invoice invoice : invoices) {
          Customer customer = DatabaseApp.self().getDatabase().customerDao()
            .findById(invoice.getCdCustomer());

          List<Abastecimento> abastecimentos = DatabaseApp.self().getDatabase().abastecimentoDao()
            .find(customer.getCdCustomer(),
              invoice.getId());

          if (abastecimentos.size() == 0)
            continue;

          tanqueAtual = "";

          if (!clienteAtual.equals(invoice.getCdCustomer())) {
            addLine(String.format(Locale.getDefault(), "L 7 %d 803 %d 1",
              posValores += tam - 5, posValores));

            addLine(String.format(Locale.getDefault(), "T 0 2 7 %d Cliente: %d - %s",
              posValores += 15, invoice.getCdCustomer(), customer.getNome()));

            //Guardando a nota para imprimir no cabecalho
            clienteAtual = invoice.getCdCustomer();
          }

          SuperOperation OPERACAO = SuperOperation.getOperation(invoice.getTipoTransacao());

          if (!notaAtual.equals(invoice.getId())) {
            addLine(String.format(Locale.getDefault(), "T 0 2 7 %dNF %s: %d     Serie: %d",
              posValores += tam, OPERACAO.getOperationType().getName(),
              invoice.getNumero(), invoice.getSerie()));

            //Guardando a nota para imprimir no cabecalho
            notaAtual = invoice.getId();

            Double totalCalculado = getTotalM3(abastecimentos);

            int coluna = 11;

            if (abastecimentos.size() > 0) {
              Abastecimento abastecimento = abastecimentos.get(0);

              if (abastecimento.getTipoCalculo().equals(CalculoVolumeType.PESO.getValue()))
                totalCalculado = abastecimento.getTotalCalulado();

              String tpCalculoStr = abastecimento.getTipoCalculo()
                .equals(CalculoVolumeType.PESO.getValue()) ? "Pesagem" : "Diferenca de Nivel";

              linha = String.format(Locale.getDefault(),
                "T 0 2 7 %dTipo Calculo: %s     Divergencia: %s", posValores += tam,
                tpCalculoStr, (totalCalculado.equals(abastecimento.getTotalNfe()) ? "NAO" : "SIM"));
              addLine(linha);

              linha = String.format(Locale.getDefault(),
                "T 0 2 7 %dVolume Total Calculado (M3): %f", posValores += tam, totalCalculado);
              addLine(linha);

              linha = String.format(Locale.getDefault(),
                "T 0 2 7 %dVolume Total NFe (M3): %f", posValores += tam,
                abastecimento.getTotalNfe());
              addLine(linha);
            }

            for (Abastecimento abastecimento : abastecimentos) {
              if (!tanqueAtual.equalsIgnoreCase(abastecimento.getNumeroSerieTanque())
                || abastecimento.getTipoCalculo().equals(CalculoVolumeType.PESO.getValue())) {
                if (abastecimento.getNumeroSerieTanque() != null
                  && !abastecimento.getNumeroSerieTanque().isEmpty()) {

                  linha = String.format(Locale.getDefault(),
                    "T 0 2 7 %dTanque (Num. Serie): %s", posValores += tam + 10,
                    abastecimento.getNumeroSerieTanque());
                  addLine(linha);
                }

                addLine(String.format(Locale.getDefault(), "L 7 %d 803 %d 1",
                  posValores += tam - 5, posValores));

                coluna = 12;

                if (abastecimento.getTipoCalculo().equals(CalculoVolumeType.PESO.getValue())) {
                  coluna = 13;

                  linha = String.format(Locale.getDefault(), "T 0 2 7 %s%s%s%s%s%s",
                    posValores += tam - 5,
                    UtilHelper.padLeft("Peso Antes", ' ', coluna),
                    UtilHelper.padLeft("Peso Depois", ' ', coluna),
                    UtilHelper.padLeft("Diferenca", ' ', coluna),
                    UtilHelper.padLeft("Ft. Conv.", ' ', coluna),
                    UtilHelper.padLeft("Vol. M3/KG", ' ', coluna)
                  );
                  addLine(linha);
                } else {
                  linha = String.format(Locale.getDefault(), "T 0 2 7 %s%s%s%s%s%s%s%s",
                    posValores += tam - 5,
                    UtilHelper.padLeft("Volume   ", ' ', coluna),
                    UtilHelper.padLeft("Volume   ", ' ', coluna),
                    UtilHelper.padLeft("Diferenca", ' ', coluna),
                    UtilHelper.padLeft("Fator  ", ' ', 11),
                    UtilHelper.padLeft("Volume", ' ', 7),
                    UtilHelper.padLeft("Capacidade", ' ', 12),
                    UtilHelper.padLeft("Capacidade", ' ', 12)
                  );

                  addLine(linha);

                  linha = String.format(Locale.getDefault(), "T 0 2 7 %s%s%s%s%s%s%s%s",
                    posValores += tam,
                    UtilHelper.padLeft("Antes Pol.", ' ', coluna),
                    UtilHelper.padLeft("Depois Pol.", ' ', coluna),
                    UtilHelper.padLeft("Vol. Pol.", ' ', coluna),
                    UtilHelper.padLeft("Conversao", ' ', 11),
                    UtilHelper.padLeft("M3/KG", ' ', 7),
                    UtilHelper.padLeft("Polegadas", ' ', 12),
                    UtilHelper.padLeft("M3/KG", ' ', 12)
                  );

                  addLine(linha);
                }
                addLine(String.format(Locale.getDefault(), "L 7 %d 803 %d 1",
                  posValores += tam - 5, posValores));

                tanqueAtual = abastecimento.getNumeroSerieTanque();
              }

              Double diferenca = 0D;

              int divisao = 10000000;

              if (abastecimento.getTipoCalculo().equals(CalculoVolumeType.PESO.getValue())) {
                diferenca = abastecimento.getPesoAntes() - abastecimento.getPesoDepois();

                linha = String.format(Locale.getDefault(), "T 0 2 7 %s%s%s%s%s%s",
                  posValores += tam - 15,
                  UtilHelper.padLeft(UtilHelper.formatDoubleString(abastecimento.getPesoAntes(),
                    0), ' ', coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(abastecimento.getPesoDepois(),
                    0), ' ', coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(diferenca, 0), ' ',
                    coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(abastecimento.getFatorConversao(),
                    0), ' ', coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(abastecimento.getTotalCalulado(),
                    0), ' ', coluna)
                );
              } else {
                divisao = 100;
                diferenca = abastecimento.getNivelAntes() - abastecimento.getNivelDepois();

                linha = String.format(Locale.getDefault(),
                  "T 0 2 7 %s%s%s%s%s%s%s%s", posValores += tam - 15,

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(abastecimento.getNivelAntes(),
                    0), ' ', coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(abastecimento.getNivelDepois(),
                    0), ' ', coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(diferenca, 0), ' ',
                    coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(abastecimento.getFatorConversao(),
                    0), ' ', coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(diferenca *
                    (abastecimento.getFatorConversao() / divisao), 0), ' ', coluna),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(
                    abastecimento.getCapacidadePol() / 100, 0), ' ', 12),

                  UtilHelper.padLeft(UtilHelper.formatDoubleString(
                    abastecimento.getCapacidadeKG() / 100, 0), ' ', 12)
                );
              }

              addLine(linha);
            }

            if (abastecimentos.size() > 0)
              posValores += 30;
          }

          //variacao = (tam * 3);
        }

        //Definindo o tamanho da impressão
        _printDefs._height = posValores + 100;
      }
    };

    return printer;
  }

  @Override
  public String toString() {
    return "RELATÓRIO DE CÁLCULO DO VOLUME DESCARREGADO";
  }
}
