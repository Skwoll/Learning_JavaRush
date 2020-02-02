package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.GameObject;
import com.javarush.task.task34.task3410.model.Home;
import com.javarush.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    View view;
    EventListener eventListener;

    //region Methods
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,view.getWidth(),view.getHeight());

        for (GameObject o :
                view.getGameObjects().getAll()) {
            o.draw(g);
        }

    }
    //endregion


    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    //region Constructors
    public Field(View view) {
        this.view = view;
    }
    //endregion
}
