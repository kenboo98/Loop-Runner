package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by kenbo on 2018-01-02.
 */

public class Level6 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;

        currentActor = new Block(renderer, -400, -400, 400, 400);
        currentActor.addAction(Actions.sequence(Actions.moveTo(1480, 2320, 7),
                Actions.moveTo(-400, -400, 7), Actions.moveTo(1480, 2320, 7),
                Actions.moveTo(-400, -400, 7)));
        bm.addActor(currentActor);
        currentActor = new Block(renderer, -400, 2320, 400, 400);
        currentActor.addAction(Actions.sequence(Actions.delay(2), Actions.moveTo(1480, -400, 7),
                Actions.moveTo(-400, 2320, 7), Actions.moveTo(1480, -400, 7),
                Actions.moveTo(-400, 2320)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1480, 2320, 400, 400);
        currentActor.addAction(Actions.sequence(Actions.delay(4), Actions.moveTo(-400, -400, 7),
                Actions.moveTo(1480, 2320, 7), Actions.moveTo(-400, -400, 7),
                Actions.moveTo(1480, 2320, 7)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1480, -400, 400, 400);
        currentActor.addAction(Actions.sequence(Actions.delay(6), Actions.moveTo(-400, 2320, 7),
                Actions.moveTo(1480, -400, 7), Actions.moveTo(-400, 2320, 7),
                Actions.moveTo(-1480, -400, 7)));
        bm.addActor(currentActor);

        currentActor = new Coin(540, 2000, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(2), Actions.moveTo(540, -50, 6)));
        bm.addActor(currentActor);

        currentActor = new Coin(-40, 960, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(16), Actions.moveTo(540, 960, 6)
                , Actions.moveTo(-40, -40, 6)));
        bm.addActor(currentActor);

        currentActor = new Coin(-40, 2000, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(10), Actions.moveTo(1200, 500, 3),
                Actions.moveTo(-40, 1000, 3), Actions.moveTo(1000, 1000, 3)));
        bm.addActor(currentActor);

        return bm;
    }
}
