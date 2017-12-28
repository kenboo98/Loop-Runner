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
        Actor currentActor;
        currentActor = new Block(renderer, 0, 0, 400, 400);
        currentActor.addAction(Actions.moveTo(0, 2000, 10));
        bm.addActor(currentActor);

        return bm;
    }
}
