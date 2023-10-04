package br.com.whitemartins.obc.service;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.net.ssl.SSLException;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.HttpMethodType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.util.ConnectionHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.SeedHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;
import br.com.whitemartins.obc.xml.XmlRetorno;

public abstract class BaseService extends AsyncTask<Void, String, Boolean> {

  protected final String TAG = this.getClass().getSimpleName();
  final String HTTP_CONTENT_TYPE = "text/plain";
  protected HttpURLConnection connection = null;
  protected WeakReference<Activity> activity;
  protected Throwable exception = null;
  String HOST = XmlConfig.self().getUrlServidorNFe();
  String HTTP_URL_TOKEN = HOST + "api/service/ativarUsuario/%s/%s";
  String HTTP_URL_UPGRADE = HOST + "api/service/download/upgrade/%s/%s"; //{arquivo}/{imei}
  String HTTP_URL_FILES = HOST + "api/service/download/android/%s/%s/%s/%s"; //{arquivo}/{extensao}/{versao}/{imei}
  String HTTP_URL_LOAD = HOST + "api/service/download/%s/%s/%s/%s/%s"; //{filial}/{veiculo}/{arquivo}/{extensao}/{imei}
  String HTTP_URL_SERVICE = HOST + "api/service/solicitacao/%s";
  private TextView txtStatus;
  private ProgressBar pBarStatus;
  private int tentativas = 3;

  public BaseService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }

  public BaseService setTxtStatus(TextView txtStatus) {
    this.txtStatus = txtStatus;
    return this;
  }

  public BaseService setpBarStatus(ProgressBar pBarStatus) {
    this.pBarStatus = pBarStatus;
    return this;
  }

  void setTextStatus(String text) {
    if (txtStatus != null)
      txtStatus.setText(text);
  }

  protected void setProgress(int progress) {
    if (pBarStatus != null)
      pBarStatus.setProgress(progress);
  }

  protected void initProgressBar(int max) {
    if (pBarStatus != null) {
      pBarStatus.setMax(max);
      pBarStatus.setProgress(0);
    }
  }

  protected void changeUrlService(String host) {
    HOST = host;
    HTTP_URL_TOKEN = HOST + "api/service/ativarUsuario/%s/%s";
    HTTP_URL_UPGRADE = HOST + "api/service/download/upgrade/%s/%s"; //{arquivo}/{imei}
    HTTP_URL_FILES = HOST + "api/service/download/android/%s/%s/%s/%s"; //{arquivo}/{extensao}/{versao}/{imei}
    HTTP_URL_LOAD = HOST + "api/service/download/%s/%s/%s/%s/%s"; //{filial}/{veiculo}/{arquivo}/{extensao}/{imei}
    HTTP_URL_SERVICE = HOST + "api/service/solicitacao/%s";
  }

  protected void writeOnHeader(String token, ActionType actionType) {
    connection.setDoInput(true);
    connection.setDoOutput(true);
    connection.setRequestProperty("token", token);
    connection.setRequestProperty("Content-Type", HTTP_CONTENT_TYPE);
    connection.setRequestProperty("tipoOperacao", actionType.getHttpOperationType());
    connection.setRequestProperty("operacao", actionType.getLineName());
  }

  protected void writeOnBody(String value) throws IOException {
    OutputStream os = connection.getOutputStream();
    OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8.name());
    osw.write(value);
    osw.flush();
    osw.close();
    os.close();
  }

  void updateProgressMessage(final String message) {
    if (txtStatus != null)
      activity.get().runOnUiThread(new Runnable() {
        @Override
        public void run() {
          txtStatus.setText(message);
        }
      });
  }

  void updateProgressMessage(final int idMessage) {
    updateProgressMessage(activity.get().getString(idMessage));
  }

  protected String getProgressMsg1() {
    return "Conectando...";
  }

  protected String getProgressMsg2() {
    return "Enviando...";
  }

  protected String getProgressMsg3() {
    return "Enviado...";
  }

  protected abstract ActionType getActionTypeSend();

  protected abstract ActionType getActionTypeConsult();

  protected abstract boolean doPostConsult(String xml) throws Throwable;

  protected abstract boolean doPostSend() throws Exception;

  protected abstract void showExceptionMessage();

  boolean doPostException(Throwable e) {
    if (e instanceof SocketTimeoutException)
      e = new Throwable("Tempo de conexão excedido. \nverifique a conexão com a internet!");

    if (e instanceof SSLException || e instanceof ConnectException)
      e = new Throwable("Conexão perdida. \nVerifique a conexão com a internet!");

    this.exception = e;
    LogHelper.self().error(TAG, this.exception);

    return false;
  }

  @Override
  protected void onProgressUpdate(String... values) {
    setTextStatus(values[0]);
    setProgress(UtilHelper.convertToIntegerDef(values[0], 0));
    super.onProgressUpdate(values);
  }

  protected HttpURLConnection tryConnect(String xml, ActionType actionType, int tentativas) throws Throwable {
    int times = 0;
    connection = null;
    XmlRetorno.self().clearFields();

    do {

      String token = SeedHelper.getToken(activity.get());
      String imei = GLOBAL.self().getImei();
      String url = String.format(Locale.getDefault(), HTTP_URL_SERVICE, imei);

      connection = ConnectionHelper.self().getHttpConn(url, HttpMethodType.POST.getValue(),
        false);

      if (connection != null) {
        writeOnHeader(token, actionType);
        writeOnBody(xml);

        connection.connect();

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
          XmlRetorno.self().clearFields();
          XmlRetorno.self().parseXML(connection.getInputStream());

          if (XmlRetorno.self().getCodigoRetorno() == 2) {
            times++;
          }
          if (XmlRetorno.self().getCodigoRetorno() == 1) {
            throw new Throwable(XmlRetorno.self().getMensagemRetorno());
          } else if (XmlRetorno.self().getCodigoRetorno() == 0)
            times = ++tentativas;

          LogHelper.self().info(TAG, XmlRetorno.self().getMensagemRetorno());
        } else times++;
      } else
        throw new Throwable(activity.get().getString(R.string.internet_conn_error));
    }
    while (times < tentativas);

    if (XmlRetorno.self().getCodigoRetorno() != 0)
      throw new Throwable(XmlRetorno.self().getMensagemRetorno());

    return connection;
  }

  protected boolean send(String xml) {
    try {
      publishProgress(getProgressMsg1());

      connection = tryConnect(xml, getActionTypeSend(), tentativas);

      if (connection != null) {
        publishProgress(getProgressMsg2());

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
          if (XmlRetorno.self().getCodigoRetorno() > 0)
            throw new Throwable(XmlRetorno.self().getMensagemRetorno());

          publishProgress(getProgressMsg3());

          return doPostSend();
        } else
          throw new Throwable(activity.get().getString(R.string.conn_error));
      } else
        throw new Throwable(activity.get().getString(R.string.conn_error));
    } catch (Throwable e) {
      return doPostException(e);
    } finally {
      if (connection != null)
        connection.disconnect();
    }
  }

  boolean consult(String xml) {
    int times = 0;
    try {

      do {
        connection = tryConnect(xml, getActionTypeConsult(), tentativas);

        if (connection != null) {

          if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            if (XmlRetorno.self().getCodigoRetorno() > 0)
              throw new Throwable(XmlRetorno.self().getMensagemRetorno());

            if (doPostConsult(XmlRetorno.self().getConteudoConsulta())) {
              times = ++tentativas;
              this.finalize();
            } else
              return false;
          } else {
            ++times;

            if (times == tentativas)
              throw new Throwable(activity.get().getString(R.string.conn_error));
          }
        } else {
          ++times;

          if (times == tentativas)
            throw new Throwable(activity.get().getString(R.string.conn_error));
        }
      }
      while (times < tentativas);
    } catch (Throwable e) {
      return doPostException(e);
    } finally {
      if (connection != null)
        connection.disconnect();
    }

    return true;
  }
}
