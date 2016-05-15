package com.Dai18cm.gamescene;

import com.Dai18cm.models.TargetImage;
import com.Dai18cm.models.TargetType;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Administrator on 5/15/2016.
 */
public abstract class GameScene {
    private GameSceneListener gameSceneListener;
    protected TargetImage targetImage;
    protected static TargetType targetType = TargetType.NONE;
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    protected void changeGameScene(GameSceneType gameSceneType) {
        if(gameSceneListener != null) {
            gameSceneListener.changeGameScence(gameSceneType);
        }
    }

    public abstract void run(Point mousePoint);

    public abstract void paint(Graphics g);

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onKeyReleased(KeyEvent e);

    public abstract void onMouse(Point mousePoint);

    public abstract void click(MouseEvent e);

}
