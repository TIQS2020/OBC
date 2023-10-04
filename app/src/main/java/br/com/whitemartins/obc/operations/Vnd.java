package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.CstType;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;

public class Vnd extends SuperOperation {

  public Vnd() {
    //Definindo os CFOPs de Vnd
    operationType = OperationType.VND;
    cfop4Type = new Integer[]{5103, 5104, 6103, 6104};
    cfop3Type = new Integer[]{514, 515, 614, 615};
    unidadeFixa = false;
    tipoTransacao = operationType.getValue();
    tax1 = "T";
    tax2 = "T";
    codigoInterno = "T90";
    tipoNota = InvoiceType.SAIDA;
    recursivoUPC = false;
    returnCode = "S";
    finalizaPedido = true;
    condicaoPagamento = true;
    cilindroPP = false;

    codigoMensagens = new String[]{
      ConstantsEnum.A.getValue(),
      ConstantsEnum.K.getValue(),
      ConstantsEnum.I.getValue(),
      ConstantsEnum.Z.getValue()
    };

    loadType = LoadType.CHEIO;
    calculaVolume = true;
    imprimeIcmsRodape = true;

    //"5103", // UF dentro UF - manufaturado
    //"5104", // UF dentro UF - não manufaturado
    //"6103", // UF fora UF - manufaturado
    //"6104", // UF fora UF - não manufaturado
    //"514", // OLD - UF dentro UF - manufaturado
    //"515", // OLD - UF dentro UF - não manufaturado
    //"614", // OLD - UF fora UF - manufaturado
    //"615", // OLD - UF fora UF - não manufaturado
  }

  public static SuperOperation newInstance() {
    return new Vnd();
  }

  @Override
  public String getCodigoMovimento(Invoice invoice, Customer customer) {
    if (invoice.getValorFatura() > 0) {
      if (ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlFilialWm())) {
        return CstType._86.getValue();
      } else {
        return CstType._80.getValue();
      }
    } else {
      if (ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlFilialWm()))
        return CstType._96.getValue();
      else
        return CstType._90.getValue();
    }
  }

  @Override
  public String getCodigoDocumento(Customer customer) {
    if (ConstantsEnum.YES.getValue().equalsIgnoreCase(customer.getFlFilialWm()))
      return "SI/VT";
    else
      return "SO/VT";
  }

}
