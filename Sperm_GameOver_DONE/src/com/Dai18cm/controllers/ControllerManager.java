package com.Dai18cm.controllers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Admin on 5/12/2016.
 */
public class ControllerManager implements Controller {

    protected Vector<SingleController> singleControllerVector;

    public ControllerManager() {
        singleControllerVector = new Vector<SingleController>();
    }

    public void add(SingleController controller) {
        singleControllerVector.add(controller);
    }

    public int size() {
        return this.singleControllerVector.size();
    }

    public static void deleteAll(Vector<Controller> controllerVector){
        Iterator<Controller> iterator = controllerVector.iterator();
        while(iterator.hasNext()) {
            Controller controller = iterator.next();
            if(!(controller instanceof PlayerController)){
                iterator.remove();
            }
        }
    }

    @Override
    public void run() {
        Iterator<SingleController> iterator = singleControllerVector.iterator();
        while(iterator.hasNext()) {
            SingleController singleController = iterator.next();
            if(!singleController.getGameObject().isAlive()) {
                iterator.remove();
            } else {
                singleController.run();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Iterator<SingleController> iterator = singleControllerVector.iterator();
        while(iterator.hasNext()) {
            SingleController singleController = iterator.next();
            if(!singleController.getGameObject().isAlive()) {
                iterator.remove();
            } else {
                singleController.paint(g);
            }
        }
//        for(SingleController controller : singleControllerVector) {
//            controller.paint(g);
//        }
    }

}
