package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.Block;
import com.kenboo.looprunner.BlockManager;

/**
 * Created by kenbo on 2017-12-24.
 */

public class Level1 {

    public static BlockManager getLevel(ShapeRenderer renderer) {
        BlockManager bm = new BlockManager(renderer);
        //set up each block and its action and add it to the block manager
        Actor currentActor;
        currentActor = new Block(renderer, 0, -600, 300, 50);
        currentActor.addAction(Actions.moveTo(100, 800, 15));
        bm.addActor(currentActor);
        currentActor = new Block(renderer, -400, 100, 50, 300);
        currentActor.addAction(Actions.moveTo(900, 100, 12));
        bm.addActor(currentActor);
        return bm;
    }
}
