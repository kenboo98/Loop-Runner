package com.kenboo.looprunner.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kenboo.looprunner.GameColors;
import com.kenboo.looprunner.GameScreen;

/**
 * This is a UI element that will indicated how many coin pieces are left in the level
 * and how many still need to be collected
 */

public class CoinIndicator extends Actor {
    //total number of coin in the level
    private int totalCoin;
    //number of coin user has gotten
    private int coin = 0;
    private ShapeRenderer renderer;

    private final static float RADIUS = 20;//radius of each circle

    private final static float bottomLeftY = 60;
    private float bottomLeftX;

    public CoinIndicator(int totalCoin, ShapeRenderer renderer){
        this.totalCoin = totalCoin;
        this.renderer = renderer;
        this.bottomLeftX = GameScreen.STAGE_WIDTH/2-(RADIUS*2)* totalCoin /2;
    }
    public int getCoin(){return coin;}
    public void incGold(){
        coin++;
    }
    public void draw(Batch batch, float parentAlpha){

        batch.end();
        //set up renderer
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());

        renderer.begin(ShapeRenderer.ShapeType.Filled);


        //draw each circle
        for(int i = 0; i< totalCoin; i++){
            if(i< coin){
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
