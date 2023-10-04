package br.com.whitemartins.obc.print;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class PrintReports extends AsyncTask<Void, Integer, Boolean> {

  protected String parcial = "";
  private final Object monitor = new Object();
  private MyCallbackInterface.CallbackBooleanInterface notifyFinish;
  private ProgressDialog progressDialog;
  private WeakReference<Activity> weakActivity;
  private List<BaseReports> reports = new ArrayList<>();
  private boolean ready = false;
  private boolean printOk = false;

  public PrintReports(Activity activity) {
    this.progressDialog = UtilHelper.ProgressDialogInstance(activity);
    this.weakActivity = new WeakReference<>(activity);
  }

  public PrintReports addReport(BaseReports printBaseReports) {
    reports.add(printBaseReports);
    return this;
  }

  public PrintReports setParcial(String parcial) {
    this.parcial = parcial;
    return this;
  }

  public PrintReports setNotifyFinish(MyCallbackInterface.CallbackBooleanInterface notifyFinish) {
    this.notifyFinish = notifyFinish;
    return this;
  }

  @Override
  protected void onPreExecute() {
    progressDialog = ProgressDialog.show(this.weakActivity.get(),
      this.weakActivity.get().getString(R.string.printer_title),
      this.weakActivity.get().getString(R.string.send_data_printer), false,
      false);
    progressDialog.setCancelable(false);
    progressDialog.setIndeterminate(false);
    progressDialog.show();
  }

  private void updateUI(final String s) {
    weakActivity.get().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        progressDialog.setTitle(s);
      }
    });
  }

  private void showMessage() {
    weakActivity.get().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        DialogHelper.showInformationMessage(weakActivity.get(), R.string.informar_text,
          R.string.destacar_relatorio, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              ready = true;
              synchronized (monitor) {
                monitor.notifyAll();
              }
            }
          }
        );
      }
    });
  }

  private synchronized Boolean print() {
    try {
      if (!PrinterConnection.self().isConnected())
        PrinterConnection.self().connect();

      for (BaseReports report : reports) {
        try {
          updateUI(report.toString());
          report.print();
          showMessage();

          synchronized (monitor) {
            while (!ready) {
              try {
                monitor.wait();
              } catch (InterruptedException ignored) {

              }
            }
          }
          ready = false;
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      if (PrinterConnection.self().isConnected())
        PrinterConnection.self().disconnect();

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      progressDialog.dismiss();
    }

    return true;
  }

  protected Boolean doInBackground(Void... erros) {
    synchronized (monitor) {
      return print();
    }
  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (notifyFinish != null)
      notifyFinish.execute(success);
  }
}
