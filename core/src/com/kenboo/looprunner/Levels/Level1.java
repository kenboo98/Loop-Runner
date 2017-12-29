package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.kenboo.looprunner.Actors.Gold;
import com.kenboo.looprunner.Block;
import com.kenboo.looprunner.ActorManager;

/**
 * Created by kenbo on 2017-12-24.
 */

public class Level1 {

    public static ActorManager getLevel(ShapeRenderer renderer) {

        ActorManager bm = new ActorManager(renderer);
        Actor currentActor;
        currentActor = new Block(renderer, 0, 0, 400, 400);
        currentActor.addAction(Actions.moveTo(0, 2000, 10));
        bm.addActor(currentActor);

        currentActor = new Gold(0,0,40,renderer);
        currentActor.addAction(new SequenceAction(Actions.moveTo(1120,1940,4, Interpolation.bounce)));
        bm.addActor(currentActor);

        return bm;
    }
}
