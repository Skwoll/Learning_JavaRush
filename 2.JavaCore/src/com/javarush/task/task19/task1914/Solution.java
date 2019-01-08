package com.javarush.task.task19.task1914;

/* 
Решаем пример
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream =  System.out;
        ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
        PrintStream arrayOutStream = new PrintStream(arrayOut);
        System.setOut(arrayOutStream);
        testString.printSomething();
        System.setOut(consoleStream);
        String[] values = arrayOut.toString().split(" ");
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[2]);
        int c = 0;
        switch (values[1]){
            case "+" :
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
        }
        System.out.printf("%s %s %s = %s",a,values[1],b,c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

