package com.Dai18cm.controllers;

import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.GameVector;
import com.Dai18cm.models.SunFlower;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;
import sun.security.provider.Sun;

import java.awt.*;

/**
 * Created by Admin on 5/19/2016.
 */
public class SunFlowerController extends SingleController {
    public SunFlowerController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
    }

    public SunFlowerController(GameObject gameObject, AnimationDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }
    private static SunFlowerController inst;
    public static SunFlowerController getInst(){
        SunFlowerController sunFlowerController = null;
        if (inst == null) {
            SunFlower sunFlower = new SunFlower(500, 510, 80 , 80);
            AnimationDrawer animationDrawer = new AnimationDrawer(
                    new String[]{
                            "resources/mam/mam0.png",
                            "resources/mam/mam1.png",
                            "resources/mam/mam2.png",
                            "resources/mam/mam3.png",
                            "resources/mam/mam4.png",
                            "resources/mam/mam5.png",
                    }
            );
            sunFlowerController = new SunFlowerController(sunFlower, animationDrawer);
        }
        return sunFlowerController;
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
