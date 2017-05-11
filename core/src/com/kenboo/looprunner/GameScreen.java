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
    //base the radius of the circle on the width. The height will always be higher than the width.
    float width;
    float circleRadius;
    //thickness of the circle
    float thickness = circleRadius *0.1f;

    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    //view port width. A window to the game world.
    // The viewport height will be calculated from the ratio of the actual game window/phone screen
    //ratio

    //instance of main game
    private MainGame mainGame;

    private BackgroundCircle circle;
    private PlayerBall playerBall;
    //a temporary test block to test all the block functions
    private BlockManager blockManger;

    //touch vector
    private Vector3 touchVect;

    boolean gameOver = false;


    public GameScreen(MainGame mainGame){
        shapeRenderer = new ShapeRenderer();
        //setup camera for the gameScreen
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        width = Gdx.graphics.getWidth();
        circleRadius = width *0.75f/2;
        thickness = circleRadius *0.1f;

        circle = new BackgroundCircle(this, thickness);
        playerBall = new PlayerBall(this);
        blockManger = new BlockManager();
        touchVect = new Vector3();

        this.mainGame = mainGame;

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
            if(!gameOver) {
                GameColors.invertMainColors();
                blockManger.stop();
                playerBall.stop();
                gameOver = true;
            }

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
        camera.viewportWidth = width;
        camera.viewportHeight = height;
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
        if(touchVect.len()<circleRadius){
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
