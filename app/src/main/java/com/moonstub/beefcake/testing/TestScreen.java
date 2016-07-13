package com.moonstub.beefcake.testing;

import com.moonstub.beefcake.GameAsset;
import com.moonstub.beefcake.GameIO;
import com.moonstub.beefcake.GameScene;
import com.moonstub.beefcake.GameScreen;

/**
 * Created by mkline on 7/12/2016.
 */
public class TestScreen extends GameScreen {

    public TestScreen(Game game) {
        super(game);
        loadAssets();
        initScenes();
        start();
    }

    @Override
    public void initScenes() {
        addScene(new TestGameScene(this, "Test_1"),"Test_1");
    }

    @Override
    public void start() {
        setCurrentScene(getSceneMap().get("Test_1"));
    }

    @Override
    public void loadAssets() {
        GameIO gameIO = getActivity().getGameIO();
        GameAsset.firstImage = gameIO.loadImageAsset("test.png");
    }
}
