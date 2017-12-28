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

public class Level3 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;

        currentActor = new Block(renderer, 0, 0, 400, 400);
        currentActor.addAction(new ParallelAction(Actions.moveTo(0, 2000, 10), Actions.rotateBy(100, 10)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 940,2000,300,300);
        currentActor.addAction(Actions.moveTo(940,-300,8));
        bm.addActor(currentActor);
        return bm;
    }
}
