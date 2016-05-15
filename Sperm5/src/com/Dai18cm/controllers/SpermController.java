package com.Dai18cm.controllers;

import com.Dai18cm.models.*;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/12/2016.
 */
public class SpermController extends SingleController implements Colliable{

    private static int DEFAULT_SPEED = 5;

    public SpermController(GameObject gameObject, GameDrawer gameDrawer, GameVecto gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    public SpermController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    public static int getDefaultSpeed() {
        return DEFAULT_SPEED;
    }

    public static void setDefaultSpeed(int defaultSpeed) {
        DEFAULT_SPEED = defaultSpeed;
    }

    @Override
    public void run() {
        //if (this.gameObject.isAlive())
        super.run();
        if(!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
            Status.decrease();
//            if(Player.getHP() <= 0) PlayerController.getInst().getGameObject().setAlive(false);
        }
    }

    @Override
    public void paint(Graphics g) {
        //if (this.gameObject.isAlive())
        super.paint(g);
    }

    public static SpermController create(/*Sau co the them SpermType*/int x, int y){
        SpermController spermController = null;

        Sperm sperm = new Sperm(x, y, Sperm.DEFAULT_WIDTH, Sperm.DEFAULT_HEIGHT);
        GameVecto gameVecto = new GameVecto(0, DEFAULT_SPEED);
        ImageDrawer imageDrawer = new ImageDrawer("resources/egg11.png");

        spermController = new SpermController(sperm, imageDrawer, gameVecto);

        return spermController;
    }

    @Override
    public void onCollide(Colliable c) {

    }
}
