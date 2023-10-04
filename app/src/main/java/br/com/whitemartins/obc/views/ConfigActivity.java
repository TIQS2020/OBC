package br.com.whitemartins.obc.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.OptionType;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.util.ConnectionHelper;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;

public class ConfigActivity extends BaseActivity {

  XmlConfig config = XmlConfig.self();
  TextView txtStatusConfig;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_config);

    config.read();

    final EditText edtTimeOut = findViewById(R.id.edtTimeOut);
    edtTimeOut.setText(config.getTempoTotal());

    final EditText edtServidorComunicacao = findViewById(R.id.edtServidorComunicacao);
    edtServidorComunicacao.setText(config.getUrlServidorNFe());

    final EditText edtServidorContigencia = findViewById(R.id.edtServidorContigencia);
    edtServidorContigencia.setText(config.getUrlServidorContingencia());

    txtStatusConfig = findViewById(R.id.txtStatusConfig);
    txtStatusConfig.setText("");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_settings, menu);
    getMenuInflater().inflate(R.menu.menu_app, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_testar_conexao_config)
      testarConexao();
    else if (id == R.id.action_back)
      finish();

    return true;
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    UtilHelper.hideKeyboardFrom(this, getCurrentFocus());
  }

  private void testarConexao() {
    List<String> params = new ArrayList<>();

    new ConnectionHelper()
      .setOptionType(OptionType.TESTAR)
      .setTxtStatus(txtStatusConfig)
      .setPostExecuteCallback(new MyCallbackInterface.CallbackBooleanInterface() {
        @Override
        public void execute(Boolean success) {
          txtStatusConfig.setText("");

          if (success)
            DialogHelper.showInformationMessage(ConfigActivity.this, R.string.informar_text,
              R.string.conn_ok, null);
          else
            DialogHelper.showInformationMessage(ConfigActivity.this, R.string.informar_text,
              R.string.internet_conn_error, null);
        }
      })
      .execute(params);
  }

}
