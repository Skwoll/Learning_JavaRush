package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. У класса Rectangle должны быть переменные top, left, width и height с типом int.
3. У класса должен быть хотя бы один метод initialize.
4. У класса должно быть хотя бы два метода initialize.
5. У класса должно быть хотя бы три метода initialize.
6. У класса должно быть хотя бы четыре метода initialize.
*/

public class Rectangle {
    //напишите тут ваш код
    private int top, left, width , height;

    public static void main(String[] args) {

    }

    public void initialize (int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize (int top, int left){
        this.top = top;
        this.left = left;
        this.width = 0;
        this.height = 0;
    }

    public void initialize (int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }

    public void initialize (Rectangle r){
        this.top = r.top;
        this.left = r.left;
        this.width = r.width;
        this.height = r.height;
    }
}
