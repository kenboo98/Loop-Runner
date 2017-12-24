package com.kenboo.looprunner.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenboo.looprunner.GameColors;
import com.kenboo.looprunner.GameScreen;


/**
 * This class represents the ring that the ball will rotate on.
 * Since we cannot draw a thick ring with libgdx,
 * we will draw two circles. A white inside and a large black circle to draw a ring.
 */

public class BackgroundCircle extends Actor {
    //class to draw the circle in the background. To get a ring, draw two circles
    //thickness of the loop. Difference in the radius of the two circles.
    private float thickness;

    private GameScreen screen;
    private ShapeRenderer renderer;



    public BackgroundCircle(ShapeRenderer renderer,float radius, float thickness){
        this.thickness = thickness;
        this.setWidth(radius);
        this.setHeight(radius);
        this.renderer = renderer;


    }
    public void draw(Batch batch, float parentAlpha){
        batch.end();
        //set up renderer
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.scale(getScaleX(),getScaleY(),0);
        renderer.translate(getX(), getY(), 0);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        //draw circles
        renderer.setColor(GameColors.mainColor2);
        renderer.circle(0, 0, getWidth());
        //inside circle
        renderer.setColor(GameColors.mainColor1);
        renderer.circle(0,0,getWidth() - thickness);

        renderer.end();
        batch.begin();
    }
}
