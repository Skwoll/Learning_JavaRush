package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {
    //region Constructors
    public Player(int x, int y) {
        super(x, y);
    }
    //endregion

    //region Methods
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(getX()-getWidth()/2,getY()-getHeight()/2,getWidth(),getHeight());
    }

    @Override
    public void move(int x, int y) {
        setX(getX()+x);
        setY(getY()+y);
    }
    //endregion
}
