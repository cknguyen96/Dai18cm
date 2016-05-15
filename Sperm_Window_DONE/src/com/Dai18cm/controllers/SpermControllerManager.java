package com.Dai18cm.controllers;

import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Sperm;

import java.util.Random;

/**
 * Created by Admin on 5/12/2016.
 */
public class SpermControllerManager extends ControllerManager {//Singleton

    private int count = 0;                  //Dem khi nao > n thi sperm ra doi
    Random rand = new Random();
    private static int SPEED_RANDOM = 1000;
    private static int SPACE_RANDOM = 100;
    private int n = rand.nextInt(SPEED_RANDOM) + SPACE_RANDOM; //thoi diem ngau nhien de con sperm tiep theo ra doi :v

    public SpermControllerManager(){
        super();
    }

    @Override
    public void run() {
        super.run();
        count ++;
        if(GameConfig.getInst().durationInMiliSeconds(count) > n){
            count = 0;                                                          //Gan lai count
            n = rand.nextInt(SPEED_RANDOM) + SPACE_RANDOM;                                         //Sinh thoi diem ngau nhien #
            int random_X =
                    rand.nextInt(((GameConfig.DEFAULT_SCREEN_WIDTH /2) - Sperm.DEFAULT_WIDTH - 5)) + 1;// Random vi tri X cua Sperm

            this.singleControllerVector.add(SpermController.create(random_X, 0));
        }
    }

    //Singleton
    private static SpermControllerManager inst;
    public static SpermControllerManager getInst() {
        if(inst == null) {
            inst = new SpermControllerManager();
        }
        return inst;
    }
    public static void setNULL(){
        inst = null;
    }

    public static void levelChange(LevelType levelType) {
        switch (levelType){
            case LEVEL_1:
                break;
            case LEVEL_2:
                SPEED_RANDOM = 800;
                SPACE_RANDOM = 80;
                SpermController.setDefaultSpeed(7);
                break;
            case LEVEL_3:
                SPEED_RANDOM = 500;
                SPACE_RANDOM = 50;
                SpermController.setDefaultSpeed(10);
                break;
        }
    }
}
