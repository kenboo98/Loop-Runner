package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * class to load and handle assets. Mostly fonts for this game.
 */

public class Assets {
    public static BitmapFont font64;
    public static BitmapFont font256;
    public static BitmapFont font128;
    public static BitmapFont font96;

    public static void load(){
        font64 = new BitmapFont(Gdx.files.internal("fonts/font64.fnt"));
        font256 = new BitmapFont(Gdx.files.internal("fonts/font256.fnt"));
        font128 = new BitmapFont(Gdx.files.internal("fonts/font128.fnt"));
        font96 = new BitmapFont(Gdx.files.internal("fonts/font96.fnt"));
    }
}
