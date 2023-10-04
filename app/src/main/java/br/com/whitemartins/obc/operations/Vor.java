package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;

public class Vor extends SuperOperation {

  public Vor() {
    //Definindo os CFOPs de Vnd
    operationType = OperationType.VOR;
    cfop4Type = new Integer[]{5923, 5923, 6923, 6923};
    cfop3Type = new Integer[]{599, 599, 699, 699};
    unidadeFixa = false;
    tipoTransacao = operationType.getValue();
    tax1 = "T";
    tax2 = "T";
    codigoInterno = "T51";
    codigoDocumento = "AP/AE";
    tipoNota = InvoiceType.SAIDA;
    recursivoUPC = false;
    returnCode = "T";
    finalizaPedido = false;
    condicaoPagamento = false;
    codigoMensagens = new String[]{
      ConstantsEnum.D.getValue(),
      ConstantsEnum.K.getValue(),
      ConstantsEnum.N.getValue(),
      ConstantsEnum.V.getValue()};

    loadType = LoadType.CHEIO;
    imprimeIcmsRodape = false;

//    "5923", // UF dentro UF - manufaturado
//    "5923", // UF dentro UF - não manufaturado
//    "6923", // UF fora UF - manufaturado
//    "6923", // UF fora UF - não manufaturado
//    "599", // OLD - UF dentro UF - manufaturado
//    "599", // OLD - UF dentro UF - não manufaturado
//    "699", // OLD - UF fora UF - manufaturado    ***** VERIFICAR
//    "699", // OLD - UF fora UF - não manufaturado***** VERIFICAR
  }

  public static SuperOperation newInstance() {
    return new Vor();
  }

}