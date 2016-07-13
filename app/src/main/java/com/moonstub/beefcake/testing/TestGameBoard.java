package com.moonstub.beefcake.testing;

import android.graphics.Point;

import com.moonstub.beefcake.GameBoard;
import com.moonstub.beefcake.GameLevel;

/**
 * Created by mkline on 7/12/2016.
 */
public class TestGameBoard extends GameBoard {

    //This Class needs lots of work

   //Should set board size to screen size
//    public TestGameBoard(){
//        super();
//        init();
//        initGraphics(getBoardDimensions());
//    }
    
    //Auto call Init
    public TestGameBoard(Point boardDimensions) {
        super(boardDimensions);

    }

    @Override
    public void init() {

    }



}
