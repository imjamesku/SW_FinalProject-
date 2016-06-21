package com.jamesku.sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.Toast;

import com.jamesku.framework.Game;
import com.jamesku.framework.Graphics;
import com.jamesku.framework.Image;
import com.jamesku.framework.Input.TouchEvent;
import com.jamesku.framework.Screen;
import com.jamesku.framework.implementation.AndroidGame;

public class MultiplayerGameScreen extends Screen {
    enum GameState {
        Ready, Running, Paused, GameOver
    }

    private final Object lock = new Object();

    GameState state = GameState.Ready;

    // Variable Setup

    private static Background bg1, bg2;
    //private static Robot robot;
    //public static Heliboy hb, hb2;
    public static Vector<Ball> balls = new Vector<>();

    //   private Image currentSprite, character, character2, character3, heliboy,
    //           heliboy2, heliboy3, heliboy4, heliboy5;
    //   private Animation anim, hanim;

    private Image soccer,soccer2,soccer3,soccer4,soccer5,soccer6,soccer7,soccer8;
    private Animation socceranim;

    private Image sand,sand2,sand3,sand4,sand5,sand6,sand7,sand8,sand9,sand10,sand11,sand12,sand13,sand14,sand15;
    private Animation sandanim;

    private ArrayList tilearray = new ArrayList();

    int livesLeft = 1;
    Paint paint, paint2;

    private int gravity;
    private int addBallFreq;
    private int addBallCounter;
    private int score;
    private int HP;

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    ServerSocket serverSocket;
    Socket client;

    public MultiplayerGameScreen(Game game, Socket socket) {
        super(game);

        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        gravity = 1;
        addBallFreq = 5;
        addBallCounter = 0;
        score = 0;
        HP = 100;

        // Initialize game objects here

        bg1 = new Background(0, 0);
        bg2 = new Background(2160, 0);
    /*
        robot = new Robot();
        hb = new Heliboy(340, 360);
        hb2 = new Heliboy(700, 360);



        character = Assets.character;
        character2 = Assets.character2;
        character3 = Assets.character3;

        heliboy = Assets.heliboy;
        heliboy2 = Assets.heliboy2;
        heliboy3 = Assets.heliboy3;
        heliboy4 = Assets.heliboy4;
        heliboy5 = Assets.heliboy5;

        anim = new Animation();
        anim.addFrame(character, 1250);
        anim.addFrame(character2, 50);
        anim.addFrame(character3, 50);
        anim.addFrame(character2, 50);

        hanim = new Animation();
        hanim.addFrame(heliboy, 100);
        hanim.addFrame(heliboy2, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy4, 100);
        hanim.addFrame(heliboy5, 100);
        hanim.addFrame(heliboy4, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy2, 100);
    */

        soccer = Assets.soccer;
        soccer2 = Assets.soccer2;
        soccer3 = Assets.soccer3;
        soccer4 = Assets.soccer4;
        soccer5 = Assets.soccer5;
        soccer6 = Assets.soccer6;
        soccer7 = Assets.soccer7;
        soccer8 = Assets.soccer8;

        socceranim = new Animation();
        socceranim.addFrame(soccer,100);
        socceranim.addFrame(soccer2,100);
        socceranim.addFrame(soccer3,100);
        socceranim.addFrame(soccer4,100);
        socceranim.addFrame(soccer5,100);
        socceranim.addFrame(soccer6,100);
        socceranim.addFrame(soccer7,100);
        socceranim.addFrame(soccer8,100);

        sand = Assets.sand;
        sand2 = Assets.sand2;
        sand3 = Assets.sand3;
        sand4 = Assets.sand4;
        sand5 = Assets.sand5;
        sand6 = Assets.sand6;
        sand7 = Assets.sand7;
        sand8 = Assets.sand8;
        sand9 = Assets.sand9;
        sand10 = Assets.sand10;
        sand11 = Assets.sand11;
        sand12 = Assets.sand12;
        sand13 = Assets.sand13;
        sand14 = Assets.sand14;
        sand15 = Assets.sand15;

        sandanim = new Animation();
        sandanim.addFrame(sand,50);
        sandanim.addFrame(sand2,50);
        sandanim.addFrame(sand3,50);
        sandanim.addFrame(sand4,50);
        sandanim.addFrame(sand5,50);
        sandanim.addFrame(sand6,50);
        sandanim.addFrame(sand7,50);
        sandanim.addFrame(sand8,50);
        sandanim.addFrame(sand9,50);
        sandanim.addFrame(sand10,50);
        sandanim.addFrame(sand11,50);
        sandanim.addFrame(sand12,50);
        sandanim.addFrame(sand13,50);
        sandanim.addFrame(sand14,50);
        sandanim.addFrame(sand15, 50);


        //  currentSprite = anim.getImage();

        loadMap();

        // Defining a paint object
        paint = new Paint();
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

        paint2 = new Paint();
        paint2.setTextSize(100);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.WHITE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                readMessage();
            }
        }).start();

    }

    private void readMessage() {
        while (!socket.isClosed()) {
            String line = null;
            try {
                line = reader.readLine();
                Log.d("READ", "readMessage: " + line);
                addBallMultiPlayer(line);
                // TODO deal with message you received
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private void writeMessage(String message) {
        writer.println(message);
        writer.flush();
    }

    private void loadMap() {
        ArrayList lines = new ArrayList();
        int width = 0;
        int height = 0;

        Scanner scanner = new Scanner(SampleGame.map);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // no more lines to read
            if (line == null) {
                break;
            }

            if (!line.startsWith("!")) {
                lines.add(line);
                width = Math.max(width, line.length());

            }
        }
        height = lines.size();

        for (int j = 0; j < 12; j++) {
            String line = (String) lines.get(j);
            for (int i = 0; i < width; i++) {

                if (i < line.length()) {
                    char ch = line.charAt(i);
                    Tile t = new Tile(i, j, Character.getNumericValue(ch));
                    tilearray.add(t);
                }

            }
        }

    }

    @Override
    public void update(float deltaTime) {
        List touchEvents = game.getInput().getTouchEvents();

        // We have four separate update methods in this example.
        // Depending on the state of the game, we call different update methods.
        // Refer to Unit 3's code. We did a similar thing without separating the
        // update methods.

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
        if (state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List touchEvents) {

        // This example starts with a "Ready" screen.
        // When the user touches the screen, the game begins.
        // state now becomes GameState.Running.
        // Now the updateRunning() method will be called!

        if (touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List touchEvents, float deltaTime) {

        // This is identical to the update() method from our Unit 2/3 game.

        // 1. All touch input is handled here:
  /*
        int len = touchEvents.size();
        //System.out.println("111 " + len);
        for (int i = 0; i < len; i++) {
            TouchEvent event = (TouchEvent) touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN) {

                if (inBounds(event, 0, 285, 65, 65)) {
                    robot.jump();
                    currentSprite = anim.getImage();
                    robot.setDucked(false);
                }

                else if (inBounds(event, 0, 350, 65, 65)) {

                    if (robot.isDucked() == false && robot.isJumped() == false
                            && robot.isReadyToFire()) {
                        robot.shoot();
                    }
                }

                else if (inBounds(event, 0, 415, 65, 65)
                        && robot.isJumped() == false) {
                    currentSprite = Assets.characterDown;
                    robot.setDucked(true);
                    robot.setSpeedX(0);

                }

                if (event.x > 400) {
                    // Move right.
                    robot.moveRight();
                    robot.setMovingRight(true);

                }

            }

            if (event.type == TouchEvent.TOUCH_UP) {

                if (inBounds(event, 0, 415, 65, 65)) {
                    currentSprite = anim.getImage();
                    robot.setDucked(false);

                }

                if (inBounds(event, 0, 0, 35, 35)) {
                    pause();

                }

                if (event.x > 400) {
                    // Move right.
                    robot.stopRight();
                }
            }

        }
        */
        //  System.out.println("222 " + touchEvents.size());


        // 2. Check miscellaneous events like death:

        /*
        if (livesLeft == 0) {
            state = GameState.GameOver;
        }
*/
        // 3. Call individual update() methods here.
        // This is where all the game updates happen.
        // For example, robot.update();

     /*
        robot.update();
        if (robot.isJumped()) {
            currentSprite = Assets.characterJump;
        } else if (robot.isJumped() == false && robot.isDucked() == false) {
            currentSprite = anim.getImage();
        }

        ArrayList projectiles = robot.getProjectiles();
        for (int i = 0; i < projectiles.size(); i++) {
            Projectile p = (Projectile) projectiles.get(i);
            if (p.isVisible() == true) {
                p.update();
            } else {
                projectiles.remove(i);
            }
        }
      */

        removeTouchedBalls(touchEvents);

        /*
        if(addBallCounter >= addBallFreq) {
            addBalls(1);
            addBallCounter = 0;
        }
        else
            addBallCounter++;
        */
        /*
        if(addBallCounter  == 0){
            addBalls(1);
            addBallCounter++;
        }
        */

        if(balls.size() == 0)
            addBalls(1);
        else if(balls.size()<10 && (score/50 > balls.size()-1) ){
            addBalls(1);
        }

        updateBalls();

//        updateTiles();
        //    hb.update();
        //    hb2.update();
        bg1.update();
        bg2.update();
        animate();

       /*
        if (robot.getCenterY() > 500) {
            state = GameState.GameOver;
        }
       */

        if(HP <= 0){
            state = GameState.GameOver;
        }

    }

    private void addBalls(int numberOfBallsAdded) {
        for (int i = 0; i < numberOfBallsAdded; i++) {
            int randX = (int) (Math.random() * 800);
            int randSpeedX = (int) (Math.random() * 20);
            int randkind = (int) (Math.random() * 2);


            Ball newBall = new Ball(randX, 0);

            if (randkind == 0) {
                newBall.setRadius(47);
                newBall.setAnimation(sandanim);
            } else if (randkind == 1) {
                newBall.setRadius(18);
                newBall.setAnimation(socceranim);
            }


            newBall.setSpeedX(randSpeedX - 10);
            newBall.setSpeedY(0);
            newBall.setKind(randkind);
            synchronized (lock) {
                balls.add(newBall);
            }
        }
    }

    private String ballToString(Ball b){
        StringBuffer rt = new StringBuffer();
        rt.append(b.getKind());
        rt.append('_');
        rt.append(b.getCenterX());
        rt.append('_');
        rt.append(b.getSpeedX()*(-1));
        rt.append('_');
        rt.append(b.getSpeedY()*(-1));
        rt.append('_');
        rt.append(b.getRadius());

        return  rt.toString();
    }

    private void addBallMultiPlayer(String in){
        String[] token;
        token = in.split("_");
        Ball b = new Ball(Integer.parseInt(token[1]),0);
        b.setSpeedX(Integer.parseInt(token[2]));
        b.setSpeedY(Integer.parseInt(token[3]));
        b.setKind(Integer.parseInt(token[0]));
        b.setRadius(Integer.parseInt(token[4]));

        if (b.getKind() == 0) {
            b.setAnimation(sandanim);
        } else if (b.getKind() == 1) {
            b.setAnimation(socceranim);
        }

        synchronized (lock) {
            balls.add(b);
        }
    }



    private void updateBalls(){
        synchronized (lock) {
            int len = balls.size();

            for (int i = len - 1; i >= 0; i--) {
                Ball ball = balls.get(i);
                if (!ball.isVisible()) {
                    balls.remove(i);
                    HP--;
                } else {
                    if (ball.getSpeedY() + gravity < 10)
                        ball.setSpeedY(ball.getSpeedY() + gravity);
                    else
                        ball.setSpeedY(10);

                    //ball.update();

                    ball.update();
                }
                if(ball.getCenterY()+ball.getRadius() < 0){
                    writeMessage(ballToString(ball));
                    balls.remove(i);
                }
            }
        }
    }

    private void removeTouchedBalls(List touchEvents){
        //  System.out.println(touchEvents.size());
        for (Object o: touchEvents) {
            TouchEvent event = (TouchEvent)o;
            int len = balls.size();
            for(int i = len-1; i>=0; i--){
                Ball b = balls.get(i);
                if(inCircle(event, b.getCenterX(), b.getCenterY(), b.getRadius()+5)){
                    //balls.remove(i);
                    score += 5;
                    b.touchedBounce();
                    break;
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
    private boolean inCircle(TouchEvent event, int x, int y, int radius){
        int distance2 = (event.x - x) * (event.x - x) + (event.y - y) * (event.y - y);
        if(distance2 < radius*radius)
            return true;
        return false;
    }

    private void updatePaused(List touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = (TouchEvent) touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, 0, 0, 800, 240)) {

                    if (!inBounds(event, 0, 0, 35, 35)) {
                        resume();
                    }
                }

                if (inBounds(event, 0, 240, 800, 240)) {
                    nullify();
                    goToMenu();
                }
            }
        }
    }

    private void updateGameOver(List touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = (TouchEvent) touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN) {
                if (inBounds(event, 0, 0, 800, 480)) {
                    nullify();
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }

    }

    private void updateTiles() {

        for (int i = 0; i < tilearray.size(); i++) {
            Tile t = (Tile) tilearray.get(i);
            t.update();
        }

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawRect(0, 0, 490, 810, Color.BLACK);
        g.drawImage(Assets.background, bg1.getBgX(), bg1.getBgY());
        g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());
        paintTiles(g);

    /*
        ArrayList projectiles = robot.getProjectiles();
        for (int i = 0; i < projectiles.size(); i++) {
            Projectile p = (Projectile) projectiles.get(i);
            //g.drawRect(p.getX(), p.getY(), 10, 5, Color.YELLOW);
            g.drawCircle(p.getX(), p.getY(), 30, Color.WHITE);
        }
    */synchronized (lock) {
            for (Ball b : balls) {
                b.draw(g);
                //g.drawImage(socceranim.getImage(), b.getCenterX(), b.getCenterY());
            }
        }
        // First draw the game elements.
     /*
        g.drawImage(currentSprite, robot.getCenterX() - 61,
                robot.getCenterY() - 63);
     */
      /*
        g.drawImage(hanim.getImage(), hb.getCenterX() - 48,
                hb.getCenterY() - 48);
        g.drawImage(hanim.getImage(), hb2.getCenterX() - 48,
                hb2.getCenterY() - 48);
       */
        // Example:
        // g.drawImage(Assets.background, 0, 0);
        // g.drawImage(Assets.character, characterX, characterY);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();

        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void paintTiles(Graphics g) {
        for (int i = 0; i < tilearray.size(); i++) {
            Tile t = (Tile) tilearray.get(i);
            if (t.type != 0) {
                g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY());
            }
        }
    }

    public void animate() {
        // anim.update(10);
        // hanim.update(50);
        socceranim.update(50);
        sandanim.update(25);
    }

    private void nullify() {

        // Set all variables to null. You will be recreating them in the
        // constructor.
        paint = null;
        bg1 = null;
        bg2 = null;
      /*
        robot = null;
        hb = null;
        hb2 = null;
        currentSprite = null;
        character = null;
        character2 = null;
        character3 = null;
        heliboy = null;
        heliboy2 = null;
        heliboy3 = null;
        heliboy4 = null;
        heliboy5 = null;
        anim = null;
        hanim = null;
    */
        sandanim = null;
        socceranim = null;
        sand = null;
        sand2 = null;
        sand3 = null;
        sand4 = null;
        sand5 = null;
        sand6 = null;
        sand7 = null;
        sand8 = null;
        sand9 = null;
        sand10 = null;
        sand11 = null;
        sand12 = null;
        sand13 = null;
        sand14 = null;
        sand15 = null;
        soccer = null;
        soccer2 = null;
        soccer3 = null;
        soccer4 = null;
        soccer5 = null;
        soccer6 = null;
        soccer7 = null;
        soccer8 = null;

        for (Ball a : balls) {
            a = null;
        }
        ;
        // Call garbage collector to clean up memory.
        System.gc();

    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 0, 0, 0);
        g.drawString("Tap to Start.", 400, 240, paint);

    }

    private void drawScoreHP() {
        Graphics g = game.getGraphics();

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(25);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        g.drawString("Score: " + score, 350, 80, paint);
        g.drawString("HP: " + HP, 150, 80, paint);

    }

    private void drawRunningUI() {
        Graphics g = game.getGraphics();

        /*
        g.drawImage(Assets.button, 0, 285, 0, 0, 65, 65);
        g.drawImage(Assets.button, 0, 350, 0, 65, 65, 65);
        g.drawImage(Assets.button, 0, 415, 0, 130, 65, 65);
        g.drawImage(Assets.button, 0, 0, 0, 195, 35, 35);
        */
        drawScoreHP();

    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        // Darken the entire screen so you can display the Paused screen.
        g.drawARGB(155, 0, 0, 0);
        g.drawString("Resume", 400, 165, paint2);
        g.drawString("Menu", 400, 360, paint2);

    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        g.drawRect(0, 0, 1281, 801, Color.BLACK);
        g.drawString("GAME OVER.", 400, 240, paint2);
        g.drawString("Tap to return.", 400, 290, paint);

    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {
        if (state == GameState.Paused)
            state = GameState.Running;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        pause();
    }

    private void goToMenu() {
        // TODO Auto-generated method stub
        game.setScreen(new MainMenuScreen(game));

    }

    public static Background getBg1() {
        // TODO Auto-generated method stub
        return bg1;
    }

    public static Background getBg2() {
        // TODO Auto-generated method stub
        return bg2;
    }

   /*
    public static Robot getRobot() {
        // TODO Auto-generated method stub
        return robot;
    }
    */

}
