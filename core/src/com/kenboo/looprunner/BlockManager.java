package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;

import java.util.ArrayList;

/**
 * Created by kenbo on 2017-05-08.
 * A class to read and create all the blocks from a json file.
 * Also handles the collisions and draws the blocks.
 */

public class BlockManager extends Group{

    GameScreen screen;

    //use json to store all the level data
    JsonValue jsonFile;

    JsonValue.JsonIterator jsonBlocks;
    Json json;

    public BlockManager(GameScreen screen){
        //set up each block in the game through a json file

        this.screen = screen;

    }
    @Override
    public void act(float delta){
        for(Actor block:this.getChildren()){
            block.act(delta);
        }
    }

    public boolean checkCollision(PlayerBall ball){
        for(Actor block:this.getChildren()){
            if(Intersector.overlaps(ball.getCircle(), ((Block)block).getRectangle())){
                return true;
            }
        }
        return false;


    }
    public void stop(){
        //stops all the actions
        for(Actor block:this.getChildren()){
            block.clearActions();
        }
    }
    public boolean actionsCompleted(){
        //if there are actions left in any of the child actors, return false
         for(Actor block:this.getChildren()){
             if(block.hasActions()){
                 return false;
             }
         }return true;
    }



}
