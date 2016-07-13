package com.moonstub.beefcake;

import android.content.res.Resources;
import android.graphics.Point;

import com.moonstub.beefcake.testing.TestGameLevel;

import java.util.HashMap;

/**
 * Created by mkline on 7/12/2016.
 */
public class GameBoard {


    //Board Dimensions can be bigger than screen dimensions

    Point mBoardDimensions;
    GameSurface mBoardSurface;
    GameGraphics mGraphics;

    // List of Levels Loaded
    HashMap<String,GameLevel> mLevelList;
    GameLevel mGameLevel;

    public GameBoard(){
        mBoardDimensions = new Point();
        mLevelList = new HashMap<>();
    }

    //Should Graphics Init be moved to init?
    public GameBoard(Point boardDimensions){
        mBoardDimensions = boardDimensions;
        initGraphics(mBoardDimensions);
        mLevelList = new HashMap<>();
    }

    public void initGraphics(Point bd){
        mBoardSurface = new GameSurface(bd);
        mGraphics = new GameGraphics(mBoardSurface);


    }

    public void init(){
        loadLevel("levels/level_0001");
        setGameLevel("levels/level_0001");
        //setBoardDimensions(getGameLevel().getScaledDimension());
    }


    public void loadLevel(String fileName){
        GameIO IO = GameIO.getGameIO();
        if(IO != null){

            mGameLevel = new TestGameLevel(IO.loadParsableFile(fileName));
            mGameLevel.parseLevel();
            mLevelList.put(fileName,mGameLevel);

        } else {
            throw new Resources.NotFoundException(fileName);
        }

    }

    public GameLevel getGameLevel() {
        return mGameLevel;
    }
    // set mGameLevel from mLevelList
    public void setGameLevel(String fileName){
        mGameLevel = mLevelList.get(fileName);
    }

    public void setBoardDimensions(Point boardDimensions) {
        mBoardDimensions = boardDimensions;
    }

    public Point getBoardDimensions() {
        return mBoardDimensions;
    }

    public GameGraphics getGraphics() {
        return mGraphics;
    }

    public void update() {

    }
}
