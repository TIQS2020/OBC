package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;

public class Fut extends SuperOperation {

  public Fut() {
    //Definindo os CFOPs de Vnd
    operationType = OperationType.FUT;
    cfop4Type = new Integer[]{5116, 5117, 6116, 6117};
    cfop3Type = new Integer[]{511, 512, 611, 612};
    unidadeFixa = false;
    tipoTransacao = operationType.getValue();
    tax1 = "T";
    tax2 = "T";
    codigoInterno = "T59";
    tipoNota = InvoiceType.SAIDA;
    recursivoUPC = false;
    returnCode = "S99";
    codigoDocumento = "S5";
    finalizaPedido = false;
    condicaoPagamento = false;
    cilindroPP = false;

    codigoMensagens = new String[]{
      ConstantsEnum.E.getValue(),
      ConstantsEnum.K.getValue(),
      ConstantsEnum.Z.getValue()
    };

    imprimeIcmsRodape = true;
    loadType = LoadType.CHEIO;


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
    return new Fut();
  }


}
