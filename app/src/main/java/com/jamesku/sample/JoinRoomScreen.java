package com.jamesku.sample;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.jamesku.framework.Game;
import com.jamesku.framework.Graphics;
import com.jamesku.framework.Input;
import com.jamesku.framework.Input.TouchEvent;
import com.jamesku.framework.Screen;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Objects;

/**
 * Created by NTHUCS on 2016/6/21.
 */
public class JoinRoomScreen extends Screen{

    private Socket socket;

    private static StringBuffer IP;
    boolean isTouched = false;

    public JoinRoomScreen(Game game) {
        super(game);
        IP = new StringBuffer();
    }

    @Override
    public void update(float deltaTime) {

       List touchevents = game.getInput().getTouchEvents();
        for(Object o: touchevents) {
            TouchEvent event = (TouchEvent)o;

            if(event.type == TouchEvent.TOUCH_DOWN) {
                    if (inCircle(event, 80, 400, 40)) {
                        IP.append('1');
                        break;
                    } else if (inCircle(event, 160, 400, 40)) {
                        IP.append('2');
                        break;
                    } else if (inCircle(event, 240, 400, 40)) {
                        IP.append('3');
                        break;
                    } else if (inCircle(event, 80, 500, 40)) {
                        IP.append('4');
                        break;
                    } else if (inCircle(event, 160, 500, 40)) {
                        IP.append('5');
                        break;
                    } else if (inCircle(event, 240, 500, 40)) {
                        IP.append('6');
                        break;
                    } else if (inCircle(event, 80, 600, 40)) {
                        IP.append('7');
                        break;
                    } else if (inCircle(event, 160, 600, 40)) {
                        IP.append('8');
                        break;
                    } else if (inCircle(event, 240, 600, 40)) {
                        IP.append('9');
                        break;
                    } else if (inCircle(event, 80, 700, 40)) {
                        IP.append('.');
                        break;
                    } else if (inCircle(event, 160, 700, 40)) {
                        IP.append('0');
                        break;
                    } else if (inCircle(event, 240, 700, 40)) {
                        if (IP.length() != 0)
                            IP.deleteCharAt(IP.length() - 1);
                    } else if (inCircle(event, 400, 700, 40)) {
                        try {
                            socket = new Socket(IP.toString(), 8991);
                            Log.d("INFO", "update: CONNECT TO " + IP.toString());
                            MultiplayerGameScreen screen = new MultiplayerGameScreen(game, socket, MultiplayerGameScreen.ConnectionType.Client);
                            game.setScreen(screen);
                            Log.d("THREAD", "CONNECT THREAD TERMINATED");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }


    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255, 0, 0, 0);

        Paint paint;
        paint = new Paint();
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        g.drawString(IP.toString(), 100, 50, paint);

        //g.drawARGB(255, 127, 127, 127);
        Rect dstRect = new Rect();
        dstRect.set(0, 320, 120, 440);
        g.drawImage(Assets.one, 0, 320, 0, 0, 480, 800, dstRect);
        dstRect.set(120, 320, 240, 440);
        g.drawImage(Assets.two, 120, 320, 0, 0, 480, 800, dstRect);
        dstRect.set(240, 320, 360, 440);
        g.drawImage(Assets.three, 240, 320, 0, 0, 480, 800, dstRect);
        dstRect.set(360, 320, 480, 440);
        g.drawImage(Assets.delete, 360, 320, 0, 0, 480, 800, dstRect);

        dstRect.set(0, 440, 120, 560);
        g.drawImage(Assets.four, 0, 440, 0, 0, 480, 800, dstRect);
        dstRect.set(120, 440, 240, 560);
        g.drawImage(Assets.five, 120, 440, 0, 0, 480, 800, dstRect);
        dstRect.set(240, 440, 360, 560);
        g.drawImage(Assets.six, 240, 440, 0, 0, 480, 800, dstRect);

        dstRect.set(0, 560, 120, 680);
        g.drawImage(Assets.seven, 0, 560, 0, 0, 480, 800, dstRect);
        dstRect.set(120, 560, 240, 680);
        g.drawImage(Assets.eight, 120, 560, 0, 0, 480, 800, dstRect);
        dstRect.set(240, 560, 360, 680);
        g.drawImage(Assets.nine, 240, 560, 0, 0, 480, 800, dstRect);

        dstRect.set(0, 680, 120, 800);
        g.drawImage(Assets.dot, 0, 680, 0, 0, 480, 800, dstRect);
        dstRect.set(120, 680, 240, 800);
        g.drawImage(Assets.zero, 120, 680, 0, 0, 480, 800, dstRect);


        dstRect.set(360, 440, 480, 800);
        g.drawImage(Assets.enter, 360, 440, 0, 0, 480, 800, dstRect);





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
        game.setScreen(new TwoPlayerScreen(game));
        System.gc();
    }

    private boolean inCircle(TouchEvent event, int x, int y, int radius){
        int distance2 = (event.x - x) * (event.x - x) + (event.y - y) * (event.y - y);
        if(distance2 < radius*radius)
            return true;
        return false;
    }

    public Socket getSocket() {
        return socket;
    }

}
