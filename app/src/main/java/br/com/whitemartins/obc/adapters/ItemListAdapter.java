package br.com.whitemartins.obc.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.ItemPrice;


public class ItemListAdapter extends ArrayAdapter<ItemPrice> {
  private Activity context;
  private List<ItemPrice> prices;
  private List<ItemPrice> pricesFull;

  public ItemListAdapter(Activity context, List<ItemPrice> prices) {
    super(context, 0, prices);
    this.context = context;
    this.prices = prices;
    this.pricesFull = prices;
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

    tvItem.setText(String.format(Locale.getDefault(), "Item: %d Capacidade: %s\n%s",
      getItem(position).getItem().getCdItem(),
      getItem(position).getItem().getCapacidadeProduto(),
      getItem(position).getItem().getDescricaoProduto()));

    if (position % 2 == 0)
      tvItem.setTextColor(context.getColor(R.color.pressed_color));
    else
      tvItem.setTextColor(context.getColor(R.color.appTextColor));

    return convertView;
  }

  public Filter getFilter() {
    return new CustomFilter();
  }

  class CustomFilter extends Filter {

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
      FilterResults results = new FilterResults();

      if (constraint != null && constraint.length() > 0) {
        constraint = constraint.toString().toUpperCase();

        ArrayList<ItemPrice> filters = new ArrayList<>();

        //get specific items
        for (int i = 0; i < prices.size(); i++) {
          if (prices.get(i).getItem().getCdItem().toString().toUpperCase().contains(constraint) ||
            prices.get(i).getItem().getDescricaoProduto().toUpperCase().contains(constraint)) {

            ItemPrice p = prices.get(i);

            filters.add(p);
          }
        }

        results.count = filters.size();
        results.values = filters;

      } else {
        results.count = pricesFull.size();
        results.values = pricesFull;
      }

      return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      prices = (ArrayList<ItemPrice>) results.values;
      notifyDataSetChanged();
    }

  }
}
