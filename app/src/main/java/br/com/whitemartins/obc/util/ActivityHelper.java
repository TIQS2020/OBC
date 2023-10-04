package br.com.whitemartins.obc.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.views.BaseActivity;
import br.com.whitemartins.obc.views.ChargeConsultActivity;
import br.com.whitemartins.obc.views.ConfirmTravelDataActivity;
import br.com.whitemartins.obc.views.PrinterDiscoverActivity;
import br.com.whitemartins.obc.views.RecoverClientActivity;

/**
 * Created by 1513 IRON on 22/10/2017.
 */

public class ActivityHelper {

//  public static void setBarAction(BaseActivity activity) {
//
//    activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//    if (!(activity instanceof SplashScreemActivity || activity instanceof ConfirmTravelDataActivity)) {
//      Objects.requireNonNull(activity.getSupportActionBar()).setDisplayShowHomeEnabled(true);
//    }
//  }

  public static void events(BaseActivity activity, MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        activity.finish();
        break;

      case R.id.action_back:
        activity.finish();
        break;

      case R.id.travel_data: {
        ActivityHelper.showTravelData(activity);
        break;
      }
      case R.id.action_config_printer: {
        ActivityHelper.showConfigPrinter(activity);
        break;
      }
      case R.id.menu_report_charge_consult: {
        ActivityHelper.showChargeConsult(activity);
        break;
      }
    }
  }

  public static void showTravelData(Activity activity) {
    Intent it = new Intent(activity, ConfirmTravelDataActivity.class);
    it.putExtra("showButtons", View.INVISIBLE);
    activity.startActivity(it);
  }

  public static void showConfigPrinter(final Activity activity) {

    DialogHelper.showInformationMessage(activity, R.string.informar_text, R.string.printer_on,
      new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          Intent it = new Intent(activity, PrinterDiscoverActivity.class);
          activity.startActivity(it);
        }
      });
  }

  public static void showRecoveryClient(Activity activity) {
    Intent it = new Intent(activity, RecoverClientActivity.class);
    activity.startActivity(it);
  }

  public static void showChargeConsult(final Activity activity) {
    Intent it = new Intent(activity, ChargeConsultActivity.class);
    activity.startActivity(it);
  }
}
