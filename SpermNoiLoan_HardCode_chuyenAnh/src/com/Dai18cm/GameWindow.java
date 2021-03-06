package com.Dai18cm;

import com.Dai18cm.controllers.CollisionPool;
import com.Dai18cm.controllers.PlayerController;
import com.Dai18cm.controllers.PlayerDirection;
import com.Dai18cm.controllers.SpermControllerManager;
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
public class GameWindow extends Frame implements Runnable{

    Image backgroundImage;
    Thread thread;
    Image backbufferImage;
    Image image_lv1;
    Image image_lv2;
    PlayerController playerController;

    public GameWindow(){
        this.playerController = PlayerController.getInst();

        this.setVisible(true);
        this.setSize(GameConfig.DEFAULT_SCREEN_WIDTH, GameConfig.DEFAULT_SCREEN_HEIGHT);

        try {
            backgroundImage = ImageIO.read(new File("resources/background.png"));
            image_lv1 = ImageIO.read(new File("resources/huy_3.png"));
            image_lv2 = ImageIO.read(new File("resources/huy_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                PlayerDirection playerDirection = PlayerDirection.NONE;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        playerDirection = PlayerDirection.LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                        playerDirection = PlayerDirection.RIGHT;
                        break;
                }

                playerController.move(playerDirection);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                PlayerDirection playerDirection = PlayerDirection.NONE;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        playerDirection = PlayerDirection.STOP_X;
                        break;
                }
                playerController.move(playerDirection);
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

        backbuffeGraphics.drawImage(backgroundImage, 0, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );
        if(Player.getSCORE() >= 0 && Player.getSCORE() <= 10) {
            backbuffeGraphics.drawImage(image_lv1, GameConfig.DEFAULT_SCREEN_WIDTH / 2, 0,
                    GameConfig.DEFAULT_SCREEN_WIDTH / 2,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    null
            );
        } else {
            backbuffeGraphics.drawImage(image_lv2, GameConfig.DEFAULT_SCREEN_WIDTH / 2, 0,
                    GameConfig.DEFAULT_SCREEN_WIDTH / 2,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    null
            );
        }
        SpermControllerManager.getInst().paint(backbuffeGraphics);
        playerController.paint(backbuffeGraphics);

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
                CollisionPool.getInst().run();
                playerController.run();
                SpermControllerManager.getInst().run();
                repaint();
                Thread.sleep(GameConfig.DEFAULT_THREAD_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
