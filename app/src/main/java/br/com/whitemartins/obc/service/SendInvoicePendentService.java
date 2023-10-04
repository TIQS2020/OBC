package br.com.whitemartins.obc.service;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.SevereErrorsType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.util.LogHelper;

public class SendInvoicePendentService extends SendInvoiceService {

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = true;

    if (invoice.getStatus().equals(StatusNFeType.PENDENTE_ENVIO.getValue()))
      r = send(getRightSendXml());

    if (r)
      r = consult(getRightConsultXml());

    return r;
  }

  @Override
  protected boolean validarStatus() {
    // :TODO:
    // Usado para validação da contigencia de fim de vigem
    // RETIRAR ESSA LINHA
//    if (BuildConfig.DEBUG) {
//      invoice.setStatusContingencia(ConstantsEnum.SIM.getValue());
//    }

    if (invoice.isFinalStatus() || SevereErrorsType.isSevereStatus(invoice.getStatusGravacaoJde())) {
      LogHelper.self().info(TAG, "Salvando nota fiscal: " + invoice.toString());
      return true;
    } else {
      LogHelper.self().info(TAG, "Validando nota em contingência: " + invoice.toString());

      return ConstantsEnum.SIM.getValue().equals(invoice.getStatusContingencia());
    }
  }
}
