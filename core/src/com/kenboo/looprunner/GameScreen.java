package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by kenbo on 2017-05-06.
 */

public class GameScreen implements Screen, InputProcessor {
    //base the radius of the circle on the width. The height will always be higher than the width.
    float width;
    float circleRadius;
    //thickness of the circle
    float thickness = circleRadius * 0.1f;
    private Stage stage;
    private ShapeRenderer shapeRenderer;

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


    public GameScreen(MainGame mainGame) {
        stage = new Stage(new FitViewport(1080, 1920));
        stage.getViewport().getCamera().position.set(0,0,0);
        Gdx.input.setInputProcessor(stage);
        width = stage.getWidth();
        circleRadius = width * 0.75f / 2;
        thickness = circleRadius * 0.1f;

        circle = new BackgroundCircle(this, circleRadius, thickness);
        playerBall = new PlayerBall(this, circleRadius, width * 0.05f, thickness);
        stage.addActor(circle);
        stage.addActor(playerBall);
        touchVect = new Vector3();
        blockManger = LoadLevels.getLevel1(this);
        stage.addActor(blockManger);
        this.mainGame = mainGame;

        //this shape renderer will be used by all the actors
        shapeRenderer = new ShapeRenderer();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);


    }

    @Override
    public void render(float delta) {
        //update
        playerBall.act(Gdx.graphics.getDeltaTime());
        blockManger.act(Gdx.graphics.getDeltaTime());
        //collision event
        if (blockManger.checkCollision(playerBall)) {
            if (!gameOver) {
                GameColors.invertMainColors();

                playerBall.stop();
                blockManger.stop();
                gameOver = true;
            }

        }
        if(blockManger.actionsCompleted()){
            mainGame.changeScreen(new StartScreen(mainGame));
        }

        //setup shape renderer
        shapeRenderer.setProjectionMatrix(stage.getCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        //draw
        stage.draw();
        //end shape renderer
        shapeRenderer.end();

    }

    @Override
    public void resize(int width, int height) {
        //calculate the viewport height from the height, width ratio. This scales everything well
        stage.getViewport().update(width, height, false);
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
        touchVect = stage.getCamera().unproject(touchVect.set(screenX, screenY, 0));
        //if the vector from the center to the touch coordinate is smaller than the radius,
        //then it means that the touch is inside the circle. Then, switch sides of the ball
        if (touchVect.len() < circleRadius) {
            playerBall.switchSide();
        } else {
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

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }
}

