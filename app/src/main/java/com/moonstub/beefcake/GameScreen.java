package com.moonstub.beefcake;

import android.graphics.Point;

import java.util.HashMap;

/**
 * Created by mkline on 7/8/2016.
 */
public abstract class GameScreen {

    //Responsible for handling tracking and changing scenes

    //Reference to MainActivity
    private MainActivity mActivity;
    //Reference to all loaded Scenes
    private HashMap<String, GameScene> mSceneMap;
    //Reference to Current Scene
    private GameScene mCurrentScene;
    //Reference for screen Dimensions - literally MainActivity.getScreenDimensions();
    private Point mDimensions;


    public GameScreen(MainActivity mainActivity) {
        mActivity = mainActivity;
        mSceneMap = new HashMap<>();
        mDimensions = mActivity.getScreenDimensions();
    }

    //Load up all your assets you need for a Scene use a Loader Thread to not block
    public abstract void loadAssets();

    //Load up all the Scenes
    public abstract void initScenes();

    //Helper Method to Add Scene to map list
    public void addScene(GameScene scene, String tag){
        mSceneMap.put(tag, scene);
    }

    public boolean switchScene(String tag){
        if(mCurrentScene != null){
            unloadScene();
        }

        mCurrentScene = mSceneMap.get(tag);
        mCurrentScene.init();

        return true;
    }

    //Get/Set methods
    public MainActivity getActivity() {
        return mActivity;
    }

    public void setActivity(MainActivity activity) {
        mActivity = activity;
    }

    public HashMap<String, GameScene> getSceneMap() {
        return mSceneMap;
    }

    public void setSceneMap(HashMap<String, GameScene> sceneMap) {
        mSceneMap = sceneMap;
    }

    public GameScene getCurrentScene() {
        return mCurrentScene;
    }

    public void setCurrentScene(GameScene currentScene) {
        mCurrentScene = currentScene;
    }

    private void unloadScene() {
        mCurrentScene.setGameState(GameState.EXIT);
        mCurrentScene = null;
    }

    public Point getDimensions() {
        return mDimensions;
    }

    public abstract void start();
}
