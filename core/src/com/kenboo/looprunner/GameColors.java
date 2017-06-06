package com.kenboo.looprunner;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by kenbo on 2017-05-11.
 */

public class GameColors {
    //a global color controller. This way we can easily change all the colors depending on the levelText, game status etc
    //Color of most blocks, player etc
    public static Color mainColor1 = Color.WHITE;
    //color of background
    public static Color mainColor2 = Color.BLACK;

    public static void resetColors(){
        mainColor1 = Color.WHITE;
        mainColor2 = Color.BLACK;

    }
    public static void invertMainColors(){
        Color temp;
        temp = mainColor1;
        mainColor1 = mainColor2;
        mainColor2 = temp;
    }

}
