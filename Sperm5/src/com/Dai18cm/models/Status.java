package com.Dai18cm.models;

/**
 * Created by Admin on 5/15/2016.
 */
public class Status {
    private static int score = 0;
    private static int hp = 5;

    public int getHp() {
        return hp;
    }

    public static int getScore() {
        return score;
    }

    public static void increaseScore() {
        score++;
    }

    public static void decrease() {
        if(hp > 0) hp--;
    }

    public static int getHP() {
        return hp;
    }
}
