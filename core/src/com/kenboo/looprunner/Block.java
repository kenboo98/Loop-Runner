package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by kenbo on 2017-05-08.
 */

public class Block {
    private Rectangle rectangle;

    private float deltaX;
    private float deltaY;
    private Color color;

    public Block(float x, float y,float width, float height){
        rectangle = new Rectangle(x,y,width,height);
        color = new Color(Color.BLACK);
    }
    public void setVelocity(float dx, float dy){
        this.deltaX = dx;
        this.deltaY = dy;
    }
    public void update(float delta){
        rectangle.setPosition(rectangle.getX()+deltaX*delta, rectangle.getY()+deltaY*delta);
    }

    public void draw(ShapeRenderer renderer){
        ///renderer.begin() should already have been called
        renderer.setColor(color);
        renderer.rect(rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
        //renderer end will be called later
    }
    public Rectangle getRectangle(){
        return rectangle;
    }
}
