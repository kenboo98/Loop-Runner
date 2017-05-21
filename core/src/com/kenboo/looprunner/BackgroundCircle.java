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
    //thickness of the loop. Difference in the radius of the two circles.
    float thickness;
    //radius of outer loop
    float radius;
    GameScreen screen;


    public BackgroundCircle(float radius, float thickness){
        this.thickness = thickness;
        this.radius = radius;
    }
    public void draw(ShapeRenderer renderer){
        //shape renderer should be sent in after begin() was already called
        //outside circle
        renderer.setColor(GameColors.mainColor2);
        renderer.circle(0, 0, radius);
        //inside circle
        renderer.setColor(GameColors.mainColor1);
        renderer.circle(0,0,radius-thickness);
    }
}
