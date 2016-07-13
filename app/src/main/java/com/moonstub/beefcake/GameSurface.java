package com.moonstub.beefcake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by mkline on 7/8/2016.
 */
public class GameSurface {

    Canvas mCanvas;
    Paint mPaint;
    Bitmap mBitmap;
    Point mDimensions;

    public GameSurface(Point dimensions){
        mDimensions = dimensions;
        mBitmap = Bitmap.createBitmap(mDimensions.x,mDimensions.y, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        mPaint = new Paint();
    }

    public Rect getBounds(){
        return new Rect(0,0,mDimensions.x,mDimensions.y);
    }

    public Canvas getCanvas() {
        return mCanvas;
    }

    public void setCanvas(Canvas canvas) {
        mCanvas = canvas;
    }

    public Paint getPaint() {
        return mPaint;
    }

    public void setPaint(Paint paint) {
        mPaint = paint;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public Point getDimensions() {
        return mDimensions;
    }

    public void setDimensions(Point dimensions) {
        mDimensions = dimensions;
    }
}
