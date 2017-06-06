package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 This actor's origin is at the center of the triangle
 */

public class ArrowButtonActor extends Actor {
    ShapeRenderer renderer;
    final static int LEFT = 1;
    final static int RIGHT = 0;
    int direction;
    public ArrowButtonActor(ShapeRenderer renderer,float width, float height, int direction){
        this.renderer = renderer;
        this.direction = direction;
        setHeight(height);
        setWidth(width);
        setDebug(true);


    }

    public void draw(Batch batch, float parentAlpha){
        //draw triangle centered at x,y
        //renderer already setup
        batch.end();
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.translate(getX(),getY(),0);
        //drawDebug(renderer);
        renderer.setColor(getColor());
        if(direction ==LEFT){
            renderer.triangle(0, getHeight()/2,getWidth(), getHeight(),getWidth(),0);
        }if(direction == RIGHT){
            renderer.triangle(0, 0,0, getHeight(),getWidth(),getHeight()/2);
        }
        renderer.end();
        batch.begin();

    }
}
