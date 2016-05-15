package com.Dai18cm.controllers;

import com.Dai18cm.models.*;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;

/**
 * Created by nhoxkem96 on 14/05/2016.
 */
public class GiftController extends SingleController implements Colliable {


    public GiftController(GameObject gameObject, GameDrawer gameDrawer, GameVecto gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    public GiftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void run() {
        super.run();
        if(!GameConfig.getInst().isInScreen(this.gameObject)) {
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlayerController){
            Player player = (Player)c.getGameObject();
            Gift gift = (Gift)gameObject;
            ((PlayerController)c).inBuff(GiftType.BIGGER);
            this.gameObject.setAlive(false);
        }
    }

    public static GiftController create(int x , int y){
        Gift gift = new Gift(x , y, Gift.WIDTH_DEFAULT , Gift.HEIGHT_DEFAULT);
        GameVecto gameVecto = new GameVecto(0 , 6);
        ImageDrawer imageDrawer = new ImageDrawer("resources/huy_3.png");
        return new GiftController(gift , imageDrawer , gameVecto);
    }
}
