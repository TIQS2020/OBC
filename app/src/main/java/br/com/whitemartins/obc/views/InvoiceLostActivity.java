package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.FileHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class InvoiceLostActivity extends BaseActivity {

  ImageButton btnConfirmarInvoiceView;
  TextView txtTituloInvoiceView;
  ListView lstInvoiceView;
  ArrayAdapter<String> adapter;
  Invoice invoice;
  List<String> all = new ArrayList<>();
  int pos = -1;

  private View.OnClickListener btnConfirmarListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      if (pos < 0) {
        DialogHelper.showInformationMessage(InvoiceLostActivity.this, R.string.informar_text,
          R.string.selecione_nota_emitir, null);
        return;
      }

      String[] values = all.get(pos).split("\\r");

      Invoice invoice = Invoice.newInstance();
      invoice.setNumero(UtilHelper.convertToLongDef(values[0], 0));
      invoice.setSerie(UtilHelper.convertToLongDef(values[1], 0));

      if (values[2].equalsIgnoreCase(InvoiceType.ENTRADA.getName()))
        invoice.setTipoNota(InvoiceType.ENTRADA.getValue());
      else
        invoice.setTipoNota(InvoiceType.SAIDA.getValue());

      GLOBAL.self().setInvoice(invoice);

      DialogHelper.showInputPickTravel(InvoiceLostActivity.this, new MyCallbackInterface.CallbackVoidInterface() {
        @Override
        public void execute() {
          setResult(CommonStatusCodes.SUCCESS);
          finish();
        }
      });
    }
  };

  private void sair() {

    DialogHelper.showQuestionMessageStyled(this, R.string.attention,
      R.string.exit_message, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          DialogHelper.showInputPasswordDialog(InvoiceLostActivity.this,
            R.string.exit_title, new UtilHelper.OnOkListener() {
              @Override
              public boolean onOkClick(String value) {
                FileHelper
                  .self(InvoiceLostActivity.this)
                  .setOptionType(OptionType.APAGAR_BASE)
                  .setPostExecuteCallback(new MyCallbackInterface.CallbackBooleanInterface() {
                    @Override
                    public void execute(Boolean success) {
                      finishAffinity();
                      System.exit(0);

                    }
                  })
                  .execute();
                return true;
              }
            }, false);
        }
      }, null);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    //Relatório não permitido para viagens HC
    if (!GLOBAL.self().isHomecare())
      getMenuInflater().inflate(R.menu.menu_report, menu);

    getMenuInflater().inflate(R.menu.menu_config_printer, menu);
    getMenuInflater().inflate(R.menu.menu_exit, menu);

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_exit:
        sair();
        break;

      default:
        ActivityHelper.events(this, item);

    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_invoice_lost);

    btnConfirmarInvoiceView = findViewById(R.id.btnConfirmarInvoiceView);
    btnConfirmarInvoiceView.setOnClickListener(btnConfirmarListener);

    lstInvoiceView = findViewById(R.id.lstInvoiceView);
    lstInvoiceView.setChoiceMode(ListView.FOCUSABLES_TOUCH_MODE);

    txtTituloInvoiceView = findViewById(R.id.txtTituloInvoiceView);

    String msg = String.format("%s\r%s\r%s ",
      UtilHelper.padRight(getString(R.string.nota), ' ', 6),
      UtilHelper.padRight(getString(R.string.serie), ' ', 6),
      UtilHelper.padRight(getString(R.string.tipo), ' ', 9));

    txtTituloInvoiceView.setText(msg);
    txtTituloInvoiceView.setVisibility(View.GONE);

    List<String> in = getIntent().getStringArrayListExtra("in");
    List<String> out = getIntent().getStringArrayListExtra("out");

    all = new ArrayList<>();
    all.addAll(in);
    all.addAll(out);

    adapter = new ArrayAdapter<>(this, R.layout.list_view_item, all);
    lstInvoiceView.setAdapter(adapter);
    lstInvoiceView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position;
      }
    });
  }
}
