package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код

        if (this.age+this.strength+this.weight > anotherCat.weight+anotherCat.age+anotherCat.strength) return true;
        else return false;



    }

    public static void main(String[] args) {

    }
}
