package com.Dai18cm.controllers;

import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.GameVecto;
import com.Dai18cm.models.Gift;
import com.Dai18cm.models.Player;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

/**
 * Created by nhoxkem96 on 14/05/2016.
 */
public class GiftController extends SingleController implements Colliable {


    public GiftController(Gift gameObject, GameDrawer gameDrawer, GameVecto gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    public GiftController(Gift gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlayerController){
            Player player = (Player)c.getGameObject();
            Gift gift = (Gift)gameObject;
            System.out.println(gift.getGiftType());
            switch (gift.getGiftType()){
                case BIGGER:
                    ((PlayerController)c).inBuff(GiftType.BIGGER);
                    break;
                case SPERM_SLOW:
                    ((PlayerController)c).inBuff(GiftType.SPERM_SLOW);
                    break;
            }

            this.gameObject.setAlive(false);
        }
    }

    public static GiftController create(GiftType giftType, int x , int y){
        Gift gift = new Gift(x , y, Gift.WIDTH_DEFAULT , Gift.HEIGHT_DEFAULT);
        GameVecto gameVecto = new GameVecto(0 , 6);
        ImageDrawer imageDrawer = null;
        AnimationDrawer animationDrawer = null;
        switch (giftType){
            case BIGGER:
                gift.setGiftType(GiftType.BIGGER);
                 animationDrawer = new AnimationDrawer(
                         new String[]{
                                 "resources/gift.gif"
                         }
                 );
                break;
            case SPERM_SLOW:
                gift.setGiftType(GiftType.SPERM_SLOW);
                animationDrawer = new AnimationDrawer(
                        new String[] {
                                "resources/giftblue/giftblue1.png",
                                "resources/giftblue/giftblue2.png",
                                "resources/giftblue/giftblue3.png",
                                "resources/giftblue/giftblue4.png",
                        }
                );
                break;
        }
        return new GiftController(gift , animationDrawer , gameVecto);
    }
}
