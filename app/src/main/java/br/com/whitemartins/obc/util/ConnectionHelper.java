package br.com.whitemartins.obc.util;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.HttpResponse;
import br.com.whitemartins.obc.xml.XmlConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectionHelper extends AsyncTask<List<String>, Integer, Boolean> {

  private static ConnectionHelper _self;
  private MyCallbackInterface.CallbackBooleanInterface postExecuteCallback;
  private OptionType optionType;
  private ProgressDialog progressDialog;
  private TextView txtStatus;
  private String TAG = getClass().getSimpleName();
  private URL _url;

  public ConnectionHelper() {

  }

  public static ConnectionHelper self() {
    if (_self == null)
      _self = new ConnectionHelper();

    return _self;
  }

  public boolean isOnline() {
    return testConn();
  }

  public ConnectionHelper setOptionType(OptionType optionType) {
    this.optionType = optionType;
    return this;
  }

  public ConnectionHelper setTxtStatus(TextView txtStatus) {
    this.txtStatus = txtStatus;
    return this;
  }

  public HttpURLConnection getHttpConn(String sUrl, String requestMethod, Boolean connect) {

    HttpURLConnection connection = getHttpConn(sUrl, requestMethod);

    if (connect) {
      try {
        if (connection != null) {
          connection.connect();

          if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
            return connection;
          else
            return null;
        }
      } catch (IOException e) {
        e.printStackTrace();
//        LogHelper.self().error(TAG, e);
        HttpResponse.self().setDesc(e.getMessage());
      }
    }

    return connection;
  }

  private HttpURLConnection getHttpConn(String sUrl, String requestMethod) {
    HttpURLConnection connection = null;

//    byPassSSLValidation();
    if (!isOnline()) {
      //updateProgressMessage(R.string.internet_conn_error);
      return null;
    }

    try {
      URL url = new URL(sUrl);

      int tempoS = UtilHelper.convertToIntegerDef(XmlConfig.self().getTimeOut2(), 5) * 60;
      int timeout = tempoS * 1000;

      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod(requestMethod);
      connection.setConnectTimeout(timeout);
      connection.setReadTimeout(timeout);

      return connection;
    } catch (IOException e) {
      e.printStackTrace();
//      LogHelper.self().error(TAG, e);
      return null;
    }
  }

  private boolean testConn() {
    try {

      final OkHttpClient client = new OkHttpClient();

      URL url = new URL(XmlConfig.self().getUrlServidorNFe());

      Request request = new Request.Builder()
          .url(url)
          .get()
          .build();

      Response response = client.newCall(request).execute();
      boolean success = response.isSuccessful();

      if (!success) {
        url = new URL(XmlConfig.self().getUrlServidorContingencia());

        request = new Request.Builder()
            .url(url)
            .get()
            .build();

        response = client.newCall(request).execute();
        success = response.isSuccessful();
      }

      return success;


    } catch (IOException e) {
//      LogHelper.self().error(TAG, e);
      e.printStackTrace();
    }

    return false;
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();

    if (this.optionType == null)
      throw new NullPointerException("optionType nulo.");

  }

  @Override
  protected void onPostExecute(Boolean success) {

    try {
      if (progressDialog != null)
        progressDialog.dismiss();

      if (postExecuteCallback != null)
        postExecuteCallback.execute(success);

    } catch (Exception e) {
      e.printStackTrace();
//      LogHelper.self().error(TAG, e);
    }
  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    Integer value = values[0];

    if (progressDialog != null)
      progressDialog.setProgress(value);

    super.onProgressUpdate(value);
  }

  @SafeVarargs
  @Override
  protected final Boolean doInBackground(List<String>... sUrl) {
    if (optionType.equals(OptionType.TESTAR))
      return testConn();

    return true;
  }

  public ConnectionHelper setPostExecuteCallback(MyCallbackInterface.CallbackBooleanInterface postExecuteCallback) {
    this.postExecuteCallback = postExecuteCallback;
    return this;
  }
}
