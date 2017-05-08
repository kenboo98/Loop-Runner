package com.kenboo.looprunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.Circle;

/**
 * Created by kenbo on 2017-05-06.
 */

public class PlayerBall {
    //radius of the player ball. RADIUS is the radius of the circle
    final static float RADIUS = GameScreen.WIDTH*0.1f/2;
    //starting x and y position
    float x = GameScreen.CIRCLE_RADIUS + RADIUS;
    float y = 0;

    //angle theta in radians
    float angle;

    //delta angle is the rotational velocity. The inner velocity must be faster than the outer to make up for the smaller radius
    final static float DELTAANGLEOUTER = 3.14f;
    final static float DELTAANGLEINNER = DELTAANGLEOUTER*(GameScreen.CIRCLE_RADIUS+RADIUS)/(GameScreen.CIRCLE_RADIUS - RADIUS - GameScreen.THICKNESS);
    float deltaAngle = 3.14f;

    float hypoteneuse = GameScreen.CIRCLE_RADIUS+RADIUS;
    //circle used for collision check with the squares
    private Circle circle;
    final static int CLOCKWISE = -1;
    final static int COUNTER_CLOCKWISE = 1;
    int direction = 1;
    public PlayerBall(){
        //create a cir
        circle = new Circle(x,y,RADIUS);

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
        //move the collision circle to current position
        circle.setPosition(x,y);
    }
    public void switchDirection(){
        deltaAngle = (-1)*deltaAngle;
        direction = (-1)*direction;
    }
    public void switchSide(){
        //when we switch sides, we change the length of the hypoteneuse and the rotational speed
        if(hypoteneuse == GameScreen.CIRCLE_RADIUS+RADIUS){
            hypoteneuse = GameScreen.CIRCLE_RADIUS - RADIUS - GameScreen.THICKNESS;
            if(direction == COUNTER_CLOCKWISE){
                deltaAngle = DELTAANGLEINNER;
            }else{
                deltaAngle = -DELTAANGLEINNER;
            }

        }else{
            hypoteneuse = GameScreen.CIRCLE_RADIUS + RADIUS;
            if(direction == COUNTER_CLOCKWISE){
                deltaAngle = DELTAANGLEOUTER;
            }else{
                deltaAngle = -DELTAANGLEOUTER;
            }

        }
    }
    public Circle getCircle(){
        return circle;
    }

}
