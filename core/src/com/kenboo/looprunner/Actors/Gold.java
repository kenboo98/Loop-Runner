package com.kenboo.looprunner.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenboo.looprunner.GameColors;

/**
 * Created by root on 27/12/17.
 */

public class Gold extends Actor {
    private ShapeRenderer renderer;
    //circle to represent the gold coin. This will be used for collision later.
    private Circle circle;

    public Gold(float x, float y,float radius, ShapeRenderer renderer){
        setX(x);
        setY(y);
        this.renderer = renderer;
        //place circle in same spot
        circle = new Circle(x,y,radius);
    }
    public void act(float delta){
        super.act(delta);
        //
        circle.setX(getX());
        circle.setY(getY());

    }
    public void draw(Batch batch, float parentAlpha){
        batch.end();
        //set up renderer
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        //cet the origin of the renderer to the origin of the block so the block rotates around the origin
        renderer.translate(getX()+getOriginX(), getY()+getOriginY(), 0);
        //rotate according to actor rotation
        renderer.rotate(0,0,1,getRotation());
        //scale according to actor scale
        renderer.scale(getScaleX(),getScaleY(),0);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(GameColors.miscColor1);
        renderer.circle(0,0,circle.radius);
        renderer.end();

        batch.begin();
    }

    public Circle getCircle() {
        return circle;
    }
}
