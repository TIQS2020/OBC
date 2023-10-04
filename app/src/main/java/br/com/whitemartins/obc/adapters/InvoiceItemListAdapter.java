package br.com.whitemartins.obc.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.interafce.adapterListener;
import br.com.whitemartins.obc.model.InvoiceItem;
import br.com.whitemartins.obc.util.UtilHelper;


public class InvoiceItemListAdapter extends ArrayAdapter<InvoiceItem> {
  private Activity context;
  private List<InvoiceItem> invoiceItems;

  public InvoiceItemListAdapter(Activity context, List<InvoiceItem> invoiceItems, adapterListener listener) {
    super(context, 0, invoiceItems);
    this.context = context;
    this.invoiceItems = invoiceItems;
  }

  @Override
  public int getCount() {
    return invoiceItems.size();
  }

  @Override
  public InvoiceItem getItem(int position) {
    return invoiceItems.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.item_cec_list_adapter, null);
    }

    TextView tvItem = convertView.findViewById(R.id.item_descricao);

    InvoiceItem invoiceItem = getItem(position);

    if (tvItem != null) {
      String text = //invoiceItem.getCdItem().toString() + " " +
        invoiceItem.getNomeItem() + "\n" + context.getString(R.string.volume) + ": " +
          UtilHelper.formatDoubleString(invoiceItem.getVolume(), 2);

      tvItem.setText(text);
    }
    return convertView;
  }
}
