package com.javarush.task.task06.task0602;

/* 
Пустые кошки, пустые псы
Требования:
1. В классе Cat должен быть void метод finalize.
2. В классе Dog должен быть void метод finalize.
3. В классах Cat и Dog не должно быть конструкторов или должны быть конструкторы без параметров.
4. Метод finalize класса Cat должен выводить на экран "Cat was destroyed".
5. Метод finalize класса Dog должен выводить на экран "Dog was destroyed".
*/

public class Cat {
    public static void main(String[] args) {

    }

    //напишите тут ваш код

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    //напишите тут ваш код

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
