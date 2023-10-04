package br.com.whitemartins.obc.service;

import android.app.ProgressDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ActionType;
import br.com.whitemartins.obc.enumeration.HttpMethodType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.ConnectionHelper;
import br.com.whitemartins.obc.util.Constants;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.PathHelper;
import br.com.whitemartins.obc.util.SeedHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;

public class UpgradeService extends BaseService {

  private List<String> files = new ArrayList<>();
  private ProgressDialog progressDialog;
  private MyCallbackInterface.CallbackBooleanInterface postExecuteCallback;
  private String version;

  public UpgradeService setFiles(List<String> files) {
    this.files = files;
    return this;
  }

  public UpgradeService setVersion(String version) {
    this.version = version;
    return this;
  }

  public UpgradeService setPostExecuteCallback(MyCallbackInterface.CallbackBooleanInterface
                                                 postExecuteCallback) {
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
  protected void onProgressUpdate(String... values) {
    progressDialog.setProgress(UtilHelper.convertToIntegerDef(values[0], 0));

    if (values.length > 1)
      progressDialog.setMessage(values[1]);

    super.onProgressUpdate(values);
  }


  @Override
  protected void initProgressBar(int max) {
    progressDialog.setProgress(0);
    progressDialog.setMax(max);
  }

  @Override
  protected boolean send(String fileName) {

    InputStream input = null;
    FileOutputStream output = null;
    HttpURLConnection connection = null;

    try {
      if (fileName.isEmpty())
        fileName = Constants.OBC_NET_UPDATE;

      publishProgress("0", String.format(activity.get().getString(R.string.current_file),
        fileName));

      //{arquivo}/{extensao}/{versao}/{imei}

      String url = String.format(HTTP_URL_UPGRADE, fileName, GLOBAL.self().getImei());

      LogHelper.self().info(TAG, url);

      if (!version.isEmpty())
        url = String.format(HTTP_URL_FILES, fileName.split("\\.")[0],
          fileName.split("\\.")[1], version, GLOBAL.self().getImei());

      connection = ConnectionHelper.self().getHttpConn(url, HttpMethodType.GET.getValue(),
        false);

      String token = SeedHelper.getToken(activity.get());
      connection.setRequestProperty("token", token);
      connection.connect();

      int resCode = connection.getResponseCode();

      if (resCode != HttpURLConnection.HTTP_OK) {
        changeUrlService(XmlConfig.self().getUrlServidorContingencia());
        url = String.format(HTTP_URL_UPGRADE, fileName, GLOBAL.self().getImei());

        connection = ConnectionHelper.self().getHttpConn(url, HttpMethodType.GET.getValue(),
          false);

        token = SeedHelper.getToken(activity.get());
        connection.setRequestProperty("token", token);
        connection.connect();
      }

      resCode = connection.getResponseCode();

      if (resCode != HttpURLConnection.HTTP_OK)
        throw new Throwable(activity.get().getString(R.string.internet_conn_error));

//      if (resCode != HttpURLConnection.HTTP_OK)
//        throw new Throwable(activity.get().getString(R.string.file_not_found_error));

      input = connection.getInputStream();

      int fileLength = connection.getContentLength();

      initProgressBar(fileLength);

      input = connection.getInputStream();

      String PATH = PathHelper.self().getFilePathDownload();
      File file = new File(PATH);
      File outputFile = new File(file, fileName);
      output = new FileOutputStream(outputFile);

      byte data[] = new byte[4096];
      long total = 0L;
      int count;
      while ((count = input.read(data)) != -1) {
        if (isCancelled()) {
          input.close();
          return false;
        }
        total += count;
        if (fileLength > 0)
          publishProgress(Long.toString(total), String.format(this.activity.get()
            .getString(R.string.current_file), fileName));

        output.write(data, 0, count);
      }

    } catch (Throwable e) {
      return doPostException(e);
    } finally {
      try {
        if (output != null)
          output.close();
        if (input != null)
          input.close();
      } catch (IOException ignored) {
        LogHelper.self().error(TAG, ignored);
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
    progressDialog.setTitle(R.string.update_titulo);
    progressDialog.setMessage(activity.get().getString(R.string.prepare_download));
    progressDialog.setCancelable(false);
    progressDialog.setIndeterminate(false);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    progressDialog.setProgress(0);
    progressDialog.show();
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = false;

    try {
      if (files.size() == 0)
        r = send("");
      else
        for (String file : files) {
          r = send(file);
          if (!r)
            break;
        }

    } catch (Exception throwable) {
      doPostException(throwable);
      throwable.printStackTrace();
    }

    return r;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (progressDialog.isShowing())
      progressDialog.dismiss();

    if (postExecuteCallback != null)
      postExecuteCallback.execute(success);
  }
}
