package com.kenboo.looprunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.kenboo.looprunner.GameScreen.CIRCLE_RADIUS;

/**
 * Created by kenbo on 2017-05-06.
 */

public class BackgroundCircle {
    //class to draw the circle in the background
    float thickness;
    public BackgroundCircle(float thickness){
        this.thickness = thickness;
    }
    public void draw(ShapeRenderer renderer){
        //shape renderer should be sent in after begin() was already called
        renderer.setColor(Color.BLACK);
        renderer.circle(0, 0, CIRCLE_RADIUS);
        renderer.setColor(Color.WHITE);
        renderer.circle(0,0,CIRCLE_RADIUS-thickness);
    }
}
