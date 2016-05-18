package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.controllers.*;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Player;
import com.Dai18cm.models.Status;
import com.Dai18cm.models.TargetImage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Admin on 5/16/2016.
 */
public class PlayGameScene extends GameScene {

    private PlayerController playerController;
    Image backgoundImage;
    private Vector<Controller> controllerVect;
    private GameConfig gameConfig;
    private CollisionPool collisionPool;

    public PlayGameScene(){
        collisionPool = CollisionPool.getInst();
        gameConfig = GameConfig.getInst();
        controllerVect = new Vector<Controller>();
        this.playerController = PlayerController.getInst();
        controllerVect.add(EnemyControllerManager.getInst());
        controllerVect.add(GiftControllerManager.getInst());
        controllerVect.add(this.playerController);

        this.backgoundImage = Utils.loadImage("resources/background1.png");
        this.targetImage = new TargetImage(this.targetType);
    }

    public void resetPlayGameScene(){
        Status.resetHP();
        Status.resetScore();
        EnemyControllerManager.setNULL();
        GiftControllerManager.setNULL();
        //this.playerController.setNULL();
        collisionPool.reset();
    }

    @Override
    public void run(Point mousePoint) {
        collisionPool.run();
        onMouse(mousePoint);
        Iterator<Controller> iterator = controllerVect.iterator();
        while(iterator.hasNext()) {
            Controller c = iterator.next();
            c.run();
        }
        if(Status.getHp() <= 0){
            resetPlayGameScene();
            //playerController.getGameObject().setAlive(false);
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_1);
            GameOverScene.CURRENT_IMAGE = this.targetImage.getCurrent_image();
            changeGameScene(GameSceneType.GAME_OVER);

        }
    }

    @Override
    public void paint(Graphics g) {
        //ve background
        g.drawImage(this.backgoundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);

        Iterator<Controller> iterator = controllerVect.iterator();
        while(iterator.hasNext()) {
            Controller c = iterator.next();
            c.paint(g);
        }

        this.targetImage.paint(g);
        g.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        g.drawString("Score: " + Status.getScore() , 30 , 60);
        g.drawString("HP: " + Status.getHp(), 330, 60);
    }

    @Override
    public void onMouse(Point mousePoint) {
        if(mousePoint.x - 5 > playerController.getGameObject().getX()) {
            playerController.getGameVector().dx = Player.DEFAULT_SPEED;
        } else if(mousePoint.x + 5 < playerController.getGameObject().getX()) {
            playerController.getGameVector().dx = - Player.DEFAULT_SPEED;
        } else {
            playerController.getGameVector().dx = 0;
        }
    }

    @Override
    public void click(MouseEvent e) {

    }
}
