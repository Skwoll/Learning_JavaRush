package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject {
    //region Constructors
    public Wall(int x, int y) {
        super(x, y);
    }
    //endregion

    //region Methods
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(getX()-getWidth()/2,getY()-getHeight()/2,getWidth(),getHeight());
    }
    //endregion
}
