package com.javarush.task.task03.task0325;


import java.io.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String money =  new BufferedReader(new InputStreamReader(System.in)).readLine();

        System.out.printf("Я буду зарабатывать $%s в час \n",money);
    }
}
