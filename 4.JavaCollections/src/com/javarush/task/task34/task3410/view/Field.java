package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.*;
import com.javarush.task.task34.task3410.model.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Field extends JPanel {
    View view;
    EventListener eventListener;

    //region Methods
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,view.getWidth(),view.getHeight());

        if(view != null && view.getGameObjects() != null)
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
        addKeyListener( new KeyHandler());
        setFocusable(true);
    }
    //endregion
    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case VK_RIGHT:
                    eventListener.move(Direction.RIGHT);
                    break;
                case VK_LEFT:
                    eventListener.move(Direction.LEFT);
                    break;
                case VK_UP:
                    eventListener.move(Direction.UP);
                    break;
                case VK_DOWN:
                    eventListener.move(Direction.DOWN);
                    break;
                case VK_R:
                    eventListener.restart();
                    break;
                default:
                    break;
            }
        }
    }
}
