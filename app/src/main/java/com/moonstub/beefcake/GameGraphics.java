package com.moonstub.beefcake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by mkline on 7/8/2016.
 */
public class GameGraphics {

    // Graphics Helper Class for drawing on Game Surfaces

    Canvas mCanvas;
    Paint mFillPaint,mStrokePaint;
    //What was I thinking here
    //GameCamera mCamera;

    //Does the GameGraphics Handle Paint or does the GameSurface
    public GameGraphics(GameSurface surface) {
        mCanvas = surface.getCanvas();
        mFillPaint = surface.getPaint();
        mStrokePaint = new Paint(mFillPaint);

        mStrokePaint.setStyle(Paint.Style.STROKE);
        mFillPaint.setStyle(Paint.Style.FILL);
    }

    //Draw Shapes
    public void drawRect(Rect bounds){
        drawRect(bounds, getFillPaint());
    }

    public void drawRect(Rect bounds, Paint paint){
        getCanvas().drawRect(bounds, paint);
    }
    //Draw Images
    public void drawImage(Bitmap image, Rect bounds) {
        getCanvas().drawBitmap(image,null,bounds,getFillPaint());
    }

    //TODO Draw Text
    public void drawText(String Text){

    }

    public void drawText(String text, TextPosition pos ){

    }

    //Helper Methods Get/Set

    public void setFillColor(int color){
        mFillPaint.setColor(color);
    }

    public void setStrokeColoe(int color){
        mStrokePaint.setColor(color);
    }

    public Canvas getCanvas() {
        return mCanvas;
    }

    public void setCanvas(Canvas canvas) {
        mCanvas = canvas;
    }

    public Paint getFillPaint() {
        return mFillPaint;
    }

    public void setFillPaint(Paint fillPaint) {
        mFillPaint = fillPaint;
    }

    public Paint getStrokePaint() {
        return mStrokePaint;
    }

    public void setStrokePaint(Paint strokePaint) {
        mStrokePaint = strokePaint;
    }

}
