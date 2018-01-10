
package com.kenboo.looprunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/*
* This class handles the the main game life cycle.
* Handles the initial startup, the rendering, disposal and
* switching of the different screens.
*
*
 */
public class MainGame extends Game {

    private Screen currentScreen;

    @Override
    public void create() {

        //the main game screen
        Assets.load();
        //document the width and height of the screen
        Gdx.app.log("HEIGHT: ", Float.toString(Gdx.graphics.getHeight()));
        Gdx.app.log("WIDTH: ", Float.toString(Gdx.graphics.getWidth()));
        //first initialize a start screen
        currentScreen = new MenuScreen(this);
        setScreen(currentScreen);
    }

    @Override
    public void render() {
        //clear the screen with the main color and render the current screen
        Gdx.gl.glClearColor(GameColors.mainColor1.r, GameColors.mainColor1.g, GameColors.mainColor1.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        currentScreen.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        //dispose the current screen to avoid memory leaks
        currentScreen.dispose();
    }

    public void changeScreen(Screen screen) {
        currentScreen.dispose();
        currentScreen = screen;
        setScreen(currentScreen);
    }
}
