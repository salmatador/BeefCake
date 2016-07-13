package com.moonstub.beefcake;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public abstract class MainActivity extends AppCompatActivity {

    GameInput mGameInput;
    GameAudio mGameAudio;
    GameIO mGameIO;
    GameScreen mScreen;
    GameGraphics mGameGraphics;
    Point mScreenDimensions;
    GameSurface mSurface;
    GameRenderer mGameRenderer;

    protected abstract GameScreen initializeGame();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mGameIO = new GameIO(this);

        //set screen dimensions based on device screen
        setDimensions();
        //create drawing surface
        mSurface = new GameSurface(mScreenDimensions);
        //create graphics
        mGameGraphics = new GameGraphics(mSurface);

        mScreen = initializeGame();

        mGameRenderer = new GameRenderer(this);

        setContentView(mGameRenderer);

    }

    private void setDimensions() {
        mScreenDimensions = new Point();
        WindowManager wm = getWindowManager();
        wm.getDefaultDisplay().getRealSize(mScreenDimensions);
    }

    @Override
    public void onBackPressed() {
        getGameRenderer().stop();
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        if(!getGameRenderer().isRunning){
            getGameRenderer().start();
        }
        super.onStart();
    }

    @Override
    protected  void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    protected void onDestroy(){
        super.onDestroy();
    }

    public GameScreen getScreen() {
        return mScreen;
    }

    public GameIO getGameIO() {
        return mGameIO;
    }

    public Point getScreenDimensions() {
        return mScreenDimensions;
    }

    public GameGraphics getGraphics() {
        return mGameGraphics;
    }

    public GameSurface getGameSurface() {
        return mSurface;
    }

    public GameRenderer getGameRenderer() {
        return mGameRenderer;
    }

    public GameSurface getSurface() {
        return mSurface;
    }

    public GameInput getGameInput() {
        return mGameInput;
    }

    public GameAudio getGameAudio() {
        return mGameAudio;
    }

    public GameGraphics getGameGraphics() {
        return mGameGraphics;
    }

}
