package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    public LevelLoader(Path levels) {
    }
    public GameObjects getLevel(int level){
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        Player player = new Player(100,100);
        boxes.add(new Box(50, 50));
        homes.add(new Home(90, 90));
        walls.add(new Wall(10, 10));
        walls.add(new Wall(10, 30));
        walls.add(new Wall(10, 50));

        return new GameObjects(walls,boxes,homes,player);

    }
}
