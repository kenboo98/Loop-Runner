package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by root on 31/12/17.
 */

public class Level5 {
    public static ActorManager getLevel(ShapeRenderer renderer) {

        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;
        currentActor = new Block(renderer, 0, 0, 216, 400);
        currentActor.addAction(Actions.sequence(Actions.moveBy(0, 2500, 7), Actions.moveBy(0, -2500, 7)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 216, 0, 216, 400);
        currentActor.addAction(Actions.sequence(Actions.delay(2.5f), Actions.moveBy(0, 2500, 7), Actions.moveBy(0, -2500, 7)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 432, 0, 216, 400);
        currentActor.addAction(Actions.sequence(Actions.delay(5), Actions.moveBy(0, 2500, 7), Actions.moveBy(0, -2500, 7)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 648, 0, 216, 400);
        currentActor.addAction(Actions.sequence(Actions.delay(7.5f), Actions.moveBy(0, 2500, 7), Actions.moveBy(0, -2500, 7)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 864, 0, 216, 400);
        currentActor.addAction(Actions.sequence(Actions.delay(10), Actions.moveBy(0, 2500, 7), Actions.moveBy(0, -2500, 7)));
        bm.addActor(currentActor);


        currentActor = new Coin(-100,-100,renderer);
        currentActor.addAction(Actions.sequence(Actions.moveTo(1120, 1940, 4)));
        bm.addActor(currentActor);

        currentActor = new Coin(-40,1940,renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(8), Actions.moveTo(1120, 0, 10, Interpolation.circle)));
        bm.addActor(currentActor);

        currentActor = new Coin(-40, 1200, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(14), Actions.moveTo(1120, 0, 7, Interpolation.circle)));
        bm.addActor(currentActor);

        return bm;
    }
}
