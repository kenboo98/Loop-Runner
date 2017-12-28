package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.kenboo.looprunner.Block;
import com.kenboo.looprunner.ActorManager;

/**
 * Created by kenbo on 2017-12-24.
 */

public class Level2 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        //set up each block and its action and add it to the block manager
        Actor currentActor;
        currentActor = new Block(renderer, 0, 515, 300, 50);
        currentActor.addAction(Actions.moveTo(1080, 515, 10));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 175, 1920, 50, 300);
        currentActor.addAction(Actions.moveTo(175, -300, 8));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 540, 1920, 50, 300);
        currentActor.addAction(new ParallelAction(Actions.rotateBy(360,10),Actions.moveTo(540, -400, 8)));
        bm.addActor(currentActor);

        return bm;
    }
}
