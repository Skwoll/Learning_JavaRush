package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
Требования:
1. У класса Rectangle должны быть переменные top, left, width и height с типом int.
2. У класса должен быть хотя бы один конструктор.
3. У класса должно быть хотя бы два конструктора.
4. У класса должно быть хотя бы три конструктора.
5. У класса должно быть хотя бы четыре конструктора.

*/


public class Rectangle {
    //напишите тут ваш код

    private int top, left, width, height;

    public Rectangle(int top, int left, int width, int height){
        this.height = height;
        this.left = left;
        this.top = top;
        this.width = width;
    }
    public Rectangle(int top, int left){
        this.height = 0;
        this.left = left;
        this.top = top;
        this.width = 0;
    }
    public Rectangle(int top, int left, int width){
        this.height = width;
        this.left = left;
        this.top = top;
        this.width = width;
    }
    public Rectangle(Rectangle r){
        this.height = r.height;
        this.left = r.left;
        this.top = r.top;
        this.width = r.width;
    }

    public static void main(String[] args) {

    }
}
