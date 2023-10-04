package br.com.whitemartins.obc.token;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import br.mlife.token.digests.SHA1Digest;
import br.mlife.token.macs.HMac;
import br.mlife.token.params.KeyParameter;


public class HmacSha1OTP {
  private static final int DEFAULT_CODE_DIGITS = 6;
  private static final boolean DEFAULT_ADD_CHECKSUM = false;
  private static final int DEFAULT_TRUNCATION_OFFSET = 0;

  private static final int[] doubleDigits = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
  private static final int[] DIGITS_POWER = {1, 10, 100, 1000, 10000,
    100000, 1000000, 10000000, 100000000};

  /**
   * Validates an HMAC-SHA1 OTP generated password using the OATH standard.
   * This method assumes an 8 digit OTP, without checksum and dynamic
   * truncation.
   *
   * @param password     the one time password
   * @param secret       device secret key, in hexadecimal notation
   * @param movingFactor the counter, time, or other value that changes on a per use
   *                     basis.
   * @return true if the password is valid for the given secret and
   * movingFactor, false otherwise
   * @throws NoSuchAlgorithmException if no provider makes either HmacSHA1 or HMAC-SHA-1 digest
   *                                  algorithms available.
   * @throws InvalidKeyException      The secret provided was not a valid HMAC-SHA-1 key.
   */
  public boolean validatePassword(String password, String secret,
                                  long movingFactor) {

    return validatePassword(password, secret, movingFactor,
      DEFAULT_CODE_DIGITS, DEFAULT_ADD_CHECKSUM,
      DEFAULT_TRUNCATION_OFFSET);

  }

  /**
   * Generates an HMAC-SHA1 OTP using the OATH standard. This method assumes
   * an 8 digit OTP, without checksum and dynamic truncation.
   *
   * @param secret       device secret key, in hexadecimal notation
   * @param movingFactor the counter, time, or other value that changes on a per use
   *                     basis.
   * @return true if the password is valid for the given secret and
   * movingFactor, false otherwise
   * @throws NoSuchAlgorithmException if no provider makes either HmacSHA1 or HMAC-SHA-1 digest
   *                                  algorithms available.
   * @throws InvalidKeyException      The secret provided was not a valid HMAC-SHA-1 key.
   */
  public String generatePassword(String secret, long movingFactor) {

    return generatePassword(secret, movingFactor, DEFAULT_CODE_DIGITS,
      DEFAULT_ADD_CHECKSUM, DEFAULT_TRUNCATION_OFFSET);
  }

  /**
   * Validates an HMAC-SHA1 OTP generated password using the OATH standard.
   *
   * @param password         the one time password
   * @param secret           device secret key, in hexadecimal notation
   * @param movingFactor     the counter, time, or other value that changes on a per use
   *                         basis.
   * @param codeDigits       the number of digits in the OTP, not including the checksum,
   *                         if any.
   * @param addChecksum      a flag that indicates if a checksum digit should be appended
   *                         to the OTP.
   * @param truncationOffset the offset into the MAC result to begin truncation. If this
   *                         value is out of the range of 0 ... 15, then dynamic truncation
   *                         will be used. Dynamic truncation is when the last 4 bits of
   *                         the last byte of the MAC are used to determine the start
   *                         offset.
   * @return true if the password is valid for the given secret and
   * movingFactor, false otherwise
   * @throws NoSuchAlgorithmException if no provider makes either HmacSHA1 or HMAC-SHA-1 digest
   *                                  algorithms available.
   * @throws InvalidKeyException      The secret provided was not a valid HMAC-SHA-1 key.
   */
  public boolean validatePassword(String password, String secret,
                                  long movingFactor, int codeDigits, boolean addChecksum,
                                  int truncationOffset) {

    boolean result = false;
    // byte[] secretAsBytesArray = new BigInteger(secret, 16).toByteArray();

    String n = generateOTP(secret.getBytes(), movingFactor, codeDigits,
      addChecksum, truncationOffset);

    result = n.equals(password);
    return result;
  }

  /**
   * Generates an HMAC-SHA1 OTP using the OATH standard.
   *
   * @param secret           device secret key, in hexadecimal notation
   * @param movingFactor     the counter, time, or other value that changes on a per use
   *                         basis.
   * @param codeDigits       the number of digits in the OTP, not including the checksum,
   *                         if any.
   * @param addChecksum      a flag that indicates if a checksum digit should be appended
   *                         to the OTP.
   * @param truncationOffset the offset into the MAC result to begin truncation. If this
   *                         value is out of the range of 0 ... 15, then dynamic truncation
   *                         will be used. Dynamic truncation is when the last 4 bits of
   *                         the last byte of the MAC are used to determine the start
   *                         offset.
   * @return true if the password is valid for the given secret and
   * movingFactor, false otherwise
   * @throws NoSuchAlgorithmException if no provider makes either HmacSHA1 or HMAC-SHA-1 digest
   *                                  algorithms available.
   * @throws InvalidKeyException      The secret provided was not a valid HMAC-SHA-1 key.
   */
  public String generatePassword(String secret, long movingFactor,
                                 int codeDigits, boolean addChecksum, int truncationOffset) {

    // byte[] secretAsBytesArray = new BigInteger(secret, 16).toByteArray();

    String n = generateOTP(secret.getBytes(), movingFactor, codeDigits,
      addChecksum, truncationOffset);

    return n;
  }

  /**
   * Calculates the moving factor for the next OTP of a given device, using
   * the last two valid passwords. This method looks up for the two given
   * consecutive passwords, starting at startMovingFactor and checking the
   * next resyncWindow valid passwords.
   *
   * @param password1         a valid one time password
   * @param password2         a valid one time password (must be the immediate next one to
   *                          password1)
   * @param secret            device secret key, in hexadecimal notation
   * @param codeDigits        the number of digits in the OTP, not including the checksum,
   *                          if any.
   * @param addChecksum       a flag that indicates if a checksum digit should be appended
   *                          to the OTP.
   * @param truncationOffset  the offset into the MAC result to begin truncation. If this
   *                          value is out of the range of 0 ... 15, then dynamic truncation
   *                          will be used. Dynamic truncation is when the last 4 bits of
   *                          the last byte of the MAC are used to determine the start
   *                          offset.
   * @param resyncWindow      number of passwords to calculate to findNext password1 and
   *                          password2
   * @param startMovingFactor moving factor on which to start the look up
   * @return the movingFactor of the next valid password if password1 and
   * password2 were found, -1 otherwise
   * @throws NoSuchAlgorithmException if no provider makes either HmacSHA1 or HMAC-SHA-1 digest
   *                                  algorithms available.
   * @throws InvalidKeyException      The secret provided was not a valid HMAC-SHA-1 key.
   */
  public long resyncMovingFactor(String password1, String password2,
                                 String secret, int codeDigits, boolean addChecksum,
                                 int truncationOffset, int resyncWindow, long startMovingFactor) {

    boolean ok1 = false;
    boolean ok2 = false;

    byte[] secretAsBytesArray = new BigInteger(secret, 16).toByteArray();
    long movingFactor = startMovingFactor;

    int counter = 1;
    while (!ok2 & counter <= resyncWindow) {
      String n = generateOTP(secretAsBytesArray, movingFactor,
        codeDigits, addChecksum, truncationOffset);

      // si valido la clave 1, la siguiente debe ser la 2
      if (ok1) {
        if (n.equals(password2)) {
          ok2 = true;
          break;
        }
        ok1 = false; // de no ser as� seguimos buscando por la primer
        // clave y luego la segunda.
      }
      if (!ok1 && n.equals(password1)) {
        ok1 = true;
      }
      movingFactor++;
      counter++;
    }

    if (ok2) {
      return ++movingFactor;
    } else {
      return -1;
    }
  }

  /**
   * Calculates the checksum using the credit card algorithm. This algorithm
   * has the advantage that it detects any single mistyped digit and any
   * single transposition of adjacent digits.
   *
   * @param num    the number to calculate the checksum for
   * @param digits number of significant places in the number
   * @return the checksum of num
   */
  private int calcChecksum(long num, int digits) {
    boolean doubleDigit = true;
    int total = 0;
    while (0 < digits--) {
      int digit = (int) (num % 10);
      num /= 10;
      if (doubleDigit) {
        digit = doubleDigits[digit];
      }
      total += digit;
      doubleDigit = !doubleDigit;
    }
    int result = total % 10;
    if (result > 0) {
      result = 10 - result;
    }
    return result;
  }

  /**
   * This method uses the BounceCastle API to provide the HMAC-SHA-1
   * algorithm. HMAC computes a Hashed Message Authentication Code and in this
   * case SHA1 is the hash algorithm used.
   *
   * @param keyBytes the bytes to use for the HMAC-SHA-1 key
   * @param text     the message or text to be authenticated.
   * @throws InvalidKeyException The secret provided was not a valid HMAC-SHA-1 key.
   */
  private byte[] hmac_sha1(byte[] keyBytes, byte[] text) {

    HMac hmac = new HMac(new SHA1Digest());
    byte[] resBuf = new byte[hmac.getMacSize()];

    // hmac.init(new KeyParameter(Hex.decode(keyBytes)));
    hmac.init(new KeyParameter(keyBytes));
    hmac.update(text, 0, text.length);
    hmac.doFinal(resBuf, 0);

    return resBuf;

  }

  /**
   * This method uses the JCE to provide the HMAC-SHA-1 algorithm. HMAC
   * computes a Hashed Message Authentication Code and in this case SHA1 is
   * the hash algorithm used.
   *
   * @param keyBytes
   *            the bytes to use for the HMAC-SHA-1 key
   * @param text
   *            the message or text to be authenticated.
   *
   * @throws NoSuchAlgorithmException
   *             if no provider makes either HmacSHA1 or HMAC-SHA-1 digest
   *             algorithms available.
   * @throws InvalidKeyException
   *             The secret provided was not a valid HMAC-SHA-1 key.
   * @throws NoSuchAlgorithmException
   *
   */
  /*
   * private byte[] hmac_sha1_jce(byte[] keyBytes, byte[] text) throws
   * InvalidKeyException, NoSuchAlgorithmException {
   *
   *
   * Mac hmacSha1; try { hmacSha1 = Mac.getInstance("HmacSHA1"); } catch
   * (NoSuchAlgorithmException nsae) { hmacSha1 =
   * Mac.getInstance("HMAC-SHA-1"); } SecretKeySpec macKey = new
   * SecretKeySpec(keyBytes, "RAW"); hmacSha1.init(macKey); return
   * hmacSha1.doFinal(text); }
   */

  /**
   * This method generates an OTP value for the given set of parameters.
   *
   * @param secret           the shared secret
   * @param movingFactor     the counter, time, or other value that changes on a per use
   *                         basis.
   * @param codeDigits       the number of digits in the OTP, not including the checksum,
   *                         if any.
   * @param addChecksum      a flag that indicates if a checksum digit should be appended
   *                         to the OTP.
   * @param truncationOffset the offset into the MAC result to begin truncation. If this
   *                         value is out of the range of 0 ... 15, then dynamic truncation
   *                         will be used. Dynamic truncation is when the last 4 bits of
   *                         the last byte of the MAC are used to determine the start
   *                         offset.
   * @return A numeric String in base 10 that includes {@link codeDigits}
   * digits plus the optional checksum digit if requested.
   * @throws NoSuchAlgorithmException if no provider makes either HmacSHA1 or HMAC-SHA-1 digest
   *                                  algorithms available.
   * @throws InvalidKeyException      The secret provided was not a valid HMAC-SHA-1 key.
   */
  private String generateOTP(byte[] secret, long movingFactor,
                             int codeDigits, boolean addChecksum, int truncationOffset) {

    // put movingFactor value into text byte array
    String result = null;
    int digits = addChecksum ? (codeDigits + 1) : codeDigits;
    byte[] text = new byte[8];
    for (int i = text.length - 1; i >= 0; i--) {
      text[i] = (byte) (movingFactor & 0xff);
      movingFactor >>= 8;
    }
    // compute hmac hash
    byte[] hash = hmac_sha1(secret, text);
    // put selected bytes into result int
    int offset = hash[hash.length - 1] & 0xf;
    if ((0 <= truncationOffset) && (truncationOffset < (hash.length - 4))) {
      offset = truncationOffset;
    }
    int binary = ((hash[offset] & 0x7f) << 24)
      | ((hash[offset + 1] & 0xff) << 16)
      | ((hash[offset + 2] & 0xff) << 8) | (hash[offset + 3] & 0xff);
    int otp = binary % DIGITS_POWER[codeDigits];
    if (addChecksum) {
      otp = (otp * 10) + calcChecksum(otp, codeDigits);
    }
    result = Integer.toString(otp);
    while (result.length() < digits) {
      result = "0" + result;
    }
    return result;
  }
}
