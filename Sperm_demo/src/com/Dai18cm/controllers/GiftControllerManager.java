package com.Dai18cm.controllers;

import com.Dai18cm.models.GameConfig;

import java.util.Random;

/**
 * Created by nhoxkem96 on 14/05/2016.
 */
public class GiftControllerManager extends ControllerManager {

    private int count = 0;
    private int count_giftxanh = 0;
    Random rand = new Random();
    @Override
    public void run() {
        super.run();
        count++;
        count_giftxanh++;
        if(GameConfig.getInst().durationInSeconds(count) > 6 ){
            count = 0;
            //random x
            int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH/2 - 60) + 40;
            GiftController giftController = GiftController.create(GiftType.BIGGER, x , 0);
            this.singleControllerVector.add(giftController);
        }
        if (GameConfig.getInst().durationInSeconds(count_giftxanh) > 10){
            count_giftxanh = 0;
            //random x
            int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH/2 - 60) + 40;
            GiftController giftController = GiftController.create(GiftType.SPERM_SLOW, x , 0);
            this.singleControllerVector.add(giftController);

        }
    }

    private static GiftControllerManager inst;
    public static GiftControllerManager getInst() {
        if(inst == null) {
            inst = new GiftControllerManager();
        }
        return inst;
    }
    public static void setNULL(){
        inst = null;
    }
}
