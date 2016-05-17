package com.Dai18cm.controllers;

import com.Dai18cm.models.*;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/16/2016.
 */
public class EnemyController extends SingleController implements Colliable{

    public static int level_speed = Enemy.DEFAULT_SPEED;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }

    /*TODO lam` hieu ung cho enemy */

    @Override
    public void run() {
        super.run();
        if(!GameConfig.getInst().isInScreen(this.gameObject.getRect())) {
            this.gameObject.setAlive(false);
            Status.decreaseHP();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public static EnemyController create(int x, int y){
        EnemyController enemyController = null;
        GameVector gameVector = new GameVector(0, level_speed);
        /*TODO lam hieu ung cho enemy */
        Enemy enemy = new Enemy(x, y,
                Enemy.DEFAULT_WIDTH,
                Enemy.DEFAULT_HEIGHT
        );
        AnimationDrawer animationDrawer = new AnimationDrawer(
                new String[] {
                        "resources/sperm/sperm.png",
                        "resources/sperm/sperm1.png",
                        "resources/sperm/sperm2.png",
                        "resources/sperm/sperm3.png",
                        "resources/sperm/sperm4.png",
                        "resources/sperm/sperm5.png",
                        "resources/sperm/sperm6.png",
                        "resources/sperm/sperm7.png",
                        "resources/sperm/sperm8.png",
                        "resources/sperm/sperm9.png"
                }
        );
        enemyController = new EnemyController(enemy, animationDrawer, gameVector);
        return enemyController;
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlayerController){
            this.getGameObject().setAlive(false);
            Status.increaseScore();
        }
    }
}
