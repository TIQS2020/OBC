package br.com.whitemartins.obc.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.whitemartins.obc.views.SplashScreemActivity;

public class UpdateReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    // Restart your app here
//    Intent i = new Intent(context, SplashScreemActivity.class);
//    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//    context.startActivity(i);
  }
}
