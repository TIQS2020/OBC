package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.InvoiceViewListAdapter;
import br.com.whitemartins.obc.enumeration.CecType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.print.PrintCEC;
import br.com.whitemartins.obc.print.PrintREC;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.LogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class ReprintCecActivity extends BaseActivity {
  final int REQUEST_FOR_PAIR_CODE = 1;
  private final String TAG = "ReprintCecActivity";

  TextView txtTituloReprintCec;
  ListView lstInvoiceReprintCec;
  List<Invoice> invoices;
  Invoice invoice;
  InvoiceViewListAdapter adapter;
  private int pos = -1;

  private View.OnClickListener btnConfirmaClickListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      if (GLOBAL.self().getStaticTable().getMacAddress().isEmpty())
        DialogHelper.showErrorMessage(ReprintCecActivity.this, R.string.erro_text, R.string.pair_info,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Intent intent = new Intent(ReprintCecActivity.this,
                PrinterDiscoverActivity.class);
              startActivityForResult(intent, REQUEST_FOR_PAIR_CODE);
            }
          });
      else
        print();
    }
  };

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

    if (resultCode == CommonStatusCodes.SUCCESS)
      if (requestCode == REQUEST_FOR_PAIR_CODE)
        print();

//    super.onActivityResult(requestCode, resultCode, data);
  }

  private void print() {

    if (pos < 0) {
      DialogHelper.showInformationMessage(ReprintCecActivity.this, R.string.informar_text,
        R.string.selecione_nota_reimprimir, null);
      return;
    }

    invoice = invoices.get(pos);

    SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());
    CecType cecType = GLOBAL.self().getCecDanfe(operation, false);
    String m = cecType.getName().toUpperCase();

    String question = String.format(Locale.getDefault(), getString(R.string.reprint_cec),
      m, invoice.getNumero(), invoice.getSerie());

    adapter = new InvoiceViewListAdapter(ReprintCecActivity.this, invoices, false);

    lstInvoiceReprintCec.setAdapter(adapter);

    DialogHelper.showQuestionMessage(ReprintCecActivity.this,
      getString(R.string.confirmar_text), question, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
          try {
            invoice.setItens(DatabaseApp.self().getDatabase().invoiceItemDao()
              .findByIdNota(invoice.getId()));

            Bitmap bitmap = BitmapFactory.decodeFile(UtilHelper.getSignFileName(invoice));

            PrintCEC pCEC;

            if (SuperOperation.getOperation(invoice.getTipoTransacao()).getOperationType()
              .equals(OperationType.RPS))
              pCEC = new PrintREC(ReprintCecActivity.this);
            else
              pCEC = new PrintCEC(ReprintCecActivity.this);

            pCEC.setInvoice(invoice)
              .setReprint(true)
              .setAutomatic(false)
              .setSignature(bitmap)
              .setFinishExecuteCallback(new MyCallbackInterface.CallbackBooleanInterface() {
                @Override
                public void execute(Boolean success) {
                  if (success)
                    finish();
                  else
                    DialogHelper.showQuestionMessage(ReprintCecActivity.this,
                      getString(R.string.confirmar_text),
                      String.format(getString(R.string.send_data_printer_fail),
                        GLOBAL.self().getCecDanfe(operation, false).getName()),
                      new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                          print();
                        }
                      }, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                          finish();
                        }
                      }
                    );
                }
              })
              .execute();

          } catch (Exception e) {
            e.printStackTrace();
            LogHelper.self().error(TAG, e);

            DialogHelper.showQuestionMessage(ReprintCecActivity.this,
              getString(R.string.confirmar_text),
              String.format(getString(R.string.send_data_printer_fail),
                GLOBAL.self().getCecDanfe(operation, false).getName()),
              null, null
            );
          }
        }
      }, null);

  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reprint_cec);

    ImageButton btnConfirmarInvoiceReprint = findViewById(R.id.btnConfirmarInvoiceReprint);
    btnConfirmarInvoiceReprint.setOnClickListener(btnConfirmaClickListener);

    lstInvoiceReprintCec = findViewById(R.id.lstInvoiceReprintCec);
    txtTituloReprintCec = findViewById(R.id.txtTituloReprintCec);

    String msg = String.format("%s %s %s %s",
      UtilHelper.padRight(getString(R.string.nota), ' ', 6),
      UtilHelper.padRight(getString(R.string.operacao), ' ', 17),
      UtilHelper.padRight(getString(R.string.evento), ' ', 8),
      getString(R.string.status_nfe));

    txtTituloReprintCec.setText(msg);
    txtTituloReprintCec.setVisibility(View.GONE);

    Long cdCustomer = cdCustomer = getIntent().getExtras().getLong("cdCustomer");

    if (cdCustomer == 0)
      cdCustomer = null;

    invoices = DatabaseApp.self().getDatabase().invoiceDao().find(cdCustomer,
      UtilHelper.padLeft(GLOBAL.self().getRoute().getNumeroViagem().toString(), '0', 6));

    adapter = new InvoiceViewListAdapter(this, invoices, true);

    lstInvoiceReprintCec.setAdapter(adapter);
    lstInvoiceReprintCec.setChoiceMode(ListView.FOCUSABLES_TOUCH_MODE);

    lstInvoiceReprintCec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position;
      }
    });
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
