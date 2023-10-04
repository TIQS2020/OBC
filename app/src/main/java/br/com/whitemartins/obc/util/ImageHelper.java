package br.com.whitemartins.obc.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import br.com.whitemartins.obc.model.Invoice;
import br.com.whitemartins.obc.model.InvoiceImage;

public class ImageHelper {
  private static ImageHelper _self;
  private final String TAG = getClass().getSimpleName();
  Canvas mainCanvas;
  private Bitmap mainBitmap;
  private int height = 0;
  private int width = 480;

  public static ImageHelper self() {
    if (_self == null)
      _self = new ImageHelper();

    return _self;
  }

  public void setBitmapsFromInvoiceAndSave(Invoice invoice, InvoiceImage invoiceImage) {
    invoiceImage.setCec(encodeBitmapFromByteArray(new File(UtilHelper.getCecFileName(invoice))));
    invoiceImage.setAssinatura(encodeBitmapFromByteArray(new File(UtilHelper.getSignFileName(invoice))));
    invoiceImage.save();
  }

  public void doText(String text, int y, boolean bold, boolean centralizar) {

    int x = 1;
    int xPos = (mainCanvas.getWidth() / 2);

    if (y == 0)
      y = 20;

    Paint paint = new Paint();
    paint.setFilterBitmap(true);
    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(1);
    paint.setStyle(Paint.Style.FILL);
    paint.setStrokeWidth(1);
    paint.setTextSize(11);

    int style = Typeface.NORMAL;
    if (bold)
      style = Typeface.BOLD;

    paint.setTypeface(Typeface.create(Typeface.MONOSPACE, style));

    paint.setAntiAlias(true);

    paint.setTextAlign(Paint.Align.LEFT);
    paint.setElegantTextHeight(true);
    paint.setFilterBitmap(true);

    if (centralizar) {
      paint.setTextAlign(Paint.Align.CENTER);
      x = xPos;
    }

    mainCanvas.drawText(text, x, y, paint);
  }

  public Bitmap doTextSignature(String text, int w, int h) {

    Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

    Canvas canvas = new Canvas(bitmap);
    canvas.drawColor(Color.WHITE);

    int xPos = (canvas.getWidth() / 2);
    int yPos = (canvas.getHeight() / 2);

    Paint paint = new Paint();
    paint.setFilterBitmap(true);
    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(1);
    paint.setStyle(Paint.Style.FILL);
    paint.setStrokeWidth(1);
    paint.setTextSize(45);
    paint.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.BOLD));
    paint.setAntiAlias(true);
    paint.setTextAlign(Paint.Align.LEFT);
    paint.setElegantTextHeight(true);
    paint.setFilterBitmap(true);

    paint.setTextAlign(Paint.Align.CENTER);

    int x = xPos;
    int y = 10;

    String[] texts = text.split("\\n");

    for (String t : texts)
      canvas.drawText(t, x, y += 50, paint);

    return bitmap;
  }

  public void doLine(float strokeWidth, int startX, int startY, int stopX, int stopY) {
    Paint paint = new Paint();
    paint.setFilterBitmap(true);
    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(1);
    paint.setStyle(Paint.Style.FILL);
    paint.setStrokeWidth(1);
    paint.setAntiAlias(true);

    paint.setTextAlign(Paint.Align.CENTER);
    paint.setElegantTextHeight(true);
    paint.setFilterBitmap(true);
    paint.setStrokeWidth(strokeWidth);

    mainCanvas.drawLine(startX, startY, stopX, stopY, paint);
  }

  public void doBox(float strokeWidth, int left, int top, int right, int bottom) {
    Paint paint = new Paint();
    paint.setFilterBitmap(true);
    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(1);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(1);
    paint.setAntiAlias(true);

    paint.setTextAlign(Paint.Align.CENTER);
    paint.setElegantTextHeight(true);
    paint.setFilterBitmap(true);
    paint.setStrokeWidth(strokeWidth);

    right = mainCanvas.getWidth();

    mainCanvas.drawRect(left, top, right, bottom, paint);
  }

  public void doBarcode(String value, int left, int top) {
    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    try {
      BitMatrix bitMatrix = multiFormatWriter.encode(value, BarcodeFormat.CODE_128, width,
          60);
      BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
      Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

      bitmap.setWidth(mainCanvas.getWidth());

      mainCanvas.drawBitmap(bitmap, left, top, null);
      doText(value, top + 70, false, true);

    } catch (WriterException e) {
      e.printStackTrace();
    }
  }

  public void doSignature(String fileName, int left, int top) {

    try {
      File file = new File(fileName);

      if (file.exists()) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), bmOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap, mainCanvas.getWidth() - 20, 200, true);

        mainCanvas.drawBitmap(bitmap, left + 10, top, null);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    height += top + 210;
  }

  private Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                           boolean filter) {
    float ratio = Math.min(
        maxImageSize / realImage.getWidth(),
        maxImageSize / realImage.getHeight());

    int width = Math.round(ratio * realImage.getWidth());
    int height = Math.round(ratio * realImage.getHeight());

    Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width, height, filter);
    return newBitmap;
  }

  public Bitmap scaleBitmap(int _h) {
    Bitmap top1 = null;

    if (mainBitmap != null)
      top1 = Bitmap.createBitmap(mainBitmap, 0, 0, mainBitmap.getWidth(), _h);

    return top1;
  }

  public Bitmap scaleBitmap(Bitmap bitmap, int _h, int _w) {
    Bitmap top1 = null;

    if (bitmap != null)
      top1 = Bitmap.createBitmap(bitmap, 0, 0, _w, _h);

    return top1;
  }

  public Bitmap getBitpmapFromString(Invoice invoice, String invoiceSign) throws IOException {
    Bitmap bitmap = null;

    if (invoiceSign != null) {
      byte[] img = Base64.decode(invoiceSign, Base64.NO_WRAP);
      bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
      saveBitmap(invoice, bitmap, false);
    }
    return bitmap;
  }

  public void saveBitmap(Invoice invoice, Bitmap bitmap, Boolean scale) throws IOException {
    File file = new File(UtilHelper.getSignFileName(invoice));

    if (!file.exists()) {
      FileOutputStream ostream;
      try {
        file.createNewFile();
        ostream = new FileOutputStream(file);

        if (scale)
          bitmap = scaleDown(bitmap, 100, true);

        bitmap.compress(Bitmap.CompressFormat.JPEG, 30, ostream);

        ostream.flush();
        ostream.close();
      } catch (Exception e) {
        LogHelper.self().error(TAG, e);
        throw e;
      }
    }
  }

  public String encodeBitmapFromByteArray(File file) {
    if (file.exists()) {
      Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
      byte[] bytes = outputStream.toByteArray();

      return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }
    return null;
  }

  public void saveCecImage(String filneName) throws IOException {
    File file = new File(filneName);

    try {
      Bitmap bmp = scaleBitmap(height);

      OutputStream fOutputStream = new FileOutputStream(file);
      bmp.compress(Bitmap.CompressFormat.JPEG, 50, fOutputStream);
      fOutputStream.flush();
      fOutputStream.close();
      mainBitmap = null;
      mainCanvas = null;

    } catch (IOException e) {
      e.printStackTrace();
      LogHelper.self().error(TAG, e);
      throw e;
    }
  }

  public void createCecImage(int h) {
    if (height > h)
      h = height;

    height = 0;
    mainBitmap = Bitmap.createBitmap(width, h, Bitmap.Config.ARGB_8888);
    mainCanvas = new Canvas(mainBitmap);
    mainCanvas.drawColor(Color.WHITE);
  }
}
