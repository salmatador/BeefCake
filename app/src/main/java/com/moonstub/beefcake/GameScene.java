package com.moonstub.beefcake;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.HashMap;

/**
 * Created by mkline on 7/8/2016.
 */
public abstract class GameScene {

    GameSurface sceneSurface;
    HashMap<String, GameUi> mSceneUi;
    GameScreen mScreen;
    String mTag;
    GameGraphics graphics;


    //bot
    GameTile gameTile = new GameTile(GameAsset.firstImage, new Point(0,0));
    //GameTile gameTile2 = new GameTile(GameAsset.secondImage, new Point(1,1));
    private GameState mGameState;
    //eot

    public GameScene(GameScreen screen, String tag){
        mScreen = screen;
        mTag = tag;
        mSceneUi = new HashMap<>();
        sceneSurface = new GameSurface(mScreen.getDimensions());
        graphics = new GameGraphics(sceneSurface);

        //testing
       // loadTiles();
    }

    //usage mSceneUi.put("UI_TAG", new GameUi());
    public abstract void init();

    private void loadTiles(){
        //GameTile gameTile = new GameTile(GameAsset.firstImage, new Point(0,0));
        //GameTile gameTile2 = new GameTile(GameAsset.secondImage, new Point(1,1));
    }

    public void draw(){
        gameTile.draw(graphics);

        //gameTile2.draw(graphics);
        //graphics.drawRectangle();
        //graphics.drawScaledImage();
        //graphics.drawText();
    }


    public Bitmap getSceneBitmap(){
        return sceneSurface.getBitmap();
    }

    public GameSurface getSceneSurface() {
        return sceneSurface;
    }
    public GameScreen getScreen() {
        return mScreen;
    }

    public void setScreen(GameScreen screen) {
        mScreen = screen;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public abstract void update();

    public abstract void render();

    public void setGameState(GameState gameState) {
        mGameState = gameState;
    }

    public GameGraphics getGraphics() {
        return graphics;
    }

    public GameGraphics getGameGraphics(){
        return mScreen.getActivity().getGameGraphics();
    }
}
