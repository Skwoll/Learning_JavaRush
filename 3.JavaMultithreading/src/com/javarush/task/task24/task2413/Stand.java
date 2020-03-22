package com.javarush.task.task24.task2413;

public class Stand extends BaseObject{
    private double direction;
    private double speed;

    public double getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public void draw(Canvas canvas) {
        
    }

    @Override
    public void move() {

    }

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }
    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }
}
