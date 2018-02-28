package com.javarush.task.task06.task0612;

/* 
Калькулятор
Требования:
1. Метод plus должен возвращать сумму чисел a и b.
2. Метод minus должен возвращать разницу чисел a и b.
3. Метод multiply должен возвращать результат умножения числа a на число b.
4. Метод division должен возвращать результат деления числа a на число b.
5. Метод percent должен возвращать процент b из числа a.
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a + b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a - b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a * b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        return (double)a / (double) b;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        return (double) a * (double) b / 100;
    }

    public static void main(String[] args) {
    }
}