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

public class Apl extends SuperOperation {

  public Apl() {
    //Definindo os CFOPs de Rfh
    operationType = OperationType.APL;
    cfop4Type = new Integer[]{5921, 5949, 6921, 6949};
    cfop3Type = new Integer[]{599, 599, 699, 699};
    unidadeFixa = true;
    tipoTransacao = operationType.getValue();
    tax1 = "T";
    tax2 = "T";
    codigoInterno = "T14";
    tipoNota = InvoiceType.SAIDA;
    recursivoUPC = true;
    returnCode = "L";
    codigoDocumento = "A3/SA";
    finalizaPedido = false;
    codigoMensagens = new String[]{
      ConstantsEnum.K.getValue(),
      ConstantsEnum.B.getValue(),
      ConstantsEnum.W.getValue()
    };

    imprimeIcmsRodape = false;
    loadType = LoadType.VAZIO;

//      "5921", // UF dentro UF - manufaturado
//      "5949", // UF dentro UF - não manufaturado
//      "6921", // UF fora UF - manufaturado
//      "6949", // UF fora UF - não manufaturado
//      "599", // OLD - UF dentro UF - manufaturado
//      "599", // OLD - UF dentro UF - não manufaturado
//      "599", // OLD - UF fora UF - manufaturado
//      "699", // OLD - UF fora UF - não manufaturado
  }

  public static SuperOperation newInstance() {
    return new Apl();
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
