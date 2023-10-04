package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;

public class Rfh extends SuperOperation {

  public Rfh() {
    //Definindo os CFOPs de Rfh
    operationType = OperationType.RFH;
    cfop4Type = new Integer[]{5923, 5923, 6923, 6923};
    cfop3Type = new Integer[]{599, 599, 699, 699};
    unidadeFixa = false;
    tipoTransacao = operationType.getValue();
    tax1 = "T";
    tax2 = "T";
    codigoInterno = "T67";
    tipoNota = InvoiceType.SAIDA;
    recursivoUPC = false;
    returnCode = "H";
    codigoDocumento = "BU/VT";
    finalizaPedido = false;

    codigoMensagens = new String[]{
      ConstantsEnum.D.getValue(),
      ConstantsEnum.K.getValue(),
      ConstantsEnum.L.getValue()
    };
    
    condicaoPagamento = false;
    loadType = LoadType.CHEIO;
    calculaVolume = true;
    imprimeIcmsRodape = false;
    // "5923", // UF dentro UF - manufaturado
    // "5923", // UF dentro UF - não manufaturado
    // "6923", // UF fora UF - manufaturado
    // "6923", // UF fora UF - não manufaturado
    // "599", // OLD - UF dentro UF - manufaturado
    // "599", // OLD - UF dentro UF - não manufaturado
    // "699", // OLD - UF fora UF - manufaturado
    // "699", // OLD - UF fora UF - não manufaturado
  }

  public static SuperOperation newInstance() {
    return new Rfh();
  }
}
