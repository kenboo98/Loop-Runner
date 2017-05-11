package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 A round button that will be used all around our game
 */

public class ButtonActor extends Actor {
    ShapeRenderer renderer;
    float radius;

    public ButtonActor(Color color, float radius){
        setColor(color);
        this.radius = radius;
        renderer = new ShapeRenderer();
        setHeight(radius*2);
        setWidth(radius*2);
        setBounds(getX(),getY(),radius*2, radius*2);

    }
    @Override
    public void draw(Batch batch, float parentAlpha){
        //set square bounds
        setBounds(getX(),getY(),radius*2, radius*2);
        batch.end();

        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.translate(getX(), getY(), 0);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(GameColors.mainColor2);
        renderer.circle(radius,radius,radius);
        renderer.end();

        batch.begin();


    }
    public float getRadius(){
        return radius;
    }
}
