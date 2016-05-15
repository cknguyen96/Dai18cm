package com.Dai18cm.controllers;

import com.Dai18cm.models.*;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/12/2016.
 */
public class SpermController extends SingleController implements Colliable{

//    public static int DEFAULT_SPEED = 5;
//    public static int CURRENT_SPEED = DEFAULT_SPEED;
    public static int LEVEL_SPEED = Sperm.DEFAULT_SPEED;
    private static boolean isInBuff = false;
    public SpermController(Sperm gameObject, GameDrawer gameDrawer, GameVecto gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    public SpermController(Sperm gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    public void setIsInBuff(boolean isInBuff) {
        SpermController.isInBuff = isInBuff;
    }

//    public void setSpeed(){
//        ((Sperm)this.getGameObject()).setSpeed(LEVEL_SPEED / 2);
//    }

    @Override
    public void run() {
        super.run();
        if(!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
            Status.decrease();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public static SpermController create(/*Sau co the them SpermType*/int x, int y){
        SpermController spermController = null;
        GameVecto gameVecto = null;
        Sperm sperm = new Sperm(x, y, Sperm.DEFAULT_WIDTH, Sperm.DEFAULT_HEIGHT, Sperm.DEFAULT_SPEED);
        if(isInBuff == false){
            gameVecto = new GameVecto(0, LEVEL_SPEED);
        } else{
            Sperm.setSpeed(LEVEL_SPEED/2);
            gameVecto = new GameVecto(0, Sperm.speeddd);
//            System.out.println(sperm.getSpeed());
        }
        System.out.println(gameVecto.dy);
        AnimationDrawer spermDrawer = new AnimationDrawer(
                new String[] {
                        "resources/sperm/sperm.png",
                        "resources/sperm/sperm1.png",
                        "resources/sperm/sperm2.png",
                        "resources/sperm/sperm3.png",
                        "resources/sperm/sperm4.png",
                        "resources/sperm/sperm5.png",
                        "resources/sperm/sperm6.png",
                        "resources/sperm/sperm7.png",
                        "resources/sperm/sperm8.png",
                        "resources/sperm/sperm9.png"
                }
        );

        spermController = new SpermController(sperm, spermDrawer, gameVecto);

        return spermController;
    }

    @Override
    public void onCollide(Colliable c) {

    }
}
