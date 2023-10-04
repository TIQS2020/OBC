package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.Cfop3Type;
import br.com.whitemartins.obc.enumeration.Cfop4Type;
import br.com.whitemartins.obc.enumeration.CilinderPropertyType;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.ItemPrice;

public class Rcl extends SuperOperation {
  public Rcl() {
    //Definindo os CFOPs de RclNf
    operationType = OperationType.RCL;
    cfop4Type = new Integer[]{1920, 1949, 2920, 2949};
    cfop3Type = new Integer[]{199, 199, 299, 299};
    unidadeFixa = true;
    tipoTransacao = operationType.getValue();
    tax1 = "T";
    tax2 = "T";
    codigoInterno = "T26";
    tipoNota = InvoiceType.ENTRADA;
    recursivoUPC = true;
    returnCode = "M";
    codigoDocumento = "V1/T1";
    finalizaPedido = false;
    cilindroPP = true;
    codigoMensagens = new String[]{
      ConstantsEnum.C.getValue(),
      ConstantsEnum.K.getValue()
    };

    imprimeIcmsRodape = false;
    loadType = LoadType.VAZIO;
  }

  public static SuperOperation newInstance() {
    return new Rcl();
  }

  @Override
  public Integer getCfop(Customer customer, ItemPrice itemPrice) {
    if (customer.getUf().equalsIgnoreCase(GLOBAL.self().getRoute().getUf())) {
      if (itemPrice.getItem().getTipoPropriedade().equalsIgnoreCase(CilinderPropertyType.PP.getValue()))
        return cfop4Type[Cfop4Type.INTERNO_MANUF.ordinal()];
      else
        return cfop4Type[Cfop4Type.INTERNO_NAO_MANUF.ordinal()];
    } else {
      if (itemPrice.getItem().getTipoPropriedade().equalsIgnoreCase(CilinderPropertyType.PP.getValue()))
        return cfop4Type[Cfop4Type.EXTERNO_MANUF.ordinal()];
      else
        return cfop4Type[Cfop4Type.EXTERNO_NAO_MANUF.ordinal()];
    }
  }

  @Override
  public Integer getOldCfop(Customer customer, ItemPrice itemPrice) {
    if (customer.getUf().equalsIgnoreCase(GLOBAL.self().getRoute().getUf())) {
      if (itemPrice.getItem().getTipoPropriedade().equalsIgnoreCase(CilinderPropertyType.PP.getValue()))
        return cfop3Type[Cfop3Type.INTERNO_MANUF.ordinal()];
      else
        return cfop3Type[Cfop3Type.INTERNO_NAO_MANUF.ordinal()];
    } else {
      if (itemPrice.getItem().getTipoPropriedade().equalsIgnoreCase(CilinderPropertyType.PP.getValue()))
        return cfop3Type[Cfop3Type.EXTERNO_MANUF.ordinal()];
      else
        return cfop3Type[Cfop3Type.EXTERNO_NAO_MANUF.ordinal()];
    }
  }
}
