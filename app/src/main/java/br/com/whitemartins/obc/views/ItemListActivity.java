package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.ItemListAdapter;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.model.ItemPrice;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DataGetHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class ItemListActivity extends BaseActivity {
  private SearchView searchView;
  private Customer customer;
  private ListView itemList;
  private int pos;

  private DialogInterface.OnClickListener positiveClickListener = new DialogInterface.OnClickListener() {

    public void onClick(DialogInterface dialog, int whichButton) {

      ItemPrice price = (ItemPrice) itemList.getItemAtPosition(pos);

      Integer position = GLOBAL.self().getPrices().indexOf(price);

      if (position != -1)
        price = GLOBAL.self().getPrices().get(position);

      Intent addItemActivity = new Intent(ItemListActivity.this, AddItemActivity.class);

      addItemActivity.putExtra("price", price);
      addItemActivity.putExtra("position", position);
      startActivity(addItemActivity);
      searchView.setQuery("", false);
      finish();
    }
  };

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_item_list);

    customer = GLOBAL.self().getCustomer();

    Long cdPreOrder = GLOBAL.self().getPreOrder().getCdPreOrder();
    String numeroNotaOrigem = GLOBAL.self().getPreOrder().getNumeroNotaOrigem();
    //Transferecias de estoque não tem customer

    Long cdCustomer = null;
    String flNovoFaturamento = "";

    if (customer != null) {
      cdCustomer = customer.getCdCustomer();
      flNovoFaturamento = customer.getFlNovoFaturamento();
    }

    //Caso o paciente tenha preço diferenciado, será usado o código do paciente ao invés do
    //código da operadora para buscar o preço
    if (GLOBAL.self().getPatient() != null
      && ConstantsEnum.YES.getValue().equals(GLOBAL.self().getPatient().getPrecoDiferente())) {
      cdCustomer = GLOBAL.self().getPatient().getCdPaciente();
    }

    itemList = findViewById(R.id.item_list);

    List<ItemPrice> itp = DataGetHelper.getItemsPrice(cdCustomer, null, numeroNotaOrigem,
      GLOBAL.self().getTipoItem(), flNovoFaturamento);

    final ItemListAdapter adapter = new ItemListAdapter(this, itp);
    itemList.setAdapter(adapter);
    itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemPrice p = adapter.getItem(position);

        pos = position;

        String e = getString(R.string.incluir_item_pedido);
        String m = String.format(Locale.getDefault(), e,
          p.getItem().getCdItem().toString() + " " + p.getItem().getDescricaoProduto());

        DialogHelper.showQuestionMessage(ItemListActivity.this,
          ItemListActivity.this.getString(R.string.confirmar_text), m,
          positiveClickListener, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              searchView.setQuery("", false);
            }
          });
      }
    });

    itemList.setOnScrollListener(new AbsListView.OnScrollListener() {
      @Override
      public void onScrollStateChanged(AbsListView view, int scrollState) {
        UtilHelper.hideKeyboardFrom(ItemListActivity.this, getCurrentFocus());
      }

      @Override
      public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

      }
    });

    searchView = findViewById(R.id.srcItem);

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

  }
}