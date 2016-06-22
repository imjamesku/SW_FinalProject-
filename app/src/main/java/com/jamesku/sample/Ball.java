package com.jamesku.sample;

import com.jamesku.framework.Graphics;

/**
 * Created by user on 2016/6/20.
 */
public class Ball extends GameObject {
    private int radius;
    private int color;
    private int dropFreq;
    private int kind;
    private Animation animation;
    private long elapsedTime;
    private boolean visible;
    private int holdTime;
    private long lastTouchTime;



    final private int BOTTOM_BOARDER = 800;
    final private int RIGHT_BOARDER = 480;

    public Ball(int x, int y){
        setCenterX(x);
        setCenterY(y);
        setSpeedX(0);
        setSpeedY(0);
        setVisible(true);
        setDropFreq(0);
        setKind(0);
        setAnimation(null);
        setElapsedTime(50);
        setHoldTime(0);
        setLastTouchTime(0);
    }

    public void update(){
        long notBeenTouchedTime = MultiplayerGameScreen.getPsudoTime() - getLastTouchTime();
        if(getCenterY() + getSpeedY() - getRadius() >= BOTTOM_BOARDER) {
            setVisible(false);
            return;
        }

        if(getCenterX() + getSpeedX() + getRadius() >= RIGHT_BOARDER){
            bounce();
            setCenterX(RIGHT_BOARDER - getRadius());
        }
        else if(getCenterX() + getSpeedX() - getRadius() <= 0){
            bounce();
            setCenterX(getRadius());
        }

            if(getHoldTime() == 0 || notBeenTouchedTime >= 40) {
                System.out.println("holdTime = " + holdTime);
                System.out.println("notBeenToucgedTime = " + notBeenTouchedTime);
                setCenterX(getCenterX() + getSpeedX());
                setCenterY(getCenterY() + getSpeedY());
                setHoldTime(0);
            }
            else if(getHoldTime() > 0){
                setHoldTime(getHoldTime() + 1);
            }




        animation.update(getElapsedTime(),getKind(),this);

    }

    private void bounce(){
        setSpeedX((int) (-getSpeedX() * 0.7));
    }

    public void touchedBounce(){

        if(getSpeedY()>0) {
            int randSpeedX = (int) (Math.random()*5);
            //setSpeedX((int) (-getSpeedX() * 0.7));
            setSpeedX((int) (-getSpeedX() + randSpeedX));
            setSpeedY((int) (-getSpeedY() * 4));
        }
    }

    public void draw(Graphics g){
        if(isVisible()) {
            //g.drawCircle(getCenterX(), getCenterY(), getRadius(), getColor());
            g.drawImage(animation.getImage(), getCenterX()-getRadius(), getCenterY()-getRadius());
        }
    }

    public int getRadius() {
        return radius;
    }

    public int getDropFreq(){return  dropFreq;}

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setColor(int color) {
        this.color = color;

    }

    public void setDropFreq(int dropFreq){
        this.dropFreq = dropFreq;
    }
    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }


    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
    public Animation getAnimation() {
        return animation;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(int holdTime) {
        this.holdTime = holdTime;
    }

    public long getLastTouchTime() {
        return lastTouchTime;
    }

    public void setLastTouchTime(long lastTouchTime) {
        this.lastTouchTime = lastTouchTime;
    }
}
