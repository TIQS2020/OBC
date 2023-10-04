package br.com.whitemartins.obc.print;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.zebra.sdk.graphics.internal.ZebraImageAndroid;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.util.ImageHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class PrintCEC extends AsyncTask<Boolean, Integer, Boolean> {

  //  private PrinterConnection printerConnection = new PrinterConnection();
  private ProgressDialog progressDialog;
  protected Activity context;
  private Bitmap bitmap;
  private ZebraImageAndroid image = null;
  protected Invoice invoice;
  private Boolean reprint = false;
  private Boolean automatic = false;

  private MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback;

  public PrintCEC() {
  }

  public PrintCEC(Activity _context) {
    this.progressDialog = UtilHelper.ProgressDialogInstance(_context);
    this.context = _context;
  }

  public PrintCEC setFinishExecuteCallback(MyCallbackInterface.CallbackBooleanInterface finishExecuteCallback) {
    this.finishExecuteCallback = finishExecuteCallback;
    return this;
  }

  public PrintCEC setSignature(Bitmap _bitmap) {
    this.bitmap = _bitmap;
    if (bitmap != null)
      image = new ZebraImageAndroid(bitmap);
    return this;
  }

  public PrintCEC setInvoice(@NonNull Invoice invoice) {
    this.invoice = invoice;
    return this;
  }

  public PrintCEC setReprint(Boolean reprint) {
    this.reprint = reprint;
    return this;
  }

  public PrintCEC setAutomatic(Boolean automatic) {
    this.automatic = automatic;
    return this;
  }

  protected Cec getCecRec() {
    return new Cec();
  }

  @Override
  protected void onPreExecute() {

    progressDialog = ProgressDialog.show(this.context,
      this.context.getString(R.string.printer_title),
      this.context.getString(R.string.send_data_printer), false, false);
    progressDialog.setCancelable(false);
    progressDialog.setIndeterminate(false);

    if (!automatic) // Quando viagem refeita, variavel = true para que não mostre a barra de progresso
      progressDialog.show();
  }

  protected Boolean doInBackground(Boolean... erros) {
    try {

      ImageHelper.self().createCecImage(2000);

      getCecRec()
        .setInvoice(invoice)
        .setActivity(context)
        .setReprint(reprint)
        .setAutomatic(false)
        .setSignature(bitmap)
        .print();

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    if (progressDialog.isShowing())
      progressDialog.dismiss();

    if (finishExecuteCallback != null)
      finishExecuteCallback.execute(success);
  }
}
