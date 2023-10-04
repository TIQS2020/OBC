package br.com.whitemartins.obc.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.enumeration.MovimentoIntegracaoType;
import br.com.whitemartins.obc.enumeration.OperationType;
import br.com.whitemartins.obc.enumeration.StatusNFeType;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.operations.SuperOperation;
import br.com.whitemartins.obc.util.UtilHelper;


public class InvoiceViewListAdapter extends ArrayAdapter<Invoice> {
  private Activity context;
  private List<Invoice> invoices;
  private boolean highlight;

  public InvoiceViewListAdapter(Activity context, List<Invoice> invoices, boolean highlight) {
    super(context, 0, invoices);
    this.context = context;
    this.invoices = invoices;
    this.highlight = highlight;
  }

  @Override
  public int getCount() {
    return invoices.size();
  }

  @Override
  public Invoice getItem(int position) {
    return invoices.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {

    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.list_view_item, null);
    }

    String texto = "";
    Invoice invoice = invoices.get(position);
    String evento = MovimentoIntegracaoType.getNameByValue(invoice.getTipoMovimentoIntegracao());
    evento = UtilHelper.padRight(evento, ' ', 7);
    SuperOperation operation = SuperOperation.getOperation(invoice.getTipoTransacao());

    String recibo = invoice.getCdCustomer().toString() + invoice.getNumero().toString() +
      invoice.getSerie().toString();

    if (OperationType.RPS.getValue().equals(operation.getOperationType().getValue()))
      texto = String.format(Locale.getDefault(),
        "%s: %s %s\n%s: %s\n%s: %s\n%s: %s %s: %s",
        context.getString(R.string.recibo),
        recibo, operation.getOperationType().getNickName(),
        context.getString(R.string.data_emissao),
        UtilHelper.formatDateStr(invoice.getDataMovimento(), ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue()),
        context.getString(R.string.customer),
        invoice.getCdCustomerService(),
        context.getString(R.string.evento),
        evento,
        context.getString(R.string.status_),
        StatusNFeType.getNameByValue(invoice.getStatus()));
    else
      texto = String.format(Locale.getDefault(),
        "%s: %s %s\n%s: %s\n%s: %s\n%s: %s %s: %s",
        context.getString(R.string.nota),
        invoice.getNumero().toString(), operation.getOperationType().getNickName(),
        context.getString(R.string.data_emissao),
        UtilHelper.formatDateStr(invoice.getDataMovimento(), ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue()),
        context.getString(R.string.customer),
        invoice.getCdCustomer(),
        context.getString(R.string.evento),
        evento,
        context.getString(R.string.status_),
        StatusNFeType.getNameByValue(invoice.getStatus()));

    CheckedTextView txtCheck = convertView.findViewById(R.id.txtCheck);
    txtCheck.setText(texto);

    if (highlight) {
      int color = StatusNFeType.getByValue(invoice.getStatus()).getColor();
      txtCheck.setTextColor(context.getColor(color));
    }


    return convertView;
  }
}
