package br.com.whitemartins.obc.operations;

import br.com.whitemartins.obc.enumeration.OperationType;

public class RclHc extends RclNf {

  public RclHc() {
    super();
//    loadType = LoadType.VAZIO;
    operationType = OperationType.RCLHC;
    tipoTransacao = operationType.getValue();
  }

  public static SuperOperation newInstance() {
    return new RclHc();
  }
}
