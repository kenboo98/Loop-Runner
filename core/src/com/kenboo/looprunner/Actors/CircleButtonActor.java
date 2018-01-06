package com.kenboo.looprunner.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 A round button that will be used all around our game
 */

public class CircleButtonActor extends Actor {
    private ShapeRenderer renderer;
    private float radius;

    public CircleButtonActor( ShapeRenderer renderer,Color color, float radius){
        setColor(color);
        this.radius = radius;
        this.renderer = renderer;
        setHeight(radius*2);
        setWidth(radius*2);
        setOrigin(getWidth() / 2, getHeight() / 2);

    }
    @Override
    public void draw(Batch batch, float parentAlpha){
        //set square bounds
        batch.end();
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.scale(getScaleX(), getScaleY(), 0);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.translate(getX(),getY(),0);
        renderer.setColor(Color.BLACK);
        renderer.circle(getWidth()/2,getHeight()/2,radius);
        renderer.end();
        batch.begin();


    }
    public float getRadius(){
        return radius;
    }
}
