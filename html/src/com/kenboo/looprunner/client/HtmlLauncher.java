package com.kenboo.looprunner.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.kenboo.looprunner.MainGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
            return new GwtApplicationConfiguration(720, 480);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new MainGame();
        }
}