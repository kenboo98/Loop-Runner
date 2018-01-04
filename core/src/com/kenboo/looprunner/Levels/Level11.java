package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 *Kind of easy. Replace it with earlier levels
 */

public class Level11 {

    public static ActorManager getLevel(ShapeRenderer renderer){
        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;

        currentActor = new Block(renderer, 1080, 555, 200, 81);
        currentActor.addAction(Actions.sequence(
                Actions.moveBy(-1280, 0, 6),
                Actions.delay(16),
                Actions.moveBy(1280,0,6)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1080, 717, 200, 81);
        currentActor.addAction(Actions.sequence(
                Actions.delay(2),
                Actions.moveBy(-1280, 0, 6),
                Actions.delay(12),
                Actions.moveBy(1280,0,6)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1080, 879, 200, 81);
        currentActor.addAction(Actions.sequence(
                Actions.delay(4),
                Actions.moveBy(-1280, 0, 6),
                Actions.delay(8),
                Actions.moveBy(1280,0,6)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1080, 1041, 200, 81);
        currentActor.addAction(Actions.sequence(
                Actions.delay(6),
                Actions.moveBy(-1280, 0, 6),
                Actions.delay(4),
                Actions.moveBy(1280,0,6)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1080, 1203, 200, 81);
        currentActor.addAction(Actions.sequence(
                Actions.delay(8),
                Actions.moveBy(-1280, 0, 6),
                Actions.moveBy(1280,0,6)));
        bm.addActor(currentActor);


        currentActor = new Coin(600, 2000,renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(2),
                Actions.moveTo(600, 555, 3, Interpolation.bounceOut),
                Actions.moveBy(-700,0,6)));
        bm.addActor(currentActor);

        currentActor = new Coin(300, 2000,renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(8),
                Actions.moveTo(300, 555, 3, Interpolation.bounceOut),
                Actions.moveBy(800,0,6)));
        bm.addActor(currentActor);

        currentActor = new Coin(600, 2000,renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(15),
                Actions.moveTo(600, 1365, 1, Interpolation.bounceOut),
                Actions.moveBy(600,0,6)));
        bm.addActor(currentActor);

        return bm;
    }

}
