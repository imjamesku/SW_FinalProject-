package com.jamesku.sample;

import com.jamesku.framework.Image;
import com.jamesku.framework.Music;
import com.jamesku.framework.Sound;


public class Assets {

    public static Image menu, splash, background, character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
    public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown;
    public static Image button;
    public static Sound click;
    public static Music theme;
    public static Image soccer,soccer2,soccer3,soccer4,soccer5,soccer6,soccer7,soccer8;
    public static Image sand,sand2,sand3,sand4,sand5,sand6,sand7,sand8,sand9,sand10,sand11,sand12,sand13,sand14,sand15;
    private Animation sandanim;

    public static void load(SampleGame sampleGame) {
        // TODO Auto-generated method stub
        theme = sampleGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }

}