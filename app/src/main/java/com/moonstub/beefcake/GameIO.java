package com.moonstub.beefcake;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mkline on 7/11/2016.
 */
public class GameIO {
    MainActivity mActivity;

    public static GameIO sIO = null;

    public static GameIO getGameIO() {
        return sIO;
    }

    public GameIO(MainActivity activity) {
        mActivity = activity;
        //This may have to change;
        sIO = this;
    }

    public GameImage loadImageAsset(String fileName) {
        AssetManager manager = mActivity.getAssets();
        InputStream is = null;
        Bitmap temp = null;
        try {
            is = manager.open(fileName);
            temp = BitmapFactory.decodeStream(is);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return (temp != null) ? new GameImage(temp) : null;

    }

    public GameAudio loadAudioAsset(String fileName) {
        return null;
    }

    public String loadParsableFile(String fileName) {
        AssetManager manager = mActivity.getAssets();
        InputStream is = null;
        BufferedReader br;
        String line = null;
        try {
            manager.open(fileName);
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                line = line + line;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }

    public boolean saveDataFile(String fileName){return false;}
}
