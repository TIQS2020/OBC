package br.com.whitemartins.obc.util;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.lang.ref.WeakReference;

public class BluetoohHelper {

  private static BluetoohHelper _self;
  private String TAG = "BluetoohHelper";
  private BluetoothAdapter mBluetoothAdapter;
  private WeakReference<Activity> weakReference;
  private final int REQUEST_ENABLE_BT = 1000;

  public BluetoohHelper() {
    mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
  }

  public static BluetoohHelper self() {

    if (_self == null)
      _self = new BluetoohHelper();

    return _self;
  }

  public BluetoohHelper setActivity(Activity activity) {
    this.weakReference = new WeakReference<>(activity);
    return this;
  }

  public boolean disable() {
    try {

      if (mBluetoothAdapter.isEnabled()) {
        mBluetoothAdapter.disable();
      }

      return true;

    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
      return false;
    }
  }

  public boolean isEnable() {
    return mBluetoothAdapter.isEnabled();
  }

  public boolean enable() {
    try {

      if (!mBluetoothAdapter.isEnabled()) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        weakReference.get().startActivityForResult(intent, REQUEST_ENABLE_BT);
//        weakReference.get().setResult(CommonStatusCodes.SUCCESS);
      }

      return true;

    } catch (Exception e) {
      LogHelper.self().error(TAG, e);
      e.printStackTrace();
      return false;
    }
  }

  public boolean pairDevice(String macAdress) {

    weakReference.get();
    final BluetoothManager bluetoothManager = (BluetoothManager) weakReference.get()
      .getSystemService(Context.BLUETOOTH_SERVICE);
    mBluetoothAdapter = bluetoothManager.getAdapter();
    BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(macAdress);
    byte[] pin = "0000".getBytes();
    device.setPin(pin);
//    device.setPairingConfirmation(true);
    return device.createBond();
  }

}
