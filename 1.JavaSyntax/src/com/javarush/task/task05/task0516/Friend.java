package com.javarush.task.task05.task0516;

/* 
Друзей не купишь
Требования:
1. У класса Friend должна быть переменная name с типом String.
2. У класса Friend должна быть переменная age с типом int.
3. У класса Friend должна быть переменная sex с типом char.
4. У класса должен быть конструктор, принимающий в качестве параметра имя и инициализирующий соответствующую переменную класса.
5. У класса должен быть конструктор, принимающий в качестве параметров имя, возраст и инициализирующий соответствующие переменные класса.
6. У класса должен быть конструктор, принимающий в качестве параметров имя, возраст, пол и инициализирующий соответствующие переменные класса.
*/

public class Friend {
    //напишите тут ваш код
    private String name;
    private int age;
    private char sex;

    public Friend(String name, int age, char sex){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }
    public Friend(String name, int age){
        this.age = age;
        this.name = name;
    }
    public Friend(String name){
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
