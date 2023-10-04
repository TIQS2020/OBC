package br.com.whitemartins.obc.token;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.mlife.token.seed.HotpToken;


/**
 * Classe que gera a semente utilizando um "HASH SHA1"
 *
 */
public class TokenSeed {

  public static String gerar(String s) {
    try {

      byte[] input = s.getBytes();
      MessageDigest md = MessageDigest.getInstance("SHA1");

      md.reset();
      byte[] h1 = md.digest(input);
      md.reset();
      byte[] h2 = md.digest(mergeByteArray(input, h1));

      String seed = HotpToken.byteArrayToHexString(h2);
      return seed;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("erro: " + e.getMessage());
    }
  }

  private static byte[] mergeByteArray(byte[] b1, byte[] b2) {

    byte[] result = new byte[b1.length + b2.length];

    int i = 0;

    for (byte b : b1) {
      result[i] = b;
      i++;
    }

    for (byte b : b2) {
      result[i] = b;
      i++;
    }

    return result;
  }
}
