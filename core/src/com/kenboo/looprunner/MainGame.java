package com.kenboo.looprunner;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

 public class MainGame extends Game {

	private Screen currentScreen;


	OrthographicCamera camera;
	@Override
	public void create () {

		//the main game screen

		Gdx.app.log("HEIGHT: ", Float.toString(Gdx.graphics.getHeight()));
		Gdx.app.log("width: ", Float.toString(Gdx.graphics.getWidth()));
		currentScreen = new StartScreen(this);
		setScreen(currentScreen);



}

	@Override
	public void render () {
		Gdx.gl.glClearColor(GameColors.mainColor1.r, GameColors.mainColor1.g, GameColors.mainColor1.b, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		currentScreen.render(Gdx.graphics.getDeltaTime());


	}
	
	@Override
	public void dispose () {
	}
	public void changeScreen(Screen screen){
		currentScreen.dispose();
		currentScreen = screen;
		setScreen(currentScreen);
	}
}
