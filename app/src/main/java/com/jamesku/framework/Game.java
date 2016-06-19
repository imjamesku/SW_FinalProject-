package com.jamesku.framework;

import com.jamesku.framework.Audio;
import com.jamesku.framework.FileIO;
import com.jamesku.framework.Graphics;
import com.jamesku.framework.Input;
import com.jamesku.framework.Screen;

public interface Game {

    public Audio getAudio();

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getInitScreen();
}