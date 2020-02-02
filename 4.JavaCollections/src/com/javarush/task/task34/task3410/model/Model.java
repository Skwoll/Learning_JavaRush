package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.Controller;
import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.File;

public class Model {
    public static int FIELD_CELL_SIZE = 20;
    EventListener eventListener;
    GameObjects gameObjects;
    int currentLevel = 1;
    LevelLoader levelLoader = new LevelLoader(new File( "4.JavaCollections/src/"+
            Controller.class.getPackage().getName().replace("[.]","/")+"/res/levels.txt").toPath());

    //region Properties
    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
    //endregion

    //region Methods
    public GameObjects getGameObjects(){
        return gameObjects;
    }
    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }
    public void restart(){
        restartLevel(currentLevel);
    }
    public void startNextLevel(){
        currentLevel++;
        restart();
    }
    public void move(Direction direction) {


    }
    //endregion
}
