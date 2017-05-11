package com.kenboo.looprunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


/**
 * Created by kenbo on 2017-05-06.
 */

public class BackgroundCircle {
    //class to draw the circle in the background. To get a ring, draw two circles
    float thickness;
    GameScreen screen;


    public BackgroundCircle(GameScreen screen, float thickness){
        this.thickness = thickness;
        this.screen = screen;
    }
    public void draw(ShapeRenderer renderer){
        //shape renderer should be sent in after begin() was already called
        //outside circle
        renderer.setColor(GameColors.mainColor2);
        renderer.circle(0, 0, screen.circleRadius);
        //inside circle
        renderer.setColor(GameColors.mainColor1);
        renderer.circle(0,0,screen.circleRadius-thickness);
    }
}
