package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    //напишите тут ваш код

    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertToSeconds(3));
        System.out.println(convertToSeconds(35));
    }
    public static int convertToSeconds(int hour)
    {
        return 60 * 60 * hour;
    }
}
