package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
Требования:
1. Добавь в класс Cat public статическую переменную cats (ArrayList).
2. Переменная cats должна быть проинициализирована.
3. Метод main должен создавать 10 объектов Cat (используй конструктор Cat()).
4. Метод main должен добавить всех созданных котов в переменную cats.
5. Метод printCats должен выводить всех котов из переменной cats на экран. Каждого с новой строки.
*/

public class Cat {
    //напишите тут ваш код
    static public ArrayList<Cat> cats = new ArrayList<Cat>();

    public Cat() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 10; i++) {
            Cat cat = new Cat();
            Cat.cats.add(cat);
        }
        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for (Cat c :
                Cat.cats) {
            System.out.println(c);

        }
    }
}
