package br.com.whitemartins.obc.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.model.CustomerPatient;

public class CustomerListAdapter extends ArrayAdapter<CustomerPatient> implements Filterable {
  ArrayList<CustomerPatient> customerPatients;
  ArrayList<CustomerPatient> filterList;
  private Context context;

  public CustomerListAdapter(Context context, int resource, ArrayList<CustomerPatient> customerPatients) {
    super(context, resource);
    this.context = context;
    this.customerPatients = customerPatients;
    this.filterList = customerPatients;
  }

  @Override
  public int getCount() {
    return customerPatients.size();
  }

  @Override
  public CustomerPatient getItem(int position) {
    return customerPatients.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @SuppressLint("ResourceAsColor")
  @Override
  public View getView(final int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.list_view_customer, null);
    }

    TextView item_name = convertView.findViewById(R.id.txtCheck);
    item_name.setFocusable(false);
    item_name.setText(getItem(position).toString());

    if (position % 2 == 0)
      item_name.setTextColor(context.getColor(R.color.pressed_color));
    else
      item_name.setTextColor(context.getColor(R.color.appTextColor));

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

        ArrayList<CustomerPatient> filters = new ArrayList<>();

        //get specific items
        for (int i = 0; i < filterList.size(); i++) {
          if (filterList.get(i).getCodigo().toString().contains(constraint) ||
            filterList.get(i).getNome().toUpperCase().contains(constraint) ||
            filterList.get(i).getCnpj().toUpperCase().contains(constraint)
          ) {

            CustomerPatient p = new CustomerPatient(filterList.get(i).getCodigo(),
              filterList.get(i).getNome(), filterList.get(i).getCnpj());

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
      customerPatients = (ArrayList<CustomerPatient>) results.values;
      notifyDataSetChanged();
    }

  }

}
