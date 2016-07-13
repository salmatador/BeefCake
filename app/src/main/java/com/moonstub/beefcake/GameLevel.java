package com.moonstub.beefcake;

import android.graphics.Point;

/**
 * Created by mkline on 7/12/2016.
 */
public abstract class GameLevel {

    Point mScaledDimension;
    String mRawFileData;

    public GameLevel(String parseableFile) {
        mRawFileData = parseableFile;
    }

    public abstract void parseLevel();

    public void setScaleFactor(float factor){
        Const.SCALE_FACTOR = factor;
    }

    public void setTileWidth(int width){
        Const.GRID_SIZE_X = width;
    }

    public void setTileheight(int height){
        Const.GRID_SIZE_Y = height;
    }

    public String getRawFileData(){
        return mRawFileData;
    }

    public Point getScaledDimension() {
        return mScaledDimension;
    }
}
