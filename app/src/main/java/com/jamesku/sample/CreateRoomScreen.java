package com.jamesku.sample;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.jamesku.framework.Game;
import com.jamesku.framework.Graphics;
import com.jamesku.framework.Image;
import com.jamesku.framework.Screen;
import com.jamesku.framework.implementation.AndroidGame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by NTHUCS on 2016/6/21.
 */
public class CreateRoomScreen extends Screen {

    private ServerSocket serverSocket;
    private Socket socket;
    private Image waiting,waiting2,waiting3,waiting4,waiting5,waiting6,waiting7,waiting8,waiting9,waiting10,waiting11,waiting12;
    private Animation waitinganim;

    public CreateRoomScreen(Game game) {
        super(game);
        waiting = Assets.waiting;
        waiting2 = Assets.waiting2;
        waiting3 = Assets.waiting3;
        waiting4 = Assets.waiting4;
        waiting5 = Assets.waiting5;
        waiting6 = Assets.waiting6;
        waiting7 = Assets.waiting7;
        waiting8 = Assets.waiting8;
        waiting9 = Assets.waiting9;
        waiting10 = Assets.waiting10;
        waiting11 = Assets.waiting11;
        waiting12 = Assets.waiting12;

        waitinganim = new Animation();
        waitinganim.addFrame(waiting,100);
        waitinganim.addFrame(waiting2,100);
        waitinganim.addFrame(waiting3,100);
        waitinganim.addFrame(waiting4,100);
        waitinganim.addFrame(waiting5,100);
        waitinganim.addFrame(waiting6,100);
        waitinganim.addFrame(waiting7,100);
        waitinganim.addFrame(waiting8,100);
        waitinganim.addFrame(waiting9,100);
        waitinganim.addFrame(waiting10,100);
        waitinganim.addFrame(waiting11,100);
        waitinganim.addFrame(waiting12,100);


        new Thread(new Runnable() {
            @Override
            public void run() {
                acceptConnection();
            }
        }).start();
    }

    private void acceptConnection() {
        try {
            serverSocket = new ServerSocket(8991);
            socket = serverSocket.accept();
            Log.d("INFO", "acceptConnection: NEW CONNECTION ESTABLISHED FROM " + socket.getInetAddress().getHostAddress());
            serverSocket.close();
            MultiplayerGameScreen screen = new MultiplayerGameScreen(game, socket, MultiplayerGameScreen.ConnectionType.Server);
            game.setScreen(screen);
            System.gc();
            Log.d("THREAD", "ACCEPT THREAD TERMINATED");
        } catch (IOException e) {
            Log.e("SERVER INITIALIZE", "CreateRoomScreen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(float deltaTime) {
        waitinganim.updatewaiting(50);
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        g.drawARGB(255, 255, 255, 255);
        g.drawString(NetworkUtilities.getLocalIpAddress(), 240, 300, paint);

        Rect dstRect = new Rect();
        dstRect.set(0, 0, 480, 200);
        g.drawImage(Assets.hostip, 0, 0, 0, 0, 480, 800, dstRect);

        g.drawImage(waitinganim.getImage(),150,400);


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
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }







        game.setScreen(new TwoPlayerScreen(game));
        System.gc();
    }

    public Socket getSocket() {
        return socket;
    }

}
