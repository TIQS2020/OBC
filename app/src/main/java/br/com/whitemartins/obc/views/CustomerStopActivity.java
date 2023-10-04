package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DataGetHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class CustomerStopActivity extends BaseActivity {

  EditText edtCdCliente;

  private View.OnClickListener confirmClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      Intent confirmClient = new Intent(CustomerStopActivity.this, ConfirmCustomerActivity.class);

      Customer customer = null;

      if (edtCdCliente.getText().toString().isEmpty())
        DialogHelper.showInformationMessage(CustomerStopActivity.this,
          getString(R.string.informar_text),
          getString(R.string.cliente_invalido_operacao),
          null);
      else {
        if (!edtCdCliente.getText().toString().isEmpty()) {
          Long codigo = UtilHelper.convertToLongDef(edtCdCliente.getText().toString(), 0);

          //          if (GLOBAL.self().isPaciente(codigo) == null) {
//
//          }

          CustomerListType type = GLOBAL.self().getCustomerListType();

          if (type == null)
            type = CustomerListType.INTERCOMPANY;

          List<Customer> customers = DataGetHelper.getListClients(type, codigo);

          if (!customers.isEmpty()) {
            customer = customers.get(0);
            if (GLOBAL.self().isPaciente(codigo) == null) {
              customer = DatabaseApp.self().getDatabase().customerDao().findById(codigo);
              GLOBAL.self().setCustomer(customer);
            }

            //customer = DatabaseApp.self().getDatabase().customerDao().findById(customer.getCdCustomer());
            //GLOBAL.self().setCustomer(customer);

            startActivity(confirmClient);

          } else {
            DialogHelper.showInformationMessage(CustomerStopActivity.this,
              getString(R.string.informar_text),
              getString(R.string.cliente_invalido_operacao), null);
          }


        }
        edtCdCliente.setText("");
      }
    }
  };

  private View.OnClickListener listClientClickListener = new View.OnClickListener() {
    public void onClick(View v) {
//      CustomerListType type = null;

//      if (getIntent().getExtras() != null && getIntent().getExtras().get("type") != null)
//        type = (CustomerListType) getIntent().getExtras().get("type");

      Intent it = new Intent(CustomerStopActivity.this, CustomerListActivity.class);
      GLOBAL.self().setCustomerListType(GLOBAL.self().getCustomerListType());
//      it.putExtra("type", type);
      startActivity(it);
      edtCdCliente.setText("");
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_customer_stop);

    edtCdCliente = findViewById(R.id.edtCdCliente);
    ImageButton buttonConfirm = findViewById(R.id.btnConfimarCliente);
    buttonConfirm.setOnClickListener(confirmClickListener);
    ImageButton listClients = findViewById(R.id.btnListarCliente);
    listClients.setOnClickListener(listClientClickListener);
    GLOBAL.self().getPrices().clear();

    addScreenClickHideKeyboard(findViewById(R.id.screen));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_client_stop, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.menu_travel_data)
      ActivityHelper.showTravelData(CustomerStopActivity.this);
    else if (id == R.id.menu_voltar_client_stop) {
      Intent it;
      if (GLOBAL.self().isTransfer())
        it = new Intent(this, TransferActivity.class);
      else
        it = new Intent(this, CustomerServiceActivity.class);
      startActivity(it);
      finish();
    } else if (id == R.id.menu_recover_client)
      ActivityHelper.showRecoveryClient(CustomerStopActivity.this);

    return super.onOptionsItemSelected(item);
  }
}
