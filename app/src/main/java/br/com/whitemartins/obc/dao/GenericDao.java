package br.com.whitemartins.obc.dao;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.database.DateTypeConverter;
import br.com.whitemartins.obc.enumeration.PropertyType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.views.DatabaseApp;


public class GenericDao {

  private static GenericDao _self;

  public static GenericDao self() {

    if (_self == null)
      _self = new GenericDao();

    return _self;
  }

  public InvoiceItem sumQtdInvoiceItem(Long cdItem, Integer tipoTransacao) {

    Object[] info = new Object[]{cdItem, tipoTransacao};

    Cursor cursor = DatabaseApp.self().getDatabase()
        .query("SELECT SUM(InvoiceItem.qtdItem) qtdItem" +
            "   FROM InvoiceItem" +
            "   JOIN Invoice ON Invoice.id = InvoiceItem.idNota" +
            "  WHERE InvoiceItem.cdItem = ifnull(:cdItem, InvoiceItem.cdItem) " +
            "    AND Invoice.tipoTransacao = :tipoTransacao " +
            "    AND Invoice.id NOT IN (SELECT Invoice.id from Invoice " +
            "       WHERE Invoice.tipoMovimentoIntegracao = 6 AND Invoice.status = 5)", info);

    InvoiceItem invoiceItem = InvoiceItem.newInstance();
    final int _cursorIndexOfCdCustomer = cursor.getColumnIndexOrThrow("qtdItem");

    while (cursor.moveToNext()) {
      invoiceItem.setQtdItem(cursor.getDouble(_cursorIndexOfCdCustomer));
    }

    return invoiceItem;
  }

  public Saldo sumSaldoGas() {

    Object[] info = new Object[]{TypeItemType.GAS.getValue()};

    Cursor cursor = DatabaseApp.self().getDatabase()
        .query("SELECT SUM(saldo.qtdAtualCheios) qtdAtualCheios, " +
            "   SUM(saldo.qtdAtualVazios) qtdAtualVazios, SUM(saldo.qtdCheiosCont) qtdCheiosCont, " +
            "   SUM(saldo.qtdVaziosCont) qtdVaziosCont" +
            "  FROM saldo" +
            "  JOIN item ON item.cdItem = saldo.cdItem AND item.capacidadeProduto = saldo.capacidade" +
            " WHERE Item.tipoItem in (:tipoItem)", info);

    Saldo saldo = Saldo.newInstance();

    final int _qtdAtualCheios = cursor.getColumnIndexOrThrow("qtdAtualCheios");
    final int _qtdAtualVazios = cursor.getColumnIndexOrThrow("qtdAtualVazios");
    final int _qtdCheiosCont = cursor.getColumnIndexOrThrow("qtdCheiosCont");
    final int _qtdVaziosCont = cursor.getColumnIndexOrThrow("qtdVaziosCont");

    while (cursor.moveToNext()) {
      saldo.setQtdAtualCheios(cursor.getDouble(_qtdAtualCheios));
      saldo.setQtdAtualVazios(cursor.getDouble(_qtdAtualVazios));
      saldo.setQtdCheiosCont(cursor.getDouble(_qtdCheiosCont));
      saldo.setQtdVaziosCont(cursor.getDouble(_qtdVaziosCont));
    }

    return saldo;
  }


  public Saldo sumSaldoEquipamento() {

    Cursor cursor = DatabaseApp.self().getDatabase()
        .query("SELECT SUM(qtdAtualCheios) qtdAtualCheios, " +
            "   SUM(qtdAtualVazios) qtdAtualVazios, " +
            "   SUM(qtdAplicadosHCCont) qtdAplicadosHCCont, " +
            "   SUM(qtdRecolhidosHCCont) qtdRecolhidosHCCont" +
            "  FROM saldo" +
            "  JOIN item ON item.cdItem = saldo.cdItem AND capacidadeProduto = capacidade" +
            " WHERE Item.tipoItem in (2, 4)", null);

    Saldo saldo = Saldo.newInstance();

    final int _qtdAtualCheios = cursor.getColumnIndexOrThrow("qtdAtualCheios");
    final int _qtdAtualVazios = cursor.getColumnIndexOrThrow("qtdAtualVazios");
    final int _qtdAplicadosHCCont = cursor.getColumnIndexOrThrow("qtdAplicadosHCCont");
    final int _qtdRecolhidosHCCont = cursor.getColumnIndexOrThrow("qtdRecolhidosHCCont");

    while (cursor.moveToNext()) {
      saldo.setQtdAtualCheios(cursor.getDouble(_qtdAtualCheios));
      saldo.setQtdAtualVazios(cursor.getDouble(_qtdAtualVazios));
      saldo.setQtdAplicadosHCCont(cursor.getDouble(_qtdAplicadosHCCont));
      saldo.setQtdRecolhidosHCCont(cursor.getDouble(_qtdRecolhidosHCCont));
    }

    return saldo;
  }

  public List<Saldo> movimentacao() {

    List<Saldo> saldos = new ArrayList<>();

//    String sql =
//      "SELECT '01Carregados' as tipo, WMCheios, WMVazios, WMTotal, PPCheios, PPVazios, PPTotal" +
//        "  FROM ((SELECT SUM(qtdCarregadaCheios) WMCheios, 0 as WMVazios, SUM(qtdCarregadaCheios) WMTotal" +
//        "           FROM Saldo WHERE tipoPropriedade IN :tipoPropriedade "+ //and qtdCarregadaCheios > 0" +
//        "       GROUP BY tipoPropriedade) WM,   " +
//        "   (SELECT SUM(qtdCarregadaCheios) PPCheios, 0 PPVazios, SUM(qtdCarregadaCheios) PPTotal" +
//        "          FROM Saldo WHERE tipoPropriedade IN (2) "+ //and qtdCarregadaCheios > 0" +
//        "      GROUP BY tipoPropriedade) PP)" +
//        " UNION " +
//        "SELECT '02Complementos', *" +
//        "  FROM ((SELECT SUM(qtdComplementados) WMCheios, 0 as WMVazios, SUM(qtdComplementados) WMTotal" +
//        "           FROM Saldo WHERE tipoPropriedade IN :tipoPropriedade "+ //and qtdCarregadaCheios > 0" +
//        "       GROUP BY tipoPropriedade) WM,   " +
//        "   (SELECT SUM(qtdComplementados) PPCheios, 0 PPVazios, SUM(qtdComplementados) PPTotal" +
//        "          FROM Saldo WHERE tipoPropriedade IN (2) "+ //and qtdCarregadaCheios > 0" +
//        "      GROUP BY tipoPropriedade) PP) " +
//        " UNION " +
//        "SELECT '03Descarregados', *" +
//        "  FROM ((SELECT 0 WMCheios, 0 as WMVazios, 0 WMTotal" +
//        "           FROM Saldo WHERE tipoPropriedade IN :tipoPropriedade "+ //and qtdCarregadaCheios > 0" +
//        "       GROUP BY tipoPropriedade) WM,   " +
//        "   (SELECT 0 WMCheios, 0 as WMVazios, 0 WMTotal" +
//        "          FROM Saldo WHERE tipoPropriedade IN (2) "+ //and qtdCarregadaCheios > 0" +
//        "      GROUP BY tipoPropriedade) PP) " +
//        " UNION " +
//        "SELECT '04Transferidos', *" +
//        "  FROM ((SELECT SUM(-qtdTransferidos) WMCheios, SUM(qtdTransferidos) as WMVazios, 0 WMTotal" +
//        "           FROM Saldo WHERE tipoPropriedade IN :tipoPropriedade "+ // and qtdCarregadaCheios > 0" +
//        "       GROUP BY tipoPropriedade) WM,   " +
//        "   (SELECT SUM(-qtdTransferidos) PPCheios, SUM(qtdTransferidos) PPVazios, 0 PPTotal" +
//        "          FROM Saldo WHERE tipoPropriedade IN (2) "+ //and qtdCarregadaCheios > 0" +
//        "      GROUP BY tipoPropriedade) PP)" +
//        " UNION " +
//        "SELECT '05Recolhidos', *" +
//        "  FROM ((SELECT 0 WMCheios, SUM(qtdRecolhidos) as WMVazios, SUM(qtdRecolhidos) WMTotal" +
//        "           FROM Saldo WHERE tipoPropriedade IN :tipoPropriedade " +
//        "       GROUP BY tipoPropriedade) WM,   " +
//        "   (SELECT 0 PPCheios, SUM(qtdRecolhidos) PPVazios, SUM(qtdRecolhidos) PPTotal" +
//        "          FROM Saldo WHERE tipoPropriedade IN (2) " +
//        "      GROUP BY tipoPropriedade) PP)" +
//        " UNION " +
//        "SELECT '06Trocados', *" +
//        "  FROM ((SELECT SUM(-qtdTrocados) WMCheios, SUM(qtdTrocados) as WMVazios, 0 WMTotal" +
//        "           FROM Saldo WHERE tipoPropriedade IN :tipoPropriedade "+ // and qtdCarregadaCheios > 0" +
//        "       GROUP BY tipoPropriedade) WM,   " +
//        "   (SELECT SUM(-qtdTrocados) PPCheios, SUM(qtdTrocados) PPVazios, 0 PPTotal" +
//        "          FROM Saldo WHERE tipoPropriedade IN (2) "+ //and qtdCarregadaCheios > 0" +
//        "      GROUP BY tipoPropriedade) PP)" +
//        " UNION " +
//        "SELECT '07Vendidos', *" +
//        "  FROM ((SELECT SUM(-qtdVendidos) WMCheios, SUM(qtdVendidos) as WMVazios, 0 WMTotal" +
//        "           FROM Saldo WHERE tipoPropriedade IN :tipoPropriedade "+ //and qtdCarregadaCheios > 0" +
//        "       GROUP BY tipoPropriedade) WM,   " +
//        "   (SELECT SUM(-qtdVendidos) PPCheios, SUM(qtdVendidos) PPVazios, 0 PPTotal" +
//        "          FROM Saldo WHERE tipoPropriedade IN (2) "+ //and qtdCarregadaCheios > 0" +
//        "      GROUP BY tipoPropriedade) PP)" +
//        " UNION " +
//        "SELECT '08Aplicados', *" +
//        "  FROM ((SELECT 0 WMCheios, SUM(-qtdAplicados) as WMVazios, SUM(-qtdAplicados) WMTotal" +
//        "           FROM Saldo WHERE tipoPropriedade IN :tipoPropriedade "+ //and qtdCarregadaCheios > 0" +
//        "       GROUP BY tipoPropriedade) WM,   " +
//        "   (SELECT 0 PPCheios, SUM(-qtdAplicados) PPVazios, SUM(-qtdAplicados) PPTotal" +
//        "          FROM Saldo WHERE tipoPropriedade IN (2)  "+ //and qtdCarregadaCheios > 0" +
//        "      GROUP BY tipoPropriedade) PP)";

    String sql =
        "SELECT '01Carregados' TIPO, SUM(QTDCARREGADACHEIOS) CHEIOS, " +
            "                0 AS VAZIOS, " +
            "                SUM(QTDCARREGADACHEIOS) TOTAL " +
            "           FROM SALDO " +
            "          WHERE TIPOPROPRIEDADE = :tipoPropriedade " +
            "          GROUP BY TIPOPROPRIEDADE       " +
            "UNION  " +
            "SELECT '02Complementos', SUM(QTDCOMPLEMENTADOS) CHEIOS, " +
            "                0 AS VAZIOS, " +
            "                SUM(QTDCOMPLEMENTADOS) TOTAL " +
            "           FROM SALDO " +
            "          WHERE TIPOPROPRIEDADE = :tipoPropriedade " +
            "          GROUP BY TIPOPROPRIEDADE " +
            "UNION " +
            "SELECT '03Descarregados', 0 CHEIOS, 0 AS VAZIOS, 0 TOTAL " +
            "           FROM SALDO " +
            "          WHERE TIPOPROPRIEDADE = :tipoPropriedade " +
            "          GROUP BY TIPOPROPRIEDADE " +
            "UNION " +
            "SELECT '04Transferidos', SUM(-QTDTRANSFERIDOS) CHEIOS, " +
            "                SUM(QTDTRANSFERIDOS) AS VAZIOS, " +
            "                0 TOTAL " +
            "           FROM SALDO " +
            "          WHERE TIPOPROPRIEDADE = :tipoPropriedade " +
            "          GROUP BY TIPOPROPRIEDADE " +
            "UNION " +
            "SELECT '05Recolhidos', 0 CHEIOS, " +
            "                SUM(QTDRECOLHIDOS) AS VAZIOS, " +
            "                SUM(QTDRECOLHIDOS) TOTAL " +
            "           FROM SALDO " +
            "          WHERE TIPOPROPRIEDADE = :tipoPropriedade " +
            "          GROUP BY TIPOPROPRIEDADE " +
            "UNION " +
            "SELECT '06Trocados', SUM(-QTDTROCADOS) CHEIOS, " +
            "                SUM(QTDTROCADOS) AS VAZIOS, " +
            "                0 TOTAL " +
            "           FROM SALDO " +
            "          WHERE TIPOPROPRIEDADE = :tipoPropriedade " +
            "          GROUP BY TIPOPROPRIEDADE " +
            "UNION " +
            "SELECT '07Vendidos', SUM(-QTDVENDIDOS) CHEIOS, " +
            "                SUM(QTDVENDIDOS) AS VAZIOS, " +
            "                0 TOTAL " +
            "           FROM SALDO " +
            "          WHERE TIPOPROPRIEDADE = :tipoPropriedade " +
            "          GROUP BY TIPOPROPRIEDADE " +
            "UNION " +
            "SELECT '08Aplicados' TIPO, 0 CHEIOS, " +
            "                SUM(-QTDAPLICADOS) AS VAZIOS, " +
            "                SUM(-QTDAPLICADOS) TOTAL " +
            "           FROM SALDO " +
            "          WHERE TIPOPROPRIEDADE = :tipoPropriedade " +
            "          GROUP BY TIPOPROPRIEDADE ";

    Cursor cursor = null;

    try {
      Object[] info = new Object[]{PropertyType.PRODUZIDO_WM.getValue()};
      cursor = DatabaseApp.self().getDatabase().query(sql, info);

      final int tipo = cursor.getColumnIndexOrThrow("TIPO");
      final int cheios = cursor.getColumnIndexOrThrow("CHEIOS");
      final int vazios = cursor.getColumnIndexOrThrow("VAZIOS");
      final int total = cursor.getColumnIndexOrThrow("TOTAL");
      //final int PPCheios = cursor.getColumnIndexOrThrow("PPCheios");
      //final int PPVazios = cursor.getColumnIndexOrThrow("PPVazios");
      //final int PPTotal = cursor.getColumnIndexOrThrow("PPTotal");

      while (cursor.moveToNext()) {
        Saldo saldo = Saldo.newInstance();
        saldo.setNomeItem(cursor.getString(tipo));
        saldo.setQtdCarregadaCheios(cursor.getDouble(cheios));
        saldo.setQtdCarregadaVazios(cursor.getDouble(vazios));
        saldo.setQtdVendidos(cursor.getDouble(total));
        saldo.setQtdRecolhidos(0D);
        saldo.setQtdAplicados(0D);
        saldo.setQtdTrocados(0D);

        saldos.add(saldo);
      }

      info = new Object[]{PropertyType.NAO_PRODUZIDO_WM.getValue()};
      cursor.close();
      cursor = DatabaseApp.self().getDatabase().query(sql, info);

      if (!saldos.isEmpty()) {
        Cursor finalCursor = cursor;

        while (finalCursor.moveToNext()) {
          for (Saldo saldo : saldos) {
            if (saldo.getNomeItem().equalsIgnoreCase((finalCursor.getString(tipo)))) {
              saldo.setNomeItem(finalCursor.getString(tipo));
              saldo.setQtdRecolhidos(finalCursor.getDouble(cheios));
              saldo.setQtdAplicados(finalCursor.getDouble(vazios));
              saldo.setQtdTrocados(finalCursor.getDouble(total));
            }
          }
        }
      } else {
        while (cursor.moveToNext()) {
          Saldo saldo = Saldo.newInstance();
          saldo.setNomeItem(cursor.getString(tipo));
//        saldo.setQtdCarregadaCheios(0D);
//        saldo.setQtdCarregadaVazios(0D);
//        saldo.setQtdVendidos(0D);
          saldo.setQtdRecolhidos(cursor.getDouble(cheios));
          saldo.setQtdAplicados(cursor.getDouble(vazios));
          saldo.setQtdTrocados(cursor.getDouble(total));

          saldos.add(saldo);
        }
      }
    } catch (Exception e) {
      LogHelper.self().error("movimentacao", e);
    } finally {
      if (cursor != null)
        cursor.close();
    }

    return saldos;
  }

  public List<PreOrder> getPreOrders(Long cdCustomer) {
    Cursor cursor = DatabaseApp.self().getDatabase()
        .query("SELECT DISTINCT cdPreOrder, dataEmissaoNota, numeroNotaOrigem FROM PreOrder " +
            "where cdCustomer = :cdCustomer", new Long[]{cdCustomer});

    final int cdPreOrder = cursor.getColumnIndexOrThrow("cdPreOrder");
    final int dataEmissaoNota = cursor.getColumnIndexOrThrow("dataEmissaoNota");
    final int numeroNotaOrigem = cursor.getColumnIndexOrThrow("numeroNotaOrigem");

    List<PreOrder> preOrders = new ArrayList<>();

    while (cursor.moveToNext()) {
      PreOrder preOrder = PreOrder.newInstance();

      preOrder.setCdPreOrder(cursor.getLong(cdPreOrder));
      preOrder.setDataEmissaoNota(DateTypeConverter.fromTimestamp(cursor.getLong(dataEmissaoNota)));
      preOrder.setNumeroNotaOrigem(cursor.getString(numeroNotaOrigem));
      preOrders.add(preOrder);
    }

    return preOrders;
  }
}
