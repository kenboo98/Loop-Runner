package com.kenboo.looprunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by kenbo on 2017-05-06.
 */

public class PlayerBall {
    //radius of the player ball. RADIUS is the radius of the circle
    final static float RADIUS = MainGame.WIDTH*0.1f/2;
    //starting x and y position
    float x = GameScreen.CIRCLE_RADIUS + RADIUS;
    float y = 0;

    //angle theta in radians
    float angle;

    //final
    final static float DELTAANGLEOUTER = 3.14f;
    final static float DELTAANGLEINNER = DELTAANGLEOUTER*(GameScreen.CIRCLE_RADIUS+RADIUS)/(GameScreen.CIRCLE_RADIUS - RADIUS - GameScreen.THICKNESS);
    float deltaAngle = 3.14f;

    float hypoteneuse = GameScreen.CIRCLE_RADIUS+RADIUS;
    public PlayerBall(){

    }
    public void draw(ShapeRenderer renderer){
        renderer.setColor(Color.BLACK);
        renderer.circle(x,y,RADIUS);

    }
    public void update(float delta){
        //move along circle
        angle += deltaAngle * delta;
        x = MathUtils.cos(angle)*(hypoteneuse);
        y = MathUtils.sin(angle) * (hypoteneuse);
    }
    public void switchDirection(){
        deltaAngle = (-1)*deltaAngle;
    }
    public void switchSide(){
        //when we switch sides, we change the length of the hypoteneuse and the rotational speed
        if(hypoteneuse == GameScreen.CIRCLE_RADIUS+RADIUS){
            hypoteneuse = GameScreen.CIRCLE_RADIUS - RADIUS - GameScreen.THICKNESS;
            deltaAngle = DELTAANGLEINNER;
        }else{
            hypoteneuse = GameScreen.CIRCLE_RADIUS + RADIUS;
            deltaAngle = DELTAANGLEOUTER;
        }
    }

}
