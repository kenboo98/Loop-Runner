package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 A class for each block that the user must avoid
 */

public class Block extends Actor{
    //use a polygon to calculate collisions
    private Polygon polygon;
    ShapeRenderer renderer;





    public Block(ShapeRenderer renderer, float x, float y,float width, float height){
        this.setHeight(height);
        this.setWidth(width);
        this.setPosition(x,y);
        //set origin to the center for rotations
        this.setOrigin(getWidth()/2,getHeight()/2);
        //set the vertices of the polygon
        float[] vertices = {0, 0, getWidth(), 0, getWidth(), getHeight(), 0, getHeight()};
        polygon = new Polygon(vertices);
        polygon.setOrigin(getOriginX(), getOriginY());
        this.renderer = renderer;
        //setDebug(true);
    }

    public void act(float delta){
        super.act(delta);
        polygon.setPosition(getX(),getY());
        polygon.setOrigin(getOriginX(),getOriginY());
        polygon.setRotation(getRotation());
        polygon.setScale(getScaleX(),getScaleY());
    }

    public void draw(Batch batch,float parentAlpha){
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


        renderer.setColor(GameColors.mainColor2);
        renderer.rect(-getOriginX(),-getOriginY(),getWidth(),getHeight());
        renderer.end();

        batch.begin();
    }

    public Polygon getPolygon() {
        return polygon;
    }


}
