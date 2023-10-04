package br.com.whitemartins.obc.views;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.common.api.CommonStatusCodes;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.util.ActivityHelper;
import br.com.whitemartins.obc.util.InvoiceMessageHelper;

public class AddMessageActivity extends BaseActivity {

  EditText edt1, edt2, edt3, edt4, edt5, edt6;
  private View.OnClickListener confirmOrderClickListener = new View.OnClickListener() {
    public void onClick(View v) {

      String msg = edt1.getText().toString().trim() +
        "_" + edt2.getText().toString().trim() +
        "_" + edt3.getText().toString().trim() +
        "_" + edt4.getText().toString().trim() +
        "_" + edt5.getText().toString().trim() +
        "_" + edt6.getText().toString().trim();

      //Setando a mensagem adiconial na classe responsável pela criação de TODAS as mensagens da NFe
      InvoiceMessageHelper.self(AddMessageActivity.this, null).setAddMessage(msg);

      setResult(CommonStatusCodes.SUCCESS);

      finish();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_message);

    edt1 = findViewById(R.id.edt1);
    edt2 = findViewById(R.id.edt2);
    edt3 = findViewById(R.id.edt3);
    edt4 = findViewById(R.id.edt4);
    edt5 = findViewById(R.id.edt5);
    edt6 = findViewById(R.id.edt6);

    ImageButton btnConfirmarMensagemAdicional = findViewById(R.id.btnConfirmarMensagemAdicional);
    btnConfirmarMensagemAdicional.setOnClickListener(confirmOrderClickListener);

    addScreenClickHideKeyboard(findViewById(R.id.screen));
    addScreenClickHideKeyboard(findViewById(R.id.screen2));
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
