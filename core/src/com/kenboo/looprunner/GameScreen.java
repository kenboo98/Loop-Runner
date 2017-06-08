package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
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
    //use this boolean values so the events when the game is over is only called once
    boolean gameOver = false;
    int level;


    public GameScreen(MainGame mainGame, int level) {
        this.level = level;
        stage = new Stage(new FitViewport(1080, 1920));
        stage.getCamera().position.set(0,0,0);
        Gdx.input.setInputProcessor(stage);

        width = stage.getWidth();
        circleRadius = width * 0.75f / 2;
        thickness = circleRadius * 0.1f;
        //this shape renderer will be used by all the actors
        shapeRenderer = new ShapeRenderer();
        circle = new BackgroundCircle(shapeRenderer, circleRadius, thickness);

        playerBall = new PlayerBall(shapeRenderer, circleRadius, width * 0.05f, thickness);

        stage.addActor(circle);
        stage.addActor(playerBall);
        touchVect = new Vector3();
        blockManger = LoadLevels.getLevel(level, shapeRenderer);
        stage.addActor(blockManger);
        this.mainGame = mainGame;


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);


    }

    @Override
    public void render(float delta) {
        //update
        stage.act(delta);
        //collision event. Go to game over screen
        if (blockManger.checkCollision(playerBall)) {
            //when user collides
            if (!gameOver) {
                GameColors.invertMainColors();

                playerBall.stop();
                blockManger.stop();
                circle.addAction(Actions.sequence(Actions.scaleTo(3, 3, 1.5f), new GameOverScreenAction(mainGame,GameOverScreen.FAIL)));
                gameOver = true;
            }

        }
        if (blockManger.actionsCompleted() && !gameOver) {
            //when the level is completed
            gameOver = true;
            System.out.println("Added");
            //this animate the circle and then change screens
            circle.addAction(Actions.sequence(Actions.scaleTo(3, 3, 1.5f), new GameOverScreenAction(mainGame,GameOverScreen.SUCCESS)));
            System.out.println(circle.getScaleX());
        }


        //draw
        stage.draw();


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

    class GameOverScreenAction extends Action {
        //this is the action we can put at the end of the animation action sequence for the buttons to change screens
        MainGame mainGame;
        int flag;

        public GameOverScreenAction(MainGame mainGame, int flag) {
            super();
            this.mainGame = mainGame;
            this.flag = flag;

        }

        @Override
        public boolean act(float delta) {
            GameColors.resetColors();
            mainGame.changeScreen(new GameOverScreen(mainGame,flag, level));
            return true;
        }
    }
}

