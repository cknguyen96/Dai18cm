package com.Dai18cm.gamesence;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Admin on 5/14/2016.
 */
public abstract class GameScene {
    private GameSceneLitsener gameSceneLitsener;

    public void setGameSceneListener(GameSceneLitsener gameSceneListener) {
        this.gameSceneLitsener = gameSceneListener;
    }

    protected void changeGameScene(GameSceneType gameScenceType) {
        if(gameSceneLitsener != null) {
            gameSceneLitsener.changeGameScence(gameScenceType);
        }
    }
    public abstract void run(Point mousePoint);

    public abstract void paint(Graphics g);

    public abstract void onKeyPressed(KeyEvent e);

    public abstract void onKeyReleased(KeyEvent e);

    public abstract void onMouse(Point mousePoint);
}
