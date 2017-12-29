package com.kenboo.looprunner.Actors;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenboo.looprunner.GameColors;
import com.kenboo.looprunner.GameScreen;

/**
 * This is a UI element that will indicated how many gold pieces are left in the level
 * and how many still need to be collected
 */

public class GoldIndicator extends Actor {
    //total number of gold in the level
    private int totalGold;
    //number of gold user has gotten
    private int gold = 0;
    private ShapeRenderer renderer;

    private final static float RADIUS = 20;//radius of each circle

    private final static float bottomLeftY = 60;
    private float bottomLeftX;

    public GoldIndicator(int totalGold, ShapeRenderer renderer){
        this.totalGold = totalGold;
        this.renderer = renderer;
        this.bottomLeftX = GameScreen.STAGE_WIDTH/2-(RADIUS*2)*totalGold/2;
    }
    public int getGold(){return gold;}
    public void incGold(){
        gold++;
    }
    public void draw(Batch batch, float parentAlpha){
        
        batch.end();
        //set up renderer
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());

        renderer.begin(ShapeRenderer.ShapeType.Filled);


        //draw each circle
        for(int i=0;i<totalGold;i++){
            if(i<gold){
                renderer.setColor(GameColors.miscColor1);
            }else{
                renderer.setColor(GameColors.miscColor2);
            }
            renderer.circle(bottomLeftX+2*i*RADIUS,bottomLeftY,RADIUS);
        }

        renderer.end();

        batch.begin();
    }
}
