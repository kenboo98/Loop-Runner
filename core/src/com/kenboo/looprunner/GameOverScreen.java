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
    //constants to represent the state of the last attempt
    final static int FAIL = 1;
    final static int SUCCESS = 2;
    //this flag represents if the screen is gonna display, RETRY or NEXT LEVEL
    int flag;
    int currentLevel;

    MainGame mainGame;
    Stage stage;
    ShapeRenderer renderer;
    //main button
    CircleButtonActor mainButton;
    TextActor mainButtonText;
    //button group to group the button and button text togethher
    Group buttonGroup;

    public GameOverScreen(MainGame main, int flag, int currentLevel){
        this.flag = flag;
        this.currentLevel = currentLevel;
        this.mainGame = main;

    }

    @Override
    public void show() {
        //setup the stage
        stage = new Stage(new FitViewport(1080,1920));
        Gdx.input.setInputProcessor(stage);
        renderer = new ShapeRenderer();

        mainButton = new CircleButtonActor(renderer, Color.BLACK,stage.getWidth()*0.3f);
        mainButton.setPosition(0,0);
        if(flag == FAIL){
            mainButtonText = new TextActor(Assets.font128,"RETRY",Color.WHITE);
        }
        if(flag == SUCCESS){
            mainButtonText = new TextActor(Assets.font128,">NEXT\n>LEVEL", Color.WHITE);
        }

        mainButtonText.setPosition(mainButton.getWidth()/2,mainButton.getHeight()/2);

        buttonGroup = new Group();
        buttonGroup.addActor(mainButton);
        buttonGroup.addActor(mainButtonText);
        buttonGroup.setPosition(stage.getWidth() / 2 - mainButton.getWidth() / 2, stage.getHeight() / 2 - mainButton.getHeight() / 2);

        mainButton.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                buttonGroup.addAction(new SequenceAction(Actions.moveTo(buttonGroup.getX(), stage.getHeight() + mainButton.getHeight(), 1.5f, Interpolation.sine), new StartScreenAction(mainGame)));
                return false;
            }
        });
        stage.addActor(buttonGroup);

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
    class StartScreenAction extends Action{
        MainGame main;
        public StartScreenAction(MainGame main){
            this.main = main;
        }
        @Override
        public boolean act(float delta) {
            main.changeScreen(new StartScreen(main));
            return false;
        }
    }
}
