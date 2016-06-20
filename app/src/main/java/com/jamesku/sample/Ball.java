package com.jamesku.sample;

import com.jamesku.framework.Graphics;

/**
 * Created by user on 2016/6/20.
 */
public class Ball extends GameObject {
    private int radius;
    private int color;
    private boolean visible;
    final private int BOTTOM_BOARD = 480;

    public Ball(int x, int y, int radius, int color){
        setCenterX(x);
        setCenterY(y);
        setRadius(radius);
        setColor(color);
        setSpeedX(0);
        setSpeedY(0);
    }

    public void update(){
        if(getCenterY() + getSpeedY() - radius >= BOTTOM_BOARD) {
            setVisible(false);
            return;
        }
        
    }

    public void draw(Graphics g){
        g.drawCircle(getCenterX(), getCenterY(), getRadius(), getColor());
    }

    public int getRadius() {
        return radius;
    }

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
}
