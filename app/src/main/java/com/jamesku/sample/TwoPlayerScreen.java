package com.jamesku.sample;

import android.graphics.Rect;
import android.util.Log;

import com.jamesku.framework.Game;
import com.jamesku.framework.Graphics;
import com.jamesku.framework.Input;
import com.jamesku.framework.Screen;
import com.jamesku.framework.Input.TouchEvent;

import java.util.List;

/**
 * Created by NTHUCS on 2016/6/22.
 */
public class TwoPlayerScreen extends Screen{

    public TwoPlayerScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        List touchevents = game.getInput().getTouchEvents();
        for(Object o: touchevents) {
            TouchEvent event = (TouchEvent)o;

            if(event.type == TouchEvent.TOUCH_DOWN) {


                if (inBounds(event, 40, 300, 400, 170)) {

                    CreateRoomScreen createRoomScreen = new CreateRoomScreen(game);
                    game.setScreen(createRoomScreen);

                }
                else if (inBounds(event, 40, 500, 400, 200)) {

                    JoinRoomScreen joinRoomScreen = new JoinRoomScreen(game);
                    game.setScreen(joinRoomScreen);

                }


            }


        }



    }


    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255, 127, 127, 127);
        Rect dstRect = new Rect();
        dstRect.set(40, 300, 440, 470);
        g.drawImage(Assets.createaroom,40,300,0,0,480,800,dstRect);
        dstRect.set(40, 500, 440, 700);
        g.drawImage(Assets.joinaroom,40,500,0,0,480,800,dstRect);
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
        game.setScreen(new MainMenuScreen(game));
        System.gc();
    }

    private boolean inBounds(TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }

}
