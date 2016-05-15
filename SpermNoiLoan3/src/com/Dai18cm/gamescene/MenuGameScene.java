package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Administrator on 5/15/2016.
 */
public class MenuGameScene extends GameScene {
    Image backgoundImage;
    public MenuGameScene() {
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
    public void onKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            changeGameScene(GameSceneType.PLAY);
        }

    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }

    @Override
    public void onMouse(Point mousePoint) {

    }
}
