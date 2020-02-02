package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject {
    //region Methods
    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.drawOval(getX()-getWidth()/2,getY()-getHeight()/2,getWidth(),getHeight());
    }
    //endregion

    //region Constructors
    public Home(int x, int y) {
        super(x, y,2,2);
    }
    //endregion
}
