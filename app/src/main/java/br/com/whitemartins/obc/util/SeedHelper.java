package br.com.whitemartins.obc.util;

import android.app.Activity;

import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.token.TokenHelper;

public class SeedHelper {

  public static String getSeed() {
    return GLOBAL.self().getStaticTable().getSemente();
  }

  public static String getToken(Activity activity) {
    String t = TokenHelper.self().gerarToken(getSeed());

//    if (BuildConfig.DEBUG)
//      t = "696610";

    return t.trim();
  }

  public static boolean isActive() {
    return !getSeed().isEmpty();
  }

}
