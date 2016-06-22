package com.jamesku.sample;

import com.jamesku.framework.Game;
import com.jamesku.framework.Graphics;
import com.jamesku.framework.Screen;
import com.jamesku.framework.Graphics.ImageFormat;

public class SplashLoadingScreen extends Screen {
    public SplashLoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.splash= g.newImage("splash.jpg", ImageFormat.ARGB4444);

        game.setScreen(new LoadingScreen(game));


    }

    @Override
    public void paint(float deltaTime) {

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