package br.com.whitemartins.obc.views;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.zebra.sdk.printer.discovery.DiscoveredPrinterBluetooth;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.BluetoothStateHolder;
import br.com.whitemartins.obc.adapters.PrinterAdapter;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.BluetoohHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class PrinterDiscoverActivity extends BaseActivity implements BluetoothStateHolder.BluetoothStateListener {
  private final int REQUEST_ENABLE_BT = 1000;
  boolean returnWhenSelected;
  BluetoothStateHolder bluetoothService = new BluetoothStateHolder(this);
  boolean springloadDiscoveryResult = false;
  ListView listPrinters;
  List<DiscoveredPrinterBluetooth> printers = new ArrayList<>();

  BluetoohHelper bluetoohHelper = BluetoohHelper.self().setActivity(this);
  ProgressDialog progressDialog;
  private SearchView searchView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_printer_discover);
    BluetoothStateHolder.attachContextListener(this, this);

    listPrinters = findViewById(R.id.listPrinters);
    searchView = findViewById(R.id.srcCustomer);

    if (bluetoohHelper.isEnable())
      findPrinters();
    else
      bluetoohHelper.enable();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == REQUEST_ENABLE_BT)
      findPrinters();

    super.onActivityResult(requestCode, resultCode, data);
  }

  private void done(int code) {
    setResult(code);
    finish();
  }

  private void findPrinters() {
    bluetoothService.startBluetoothDiscovery();
    springloadDiscoveryResult = true;
    progressDialog = UtilHelper.ProgressDialogInstance(this);
    progressDialog.setTitle(R.string.printer_discover);
    progressDialog.setMessage(getString(R.string.find_printers));
    progressDialog.setCancelable(false);
    progressDialog.setIcon(R.drawable.ic_bluetooth);
    progressDialog.setIndeterminate(true);
    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    progressDialog.show();
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
  }

  private void launchPrinterSelect(final ArrayList<DiscoveredPrinterBluetooth> printers) {
    springloadDiscoveryResult = false;
    if (isFinishing()) {
      return;
    }
    this.printers = printers;

    final PrinterAdapter printerAdapter = new PrinterAdapter(this,
        android.R.layout.simple_spinner_item, printers);
    listPrinters.setAdapter(printerAdapter);

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        printerAdapter.getFilter().filter(newText);
        return false;
      }
    });

    listPrinters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DiscoveredPrinterBluetooth printer =
            (DiscoveredPrinterBluetooth) parent.getAdapter().getItem(position);
        final String mac = printer.toString();

        String fn = "";
        if (printer.friendlyName != null)
          fn = printer.friendlyName;

        final String name = fn;

        DialogHelper.showQuestionMessage(PrinterDiscoverActivity.this,
            getString(R.string.confirmar_text),
            String.format(getString(R.string.pair_print), name), new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {

                GLOBAL.self().getStaticTable().setMacAddress(mac);
                GLOBAL.self().getStaticTable().setNomeImpressora(name);
                GLOBAL.self().getStaticTable().save();
                bluetoohHelper.pairDevice(mac);
                done(CommonStatusCodes.SUCCESS);
              }
            }, new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                done(CommonStatusCodes.ERROR);
              }
            });
      }
    });

    progressDialog.dismiss();

    if (printers.isEmpty())
      DialogHelper.showQuestionMessage(this, R.string.confirmar_text,
          R.string.turn_on_printer, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              findPrinters();
            }
          }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              done(CommonStatusCodes.ERROR);
            }
          });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_find_printer, menu);
    getMenuInflater().inflate(R.menu.menu_app, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    setResult(CommonStatusCodes.ERROR);

    ActivityHelper.events(this, item);

    if (item.getItemId() == R.id.action_find) {
      findPrinters();
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onBluetoothStateUpdate() {
    if (isFinishing()) {
      return;
    } else {
      if (bluetoothService.getActivePrinter() != null && returnWhenSelected) {
        done(CommonStatusCodes.ERROR);
      } else if (springloadDiscoveryResult && !bluetoothService.inDiscovery()
        //&& bluetoothService.getActivePrinter() == null
      )
        launchPrinterSelect(bluetoothService.getDiscoveredPrinters());
    }
  }

  @Override
  public void attachStateHolder(BluetoothStateHolder bluetoothStateHolder) {
    this.bluetoothService = bluetoothStateHolder;
  }
}
