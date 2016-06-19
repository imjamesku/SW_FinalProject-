package com.jamesku.framework;
import com.jamesku.framework.Graphics;
/**
 * Created by James on 2016/06/19.
 */
public interface Image {
    public int getWidth();
    public int getHeight();
    public Graphics.ImageFormat getFormat();
    public void dispose();
}
