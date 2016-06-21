package com.jamesku.sample;

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




        //This is how you would load a sound if you had one.
        //Assets.click = game.getAudio().createSound("explode.ogg");


        game.setScreen(new MainMenuScreen(game));

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.splash, 0, 0);
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