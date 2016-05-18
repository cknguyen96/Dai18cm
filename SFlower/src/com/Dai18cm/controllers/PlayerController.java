package com.Dai18cm.controllers;

import com.Dai18cm.models.*;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Admin on 5/16/2016.
 */
public class PlayerController extends SingleController implements Colliable{

//    private GiftType current_giftType =  GiftType.NONE;
    private boolean inBuff = false;
    public Vector<GiftController> giftControllerVector = new Vector<GiftController>();
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
            case NONE:
                break;
            case BIGGER_PLAYER:
//                current_giftType = GiftType.BIGGER_PLAYER;
                ((Player)this.gameObject).setWidth(Player.DEFAULT_WIDTH + 40);
                this.inBuff = true;
                break;
            case SLOW_ENEMY:
//                current_giftType = GiftType.SLOW_ENEMY;
                EnemyControllerManager.getInst().slowAll();
                this.inBuff = true;
                break;
        }
    }

    public void outBuff(){
        Iterator<GiftController> iterator = giftControllerVector.iterator();
        while (iterator.hasNext()) {
            GiftController giftController = iterator.next();
            ((Gift)giftController.getGameObject()).decreaseDurationTime();
            //System.out.println(((Gift)giftController.getGameObject()).getDurationTime());
            if(((Gift)giftController.getGameObject()).getDurationTime() <= 0){
                switch (((Gift)giftController.getGameObject()).getGiftType()){
                    case NONE:
                        break;
                    case BIGGER_PLAYER:
                        ((Player)this.gameObject).setWidth(Player.DEFAULT_WIDTH);
                        ((Player)this.gameObject).setHeight(Player.DEFAULT_HEIGHT);
                        break;
                    case SLOW_ENEMY:
                        EnemyControllerManager.getInst().reset();
                        break;
                }
                iterator.remove();
            }
        }
//        switch (giftType){
//            case NONE:
//                break;
//            case BIGGER_PLAYER:
//                ((Player)this.gameObject).setWidth(Player.DEFAULT_WIDTH);
//                ((Player)this.gameObject).setHeight(Player.DEFAULT_HEIGHT);
//                break;
//            case SLOW_ENEMY:
//                EnemyControllerManager.getInst().reset();
//                break;
//        }

    }
    @Override
    public void run() {
        Rectangle rectangle = this.gameObject.getNextRect(this.gameVector);
        if(GameConfig.getInst().isInScreen(rectangle) && this.getGameObject().isAlive() == true) {
            if(this.inBuff == true) outBuff();
            super.run();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof GiftController){
            switch (((Gift)c.getGameObject()).getGiftType()){
                case NONE:
                    break;
                case BIGGER_PLAYER:
                    isInBuff(GiftType.BIGGER_PLAYER);
                    this.giftControllerVector.add((GiftController)c);
                    break;
                case SLOW_ENEMY:
                    isInBuff(GiftType.SLOW_ENEMY);
                    this.giftControllerVector.add((GiftController)c);
                    break;
            }
            c.getGameObject().setAlive(false);
        }
    }
}
