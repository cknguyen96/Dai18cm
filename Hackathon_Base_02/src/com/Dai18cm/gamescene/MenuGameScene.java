package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/16/2016.
 */
public class MenuGameScene extends GameScene {

    Image backgoundImage;

    public MenuGameScene(){
        this.backgoundImage = Utils.loadImage("resources/background.png");
    }

    @Override
    public void run(Point mousePoint) {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.backgoundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);
    }

    @Override
    public void onMouse(Point mousePoint) {

    }

    @Override
    public void click(MouseEvent e) {
        switch (e.getClickCount()){
            case 1: //hardcode
                System.out.println(e.getLocationOnScreen());
                if(e.getLocationOnScreen().getX() >= 625 && e.getLocationOnScreen().getX() <= 800
                        && e.getLocationOnScreen().getY() >= 530 && e.getLocationOnScreen().getY() <= 630)
                changeGameScene(GameSceneType.PLAY);
                break;
        }
    }
}
