package br.com.whitemartins.obc.util;

import android.app.Activity;
import android.content.Intent;

import java.lang.ref.WeakReference;

import br.com.whitemartins.obc.service.InvoiceBackgroundService;

public class ThreadHelper {
  public static ThreadHelper _self;
  protected WeakReference<Activity> activity;
  Intent invoiceService;

  public static ThreadHelper self() {

    if (_self == null)
      _self = new ThreadHelper();

    return _self;
  }

  public void startProcess(Activity activity) {
    invoiceService = new Intent(activity, InvoiceBackgroundService.class);
    activity.startService(invoiceService);
  }

  public void stopProcess(Activity activity) {

    if (invoiceService != null)
      activity.stopService(invoiceService);

  }
}
