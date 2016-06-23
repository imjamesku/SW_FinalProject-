package com.jamesku.sample;

import java.util.ArrayList;

import com.jamesku.framework.Image;


public class Animation {

    private ArrayList frames;
    private int currentFrame;
    private long animTime;
    private long totalDuration;

    public Animation() {
        frames = new ArrayList();
        totalDuration = 0;

        synchronized (this) {
            animTime = 0;
            currentFrame = 0;
        }
    }

    public synchronized void addFrame(Image image, long duration) {
        totalDuration += duration;
        frames.add(new AnimFrame(image, totalDuration));
    }

    public synchronized void update(long elapsedTime,int kind,Ball ball) {
        if (frames.size() > 1) {
            animTime += elapsedTime;
            if (animTime >= totalDuration) {
                animTime = animTime % totalDuration;
                currentFrame = 0;

            }

            int[] magicballradius = {26,26,27,29,31,32,34,36,37,37,37,37,36,35,34,32,30,28,27,26,25};
            while (animTime > getFrame(currentFrame).endTime) {
                if(kind == 3){
                    ball.setRadius(magicballradius[currentFrame]);
                }
                currentFrame++;

            }
        }
    }

    public  void updatewaiting(long elapsedTime) {
        if (frames.size() > 1) {
            animTime += elapsedTime;
            if (animTime >= totalDuration) {
                animTime = animTime % totalDuration;
                currentFrame = 0;

            }


            while (animTime > getFrame(currentFrame).endTime) {
                currentFrame++;

            }
        }
    }

    public synchronized Image getImage() {
        if (frames.size() == 0) {
            return null;
        } else {
            return getFrame(currentFrame).image;
        }
    }

    private AnimFrame getFrame(int i) {
        return (AnimFrame) frames.get(i);
    }

    private class AnimFrame {

        Image image;
        long endTime;

        public AnimFrame(Image image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }
    }
}