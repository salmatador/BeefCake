package com.moonstub.beefcake;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by mkline on 7/8/2016.
 */
public class GameImage {

    //Move everything out except the Bitmap

    private Bitmap mImage;

    public GameImage(){}

    public GameImage(Bitmap image) {
        mImage = image;
    }

    public void setImage(Bitmap image){
        mImage = image;
    }

    public Bitmap getImage(){
        return mImage;
    }

    public boolean dispose() {
        if(!mImage.isRecycled()) {
            mImage = null;
            mImage.recycle();
        }

        return mImage.isRecycled();
    }
}
