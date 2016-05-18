package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.TargetType;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/16/2016.
 */
public class MenuGameScene extends GameScene {

    Image backgoundImage;
    Image boyImage;
    Image girlImage;

    public MenuGameScene(){
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
        g.setFont(new Font("TimesRoman",Font.PLAIN, 30));
        g.setColor(Color.ORANGE);
        g.drawString("Choose the character which", 250 , 70);
        g.drawString("you want to take off", 280 , 100);
    }

    @Override
    public void onMouse(Point mousePoint) {

    }

    @Override
    public void click(MouseEvent e) {
        switch (e.getClickCount()){
            case 1:
                System.out.println(e.getLocationOnScreen());
                if(e.getLocationOnScreen().getX() < 695)
                    targetType = TargetType.BOY_QUAN_SIP;
                if(e.getLocationOnScreen().getX() > 695)
                    targetType = TargetType.GIRL;
                changeGameScene(GameSceneType.PLAY);
                break;
        }
    }
}
