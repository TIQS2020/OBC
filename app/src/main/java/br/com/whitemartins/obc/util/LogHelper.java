package br.com.whitemartins.obc.util;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import br.com.whitemartins.obc.dao.RouteDao;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.views.DatabaseApp;

public class LogHelper {
  private static Logger log = Logger.getLogger("LogHelper");
  private static LogHelper _self;
  private final File file;
  private File dir;

  private LogHelper() {
    final String FILE_NAME = "obclog.txt";
    this.dir = new File(PathHelper.self().getFilePathLog());
    this.file = new File(this.dir, FILE_NAME);
    if (!this.dir.exists()) {
      this.dir.mkdirs();
    }
  }

  public static LogHelper self() {
    if (_self == null)
      _self = new LogHelper();

    return _self;
  }

  public void infoErro(String TAG, String message) {
    SimpleDateFormat format = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue(),
        Locale.getDefault());
    String currentDateTimeString = format.format(new Date());

    try {

      BufferedWriter buf = new BufferedWriter(new FileWriter(this.file, true));
      buf.append(String.format("[ERRO V:%s] %s: %s - %s",
          GLOBAL.self().getVersao(), currentDateTimeString, TAG, message));
      buf.newLine();
      buf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void info(String message) {
    SimpleDateFormat format = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue(),
        Locale.getDefault());
    String currentDateTimeString = format.format(new Date());

    try {

      Log.d("", message);

      String dataViagemM = "";
      if (GLOBAL.self().getRoute() != null)
        dataViagemM = UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
            ConstantsEnum.ddMMyyyy_barra.getValue());

      String dataViagemDB = "";
      if (DatabaseApp.self().getDatabase().routeDao().getRoute() != null)
        dataViagemDB = UtilHelper.formatDateStr(DatabaseApp.self().getDatabase().routeDao()
            .getRoute().getDataViagem(), ConstantsEnum.ddMMyyyy_barra.getValue());

      BufferedWriter buf = new BufferedWriter(new FileWriter(this.file, true));
      buf.append(String.format("[INFO V:%s] %s: %s (Memoria: %s Banco: %s)",
          GLOBAL.self().getVersao(), currentDateTimeString, message,
          dataViagemM, dataViagemDB));
      buf.newLine();
      buf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void info(String TAG, String message) {
    SimpleDateFormat format = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue(),
        Locale.getDefault());

    String currentDateTimeString = format.format(new Date());

    try {

      Log.d(TAG, message);

      String dataViagemM = "";
      if (GLOBAL.self().getRoute() != null)
        dataViagemM = UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
            ConstantsEnum.ddMMyyyy_barra.getValue());

      String dataViagemDB = "";
      if (DatabaseApp.self().getDatabase().routeDao().getRoute() != null)
        dataViagemDB = UtilHelper.formatDateStr(DatabaseApp.self().getDatabase().routeDao()
            .getRoute().getDataViagem(), ConstantsEnum.ddMMyyyy_barra.getValue());


      BufferedWriter buf = new BufferedWriter(new FileWriter(this.file, true));
      buf.append(String.format("[INFO V:%s] %s: %s %s (Memoria: %s Banco: %s)",
          GLOBAL.self().getVersao(), currentDateTimeString, TAG, message,
          dataViagemM, dataViagemDB));

      buf.newLine();
      buf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void error(String TAG, String message) {
    SimpleDateFormat format = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue(),
        Locale.getDefault());
    String currentDateTimeString = format.format(new Date());

    try {
      Log.e(TAG, message);

      String dataViagemM = "";
      if (GLOBAL.self().getRoute() != null)
        dataViagemM = UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
            ConstantsEnum.ddMMyyyy_barra.getValue());

      String dataViagemDB = "";
      if (DatabaseApp.self().getDatabase().routeDao().getRoute() != null)
        dataViagemDB = UtilHelper.formatDateStr(DatabaseApp.self().getDatabase().routeDao()
            .getRoute().getDataViagem(), ConstantsEnum.ddMMyyyy_barra.getValue());

      BufferedWriter buf = new BufferedWriter(new FileWriter(this.file, true));
      buf.append(String.format("[ERRO V:%s] %s: %s %s (Memoria: %s Banco: %s)",
          GLOBAL.self().getVersao(), currentDateTimeString, TAG, message,
          dataViagemM, dataViagemDB));

      buf.newLine();
      buf.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void error(String TAG, Throwable e) {

    SimpleDateFormat format = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue(),
        Locale.getDefault());
    String currentDateTimeString = format.format(new Date());

    try {
      StringWriter errors = new StringWriter();
      e.printStackTrace(new PrintWriter(errors));
      Log.e(TAG, errors.toString());

      String dataViagemM = "";
      if (GLOBAL.self().getRoute() != null)
        dataViagemM = UtilHelper.formatDateStr(GLOBAL.self().getRoute().getDataViagem(),
            ConstantsEnum.ddMMyyyy_barra.getValue());

      String dataViagemDB = "";
      if (DatabaseApp.self().getDatabase().routeDao().getRoute() != null)
        dataViagemDB = UtilHelper.formatDateStr(DatabaseApp.self().getDatabase().routeDao()
            .getRoute().getDataViagem(), ConstantsEnum.ddMMyyyy_barra.getValue());

      BufferedWriter buf = new BufferedWriter(new FileWriter(this.file, true));
      buf.append(String.format("[ERRO V:%s] %s: %s %s (Memoria: %s Banco: %s)",
          GLOBAL.self().getVersao(), currentDateTimeString, TAG, errors.toString(),
          dataViagemM, dataViagemDB));

      buf.newLine();
      buf.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public void clear() {
    if (this.file.exists())
      this.file.delete();
  }
}
