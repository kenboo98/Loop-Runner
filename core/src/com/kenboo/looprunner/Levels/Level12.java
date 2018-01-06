package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by kenbo on 2018-01-05.
 */

public class Level12 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;

        currentActor = new Block(renderer, -400, 960, 400, 400);
        currentActor.addAction(Actions.sequence(
                Actions.parallel(
                        Actions.moveTo(1480, 960, 6),
                        Actions.rotateBy(765, 6)),
                Actions.delay(8),
                Actions.parallel(
                        Actions.moveTo(-700, 960, 6),
                        Actions.scaleBy(1.2f, 1.2f, 6))

        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1280, 1240, 200, 200);
        currentActor.addAction(Actions.sequence(
                Actions.delay(2),
                Actions.parallel(
                        Actions.moveTo(0, 1240, 6),
                        Actions.rotateBy(720, 6)),
                Actions.parallel(
                        Actions.moveTo(1280, 1240, 6),
                        Actions.rotateBy(720, 6)
                )
        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1280, 480, 200, 200);
        currentActor.addAction(Actions.sequence(
                Actions.delay(3.5f),
                Actions.parallel(
                        Actions.moveTo(0, 480, 6),
                        Actions.rotateBy(720, 6)),
                Actions.parallel(
                        Actions.moveTo(1280, 480, 6),
                        Actions.rotateBy(720, 6)
                )
        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, 1380, 800, 300, 300);
        currentActor.addAction(Actions.sequence(
                Actions.delay(20),
                Actions.parallel(
                        Actions.moveTo(-300, 1000, 6),
                        Actions.rotateBy(720, 6)),
                Actions.parallel(
                        Actions.moveTo(1380, 1500, 6),
                        Actions.rotateBy(720, 6)
                )
        ));
        bm.addActor(currentActor);

        currentActor = new Block(renderer, -300, 1600, 300, 300);
        currentActor.addAction(Actions.sequence(
                Actions.delay(20),
                Actions.parallel(
                        Actions.moveTo(1380, 1000, 6),
                        Actions.rotateBy(720, 6)),
                Actions.parallel(
                        Actions.moveTo(-400, 200, 6),
                        Actions.rotateBy(720, 6)
                )
        ));
        bm.addActor(currentActor);

        currentActor = new Coin(600, 2000, renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(4),
                Actions.moveTo(600, 1365, 1, Interpolation.bounceOut),
                Actions.moveBy(600, -1400, 6)));
        bm.addActor(currentActor);

        currentActor = new Coin(600, 2000, renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(16),
                Actions.moveTo(600, 1365, 1, Interpolation.bounceOut),
                Actions.moveBy(-600, -1400, 6)));
        bm.addActor(currentActor);

        currentActor = new Coin(-40, 2000, renderer);
        currentActor.addAction(Actions.sequence(
                Actions.delay(20),
                Actions.moveTo(600, -40, 7, Interpolation.circleIn)));
        bm.addActor(currentActor);
        return bm;
    }
}
