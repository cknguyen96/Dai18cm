package com.Dai18cm.models;

/**
 * Created by Admin on 5/12/2016.
 */
public class Sperm extends GameObject {

    public static final int DEFAULT_WIDTH = 25;
    public static final int DEFAULT_HEIGHT = 35;

    public static final int DEFAULT_SPEED = 6;
    public static int speeddd;

    public int getSpeed() {
        return speeddd;
    }

    public static void setSpeed(int speed) {
        speeddd = speed;
    }

    public Sperm(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        speeddd = speed;
    }

    public Sperm(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

}
