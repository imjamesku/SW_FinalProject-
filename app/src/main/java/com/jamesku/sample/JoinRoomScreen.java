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
                    if (inBounds(event, 0, 320, 120, 120)) {
                        IP.append('1');
                        break;
                    } else if (inBounds(event, 120, 320, 120, 120)) {
                        IP.append('2');
                        break;
                    } else if (inBounds(event, 240, 320, 120, 120)) {
                        IP.append('3');
                        break;
                    } else if (inBounds(event, 0, 440, 120, 120)) {
                        IP.append('4');
                        break;
                    } else if (inBounds(event, 120, 440, 120, 120)) {
                        IP.append('5');
                        break;
                    } else if (inBounds(event, 240, 440, 120, 120)) {
                        IP.append('6');
                        break;
                    } else if (inBounds(event, 0, 560, 120, 120)) {
                        IP.append('7');
                        break;
                    } else if (inBounds(event, 120, 560, 120, 120)) {
                        IP.append('8');
                        break;
                    } else if (inBounds(event, 240, 560, 120, 120)) {
                        IP.append('9');
                        break;
                    } else if (inBounds(event, 0, 680, 120, 120)) {
                        IP.append('.');
                        break;
                    } else if (inBounds(event, 120, 680, 120, 120)) {
                        IP.append('0');
                        break;
                    } else if (inBounds(event, 360, 320, 120, 120)) {
                        if (IP.length() != 0)
                            IP.deleteCharAt(IP.length() - 1);
                        break;
                    } else if (inBounds(event, 360, 440, 120, 360)) {
                        try {
                            socket = new Socket(IP.toString(), 8991);
                            Log.d("INFO", "update: CONNECT TO " + IP.toString());
                            MultiplayerGameScreen screen = new MultiplayerGameScreen(game, socket, MultiplayerGameScreen.ConnectionType.Client);
                            game.setScreen(screen);
                            Log.d("THREAD", "CONNECT THREAD TERMINATED");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
            }
        }


    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255, 0, 0, 0);

        Paint paint,paint1;
        paint = new Paint();
        paint.setTextSize(50);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

        paint1 = new Paint();
        paint1.setTextSize(70);
        paint1.setTextAlign(Paint.Align.CENTER);
        paint1.setAntiAlias(true);
        paint1.setColor(Color.WHITE);
        g.drawString("Enter Host IP:", 240, 100, paint1);

        g.drawString(IP.toString(), 240, 200, paint);

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

    private boolean inBounds(TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    public Socket getSocket() {
        return socket;
    }

}
