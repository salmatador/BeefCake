package com.moonstub.beefcake.testing;

import com.moonstub.beefcake.GameScreen;
import com.moonstub.beefcake.MainActivity;

/**
 * Created by mkline on 7/12/2016.
 */
public class Game extends MainActivity {
    @Override
    protected GameScreen initializeGame() {
        return new TestScreen(this);
    }

    protected void start(){
        getScreen().loadAssets();
        getScreen().initScenes();
        getScreen().start();
    }
}
