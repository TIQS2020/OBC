package br.com.whitemartins.obc.service;

import java.io.File;
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
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.PathHelper;
import br.com.whitemartins.obc.util.SeedHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;
import br.com.whitemartins.obc.xml.XmlRetorno;

public class LoadService extends BaseService {

  private String fileName = "";
  private String fileExtension = "";
  private Integer fileLength = 0;

  private MyCallbackInterface.CallbackBooleanInterface postExecuteCallback;

  public LoadService setPostExecuteCallback(MyCallbackInterface.CallbackBooleanInterface postExecuteCallback) {
    this.postExecuteCallback = postExecuteCallback;
    return this;
  }

  public LoadService setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  public LoadService setFileExtension(String fileExtension) {
    this.fileExtension = fileExtension;
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
    String s = "";
    if (exception != null)
      s = exception.getMessage();

    if (!s.isEmpty()) {
      DialogHelper.showErrorMessage(activity.get(),
        activity.get().getString(R.string.erro_text), s, null);
    }
  }

  @Override
  protected boolean doPostSend() throws Exception {
    return true;
  }

  @Override
  protected void onProgressUpdate(String... values) {
    setTextStatus(String.format(Locale.getDefault(), "Baixados: %s bytes de %d bytes",
      values[0], fileLength));
    setProgress(UtilHelper.convertToIntegerDef(values[0], 0));
  }

  @Override
  protected HttpURLConnection tryConnect(String xml, ActionType actionType, int tentativas) throws Throwable {
    int times = 0;
    connection = null;
    XmlRetorno.self().clearFields();

    HOST = XmlConfig.self().getUrlServidorNFe();

    try {
      do {
        String imei = GLOBAL.self().getImei();
        String url = String.format(Locale.getDefault(), HTTP_URL_SERVICE, imei);
        String token = SeedHelper.getToken(activity.get());

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
              times = (tentativas * 2);

            LogHelper.self().info(TAG, XmlRetorno.self().getMensagemRetorno());
          } else times++;
        } else {
          times++;

          if (times == tentativas)
            changeUrlService(XmlConfig.self().getUrlServidorContingencia().trim());

          if (times == (tentativas * 2))
            throw new Throwable(activity.get().getString(R.string.internet_conn_error));
        }
      }
      while (times < (tentativas * 2));
    } catch (Throwable throwable) {
      LogHelper.self().error(TAG, throwable);
      throw new Throwable(activity.get().getString(R.string.internet_conn_error));
    }

    if (XmlRetorno.self().getCodigoRetorno() != 0)
      throw new Throwable(XmlRetorno.self().getMensagemRetorno());

    return connection;
  }

  @Override
  protected boolean send(String fileName) {

    InputStream input = null;
    FileOutputStream output = null;
    HttpURLConnection connection = null;

    try {
      updateProgressMessage(String.format(this.activity.get().getString(R.string.current_file),
        this.fileName));

      String url = String.format(Locale.getDefault(), HTTP_URL_LOAD,
        GLOBAL.self().getStaticTable().getCdFilial(),
        GLOBAL.self().getStaticTable().getCdVeiculo(), fileName, fileExtension,
        GLOBAL.self().getImei());

      connection = ConnectionHelper.self().getHttpConn(url, HttpMethodType.GET.getValue(),
        false);

      String token = SeedHelper.getToken(activity.get());
      connection.setRequestProperty("token", token);
      connection.connect();

      int resCode = connection.getResponseCode();

      if (resCode != HttpURLConnection.HTTP_OK) {
        changeUrlService(XmlConfig.self().getUrlServidorContingencia());

        url = String.format(Locale.getDefault(), HTTP_URL_LOAD,
          GLOBAL.self().getStaticTable().getCdFilial(),
          GLOBAL.self().getStaticTable().getCdVeiculo(), fileName, fileExtension,
          GLOBAL.self().getImei());

        connection = ConnectionHelper.self().getHttpConn(url, HttpMethodType.GET.getValue(),
          false);

        token = SeedHelper.getToken(activity.get());
        connection.setRequestProperty("token", token);
        connection.connect();
      }

      resCode = connection.getResponseCode();

      if (resCode == HttpURLConnection.HTTP_UNAVAILABLE)
        throw new Throwable(activity.get().getString(R.string.file_not_found_error_2));

      if (resCode != HttpURLConnection.HTTP_OK)
        throw new Throwable(activity.get().getString(R.string.internet_conn_error));

      fileLength = connection.getContentLength();

      if (fileLength > 0) {
        initProgressBar(fileLength);

        input = connection.getInputStream();

        String PATH = PathHelper.self().getFilePathDownload();
        File file = new File(PATH);
        file.mkdirs();
        File outputFile = new File(file, this.fileName);
        output = new FileOutputStream(outputFile);

        byte data[] = new byte[4096];
        Long total = 0L;
        int count;
        while ((count = input.read(data)) != -1) {
          if (isCancelled()) {
            input.close();
            return false;
          }
          total += count;
          if (fileLength > 0) // only if total length is known
            publishProgress(total.toString());

          output.write(data, 0, count);
        }
        return doPostSend();
      } else
        throw new Throwable(activity.get().getString(R.string.file_not_found_error));
    } catch (Throwable e) {
      return doPostException(e);
    } finally {
      try {
        if (output != null)
          output.close();
        if (input != null)
          input.close();
      } catch (IOException ignored) {
      }
    }
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
  }

  @Override
  protected Boolean doInBackground(Void... voids) {
    boolean r = false;

    try {
      r = send(fileName);
    } catch (Exception throwable) {
      doPostException(throwable);
      throwable.printStackTrace();
    }

    return r;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (!success) {
      initProgressBar(0);
      showExceptionMessage();
    }

    if (postExecuteCallback != null)
      postExecuteCallback.execute(success);

    //Apos carga da viagem, volta a URL de envio/canclemaneto de notas seja a principal
    changeUrlService(XmlConfig.self().getUrlServidorNFe());

  }
}
