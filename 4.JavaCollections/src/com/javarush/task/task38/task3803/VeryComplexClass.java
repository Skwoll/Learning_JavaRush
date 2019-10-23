package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен всегда кидать Runtime исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен всегда кидать Runtime исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.


Требования:
1. Метод methodThrowsClassCastException класса veryComplexClass не должен использовать ключевое слово throw.
2. Метод methodThrowsNullPointerException класса veryComplexClass не должен использовать ключевое слово throw.
3. Метод methodThrowsClassCastException класса veryComplexClass должен бросать исключение ClassCastException.
4. Метод methodThrowsNullPointerException класса veryComplexClass должен бросать исключение NullPointerException.
*/

import java.io.ObjectInputStream;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object i = Integer.valueOf(5);
        String s  = (String) i;
    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.split(" ");

    }

    public static void main(String[] args) {

    }
}
