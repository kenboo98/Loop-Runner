package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by kenbo on 2018-01-03.
 */

public class Level9 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;

        currentActor = new Block(renderer, 0, 0, 260, 260);
        currentActor.addAction(Actions.sequence(
                Actions.moveBy(0, 1800, 7),
                Actions.moveBy(0, -500, 6),
                Actions.moveBy(0, 600, 3),
                Actions.moveBy(0, 2000, 9),
                Actions.moveBy(0, -1300, 5)

        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 260, 0, 260, 260);
        currentActor.addAction(Actions.sequence(
                Actions.moveBy(0, 1400, 7),
                Actions.moveBy(0, -1300, 4),
                Actions.moveBy(0, 1600, 7),
                Actions.moveBy(0, -1800, 6),
                Actions.moveBy(0, 2500, 6)

        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 520, 0, 260, 260);
        currentActor.addAction(Actions.sequence(
                Actions.moveBy(0, 1800, 7),
                Actions.moveBy(0, -900, 6),
                Actions.moveBy(0, 600, 7),
                Actions.moveBy(0, -2000, 3),
                Actions.moveBy(0, 2500, 4)
        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 780, 0, 260, 260);
        currentActor.addAction(Actions.sequence(
                Actions.moveBy(0, 2000, 4),
                Actions.moveBy(0, -2000, 6),
                Actions.moveBy(0, 2000, 8),
                Actions.moveBy(0, -2000, 7),
                Actions.moveBy(0, 2000, 7)

        ));
        bm.addActor(currentActor);

        currentActor = new Coin(50, 2000, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(4), Actions.moveTo(200, -40, 4)));
        bm.addActor(currentActor);

        currentActor = new Coin(800, 2000, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(7), Actions.moveTo(500, -40, 3)));
        bm.addActor(currentActor);

        currentActor = new Coin(600, 2000, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(12), Actions.moveTo(200, -40, 5)));
        bm.addActor(currentActor);

        currentActor = new Coin(100, 2000, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(20), Actions.moveTo(200, -40, 6)));
        bm.addActor(currentActor);

        currentActor = new Coin(400, 2000, renderer);
        currentActor.addAction(Actions.sequence(Actions.delay(26), Actions.moveTo(350, -40, 5)));
        bm.addActor(currentActor);
        return bm;

    }
}
