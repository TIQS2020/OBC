package br.com.whitemartins.obc.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.util.UtilHelper;

public class InvoiceSyncActivity extends BaseActivity {

  ImageButton btnConfirmarInvoiceView;
  TextView txtTituloInvoiceView;
  ListView lstInvoiceView;
  ArrayAdapter<Invoice> adapter;
  List<Invoice> invoices;

  private View.OnClickListener btnConfirmarListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      setResult(CommonStatusCodes.SUCCESS);
      finish();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_invoice_sync);

    btnConfirmarInvoiceView = findViewById(R.id.btnConfirmarInvoiceView);
    btnConfirmarInvoiceView.setOnClickListener(btnConfirmarListener);

    lstInvoiceView = findViewById(R.id.lstInvoiceView);
    lstInvoiceView.setChoiceMode(ListView.FOCUSABLES_TOUCH_MODE);

    txtTituloInvoiceView = findViewById(R.id.txtTituloInvoiceView);

    String msg = String.format("%s %s %s %s",
      UtilHelper.padRight(getString(R.string.nota), ' ', 6),
      UtilHelper.padRight(getString(R.string.operacao), ' ', 17),
      UtilHelper.padRight(getString(R.string.evento), ' ', 8),
      getString(R.string.status_nfe));

    txtTituloInvoiceView.setText(msg);
    txtTituloInvoiceView.setVisibility(View.GONE);

    invoices = DatabaseApp.self().getDatabase().invoiceDao().getAll();

    adapter = new ArrayAdapter<>(this, android.R.layout.test_list_item, invoices);

    lstInvoiceView.setAdapter(adapter);
  }
}
