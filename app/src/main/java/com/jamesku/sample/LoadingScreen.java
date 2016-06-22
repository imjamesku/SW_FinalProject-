package com.jamesku.sample;

import android.graphics.Rect;

import com.jamesku.framework.Game;
import com.jamesku.framework.Graphics;
import com.jamesku.framework.Graphics.ImageFormat;
import com.jamesku.framework.Screen;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {

        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
        Assets.background = g.newImage("background.png", ImageFormat.RGB565);
        Assets.character = g.newImage("character.png", ImageFormat.ARGB4444);
        Assets.character2 = g.newImage("character2.png", ImageFormat.ARGB4444);
        Assets.character3  = g.newImage("character3.png", ImageFormat.ARGB4444);
        Assets.characterJump = g.newImage("jumped.png", ImageFormat.ARGB4444);
        Assets.characterDown = g.newImage("down.png", ImageFormat.ARGB4444);


        Assets.heliboy = g.newImage("heliboy.png", ImageFormat.ARGB4444);
        Assets.heliboy2 = g.newImage("heliboy2.png", ImageFormat.ARGB4444);
        Assets.heliboy3  = g.newImage("heliboy3.png", ImageFormat.ARGB4444);
        Assets.heliboy4  = g.newImage("heliboy4.png", ImageFormat.ARGB4444);
        Assets.heliboy5  = g.newImage("heliboy5.png", ImageFormat.ARGB4444);



        Assets.tiledirt = g.newImage("tiledirt.png", ImageFormat.RGB565);
        Assets.tilegrassTop = g.newImage("tilegrasstop.png", ImageFormat.RGB565);
        Assets.tilegrassBot = g.newImage("tilegrassbot.png", ImageFormat.RGB565);
        Assets.tilegrassLeft = g.newImage("tilegrassleft.png", ImageFormat.RGB565);
        Assets.tilegrassRight = g.newImage("tilegrassright.png", ImageFormat.RGB565);

        Assets.button = g.newImage("button.jpg", ImageFormat.RGB565);

        Assets.soccer = g.newImage("soccer.png",ImageFormat.ARGB4444);
        Assets.soccer2 = g.newImage("soccer2.png",ImageFormat.ARGB4444);
        Assets.soccer3 = g.newImage("soccer3.png",ImageFormat.ARGB4444);
        Assets.soccer4 = g.newImage("soccer4.png",ImageFormat.ARGB4444);
        Assets.soccer5 = g.newImage("soccer5.png",ImageFormat.ARGB4444);
        Assets.soccer6 = g.newImage("soccer6.png",ImageFormat.ARGB4444);
        Assets.soccer7 = g.newImage("soccer7.png",ImageFormat.ARGB4444);
        Assets.soccer8 = g.newImage("soccer8.png",ImageFormat.ARGB4444);

        Assets.sand = g.newImage("sand.png",ImageFormat.ARGB4444);
        Assets.sand2 = g.newImage("sand2.png",ImageFormat.ARGB4444);
        Assets.sand3 = g.newImage("sand3.png",ImageFormat.ARGB4444);
        Assets.sand4 = g.newImage("sand4.png",ImageFormat.ARGB4444);
        Assets.sand5 = g.newImage("sand5.png",ImageFormat.ARGB4444);
        Assets.sand6 = g.newImage("sand6.png",ImageFormat.ARGB4444);
        Assets.sand7 = g.newImage("sand7.png",ImageFormat.ARGB4444);
        Assets.sand8 = g.newImage("sand8.png",ImageFormat.ARGB4444);
        Assets.sand9 = g.newImage("sand9.png",ImageFormat.ARGB4444);
        Assets.sand10 = g.newImage("sand10.png",ImageFormat.ARGB4444);
        Assets.sand11 = g.newImage("sand11.png",ImageFormat.ARGB4444);
        Assets.sand12 = g.newImage("sand12.png",ImageFormat.ARGB4444);
        Assets.sand13 = g.newImage("sand13.png",ImageFormat.ARGB4444);
        Assets.sand14 = g.newImage("sand14.png",ImageFormat.ARGB4444);
        Assets.sand15 = g.newImage("sand15.png",ImageFormat.ARGB4444);

        Assets.cool = g.newImage("cool.png",ImageFormat.ARGB4444);
        Assets.cool2 = g.newImage("cool2.png",ImageFormat.ARGB4444);
        Assets.cool3 = g.newImage("cool3.png",ImageFormat.ARGB4444);
        Assets.cool4 = g.newImage("cool4.png",ImageFormat.ARGB4444);

        Assets.magic = g.newImage("magic.png",ImageFormat.ARGB4444);
        Assets.magic2 = g.newImage("magic2.png",ImageFormat.ARGB4444);
        Assets.magic3 = g.newImage("magic3.png",ImageFormat.ARGB4444);
        Assets.magic4 = g.newImage("magic4.png",ImageFormat.ARGB4444);
        Assets.magic5 = g.newImage("magic5.png",ImageFormat.ARGB4444);
        Assets.magic6 = g.newImage("magic6.png",ImageFormat.ARGB4444);
        Assets.magic7 = g.newImage("magic7.png",ImageFormat.ARGB4444);
        Assets.magic8 = g.newImage("magic8.png",ImageFormat.ARGB4444);
        Assets.magic9 = g.newImage("magic9.png",ImageFormat.ARGB4444);
        Assets.magic10 = g.newImage("magic10.png",ImageFormat.ARGB4444);
        Assets.magic11 = g.newImage("magic11.png",ImageFormat.ARGB4444);
        Assets.magic12 = g.newImage("magic12.png",ImageFormat.ARGB4444);
        Assets.magic13 = g.newImage("magic13.png",ImageFormat.ARGB4444);
        Assets.magic14 = g.newImage("magic14.png",ImageFormat.ARGB4444);
        Assets.magic15 = g.newImage("magic15.png",ImageFormat.ARGB4444);
        Assets.magic16 = g.newImage("magic16.png",ImageFormat.ARGB4444);
        Assets.magic17 = g.newImage("magic17.png",ImageFormat.ARGB4444);
        Assets.magic18 = g.newImage("magic18.png",ImageFormat.ARGB4444);
        Assets.magic19 = g.newImage("magic19.png",ImageFormat.ARGB4444);
        Assets.magic20 = g.newImage("magic20.png",ImageFormat.ARGB4444);
        Assets.magic21 = g.newImage("magic21.png",ImageFormat.ARGB4444);

        Assets.title = g.newImage("Title_new.png",ImageFormat.ARGB4444);
        Assets.oneplayer = g.newImage("oneplayer.png",ImageFormat.ARGB4444);
        Assets.twoplayer = g.newImage("twoplayer.png",ImageFormat.ARGB4444);
        Assets.createaroom = g.newImage("createaroom.png",ImageFormat.ARGB4444);
        Assets.joinaroom = g.newImage("joinaroom.png",ImageFormat.ARGB4444);

        Assets.zero = g.newImage("zero.png",ImageFormat.ARGB4444);
        Assets.one = g.newImage("one.png",ImageFormat.ARGB4444);
        Assets.two = g.newImage("two.png",ImageFormat.ARGB4444);
        Assets.three = g.newImage("three.png",ImageFormat.ARGB4444);
        Assets.four = g.newImage("four.png",ImageFormat.ARGB4444);
        Assets.five = g.newImage("five.png",ImageFormat.ARGB4444);
        Assets.six = g.newImage("six.png",ImageFormat.ARGB4444);
        Assets.seven = g.newImage("seven.png",ImageFormat.ARGB4444);
        Assets.eight = g.newImage("eight.png",ImageFormat.ARGB4444);
        Assets.nine = g.newImage("nine.png",ImageFormat.ARGB4444);
        Assets.dot = g.newImage("dot.png",ImageFormat.ARGB4444);
        Assets.delete = g.newImage("delete.png",ImageFormat.ARGB4444);
        Assets.enter = g.newImage("enter.png",ImageFormat.ARGB4444);
        Assets.hostip = g.newImage("hostip.png",ImageFormat.ARGB4444);

        Assets.waiting = g.newImage("waiting.png",ImageFormat.ARGB4444);
        Assets.waiting2 = g.newImage("waiting2.png",ImageFormat.ARGB4444);
        Assets.waiting3 = g.newImage("waiting3.png",ImageFormat.ARGB4444);
        Assets.waiting4 = g.newImage("waiting4.png",ImageFormat.ARGB4444);
        Assets.waiting5 = g.newImage("waiting5.png",ImageFormat.ARGB4444);
        Assets.waiting6 = g.newImage("waiting6.png",ImageFormat.ARGB4444);
        Assets.waiting7 = g.newImage("waiting7.png",ImageFormat.ARGB4444);
        Assets.waiting8 = g.newImage("waiting8.png",ImageFormat.ARGB4444);
        Assets.waiting9 = g.newImage("waiting9.png",ImageFormat.ARGB4444);
        Assets.waiting10 = g.newImage("waiting10.png",ImageFormat.ARGB4444);
        Assets.waiting11 = g.newImage("waiting11.png",ImageFormat.ARGB4444);
        Assets.waiting12 = g.newImage("waiting12.png",ImageFormat.ARGB4444);

        Assets.gameover = g.newImage("gameover.png",ImageFormat.ARGB4444);
        Assets.taptoreturn = g.newImage("taptoreturn.png", ImageFormat.ARGB4444);
        Assets.youwin = g.newImage("youwin.png",ImageFormat.ARGB4444);
        Assets.windowsXP = g.newImage("windowsXP.jpg", ImageFormat.ARGB4444);





        //This is how you would load a sound if you had one.
        //Assets.click = game.getAudio().createSound("explode.ogg");


        game.setScreen(new MainMenuScreen(game));

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255, 255, 255, 255);
        Rect dstRect = new Rect();
        dstRect.set(0, 0, 480, 800);
        g.drawImage(Assets.splash, 0, 0, 0, 0, 480, 800, dstRect);



    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }
}