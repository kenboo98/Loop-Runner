package com.kenboo.looprunner.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * This actor is to used to display in game text.
 * It is mostly used for the start and end game screems.
 * Can be easily attatched to buttons.
 */

public class TextActor extends Actor {
    private BitmapFont font;
    private GlyphLayout glyphLayout;//used to calculate size and position of text
    private String text;

    public TextActor(BitmapFont font, String text, Color color){
        this.font = font;
        glyphLayout = new GlyphLayout(font, text);
        this.text = text;
        setColor(color);
    }
    public void draw(Batch batch, float parentAlpha){
        //set colour
        font.setColor(getColor());
        //draw it centered at the x and y position on the batch
        font.draw(batch,text,getX()-glyphLayout.width/2, getY()+glyphLayout.height/2);
    }
    public void setText(String text){
        this.text = text;
    }

}
