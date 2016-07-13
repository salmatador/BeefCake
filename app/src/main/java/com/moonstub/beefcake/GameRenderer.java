package com.moonstub.beefcake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by mkline on 7/12/2016.
 */
public class GameRenderer extends SurfaceView implements Runnable {

    MainActivity mActivity;
    GameScreen mScreen;
    SurfaceHolder mSurfaceHolder;

    boolean isRunning;
    Thread mainThread;


    public GameRenderer(Context context) {
        super(context);
        mActivity = (MainActivity) context;
        mScreen = mActivity.getScreen();
        mSurfaceHolder = getHolder();
    }

    public void start(){
        isRunning = true;
        mainThread = new Thread(this);
        mainThread.start();
    }

    public void stop(){
        isRunning = false;
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mainThread = null;
        }
    }


    @Override
    public void run() {

        Rect r = new Rect();
        Thread currentThread = Thread.currentThread();

        while(isRunning && mainThread == currentThread) {

            if (!mSurfaceHolder.getSurface().isValid()) {
                continue;
            }

            mScreen.getCurrentScene().update();
            mScreen.getCurrentScene().render();

            Canvas c;

            c = mSurfaceHolder.lockCanvas();
            c.getClipBounds(r);
            c.drawBitmap(mActivity.getGameSurface().getBitmap(), null, r, null);

            getHolder().unlockCanvasAndPost(c);







        }

    }
}
