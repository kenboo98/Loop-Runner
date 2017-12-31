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

public class Level3 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;
        //add blocks
        currentActor = new Block(renderer, 0, 0, 400, 400);
        currentActor.addAction(new ParallelAction(Actions.moveTo(0, 2000, 10), Actions.rotateBy(100, 10)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 940,2000,300,300);
        currentActor.addAction(Actions.moveTo(940,-300,8));
        bm.addActor(currentActor);

        currentActor = new Block(renderer,-200,1365,200,120);
        currentActor.addAction(new ParallelAction(Actions.moveTo(1080,1365,8),Actions.rotateBy(360,10)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer,1920,1080,200,420);
        currentActor.addAction(new ParallelAction(Actions.moveTo(-200,-200,10),Actions.rotateBy(180,10)));
        bm.addActor(currentActor);


        //add coins
        currentActor = new Coin(-100,1000,renderer);
        currentActor.addAction(new SequenceAction(Actions.delay(5),Actions.moveTo(1000,1000,5)));
        bm.addActor(currentActor);

        currentActor = new Coin(600,2000,renderer);
        currentActor.addAction(Actions.moveTo(600,0,5, Interpolation.circleIn));
        bm.addActor(currentActor);

        currentActor = new Coin(-100,-100,renderer);
        currentActor.addAction(new SequenceAction(Actions.delay(7),Actions.moveTo(2000,2000,3)));
        bm.addActor(currentActor);



        return bm;
    }
}
