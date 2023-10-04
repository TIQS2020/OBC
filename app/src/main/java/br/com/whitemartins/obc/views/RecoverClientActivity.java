package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.common.api.CommonStatusCodes;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.model.Customer;
import br.com.whitemartins.obc.timer.RecoverClientTimer;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;

public class RecoverClientActivity extends BaseActivity {

  EditText edtCdCustomerRecoveryClient;
  Long cdCustomer;

  private MyCallbackInterface.CallbackBooleanInterface executeNotify = new MyCallbackInterface.CallbackBooleanInterface() {
    @Override
    public void execute(Boolean success) {
      if (success)
        setResult(CommonStatusCodes.SUCCESS);
      else
        setResult(CommonStatusCodes.ERROR);

      finish();
    }
  };

  private View.OnClickListener confirmClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      sendAndConsult();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_recover_client);

    edtCdCustomerRecoveryClient = findViewById(R.id.edtCdCustomerRecoveryClient);

    cdCustomer = getIntent().getLongExtra("cdCustomer", 0);

    ImageButton confirmClient = findViewById(R.id.btnConfimarRecoveryClient);
    confirmClient.setOnClickListener(confirmClickListener);

    if (cdCustomer > 0) {
      edtCdCustomerRecoveryClient.setText(cdCustomer.toString());
      edtCdCustomerRecoveryClient.setEnabled(false);
      sendAndConsult();
    }
  }

  boolean validateWMCustomer(Long cdCustomer) {
    if (cdCustomer.toString().length() == 4) {
      Customer customer = DatabaseApp.self().getDatabase().customerDao().findById(cdCustomer);
      return customer != null;
    }

    return true;
  }

  private void sendAndConsult() {

    final long timeout = UtilHelper.convertToLongDef(XmlConfig.self().getTimeOut1(), 0) * 1000;

    boolean valido = edtCdCustomerRecoveryClient.getText().toString().length() == 4 ||
      edtCdCustomerRecoveryClient.getText().toString().length() == 8;

    if (!valido) {
      DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.cliente_invalido,
        null);
      return;
    }

    final Long cdCustomer = UtilHelper.convertToLongDef(edtCdCustomerRecoveryClient.getText().toString(),
      0);

    if (valido) {
      if (!validateWMCustomer(cdCustomer))
        DialogHelper.showErrorMessage(this, R.string.erro_text, R.string.cia_nao_carregada,
          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              finish();
            }
          });
      else
        DialogHelper.showQuestionMessage(this, R.string.confirmar_text, R.string.recuperar_cliente,

          new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              new RecoverClientTimer(RecoverClientActivity.this, timeout, 1000)
                .setCdCustomer(cdCustomer)
                .setNotifyOwner(executeNotify)
                .start();
            }
          }, null
        );
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_app, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    ActivityHelper.events(this, item);
    return super.onOptionsItemSelected(item);
  }

}
