package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import java.util.List;
import java.util.Locale;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.WantedClient;
import br.com.whitemartins.obc.util.UtilHelper;

public class RecoveryClientViewActivity extends BaseActivity {

  final int REQUEST_RECOVERY = 1;
  List<String> customers;
  ArrayAdapter<String> adapter;
  private int pos;
  private View.OnClickListener btnConfirmarListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      if (customers.size() > 0)
        recovery();
    }
  };

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == REQUEST_RECOVERY) {
      if (resultCode == CommonStatusCodes.SUCCESS) {
        customers.remove(pos);
        adapter.notifyDataSetChanged();
        if (customers.size() == 0)
          finish();
//        else
//          finish();
      }
    }
  }

  private void recovery() {

    String[] cust = customers.get(pos).split("\\ ");

    WantedClient wantedClient = new WantedClient();
    wantedClient.setCdCustomer(UtilHelper.convertToLongDef(cust[0], 0));
    wantedClient.setNumeroViagem(cust[1]);
    wantedClient.setDataViagem(UtilHelper.convertToDate(cust[2],
      ConstantsEnum.ddMMyyyy_barra.getValue()));

    GLOBAL.self().getRoute().setNumeroViagem(UtilHelper.convertToLongDef(wantedClient.getNumeroViagem(), 0));
    GLOBAL.self().getRoute().setDataViagem(wantedClient.getDataViagem());

    Intent intent = new Intent(RecoveryClientViewActivity.this, RecoverClientActivity.class);
    intent.putExtra("cdCustomer", wantedClient.getCdCustomer());
    startActivityForResult(intent, REQUEST_RECOVERY);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recovery_client_view);

    customers = getIntent().getStringArrayListExtra("customers");

    ImageButton btnConfirmarRecoveryClientView = findViewById(R.id.btnConfirmarRecoveryClientView);
    btnConfirmarRecoveryClientView.setOnClickListener(btnConfirmarListener);

    ListView lstRecoveryClientView = findViewById(R.id.lstRecoveryClientView);
    lstRecoveryClientView.setChoiceMode(ListView.FOCUSABLES_TOUCH_MODE);

    TextView txtTituloRecoveryClientView = findViewById(R.id.txtTituloRecoveryClientView);

    String msg = String.format(Locale.getDefault(), "%s%s %s",
      UtilHelper.padRight(getString(R.string.customer), ' ', 8),
      UtilHelper.padRight(getString(R.string.numero_viagem_2), ' ', 6),
      UtilHelper.padRight(getString(R.string.data_viagem), ' ', 10),
      getString(R.string.status_nfe));

    txtTituloRecoveryClientView.setText(msg);

    adapter = new ArrayAdapter<>(this, R.layout.list_view_item, customers);

    lstRecoveryClientView.setAdapter(adapter);
    lstRecoveryClientView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position;
      }
    });
  }


}
