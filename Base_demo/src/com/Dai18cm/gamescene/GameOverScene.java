package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/16/2016.
 */
public class GameOverScene extends GameScene {
    public static Image CURRENT_IMAGE;
    private Image backgroundImage;
    public GameOverScene(){
        backgroundImage = Utils.loadImage("resources/background1.png");
    }
    @Override
    public void run(Point mousePoint) {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroundImage, 0, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );
        g.drawImage(CURRENT_IMAGE, 200, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH/2,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );
        g.setFont(new Font("TimesRoman",Font.ROMAN_BASELINE, 50));
        g.setColor(Color.red);
        g.drawString("GAME" , 30 , GameConfig.DEFAULT_SCREEN_HEIGHT/2 + 30);
        g.drawString("OVER" , 620 , GameConfig.DEFAULT_SCREEN_HEIGHT/2 + 30);
    }

    @Override
    public void onMouse(Point mousePoint) {

    }

    @Override
    public void click(MouseEvent e) {
        switch (e.getClickCount()){
            case 1:
                changeGameScene(GameSceneType.MENU);
                break;
        }
    }
}
