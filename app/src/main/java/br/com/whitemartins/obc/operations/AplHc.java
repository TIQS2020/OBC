package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.LoadType;
import br.com.whitemartins.obc.enumeration.OperationType;

public class AplHc extends Apl {

 public AplHc()
 {
   super();
   loadType = LoadType.CHEIO;
   operationType = OperationType.APLHC;
   tipoTransacao = operationType.getValue();
 }

  public static SuperOperation newInstance() {
    return new AplHc();
  }
}
