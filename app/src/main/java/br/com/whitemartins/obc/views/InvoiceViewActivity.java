package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.InvoiceViewListAdapter;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.enumeration.MovimentoIntegracaoType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.timer.CancelInvoiceTimer;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;

public class InvoiceViewActivity extends BaseActivity {

  ImageButton btnConfirmarInvoiceView, btnAtualizarInvoiceView;
  ListView lstInvoiceView;
  InvoiceViewListAdapter adapter;
  List<Invoice> invoices;
  Long cdCustomer = null;
  boolean OK = false;
  Invoice invoice;
  CustomerListType type;
  private int pos = -1;
  private View.OnClickListener btnAtualizarListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {

      runOnUiThread(new Runnable() {
        @Override
        public void run() {
          consultar();
        }
      });
    }
  };

  private MyCallbackInterface.CallbackVoidInterface finishProcessCallback = new MyCallbackInterface.CallbackVoidInterface() {
    @Override
    public void execute() {
      try {
        adapter.notifyDataSetChanged();

        if (!invoices.get(pos).isFinalStatus())
          GLOBAL.self().getInvoiceBackgroundService().addInvoiceToList(invoices.get(pos));

        finish();
      } catch (Exception e) {
        e.printStackTrace();
        LogHelper.self().error(TAG, e);
      }
    }
  };

  protected View.OnClickListener btnConfirmarListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      if (pos < 0) {
        DialogHelper.showInformationMessage(InvoiceViewActivity.this, R.string.informar_text,
          R.string.selecione_nota_cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              btnConfirmarInvoiceView.setEnabled(true);
            }
          });
        return;
      }

      invoice = invoices.get(pos);

      if (invoice.getTipoMovimentoIntegracao().equals(MovimentoIntegracaoType
        .EVENTO_CANCELAMENTO.getValue())) {
        DialogHelper.showInformationMessage(InvoiceViewActivity.this, R.string.informar_text,
          R.string.nota_cancelada, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              btnConfirmarInvoiceView.setEnabled(true);
            }
          });
      } else if (!invoice.getStatus().equals(StatusNFeType.AUTORIZADA.getValue()))
        DialogHelper.showInformationMessage(InvoiceViewActivity.this, R.string.informar_text,
          R.string.nao_pode_cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              btnConfirmarInvoiceView.setEnabled(true);
            }
          });
      else {
        String numero = invoice.getNumero().toString();

        if (OperationType.RPS.getValue().equals(invoice.getTipoTransacao()))
          numero = invoice.getCdCustomer().toString() + invoice.getNumero().toString() +
            invoice.getSerie().toString();

        DialogHelper.showQuestionMessage(InvoiceViewActivity.this,
          getString(R.string.confirmar_text),
          String.format(getString(R.string.msg_cancel_nota),
            numero),
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              Customer customer = InvoiceHelper.self().getInvoiceCustomer(invoice);

              DialogHelper.showInputMotiveItemDialog(InvoiceViewActivity.this,
                customer, null, new MyCallbackInterface.CallbackStringInterface() {
                  @Override
                  public void execute(String choice) {
                    invoice.setStatus(StatusNFeType.PENDENTE_CANCELAMENTO.getValue());
                    invoice.setTipoMovimentoIntegracao(
                      MovimentoIntegracaoType.EVENTO_CANCELAMENTO.getValue());
                    invoice.setCdMotivo(choice.split("-")[0]);
                    invoice.setDsMotivo(choice.split("-")[1]);
                    invoice.save();

                    sendAndConsult();
                  }
                });
            }
          }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              OK = true;
            }
          });
      }
    }
  };

  private void consultar() {

    invoices = DatabaseApp.self().getDatabase().invoiceDao().find(cdCustomer,
      UtilHelper.padLeft(GLOBAL.self().getRoute().getNumeroViagem().toString(), '0', 6));

    adapter = new InvoiceViewListAdapter(InvoiceViewActivity.this, invoices, true);

    lstInvoiceView.setAdapter(adapter);

    DialogHelper.showInformationMessage(this, R.string.informar_text,
      R.string.consult_finish, null);
  }

  @Override
  protected void onResume() {
    btnConfirmarInvoiceView.setEnabled(true);
    super.onResume();
  }

  private void sendAndConsult() {

    long timeout = UtilHelper.convertToLongDef(XmlConfig.self().getTimeOut1(), 0) * 1000;

    new CancelInvoiceTimer(this, timeout, 1000)
      .setFinishProcessCallback(finishProcessCallback)
      .setInvoice(invoice)
      .start();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_invoice_view);

    type = GLOBAL.self().getCustomerListType();//(CustomerListType) getIntent().getExtras().get("type");

    btnConfirmarInvoiceView = findViewById(R.id.btnConfirmarInvoiceView);
    btnConfirmarInvoiceView.setOnClickListener(btnConfirmarListener);

    btnAtualizarInvoiceView = findViewById(R.id.btnAtualizarInvoiceView);
    btnAtualizarInvoiceView.setOnClickListener(btnAtualizarListener);

    lstInvoiceView = findViewById(R.id.lstInvoiceView);
    lstInvoiceView.setChoiceMode(ListView.FOCUSABLES_TOUCH_MODE);

    cdCustomer = getIntent().getExtras().getLong("cdCustomer");

    if (cdCustomer == 0)
      cdCustomer = null;

    invoices = DatabaseApp.self().getDatabase().invoiceDao().find(cdCustomer,
      UtilHelper.padLeft(GLOBAL.self().getRoute().getNumeroViagem().toString(), '0', 6));

    adapter = new InvoiceViewListAdapter(this, invoices, true);

    lstInvoiceView.setAdapter(adapter);
    lstInvoiceView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position;
      }
    });

    addScreenClickHideKeyboard(findViewById(R.id.screen));
    addScreenClickHideKeyboard(findViewById(R.id.screen2));
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
