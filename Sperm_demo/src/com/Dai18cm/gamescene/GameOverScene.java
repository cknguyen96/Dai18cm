package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Status;
import com.Dai18cm.models.TargetImage;
import com.Dai18cm.models.TargetType;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/15/2016.
 */
public class GameOverScene extends GameScene {
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
        g.drawImage(this.targetImage.current_image, 200, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH/2,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );
        g.setFont(new Font("TimesRoman",Font.PLAIN, 50));
        g.setColor(Color.red);
        g.drawString("GAME" , 30 , GameConfig.DEFAULT_SCREEN_HEIGHT/2 + 30);
        g.drawString("OVER" , 620 , GameConfig.DEFAULT_SCREEN_HEIGHT/2 + 30);
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
                changeGameScene(GameSceneType.MENU);
                break;
        }
    }
}
