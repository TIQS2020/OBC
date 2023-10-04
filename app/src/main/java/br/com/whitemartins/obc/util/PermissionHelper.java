package br.com.whitemartins.obc.util;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.lang.ref.WeakReference;

import br.com.whitemartins.obc.R;

/**
 * Created by Rodolfo on 12/12/2017.
 */

public class PermissionHelper {

  public static PermissionHelper _self;
  private final int REQUEST_PERMISSION_STATE_CODE = 1;
  private WeakReference<Activity> activity;

  private String[] all_perms = {
      Manifest.permission.WRITE_EXTERNAL_STORAGE,
      Manifest.permission.INTERNET,
      Manifest.permission.BLUETOOTH,
      Manifest.permission.READ_PHONE_STATE,
      Manifest.permission.READ_EXTERNAL_STORAGE,
      Manifest.permission.REQUEST_INSTALL_PACKAGES,
      Manifest.permission.INSTALL_PACKAGES,
      Manifest.permission.ACCESS_FINE_LOCATION,
      Manifest.permission.CAMERA,
      Manifest.permission.BLUETOOTH_ADMIN,
      Manifest.permission.BLUETOOTH_PRIVILEGED,
      Manifest.permission.RESTART_PACKAGES,
      Manifest.permission.MANAGE_EXTERNAL_STORAGE
  };

  public static PermissionHelper self(Activity a) {
    if (_self == null)
      _self = new PermissionHelper();

    _self.activity = new WeakReference<>(a);

    return _self;
  }

  public PermissionHelper requestPermission() {
    ActivityCompat.requestPermissions(activity.get(), all_perms, REQUEST_PERMISSION_STATE_CODE);
    return this;
  }

  private void requestPermission(String permissionName, int permissionRequestCode) {
    ActivityCompat.requestPermissions(activity.get(),
        new String[]{permissionName}, permissionRequestCode);
  }

  private void showExplanation(final String title,
                               final String message,
                               final String permission,
                               final int permissionRequestCode) {


    DialogHelper.showInformationMessage(activity.get(),
        activity.get().getString(R.string.confirmar_text), message,
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            requestPermission(permission, permissionRequestCode);
          }
        });
  }

  private void showPhoneStatePermission(String permission) {

    int permissionCheck = ContextCompat.checkSelfPermission(activity.get(), permission);

    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
      if (ActivityCompat.shouldShowRequestPermissionRationale(activity.get(), permission)) {
        showExplanation("Permission Needed", "Rationale", permission,
            REQUEST_PERMISSION_STATE_CODE);
      } else {
        ActivityCompat.requestPermissions(activity.get(), all_perms, REQUEST_PERMISSION_STATE_CODE);

        //requestPermission(permission, REQUEST_PERMISSION_STATE_CODE);
      }
    }
  }
}
