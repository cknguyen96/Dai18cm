package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.controllers.*;
import com.Dai18cm.models.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Iterator;
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
    private CollisionPool collisionPool;
    public PlayGameScene() {
        collisionPool = CollisionPool.getInst();
        gameConfig = GameConfig.getInst();
        controllerVect = new Vector<Controller>();
        this.playerController = PlayerController.getInst();
        controllerVect.add(SpermControllerManager.getInst());
        controllerVect.add(GiftControllerManager.getInst());
        controllerVect.add(this.playerController);

        this.backgoundImage = Utils.loadImage("resources/background1.png");
        this.targetImage = new TargetImage(this.targetType);


    }
    public void reset(){
        Status.hp = 5;
        Status.score = 0;
        SpermControllerManager.setNULL();
        GiftControllerManager.setNULL();
        collisionPool.reset();
    }
    @Override
    public void run(Point mousePoint) {
        collisionPool.run();
        onMouse(mousePoint);
        for(Controller controller : controllerVect) {
            controller.run();
        }
        if(Status.hp == 0){
            reset();
            playerController.getGameObject().setAlive(false);
            changeGameScene(GameSceneType.GAME_OVER);
            SpermControllerManager.getInst().levelChange(LevelType.LEVEL_1);
        }
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
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
    }

    @Override
    public void onKeyReleased(KeyEvent e) {

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
