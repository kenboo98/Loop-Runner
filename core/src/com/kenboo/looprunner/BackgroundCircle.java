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
    ShapeRenderer renderer;



    public BackgroundCircle(ShapeRenderer renderer,float radius, float thickness){
        this.thickness = thickness;
        this.radius = radius;
        //current screen
        this.screen = screen;
        this.setWidth(radius);
        this.setHeight(radius);
        this.renderer = renderer;

    }
    public void draw(Batch batch, float parentAlpha){
        super.draw(batch,parentAlpha);
        System.out.println(getScaleX());
        //shape renderer should be sent in after begin() was already called
        //outside circle
        renderer.setColor(GameColors.mainColor2);
        renderer.circle(0, 0, getWidth()*getScaleX());
        //inside circle
        renderer.setColor(GameColors.mainColor1);
        renderer.circle(0,0,getWidth()*getScaleX() - thickness);
    }
}
