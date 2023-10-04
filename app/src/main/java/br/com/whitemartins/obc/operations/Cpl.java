package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.CstType;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;

public class Cpl extends SuperOperation {

  public Cpl() {
    //Definindo os CFOPs de Vnd
    operationType = OperationType.CPL;
    unidadeFixa = false;
    tipoTransacao = operationType.getValue();
    tax1 = "F";
    tax2 = "F";
//    codigoInterno = "T90";
    tipoNota = InvoiceType.ENTRADA;
//    recursivoUPC = false;
//    returnCode = "S";
    finalizaPedido = false;
//    condicaoPagamento = true;
//    cilindroPP = false;

//    codigoMensagens = new String[]{
//      ConstantsEnum.A.getValue(),
//      ConstantsEnum.K.getValue(),
//      ConstantsEnum.I.getValue(),
//      ConstantsEnum.Z.getValue()};

    loadType = LoadType.CHEIO;
    calculaVolume = true;
  }

  public static SuperOperation newInstance() {
    return new Cpl();
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
