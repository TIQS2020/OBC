package br.com.whitemartins.obc.util;

import android.app.Activity;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.MockRecord;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.views.ConfirmTravelDataActivity;
import br.com.whitemartins.obc.views.DatabaseApp;
import br.com.whitemartins.obc.views.LoadTravelActivity;

import static java.util.Locale.getDefault;

public class FileHelper extends AsyncTask<Void, Integer, String> {
  public static FileHelper _self;
  private Activity activity;
  private ProgressBar pbar1;
  private TextView textProgress;
  private String targetDirectory;
  private String pText = "";
  private boolean error = false;
  private String msg = "";
  private OptionType optionType;


  private MyCallbackInterface.CallbackBooleanInterface postExecuteCallback;

  public static FileHelper self(Activity activity) {
    _self = new FileHelper();
    _self.activity = activity;
    return _self;
  }

  public static File saveFile(String content, String fileName) throws IOException {
    FileOutputStream outputStream = null;
    File outputFile;

    try {
      outputFile = new File(fileName);
      outputStream = new FileOutputStream(outputFile);
      outputStream.write(content.getBytes());

    } finally {
      outputStream.flush();
      outputStream.close();
    }

    return outputFile;
  }

  public FileHelper setPostExecuteCallback(MyCallbackInterface.CallbackBooleanInterface postExecuteCallback) {
    this.postExecuteCallback = postExecuteCallback;
    return this;
  }

  public FileHelper setOptionType(OptionType optionType) {
    this.optionType = optionType;
    return this;
  }

  public FileHelper setActivity(Activity activity) {
    this.activity = activity;
    return this;
  }

  public FileHelper setProgressbar(ProgressBar pbar1) {
    this.pbar1 = pbar1;
    return this;
  }

  public FileHelper setTargetDirectory(String targetDirectory) {
    this.targetDirectory = targetDirectory;
    return this;
  }

  public FileHelper setTextProgress(TextView textProgress) {
    this.textProgress = textProgress;
    return this;
  }

  private void deleteAllTables() {
    MockRecord record = null;
    int total = 0;

    if (pbar1 != null) {
      pbar1.setProgress(0);
      pbar1.setMax(FileModelMap.self().getFileModelMapClassList().size());
    }

    for (FileModelMap.FileModelMapClass fileModelMap : FileModelMap.self().getFileModelMapClassList()) {
      try {
        Class<MockRecord> klass = fileModelMap.getKlass();
        record = klass.newInstance();

        if (klass != null && record != null) {
          pText = String.format(getDefault(), activity.getString(R.string.apagando_tabela),
              record.getClass().getSimpleName());

          record.deleteAll();
        }
        publishProgress(++total);

        LogHelper.self().info(String.format(
            activity.getString(R.string.tabela_finalizado_sucesso), fileModelMap.getFileName()));

        GLOBAL.self().setGeneral(null);
        GLOBAL.self().setRoute(null);

      } catch (Exception e) {
        error = true;

        String erro_text = String.format(getDefault(),
            activity.getString(R.string.tabela_finalizado_erro),
            record.getClass().getSimpleName(), Arrays.toString(e.getStackTrace()));

        LogHelper.self().error("FileHelper", erro_text);
        e.printStackTrace();

        this.msg = erro_text;

        cancel(true);
      }
    }
    resetSequences();
  }

  private void resetSequences() {
    SupportSQLiteDatabase supportSQLiteDatabase = DatabaseApp.self().getDatabase().getOpenHelper()
        .getWritableDatabase();

    SqliteHelper db = SqliteHelper.self(activity);

    db.resetAutoIncrement(supportSQLiteDatabase, "Tax", 0);
    db.resetAutoIncrement(supportSQLiteDatabase, "Code", 0);
    db.resetAutoIncrement(supportSQLiteDatabase, "Search", 0);
    db.resetAutoIncrement(supportSQLiteDatabase, "Invoice", 0);
    db.resetAutoIncrement(supportSQLiteDatabase, "Message", 0);
    db.resetAutoIncrement(supportSQLiteDatabase, "Rastreabilidade", 0);
  }

  private boolean readFile(String targetDirectory) {
    String line = "";
    MockRecord record = null;
    int total = 0;

    for (FileModelMap.FileModelMapClass fileModelMap : FileModelMap.self().getFileModelMapClassList()) {
      try {
        File file = new File(targetDirectory + "/" + fileModelMap.getFileName());
        if (!file.exists()) {
          throw new FileNotFoundException(String.format(
              activity.getString(R.string.arquivo_nao_encontrado), fileModelMap.getFileName()));
        }

        Class klass = fileModelMap.getKlass();
        record = (MockRecord) klass.newInstance();

        if (klass != null && record != null)
          record.deleteAll();

        //Somente tabelas que são populadas pelo processo de carga
        if (!fileModelMap.getFileName().isEmpty()) {
          FileInputStream fis = new FileInputStream(targetDirectory + "/" +
              fileModelMap.getFileName());

          BufferedReader bufferedReader = new BufferedReader(
              new InputStreamReader(fis,
                  activity.getString(R.string.app_file_encoding)));

          BufferedReader fileLines = new BufferedReader(
              new FileReader(targetDirectory + "/" + fileModelMap.getFileName()));

          java.io.LineNumberReader lineNumberReader = new java.io.LineNumberReader(fileLines);
          lineNumberReader.skip(Long.MAX_VALUE);
          int count_lines = lineNumberReader.getLineNumber();

          if (pbar1 != null) {
            pbar1.setProgress(0);
            pbar1.setMax(count_lines);
          }

          total = 0;

          while ((line = bufferedReader.readLine()) != null) {
            ++total;
            publishProgress(total);
            record.parseLine(line);
            record.save();

            pText = String.format(getDefault(), activity.getString(R.string.ler_arquivo_carga),
                fileModelMap.getFileName(), total, pbar1.getMax());
          }

          LogHelper.self().info(String.format(
              activity.getString(R.string.arquivo_finalizado_sucesso), fileModelMap.getFileName()));

          record = null;
          bufferedReader.close();
          fileLines.close();
        }
      } catch (Exception e) {
        error = true;

        LogHelper.self().error("FileHelper", e);
        e.printStackTrace();

        this.msg = String.format(getDefault(), activity.getString(R.string.charge_file_error),
            fileModelMap.getFileName(), total);
        return false;
      }
    }
    return true;
  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    if (pbar1 != null)
      pbar1.setProgress(values[0]);

    if (textProgress != null)
      textProgress.setText(pText);

    super.onProgressUpdate(values);
  }

  @RequiresApi(api = Build.VERSION_CODES.N)
  @Override
  protected String doInBackground(Void... voids) {
    try {
      if (optionType.equals(OptionType.APAGAR_BASE)) {
        deleteAllTables();
      } else if (optionType.equals(OptionType.CRIAR_BASE)) {
        if (readFile(targetDirectory))
          processTripsFile();

        if (!error)
          return activity.getBaseContext().getString(R.string.end_success);
        else
          return activity.getBaseContext().getString(R.string.end_error);
      }
    } catch (Exception e) {
      error = true;
      return activity.getBaseContext().getString(R.string.end_error);
    }
    return "";
  }

  private void processTripsFile() {
    Travel travel = DatabaseApp.self().getDatabase().travelDao().findNext();

    if (travel != null) {
      String dataStr = UtilHelper.formatDateStr(travel.getDataViagem(),
          ConstantsEnum.ddMMyyyy.getValue());

      travel.setDataViagem(UtilHelper.convertToDate(dataStr, ConstantsEnum.ddMMyyyy.getValue()));

      travel.setIndViagemUsada(ConstantsEnum.YES.getValue());
      travel.setDataViagem(UtilHelper.sumHoursToDate(travel.getDataViagem(), 12));
      travel.save();
    }

    GLOBAL.self().sum12HourRoute();
  }

  @Override
  protected void onPostExecute(String s) {
    if (pbar1 != null)
      pbar1.setProgress(0);

    if (textProgress != null)
      textProgress.setText(s);

    if (postExecuteCallback != null)
      postExecuteCallback.execute(!error);
    else {
      if (optionType.equals(OptionType.CRIAR_BASE)) {
        if (!error) {
          activity.startActivity(new Intent(activity, ConfirmTravelDataActivity.class));
        } else
          DialogHelper.showErrorMessage(activity,
              activity.getString(R.string.erro_text), msg, null);
      } else if (optionType.equals(OptionType.APAGAR_BASE)) {
        activity.startActivity(new Intent(activity, LoadTravelActivity.class));
      }

      //PathHelper.self().clearPaths();
    }
  }

  public File saveFile(InputStream input, String fileName) throws IOException {
    FileOutputStream outputStream = null;
    File outputFile = null;

    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      dbf.setNamespaceAware(false);
      dbf.setValidating(false);
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document document = db.parse(input);

      String xml = document.getDocumentElement().getElementsByTagName("conteudoConsulta")
          .item(0).getFirstChild().getNodeValue();

      outputFile = new File(fileName);
      outputStream = new FileOutputStream(outputFile);
      outputStream.write(xml.getBytes());

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } finally {
      outputStream.flush();
      outputStream.close();
//      input.close();
    }
    return outputFile;
  }
}
