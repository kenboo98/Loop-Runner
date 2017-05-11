package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

/**
 * Created by kenbo on 2017-05-08.
 */

public class BlockManager {
    ArrayList<Block> blocks;

    public BlockManager(){
        blocks = new ArrayList<Block>();
        blocks.add(new Block(-400,100, 50,300));
        blocks.add(new Block(0, -600, 300,50));
        blocks.get(0).setVelocity(90,40);
        blocks.get(1).setVelocity(30,108);

    }
    public void update(float delta){
        for(Block block:blocks){
            block.update(delta);
        }
    }
    public void draw(ShapeRenderer renderer){
        ///renderer.begin() should've already been called
        for(Block block:blocks){
            block.draw(renderer);
        }
    }
    public boolean checkCollision(PlayerBall ball){
        for(Block block:blocks){
            if(Intersector.overlaps(ball.getCircle(), block.getRectangle())){
                return true;
            }
        }
        return false;


    }
    public void stop(){
        for(Block block:blocks){
            block.setVelocity(0,0);
        }
    }

}
