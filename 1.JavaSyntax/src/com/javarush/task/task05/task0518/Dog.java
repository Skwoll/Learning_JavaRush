package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
Требования:
1. У класса Dog должна быть переменная name с типом String.
2. У класса Dog должна быть переменная height с типом int.
3. У класса Dog должна быть переменная color с типом String.
4. У класса должен быть конструктор, принимающий в качестве параметра имя и инициализирующий соответствующую переменную класса.
5. У класса должен быть конструктор, принимающий в качестве параметров имя, рост и инициализирующий соответствующие переменные класса.
6. У класса должен быть конструктор, принимающий в качестве параметров имя, рост, цвет и инициализирующий соответствующие переменные класса.
*/


public class Dog {
    //напишите тут ваш код
    private String name;
    private int height;
    private String color;

    public Dog (String name, int height, String color){
        this.color = color;
        this.height = height;
        this.name = name;
    }
    public Dog (String name, int height){
        this.height = height;
        this.name = name;
    }
    public Dog (String name){
        this.name = name;
    }



    public static void main(String[] args) {

    }
}
