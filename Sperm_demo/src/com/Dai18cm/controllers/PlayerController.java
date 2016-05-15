package com.Dai18cm.controllers;

import com.Dai18cm.models.*;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/12/2016.
 */
public class PlayerController extends SingleController implements Colliable { //Singleton

    private int durationBuff;
    private GiftType current_giftType =  GiftType.NONE;
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
                System.out.println("LEFT");
                break;
            case RIGHT:
                this.gameVecto.dx = SPEED;
                System.out.println("RIGHT");
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
            Player player = new Player(200, 500, Player.DEFAULT_WIDTH , Player.DEFAULT_HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/condom.png");
            playerController = new PlayerController(player, imageDrawer);
        }
        return playerController;
    }


    public void inBuff(GiftType giftType){
        switch (giftType){
            case NONE:
                break;
            case BIGGER:
                durationBuff = 3000;
                current_giftType = GiftType.BIGGER;
                ((Player)this.gameObject).setWidth(Player.DEFAULT_WIDTH + 40);
                ((Player)this.gameObject).setHeight(Player.DEFAULT_HEIGHT + 40);
                break;
            case SPERM_SLOW:
                durationBuff = 2000;
                current_giftType = GiftType.SPERM_SLOW;
                SpermControllerManager.getInst().slowAll();
                break;
        }
    }

    public void outBuff(GiftType giftType){
        switch (giftType){
            case NONE:
                break;
            case BIGGER:
                ((Player)this.gameObject).setWidth(Player.DEFAULT_WIDTH);
                ((Player)this.gameObject).setHeight(Player.DEFAULT_HEIGHT);
                break;
            case SPERM_SLOW:
               SpermControllerManager.getInst().reset();
                break;
        }

    }
    @Override
    public void run() {
        Rectangle rectangle = this.gameObject.getNextRect(this.gameVecto);
        if(GameConfig.getInst().isInScreen(rectangle) && this.getGameObject().isAlive() == true) {
            if(durationBuff > 0 ) durationBuff -= GameConfig.getInst().getThreadDelay();
            else {
                durationBuff = 0;
                outBuff(current_giftType);
                //SpermControllerManager.getInst().reset();
            }
            super.run();
        }
    }

    @Override
    public void paint(Graphics g) {
        if(Status.getHP() > 0) super.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if (c instanceof SpermController){
            Sperm sperm = (Sperm) c.getGameObject();
            sperm.setAlive(false);
            Status.increaseScore();
        }
    }
}
