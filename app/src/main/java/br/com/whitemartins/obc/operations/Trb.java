package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;

public class Trb extends SuperOperation {

  public Trb() {
    //Definindo os CFOPs de Rfh
    operationType =  OperationType.TRB;
//    cfop4Type = new Integer[]{5921, 5949, 6921, 6949};
//    cfop3Type = new Integer[]{599, 599, 699, 699};
    unidadeFixa = true;
    tipoTransacao = operationType.getValue();
    tax1 = "F";
    tax2 = "F";
//    codigoInterno = "T14";
    tipoNota = InvoiceType.SAIDA;
    recursivoUPC = false;
    returnCode = "U";
//    codigoDocumento = "A3/SA";
    finalizaPedido = false;
//    codigoMensagens = new String[]{
//      ConstantsEnum.K.getValue(),
//      ConstantsEnum.B.getValue(),
//      ConstantsEnum.W.getValue()
//    };

    loadType = LoadType.NULO;

  }

  public static SuperOperation newInstance() {
    return new Trb();
  }

}
