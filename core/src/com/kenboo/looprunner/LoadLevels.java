package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Created by kenbo on 2017-06-02.
 */

public class LoadLevels {
    //number of levels in the game
    final static int N_LEVELS = 2;
    public static BlockManager getLevel(int level, ShapeRenderer renderer){
        switch (level){
            case 1:
                return getLevel1(renderer);

            default:
                return getLevel2(renderer);
        }
    }
    public static BlockManager getLevel1(ShapeRenderer renderer){
        BlockManager bm = new BlockManager(renderer);
        //set up each block and its action and add it to the block manager
        Actor currentActor;
        currentActor = new Block(renderer, 0,-600,300,50);
        currentActor.addAction(Actions.moveTo(100,800,15));
        bm.addActor(currentActor);
        currentActor = new Block(renderer, -400,100,50,300);
        currentActor.addAction(Actions.moveTo(900,100,12));
        bm.addActor(currentActor);
        return bm;
    }
    public static BlockManager getLevel2(ShapeRenderer renderer){
        BlockManager bm = new BlockManager(renderer);
        Actor currentActor;
        currentActor = new Block(renderer, 0,-1000,400,400);
        currentActor.addAction(Actions.moveTo(0,1000,10));
        bm.addActor(currentActor);
        return bm;
    }
}
