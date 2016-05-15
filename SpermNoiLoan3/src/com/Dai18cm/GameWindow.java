package com.Dai18cm;

import com.Dai18cm.controllers.*;
import com.Dai18cm.gamescene.*;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 5/12/2016.
 */
public class GameWindow extends Frame implements Runnable, GameSceneListener{

    Image backgroundImage;
    Thread thread;
    Image backbufferImage;
    GameScene gameScene;


    public GameWindow(){
        gameScene = new MenuGameScene();
        gameScene.setGameSceneListener(this);

        this.setVisible(true);
        this.setSize(GameConfig.DEFAULT_SCREEN_WIDTH, GameConfig.DEFAULT_SCREEN_HEIGHT);


        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                gameScene.onKeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameScene.onKeyReleased(e);
            }
        });

        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {
        //super.update(g);
        if (backbufferImage == null){
            backbufferImage = new BufferedImage(GameConfig.DEFAULT_SCREEN_WIDTH,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    1
            );
        }
        Graphics backbuffeGraphics = backbufferImage.getGraphics();

//        backbuffeGraphics.setFont(new Font("TimesRoman",Font.PLAIN, 20));
//        backbuffeGraphics.drawString("Score: " + playerController.getScore() , 30 , 60);
//        backbuffeGraphics.drawString("HP: " + Player.getHP(), 330, 60);


        gameScene.paint(backbuffeGraphics);

        g.drawImage(backbufferImage, 0, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );
    }

    @Override
    public void run() {
        while (true){
            try {
                Point mousePoint = MouseInfo.getPointerInfo().getLocation();

                mousePoint.x -= getLocationOnScreen().x;
                mousePoint.y -= getLocationOnScreen().y;

                gameScene.run(mousePoint);
                repaint();
                Thread.sleep(GameConfig.DEFAULT_THREAD_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeGameScence(GameSceneType gameSceneType) {
        switch (gameSceneType){
            case PLAY:
                gameScene = new PlayGameScene();
                break;
        }
    }
}
