package br.com.whitemartins.obc.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Invoice;

/**
 * Created by Rodolfo on 14/12/2017.
 */

public class UtilHelper {

  public static void hideKeyboardFrom(Activity context, View v) {
    InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    if (v != null)
      imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
  }

  public static ProgressDialog ProgressDialogInstance(Activity activity) {
    ProgressDialog progressDialog = new ProgressDialog(activity, R.style.ProgressBar);
    progressDialog.setCancelable(false);
    return progressDialog;
  }

  @SuppressLint("SimpleDateFormat")
  public static String formatDateStr(Date date, String pattern) {
    if (date == null)
      return "";
//    date = new Date();

    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    return formatter.format(date);
  }

  @SuppressLint("SimpleDateFormat")
  public static String formatDateStr(Object date, String pattern) {
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    return formatter.format(date);
  }

  public static Double formatDouble(Double value, Integer decimals) {
    try {
      return Double.parseDouble(formatDoubleString(value, decimals));
    } catch (Exception e) {
      return value;
    }
  }

  public static Double formatDouble(String value, Integer decimals) {
    try {
      Double v = Double.parseDouble(value);
      return formatDouble(v, decimals);
    } catch (Exception e) {
      return Double.parseDouble(value);
    }
  }

  public static String formatDoubleString(Double value, Integer decimals) {
    try {
      if (value == null)
        value = 0D;

      String decStr = "";

      if (decimals > 0)
        decStr = "." + padLeft(decStr, '0', decimals);

      final String BEGIN_WITH_DOLLAR = "0" + decStr.trim();

      DecimalFormat dFormat = new DecimalFormat(BEGIN_WITH_DOLLAR,
          DecimalFormatSymbols.getInstance(Locale.US));
      dFormat.setRoundingMode(RoundingMode.HALF_UP);

      return dFormat.format(value);
    } catch (Exception e) {
      return value.toString();
    }
  }

  public static Integer convertToIntegerDef(String value, Integer def) {
    try {
      return (int) Float.parseFloat(value);
    } catch (NumberFormatException e) {
      return def;
    }
  }

  public static Long convertToLongDef(String value, Integer def) {
    try {
      return Long.parseLong(value.trim());
    } catch (Exception e) {
      return Long.valueOf(def);
    }
  }

  public static Double convertToDoubleDef(String value, Integer def) {
    try {

      value = value.replace(",", "");

      return Double.parseDouble(value.trim());
    } catch (Exception e) {
      return Double.valueOf(def);
    }
  }

  @SuppressLint("SimpleDateFormat")
  public static Date convertToDate(String value, @Nullable String pattern) {
    Date convertedDate = null;
    try {
      if (pattern == null || pattern.isEmpty())
        convertedDate = new SimpleDateFormat().parse(value);
      else
        convertedDate = new SimpleDateFormat(pattern).parse(value);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return convertedDate;
  }

  @SuppressLint("SimpleDateFormat")
  public static Date currentDateTime(@NonNull String pattern) {
    Date convertedDate = null;
    try {
      DateFormat d = SimpleDateFormat.getDateInstance();

      SimpleDateFormat sdf = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss.getValue(),
          Locale.getDefault());

      if (!pattern.isEmpty())
        sdf = new SimpleDateFormat(pattern);

      convertedDate = sdf.parse(sdf.format(new Date()));

    } catch (Exception e) {
      e.printStackTrace();
    }
    return convertedDate;
  }

  @SuppressLint("SimpleDateFormat")
  static String currentDateTimeString(@NonNull String pattern) {
    String convertedDate = null;
    try {
      DateFormat d = SimpleDateFormat.getDateInstance();

      SimpleDateFormat sdf = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss.getValue(),
          Locale.getDefault());

      if (!pattern.isEmpty())
        sdf = new SimpleDateFormat(pattern);

      convertedDate = sdf.format(new Date());

    } catch (Exception e) {
      e.printStackTrace();
    }
    return convertedDate;
  }

  public static String padLeft(String value, char c, int length) {
    if (value.length() > length)
      value = value.substring(0, length);

    return String.format("%" + length + "s", value).replace(' ', c);
  }

  public static String padRight(String value, char c, int length) {
    if (value.length() > length)
      value = value.substring(0, length);

    return String.format("%-" + length + "s", value).replace(' ', c);
  }

  public static void unzip(File zipFile) throws Throwable {
    ZipInputStream zis = null;
    try {
      zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
      ZipEntry ze;
      int count;
      byte[] buffer = new byte[8192];
      while ((ze = zis.getNextEntry()) != null) {
        File file = new File(zipFile.getParent(), ze.getName());
        File dir = ze.isDirectory() ? file : file.getParentFile();
        if (!dir.isDirectory() && !dir.mkdirs())
          throw new FileNotFoundException("Failed to ensure directory: " +
              dir.getAbsolutePath());
        if (ze.isDirectory())
          continue;
        FileOutputStream fout = new FileOutputStream(file);
        while ((count = zis.read(buffer)) != -1)
          fout.write(buffer, 0, count);
      }
    } catch (FileNotFoundException e) {
      throw new Throwable("Arquivo da viagem não encontrado.");
    } finally {
      if (zis != null)
        zis.close();
    }
  }

  public static String formataCNPJ(String st) {
    String c1_st = st.trim();

    c1_st = c1_st.replace(".", "").replace("/", "");

    while (c1_st.length() < 14) {
      c1_st = "0" + c1_st;
    }

    String c_st = c1_st.substring(0, 2) + "." +
        c1_st.substring(2, 5) + "." +
        c1_st.substring(5, 8) + "/" +
        c1_st.substring(8, 12) + "-" +
        c1_st.substring(12, 14);

    return c_st;
  }


  public static String formataCPF(String st) {
    String p1_st = st.trim();

    p1_st = p1_st.replace(".", "").replace("-", "");

    while (p1_st.length() > 11) {
      p1_st = p1_st.substring(1);
    }

    while (p1_st.length() < 11) {
      p1_st = "0" + p1_st;
    }

    String p_st =
        p1_st.substring(0, 3) + "." +
            p1_st.substring(3, 6) + "." +
            p1_st.substring(6, 9) + "-" +
            p1_st.substring(9, 11);

    return p_st;

  }

  public static void setButtonStatus(Activity activity, ImageButton btn, boolean enable) {
    Drawable d = ContextCompat.getDrawable(activity, R.drawable.roundcorner);

    if (enable) {
      btn.setBackground(null);
      btn.setColorFilter(null);
    } else {
      btn.setBackground(d);
      btn.setColorFilter(activity.getColor(R.color.indicator_unselected));
    }

    btn.setEnabled(enable);
  }


  public static String formatCounterTimeText(long millisUntilFinished) {
    String hms = String.format(Locale.getDefault(), "%02d:%02d",
        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

    return hms;
  }

  public static String capitalize(String capString) {
    StringBuffer capBuffer = new StringBuffer();
    Matcher capMatcher = Pattern.compile("([a-z])([a-z]*)",
        Pattern.CASE_INSENSITIVE).matcher(capString);
    while (capMatcher.find()) {
      capMatcher.appendReplacement(capBuffer, capMatcher.group(1).toUpperCase() +
          capMatcher.group(2).toLowerCase());
    }

    return capMatcher.appendTail(capBuffer).toString();
  }

  public static String getSignFileName(Invoice invoice) {
    return PathHelper.self().getFilePathFiles() +
        String.format(Locale.getDefault(), "%d_%d_a.jpg", invoice.getNumero(),
            invoice.getSerie());
  }

  public static String getCecFileName(Invoice invoice) {
    return PathHelper.self().getFilePathFiles() +
        String.format(Locale.getDefault(), "%d_%d_r.jpg", invoice.getNumero(),
            invoice.getSerie());
  }

  public static String getRetornoConsultaFileName(Invoice invoice) {
    return PathHelper.self().getFilePathDownload() +
        String.format(Locale.getDefault(), "retornoConsulta_%d_%d.xml", invoice.getNumero(),
            invoice.getSerie());
  }

  public static String getInvoiceFileName(Invoice invoice) {
    return PathHelper.self().getFilePathInvoice() +
        String.format(Locale.getDefault(), "%d_%d.xml", invoice.getNumero(),
            invoice.getSerie());
  }

  public static String getCancelFileName(Invoice invoice) {
    return PathHelper.self().getFilePathDownload() +
        String.format(Locale.getDefault(), "retornoCancelamento_%d_%d.xml", invoice.getNumero(),
            invoice.getSerie());
  }


  public static String formataInscEst(String inscEstadual) {
    return inscEstadual;
  }

  public static String insertSpaces(int spaces) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i <= spaces; i++)
      sb.append(' ');

    return sb.toString();

  }

  public static void copyFile(File sourceFile, File destFile) throws IOException {
    FileChannel source = null;
    FileChannel destination = null;

    try {
      source = new FileInputStream(sourceFile).getChannel();
      destination = new FileOutputStream(destFile).getChannel();
      destination.transferFrom(source, 0, source.size());
    } finally {
      if (source != null) {
        source.close();
      }
      if (destination != null) {
        destination.close();
      }
    }
  }

  public static int Module11VOR(String N) {
    if (N.length() <= 0) return -1;

    int y = 2;
    int nDV = 0;
    int temp = 0;
    int size = N.length() - 1;
    for (int x = size; x >= 0; x--) {
      temp = Integer.parseInt(N.substring(x, x + 1));
      nDV += temp * y;
      y++;
      if (y > 9) y = 2;
    }
    int AuxDV = (nDV % 11);
    if (AuxDV == 0 || AuxDV == 1)
      nDV = 0;
    else
      nDV = 11 - AuxDV;

    return nDV;
  }

  public static void saveFile(String input, String fileName) throws IOException {
    FileOutputStream outputStream = null;
    File outputFile = null;
    try {
      File dir = new File(fileName);
//      outputFile = new File(dir, fileName);
      outputStream = new FileOutputStream(dir);
      outputStream.write(input.getBytes());

    } finally {
      if (outputStream != null) {
        outputStream.flush();
        outputStream.close();
      }
    }
  }


  public static boolean checkSimCard(Activity activity) {
    TelephonyManager telMgr = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE);
    int simState = telMgr.getSimState();
    return simState == TelephonyManager.SIM_STATE_ABSENT;
  }

  public interface OnOkListener {
    boolean onOkClick(String value);
  }

  public static Date sumHoursToDate(Date data, int horas) {
    //Adiconando 12 horas na hora do Route pra que não dê problema de conversão com fuso de Manaus
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
    calendar.setTime(data);
    calendar.add(Calendar.HOUR, horas);

    return calendar.getTime();
  }
}
