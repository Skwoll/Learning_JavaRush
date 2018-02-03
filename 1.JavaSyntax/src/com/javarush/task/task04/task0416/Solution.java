package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double d = new Scanner(new InputStreamReader(System.in)).nextDouble() % 5;
        String r ;
        if (d >= 0 && d < 3)
            r = "зелёный";
        else if (d >=3 && d < 4)
            r = "жёлтый";
        else
            r = "красный";

        System.out.println(r);

    }
}