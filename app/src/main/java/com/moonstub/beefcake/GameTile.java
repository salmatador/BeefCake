package com.moonstub.beefcake;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by mkline on 7/12/2016.
 */
public class GameTile {

    private GameImage mGameImage;
    private Point mLoc;

    public GameTile(GameImage gameImage, Point location){
        mGameImage = gameImage;
        mLoc = location;
    }

    public Point getLocation(){
        return mLoc;
    }

    public Bitmap getImage() {
        return mGameImage.getImage();
    }

    public int getX() {
        return (int) ((mLoc.x * Const.GRID_SIZE_X) * Const.SCALE_FACTOR);
    }

    public int getY() {
        return (int)((mLoc.y * Const.GRID_SIZE_Y) * Const.SCALE_FACTOR);
    }

    public int getW(){
        return getX() + getImage().getWidth();
    }

    public int getH(){
        return getY() + getImage().getHeight();
    }

    public Rect getBounds(){
        return new Rect(getX(),getY(),getW(),getH());
    }

    public void draw(GameGraphics g){
        g.drawImage(getImage(), getBounds());
    }

}
