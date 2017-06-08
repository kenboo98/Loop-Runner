package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by kenbo on 2017-05-06.
 */

public class PlayerBall extends Actor {
    //radius of the player ball. RADIUS is the radius of the circle
    float radius;
    float backgroundCircleRadius;
    //thickness of the background circle
    float thickness;

    //angle theta in radians
    float angle;

    //delta angle is the rotational velocity. The inner velocity must be faster than the outer to make up for the smaller radius
    //These two values are calculted at the start
    float deltaangleouter = 2.8f;
    float deltaangleinner;
    //current speed of the rotation.
    float deltaAngle = deltaangleouter;

    float hypoteneuse;
    //circle used for collision check with the squares

    final static int CLOCKWISE = -1;
    final static int COUNTER_CLOCKWISE = 1;
    int direction = 1;
    //use this inner rectangle for collision detection
    Circle circle;
    ShapeRenderer renderer;

    public PlayerBall(ShapeRenderer renderer,float backgroundCircleRadius, float playerRadius, float thickness){
        this.backgroundCircleRadius = backgroundCircleRadius;
        this.radius = playerRadius;
        this.thickness = thickness;
        //create a cir
        setX(backgroundCircleRadius + radius);
        circle = new Circle(getX(),getY(),radius);
        hypoteneuse = backgroundCircleRadius+radius;
        deltaangleinner = deltaangleouter *(backgroundCircleRadius)/(backgroundCircleRadius - radius - thickness);
        this.renderer = renderer;

        //draw bounds
        setDebug(true);
    }

    public void draw(Batch batch, float parentAlpha){
        batch.end();
        //set up renderer
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.translate(getX(), getY(), 0);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        //draw circle
        renderer.setColor(GameColors.mainColor2);
        renderer.circle(0,0,radius);


        renderer.end();
        batch.begin();
    }

    public void act(float delta){
        super.act(delta);
        //move along circle
        angle += deltaAngle * delta;
        setX(MathUtils.cos(angle)*(hypoteneuse));
        setY(MathUtils.sin(angle) * (hypoteneuse));
        //set the collision circle
        circle.set(getX(),getY(),radius);



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

    public void stop(){
        //function to stop the ball when the game is done
        deltaAngle = 0;
    }

}
