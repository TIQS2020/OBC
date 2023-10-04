package br.com.whitemartins.obc.views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.interafce.MyCallbackInterface;
import br.com.whitemartins.obc.service.TokenService;
import br.com.whitemartins.obc.util.DialogHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.xml.XmlConfig;

public class ActivateDeviceActivity extends BaseActivity {

  EditText edtImei, edtChaveAtivacao;
  TextView edtUrlServidor;
  ImageButton btnConfirmarAtivacao, btnCancelarViagemAtivacao;

  private MyCallbackInterface.CallbackStringInterface
    callBack = new MyCallbackInterface.CallbackStringInterface() {
    @Override
    public void execute(String mensagem) {
      UtilHelper.setButtonStatus(ActivateDeviceActivity.this, btnConfirmarAtivacao,
        true);
      UtilHelper.setButtonStatus(ActivateDeviceActivity.this, btnCancelarViagemAtivacao,
        true);

      if (mensagem.isEmpty())
        DialogHelper.showOkMessage(ActivateDeviceActivity.this, R.string.informar_text,
          R.string.ativado_sucesso, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              //DatabaseApp.self().createDB(SeedHelper.getToken(ActivateDeviceActivity.this));

              setResult(CommonStatusCodes.SUCCESS);
              finish();
            }
          });
      else {
        DialogHelper.showInformationMessage(ActivateDeviceActivity.this,
          getString(R.string.informar_text), mensagem, null);

      }
    }
  };

  private View.OnClickListener confirmClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      UtilHelper.setButtonStatus(ActivateDeviceActivity.this, btnConfirmarAtivacao,
        false);
      UtilHelper.setButtonStatus(ActivateDeviceActivity.this, btnCancelarViagemAtivacao,
        false);

      new TokenService()
        .setActivationCode(edtChaveAtivacao.getEditableText().toString())
        .setPostExecuteCallback(callBack)
        .setActivity(ActivateDeviceActivity.this)
        .execute();
    }
  };

  private View.OnClickListener cancelClickListener = new View.OnClickListener() {
    public void onClick(View v) {
      setResult(CommonStatusCodes.ERROR);
      finish();
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_activate_device);

    GLOBAL.self().init(this);

    edtImei = findViewById(R.id.edtImei);
    edtImei.setEnabled(false);

    edtChaveAtivacao = findViewById(R.id.edtChaveAtivacao);
    edtUrlServidor = findViewById(R.id.edtUrlServidor);
    edtUrlServidor.setEnabled(false);
    edtUrlServidor.setText(XmlConfig.self().getUrlServidorNFe());

    btnConfirmarAtivacao = findViewById(R.id.btnConfirmarAtivacao);
    btnConfirmarAtivacao.setOnClickListener(confirmClickListener);

    btnCancelarViagemAtivacao = findViewById(R.id.btnCancelarViagemAtivacao);
    btnCancelarViagemAtivacao.setOnClickListener(cancelClickListener);
    edtImei.setText(GLOBAL.self().getImei());
    edtChaveAtivacao.requestFocus();
  }
}
