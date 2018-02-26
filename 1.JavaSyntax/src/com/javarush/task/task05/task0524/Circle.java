package com.javarush.task.task05.task0524;

/* 
Основа колеса
Требования:
1. У класса Circle должны быть переменные x, y и r с типом double.
2. У класса должен быть один конструктор.
3. Конструктор должен быть public.
4. Конструктор должен иметь три параметра типа double.
5. Конструктор должен проинициализировать все переменные класса.
*/

public class Circle {
    public double x;
    public double y;
    public double r;

    //напишите тут ваш код
    public Circle (double x, double y, double r){
        this.r = r;
        this.x = x;
        this.y = y;
    }
    public static void main(String[] args) {

    }
}
