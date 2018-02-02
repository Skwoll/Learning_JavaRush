package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int s;
        int i = new Scanner(new InputStreamReader(System.in)).nextInt();

        if (i % 4 ==0 )
            if ((i / 100) % 4 != 0 && i % 100 ==0 )
                s = 365;
            else
                s = 366;

        else
            s = 365;


        System.out.printf("количество дней в году: %d",s);


    }
}