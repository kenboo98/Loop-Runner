package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;

/**
 * Created by kenbo on 2017-05-06.
 */

public class GameScreen implements Screen, InputProcessor{
    //width of the area
    static final int WIDTH = 1000;
    static final float CIRCLE_RADIUS = WIDTH*0.75f/2;
    //thickness of the circle
    static final float THICKNESS = CIRCLE_RADIUS *0.1f;

    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    //view port width. A window to the game world.
    // The viewport height will be calculated from the ratio of the actual game window/phone screen
    //ratio
    private float viewPortWidth = 1080;


    private BackgroundCircle circle;
    private PlayerBall playerBall;
    //a temporary test block to test all the block functions
    private BlockManager blockManger;

    //touch vector
    private Vector3 touchVect;


    public GameScreen(){
        shapeRenderer = new ShapeRenderer();
        //setup camera for the gameScreen
        camera = new OrthographicCamera(viewPortWidth, viewPortWidth * Gdx.graphics.getHeight()/Gdx.graphics.getWidth());

        circle = new BackgroundCircle(THICKNESS);
        playerBall = new PlayerBall();
        blockManger = new BlockManager();
        touchVect = new Vector3();

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
        //update
        playerBall.update(Gdx.graphics.getDeltaTime());
        blockManger.update(Gdx.graphics.getDeltaTime());
        //check collision
        if(blockManger.checkCollision(playerBall)){
            Gdx.app.exit();
        }
        //setup shape renderer
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //draw
        circle.draw(shapeRenderer);
        playerBall.draw(shapeRenderer);
        blockManger.draw(shapeRenderer);
        //end shape renderer
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        //calculate the viewport height from the height, width ratio. This scales everything well
        camera.viewportWidth = viewPortWidth;
        camera.viewportHeight = viewPortWidth * height/width;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchVect = camera.unproject(touchVect.set(screenX,screenY,0));
        //if the vector from the center to the touch coordinate is smaller than the radius,
        //then it means that the touch is inside the circle. Then, switch sides of the ball
        if(touchVect.len()<CIRCLE_RADIUS){
            playerBall.switchSide();
        }else{
            playerBall.switchDirection();
        }


        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
