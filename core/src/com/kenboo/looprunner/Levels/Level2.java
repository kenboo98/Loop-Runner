package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.kenboo.looprunner.Actors.Coin;
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

        currentActor = new Block(renderer, 175, -340, 20, 340);
        currentActor.addAction(new ParallelAction(Actions.moveTo(175, 1920, 11)));
        bm.addActor(currentActor);

        currentActor = new Coin(540,1920,renderer);
        currentActor.addAction(new SequenceAction(Actions.moveTo(540,1000, 5,Interpolation.circle),
                Actions.moveTo(-100,1000,5,Interpolation.swing)));
        bm.addActor(currentActor);

        currentActor = new Coin(0,1920,renderer);
        currentActor.addAction(new SequenceAction(Actions.delay(6),
                Actions.moveTo(1080,0,5,Interpolation.swing)));
        bm.addActor(currentActor);
        return bm;
    }
}
