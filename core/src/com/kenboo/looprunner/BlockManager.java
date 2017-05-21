package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;

/**
 * Created by kenbo on 2017-05-08.
 */

public class BlockManager {
    ArrayList<Block> blocks;

    //use json to store all the level data
    JsonValue jsonFile;
    JsonValue blockss;
    JsonValue.JsonIterator jsonBlocks;
    Json json;

    public BlockManager(int level){
        //set up each block in the game through a json file
        blocks = new ArrayList<Block>();
        jsonFile = new JsonReader().parse(Gdx.files.internal("level"+Integer.toString(level))+".json");
        blockss  = jsonFile.get("blocks");

        jsonBlocks = blockss.iterator();
       /* for(JsonValue block: jsonBlocks){
            //add the block to an array
            Gdx.app.log("Blocks:","ADDED");
            blocks.add(new Block(block.get("x").asFloat(),block.get("y").asFloat(),block.get("width").asFloat(),block.get("height").asFloat()));
            blocks.get(blocks.size()-1).setVelocity(block.get("deltaX").asFloat(),block.get("deltaY").asFloat());

        }*/






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
