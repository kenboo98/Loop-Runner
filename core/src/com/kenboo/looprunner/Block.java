package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by kenbo on 2017-05-08.
 */

public class Block extends Actor{
    private Rectangle rectangle;
    private GameScreen screen;
    private float deltaX;
    private float deltaY;




    public Block(GameScreen screen, float x, float y,float width, float height){
        this.setHeight(height);
        this.setWidth(width);
        this.setPosition(x,y);
        rectangle = new Rectangle(x,y,width,height);
        this.screen = screen;
    }

    public void act(float delta){
        super.act(delta);
        rectangle.setPosition(getX(),getY());
    }

    public void draw(Batch batch,float parentAlpha){
        ///renderer.begin() should already have been called
        screen.getShapeRenderer().setColor(GameColors.mainColor2);
        screen.getShapeRenderer().rect(getX(),getY(),rectangle.getWidth(),rectangle.getHeight());
        //renderer end will be called later
    }
    public Rectangle getRectangle(){
        return rectangle;
    }


}
