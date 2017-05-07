package com.kenboo.looprunner;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MainGame extends Game {
	private Screen gameScreen;
	//width and height of the area we want to create the circle
	//height is mever used
	static final int HEIGHT = 1000;
	static final int WIDTH = 1000;

	OrthographicCamera camera;
	@Override
	public void create () {

		//the main game screen
		gameScreen = new GameScreen();
		setScreen(gameScreen);



}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameScreen.render(Gdx.graphics.getDeltaTime());

	}
	
	@Override
	public void dispose () {
	}
}
