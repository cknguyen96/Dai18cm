package com.Dai18cm.gamesence;

import com.Dai18cm.Utils;
import com.Dai18cm.controllers.*;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.GameVecto;
import com.Dai18cm.models.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Admin on 5/14/2016.
 */
public class PlayGameScene extends GameScene {
    private Image backgroundImage;
    private PlayerController playerController;
    private Vector<Controller> controllerVect;
    private GameConfig gameConfig;
    Image image_lv1;
    Image image_lv2;
    Image image_lv3;

    public PlayGameScene() {
        gameConfig = GameConfig.getInst();
        controllerVect = new Vector<Controller>();

        controllerVect.add(SpermControllerManager.getInst());
        controllerVect.add(PlayerController.getInst());
        controllerVect.add(GiftControllerManager.getInst());

        this.playerController = PlayerController.getInst();


        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
            image_lv1 = ImageIO.read(new File("resources/huy_1.png"));
            image_lv2 = ImageIO.read(new File("resources/huy_2.png"));
            image_lv3 = ImageIO.read(new File("resources/huy_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(Point mousePoint) {
        CollisionPool.getInst().run();
        for(Controller controller : controllerVect) {
            controller.run();
        }
        onMouse(mousePoint);
    }

    @Override
    public void paint(Graphics backbufferGraphics) {

        backbufferGraphics.drawImage(backgroundImage, 0, 0,
                gameConfig.getScreenWidth(), gameConfig.getScreenHeight(), null);

        backbufferGraphics.drawImage(backgroundImage, 0, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );

        backbufferGraphics.drawImage(image_lv1,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH/2,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );

        for (Controller controller : controllerVect) {
            controller.paint(backbufferGraphics);
        }
        Utils.displayBoard(backbufferGraphics);
//        backbufferGraphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));
//        backbufferGraphics.drawString("Score: " + playerController.getScore() , 30 , 60);
//        backbufferGraphics.drawString("HP: " + Player.getHP(), 330, 60);

        if (playerController.getScore() > 10 && playerController.getScore() <= 20) {
            SpermControllerManager.levelChange(LevelType.LEVEL_2);
            backbufferGraphics.drawImage(image_lv2,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
                    GameConfig.DEFAULT_SCREEN_WIDTH/2,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    null
            );
        }

        if (playerController.getScore() > 20) {
            SpermControllerManager.levelChange(LevelType.LEVEL_3);
            backbufferGraphics.drawImage(image_lv3,GameConfig.DEFAULT_SCREEN_WIDTH/2, 0,
                    GameConfig.DEFAULT_SCREEN_WIDTH/2,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    null
            );
        }

    }

    @Override
    public void onKeyPressed(KeyEvent e) {

    }

    @Override
    public void onKeyReleased(KeyEvent e) {

    }

    @Override
    public void onMouse(Point mousePoint) {
        int xxx = playerController.getGameObject().getX();
        int yyy = playerController.getGameObject().getX();
        GameVecto gameVecto = null;
                if(mousePoint.x - 5 > playerController.getGameObject().getX()) {
                    gameVecto = new GameVecto(5, 0);
                     playerController.setGameVecto(gameVecto);
                } else if(mousePoint.x + 5 < playerController.getGameObject().getX()) {
                    gameVecto = new GameVecto(-5, 0);
                    playerController.setGameVecto(gameVecto);
                } else {
                    gameVecto = new GameVecto(0, 0);
                    playerController.setGameVecto(gameVecto);
                }

//                if(mousePoint.y - 5 > plane2.y) {
//                    plane2.dy = 5;
//                } else if(mousePoint.y + 5 < plane2.y) {
//                    plane2.dy = -5;
//                } else {
//                    plane2.dy = 0;
//                }

    }
    //    @Override
//    public void onKeyPressed(KeyEvent e) {
//
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
//    }
//
//    @Override
//    public void onKeyReleased(KeyEvent e) {
//        PlayerDirection playerDirection = PlayerDirection.NONE;
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT:
//            case KeyEvent.VK_RIGHT:
//                playerDirection = PlayerDirection.STOP_X;
//                break;
//        }
//        playerController.move(playerDirection);
//    }
}
