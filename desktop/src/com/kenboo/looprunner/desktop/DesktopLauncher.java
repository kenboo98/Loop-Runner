package com.kenboo.looprunner.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kenboo.looprunner.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 1280;
		config.width = 720;
		config.samples = 8;
		new LwjglApplication(new MainGame(), config);
	}
}
