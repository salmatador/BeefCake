package com.moonstub.beefcake.testing;

import android.graphics.Point;

import com.moonstub.beefcake.Const;
import com.moonstub.beefcake.GameAsset;
import com.moonstub.beefcake.GameLevel;
import com.moonstub.beefcake.GameTile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkline on 7/12/2016.
 */
public class TestGameLevel extends GameLevel {

    Point mLevelDimension;
    List<GameTile> mTileList;

    public TestGameLevel(String parseableFile) {
        super(parseableFile);
        mLevelDimension = new Point();
    }



    @Override
    public void parseLevel() {
        String temp = getRawFileData();

        //split String into an array
        String[] tempArray = temp.split(",");
        //First two indices are board dimensions
        mLevelDimension.x = Integer.parseInt(tempArray[0]);
        mLevelDimension.y = Integer.parseInt(tempArray[1]);

        //Create a list with the remaining values and create GameTiles
        //Must initialize GameAsset.TileSet
        mTileList = new ArrayList<>();
        for(int y = 0; y < mLevelDimension.y; y++){
            for(int x = 0; x < mLevelDimension.x; x++){
                int index = Integer.parseInt(tempArray[y * mLevelDimension.x + x]);
                mTileList.add(new GameTile(GameAsset.TileSet[index], new Point(x,y)));
            }
        }

    }

    @Override
    public Point getScaledDimension() {
        int x = (int) (mLevelDimension.x * Const.GRID_SIZE_X * Const.SCALE_FACTOR_X);
        int y = (int)(mLevelDimension.y * Const.GRID_SIZE_Y * Const.SCALE_FACTOR_Y);
        return super.getScaledDimension();
    }
}
