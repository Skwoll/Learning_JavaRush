package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private int age;
        private String address;
        private Human parent1;
        private Human parent2;

        public Human(String firstName, String lastName, int age, String address, Human parent1, Human parent2) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName, String address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
        }

        public Human(String firstName, String lastName, int age, String address) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;

            this.address = address;
        }

        public Human(String firstName, String lastName, int age, String address, Human parent1) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
            this.parent1 = parent1;
        }

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(String firstName, String lastName, int age, Human parent1) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.parent1 = parent1;
        }

        public Human(String firstName, String lastName, Human parent1) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.parent1 = parent1;
        }

        public Human(String firstName, String lastName, Human parent1, Human parent2) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.parent1 = parent1;
            this.parent2 = parent2;
        }
    }
}
