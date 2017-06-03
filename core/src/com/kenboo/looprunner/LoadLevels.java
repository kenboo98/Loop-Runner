package com.kenboo.looprunner;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Created by kenbo on 2017-06-02.
 */

public class LoadLevels {
    public static BlockManager getLevel1(GameScreen screen){
        BlockManager bm = new BlockManager(screen);
        Actor currentActor;
        currentActor = new Block(screen, 0,-600,300,50);
        currentActor.addAction(Actions.moveTo(100,800,15));
        bm.addActor(currentActor);
        currentActor = new Block(screen, -400,100,50,300);
        currentActor.addAction(Actions.moveTo(900,100,12));
        bm.addActor(currentActor);
        return bm;
    }
}
