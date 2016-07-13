package com.moonstub.beefcake;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by mkline on 7/8/2016.
 */
public abstract class GameUi extends Fragment {

    MainActivity mActivity;
    GameScreen mScreen;
    GameScene mScene;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
        mScreen = mActivity.getScreen();
        mScene = mScreen.getCurrentScene();
    }

    public MainActivity getMainActivity() {
        return mActivity;
    }

    public GameScreen getScreen() {
        return mScreen;
    }

    public GameScene getScene(){
        return mScene;
    }
}
