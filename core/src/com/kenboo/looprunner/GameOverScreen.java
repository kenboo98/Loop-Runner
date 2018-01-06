package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.kenboo.looprunner.Actors.CircleButtonActor;
import com.kenboo.looprunner.Actors.TextActor;

/**
 This screen is for both when a user completes a level and when a user fails a level
 */

public class GameOverScreen implements Screen {
    private final static int STAGE_WIDTH = 1080;
    private final static int STAGE_HEIGHT = 1920;
    //constants to represent the state of the last attempt
    final static int FAIL = 1;
    final static int SUCCESS = 2;
    //this flag represents if the screen is gonna display, RETRY or NEXT LEVEL
    private int flag;
    //if the user fails the level, set next level to the current level to retry
    private int nextLevel;

    private MainGame mainGame;
    private Stage stage;
    private ShapeRenderer renderer;
    //main button will be a retry or next level button
    //menu button will be a button to go back to the main menu
    private CircleButtonActor mainButton, menuButton;
    private TextActor mainButtonText, menuButtonText;
    //button group to group the button and button text together
    private Group mainButtonGroup, menuButtonGroup;

    public GameOverScreen(MainGame main, int flag, int currentLevel){
        this.flag = flag;
        this.nextLevel = flag == SUCCESS ? currentLevel + 1 : currentLevel;
        this.mainGame = main;


    }

    @Override
    public void show() {
        //setup the stage and the shape renderer.
        stage = new Stage(new FitViewport(STAGE_WIDTH, STAGE_HEIGHT));
        Gdx.input.setInputProcessor(stage);
        renderer = new ShapeRenderer();

        mainButton = new CircleButtonActor(renderer, Color.BLACK, STAGE_WIDTH * 0.3f);
        mainButton.setPosition(0,0);
        if(flag == FAIL){
            mainButtonText = new TextActor(Assets.font128,"RETRY",Color.WHITE);
        }
        if(flag == SUCCESS){
            mainButtonText = new TextActor(Assets.font128,">NEXT\n>LEVEL", Color.WHITE);
        }

        mainButtonText.setPosition(mainButton.getWidth()/2,mainButton.getHeight()/2);

        mainButtonGroup = new Group();
        mainButtonGroup.addActor(mainButton);
        mainButtonGroup.addActor(mainButtonText);
        mainButtonGroup.setPosition(STAGE_WIDTH / 2 - mainButton.getWidth() / 2, STAGE_HEIGHT / 2 - mainButton.getHeight() / 2);

        mainButton.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                mainButtonGroup.addAction(new SequenceAction(Actions.moveTo(mainButtonGroup.getX(), STAGE_HEIGHT + mainButton.getHeight(), 1.5f, Interpolation.sine), new NewGameAction(mainGame)));
                return false;
            }
        });
        stage.addActor(mainButtonGroup);

        menuButton = new CircleButtonActor(renderer, Color.BLACK, STAGE_WIDTH * 0.15f);
        menuButton.setPosition(0, 0);
        menuButtonText = new TextActor(Assets.font64, "MENU", Color.WHITE);
        menuButtonText.setPosition(menuButton.getWidth() / 2, menuButton.getHeight() / 2);

        menuButtonGroup = new Group();
        menuButtonGroup.addActor(menuButton);
        menuButtonGroup.addActor(menuButtonText);
        menuButtonGroup.setPosition(STAGE_WIDTH / 2 - menuButton.getWidth() / 2, STAGE_HEIGHT / 5 - menuButton.getHeight() / 2);

        menuButtonGroup.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                menuButtonGroup.addAction(new SequenceAction(Actions.moveTo(menuButtonGroup.getX(), -menuButton.getHeight(), 1.5f, Interpolation.sine), new MenuAction(mainGame)));
                return false;
            }
        });
        stage.addActor(menuButtonGroup);

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        //VERY IMPORTANT
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

    class NewGameAction extends Action {
        MainGame main;

        public NewGameAction(MainGame main) {
            this.main = main;
        }
        @Override
        public boolean act(float delta) {
            main.changeScreen(new GameScreen(main, nextLevel));
            return false;
        }
    }

    class MenuAction extends Action {
        MainGame main;

        public MenuAction(MainGame main) {
            this.main = main;
        }

        @Override
        public boolean act(float delta) {
            main.changeScreen(new MenuScreen(main));
            return false;
        }
    }
}
