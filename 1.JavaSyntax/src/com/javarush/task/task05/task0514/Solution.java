package com.javarush.task.task05.task0514;

/* 
Программист создает человека
Требования:
1. Класс Solution должен содержать класс Person.
2. У класса Person должна быть переменная name с типом String.
3. У класса Person должна быть переменная age с типом int.
4. У класса Person должен быть метод initialize, принимающий в качестве параметра имя, возраст и инициализирующий соответствующие переменные класса.
5. Необходимо создать объект типа Person.
6. Необходимо вызвать метод initialize у созданного объекта и передать в него какие-либо параметры.
*/

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код

        Person person = new Person();

        person.initialize("name1",25);
    }

    static class Person {
        //напишите тут ваш код
        private int age;
        private String name;

        public void initialize (String name, int age){
            this.age = age;
            this.name = name;
        }
    }
}
