package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;

public class Trf extends SuperOperation {

  public Trf() {
    //Definindo os CFOPs de Trc
    operationType =  OperationType.TRF;
    cfop4Type = new Integer[]{5151, 5152, 6151, 6152};
    cfop3Type = new Integer[]{521, 522, 621, 622};
    unidadeFixa = false;
    tipoTransacao = operationType.getValue();
    tax1 = "T";
    tax2 = "T";
    codigoInterno = "T55";
    tipoNota = InvoiceType.SAIDA;
    recursivoUPC = false;
    permiteNegativo = false;
    returnCode = "O";
    codigoDocumento = "ST/VT";
    finalizaPedido = false;
    codigoMensagens = new String[]{
      ConstantsEnum.F.getValue(),
      ConstantsEnum.K.getValue()
    };

    imprimeIcmsRodape = false;
    loadType = LoadType.CHEIO;
  }

  public static SuperOperation newInstance() {
    return new Trf();
  }

}
