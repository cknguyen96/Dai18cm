package com.Dai18cm.controllers;

import com.Dai18cm.models.GameConfig;

import java.util.Random;

/**
 * Created by nhoxkem96 on 14/05/2016.
 */
public class GiftControllerManager extends ControllerManager {

    private int count = 0;
    Random rand = new Random();
    @Override
    public void run() {
        super.run();
        count++;
        if(GameConfig.getInst().durationInSeconds(count) > 10 ){
            int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH/2 - 60) + 40;
            count = 0 ;
            GiftController giftController = GiftController.create(x , 0);
            add(giftController);
        }
    }

    private static GiftControllerManager inst;
    public static GiftControllerManager getInst() {
        if(inst == null) {
            inst = new GiftControllerManager();
        }
        return inst;
    }
}
