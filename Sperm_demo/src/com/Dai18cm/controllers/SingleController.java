package com.Dai18cm.controllers;

import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.GameVecto;
import com.Dai18cm.views.GameDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/12/2016.
 */
public class SingleController implements Controller {
    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVecto gameVecto;
    protected boolean pause = false;

    public SingleController(GameObject gameObject, GameDrawer gameDrawer, GameVecto gameVecto) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVecto = gameVecto;
    }

    public SingleController(GameObject gameObject, GameDrawer gameDrawer){
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVecto = new GameVecto();
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public GameVecto getGameVecto() {
        return gameVecto;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    @Override
    public void paint(Graphics g) {
        this.gameDrawer.paint(this.gameObject, g);
    }

    @Override
    public void run() {
        if(pause == false){
            this.gameObject.move(this.gameVecto);
        }
    }
}
