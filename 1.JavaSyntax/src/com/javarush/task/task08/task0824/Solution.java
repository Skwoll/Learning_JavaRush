package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grentMother = new Human();
        Human grentFather = new Human();
        Human grentMother2 = new Human();
        Human grentFather2 = new Human();
        Human mother = new Human();
        Human father = new Human();
        Human child1 = new Human();
        Human child2 = new Human();
        Human child3 = new Human();

        child1.age = 1;
        child1.name = "Child1";
        child1.sex = true;

        child2.age = 3;
        child2.name = "Child2";
        child2.sex = true;

        child3.age = 5;
        child3.name = "Child3";
        child3.sex = true;

        mother.age = 35;
        mother.name = "Mother";
        mother.sex = false;
        mother.children.add(child1);
        mother.children.add(child3);
        mother.children.add(child2);


        father.age = 37;
        father.name = "Father";
        father.sex = true;
        father.children = mother.children;

        grentMother.name = "GrentMother";
        grentMother.age = 60;
        grentMother.sex = false;
        grentMother.children.add(mother);

        grentFather.name = "GrentFather";
        grentFather.age = 58;
        grentFather.sex = true;
        grentFather.children.add(mother);

        grentMother2.name = "GrentMother2";
        grentMother2.age = 60;
        grentMother2.sex = false;
        grentMother2.children.add(father);

        grentFather2.name = "GrentFather2";
        grentFather2.age = 58;
        grentFather2.sex = true;
        grentFather2.children.add(father);

        System.out.println(grentFather.toString());
        System.out.println(grentMother.toString());
        System.out.println(grentFather2.toString());
        System.out.println(grentMother2.toString());
        System.out.println(mother.toString());
        System.out.println(father.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children =new ArrayList<>();


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
