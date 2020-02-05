package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.Controller;
import com.javarush.task.task34.task3410.controller.EventListener;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Model {
    public static int FIELD_CELL_SIZE = 20;
    EventListener eventListener;
    GameObjects gameObjects;
    int currentLevel = 1;
    LevelLoader levelLoader = new LevelLoader(new File( "4.JavaCollections/src/"+
            Controller.class.getPackage().getName().replace(".","/")+"/../res/levels.txt").toPath());

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
        if(checkWallCollision(gameObjects.getPlayer(),direction) ||
                checkBoxCollisionAndMoveIfAvaliable(direction))
            return;

        switch (direction) {
            case RIGHT:
                gameObjects.getPlayer().move(FIELD_CELL_SIZE,0);
                break;
            case LEFT:
                gameObjects.getPlayer().move(-FIELD_CELL_SIZE,0);
                break;
            case DOWN:
                gameObjects.getPlayer().move(0, FIELD_CELL_SIZE);
                break;
            case UP:
                gameObjects.getPlayer().move(0, -FIELD_CELL_SIZE);
                break;
            default:
                break;
        }

        checkCompletion();


    }
    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall:
                gameObjects.getWalls()) {
            if (gameObject.isCollision(wall,direction)){
                return true;
            }
        }
        return false;
    }
    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction){
        for (Box box1:
             gameObjects.getBoxes()) {

            if (gameObjects.getPlayer().isCollision(box1,direction)) {
                //проверим на стену полсе ящика
                if (checkWallCollision(box1, direction)) {
                    return true;
                }
                //проерим на 2 ящика подрят
                for (Box box2 :
                        gameObjects.getBoxes()) {
                    if (!box2.equals(box1) && box1.isCollision(box2, direction))
                        return true;
                }

                switch (direction) {
                    case RIGHT:
                        box1.move(FIELD_CELL_SIZE,0);
                        return false;
                    case LEFT:
                        box1.move(-FIELD_CELL_SIZE,0);
                        return false;
                    case DOWN:
                        box1.move(0, FIELD_CELL_SIZE);
                        return false;
                    case UP:
                        box1.move(0, -FIELD_CELL_SIZE);
                        return false;
                    default:
                        break;
                }

            }

        }
        return false;
    }
    public void checkCompletion(){
        Set<Home> homes = new HashSet<>(getGameObjects().getHomes());

        for (Box box :
                gameObjects.getBoxes()) {
            homes.removeIf(home -> home.getX() == box.getX() && home.getY() == box.getY());
        }
        if (homes.isEmpty())
            eventListener.levelCompleted(currentLevel);
    }

    //endregion
}
