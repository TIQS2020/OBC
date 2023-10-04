package br.com.whitemartins.obc.views;


import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.util.UtilHelper;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

  protected String TAG = this.getClass().getSimpleName();

  @Override
  public void onBackPressed() {
    // code here to show dialog
    // super.onBackPressed();  // optional depending on your needs
  }

  private void hideKeyboard() {
    UtilHelper.hideKeyboardFrom(this, getCurrentFocus());
  }

  protected void addScreenClickHideKeyboard(View screen) {
    if (screen != null)
      screen.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          hideKeyboard();
        }
      });
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    //Usado para pegar e setar o click no componente View Layout para esconde o teclado
    //Toda tela deve ter um componente com o nome screen para que funcione
    addScreenClickHideKeyboard(findViewById(R.id.screen));
    addScreenClickHideKeyboard(findViewById(R.id.screen2));
  }
}
