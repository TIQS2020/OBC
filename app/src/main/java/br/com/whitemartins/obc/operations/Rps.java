package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;

public class Rps extends SuperOperation {

  public Rps() {
    //Definindo os CFOPs de Rps
    operationType =  OperationType.RPS;
    cfop4Type = new Integer[]{5949, 5949, 6949, 6949};
    cfop3Type = new Integer[]{599, 599, 699, 699};
    unidadeFixa = false;
    tipoTransacao = operationType.getValue();
    tax1 = "T";
    tax2 = "T";
    codigoInterno = "T65";
    tipoNota = InvoiceType.SAIDA;
    recursivoUPC = false;
    returnCode = "R";
    codigoDocumento = "S2/VT";
    finalizaPedido = false;
    codigoMensagens = new String[]{
      ConstantsEnum.K.getValue()
    };
    imprimeIcmsRodape = false;
    loadType = LoadType.CHEIO;

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
    return new Rps();
  }

}
