package br.com.whitemartins.obc.service;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.WantedClient;
import br.com.whitemartins.obc.model.sync.NotasFiscais;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.xml.XmlRetorno;
import br.com.whitemartins.obc.xml.XmlSincronismo;
import br.com.whitemartins.obc.xml.XmlSincronismoRetorno;

public class SyncService extends BaseService {

  List<WantedClient> cdCustomers = new ArrayList<>();

  private XmlSincronismo xmlSincronismo = XmlSincronismo.newInstance();
  private XmlSincronismoRetorno xmlSincronismoRetorno = XmlSincronismoRetorno.newInstance();

  private MyCallbackInterface.CallbackStringInterface finishExecuteCallback;
  private MyCallbackInterface.CallbackWantedClientsInterface finishWantedClientCallback;
  private MyCallbackInterface.CallbackListInterface syncInvoincesInterface;

  public SyncService setFinishExecuteCallback(MyCallbackInterface.CallbackStringInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public SyncService setFinishWantedClientCallback(MyCallbackInterface.CallbackWantedClientsInterface finishWantedClientCallback) {
    this.finishWantedClientCallback = finishWantedClientCallback;
    return this;
  }

  public SyncService setSyncInvoincesInterface(MyCallbackInterface.CallbackListInterface syncInvoincesInterface) {
    this.syncInvoincesInterface = syncInvoincesInterface;
    return this;
  }

  public SyncService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = false;

    try {
      r = send(xmlSincronismo.serialize());
    } catch (Exception throwable) {
      throwable.printStackTrace();
    }

    return r;
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.SINCRONIZAR_VIAGEM;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.SINCRONIZAR_VIAGEM;
  }

  @Override
  protected boolean doPostConsult(String is) {
    return true;
  }

  @Override
  protected boolean doPostSend() throws Exception {
    try {
      xmlSincronismoRetorno = (XmlSincronismoRetorno) xmlSincronismoRetorno
        .read(XmlRetorno.self().getConteudoConsulta());
      xmlSincronismoRetorno.saveFile();

      for (NotasFiscais notas : xmlSincronismoRetorno.getNotasFiscais()) {
        notas.getCabecalhoNFe().setNumeroViagem(xmlSincronismoRetorno.getNumeroViagem());
        notas.getCabecalhoNFe().setDataViagem(xmlSincronismoRetorno.getDataViagem());
      }

      if (!xmlSincronismoRetorno.getStatus().isEmpty())
        return doPostException(new Throwable(xmlSincronismoRetorno.getStatus()));
      else {
        if (cdCustomers.size() == 0)
          if (syncInvoincesInterface != null)
            syncInvoincesInterface.execute(xmlSincronismoRetorno.getNotasFiscais());
      }
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
      return false;
    }

    return true;
  }

  @Override
  protected void showExceptionMessage() {

  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (success) {
      cdCustomers = xmlSincronismoRetorno.validateCustomer();

      if (cdCustomers.size() > 0) {
        if (finishWantedClientCallback != null)
          finishWantedClientCallback.execute(cdCustomers);
      } else if (finishExecuteCallback != null)
        finishExecuteCallback.execute(xmlSincronismoRetorno.getStatus());
    } else {
      if (exception != null)
        if (finishExecuteCallback != null)
          finishExecuteCallback.execute(exception.getMessage());
    }
  }
}
