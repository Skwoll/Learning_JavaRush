package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses= new ArrayList<>();
    public static void main(String[] args) {
        List<Horse> tmpHorses = new ArrayList<>();
        tmpHorses.add(new Horse("Apple", 3d, 0d));
        tmpHorses.add(new Horse("Blueberry", 3d, 0d));
        tmpHorses.add(new Horse("Marshmallow", 3d, 0d));
        game = new Hippodrome(tmpHorses);
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void move(){

    }
    public void print(){
        
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
}
