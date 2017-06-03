package com.kenboo.looprunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**
 * Created by kenbo on 2017-05-06.
 */

public class BackgroundCircle extends Actor {
    //class to draw the circle in the background. To get a ring, draw two circles
    //thickness of the loop. Difference in the radius of the two circles.
    float thickness;
    //radius of outer loop
    float radius;
    GameScreen screen;


    public BackgroundCircle(GameScreen screen,float radius, float thickness){
        this.thickness = thickness;
        this.radius = radius;
        //current screen
        this.screen = screen;
    }
    public void draw(Batch batch, float parentAlpha){
        //shape renderer should be sent in after begin() was already called
        //outside circle
        screen.getShapeRenderer().setColor(GameColors.mainColor2);
        screen.getShapeRenderer().circle(0, 0, radius);
        //inside circle
        screen.getShapeRenderer().setColor(GameColors.mainColor1);
        screen.getShapeRenderer().circle(0,0,radius-thickness);
    }
}
