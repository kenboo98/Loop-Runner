package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by kenbo on 2017-12-24.
 */

public class Level4 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        Actor current;
        current = new Block(renderer, -450, -400, 360, 360);
        current.setRotation(45);
        current.addAction(Actions.moveTo(1200, 1000, 7));
        bm.addActor(current);

        current = new Block(renderer, 1200, -1000, 360, 360);
        current.setRotation(45);
        current.addAction(Actions.moveTo(-450, 1200, 7));
        bm.addActor(current);

        current = new Block(renderer, -450, 1200, 400, 400);
        current.setRotation(45);
        current.addAction(Actions.moveTo(1200, 0, 16, Interpolation.sine));
        bm.addActor(current);

        current = new Block(renderer, -450, 2000, 300, 300);
        current.setRotation(45);
        current.addAction(Actions.sequence(Actions.delay(10), Actions.moveTo(1200, 0, 11)));
        bm.addActor(current);

        current = new Block(renderer, -450, 200, 300, 300);
        current.setRotation(45);
        current.addAction(Actions.sequence(Actions.delay(8), Actions.moveTo(1200, 1200, 12, Interpolation.sine)));
        bm.addActor(current);

        current = new Block(renderer, -450, 1500, 300, 300);
        current.setRotation(45);
        current.addAction(Actions.sequence(Actions.delay(9), Actions.moveTo(1200, 1000, 12)));
        bm.addActor(current);

        current = new Block(renderer, -450, 1000, 300, 300);
        current.setRotation(45);
        current.addAction(Actions.sequence(Actions.delay(10), Actions.moveTo(1200, 1000, 12)));
        bm.addActor(current);

        current = new Coin(1300, 2000,renderer);
        current.setRotation(45);
        current.addAction(Actions.sequence(Actions.delay(7), Actions.moveTo(-400, 0, 10, Interpolation.sine)));
        bm.addActor(current);

        current = new Coin(700, 2000,renderer);
        current.addAction(Actions.sequence(Actions.delay(1), Actions.moveTo(-100, 0, 10, Interpolation.sine)));
        bm.addActor(current);

        current = new Coin(190, -100,renderer);
        current.addAction(Actions.sequence(Actions.delay(6), Actions.moveTo(190, 2000, 4)));
        bm.addActor(current);



        return bm;
    }
}
