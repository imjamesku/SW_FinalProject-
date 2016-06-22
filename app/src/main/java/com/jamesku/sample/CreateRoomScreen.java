package com.jamesku.sample;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.jamesku.framework.Game;
import com.jamesku.framework.Graphics;
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

    public CreateRoomScreen(Game game) {
        super(game);
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

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        Paint paint = new Paint();
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        g.drawARGB(255, 0, 0, 0);
        g.drawString(NetworkUtilities.getLocalIpAddress(),100,100,paint);
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
