package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertEurToUsd(30,1.1));
        System.out.println(convertEurToUsd(50,1.05));
    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        double r = eur * course;
        return r;

    }
}
