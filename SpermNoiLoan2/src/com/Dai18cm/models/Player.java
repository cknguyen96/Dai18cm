package com.Dai18cm.models;

/**
 * Created by Admin on 5/12/2016.
 */
public class Player extends GameObjectWithHP {

    private static final int HP_DEFAULT = 5;
    public static final int DEFAULT_WIDTH = 70;
    public static final int DEFAULT_HEIGHT = 60;
    protected int width  = DEFAULT_WIDTH;
    protected int height = DEFAULT_HEIGHT;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public Player(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }

    public Player(int x, int y, int width, int height){
        this(x, y, width, height, HP_DEFAULT);
    }


}
