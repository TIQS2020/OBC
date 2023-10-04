package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.InvoiceItemListAdapter;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import okhttp3.internal.Util;

public class CecActivity extends BaseActivity {

  EditText edtCustomer, edtNotaSerieCec, edtOperacaoCec, edtChaveCec, edtProtocoloCec;
  TextView txtCustomer, txtChaveCec, txtProtocoloCec, txtNotaSerieCec, txtValorTotalCec;
  Invoice invoice;
  ImageButton confirm;

  private View.OnClickListener confirmSouthpawClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      Intent it = new Intent(CecActivity.this, SignatureActivity.class);
      it.putExtra("invoice", invoice);
      startActivity(it);
      finish();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cec);

    invoice = (Invoice) getIntent().getSerializableExtra("invoice");

    LogHelper.self().info("CecActivity", invoice.toString());

    txtCustomer = findViewById(R.id.txtCustomer);
    edtCustomer = findViewById(R.id.edtCustomer);

    txtNotaSerieCec = findViewById(R.id.txtNotaSerieCec);
    edtNotaSerieCec = findViewById(R.id.edtNotaSerieCec);
    edtOperacaoCec = findViewById(R.id.edtOperacaoCec);
    edtChaveCec = findViewById(R.id.edtChaveCec);
    txtChaveCec = findViewById(R.id.txtChaveCec);

    edtProtocoloCec = findViewById(R.id.edtProtocoloCec);
    txtProtocoloCec = findViewById(R.id.txtProtocoloCec);
    txtValorTotalCec = findViewById(R.id.txtValorTotalCec);

    Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);

    if (invoice.getCdCustomerService() != null)
      edtCustomer.setText(GLOBAL.self().getRoute().getNomeFilial());
    else
      edtCustomer.setText(customer.getNome());

    if (GLOBAL.self().getPatient() != null)
      edtCustomer.setText(GLOBAL.self().getPatient().getNome());

    edtNotaSerieCec.setText(String.format(Locale.getDefault(), "%d/%d", invoice.getNumero(),
      invoice.getSerie()));

    edtOperacaoCec.setText(invoice.getNomeOperacao());
    edtChaveCec.setText(invoice.getChave());
    edtProtocoloCec.setText(invoice.getProtocolo());

    if (invoice.getProtocolo().equalsIgnoreCase("DANFE Offline"))
      edtProtocoloCec.setText(R.string.DANFE_OFF);

    invoice.setItens(DatabaseApp.self().getDatabase().invoiceItemDao().findByIdNota(invoice.getId()));

    InvoiceItemListAdapter itemPriceListAdapter = new InvoiceItemListAdapter(
      CecActivity.this, invoice.getItens(), null);

    final ListView itemPriceList = findViewById(R.id.item_list);
    itemPriceList.setAdapter(itemPriceListAdapter);

    confirm = findViewById(R.id.btnConfirmarCEC);
    confirm.setOnClickListener(confirmSouthpawClickListener);

    txtProtocoloCec.setVisibility(View.VISIBLE);
    edtProtocoloCec.setVisibility(View.VISIBLE);
    txtChaveCec.setVisibility(View.VISIBLE);
    edtProtocoloCec.setVisibility(View.VISIBLE);
    edtProtocoloCec.setVisibility(View.VISIBLE);
    edtChaveCec.setVisibility(View.VISIBLE);
    edtChaveCec.setVisibility(View.VISIBLE);

    //Para a operação Remessa de Prestação de Serviço a tela tem um comportamento diferente
    if (invoice.getTipoTransacao().equals(OperationType.RPS.getValue())) {
      setTitle(R.string.titulo_rec);

      txtNotaSerieCec.setText(R.string.numero_rec);

      String s = String.format(Locale.getDefault(), "%d%d%d", invoice.getCdCustomer(),
        invoice.getNumero(), invoice.getSerie());

      edtNotaSerieCec.setText(s);

      txtProtocoloCec.setVisibility(View.GONE);
      edtProtocoloCec.setVisibility(View.GONE);
      txtChaveCec.setVisibility(View.GONE);
      edtProtocoloCec.setVisibility(View.GONE);
      edtProtocoloCec.setVisibility(View.GONE);
      edtChaveCec.setVisibility(View.GONE);
      edtChaveCec.setVisibility(View.GONE);
    }

    String valorTotal = getString(R.string.total_value_order) + " " +
      UtilHelper.formatDoubleString(invoice.getValorTotal(), 2);

    if (invoice.getValorFatura() > 0)
      valorTotal = "";

    txtValorTotalCec.setText(valorTotal);

    View view = findViewById(R.id.screen);

    if (view != null) {
      view.requestFocus();
      addScreenClickHideKeyboard(view);
    }
  }

  @Override
  public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
    UtilHelper.hideKeyboardFrom(this, getCurrentFocus());
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    ActivityHelper.events(this, item);
    return super.onOptionsItemSelected(item);
  }

}
