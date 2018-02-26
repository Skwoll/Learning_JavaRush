package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
Требования:
1. У класса должно быть хотя бы три переменные.
2. У класса должен быть конструктор по умолчанию.
3. У класса должен быть хотя бы один конструктор.
4. У класса должно быть хотя бы два конструктора.
5. У класса должно быть хотя бы три конструктора.
6. У класса должно быть хотя бы четыре конструктора.
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код

    public Circle(){
        this.x = 0;
        this.y = 0;
        this.radius = 10;
    }

    public Circle(double x, double y, double radius){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    public Circle(double x, double y){
        this.radius = 10;
        this.x = x;
        this.y = y;
    }
    public Circle(Circle circle){
        this.radius = circle.radius;
        this.x = circle.x;
        this.y = circle.y;
    }


    public static void main(String[] args) {

    }
}