package br.com.whitemartins.obc.print;

import android.app.Activity;

public class PrintREC extends PrintCEC { // AsyncTask<Boolean, Integer, Boolean> {

  public PrintREC(Activity _context) {
    super(_context);
  }

  @Override
  protected Cec getCecRec() {
    return new Rec();
  }

//  protected Boolean doInBackground(Boolean... erros) {
//    try {
//
//      ImageHelper.self().createCecImage(2000);
//
//      new Rec()
//        .setInvoice(invoice)
//        .setActivity(context)
//        .setReprint(reprint)
//        .setAutomatic(false)
//        .setSignature(bitmap)
//        .print();
//
//    } catch (Exception e) {
//      e.printStackTrace();
//      return false;
//    }
//    return true;
//  }
}
