package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.CustomerListAdapter;
import br.com.whitemartins.obc.enumeration.CustomerListType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.CustomerPatient;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DataGetHelper;
import br.com.whitemartins.obc.util.UtilHelper;


public class CustomerListActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_customer_list);

    CustomerListType type = GLOBAL.self().getCustomerListType();

    if (type == null)
      type = CustomerListType.INTERCOMPANY;

    ArrayList<CustomerPatient> custPat = new ArrayList<>();

    List<Customer> customers = DataGetHelper.getListClients(type, null);

    for (Customer customer : customers) {
      custPat.add(new CustomerPatient(customer.getCdCustomer(), customer.getNome(), customer.getCnpj()));
    }

    final CustomerListAdapter adapter = new CustomerListAdapter(this,
      android.R.layout.test_list_item, custPat);

    final TextView txtHeaderCustomerList = findViewById(R.id.txtHeaderCustomerList);

    txtHeaderCustomerList.setText(
      String.format("%s %s", UtilHelper.padRight(getString(R.string.codigo), ' ', 8),
        UtilHelper.padRight(getString(R.string.client_cnpj_cpf), ' ', 14)));

    final SearchView searchView = findViewById(R.id.srcCustomer);

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
      }
    });

    final ListView customerList = findViewById(R.id.client_list);
    customerList.setAdapter(adapter);
    customerList.setOnScrollListener(new AbsListView.OnScrollListener() {
      @Override
      public void onScrollStateChanged(AbsListView view, int scrollState) {
        UtilHelper.hideKeyboardFrom(CustomerListActivity.this, getCurrentFocus());
      }

      @Override
      public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
      }
    });

    customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CustomerPatient customerPatient = (CustomerPatient) customerList.getItemAtPosition(position);

        if (GLOBAL.self().isPaciente(customerPatient.getCodigo()) == null) {
          Customer customer = DatabaseApp.self().getDatabase().customerDao().findById(customerPatient.getCodigo());
          GLOBAL.self().setCustomer(customer);
        }

        Intent confirmClient = new Intent(CustomerListActivity.this,
          ConfirmCustomerActivity.class);
        startActivity(confirmClient);
        searchView.setQuery("", false);
        finish();
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

//    int id = item.getItemId();
//
//    if (id == R.id.menu_voltar_client_stop)
//      finish();
    return super.onOptionsItemSelected(item);
  }
}
