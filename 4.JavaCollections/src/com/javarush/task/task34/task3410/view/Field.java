package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.Home;
import com.javarush.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    View view;
    EventListener eventListener;

    //region Methods
    public void paint(Graphics g) {
        new Box(300,10).draw(g);
        new Player(50,50).draw(g);
        new Home(100,100).draw(g);

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
