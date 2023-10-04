package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.dao.GenericDao;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.PreOrder;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class FutViewActivity extends BaseActivity {

  ListView lstInvoiceFutView;
  View lastSelectedView;
  List<PreOrder> preOrders;
  ArrayAdapter<PreOrder> adapter;
  ImageButton btnConfirmarFutView;
  int pos;

  private View.OnClickListener btnConfirmarListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {

      final PreOrder preOrder = preOrders.get(pos);

      DialogHelper.showQuestionMessage(FutViewActivity.this,
        getString(R.string.confirmar_text),
        String.format(getString(R.string.confirmar_fut_entrega), preOrder.getNumeroNotaOrigem()),
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {

            GLOBAL.self().setPreOrder(preOrder);

            startActivity(new Intent(FutViewActivity.this, InvoiceActivity.class));
          }
        }, null);
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fut_view);

    lstInvoiceFutView = findViewById(R.id.lstInvoiceFutView);
    btnConfirmarFutView = findViewById(R.id.btnConfirmarFutView);
    btnConfirmarFutView.setOnClickListener(btnConfirmarListener);

    Long cdCustomer = null;

    if (GLOBAL.self().getCustomer() != null)
      cdCustomer = GLOBAL.self().getCustomer().getCdCustomer();

    preOrders = GenericDao.self().getPreOrders(cdCustomer);

    adapter = new ArrayAdapter<>(this,
      android.R.layout.test_list_item, preOrders);

    lstInvoiceFutView.setAdapter(adapter);
    lstInvoiceFutView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      public void clearSelection() {
        if (lastSelectedView != null)
          lastSelectedView.setBackgroundResource(android.R.color.white);
      }

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position;
        clearSelection();
        lastSelectedView = view;
        view.setBackgroundResource(android.R.color.darker_gray);
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

    return true;
  }

}
