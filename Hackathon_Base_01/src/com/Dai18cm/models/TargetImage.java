package com.Dai18cm.models;

import com.Dai18cm.Utils;
import com.Dai18cm.controllers.EnemyControllerManager;
import com.Dai18cm.controllers.LevelType;

import java.awt.*;

/**
 * Created by Admin on 5/16/2016.
 */
public class TargetImage {
    private Image image_lv1;
    private Image image_lv2;
    private Image image_lv3;
    private Image current_image = Utils.loadImage("resources/huy_3.png");

    public TargetImage(TargetType targetType){
        switch (targetType){
            case NONE:
                break;
            case BOY_QUAN_SIP:
                image_lv1 = Utils.loadImage("resources/huy_1.png");
                image_lv2 = Utils.loadImage("resources/huy_2.png");
                image_lv3 = Utils.loadImage("resources/huy_3.png");
                break;
            case GIRL:
                image_lv1 = Utils.loadImage("resources/ngoctrinh_1.png");
                image_lv2 = Utils.loadImage("resources/ngoctrinh_2.png");
                image_lv3 = Utils.loadImage("resources/ngoctrinh_3.png");
                break;
        }
    }
    public void paint(Graphics g){
        /*TODO Ve targetImage va doi Image moi khi dat diem */
        if(Status.getScore() <= 20){
            g.drawImage(image_lv1,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
                    GameConfig.DEFAULT_SCREEN_WIDTH/2,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    null
            );
            current_image = image_lv1;
        }
        if (Status.getScore() > 20 && Status.getScore() <= 40) {
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_2);
            g.drawImage(image_lv2,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
                    GameConfig.DEFAULT_SCREEN_WIDTH/2,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    null
            );
            current_image = image_lv2;
        }

        if (Status.getScore() > 40) {
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_3);
            g.drawImage(image_lv3,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
                    GameConfig.DEFAULT_SCREEN_WIDTH/2,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    null
            );
            current_image = image_lv3;
        }
    }

    public Image getCurrent_image() {
        return current_image;
    }
}
