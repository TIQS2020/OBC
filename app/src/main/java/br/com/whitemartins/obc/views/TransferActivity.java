package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.operations.Cpl;
import br.com.whitemartins.obc.operations.Trf;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class TransferActivity extends BaseActivity {

  private MyCallbackInterface.CallbackBooleanInterface
    performPositiveClick = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      startActivity(new Intent(TransferActivity.this, InvoiceActivity.class));
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface
    transfUnidadeClick = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      Intent it = new Intent(TransferActivity.this, CustomerStopActivity.class);
      GLOBAL.self().setCustomerListType(CustomerListType.TRANSFERENCIA);
//      it.putExtra("type", CustomerListType.TRANSFERENCIA);
      startActivity(it);
      finish();
    }
  };

  private View.OnClickListener transfUnidade = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().init(TransferActivity.this);
      GLOBAL.self().setOperation(Trf.newInstance());
      GLOBAL.self().getPrices().clear();

      transfUnidadeClick.execute(true);
    }
  };

  private View.OnClickListener complementoCarga = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().init(TransferActivity.this);
      GLOBAL.self().setOperation(Cpl.newInstance());
      GLOBAL.self().getPrices().clear();

      DialogHelper.showInputPasswordDialog(TransferActivity.this, R.string.comp_carga,
        new UtilHelper.OnOkListener() {
          @Override
          public boolean onOkClick(String value) {
            startActivity(new Intent(TransferActivity.this, InvoiceActivity.class));
            return true;
          }
        }, false);
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_transfer);

    ImageButton btnTransfUnidade = findViewById(R.id.btnTransfUnidade);
    btnTransfUnidade.setOnClickListener(transfUnidade);

    ImageButton btnComplementoCarga = findViewById(R.id.btnComplementoCarga);
    btnComplementoCarga.setOnClickListener(complementoCarga);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_app, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    ActivityHelper.events(this, item);
    return true;
  }

}
