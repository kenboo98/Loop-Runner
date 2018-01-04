package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.kenboo.looprunner.Actors.Coin;
import com.kenboo.looprunner.Actors.PlayerBall;

/**
 * Created by kenbo on 2017-05-08.
 * This actor manager handles al the collision, drawing and updating of the blocks
 * and also the gold.
 *
 */

public class ActorManager extends Group{

    ShapeRenderer renderer;
    //these vectors will be used each loop for collision detection
    Vector2 start;
    Vector2 end;
    Vector2 center;


    //these are temporary vectors
    public ActorManager(ShapeRenderer renderer){
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

    public boolean blockCollision(PlayerBall ball){

        for (Actor block : this.getChildren()) {
            if (block instanceof Block && intersectCirclePolygon(((Block) block).getPolygon(), ball.getCircle())) {
                return true;
            }
        }
        return false;


    }
    public void stop(){
        //stops all the actions
        for(Actor actor:this.getChildren()){
            actor.clearActions();
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

    /**
     * This function is to do collision checking between the player ball and the blocks.
     * The blocks are treated as polygons due to the fact that it will get rotated in game.
     * The function will simply go through each edge of the block and check if that line
     * collides with the circle representing the player ball
     * @param polygon
     * @param circle
     * @return
     */
    public boolean intersectCirclePolygon(Polygon polygon, Circle circle) {

        int numberVertices = polygon.getVertices().length;
        //do quick bound checks before the full check with each polygon line
        if(!quickCheck(polygon.getBoundingRectangle(),circle)) return false;
        for (int i = 3; i <= numberVertices+1; i += 2) {
            //this is for all the vertices except the last one
            if (i != (numberVertices +  1)) {
                start.set(polygon.getTransformedVertices()[i - 3], polygon.getTransformedVertices()[i - 2]);
                end.set(polygon.getTransformedVertices()[i - 1], polygon.getTransformedVertices()[i]);
                center.set(circle.x, circle.y);

                //for the last vertice, connect it with the first one
            } else {
                start.set(polygon.getTransformedVertices()[i-3], polygon.getTransformedVertices()[i-2]);
                end.set(polygon.getTransformedVertices()[0], polygon.getTransformedVertices()[1]);
                center.set(circle.x,circle.y);
            }
            if (Intersector.intersectSegmentCircle(start, end, center, circle.radius * circle.radius)) {
                return true;
            }
        }
        return false;
    }
    //this function checks for a collision between the player and the gold
    //It returns true if the player
    public boolean goldCollision(PlayerBall player){
        for(Actor child:getChildren()){
            if(child instanceof Coin){
                if(((Coin)child).getCircle().overlaps(player.getCircle())){
                    child.remove();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * A quick check to be preformed before doing the more accurate bound checks
     *
     * @param bound
     * @param circle
     * @return wether or
     */
    private boolean quickCheck(Rectangle bound, Circle circle){
        if(circle.x + circle.radius <bound.getX()) return false;
        if(circle.x - circle.radius > bound.getX()+bound.getWidth()) return false;
        if(circle.y + circle.radius <bound.getY()) return false;
        if(circle.y - circle.radius > bound.getY()+bound.getHeight()) return false;
        return true;

    }

}
