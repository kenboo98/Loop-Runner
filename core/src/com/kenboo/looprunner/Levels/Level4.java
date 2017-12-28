package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.Block;
import com.kenboo.looprunner.ActorManager;

/**
 * Created by kenbo on 2017-12-24.
 */

public class Level4 {
    public static ActorManager getLevel(ShapeRenderer renderer) {
        ActorManager bm = new ActorManager(renderer);
        Actor current;
        current = new Block(renderer, -1000, -1000, 360, 360);
        current.setRotation(45);
        current.addAction(Actions.moveTo(1000, 1000, 7));
        bm.addActor(current);
        current = new Block(renderer, 1000, -1000, 360, 360);
        current.setRotation(45);
        current.addAction(Actions.moveTo(-1000, 1000, 11));
        bm.addActor(current);
        current = new Block(renderer, -500, -1500, 400, 400);
        current.addAction(Actions.moveTo(-500, 1500, 16, Interpolation.sine));
        bm.addActor(current);
        return bm;
    }
}
