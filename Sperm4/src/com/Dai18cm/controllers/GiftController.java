package com.Dai18cm.controllers;

import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.GameVecto;
import com.Dai18cm.models.Gift;
import com.Dai18cm.models.Player;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

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
        ImageDrawer imageDrawer = new ImageDrawer("resources/gift.gif");
        return new GiftController(gift , imageDrawer , gameVecto);
    }
}
