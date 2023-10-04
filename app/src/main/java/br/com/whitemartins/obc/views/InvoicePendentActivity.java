package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.FinishTripType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.global.TRIP;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.service.SendInvoicePendentService;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class InvoicePendentActivity extends BaseActivity {

  TextView txtTituloInvoicePendent, txtStatus;
  List<Invoice> invoices;
  ListView lstInvoicePendent;
  ArrayAdapter<Invoice> adapter;
  ProgressBar progressBar;

  List<Invoice> invoicesErrors = new ArrayList<>();
  int idx = -1;

  private DialogInterface.OnClickListener positiveClickListener = new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
      finish();
    }
  };

  private MyCallbackInterface.CallbackBooleanInterface finishCallback =
    new MyCallbackInterface.CallbackBooleanInterface() {
      @Override
      public void execute(Boolean success) {

        ++idx;

        progressBar.setProgress(progressBar.getProgress() + 1, false);
        adapter.notifyDataSetChanged();

        if (success) {
          if (idx + 1 == invoices.size()) {

            if (invoicesErrors.isEmpty()) {
              TRIP.self()
                .setWeakReference(GLOBAL.self().getGlobalActivity())
                .finish(FinishTripType.SINCRONISMO_CECS);
              finish();
            } else {
              DialogHelper.showErrorMessage(InvoicePendentActivity.this, R.string.erro_text,
                R.string.erro_enviar_notas, positiveClickListener);
            }
          }
        } else {
          if (idx <= invoices.size())
            invoicesErrors.add(invoices.get(idx));

          if (idx + 1 == invoices.size())
            DialogHelper.showErrorMessage(InvoicePendentActivity.this, R.string.erro_text,
              R.string.erro_enviar_notas, positiveClickListener);
        }
      }
    };

  private View.OnClickListener btnConfirmarListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      sendAndConsult();
    }
  };

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    sendAndConsult();
  }

  private void getInvoices() {
    invoices = DatabaseApp.self().getDatabase().invoiceDao().find(StatusNFeType.build(
      StatusNFeType.PENDENTE_ENVIO, StatusNFeType.PROCESSANDO));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_invoice_pendent);

    //Limpando a lista da thread para que não haja concorrencia
    GLOBAL.self().getInvoiceBackgroundService().clearInvoiceList();

    txtTituloInvoicePendent = findViewById(R.id.txtTituloInvoicePendent);
    lstInvoicePendent = findViewById(R.id.lstInvoicePendent);
    progressBar = findViewById(R.id.pbarSendInvoice);
    txtStatus = findViewById(R.id.txtStatus);

    ImageButton btnConfirmarInvoicePendent = findViewById(R.id.btnConfirmarInvoicePendent);
    btnConfirmarInvoicePendent.setOnClickListener(btnConfirmarListener);
    btnConfirmarInvoicePendent.setVisibility(View.GONE);

    String msg = String.format("%s %s %s %s",
      UtilHelper.padRight(getString(R.string.nota), ' ', 6),
      UtilHelper.padRight(getString(R.string.operacao), ' ', 17),
      UtilHelper.padRight(getString(R.string.evento), ' ', 8),
      getString(R.string.status_nfe));

    txtTituloInvoicePendent.setText(msg);
    txtTituloInvoicePendent.setVisibility(View.GONE);

    getInvoices();

    progressBar.setMax(invoices.size());
    adapter = new ArrayAdapter<>(this, android.R.layout.test_list_item, invoices);
    lstInvoicePendent.setAdapter(adapter);
  }

  private void sendAndConsult() {
    invoicesErrors.clear();

    progressBar.setProgress(0, true);

    for (Invoice invoice : invoices) {
      new SendInvoicePendentService()
        .setInvoice(invoice)
        .setFinishExecuteCallback(finishCallback)
        .setActivity(this)
        .setTxtStatus(txtStatus)
        .execute();
    }
  }
}
