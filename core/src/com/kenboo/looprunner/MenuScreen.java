package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.kenboo.looprunner.Actors.ArrowButtonActor;
import com.kenboo.looprunner.Actors.CircleButtonActor;
import com.kenboo.looprunner.Actors.TextActor;
import com.kenboo.looprunner.Levels.LoadLevels;

/**
 * Created by kenbo on 2017-05-08.
 */

public class MenuScreen implements Screen {

    public final static float STAGE_WIDTH = 1080;
    public final static float STAGE_HEIGHT= 1920;

    private MainGame mainGame;
    private Stage stage;
    private ShapeRenderer renderer;
    //vario
    private Group startButtonGroup;
    private CircleButtonActor startButton;
    private TextActor startText, levelText,coinText;
    private ArrowButtonActor leftLevel, rightLevel;
    private Preferences prefs;
    //level to display on the play screen
    private int currentLevel;

    private final static float ARROW_BUTTON_HEIGHT = 128;

    MenuScreen(MainGame mainGame) {
        this.mainGame = mainGame;
        //this preference file stores all the
        prefs = Gdx.app.getPreferences("game_data");
        //set the first level choice to the top unlocked level,
        currentLevel = prefs.getInteger("unlocked_level",1);
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(STAGE_WIDTH, STAGE_HEIGHT));

        renderer = new ShapeRenderer();//create a new shape renderer
        Gdx.input.setInputProcessor(stage);

        //use the actor class to create buttons
        startButton = new CircleButtonActor(renderer, Color.BLACK, STAGE_WIDTH * 0.6f / 2);
        startButton.setPosition(0, 0);
        startButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //the action sequence is the animation action and then the change of screens action
                startButtonGroup.addAction(Actions.sequence(Actions.moveBy(0, STAGE_HEIGHT, 2f, Interpolation.sine), new GameScreenAction(mainGame, currentLevel)));
                return false;
            }
        });

        startText = new TextActor(Assets.font128, "PLAY", Color.WHITE);
        startText.setPosition(startButton.getWidth() / 2, startButton.getHeight() / 2);//center the text on the button
        startButtonGroup = new Group();//use this group so the buttons go up together
        startButtonGroup.setPosition(STAGE_WIDTH / 2 - startButton.getWidth() / 2, STAGE_HEIGHT / 2 - startButton.getHeight() / 2);
        startButtonGroup.addActor(startButton);
        startButtonGroup.addActor(startText);


        levelText = new TextActor(Assets.font96, "Level: "+Integer.toString(currentLevel), Color.BLACK);
        levelText.setPosition(STAGE_WIDTH / 2, STAGE_HEIGHT / 4);
        coinText = new TextActor(Assets.font64,"Coins: 0/3",Color.BLACK);
        coinText.setPosition(STAGE_WIDTH/2,levelText.getY()-192);
        setCoinText();

        leftLevel = new ArrowButtonActor(renderer, ARROW_BUTTON_HEIGHT, ARROW_BUTTON_HEIGHT, ArrowButtonActor.LEFT);
        leftLevel.setPosition(STAGE_WIDTH * 0.15f, levelText.getY() - leftLevel.getHeight() / 2);
        leftLevel.setColor(Color.BLACK);

        leftLevel.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                if (currentLevel > 1) {
                    currentLevel--;
                    levelText.setText("Level: "+Integer.toString(currentLevel));
                    rightLevel.setVisible(true);
                }
                if (currentLevel == 1) {
                    leftLevel.setVisible(false);
                }
                setCoinText();
                return false;
            }
        });
        stage.addActor(leftLevel);

        rightLevel = new ArrowButtonActor(renderer, ARROW_BUTTON_HEIGHT, ARROW_BUTTON_HEIGHT, ArrowButtonActor.RIGHT);
        rightLevel.setPosition(STAGE_WIDTH * 0.85f - rightLevel.getWidth(), levelText.getY() - rightLevel.getHeight() / 2);
        rightLevel.setColor(Color.BLACK);
        rightLevel.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                if (currentLevel < LoadLevels.N_LEVELS) {
                    currentLevel++;
                    levelText.setText("Level: "+Integer.toString(currentLevel));
                    leftLevel.setVisible(true);
                }
                if (currentLevel == LoadLevels.N_LEVELS) {
                    rightLevel.setVisible(false);
                }
                setCoinText();
                return false;
            }
        });
        //Add all the actors to the screen
        stage.addActor(startButtonGroup);
        stage.addActor(levelText);
        stage.addActor(coinText);
        stage.addActor(rightLevel);


    }
    private void setCoinText(){
        coinText.setText("Coins: "+
                Integer.toString(prefs.getInteger(Integer.toString(currentLevel)+"_coins",0))
        +"/"+Integer.toString(LoadLevels.coinNum[currentLevel-1]));
    }
    @Override
    public void render(float delta) {
        //render the stage
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
    //this action is added to the end of the animation sequence
    //it will change the screen of the mainGame object
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