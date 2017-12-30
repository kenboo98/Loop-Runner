package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.kenboo.looprunner.ActorManager;


/**
 This static class contains all the levels and level information.
 In each getLevel function, initiate each blocks and add actions to the blocks. Then, add to the
 block manager and return it. The block manager contains the all the data for each level,
 */

public class LoadLevels {
    //number of levels in the game
    public final static int N_LEVELS = 3;
    public final static int[] coinNum ={2,2,3};//number of coins for each level
    public static ActorManager getLevel(int level, ShapeRenderer renderer){
        switch (level){
            case 1:
                return Level1.getLevel(renderer);
            case 2:
                return Level2.getLevel(renderer);
            case 3:
                return Level3.getLevel(renderer);
            default:
                return Level4.getLevel(renderer);
        }
    }



}
