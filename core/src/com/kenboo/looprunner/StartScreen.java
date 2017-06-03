package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by kenbo on 2017-05-08.
 */

public class StartScreen implements Screen, InputProcessor {




    MainGame mainGame;
    Stage stage;
    //test start button
    ButtonActor startButton;

    public StartScreen(MainGame mainGame){
        this.mainGame = mainGame;
    }
    @Override
    public void show() {
        stage = new Stage(new FitViewport(1080,1920));
        Gdx.input.setInputProcessor(stage);
        //button actor is a class
        startButton = new ButtonActor(Color.BLACK,stage.getWidth() * 0.6f/2);
        System.out.println(stage.getWidth());
        System.out.println(stage.getHeight());
        startButton.setPosition(stage.getWidth()/2-startButton.getWidth()/2,stage.getHeight()/2-startButton.getWidth()/2);
        startButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //the action sequence is the animation action and then the change of screens action
                startButton.addAction(Actions.sequence(Actions.moveTo(startButton.getX(), stage.getHeight() + startButton.getHeight(),1),new GameScreenAction(mainGame)));

                //mainGame.changeScreen(new GameScreen(mainGame));
                return false;
            }
        });
        stage.addActor(startButton);






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
        stage.dispose();
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
        return false;
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
class GameScreenAction extends Action{
    //this is the action we must put at the end of the animation action sequence for the buttons
    MainGame mainGame;

    public GameScreenAction(MainGame mainGame){
        super();
        this.mainGame = mainGame;

    }

    @Override
    public boolean act(float delta) {
        mainGame.changeScreen(new GameScreen(mainGame));
        return true;
    }
}