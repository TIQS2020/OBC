package br.com.whitemartins.obc.print;

import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.com.whitemartins.obc.enumeration.ConstantsEnum;
import br.com.whitemartins.obc.global.GLOBAL;
import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;
import br.com.whitemartins.obc.util.ImageHelper;
import br.com.whitemartins.obc.util.UtilHelper;
import br.com.whitemartins.obc.views.DatabaseApp;

public abstract class BasePrinter {

  final String CRLN;
  String titulo;
  String filial;
  String numViagem;
  String numVeiculo;
  String dtViagem;
  printDefs _printDefs;
  private StringBuilder _lines;
  private StringBuilder _configLines;
  private Boolean printImage = false;
  private Boolean automatic = false;
  private Boolean reprint = false;

  private PrinterConnection printerConnection = PrinterConnection.self();

  BasePrinter() {
    _lines = new StringBuilder();
    _configLines = new StringBuilder();
    _printDefs = new printDefs();
    this._printDefs._copies = 1;
    this._printDefs._speed = 5;
    this._printDefs._mediatype = mediaTypeEnum.JOURNAL;
    this._printDefs._tone = -1;
    CRLN = "\r\n";
  }

  void addLine(String text) {
    _lines.append(text.trim());
    _lines.append(this.CRLN);
  }

  public void setPrintImage(Boolean printImage) {
    this.printImage = printImage;
  }

  public void setAutomatic(Boolean automatic) {
    this.automatic = automatic;
  }

  public void setReprint(Boolean reprint) {
    this.reprint = reprint;
  }

  protected boolean prePrint() {
    return true;
  }

  private void doConfig() {
    _configLines.delete(0, _configLines.length());

    _configLines.append("! U1 setvar \"media.type\" \"journal\" ");
    _configLines.append(CRLN);
    _configLines.append("! U1 setvar \"media.feed_length\" \"50\" ");
    _configLines.append(CRLN);

    _configLines.append("! U1 SETBOLD 0 ");
    _configLines.append("! U1 SETSP 0 ");
    _configLines.append(CRLN);
    _configLines.append(String.format("! 0 200 200 %s %s", _printDefs._height.toString(),
      _printDefs._copies.toString()));
    _configLines.append(CRLN);
    _configLines.append(String.format("PW %s", _printDefs._width.toString()));
    _configLines.append(CRLN);
    _configLines.append(String.format("TONE %s", _printDefs._tone.toString()));
    _configLines.append(CRLN);
    _configLines.append(String.format("SPEED %s", _printDefs._speed.toString()));
    _configLines.append(CRLN);
    _configLines.append("ON-FEED FEED");
    _configLines.append(CRLN);
    _configLines.append("NO-PACE");
    _configLines.append(CRLN);
    _configLines.append(String.format("%s", _printDefs._mediatype.toString().toUpperCase()));
    _configLines.append(CRLN);
  }

  protected void doHeader() {
    Date date = new Date();
    String dateStr = new SimpleDateFormat(ConstantsEnum.ddMMyyyy_HHmmss_barra.getValue(),
      Locale.getDefault()).format(date);

    int posW = 0;

    addLine("L 7 4 803 4 3");

    addLine("CENTER");
    addLine(String.format("T 7 1 %s 25 %s", posW, titulo));
    addLine("LEFT");

    addLine("T 7 0 20 84 Filial: " + filial);
    addLine("T 7 0 319 84 Viagem: " + numViagem);
    addLine("T 7 0 616 84 Veiculo: " + numVeiculo);
    addLine("T 7 0 20 121 Data Viagem: " + dtViagem);
    addLine("T 7 0 20 157 Data Hora Emissao: " + dateStr);
    addLine("L 7 185 803 185 3");
  }

  void doText(String text, int size, int yPrinter, int y, boolean bold, boolean centralizar) {
    if (printImage)
      ImageHelper.self().doText(text, y, bold, centralizar);

    if (centralizar)
      addLine(" CENTER ");

    if (bold)
      addLine("  SETBOLD 1 ");

    addLine(String.format("T 7 %s %s %s %s", size, 7, yPrinter, text));

    if (bold)
      addLine("  SETBOLD 0 ");

    if (centralizar)
      addLine(" LEFT ");
  }

  void doLine(int y, int yPrinter, int len, int wid) {
    if (printImage)
      ImageHelper.self().doLine(wid, 0, y, len, y);

    len = _printDefs._width;

    addLine(String.format(Locale.getDefault(), "L 7 %d %d %d %d", yPrinter, len, yPrinter,
      wid));
  }

  void doBox(int y, int len, int yPrinter) {
    if (printImage)
      ImageHelper.self().doBox(1, 0, y, len, y + 20);

    addLine(String.format(Locale.getDefault(), "BOX 2 %d %d %d %d", yPrinter, len,
      yPrinter + 30, 1));
  }

  void doBarcode(String value, int y, int yPrinter) {
    if (printImage)
      ImageHelper.self().doBarcode(value, 0, y);

    addLine(" CENTER ");
    addLine("BT 7 0 0");
    addLine(String.format(Locale.getDefault(), "B 128 1 30 89 0 %d %s", yPrinter, value));
    addLine(" LEFT ");
  }

  void doSignature(String fileName, int y) {
    ImageHelper.self().doSignature(fileName, 0, y);
  }


  protected abstract void doBody();

  protected void doFooter(PrinterConnection printerConnection)
    throws ConnectionException, ZebraPrinterLanguageUnknownException {
  }

  private void internalPrint() {
    _lines.delete(0, _lines.length());

    this.doHeader();
    this.doBody();
    this.doConfig();
  }

  private void saveCecImage(Invoice invoice) {

    try {
      ImageHelper.self().saveCecImage(UtilHelper.getCecFileName(invoice));

      InvoiceImage invoiceImage = DatabaseApp.self().getDatabase().invoiceImageDao()
        .find(invoice.getId());

      if (invoiceImage != null) {
        ImageHelper.self().setBitmapsFromInvoiceAndSave(invoice, invoiceImage);

        if (!automatic)
          GLOBAL.self().getInvoiceImageBackgroundService().addImageToList(invoiceImage);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void print(Invoice invoice) throws ConnectionException, ZebraPrinterLanguageUnknownException {
    if (prePrint()) {

      internalPrint();

      if (!reprint)
        saveCecImage(invoice);

      if (!automatic)
        printerConnection.print(_configLines.toString() + this.CRLN + this._lines.toString() +
          this.CRLN + "PRINT " + this.CRLN);

      this.doFooter(printerConnection);

      printerConnection.disconnect();
    }

  }

  public void prints() throws ConnectionException, ZebraPrinterLanguageUnknownException {
    _lines.delete(0, _lines.length());

    this.doHeader();
    this.doBody();
    this.doConfig();

    if (!automatic)
      printerConnection.prints(_configLines.toString() + this.CRLN + this._lines.toString() +
        this.CRLN + "PRINT " + this.CRLN);

    this.doFooter(printerConnection);
  }

  public enum mediaTypeEnum {
    JOURNAL,
    LABEL
  }

  public class printDefs {
    public Integer _height;
    public Integer _width;

    Integer _copies;
    Integer _tone;
    Integer _speed;
    mediaTypeEnum _mediatype;
  }
}
