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

public class Level1{

    public static ActorManager getLevel(ShapeRenderer renderer) {

        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;
        currentActor = new Block(renderer, 0, 0, 400, 400);
        currentActor.addAction(Actions.moveTo(0, 2000, 10));
        bm.addActor(currentActor);

        currentActor = new Coin(0,0,renderer);
        currentActor.addAction(Actions.sequence(Actions.moveTo(1120, 1940, 4, Interpolation.bounce)));
        bm.addActor(currentActor);

        currentActor = new Coin(1120,1940,renderer);
        currentActor.addAction(Actions.sequence(Actions.moveTo(0, 0, 10, Interpolation.circle)));
        bm.addActor(currentActor);

        return bm;
    }
}
