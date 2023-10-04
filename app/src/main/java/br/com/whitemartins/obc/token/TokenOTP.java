package br.com.whitemartins.obc.token;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Classe que gera a OTP utilizando o padr�o OATH TOTP para uma semente
 * conhecida
 *
 * @author ricardo
 */
public class TokenOTP {
  public static boolean LOG_ON = false;

  /**
   * @param semente              Semente do cliente para gera��o da OTP
   * @param timeShift            Diferen�a em segundos entre a hora do cliente e servidor
   * @param tempoExpirarSegundos
   * @return
   */
  public static String gerar(String semente, long timeShift, long tempoExpirarSegundos) {
    if (semente == null) {
      throw new IllegalArgumentException("Semente nula para gerar OTP");
    }
    Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    long time = currentTime.getTime().getTime();

    long movingFactor = getMovingFactor(time, timeShift, tempoExpirarSegundos);

    int segundos = currentTime.get(Calendar.SECOND);
    // para cada segundo gera um movingFactor diferente
    // soma para nao multiplicar por 0
    movingFactor *= (segundos + 1);

    HmacSha1OTP token = new HmacSha1OTP();
    String otp = token.generatePassword(semente, movingFactor);

    if (LOG_ON) {
      System.out.println(time + ": TokenOTP.gerar [timeShift/movingFactor] ["
        + timeShift + "/" + movingFactor + "] > " + otp);
    }
    return otp;
  }

  public static String gerar(String semente, long timeShift, long tempoExpirarSegundos, Date data) {
    if (semente == null) {
      throw new IllegalArgumentException("Semente nula para gerar OTP");
    }
    Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

    long time = data.getTime();

    long movingFactor = getMovingFactor(time, timeShift, tempoExpirarSegundos);

    int segundos = currentTime.get(Calendar.SECOND);
    // para cada segundo gera um movingFactor diferente
    // soma para nao multiplicar por 0
    movingFactor *= (segundos + 1);

    HmacSha1OTP token = new HmacSha1OTP();
    String otp = token.generatePassword(semente, movingFactor);

    if (LOG_ON) {
      System.out.println(time + ": TokenOTP.gerar [timeShift/movingFactor] ["
        + timeShift + "/" + movingFactor + "] > " + otp);
    }
    return otp;
  }


  /**
   * Retorna o MovingFactor
   * Se o MovingFactor for o mesmo, gera a mesma OTP.   * <p>
   *
   * @param time                 - time atual
   * @param timeShift            Diferen�a em segundos entre a hora do cliente e servidor
   * @param tempoExpirarSegundos
   * @return
   */
  public static long getMovingFactor(long time, long timeShift, long tempoExpirarSegundos) {

    // converte para segundo e  tira o timeShift
    // O sinal de menos faz a magica
    // time cliente < time servidor, timeshift � numero negativo. Ent�o vai somar o timeshift
    // time cliente > time servidor, timeshift � numero negativo. Ent�o vai subtrair o timeshift
    long timeSegundos = (time / 1000) - timeShift;

    // movingFactor que � o cara
    // ele tem que ser igual para gerar uma otp igual
    // entao a sacada � entre intervalos de 0-30 segundos por exemplo
    // gerar movingFactor igual
    long movingFactor = timeSegundos / tempoExpirarSegundos;

    if (LOG_ON) {
      System.out.println("getMovingFactor (time/timeshift/tempoExpirar) : (" + time + "/"
        + timeSegundos + "/" + tempoExpirarSegundos + ") >> " + movingFactor);
    }

//    return (time / (long) 1000 - timeShift) / tempoExpirarSegundos;
    return movingFactor;
  }

  public static boolean validar(String semente, String otp, long timeShift, long tempoExpirarSegundos) {
    if (otp == null) {
      throw new IllegalArgumentException("OTP Vazio");
    }
    if (semente == null) {
      throw new IllegalArgumentException("Semente vazia");
    }
    String newOtp = gerar(semente, timeShift, tempoExpirarSegundos);
    boolean ok = otp.equals(newOtp);
    return ok;
  }

  /**
   * Valida segundo a segundo
   *
   * @param semente
   * @param otp
   * @param timeShift
   * @param tempoExpirarSegundos
   * @return
   */

  public static boolean validar60Segundos(String semente, String otp, long timeShift, long tempoExpirarSegundos) {
    if (otp == null) {
      throw new IllegalArgumentException();
    }
    if (semente == null) {
      throw new IllegalArgumentException();
    }

    HmacSha1OTP hmac = new HmacSha1OTP();

    int sessentaSegundos = 60;

    // Vai de 0 a 60 segundos varrendo
    for (int segundos = 0; segundos < sessentaSegundos; segundos++) {
      boolean ok = validaSegundo(semente, otp, timeShift, tempoExpirarSegundos, hmac, sessentaSegundos, segundos);
      if (ok) {
        return true;
      }
    }

    return false;
  }

//  public static String validar60Segundo(String semente, String otp, long timeShift, long tempoExpirarSegundos) {
//    if (otp == null) {
//      throw new IllegalArgumentException();
//    }
//    if (semente == null) {
//      throw new IllegalArgumentException();
//    }
//
//    HmacSha1OTP hmac = new HmacSha1OTP();
//
//    int sessentaSegundos = 60;
//
//    // Vai de 0 a 60 segundos varrendo
//    for (int segundos = 0; segundos < sessentaSegundos; segundos++) {
//      boolean ok = validaSegund(semente, otp, timeShift, tempoExpirarSegundos, hmac, sessentaSegundos, segundos);
//      if (ok) {
//        return validaSegund(semente, otp, timeShift, tempoExpirarSegundos, hmac, sessentaSegundos, segundos);;
//      }
//    }
//
//    return false;
//  }

  /**
   * Valida se a OTP est� OK para o minuto ATUAL.
   * <p>
   * Do 0 ao 60 segundos vai gerar o mesmo movingFactor
   *
   * @param semente
   * @param otp
   * @param timeShift
   * @param tempoExpirarSegundos
   * @param token
   * @param sessentaSegundos
   * @param segundos
   * @return
   */
  private static boolean validaSegundo(String semente, String otp, long timeShift, long tempoExpirarSegundos, HmacSha1OTP token, int sessentaSegundos, int segundos) {
    Calendar currentTime = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    long movingFactor = getMovingFactor(currentTime.getTime().getTime(), timeShift, tempoExpirarSegundos);

    // Gera um numero igual Do 0 ao 60 segundos devido ao movingFactor
    // Entao multiplica pelo segundo atual para gerar diferente
    movingFactor *= (segundos + 1);

    String otp2 = token.generatePassword(semente, movingFactor);
    if (LOG_ON)
      System.out.println("validaSegundo (token) : (" + otp2 + ")");

    boolean ok = otp.equals(otp2);

    return ok;
  }

//  private static String validaSegund(String semente, String otp, long timeShift, long tempoExpirarSegundos, HmacSha1OTP token, int sessentaSegundos, int segundos) {
//   if (validaSegundo(semente, otp, timeShift, tempoExpirarSegundos, token, sessentaSegundos, segundos))
//
//
//    return otp2;
//  }
}
