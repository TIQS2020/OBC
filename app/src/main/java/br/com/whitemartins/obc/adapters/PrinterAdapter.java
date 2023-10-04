package br.com.whitemartins.obc.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.zebra.sdk.printer.discovery.DiscoveredPrinterBluetooth;

import java.util.ArrayList;

import br.com.whitemartins.obc.R;

public class PrinterAdapter extends ArrayAdapter<DiscoveredPrinterBluetooth> implements Filterable {
  ArrayList<DiscoveredPrinterBluetooth> printers;
  ArrayList<DiscoveredPrinterBluetooth> filterList;
  private Context context;

  public PrinterAdapter(Context context, int resource, ArrayList<DiscoveredPrinterBluetooth> printerBluetooths) {
    super(context, resource);
    this.context = context;
    this.printers = printerBluetooths;
    this.filterList = printerBluetooths;
  }

  @Override
  public int getCount() {
    return printers.size();
  }

  @Override
  public DiscoveredPrinterBluetooth getItem(int position) {
    return printers.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.list_view_printer, null);
    }

    TextView item_name = convertView.findViewById(R.id.txtCheck);
    item_name.setFocusable(false);

    String fn = printers.get(position).friendlyName;

    if (fn == null)
      fn = "";

    item_name.setText(String.format("Nome: %s \r\nEndereço Mac: %s ", fn,
      printers.get(position).address));

    return convertView;
  }

  public void notifyDataSetChanged() {
    super.notifyDataSetChanged();
  }

  @NonNull
  @Override
  public Filter getFilter() {
    return new CustomFilter();
  }

  class CustomFilter extends Filter {

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
      FilterResults results = new FilterResults();

      if (constraint != null && constraint.length() > 0) {
        constraint = constraint.toString().toUpperCase();

        ArrayList<DiscoveredPrinterBluetooth> filters = new ArrayList<>();

        //get specific items
        for (int i = 0; i < filterList.size(); i++) {
          if (filterList.get(i).address.toUpperCase().contains(constraint) ||
            filterList.get(i).friendlyName.toUpperCase().contains(constraint)) {

            DiscoveredPrinterBluetooth p = new DiscoveredPrinterBluetooth(filterList.get(i).address,
              filterList.get(i).friendlyName);

            filters.add(p);
          }
        }

        results.count = filters.size();
        results.values = filters;

      } else {
        results.count = filterList.size();
        results.values = filterList;

      }

      return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
      printers = (ArrayList<DiscoveredPrinterBluetooth>) results.values;
      notifyDataSetChanged();
    }

  }

}
