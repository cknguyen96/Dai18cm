package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.TargetType;
import sun.nio.ch.Util;
import sun.nio.cs.UTF_32LE;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 5/15/2016.
 */
public class MenuGameScene extends GameScene {
    Image backgoundImage;
    Image boyImage;
    Image girlImage;

    public MenuGameScene() {
        this.backgoundImage = Utils.loadImage("resources/background_menu.png");
        boyImage = Utils.loadImage("resources/huy_1.png");
        girlImage = Utils.loadImage("resources/ngoctrinh_1.png");
    }
    @Override
    public void run(Point mousePoint) {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.backgoundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);
        g.drawImage(boyImage, 0, 0,
                GameConfig.getInst().getScreenWidth()/2,
                GameConfig.getInst().getScreenHeight(),
                null
        );
        g.drawImage(girlImage, GameConfig.getInst().getScreenWidth()/2, 0,
                GameConfig.getInst().getScreenWidth()/2,
                GameConfig.getInst().getScreenHeight(),
                null
        );
    }

    @Override
    public void onKeyPressed(KeyEvent e) {


    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }

    @Override
    public void onMouse(Point mousePoint) {

    }

    @Override
    public void click(MouseEvent e) {
        switch (e.getClickCount()){
            case 1:
                if(e.getLocationOnScreen().getX() < GameConfig.getInst().getScreenWidth()/2)
                    targetType = TargetType.BOY_QUAN_SIP;
                if(e.getLocationOnScreen().getX() > GameConfig.getInst().getScreenWidth()/2)
                    targetType = TargetType.GIRL;
                changeGameScene(GameSceneType.PLAY);
                break;
        }
    }
}
