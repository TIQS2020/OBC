package br.com.whitemartins.obc.util;

import java.util.List;

import br.com.whitemartins.obc.dao.ItemDao;
import br.com.whitemartins.obc.dao.PreOrderDao;
import br.com.whitemartins.obc.dao.SaldoDao;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.model.Item;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.views.DatabaseApp;

public class SaldoHelper {

  private static SaldoHelper _self;
  private SaldoDao saldoDao = DatabaseApp.self().getDatabase().saldoDao();
  private PreOrderDao preOrderDao = DatabaseApp.self().getDatabase().preOrderDao();

  private SaldoHelper() {
  }

  public static SaldoHelper self() {
    if (_self == null)
      _self = new SaldoHelper();

    return _self;
  }

  public void updateSaldos() {
    ItemDao itemDao = DatabaseApp.self().getDatabase().itemDao();

    List<Integer> tipoItem = TypeItemType.build(
      TypeItemType.GAS,
      TypeItemType.EQUIPAMENTO,
      TypeItemType.MISCELANIA,
      TypeItemType.CONSUMIVEL
    );

    List<Travel> travels = DatabaseApp.self().getDatabase().travelDao().getAll();

    for (Travel travel : travels) {
      List<Item> items = itemDao.find(tipoItem);

      for (Item item : items) {
        Saldo saldo = Saldo.newInstance();
        saldo.setNumeroViagem(travel.getNumeroViagem());
        saldo.setCdItem(item.getCdItem());
        saldo.setCapacidade(item.getCapacidadeCilindro());
        saldo.setNomeItem(item.getDescricaoProduto());
        saldo.setQtdCarregadaCheios(item.getQtdCilindroCheios());
        saldo.setQtdCarregadaVazios(item.getQtdCilindroVazios());
        saldo.setQtdAtualCheios(item.getQtdCilindroCheios());
        saldo.setQtdAtualVazios(item.getQtdCilindroVazios());
        saldo.setTipoItem(item.getTipoItem());
        saldo.setTipoPropriedade(item.getTipoPropriedade());

        saldo.save();
      }
    }
  }

  public Double getSaldoByOperation(Long cdItem, Double capadidade, String numeroNotaOrigem,
                                    SuperOperation operation, Long numeroViagem) {

    Saldo saldo = saldoDao.find(cdItem, capadidade, numeroViagem);

    if (saldo == null)
      saldo = Saldo.newInstance();

    if (operation.getOperationType().equals(OperationType.FUT)) {

      Double saldoFinal = 0D;
      PreOrder preOrder = preOrderDao.find(cdItem, numeroNotaOrigem);

      Double saldoPreOrder = preOrder.getSaldo() / preOrder.getCapacidadeProduto();

      if (saldo.getQtdAtualCheios() > saldoPreOrder)
        saldoFinal = saldoPreOrder;
      else
        saldoFinal = saldo.getQtdAtualCheios();

      return UtilHelper.formatDouble(saldoFinal, 4);

    } else if (operation.getLoadType().equals(LoadType.CHEIO))
      return UtilHelper.formatDouble(saldo.getQtdAtualCheios(), 4);
    else
      return UtilHelper.formatDouble(saldo.getQtdAtualVazios(), 4);
  }


  public void atualizarSaldoOperation(Long cdItem, Double capadidade, SuperOperation operation,
                                      Double quantidade, String numeroNotaOrigem, Long numeroViagem,
                                      boolean cancelar) {

    Item item = DatabaseApp.self().getDatabase().itemDao().find(cdItem, capadidade);

    Saldo saldo = saldoDao.find(item.getCdItem(), capadidade, numeroViagem);

    if (saldo == null)
      saldo = Saldo.newInstance();

    Double qtdBanco;

    int fator = 1;
    if (cancelar)
      fator = -1;

    quantidade *= fator;

    saldo.setCdItem(item.getCdItem());
    saldo.setNomeItem(item.getDescricaoProduto());
    saldo.setCapacidade(item.getCapacidadeProduto());
    saldo.setTipoItem(item.getTipoItem());
    saldo.setNumeroViagem(numeroViagem);
    saldo.setTipoPropriedade(item.getTipoPropriedade());

    if (operation.getOperationType().equals(OperationType.VND)) {

      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);
      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() - quantidade);
      qtdBanco = saldo.getQtdVendidos();
      saldo.setQtdVendidos(qtdBanco + quantidade);

    } else if (operation.getOperationType().equals(OperationType.VOR)) {

      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);
      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() - quantidade);
      qtdBanco = saldo.getQtdVendidos();
      saldo.setQtdVendidos(qtdBanco + quantidade);

    } else if (operation.getOperationType().equals(OperationType.APL)) {

      qtdBanco = saldo.getQtdAplicados();
      saldo.setQtdAplicados(qtdBanco + quantidade);
      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() - quantidade);

    } else if (operation.getOperationType().equals(OperationType.APLHC)) {

      qtdBanco = saldo.getQtdAplicadosHC();
      saldo.setQtdAplicadosHC(qtdBanco + quantidade);
      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() - quantidade);

    } else if (operation.getOperationType().equals(OperationType.RCL)) {

      qtdBanco = saldo.getQtdRecolhidos();
      saldo.setQtdRecolhidos(qtdBanco + quantidade);
      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);

    } else if (operation.getOperationType().equals(OperationType.RCLNF)) {

      qtdBanco = saldo.getQtdRecolhidos();
      saldo.setQtdRecolhidos(qtdBanco + quantidade);
      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);

    } else if (operation.getOperationType().equals(OperationType.RCLHC)) {

      qtdBanco = saldo.getQtdRecolhidosHC();
      saldo.setQtdRecolhidosHC(qtdBanco + quantidade);
      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);

    } else if (operation.getOperationType().equals(OperationType.FUT)) {

      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);
      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() - quantidade);
      qtdBanco = saldo.getQtdVendidos();
      saldo.setQtdVendidos(qtdBanco + quantidade);

      atualizarSaldoPreOrder(cdItem, quantidade, numeroNotaOrigem);

    } else if (operation.getOperationType().equals(OperationType.TRC)) {

      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);
      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() - quantidade);
      qtdBanco = saldo.getQtdTrocados();
      saldo.setQtdTrocados(qtdBanco + quantidade);

    } else if (operation.getOperationType().equals(OperationType.RPS)) {

      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);
      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() - quantidade);
      //qtdBanco = saldo.getQtdTrocados();
      //saldo.setQtdTrocados(qtdBanco + quantidade);

      qtdBanco = saldo.getQtdVendidos();
      saldo.setQtdVendidos(qtdBanco + quantidade);
    } else if (operation.getOperationType().equals(OperationType.RFH)) {

      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);
      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() - quantidade);
//      qtdBanco = saldo.getQtdTrocados();
//      saldo.setQtdTrocados(qtdBanco + quantidade);

      qtdBanco = saldo.getQtdVendidos();
      saldo.setQtdVendidos(qtdBanco + quantidade);

    } else if (operation.getOperationType().equals(OperationType.TRF)) {

      saldo.setQtdAtualVazios(saldo.getQtdAtualVazios() + quantidade);
      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() - quantidade);
      qtdBanco = saldo.getQtdTransferidos();
      saldo.setQtdTransferidos(qtdBanco + quantidade);

    } else if (operation.getOperationType().equals(OperationType.CPL)) {

      saldo.setQtdAtualCheios(saldo.getQtdAtualCheios() + quantidade);
      saldo.setQtdCarregadaCheios(saldo.getQtdCarregadaCheios() + quantidade);
      qtdBanco = saldo.getQtdTransferidos();
      saldo.setQtdComplementados(qtdBanco + quantidade);
    }

    saldo.save();
  }

  public void atualizarSaldoPreOrder(Long cdItem, Double quantidade, String numeroNotaOrigem) {

    final PreOrder preOrder = DatabaseApp.self().getDatabase().preOrderDao().find(cdItem,
      numeroNotaOrigem);

    Double qtdBanco;

    quantidade = quantidade * preOrder.getCapacidadeProduto();
    qtdBanco = preOrder.getSaldo();
    preOrder.setSaldo(qtdBanco - quantidade);

    preOrder.save();
  }

  public void atualizarSaldoInvoice(Invoice invoice,/* Long numeroViagem, */boolean cancelar) {
    SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());

    PreOrder preOrder = DatabaseApp.self().getDatabase().preOrderDao()
      .find(invoice.getNumeroFutEntrega());

    //Impendindo que ocorra NullReferencecd
    if (preOrder == null)
      preOrder = PreOrder.newInstance();

    for (InvoiceItem invoiceItem : invoice.getItens()) {
      atualizarSaldoOperation(invoiceItem.getCdItem(), invoiceItem.getCapacidade(),
        operation, invoiceItem.getQuantidadeCilindroVendida(), preOrder.getNumeroNotaOrigem(),
        UtilHelper.convertToLongDef(invoice.getNumeroViagem(), 0), cancelar);
    }
  }

}