package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by kenboo on 06/01/18.
 */

public class Level13 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;
        currentActor = new Block(renderer, 340, 760, 400, 400);
        currentActor.addAction(Actions.sequence(
                Actions.scaleTo(2.5f, 1, 3, Interpolation.circle),
                Actions.scaleTo(1, 1, 3, Interpolation.circle),
                Actions.scaleTo(1, 4, 3, Interpolation.circle),
                Actions.scaleTo(0, 0, 3, Interpolation.circle)));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, -400, 500, 300, 100);
        currentActor.addAction(Actions.sequence(
                Actions.delay(12),
                Actions.parallel(
                        Actions.moveTo(1080, 500, 6),
                        Actions.rotateBy(360, 3)),
                Actions.delay(5),
                Actions.parallel(
                        Actions.moveTo(-400, 500, 6),
                        Actions.rotateBy(-360, 2)),
                Actions.parallel(
                        Actions.moveTo(1080, 500, 6),
                        Actions.rotateBy(360, 6))

        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, -500, 1350, 500, 100);
        currentActor.addAction(Actions.sequence(
                Actions.delay(15),
                Actions.parallel(
                        Actions.moveTo(1580, 1350, 6),
                        Actions.rotateBy(180, 3)),
                Actions.delay(3),
                Actions.parallel(
                        Actions.moveTo(-700, 1350, 6),
                        Actions.rotateBy(360, 4)),
                Actions.parallel(
                        Actions.moveTo(1580, 1350, 6),
                        Actions.rotateBy(360, 6))

        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1680, 1000, 600, 200);
        currentActor.addAction(Actions.sequence(
                Actions.delay(19),
                Actions.parallel(
                        Actions.moveTo(-600, 1000, 4),
                        Actions.rotateBy(180, 3)),
                Actions.delay(3),
                Actions.parallel(
                        Actions.moveTo(1680, 1000, 6),
                        Actions.rotateBy(360, 4))

        ));
        bm.addActor(currentActor);
        //add cpoms
        currentActor = new Coin(175, 2000, renderer);
        currentActor.addAction(Actions.sequence(
                Actions.moveTo(175, 555, 4, Interpolation.bounceOut),
                Actions.moveBy(1000, 0, 5, Interpolation.exp5In)
        ));
        bm.addActor(currentActor);

        currentActor = new Coin(1200, 2000, renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(10),
                Actions.moveTo(175, -40, 5, Interpolation.sineIn)
        ));
        bm.addActor(currentActor);

        currentActor = new Coin(1200, 1400, renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(14),
                Actions.moveTo(-40, 100, 4, Interpolation.sineIn)
        ));
        bm.addActor(currentActor);

        currentActor = new Coin(-40, 1600, renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(22),
                Actions.moveTo(1200, 800, 5, Interpolation.sineIn)
        ));
        bm.addActor(currentActor);

        currentActor = new Coin(905, 2000, renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(28),
                Actions.moveTo(905, 555, 4, Interpolation.bounceOut),
                Actions.moveBy(-1000, 0, 5, Interpolation.exp5In)
        ));
        bm.addActor(currentActor);

        return bm;
    }
}
