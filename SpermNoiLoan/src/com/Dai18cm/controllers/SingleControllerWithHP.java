package com.Dai18cm.controllers;

import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.GameVecto;
import com.Dai18cm.views.GameDrawer;

/**
 * Created by Admin on 5/12/2016.
 */
public class SingleControllerWithHP extends SingleController {

    public SingleControllerWithHP(GameObject gameObject, GameDrawer gameDrawer, GameVecto gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
    }

    public SingleControllerWithHP(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }
}
