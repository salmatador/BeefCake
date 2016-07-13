package com.moonstub.beefcake.testing;

import com.moonstub.beefcake.GameBoard;
import com.moonstub.beefcake.GameScene;
import com.moonstub.beefcake.GameScreen;

/**
 * Created by mkline on 7/12/2016.
 */
public class TestGameScene extends GameScene{

    GameBoard mGameBoard;

    public TestGameScene(GameScreen screen, String tag) {
        super(screen, tag);
    }

    @Override
    public void init() {
        //mGameBoard = new GameBoard(getScreen().getDimensions());
        mGameBoard = new GameBoard();
        mGameBoard.loadLevel("levels/level_0001");
        mGameBoard.setGameLevel("levels/level_0001");
        
    }

    @Override
    public void update() {

        draw();
        getGameGraphics().drawImage(getSceneBitmap(), getSceneSurface().getBounds() );
    }

    @Override
    public void render() {
        //mGameBoard.render();
    }
}
