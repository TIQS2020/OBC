package br.com.whitemartins.obc.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceNumber;
import br.com.whitemartins.obc.model.Travel;
import br.com.whitemartins.obc.model.sync.NotasFiscais;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.print.Cec;
import br.com.whitemartins.obc.print.Rec;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.SaldoHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public class ParseSyncService extends AsyncTask<Void, String, Boolean> {

  String TAG = this.getClass().getSimpleName();
  WeakReference<Activity> activity;
  private MyCallbackInterface.CallbackBooleanInterface callbackFinish;
  private ProgressDialog progressDialog;
  private List<NotasFiscais> notasFiscais;

  public ParseSyncService setCallbackFinish(MyCallbackInterface.CallbackBooleanInterface callbackFinish) {
    this.callbackFinish = callbackFinish;
    return this;
  }

  public ParseSyncService setNotasFiscais(List<NotasFiscais> notasFiscais) {
    this.notasFiscais = notasFiscais;
    return this;
  }

  public ParseSyncService setActivity(Activity activity) {
    this.activity = new WeakReference<>(activity);
    return this;
  }

  @Override
  protected void onPreExecute() {
    progressDialog = UtilHelper.ProgressDialogInstance(activity.get());
    progressDialog.setTitle(R.string.sync_travel_2);
    progressDialog.setMessage("Iniciando...");
    progressDialog.setCancelable(false);
    progressDialog.setIndeterminate(false);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    progressDialog.setProgress(0);
    progressDialog.setMax(notasFiscais.size() * 2);
    progressDialog.show();
  }

  @Override
  protected Boolean doInBackground(Void... voids) {

    try {
      parseAndCreateCecs();
    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  protected void onProgressUpdate(String... values) {
    progressDialog.setMessage(values[0]);
    progressDialog.setProgress(progressDialog.getProgress() + 1);
    LogHelper.self().info(TAG, values[0]);
    super.onProgressUpdate(values);
  }

  @Override
  protected void onPostExecute(Boolean success) {
    progressDialog.dismiss();

    if (callbackFinish != null)
      callbackFinish.execute(success);
  }

  private void parseAndCreateCecs() {

    DatabaseApp.self().getDatabase().runInTransaction(new Runnable() {
      @Override
      public void run() {
        List<Travel> travels = DatabaseApp.self().getDatabase().travelDao().getAll();

        activity.get().runOnUiThread(new Runnable() {
          @Override
          public void run() {
            progressDialog.setTitle(activity.get().getString(R.string.create_invoices));
          }
        });

        LogHelper.self().info(TAG, activity.get().getString(R.string.create_invoices));

        for (NotasFiscais nota : notasFiscais) {
          publishProgress(nota.toString());
          try {
            nota.saveAll();
          } catch (IOException e) {
            LogHelper.self().error(TAG, e);
            e.printStackTrace();
          }
        }

        InvoiceNumber invoiceNumber = DatabaseApp.self().getDatabase().invoiceNumberDao().getFirst();

        Long serieE = invoiceNumber.getNumeroSerieEntrada();
        Long serieS = invoiceNumber.getNumeroSerieSaida();
        Long numeroNotaIn = invoiceNumber.getNumeroNotaFiscalEntrada();
        Long numeroNotaOut = invoiceNumber.getNuemroNotaFiscalSaida();

        Invoice invoiceIn = DatabaseApp.self().getDatabase().invoiceDao()
          .findByTipoNota(InvoiceType.ENTRADA.getValue());
        if (invoiceIn != null)
          numeroNotaIn = invoiceIn.getNumero() + 1;

        Invoice invoiceOut = DatabaseApp.self().getDatabase().invoiceDao()
          .findByTipoNota(InvoiceType.SAIDA.getValue());

        if (invoiceOut != null)
          numeroNotaOut = invoiceOut.getNumero() + 1;

        GLOBAL.self().getGeneral().setNumeroNotaSaida(numeroNotaOut);
        GLOBAL.self().getGeneral().setNumeroNotaEntrada(numeroNotaIn);
        GLOBAL.self().getGeneral().save();

        GLOBAL.self().getRoute().setNumeroViagem(travels.get(0).getNumeroViagem());
        GLOBAL.self().getRoute().setDataViagem(travels.get(0).getDataViagem());
        GLOBAL.self().getRoute().save();

        createCecs();
      }
    });
  }

  private void createCecs() {
    Cec pCEC;

    List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao().getAll();

    for (Invoice invoice : invoices) {

      invoice.setItens(DatabaseApp.self().getDatabase().invoiceItemDao().findByIdNota(invoice.getId()));

      activity.get().runOnUiThread(new Runnable() {
        @Override
        public void run() {
          progressDialog.setTitle(activity.get().getString(R.string.create_cecs));
        }
      });

      LogHelper.self().info(TAG, activity.get().getString(R.string.create_cecs));
      publishProgress(String.format(Locale.getDefault(), "Nota: %d Série: %d",
        invoice.getNumero(), invoice.getSerie()));

      boolean cancelada = false;

//      if (invoice.getTipoMovimentoIntegracao().equals(MovimentoIntegracaoType.EVENTO_CANCELAMENTO.getValue())
//        && invoice.getStatus().equals(StatusNFeType.AUTORIZADA.getValue()))
      if (invoice.isCanceled())
        cancelada = true;

      //Atualizando o saldo da nota fiscal
      if (!cancelada)
        SaldoHelper.self().atualizarSaldoInvoice(invoice, false);

      File f = new File(UtilHelper.getSignFileName(invoice));

      Bitmap bitmap = null;

      if (f.exists())
        bitmap = BitmapFactory.decodeFile(UtilHelper.getSignFileName(invoice));

      if (bitmap == null)
        bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);

      if (SuperOperation.getOperation(invoice.getTipoTransacao()).getOperationType()
        .equals(OperationType.RPS))
        pCEC = new Rec();
      else
        pCEC = new Cec();

      try {
        pCEC
          .setInvoice(invoice)
          .setActivity(activity.get())
          .setReprint(false)
          .setAutomatic(true)
          .setSignature(bitmap)
          .print();

      } catch (ConnectionException | ZebraPrinterLanguageUnknownException e) {
        e.printStackTrace();
        LogHelper.self().error(TAG, e);
      }
    }
  }
}
