package com.Dai18cm.models;

/**
 * Created by Admin on 5/12/2016.
 */
public class GameObjectWithHP extends GameObject {
    private int hp;
    private static int HP = 5;
    protected static int SCORE = 0;

    public GameObjectWithHP(int x, int y, int width, int height, int hp) {
        super(x, y, width, height);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void increaseHP(int delta) {
        this.hp += delta;
    }

    public void increaseHP() {
        increaseHP(1);
    }

    public void decreaseHP(int delta) {
        this.hp -= delta;
    }

    public void decreaseHP() {
        decreaseHP(1);
    }

    public static void decrease() {
        HP--;
    }

    public static void increaseScore() {
        SCORE++;
    }

    public static int getSCORE() {
        return SCORE;
    }

    public static int getHP() {
        return HP;
    }
}
