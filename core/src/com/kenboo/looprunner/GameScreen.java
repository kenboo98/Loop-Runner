package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.kenboo.looprunner.Actors.BackgroundCircle;
import com.kenboo.looprunner.Actors.GoldIndicator;
import com.kenboo.looprunner.Actors.PlayerBall;
import com.kenboo.looprunner.Levels.LoadLevels;

/**
 * Created by kenbo on 2017-05-06.
 */

public class GameScreen implements Screen, InputProcessor {
    public final static float STAGE_WIDTH = 1080;
    public final static float STAGE_HEIGHT= 1920;

    private float circleRadius;
    //thickness of the circle
    private float thickness;
    private Stage stage;
    private ShapeRenderer shapeRenderer;

    //view port width. A window to the game world.
    // The viewport height will be calculated from the ratio of the actual game window/phone screen
    //ratio

    //instance of main game
    private MainGame mainGame;

    private BackgroundCircle circle;
    private PlayerBall playerBall;
    private GoldIndicator goldIndicator;
    //a temporary test block to test all the block functions
    private ActorManager actorManager;

    //touch vector
    private Vector3 touchVect;

    //misceallaneous
    private boolean gameOver = false;//boolean value so gameover events are only called once
    private int level;


    public GameScreen(MainGame mainGame, int level) {
        this.level = level;
        stage = new Stage(new FitViewport(STAGE_WIDTH, STAGE_HEIGHT));
        //place the camera at the center of stage. Camera anchor is at center of canera
        stage.getCamera().position.set(STAGE_WIDTH/2,STAGE_HEIGHT/2,0);
        Gdx.input.setInputProcessor(stage);

        //radius of the inside circle
        circleRadius = STAGE_WIDTH * 0.75f / 2;
        thickness = circleRadius * 0.1f;
        //this shape renderer will be used by all the actors
        shapeRenderer = new ShapeRenderer();

        circle = new BackgroundCircle(shapeRenderer, circleRadius, thickness);
        circle.setPosition(STAGE_WIDTH/2,STAGE_HEIGHT/2);

        playerBall = new PlayerBall(shapeRenderer, circleRadius, STAGE_WIDTH * 0.05f, thickness,STAGE_WIDTH/2,STAGE_HEIGHT/2);
        playerBall.setPosition(STAGE_WIDTH/2,STAGE_HEIGHT/2);

        goldIndicator = new GoldIndicator(5,shapeRenderer);

        stage.addActor(circle);
        stage.addActor(playerBall);
        stage.addActor(goldIndicator);
        Gdx.app.log("Gold",Integer.toString(goldIndicator.getGold()));
        touchVect = new Vector3();
        actorManager = LoadLevels.getLevel(level, shapeRenderer);
        stage.addActor(actorManager);
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
        //collision events
        //Gold collisions
        if(actorManager.goldCollision(playerBall)){
            goldIndicator.incGold();
        }
        // Go to game over screen if player hits a block
        if (actorManager.blockCollision(playerBall)) {
            //when user collides
            if (!gameOver) {
                GameColors.invertMainColors();

                playerBall.stop();
                actorManager.stop();
                circle.addAction(Actions.sequence(Actions.scaleTo(3, 3, 1.5f, Interpolation.sine), new GameOverScreenAction(mainGame, GameOverScreen.FAIL)));
                gameOver = true;
            }

        }
        if (actorManager.actionsCompleted() && !gameOver) {
            //when the level is completed
            gameOver = true;
            System.out.println("Added");
            //this animate the circle and then change screens
            circle.addAction(Actions.sequence(Actions.scaleTo(3, 3, 1.5f, Interpolation.sine), new GameOverScreenAction(mainGame, GameOverScreen.SUCCESS)));
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
        //if the vector from the center of circle to the touch coordinate is smaller than the radius,
        //then it means that the touch is inside the circle. Then, switch sides of the ball
        if (Vector3.len2(touchVect.x-STAGE_WIDTH/2,touchVect.y-STAGE_HEIGHT/2,0) < circleRadius*circleRadius) {
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

