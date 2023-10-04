package br.com.whitemartins.obc.util;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.dao.CustomerDao;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.views.DatabaseApp;

public class DataGetHelper {

  public static List<Customer> getListClients(CustomerListType type, Long cdCustomer) {

    CustomerDao dao = DatabaseApp.self().getDatabase().customerDao();

    return dao.getCustomersAndPatients(type.getValue(),
      UtilHelper.convertToLongDef(GLOBAL.self().getRoute().getCdCompanhia(), 0), cdCustomer);
  }

  public static List<ItemPrice> getItemsPrice(Long cdCustomer, Long cdItem, String numeroNotaOrigem,
                                              TypeItemType tipoItem, String flNovoFaturamento) {

    List<Integer> t = new ArrayList<>();

    //Para equipamento, os tipos são 2 e 4
    if (tipoItem.equals(TypeItemType.EQUIPAMENTO)) {
      t.add(TypeItemType.EQUIPAMENTO.getValue());
      t.add(TypeItemType.MISCELANIA.getValue());
    } else
      t.add(tipoItem.getValue());

    List<ItemPrice> prices = new ArrayList<>();

    if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.VND))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesVnd(cdCustomer, cdItem, t);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCLNF)
      || GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCLHC)
      || GLOBAL.self().getOperation().getOperationType().equals(OperationType.RCL))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesRcl(cdItem, t);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.APL))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesApl(cdCustomer, cdItem, t);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.APLHC))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesAplHC(cdItem, t);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.FUT))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesFut(cdCustomer, cdItem,
        numeroNotaOrigem, t);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.TRC))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesTrc(cdCustomer, cdItem, t);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.RPS))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesRps(cdCustomer, cdItem, t,
        flNovoFaturamento);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.TRB))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesTrb(cdItem);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.TRF))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesTrf(cdCustomer);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.RFH))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesRfh(cdCustomer, cdItem, t,
        flNovoFaturamento);
    else if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.CPL))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesCpl(cdItem);
    if (GLOBAL.self().getOperation().getOperationType().equals(OperationType.VOR))
      prices = DatabaseApp.self().getDatabase().priceDao().findPricesVor(cdCustomer, cdItem, t);

    return prices;
  }
}
