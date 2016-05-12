package com.Dai18cm.models;

/**
 * Created by Admin on 5/12/2016.
 */
public class Player extends GameObjectWithHP {

    private static final int HP_DEFAULT = 5;
    public static final int DEFAULT_WIDTH = 70;
    public static final int DEFAULT_HEIGHT = 60;
    private int score = 0;

    public Player(int x, int y, int width, int height, int hp) {
        super(x, y, width, height, hp);
    }

    public Player(int x, int y, int width, int height){
        this(x, y, width, height, HP_DEFAULT);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
