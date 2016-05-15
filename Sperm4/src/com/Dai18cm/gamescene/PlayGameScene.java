package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.controllers.*;
import com.Dai18cm.models.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

/**
 * Created by Administrator on 5/15/2016.
 */
public class PlayGameScene extends GameScene {
//    private Image image_lv1;
//    private Image image_lv2;
//    private Image image_lv3;
    private PlayerController playerController;
    Image backgoundImage;
    private Vector<Controller> controllerVect;
    private GameConfig gameConfig;
    public PlayGameScene() {

        gameConfig = GameConfig.getInst();
        controllerVect = new Vector<Controller>();
        this.playerController = PlayerController.getInst();
        controllerVect.add(SpermControllerManager.getInst());
        controllerVect.add(GiftControllerManager.getInst());
        controllerVect.add(this.playerController);

        this.backgoundImage = Utils.loadImage("resources/background1.png");
//        this.image_lv1 = Utils.loadImage("resources/huy_1.png");
//        this.image_lv2 = Utils.loadImage("resources/huy_2.png");
//        this.image_lv3 = Utils.loadImage("resources/huy_3.png");
        this.targetImage = new TargetImage(this.targetType);


    }
    @Override
    public void run(Point mousePoint) {
        CollisionPool.getInst().run();
        onMouse(mousePoint);
        for(Controller controller : controllerVect) {
            controller.run();
        }
        if(playerController.getGameObject().isAlive() == false) changeGameScene(GameSceneType.GAME_OVER);
//        controllerVect.get(0).run();
//        controllerVect.get(1).run();
//        playerController.run();
    }

    @Override
    public void paint(Graphics backbufferedGraphics) {
        backbufferedGraphics.drawImage(this.backgoundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);

//        backbufferedGraphics.drawImage(image_lv1,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
//                GameConfig.DEFAULT_SCREEN_WIDTH/2,
//                GameConfig.DEFAULT_SCREEN_HEIGHT,
//                null
//        );

        for(Controller controller : controllerVect){
            controller.paint(backbufferedGraphics);
        }
        targetImage.paint(backbufferedGraphics);
        backbufferedGraphics.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        backbufferedGraphics.drawString("Score: " + Status.getScore() , 30 , 60);
        backbufferedGraphics.drawString("HP: " + Status .getHP(), 330, 60);

//        if (playerController.getScore() > 20 && playerController.getScore() <= 40) {
//            SpermControllerManager.levelChange(LevelType.LEVEL_2);
//            backbufferedGraphics.drawImage(image_lv2,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
//                    GameConfig.DEFAULT_SCREEN_WIDTH/2,
//                    GameConfig.DEFAULT_SCREEN_HEIGHT,
//                    null
//            );
//        }
//
//        if (playerController.getScore() > 40) {
//            SpermControllerManager.levelChange(LevelType.LEVEL_3);
//            backbufferedGraphics.drawImage(image_lv3,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
//                    GameConfig.DEFAULT_SCREEN_WIDTH/2,
//                    GameConfig.DEFAULT_SCREEN_HEIGHT,
//                    null
//            );
//        }
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
//        PlayerDirection playerDirection = PlayerDirection.NONE;
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT:
//                playerDirection = PlayerDirection.LEFT;
//                break;
//            case KeyEvent.VK_RIGHT:
//                playerDirection = PlayerDirection.RIGHT;
//                break;
//        }
//
//        playerController.move(playerDirection);
    }

    @Override
    public void onKeyReleased(KeyEvent e) {
//        PlayerDirection playerDirection = PlayerDirection.NONE;
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT:
//            case KeyEvent.VK_RIGHT:
//                playerDirection = PlayerDirection.STOP_X;
//                break;
//        }
//        playerController.move(playerDirection);

    }

    @Override
    public void onMouse(Point mousePoint) {
        if(mousePoint.x - 5 > playerController.getGameObject().getX()) {
            playerController.getGameVecto().dx = 10;
        } else if(mousePoint.x + 5 < playerController.getGameObject().getX()) {
            playerController.getGameVecto().dx = -10;
        } else {
            playerController.getGameVecto().dx = 0;
        }

    }

    @Override
    public void click(MouseEvent e) {

    }
}
