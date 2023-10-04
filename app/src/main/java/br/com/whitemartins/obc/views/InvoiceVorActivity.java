package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.ItemsVorListAdapter;
import br.com.whitemartins.obc.enumeration.InvoiceType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class InvoiceVorActivity extends BaseActivity {
  ListView listItemVor;
  private TextView txtCodClienteVor;
  private TextView txtFilialVor;
  private TextView txtNotaVor;
  private TextView txtTotalItemVor;
  private EditText edtNotaFiscalJDE, edtSerieJDE;

  private View.OnClickListener finalizarListClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      if (isValid()) {
        GLOBAL.self().setInvoiceVOR(edtNotaFiscalJDE.getText().toString() + "|" +
          edtSerieJDE.getText().toString());

        finish();
      }
    }
  };

  private boolean isValid() {

    if (edtNotaFiscalJDE.getText().toString().isEmpty()) {
      DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.invoice_jde_error,
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            edtNotaFiscalJDE.requestFocus();
          }
        });
      return false;
    } else if (edtSerieJDE.getText().toString().isEmpty()) {
      DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.serie_jde_error,
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            edtSerieJDE.requestFocus();
          }
        });

      return false;
    } else {

      try {
        int NFDigVerif = UtilHelper.Module11VOR(edtNotaFiscalJDE.getText().toString()
          .substring(0, edtNotaFiscalJDE.getText().toString().length() - 1));

        int check = Integer.parseInt(edtNotaFiscalJDE.getText().toString()
          .substring(edtNotaFiscalJDE.getText().toString().length() - 1,
            edtNotaFiscalJDE.getText().toString().length()));

        if (NFDigVerif != check) {
          DialogHelper.showErrorMessage(this, R.string.erro_text,
            R.string.invoice_jde_invalid,
            new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                edtNotaFiscalJDE.requestFocus();
              }
            });
          return false;
        }
      } catch (NumberFormatException e) {
        e.printStackTrace();
        DialogHelper.showErrorMessage(this, R.string.erro_text,
          R.string.invoice_jde_invalid,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              edtNotaFiscalJDE.requestFocus();
            }
          });
        return false;

      }
    }

    return true;
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_app, menu);

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    setResult(CommonStatusCodes.ERROR);

    ActivityHelper.events(this, item);

    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_invoice_vor);

    TextView txtTipoPedidoVor = findViewById(R.id.txtTipoPedidoVor);
    txtCodClienteVor = findViewById(R.id.txtCodClienteVor);
    txtFilialVor = findViewById(R.id.txtFilialVor);
    txtNotaVor = findViewById(R.id.txtNotaVor);
    txtTotalItemVor = findViewById(R.id.txtTotalItemVor);
    edtNotaFiscalJDE = findViewById(R.id.edtNotaFiscalJDE);
    edtSerieJDE = findViewById(R.id.edtSerieJDE);
    listItemVor = findViewById(R.id.listItemVor);

    txtTipoPedidoVor.setText(String.format("%s: %s", getString(R.string.order_sell),
      GLOBAL.self().getOperation().getOperationType().getName()));

    txtCodClienteVor.setText(String.format(Locale.getDefault(), "%s %d",
      getString(R.string.client_number), GLOBAL.self().getCustomer().getCdCustomer()));

    Invoice nextInvoice = DatabaseApp.self().getDatabase().invoiceDao()
      .findByTipoNota(InvoiceType.SAIDA.getValue());

    Long numeroNota = GLOBAL.self().getGeneral().getNumeroNotaSaida();

    if (nextInvoice != null)
      numeroNota = nextInvoice.getNumero() + 1;

    Integer notaDV = UtilHelper.Module11VOR(numeroNota.toString());

    txtNotaVor.setText(String.format(Locale.getDefault(), "%s %d%d/%d",
      getString(R.string.invoice_obc), numeroNota, notaDV, GLOBAL.self().getGeneral().getSerieNotaSaida()));

    txtFilialVor.setText(String.format(Locale.getDefault(), "%s %s",
      getString(R.string.unidade), GLOBAL.self().getRoute().getCdFilialJde()));

    txtTotalItemVor.setText(String.format(Locale.getDefault(), "%s %d",
      getString(R.string.total_itens), GLOBAL.self().getPrices().size()));

    ItemsVorListAdapter itemPriceListAdapter = new ItemsVorListAdapter(this,
      GLOBAL.self().getPrices());

    listItemVor.setAdapter(itemPriceListAdapter);

    ImageButton btnFinalizarPedidoVor = findViewById(R.id.btnFinalizarPedidoVor);
    btnFinalizarPedidoVor.setOnClickListener(finalizarListClickListener);

  }

}
