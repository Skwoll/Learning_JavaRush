package com.javarush.task.task34.task3410.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;

    //region Constructors
    public GameObjects(Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
    }
    //endregion


    //region Methods
    public Set<GameObject> getAll(){
        Set<GameObject> objects = new HashSet<>();
        objects.addAll(walls);
        objects.addAll(boxes);
        objects.addAll(homes);
        objects.add(player);
        return objects;
    }
    //endregion

    //region Properties

    public Set<Wall> getWalls() {
        return walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public Player getPlayer() {
        return player;
    }

    //endregion
}
