package br.com.whitemartins.obc.util;

import java.io.IOException;
import java.util.List;

import br.com.whitemartins.obc.dao.GenericDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LotePatrimonioType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Asset;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Daily;
import br.com.whitemartins.obc.model.Excepty;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.InvoiceNumber;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.LotePatrimonio;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.views.DatabaseApp;

public class FileOutHelper {

  private static FileOutHelper _self;
  String terminador = "|";

  public static FileOutHelper self() {
    if (_self == null)
      _self = new FileOutHelper();

    return _self;
  }

  private void writeFile(String fileName, StringBuilder sb) {
    try {
      FileHelper.saveFile(sb.toString(), PathHelper.self().getFilePathFiles() + fileName);
    } catch (IOException e) {
      String TAG = "FileOutHelper";
      LogHelper.self().info(TAG, fileName + " " + e.getMessage());
      e.printStackTrace();
    }
  }

  public String daily() {
    try {
      List<Daily> dailies = DatabaseApp.self().getDatabase().dailyDao().getAll();

      StringBuilder sb = new StringBuilder();

      for (Daily daily : dailies)
        sb.append(daily.automaticParseOut()).append(terminador);

      writeFile("DAILY.txt", sb);

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      LogHelper.self().error("daily", e);
    }
    return "";
  }

  public String notas() {
    try {
      List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().getAll();

      StringBuilder sb = new StringBuilder();

      for (Invoice invoice : invoices)
        sb.append(invoice.automaticParseOut()).append(terminador);

      writeFile("NOTAS_NFE.txt", sb);

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();

      LogHelper.self().error("notas", e);
    }
    return "";
  }

  public String excepty() {
    try {
      List<Excepty> excepties = DatabaseApp.self().getDatabase().exceptDao().getAll();

      StringBuilder sb = new StringBuilder();

      for (Excepty excepty : excepties)
        sb.append(excepty.automaticParseOut()).append(terminador);

      writeFile("EXCEPT.txt", sb);

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      LogHelper.self().error("excepty", e);
    }
    return "";
  }

  public String situacaoCarga() {

    try {
      List<Integer> tipoItem = TypeItemType.build(TypeItemType.GAS);

      List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().saldoObc(null,
        tipoItem, GLOBAL.self().getRoute().getNumeroViagem());

      StringBuilder sb = new StringBuilder();

      for (Saldo saldo : saldos) {
        sb
          .append(saldo.getCdItem().toString())
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getCapacidade(), 2)
            .replace(".", ""), '0', 5))
          .append(saldo.getTipoPropriedade())
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCarregadaCheios(),
            0).replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCarregadaVazios(),
            0).replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualCheios(),
            0).replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualVazios(),
            0).replace(".", ""), '0', 4))
          .append(terminador);
      }

      writeFile("SITUACAO.txt", sb);
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();

      LogHelper.self().error("situacaoCarga", e);
    }
    return "";
  }

  public String contagemFisica() {

    try {
      List<Integer> tipoItem = TypeItemType.build(TypeItemType.GAS);
      List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().saldoObc(null,
        tipoItem, GLOBAL.self().getRoute().getNumeroViagem());

      StringBuilder sb = new StringBuilder();

      for (Saldo saldo : saldos) {
        Item item = DatabaseApp.self().getDatabase().itemDao().find(saldo.getCdItem(),
          saldo.getCapacidade());

        Double FDTotal = saldo.getQtdAtualCheios() + saldo.getQtdAtualVazios();
        Double CTTotal = saldo.getQtdCheiosCont() + saldo.getQtdVaziosCont();

        String sinalApl = " ", sinalRcl = " ";
        double dCheios = saldo.getQtdCheiosCont() - saldo.getQtdAtualCheios();
        double dVazios = saldo.getQtdVaziosCont() - saldo.getQtdAtualVazios();

        if (dCheios < 0)
          sinalApl = "-";

        if (dVazios < 0)
          sinalRcl = "-";

        sb.append(UtilHelper.padLeft(item.getCdCilindro().toString(), '0', 8))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(FDTotal, 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualCheios(), 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAtualVazios(), 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(CTTotal, 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCheiosCont(), 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdVaziosCont(), 0)
            .replace(".", ""), '0', 4))
          .append(sinalApl)
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(dCheios), 0)
            .replace(".", ""), '0', 4))
          .append(sinalRcl)
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(dVazios), 0)
            .replace(".", ""), '0', 4))

          .append(terminador);
      }

      writeFile("CONTAGEM_NFE.txt", sb);

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();

      LogHelper.self().error("contagemFisica", e);
    }
    return "";
  }

  public String itemCompHC() {
    try {
      List<LotePatrimonio> lotePatrimonios = DatabaseApp.self().getDatabase().lotePatrimonioDao()
        .find(LotePatrimonioType.PATRIMONIO.getValue());

      StringBuilder sb = new StringBuilder();

      for (LotePatrimonio lotePatrimonio : lotePatrimonios) {
        Invoice invoice = DatabaseApp.self().getDatabase().invoiceDao()
          .findById(lotePatrimonio.getIdNota());

        if (invoice.isCanceled())
          continue;

        Item item = DatabaseApp.self().getDatabase().itemDao().find(lotePatrimonio.getCdItem());

        Asset asset = DatabaseApp.self().getDatabase().assetDao().findById(item.getCdItem(),
          lotePatrimonio.getNumeroLote().toString());

        if (asset == null)
          asset = Asset.newInstace();

        sb.append(UtilHelper.padLeft(GLOBAL.self().getRoute().getCdFilialJde(), '0', 6))
          .append(UtilHelper.padLeft(invoice.getNumeroViagem(), '0', 6))
          .append(invoice.getDataViagem())
          .append(UtilHelper.padLeft(item.getCdItem().toString(), '0', 8))
          .append(UtilHelper.padRight(lotePatrimonio.getNumeroLote().toString(), ' ', 15))
          .append(UtilHelper.padRight(asset.getNumeroSerie(), ' ', 25))
          .append(UtilHelper.padLeft(invoice.getNumero().toString(), '0', 8))
          .append(UtilHelper.padLeft(invoice.getSerie().toString(), '0', 3))
          .append(UtilHelper.padLeft(invoice.getTipoNota(), ' ', 1))
          .append(UtilHelper.padLeft(asset.getCdAtivo(), '0', 8))
          .append(terminador);
      }

      writeFile("ITEM_COMP.txt", sb);
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      LogHelper.self().error("itemCompHC", e);
    }
    return "";
  }

  public String contagemFisicaHC() {

    try {
      List<Integer> tipoItem = TypeItemType.build(TypeItemType.EQUIPAMENTO, TypeItemType.MISCELANIA);
      List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().saldoObc(null,
        tipoItem, GLOBAL.self().getRoute().getNumeroViagem());

      StringBuilder sb = new StringBuilder();

      for (Saldo saldo : saldos) {
        Item item = DatabaseApp.self().getDatabase().itemDao().find(saldo.getCdItem(),
          saldo.getCapacidade());

        Double FDTotal = saldo.getQtdAtualCheios() + saldo.getQtdAtualVazios();

        String sinalApl = " ", sinalRcl = " ";
        double apls = saldo.getQtdAplicadosHC() - saldo.getQtdAplicadosHCCont();
        double rcls = saldo.getQtdRecolhidosHC() - saldo.getQtdRecolhidosHCCont();

        if (apls < 0)
          sinalApl = "-";

        if (rcls < 0)
          sinalRcl = "-";

        sb.append(UtilHelper.padLeft(item.getCdCilindro().toString(), '0', 8))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCarregadaCheios(), 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAplicadosHC(), 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdRecolhidosHC(), 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAplicadosHCCont(), 0)
            .replace(".", ""), '0', 4))
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdRecolhidosHCCont(), 0)
            .replace(".", ""), '0', 4))
          .append(sinalApl)
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(apls), 0)
            .replace(".", ""), '0', 4))
          .append(sinalRcl)
          .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(rcls), 0)
            .replace(".", ""), '0', 4))

          .append(terminador);
      }

      writeFile("CONTAGEM_NFE.txt", sb);

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      LogHelper.self().error("contagemFisicaHC", e);
    }
    return "";
  }

  public String movimentacaoHC() {

    try {
      List<Integer> tipoItem = TypeItemType.build(TypeItemType.EQUIPAMENTO, TypeItemType.MISCELANIA);

      List<InvoiceItem> invoiceItems = DatabaseApp.self().getDatabase().invoiceItemDao().find(tipoItem);

      StringBuilder sb = new StringBuilder();

      for (InvoiceItem invoiceItem : invoiceItems) {
        Invoice invoice = DatabaseApp.self().getDatabase().invoiceDao()
          .findById(invoiceItem.getIdNota());

        if (invoice.isCanceled())
          continue;

        Customer customer = DatabaseApp.self().getDatabase().customerDao()
          .findById(invoice.getCdCustomer());

        if (customer == null)
          customer = DatabaseApp.self().getDatabase().customerDao().findById(invoice.getCdOperadora());

        SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());

        List<LotePatrimonio> lotePatrimonios = DatabaseApp.self().getDatabase().lotePatrimonioDao()
          .find(invoice.getId(), invoiceItem.getCdItem(), invoiceItem.getCapacidade());

        String at = "";
        if (ConstantsEnum.YES.getValue().equalsIgnoreCase(invoiceItem.getFlAssistenciaTecnica()))
          at = "AT";

        String finalAt = at;

        Customer finalCustomer = customer;

        lotePatrimonios.forEach(lotePatrimonio -> {

          Asset asset = DatabaseApp.self().getDatabase().assetDao().findById(invoiceItem.getCdItem(),
            lotePatrimonio.getNumeroLote().toString());

          String serie = "";

          if (asset != null)
            serie = asset.getNumeroSerie();

          sb.append(UtilHelper.padRight(operation.getOperationType().getName(), ' ', 15))
            .append(UtilHelper.padLeft(finalAt, ' ', 2))
            .append(invoice.getCdCustomer().toString())
            .append(UtilHelper.padRight(finalCustomer.getNome(), ' ', 30))
            .append(invoiceItem.getCdItem().toString())
            .append(UtilHelper.padRight(invoiceItem.getNomeItem(), ' ', 30))
            .append(UtilHelper.padRight(invoice.getNumero().toString(), ' ', 6))
            .append(UtilHelper.padRight(invoice.getSerie().toString(), ' ', 3))
            .append(UtilHelper.formatDateStr(invoice.getDataMovimento(),
              ConstantsEnum.ddMMyyyyHHmmss.getValue()))
            .append(UtilHelper.padRight(lotePatrimonio.getNumeroLote().toString(), ' ', 15))
            .append(UtilHelper.padRight(serie, ' ', 25))
            .append(UtilHelper.padLeft(UtilHelper.formatDoubleString(invoiceItem.getQtdItem(),
              0), ' ', 2))
            .append(terminador);
        });
      }

      writeFile("MOVIMENTACAO_HC.txt", sb);

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();

      LogHelper.self().error("movimentacaoHC", e);
    }
    return "";
  }

  public String movimentacao() {

    try {
      List<Saldo> saldos = GenericDao.self().movimentacao();

      StringBuilder sb = new StringBuilder();

      saldos.forEach(saldo -> {

        String wmcheios, wmvazios, wmtotal, ppcheios, ppvazios, pptotal;

        wmcheios = " " + UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCarregadaCheios(), 0), '0', 5);
        if (saldo.getQtdCarregadaCheios() < 0)
          wmcheios = "-" + UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(saldo.getQtdCarregadaCheios()), 0), '0', 5);

        wmvazios = " " + UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdCarregadaVazios(), 0), '0', 5);
        if (saldo.getQtdCarregadaVazios() < 0)
          wmvazios = "-" + UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(saldo.getQtdCarregadaVazios()), 0), '0', 5);

        wmtotal = " " + UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdVendidos(), 0), '0', 5);
        if (saldo.getQtdVendidos() < 0)
          wmtotal = "-" + UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(saldo.getQtdVendidos()), 0), '0', 5);

        ppcheios = " " + UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdRecolhidos(), 0), '0', 5);
        if (saldo.getQtdRecolhidos() < 0)
          ppcheios = "-" + UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(saldo.getQtdRecolhidos()), 0), '0', 5);

        ppvazios = " " + UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdAplicados(), 0), '0', 5);
        if (saldo.getQtdAplicados() < 0)
          ppvazios = "-" + UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(saldo.getQtdAplicados()), 0), '0', 5);

        pptotal = " " + UtilHelper.padLeft(UtilHelper.formatDoubleString(saldo.getQtdTrocados(), 0), '0', 5);
        if (saldo.getQtdTrocados() < 0)
          pptotal = "-" + UtilHelper.padLeft(UtilHelper.formatDoubleString(Math.abs(saldo.getQtdTrocados()), 0), '0', 5);


        sb.append(UtilHelper.padRight(saldo.getNomeItem(), ' ', 32))
          .append(wmcheios)
          .append(wmvazios)
          .append(wmtotal)
          .append(ppcheios)
          .append(ppvazios)
          .append(pptotal)
          .append(terminador);
      });

      writeFile("MOVIMENTACAO.txt", sb);

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      LogHelper.self().error("movimentacao", e);
    }
    return "";
  }

  public String talonario() {

    try {
      InvoiceNumber invoiceNumber = DatabaseApp.self().getDatabase().invoiceNumberDao().getFirst();

      List<Invoice> invoicesIn = DatabaseApp.self().getDatabase().invoiceDao()
        .findAllByTipoNota(InvoiceType.ENTRADA.getValue());

      List<Invoice> invoicesOut = DatabaseApp.self().getDatabase().invoiceDao()
        .findAllByTipoNota(InvoiceType.SAIDA.getValue());

      Long firstIn = invoiceNumber.getNumeroNotaFiscalEntrada();
      Long lastIn = invoiceNumber.getNumeroNotaFiscalEntrada();
      Long firstOut = invoiceNumber.getNuemroNotaFiscalSaida();
      Long lastOut = invoiceNumber.getNuemroNotaFiscalSaida();

      if (!invoicesIn.isEmpty()) {
        firstIn = invoicesIn.get(0).getNumero();
        lastIn = invoicesIn.get(invoicesIn.size() - 1).getNumero() + 1;
      }

      if (!invoicesOut.isEmpty()) {
        firstOut = invoicesOut.get(0).getNumero();
        lastOut = invoicesOut.get(invoicesOut.size() - 1).getNumero() + 1;
      }

      StringBuilder sb = new StringBuilder();

      sb
        .append(UtilHelper.padLeft(invoiceNumber.getNumeroSerieEntrada().toString(), ' ', 3))
        .append(ConstantsEnum.R.getValue())
        .append(UtilHelper.padRight(lastIn.toString(), ' ', 8))
        .append(UtilHelper.padRight(firstIn.toString(), ' ', 8))
        .append(UtilHelper.padRight(invoiceNumber.getNumeroMaximoNFEntrada().toString(), ' ', 8))
        .append(UtilHelper.padLeft(invoiceNumber.getNumeroSerieSaida().toString(), ' ', 3))
        .append(ConstantsEnum.O.getValue())
        .append(UtilHelper.padRight(lastOut.toString(), ' ', 8))
        .append(UtilHelper.padRight(firstOut.toString(), ' ', 8))
        .append(UtilHelper.padRight(invoiceNumber.getNumeroMaximoNFSaida().toString(), ' ', 8))
        .append(UtilHelper.padRight("", '0', 23))
        .append(UtilHelper.padRight("", ' ', 5))
        .append(UtilHelper.padRight("", '0', 8))
        .append(terminador);

      writeFile("TALONARIO.txt", sb);

      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      LogHelper.self().error("talonario", e);
    }
    return "";
  }
}
