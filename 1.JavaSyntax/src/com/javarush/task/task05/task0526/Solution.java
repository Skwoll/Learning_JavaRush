package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
Требования:
1. В классе Solution создай public static класс Man.
2. В классе Solution создай public static класс Woman.
3. Класс Man должен содержать переменные: name(String), age(int) и address(String).
4. Класс Woman должен содержать переменные: name(String), age(int) и address(String).
5. У классов Man и Woman должны быть конструкторы, принимающие параметры с типами String, int и String.
6. Конструкторы должны инициализировать переменные класса.
7. В методе main необходимо создать по два объекта каждого типа.
8. Метод main должен выводить созданные объекты на экран в указанном формате.
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Man1", 25,"address1");
        Man man2 = new Man("Man2", 27,"address2");
        Woman woman1 = new Woman("Woman1", 25,"address1");
        Woman Woman2 = new Woman("Woman2", 27,"address2");

        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
        System.out.println(Woman2.name + " " + Woman2.age + " " + Woman2.address);
    }

    //напишите тут ваш код
    public static class Man{
        String name;
        int age;
        String address;

        public Man (String name, int age, String address){
            this.address = address;
            this.name = name;
            this.age = age;
        }
    }
    public static class Woman{
        String name;
        int age;
        String address;

        public Woman (String name, int age, String address){
            this.address = address;
            this.name = name;
            this.age = age;
        }
    }

}
