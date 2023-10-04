package br.com.whitemartins.obc.util;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Search;
import br.com.whitemartins.obc.views.DatabaseApp;

public class SearchHelper {

  private static SearchHelper _self;

  public static SearchHelper self() {
    if (_self == null)
      _self = new SearchHelper();

    return _self;
  }

  public boolean podePesquisar(Long cdCustomer, OperationType operationType) {

    //Em viagens Homecare, não será realizada a Pesquisa de Satisfação.
    if (GLOBAL.self().isHomecare())
      return false;

    if (operationType.equals(OperationType.VND) || operationType.equals(OperationType.FUT)) {
      String todayStr = UtilHelper.currentDateTimeString(ConstantsEnum.yyyyMMdd_traco.getValue());

      Customer customer = DatabaseApp.self().getDatabase().customerDao().findById(cdCustomer);
      Search search = DatabaseApp.self().getDatabase().searchDao().findByCustomer(cdCustomer, todayStr);

      if (todayStr.equalsIgnoreCase(UtilHelper
        .formatDateStr(customer.getDtPesquisa(), ConstantsEnum.yyyyMMdd_traco.getValue())))
        return false;

      return ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlPesquisa())
        && search == null;
    } else
      return false;
  }
}
