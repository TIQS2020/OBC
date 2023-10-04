package br.com.whitemartins.obc.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.util.UtilHelper;


public class ItemsVorListAdapter extends ArrayAdapter<ItemPrice> {
  private Activity context;
  private List<ItemPrice> prices;

  public ItemsVorListAdapter(Activity context, List<ItemPrice> prices) {
    super(context, 0, prices);
    this.context = context;
    this.prices = prices;
  }

  @Override
  public int getCount() {
    return prices.size();
  }

  @Override
  public ItemPrice getItem(int position) {
    return prices.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }


  @NonNull
  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {

    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.item_list_adapter, null);
    }

    TextView tvItem = convertView.findViewById(R.id.item_descricao);

    tvItem.setText(String.format(Locale.getDefault(), "Item: %d Capacidade: %s\n%s\nQuantidade: %s",
      getItem(position).getItem().getCdItem(),
      getItem(position).getItem().getCapacidadeProduto(),
      getItem(position).getItem().getDescricaoProduto(),
      UtilHelper.formatDoubleString(getItem(position).getQuantidadeVendida(), 0))
    );

    if (position % 2 == 0)
      tvItem.setTextColor(context.getColor(R.color.pressed_color));
    else
      tvItem.setTextColor(context.getColor(R.color.appTextColor));


    return convertView;
  }
}
