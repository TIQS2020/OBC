package br.com.whitemartins.obc.views;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.adapters.ChargeConsultListAdapter;
import br.com.whitemartins.obc.enumeration.TypeItemType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Saldo;
import br.com.whitemartins.obc.util.ActivityHelper;

public class ChargeConsultActivity extends BaseActivity {
  private ListView itemList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_charge_consult);

    List<Saldo> saldos = DatabaseApp.self().getDatabase().saldoDao().find(
      TypeItemType.build(TypeItemType.GAS), GLOBAL.self().getRoute().getNumeroViagem());

    final ChargeConsultListAdapter adapter = new ChargeConsultListAdapter(this, saldos);
    itemList = findViewById(R.id.item_list);
    itemList.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_app, menu);

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    ActivityHelper.events(this, item);
    return super.onOptionsItemSelected(item);
  }
}
