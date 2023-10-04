package br.com.whitemartins.obc.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 1513 IRON on 30/10/2017.
 */

public class CanvasView extends View {

  private static final float TOLERANCE = 5;
  public int width;
  public int height;
  Context context;
  Activity activity;
  private boolean signed = false;
  private Bitmap mBitmap;
  private Canvas mCanvas;
  private Path mPath;
  private Paint mPaint;
  private float mX, mY;

  public CanvasView(Context context, AttributeSet attributeSet) {
    super(context, attributeSet);
    this.context = context;
    mPath = new Path();
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setColor(Color.BLACK);
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeJoin(Paint.Join.ROUND);
    mPaint.setStrokeWidth(4f);
    setDrawingCacheEnabled(true);
    signed = false;
  }

  public boolean isSigned() {
    return signed;
  }

  public Canvas getmCanvas() {
    return mCanvas;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  private void drawBorder() {
    RectF r = new RectF(1, 1, mCanvas.getWidth() - 1, mCanvas.getHeight() - 1);
    mPath.addRect(r, Path.Direction.CCW);
    invalidate();
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    mBitmap.setHasAlpha(true);
    mCanvas = new Canvas(mBitmap);

    drawBorder();
  }

  public Bitmap getmBitmap() {
    return getDrawingCache();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawPath(mPath, mPaint);
  }

  private void startToutch(float x, float y) {
    mPath.moveTo(x, y);
    mX = x;
    mY = y;
  }

  private void moveToutch(float x, float y) {
    float dx = Math.abs(x - mX);
    float dy = Math.abs(y - mY);
    if (dx >= TOLERANCE || dy >= TOLERANCE) {
      mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
      mX = x;
      mY = y;
    }
  }

  public void clearCanvas() {
    signed = false;
    mPath.reset();
    drawBorder();
  }

  private void upToutch() {
    mPath.lineTo(mX, mY);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    UtilHelper.hideKeyboardFrom(activity, activity.getCurrentFocus());
    signed = true;

    float x = event.getX();
    float y = event.getY();
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        startToutch(x, y);
        invalidate();
        break;
      case MotionEvent.ACTION_MOVE:
        moveToutch(x, y);
        invalidate();
        break;
      case MotionEvent.ACTION_UP:
        upToutch();
        invalidate();
        break;
    }
    return true;
  }


}
