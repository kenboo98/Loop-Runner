package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by root on 03/01/18.
 */

public class Level7 {
    public static ActorManager getLevel(ShapeRenderer renderer){
        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;

        currentActor = new Block(renderer,1345,1365,400,400);
        currentActor.addAction(Actions.parallel(Actions.rotateBy(1080,28),Actions.sequence(Actions.moveTo(-265,1365,7),
                Actions.moveTo(-265,155,7),Actions.moveTo(945,155,7),Actions.moveTo(945,1365,10))));
        bm.addActor(currentActor);

        currentActor = new Block(renderer,705,1920,200,400);
        currentActor.addAction(Actions.sequence(Actions.moveTo(705,-400,7),Actions.moveTo(705,1920,7)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer,175,-400,200,400);
        currentActor.addAction(Actions.sequence(Actions.delay(17),Actions.moveTo(175,1920,7)
                ,Actions.moveTo(175,-400,7)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer,1080,595,400,200);
        currentActor.addAction(Actions.sequence(Actions.delay(5),Actions.moveTo(-400,595,7)
                ,Actions.moveTo(1080,595,7)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer,-400,1365,400,200);
        currentActor.addAction(Actions.sequence(Actions.delay(22),Actions.moveTo(-400,1365,7)
                ,Actions.moveTo(-400,1365,7)));
        bm.addActor(currentActor);

        currentActor = new Coin(705,1960,renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(4),Actions.moveTo(705,-400,8)));
        bm.addActor(currentActor);

        currentActor = new Coin(175,-400,renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(14),Actions.moveTo(175,1920,6)
                ,Actions.moveTo(175,-400,7)));
        bm.addActor(currentActor);

        currentActor = new Coin(1120,595,renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(10),Actions.moveTo(-400,595,7)
                ,Actions.moveTo(1120,595,7)));
        bm.addActor(currentActor);

        currentActor = new Coin(-400,1365,renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(19),Actions.moveTo(-400,1365,5)
                ,Actions.moveTo(-400,1365,7)));
        bm.addActor(currentActor);


        return bm;
    }

}
