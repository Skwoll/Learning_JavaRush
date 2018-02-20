package com.javarush.task.task05.task0505;

/* 
Кошачья бойня
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat[] cats = new Cat[3];

        for (int i = 0; i < cats.length ; i++) {
            cats[i] = new Cat("Cat"+i, new Random().nextInt(15)+1
                                           , new Random().nextInt(8)+1
                                           , new Random().nextInt(60)+1);
        }

        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i].fight(cats[i == cats.length - 1 ? 0 : i+1]));

        }
    }

    public static class Cat {
        protected String name;
        protected int age;
        protected int weight;
        protected int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            int agePlus = this.age > anotherCat.age ? 1 : 0;
            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;

            int score = agePlus + weightPlus + strengthPlus;
            return score > 2; // return score > 2 ? true : false;
        }
    }
}
