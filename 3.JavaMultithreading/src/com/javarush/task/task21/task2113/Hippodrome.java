package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        game.run();
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
        printWinner();

    }
    public void move(){
        horses.forEach(Horse::move);

    }
    public void print(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        horses.forEach(Horse::print);

    }

    public Horse getWinner(){
        return Collections.max(horses, (o1, o2) -> (int) (o1.getDistance() - o2.getDistance()));
    }
    public void printWinner(){
        System.out.println(String.format("Winner is %s!",getWinner().getName()));
    }
    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
}
