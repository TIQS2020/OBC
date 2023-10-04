package br.com.whitemartins.obc.token;

import java.net.HttpURLConnection;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import br.com.whitemartins.obc.enumeration.HttpMethodType;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.util.ConnectionHelper;
import br.com.whitemartins.obc.xml.XmlConfig;
import br.com.whitemartins.obc.xml.XmlDataMediador;
import br.com.whitemartins.obc.xml.XmlRetorno;

public class TokenHelper {

  private static final long TEMPO_EXPIRAR_OTP = 60;
  private static TokenHelper _self;
  private final String HOST = XmlConfig.self().getUrlServidorNFe();
  private final String HTTP_URL_TOKEN = HOST + "api/service/ativarUsuario/%s/%s";

  private XmlDataMediador xmlDataMediador;

//  private WeakReference<Activity> activity;

  public static TokenHelper self() {
    if (_self == null)
      _self = new TokenHelper();

    return _self;
  }

  //  @RequiresApi(api = Build.VERSION_CODES.O)
  //  timeShiftSegundos = Referente ao servidor
  private static long calculaTimeShiftToken(Long timeShiftSegundos) {

    Calendar utcTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    long utcSec = utcTime.getTimeInMillis() / 1000;
    return utcSec - timeShiftSegundos;
  }

//  public TokenHelper setActivity(Activity activity) {
//    this.activity = new WeakReference<>(activity);
//    return this;
//  }

  private long syncTime() {
    HttpURLConnection connection = null;

    try {
      String url = String.format(Locale.getDefault(), HTTP_URL_TOKEN,
        GLOBAL.self().getImei(), "");

      connection = ConnectionHelper.self().getHttpConn( url, HttpMethodType.POST.getValue(),
        true);

      if (connection.getResponseCode() != HttpURLConnection.HTTP_OK)
        return 0;

      XmlRetorno.self().clearFields();
      XmlRetorno.self().parseXML(connection.getInputStream());

      if (XmlRetorno.self().getCodigoRetorno() > 0)
        throw new Throwable(XmlRetorno.self().getMensagemRetorno());

      xmlDataMediador = (XmlDataMediador) XmlDataMediador.newInstance()
        .read(XmlRetorno.self().getConteudoConsulta());
//      xmlDataMediador.saveFile();

      return calculaTimeShiftToken(xmlDataMediador.getTimeShiftSegundos());

    } catch (Throwable e) {
    } finally {
      if (connection != null)
        connection.disconnect();
    }

    return 0;
  }

  public String gerarToken(String semente) {

    long timeShift = syncTime();
    return TokenOTP.gerar(semente, timeShift, TEMPO_EXPIRAR_OTP);
  }

}