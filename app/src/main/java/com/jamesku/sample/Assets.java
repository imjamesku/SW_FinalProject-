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
    public static Image cool,cool2,cool3,cool4;
    public static Image magic,magic2,magic3,magic4,magic5,magic6,magic7,magic8,magic9,magic10,magic11,magic12,magic13;
    public static Image magic14,magic15,magic16,magic17,magic18,magic19,magic20,magic21;
    public static Image title;
    public static Image oneplayer,twoplayer;
    public static Image createaroom,joinaroom;
    public static Image zero,one,two,three,four,five,six,seven,eight,nine,dot,delete,enter;
    public static Image hostip;
    public static Image waiting,waiting2,waiting3,waiting4,waiting5,waiting6,waiting7,waiting8,waiting9,waiting10,waiting11,waiting12;
    public static Image gameover,youwin,taptoreturn;
    public static Image windowsXP;
    public static void load(SampleGame sampleGame) {
        // TODO Auto-generated method stub
        theme = sampleGame.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }

}