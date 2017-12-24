package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.kenboo.looprunner.Actors.PlayerBall;

/**
 * Created by kenbo on 2017-05-08.
 * This Block manager handles al the collision, drawing and updating of the blocks.
 *
 */

public class BlockManager extends Group{

    ShapeRenderer renderer;
    //these vectors will be used each loop for collision detection
    Vector2 start;
    Vector2 end;
    Vector2 center;


    //these are temporary vectors
    public BlockManager(ShapeRenderer renderer){
        //set up each block in the game through a json file
        this.renderer = renderer;
        start = new Vector2();
        end = new Vector2();
        center = new Vector2();

    }
    @Override
    public void act(float delta){
        for(Actor block:this.getChildren()){
            block.act(delta);
        }
    }

    public boolean checkCollision(PlayerBall ball){

        for (Actor block : this.getChildren()) {
            if (intersectCirclePolygon(((Block) block).getPolygon(), ball)) {
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

    //use this function to detect collision between the ball and the
    public boolean intersectCirclePolygon(Polygon polygon, PlayerBall ball) {
        int numberVertices = polygon.getVertices().length;

        for (int i = 3; i < numberVertices; i += 2) {
            //this is for all the vertices except the last one
            if (i != (numberVertices - 1)) {
                start.set(polygon.getTransformedVertices()[i - 3], polygon.getTransformedVertices()[i - 2]);
                end.set(polygon.getTransformedVertices()[i - 1], polygon.getTransformedVertices()[i]);
                center.set(ball.getX(), ball.getY());

                //for the last vertice, connect it with the first one
            } else {
                start.set(polygon.getTransformedVertices()[i - 1], polygon.getTransformedVertices()[i]);
                end.set(polygon.getTransformedVertices()[0], polygon.getTransformedVertices()[1]);
                center.set(ball.getX(), ball.getY());
            }
            if (Intersector.intersectSegmentCircle(start, end, center, ball.getRadius() * ball.getRadius())) {
                return true;
            }
        }
        return false;
    }




}
