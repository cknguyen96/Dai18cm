package com.Dai18cm.controllers;

import com.Dai18cm.models.*;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/16/2016.
 */
public class PlayerController extends SingleController implements Colliable{

    private PlayerController(Player gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    private PlayerController(Player gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    public void move(PlayerDirection playerDirection) {
        switch (playerDirection) {
            case NONE:
                break;
            case LEFT:
                this.gameVector.dx = - Player.DEFAULT_SPEED;
                break;
            case RIGHT:
                this.gameVector.dx = Player.DEFAULT_SPEED;
                break;
            case STOP_X:
                this.gameVector.dx = 0;
                break;
        }

    }

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
    public void setNULL(){
        inst = null;
    }
    public void isInBuff(GiftType giftType){
        switch (giftType){
            case BIGGER_PLAYER:
                System.out.println(((Player)this.gameObject).getWidth());
                ((Player)this.gameObject).setWidth(120);
                System.out.println(((Player)this.gameObject).getWidth());
                break;
            case SLOW_ENEMY:
                break;
        }
    }
    @Override
    public void run() {
        Rectangle rectangle = this.gameObject.getNextRect(this.gameVector);
        if(GameConfig.getInst().isInScreen(rectangle) && this.getGameObject().isAlive() == true) {
//            if(durationBuff > 0 ) durationBuff -= GameConfig.getInst().getThreadDelay();
//            else {
//                durationBuff = 0;
//                outBuff(current_giftType);
//            }
            super.run();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
//        if (c instanceof SpermController){
//            Sperm sperm = (Sperm) c.getGameObject();
//            sperm.setAlive(false);
//            Status.increaseScore();
//        }
    }
}
