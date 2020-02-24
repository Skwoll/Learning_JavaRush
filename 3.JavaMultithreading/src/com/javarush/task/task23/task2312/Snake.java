package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }
    public void move(){
        if (!isAlive)
            return;

        switch (direction) {
            case UP:
                move(0,-1);
                break;
            case DOWN:
                move(0, 1);
                break;
            case LEFT:
                move(-1, 0);
                break;
            case RIGHT:
                move(1, 0);
                break;
        }

    }
    public void move(int x, int y){
        SnakeSection head = new SnakeSection(sections.get(0).getX()+x, sections.get(0).getY()+y);
        checkBorders(head);
        checkBody(head);
        if (isAlive){
           sections.add(0,head);
           if (Room.game.getMouse().getX() == head.getX() && Room.game.getMouse().getY()==head.getY()){
               Room.game.eatMouse();
           }else {
               sections.remove(sections.size() - 1);
           }
        }
    }
    public int getX(){
        return sections.get(0).getX();
    }
    public int getY(){
        return sections.get(0).getY();
    }
    public void checkBorders(SnakeSection head){
        if (head.getX()<0 || head.getX()>=Room.game.getWidth()|| head.getY()<0 || head.getY()>= Room.game.getHeight())
            isAlive = false;
    }
    public void checkBody(SnakeSection head){
        if (sections.contains(head)){
            isAlive = false;
        }
    }
}
