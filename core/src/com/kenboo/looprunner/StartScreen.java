package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by kenbo on 2017-05-08.
 */

public class StartScreen implements Screen {


    MainGame mainGame;
    Stage stage;
    //test start button
    Group startButtonGroup;
    CircleButtonActor startButton;
    TextActor startText;

    TextActor levelText;

    ShapeRenderer renderer;

    ArrowButtonActor leftLevel;
    ArrowButtonActor rightLevel;
    //level to display on the play screen
    int currentLevel;

    public StartScreen(MainGame mainGame) {
        this.mainGame = mainGame;
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(1080, 1920));
        currentLevel = 1;
        renderer = new ShapeRenderer();
        Gdx.input.setInputProcessor(stage);

        //use the actor class to create buttons
        startButton = new CircleButtonActor(renderer, Color.BLACK, stage.getWidth() * 0.6f / 2);
        startButton.setPosition(0, 0);
        startButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //the action sequence is the animation action and then the change of screens action
                startButtonGroup.addAction(Actions.sequence(Actions.moveTo(startButtonGroup.getX(), stage.getHeight() + startButton.getHeight(), 1), new GameScreenAction(mainGame, currentLevel)));

                //mainGame.changeScreen(new GameScreen(mainGame));
                return false;
            }
        });

        startText = new TextActor(Assets.font128, "PLAY", Color.WHITE);
        //center the text actor on the button
        startText.setPosition(startButton.getWidth() / 2, startButton.getHeight() / 2);
        //use this group so the buttons go up together
        startButtonGroup = new Group();
        startButtonGroup.setPosition(stage.getWidth() / 2 - startButton.getWidth() / 2, stage.getHeight() / 2 - startButton.getHeight() / 2);
        startButtonGroup.addActor(startButton);
        startButtonGroup.addActor(startText);
        stage.addActor(startButtonGroup);

        levelText = new TextActor(Assets.font64, "LEVEL:1", Color.BLACK);
        levelText.setPosition(stage.getWidth() / 2, stage.getHeight() / 4);
        stage.addActor(levelText);

        leftLevel = new ArrowButtonActor(renderer, 64, 64, ArrowButtonActor.LEFT);
        leftLevel.setPosition(stage.getWidth() / 4, levelText.getY() - leftLevel.getHeight() / 2);
        leftLevel.setColor(Color.BLACK);

        leftLevel.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                if (currentLevel > 1) {
                    currentLevel--;
                    levelText.setLevelText(currentLevel);
                }

                return false;
            }
        });
        stage.addActor(leftLevel);

        rightLevel = new ArrowButtonActor(renderer, 64, 64, ArrowButtonActor.RIGHT);
        rightLevel.setPosition(stage.getWidth() * 0.75f - rightLevel.getWidth(), levelText.getY() - rightLevel.getHeight() / 2);
        rightLevel.setColor(Color.BLACK);
        rightLevel.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("clicked");
                if (currentLevel < LoadLevels.N_LEVELS) {
                    currentLevel++;
                    levelText.setLevelText(currentLevel);
                }

                return false;
            }
        });
        stage.addActor(rightLevel);


    }

    @Override
    public void render(float delta) {

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
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
}



class GameScreenAction extends Action{
    //this is the action we must put at the end of the animation action sequence for the buttons
    MainGame mainGame;
    int level;
    public GameScreenAction(MainGame mainGame, int level){
        super();
        this.level = level;
        this.mainGame = mainGame;

    }

    @Override
    public boolean act(float delta) {
        mainGame.changeScreen(new GameScreen(mainGame, level));
        return true;
    }
}