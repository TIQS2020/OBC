package br.com.whitemartins.obc.receiver;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.views.SplashScreemActivity;

public class DevAdminReceiver extends DeviceAdminReceiver {
  public static ComponentName getComponentName(Context context) {
    return new ComponentName(context.getApplicationContext(), DevAdminReceiver.class);
  }

  @Override
  public void onEnabled(Context context, Intent intent) {
    super.onEnabled(context, intent);
    LogHelper.self().info("Device Owner Enabled");
  }

  @Override
  public void onProfileProvisioningComplete(Context context, Intent intent) {
    // Enable the profile
    DevicePolicyManager manager =
      (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
    ComponentName componentName = getComponentName(context);
    manager.setProfileName(componentName, context.getString(R.string.app_name));
    // Open the main screen
    Intent launch = new Intent(context, SplashScreemActivity.class);
    launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(launch);
  }
}
