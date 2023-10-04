package br.com.whitemartins.obc.service;

import android.app.ProgressDialog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.HttpMethodType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.ConnectionHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlAtivacao;
import br.com.whitemartins.obc.xml.XmlRetorno;

public class TokenService extends BaseService {

  private String activationCode = "";
  private ProgressDialog progressDialog;
  private MyCallbackInterface.CallbackStringInterface postExecuteCallback;

  public TokenService setActivationCode(String activationCode) {
    this.activationCode = activationCode;
    return this;
  }

  public TokenService setPostExecuteCallback(MyCallbackInterface.CallbackStringInterface postExecuteCallback) {
    this.postExecuteCallback = postExecuteCallback;
    return this;
  }

  @Override
  protected ActionType getActionTypeSend() {
    return ActionType.ATIVAR;
  }

  @Override
  protected ActionType getActionTypeConsult() {
    return ActionType.ATIVAR;
  }

  @Override
  protected boolean doPostConsult(String xml) {
    return true;
  }

  @Override
  protected void showExceptionMessage() {

  }

  @Override
  protected boolean doPostSend() {
    return true;
  }

  @Override
  protected boolean send(String xml) {

    InputStream input = null;
    FileOutputStream output = null;
    HttpURLConnection connection = null;

    try {
      String url = String.format(Locale.getDefault(), HTTP_URL_TOKEN, GLOBAL.self().getImei(),
        activationCode);

      connection = ConnectionHelper.self().getHttpConn( url, HttpMethodType.POST.getValue(),
        true);

      if (connection == null)
        throw new Throwable(activity.get().getString(R.string.internet_conn_error));

      if (connection.getResponseCode() != HttpURLConnection.HTTP_OK)
        return false;

      updateProgressMessage(R.string.ativando_imei);
      input = connection.getInputStream();

      XmlRetorno.self().clearFields();
      XmlRetorno.self().parseXML(connection.getInputStream());

      if (XmlRetorno.self().getCodigoRetorno() > 0)
        throw new Throwable(XmlRetorno.self().getMensagemRetorno());

      XmlAtivacao xmlAtivacao = (XmlAtivacao) XmlAtivacao.newInstance()
        .read(XmlRetorno.self().getConteudoConsulta());
      xmlAtivacao.saveFile();

      //Salvando a semente no banco de dados
      GLOBAL.self().getStaticTable().setSemente(xmlAtivacao.getSemente());
      GLOBAL.self().getStaticTable().save();
    } catch (Throwable e) {
      return doPostException(e);
    } finally {
      try {
        if (input != null)
          input.close();
      } catch (IOException ignored) {
      }

      if (connection != null)
        connection.disconnect();
    }

    return true;
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();

    progressDialog = UtilHelper.ProgressDialogInstance(activity.get());
    progressDialog.setTitle(R.string.ativando_titulo);
    progressDialog.setMessage("Ativando..");
    progressDialog.setIndeterminate(false);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    progressDialog.show();
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = false;

    try {
      r = send("");
    } catch (Exception throwable) {
      doPostException(throwable);
      throwable.printStackTrace();
    }

    return r;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    progressDialog.dismiss();

    String erro = "";

    if (exception != null)
      erro = exception.getMessage();

    if (postExecuteCallback != null)
      postExecuteCallback.execute(erro);
  }
}
