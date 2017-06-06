package com.kenboo.looprunner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * class to load and handle assets. Mostly fonts for this game.
 */

public class Assets {
    public static BitmapFont font64;
    public static BitmapFont font256;
    public static BitmapFont font128;

    public static void load(){
        font64 = new BitmapFont(Gdx.files.internal("font64.fnt"));
        font256 = new BitmapFont(Gdx.files.internal("font256.fnt"));
        font128 = new BitmapFont(Gdx.files.internal("fon128.fnt"));
    }
}
