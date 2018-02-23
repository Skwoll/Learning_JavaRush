package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
Требования:
1. У класса Cat должна быть переменная name с типом String.
2. У класса Cat должна быть переменная age с типом int.
3. У класса Cat должна быть переменная weight с типом int.
4. У класса Cat должна быть переменная address с типом String.
5. У класса Cat должна быть переменная color с типом String.
6. У класса должен быть конструктор, принимающий в качестве параметра имя, но инициализирующий все переменные класса, кроме адреса.
7. У класса должен быть конструктор, принимающий в качестве параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
8. У класса должен быть конструктор, принимающий в качестве параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
9. У класса должен быть конструктор, принимающий в качестве параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
10. У класса должен быть конструктор, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
*/

public class Cat {
    //напишите тут ваш код
    private int age;
    private int weight;
    private String name;
    private String address;
    private String color;

    public Cat (String name){
        this.name = name;
        this.weight = 2;
        this.age = 3;
        this.color = "Gray";
    }

    public Cat (String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Gray";
    }

    public Cat (String name,  int age){
        this.name = name;
        this.weight = 2;
        this.age = age;
        this.color = "Gray";
    }

    public Cat (int weight, String color){
        this.weight = weight;
        this.color = color;
        this.age = 3;
    }

    public Cat ( int weight, String color,  String address){
        this.address = address;
        this.weight = weight;
        this.age = 3;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
