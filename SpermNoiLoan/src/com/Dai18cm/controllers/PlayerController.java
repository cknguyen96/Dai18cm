package com.Dai18cm.controllers;

import com.Dai18cm.models.*;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/12/2016.
 */
public class PlayerController extends SingleControllerWithHP implements Colliable { //Singleton

    public final int SPEED = 10;

    public PlayerController(GameObject gameObject, GameDrawer gameDrawer, GameVecto gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    public PlayerController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    public void move(PlayerDirection playerDirection) {
        switch (playerDirection) {
            case NONE:
                break;
            case LEFT:
                this.gameVecto.dx = -SPEED;
                break;
            case RIGHT:
                this.gameVecto.dx = SPEED;
                break;
            case STOP_X:
                this.gameVecto.dx = 0;
                break;
        }

    }

    //Singleton
    private static PlayerController inst;
    public static PlayerController getInst() {
        PlayerController playerController = null;
        if (inst == null) {
            Player player = new Player(200, 500, Player.DEFAULT_WIDTH, Player.DEFAULT_HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/Condom.png");
            playerController = new PlayerController(player, imageDrawer);
        }
        return playerController;
    }

    @Override
    public void run() {
        Rectangle rectangle = this.gameObject.getNextRect(this.gameVecto);
        if(GameConfig.getInst().isInScreen(rectangle) && this.getGameObject().isAlive() == true) {
            super.run();
        }
    }

    @Override
    public void paint(Graphics g) {
        if(this.getGameObject().isAlive() == true) super.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof SpermController){
            Sperm sperm = (Sperm) c.getGameObject();
            sperm.setAlive(false);
        }
    }
}
