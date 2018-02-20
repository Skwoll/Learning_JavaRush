package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        List<Cat> cats = new ArrayList<Cat>();

        for (int i = 1; i <= 3 ; i++) {
            cats.add(new Cat("Cat"+i, new Random().nextInt(),new Random().nextInt(),new Random().nextInt()));
        }
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}