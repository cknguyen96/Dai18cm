package com.Dai18cm.models;

import java.awt.*;

/**
 * Created by Admin on 5/12/2016.
 */
public class GameObject {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isAlive = true;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public void move(GameVecto gameVecto) {
        this.x += gameVecto.dx;
        this.y += gameVecto.dy;
    }
    //Kiem tra xem Object co di ra man hinh ko?
    public Rectangle getNextRect(GameVecto gameVecto) {
        return new Rectangle(x+gameVecto.dx, y+gameVecto.dy, width, height);
    }
}
