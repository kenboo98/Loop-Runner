package com.kenboo.looprunner.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenboo.looprunner.GameColors;

/**
 * This is the ball that the player will be controlling.
 * It will spin around the background ring in one direction and spin in the other direction
 * when the player touches the outside of the ring. When the player touches the inside of the ring,
 * the ball will switch from spinning around the outside of the ring to spinning around the inside
 * of the ring and vice versa.
 */

public class PlayerBall extends Actor {
    //radius of the player ball
    private float radius;
    private float backgroundCircleRadius;
    //thickness of the background circle
    private float thickness;

    //angle theta in radians
    private float angle;

    //delta angle is the rotational velocity. The inner velocity must be faster than the outer to make up for the smaller radius
    //These two values are calculted at the start
    private float deltaangleouter = 2.8f;
    private float deltaangleinner;
    //current speed of the rotation.
    private float deltaAngle = deltaangleouter;

    private float hypoteneuse;
    //circle used for collision check with the squares

    final static int CLOCKWISE = -1;
    final static int COUNTER_CLOCKWISE = 1;
    private int direction = 1;
    //use this inner rectangle for collision detection
    Circle circle;
    ShapeRenderer renderer;

    /**
     * Constructor.
     *
     * @param renderer               The renderer to draw the circle on
     * @param backgroundCircleRadius radius of the background circle
     * @param radius
     * @param thickness
     */
    public PlayerBall(ShapeRenderer renderer, float backgroundCircleRadius, float radius, float thickness) {
        this.backgroundCircleRadius = backgroundCircleRadius;
        this.radius = radius;
        this.thickness = thickness;
        //create a cir
        setX(backgroundCircleRadius + this.radius);
        circle = new Circle(getX(), getY(), this.radius);
        hypoteneuse = backgroundCircleRadius + this.radius;
        deltaangleinner = deltaangleouter * (backgroundCircleRadius) / (backgroundCircleRadius - this.radius - thickness);
        this.renderer = renderer;

        //draw bounds
        setDebug(true);
    }

    public void draw(Batch batch, float parentAlpha){
        batch.end();
        //set up renderer
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.translate(circle.x, circle.y, 0);
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

    public float getRadius() {
        return radius;
    }

}
