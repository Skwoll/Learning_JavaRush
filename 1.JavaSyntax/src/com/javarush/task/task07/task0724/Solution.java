package com.javarush.task.task07.task0724;

/* 
Семейная перепись
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.


 имя(String), пол(boolean), возраст(int), отец(Human), мать(Human)
*/


public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human h1 = new Human("Человек 1", true, 55);
        Human h2 = new Human("Человек 2", false, 57);
        Human h3 = new Human("Человек 3", false, 58);
        Human h4 = new Human("Человек 4", true, 60);
        Human h5 = new Human("Человек 5", true, 30, h1, h2 );
        Human h6 = new Human("Человек 6", false, 27, h4, h3 );
        Human h7 = new Human("Человек 7", true, 7, h5, h6 );
        Human h8 = new Human("Человек 8", false, 1, h5, h6 );
        Human h9 = new Human("Человек 9", true, 1, h5, h6 );


        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        System.out.println(h5);
        System.out.println(h6);
        System.out.println(h7);
        System.out.println(h8);
        System.out.println(h9);


    }
    public static class Human {
        //напишите тут ваш код
        String name;
        int age;
        boolean sex;
        Human father, mother;


        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex  = sex;
            this.age  = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex  = sex;
            this.age  = age;
            this.father = father;
            this.mother = mother;

        }
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















