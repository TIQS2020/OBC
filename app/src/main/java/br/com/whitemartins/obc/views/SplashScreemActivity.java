package br.com.whitemartins.obc.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import br.com.whitemartins.obc.R;
import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.util.Constants;
import br.com.whitemartins.obc.util.FileOutHelper;
import br.com.whitemartins.obc.util.ImageHelper;
import br.com.whitemartins.obc.util.InvoiceHelper;
import br.com.whitemartins.obc.util.PathHelper;
import br.com.whitemartins.obc.util.UtilHelper;

public class SplashScreemActivity extends AppCompatActivity {

  private static int SPLASH_TIME_OUT = 3000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);

    GLOBAL.self().setGlobalActivity(this);
    GLOBAL.self().init(this);
    //Iniciando as threads
    GLOBAL.self().startBackgroudServices(this);

    final boolean hasTravel = DatabaseApp.self().getDatabase().routeDao().getAll().size() > 0;


    new Handler().postDelayed(
        new Runnable() {
          @Override
          public void run() {
            if (hasTravel)
              startActivity(new Intent(SplashScreemActivity.this, BeginTravelActivity.class));
            else
              startActivity(new Intent(SplashScreemActivity.this, LoadTravelActivity.class));
          }
        }, SPLASH_TIME_OUT
    );
  }
}
