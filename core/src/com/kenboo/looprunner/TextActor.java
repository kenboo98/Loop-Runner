package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
Used when displaying text in game. Can easily be attached to buttons
 */

public class TextActor extends Actor {
    private BitmapFont font;
    private GlyphLayout glyphLayout;
    private String text;

    public TextActor(BitmapFont font, String text, Color color){
        this.font = font;
        glyphLayout = new GlyphLayout(font, text);
        this.text = text;
        setColor(color);
        System.out.println(text);
        System.out.println(glyphLayout.width);
    }
    public void draw(Batch batch, float parentAlpha){
        //draw it centered at the x and y position

        font.setColor(getColor());

        font.draw(batch,text,getX()-glyphLayout.width/2, getY()+glyphLayout.height/2);
    }
    public void setLevelText(int level){
        this.text = "LEVEL:"+Integer.toString(level);
    }

}
