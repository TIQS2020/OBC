package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.operations.Trf;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class TransferMenuActivity extends BaseActivity {
  Customer customer;

  private MyCallbackInterface.CallbackBooleanInterface
    postTramsfUnidade = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      GLOBAL.self().setTransfer(true);
      Intent it = new Intent(TransferMenuActivity.this, InvoiceActivity.class);
      startActivity(it);
      finish();
    }
  };


  private View.OnClickListener transfUnidadeClick = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      GLOBAL.self().init(TransferMenuActivity.this);
      GLOBAL.self().setOperation(Trf.newInstance());

      if (GLOBAL.self().isHomecare()) {
        DialogHelper.showInputTipoItemDialog(TransferMenuActivity.this,
          GLOBAL.self().getOperation(), GLOBAL.self().getCustomer(),
          GLOBAL.self().getPatient(), postTramsfUnidade);
      } else
        postTramsfUnidade.execute(true);
    }
  };
  private View.OnClickListener cancelClick = new View.OnClickListener() {
    @Override
    public void onClick(View view) {

      List<Invoice> invoices = DatabaseApp.self().getDatabase().invoiceDao()
        .find(customer.getCdCustomer(), UtilHelper.padLeft(GLOBAL.self().getRoute()
          .getNumeroViagem().toString(), '0', 6));

      if (invoices.size() > 0) {
        Intent it = new Intent(TransferMenuActivity.this, InvoiceViewActivity.class);
        GLOBAL.self().setCustomerListType(CustomerListType.TRANSFERENCIA);
//        it.putExtra("type", CustomerListType.TRANSFERENCIA);
        it.putExtra("cdCustomer", customer.getCdCustomer());
        startActivity(it);
      } else
        DialogHelper.showInformationMessage(TransferMenuActivity.this,
          R.string.informar_text, R.string.no_invoices, null);
    }
  };

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_app, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
//    switch (item.getItemId()) {
//      case R.id.action_back:
//        finish();
//        break;
//    }

    ActivityHelper.events(this, item);
    return true;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_transfer_menu);

    ImageButton btnTransfUnidade = findViewById(R.id.btnTransfUnidade);
    btnTransfUnidade.setOnClickListener(transfUnidadeClick);

    ImageButton btnCancelTransferencia = findViewById(R.id.btnCancelTransferencia);
    btnCancelTransferencia.setOnClickListener(cancelClick);

    TextView txtCdClienteTransf = findViewById(R.id.txtCdClienteTransf);
    TextView txtDescClienteTransf = findViewById(R.id.txtDescClienteTransf);

    customer = GLOBAL.self().getCustomer();

    if (customer != null) {
      if (GLOBAL.self().getPatient() == null) {
        txtCdClienteTransf.setText(customer.getCdCustomer().toString());
        txtDescClienteTransf.setText(customer.getNome());
      } else {
        txtCdClienteTransf.setText(GLOBAL.self().getPatient().getCdPaciente().toString());
        txtDescClienteTransf.setText(GLOBAL.self().getPatient().getNome());
      }
    }
  }
}
