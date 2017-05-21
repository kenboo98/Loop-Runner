package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.Circle;

/**
 * Created by kenbo on 2017-05-06.
 */

public class PlayerBall {
    //radius of the player ball. RADIUS is the radius of the circle
    float radius;
    float backgroundCircleRadius;
    //thickness of the background circle
    float thickness;
    //starting x and y position
    float x;
    float y;

    //angle theta in radians
    float angle;

    //delta angle is the rotational velocity. The inner velocity must be faster than the outer to make up for the smaller radius
    float deltaangleouter = 3.14f;
    float deltaangleinner;
    float deltaAngle = 3.14f;

    float hypoteneuse;
    //circle used for collision check with the squares
    private Circle circle;
    final static int CLOCKWISE = -1;
    final static int COUNTER_CLOCKWISE = 1;
    int direction = 1;

    public PlayerBall(float backgroundCircleRadius, float playerRadius, float thickness){
        this.backgroundCircleRadius = backgroundCircleRadius;
        this.radius = playerRadius;
        this.thickness = thickness;
        //create a cir
        circle = new Circle(x,y,radius);
        x = backgroundCircleRadius + radius;
        hypoteneuse = backgroundCircleRadius+radius;
        deltaangleinner = deltaangleouter *(backgroundCircleRadius)/(backgroundCircleRadius - radius - thickness);
    }

    public void draw(ShapeRenderer renderer){
        renderer.setColor(GameColors.mainColor2);
        renderer.circle(x,y,radius);

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
        if(hypoteneuse == backgroundCircleRadius+radius){
            hypoteneuse = backgroundCircleRadius - radius - thickness;
            if(direction == COUNTER_CLOCKWISE){
                deltaAngle = deltaangleinner;
            }else{
                deltaAngle = -deltaangleinner;
            }

        }else{
            hypoteneuse = backgroundCircleRadius + radius;
            if(direction == COUNTER_CLOCKWISE){
                deltaAngle = deltaangleouter;
            }else{
                deltaAngle = -deltaangleouter;
            }

        }
    }
    public Circle getCircle(){
        return circle;
    }
    public void stop(){
        //function to stop the ball when the game is done
        deltaAngle = 0;
    }

}
