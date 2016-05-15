package com.Dai18cm.gamescene;

import java.util.Stack;

/**
 * Created by Admin on 5/15/2016.
 */
public class GameSceneManager {
    private Stack<GameScene> gameSceneStack = new Stack<GameScene>();
    private GameSceneManager(){
        gameSceneStack.push(new MenuGameScene());
    }
    public void add(GameScene gameScene){
        gameSceneStack.push(gameScene);
    }

    public Stack<GameScene> getGameSceneStack() {
        return gameSceneStack;
    }

    //Singleton
    private static GameSceneManager inst;
    public static GameSceneManager getInst(){
        if(inst == null){
            inst = new GameSceneManager();
        }
        return inst;
    }
}
