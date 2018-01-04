package com.kenboo.looprunner.Levels;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.kenboo.looprunner.ActorManager;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Block;

/**
 * Created by root on 03/01/18.
 */

public class Level8 {
    public static ActorManager getLevel(ShapeRenderer renderer){
        ActorManager am = new ActorManager(renderer);
        Actor a;
        a = new Block(renderer,1080,710,500,500);
        a.addAction(Actions.sequence(
                Actions.delay(16),
                Actions.moveBy(-1580,0,5),
                Actions.moveTo(1080,710)
        ));
        am.addActor(a);

        a = new Block(renderer,0,1920,150,150);
        a.addAction(Actions.repeat(2,
                Actions.sequence(
                    Actions.moveBy(930,-850,6),
                    Actions.moveBy(-930,-850,6),
                    Actions.moveBy(930,-850,9),
                    Actions.moveTo(0,1920))));
        am.addActor(a);

        a = new Block(renderer,930,1920,150,150);
        a.addAction(Actions.repeat(2,
                Actions.sequence(
                        Actions.moveBy(-930,-1000,4),
                        Actions.moveBy(930,-1000,3),
                        Actions.moveBy(-930,-300,6),
                        Actions.moveTo(930,1920))));
        am.addActor(a);
        a = new Block(renderer,0,0,150,150);
        a.addAction(Actions.repeat(2,
                Actions.sequence(
                        Actions.moveBy(930,1000,6),
                        Actions.moveBy(-930,1000,4),
                        Actions.moveBy(930,300,3),
                        Actions.moveTo(0,-150))));
        am.addActor(a);
        a = new Block(renderer,930,0,150,150);
        a.addAction(Actions.repeat(2,
                Actions.sequence(
                        Actions.moveBy(-930,1000,6),
                        Actions.moveBy(930,1000,4),
                        Actions.moveBy(-930,300,8),
                        Actions.moveTo(930,-150))));
        am.addActor(a);

        a = new Coin(-40,1400,renderer);
        a.addAction(Actions.sequence(
                Actions.delay(10),
                Actions.moveTo(1120,800,8)
        ));
        am.addActor(a);

        a = new Coin(-40,800,renderer);
        a.addAction(Actions.sequence(
                Actions.delay(15),
                Actions.moveTo(1120,1100,6)
        ));
        am.addActor(a);

        a = new Coin(1200,1800,renderer);
        a.addAction(Actions.sequence(
                Actions.delay(18),
                Actions.moveTo(-40,200,7)
        ));
        am.addActor(a);

        return am;
    }
}
