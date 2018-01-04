package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by root on 04/01/18.
 */

public class Level10 {
    public static ActorManager getLevel(ShapeRenderer renderer){

        ActorManager bm = new ActorManager(renderer);
        Actor current;

        current = new Block(renderer, -450, 200, 300, 300);
        current.addAction(Actions.sequence(
                Actions.delay(1),
                Actions.parallel(
                        Actions.moveTo(1200, 1200, 7, Interpolation.circle),
                        Actions.rotateBy(720,12)
                )
        ));
        bm.addActor(current);

        current = new Block(renderer, 1080, 1300, 200, 200);

        current.addAction(Actions.sequence(
                Actions.delay(3),
                Actions.parallel(
                        Actions.moveTo(-450, 1400, 8, Interpolation.circle),
                        Actions.rotateBy(720,8)
                )
        ));
        bm.addActor(current);

        current = new Block(renderer, 400, -250, 250, 250);
        current.addAction(Actions.sequence(
                Actions.delay(7),
                Actions.parallel(
                        Actions.moveTo(700, 2200, 10, Interpolation.circle),
                        Actions.rotateBy(720,12)
                ),
                Actions.parallel(
                        Actions.moveTo(900, -250, 10, Interpolation.circle),
                        Actions.rotateBy(-720,12)
                )
        ));
        bm.addActor(current);

        current = new Block(renderer, -450, 1400, 350, 350);
        current.addAction(Actions.sequence(
                Actions.delay(8),
                Actions.parallel(
                        Actions.moveTo(1200, 600, 10, Interpolation.circle),
                        Actions.rotateBy(720,10)
                ),
                Actions.parallel(
                        Actions.moveTo(-450, 100, 9, Interpolation.circle),
                        Actions.rotateBy(720,12)
                )
                ));
        bm.addActor(current);

        current = new Block(renderer, 1200, 2200, 100, 100);
        current.addAction(Actions.sequence(
                Actions.delay(15),
                Actions.parallel(
                        Actions.moveTo(200, -150, 10, Interpolation.circle),
                        Actions.rotateBy(720,10)
                ),
                Actions.parallel(
                        Actions.moveTo(1200, 2200, 9, Interpolation.circle),
                        Actions.rotateBy(720,12)
                )
        ));
        bm.addActor(current);

        current = new Block(renderer, 200, -200, 150, 150);
        current.addAction(Actions.sequence(
                Actions.delay(16),
                Actions.parallel(
                        Actions.moveTo(300, 2200, 10, Interpolation.circle),
                        Actions.rotateBy(720,10)
                ),
                Actions.parallel(
                        Actions.moveTo(600, -200, 9, Interpolation.circle),
                        Actions.rotateBy(720,9)
                )
        ));
        bm.addActor(current);

        current= new Coin(-100,-100,renderer);
        current.addAction(Actions.sequence(
                Actions.delay(4),
                Actions.moveTo(1120, 1940, 4)));
        bm.addActor(current);

        current = new Coin(-40,1940,renderer);
        current.addAction(Actions.sequence(
                Actions.delay(8),
                Actions.moveTo(1120, 0, 7)));
        bm.addActor(current);

        current = new Coin(-40, 1200, renderer);
        current.addAction(Actions.sequence(
                Actions.delay(14),
                Actions.moveTo(1120, 0, 7)));
        bm.addActor(current);

        current = new Coin(1200, 600, renderer);
        current.addAction(Actions.sequence(
                Actions.delay(23),
                Actions.moveTo(-40, 700, 5)));
        bm.addActor(current);
        current = new Coin(1200, 1500, renderer);
        current.addAction(Actions.sequence(
                Actions.delay(30),
                Actions.moveTo(-40, 1000, 5)));
        bm.addActor(current);

        return bm;
    }

}
