package br.com.whitemartins.obc.print;

import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.util.Sleeper;

public class PrinterConnection {

  private static PrinterConnection _self;
  private Connection blueToothConnection;

  public static PrinterConnection self() {
    if (_self == null)
      _self = new PrinterConnection();

    return _self;
  }

  public ZebraPrinter getPrinter() throws ConnectionException, ZebraPrinterLanguageUnknownException {
    if (blueToothConnection != null) {
      return ZebraPrinterFactory.getInstance(blueToothConnection);
    }
    return null;
  }

  private String getMacAddressFieldText() {
    return GLOBAL.self().getStaticTable().getMacAddress();
  }

  public void disconnect() {
    try {
      if (blueToothConnection != null) {
        blueToothConnection.close();
        Sleeper.sleep(1000);
      }
    } catch (ConnectionException ignored) {

    }
  }

  boolean isConnected() {
    if (blueToothConnection != null) {
      return blueToothConnection.isConnected();
    }
    return false;
  }

  boolean connect() throws ConnectionException {
    blueToothConnection = null;

    blueToothConnection = new BluetoothConnection(getMacAddressFieldText());

    try {
      disconnect();

      if (!blueToothConnection.isConnected())
        blueToothConnection.open();

      if (blueToothConnection.isConnected()) {
        return true;
      }
    } catch (ConnectionException e) {
      throw e;
    }
    return false;
  }

  public void print(String text) throws ConnectionException {
    final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] b = text.getBytes(ISO_8859_1);

    if (connect())
      if (blueToothConnection != null && blueToothConnection.isConnected()) {
        Sleeper.sleep(1000);
        blueToothConnection.write(b);
        Sleeper.sleep(1000);
      }
  }

  void prints(String text) throws ConnectionException {
//    final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    byte[] b = text.getBytes(StandardCharsets.ISO_8859_1);

    if (blueToothConnection != null && blueToothConnection.isConnected()) {
      Sleeper.sleep(1000);
      blueToothConnection.write(b);
      Sleeper.sleep(1000);
    }
  }
}
