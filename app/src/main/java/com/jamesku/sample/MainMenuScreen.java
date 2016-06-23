package com.jamesku.sample;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;

import java.util.List;


import com.jamesku.framework.Game;
import com.jamesku.framework.Graphics;
import com.jamesku.framework.Screen;
import com.jamesku.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
        Assets.theme.seekBegin();
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {

                if (inBounds(event, 40, 400, 400, 170)) {
                    game.setScreen(new GameScreen(game));
                }
                if (inBounds(event, 40, 600, 400, 200)) {
                    game.setScreen(new TwoPlayerScreen(game));
                }

            }
        }
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width,
                               int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255, 255, 255, 255);
        Rect dstRect = new Rect();
        dstRect.set(0, 0, 480, 400);
        g.drawImage(Assets.title, 0, 20, 0, 0, 480, 800, dstRect);
        dstRect.set(40, 400, 440, 570);
        g.drawImage(Assets.oneplayer, 40, 400, 0, 0, 480, 800, dstRect);
        dstRect.set(40, 600, 440, 800);
        g.drawImage(Assets.twoplayer, 40, 600, 0, 0, 480, 800, dstRect);



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
        android.os.Process.killProcess(android.os.Process.myPid());

    }
}