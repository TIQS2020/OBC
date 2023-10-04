package br.com.whitemartins.obc.print;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

public abstract class BaseReports {

  protected String parcial = "";

  protected abstract BasePrinter getPriter();

  protected void print() throws ConnectionException, ZebraPrinterLanguageUnknownException {
    try {

      BasePrinter printer = getPriter();
      printer.prints();
    } catch (ConnectionException | ZebraPrinterLanguageUnknownException e) {
      e.printStackTrace();
      throw e;
    }
  }

  public BaseReports setParcial(String parcial) {
    this.parcial = parcial;
    return this;
  }
}
