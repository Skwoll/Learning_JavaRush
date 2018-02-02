package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int a = s.nextInt();
        String r ="";

        if (a % 2 == 0 )
            r= "четное ";
        else
            r="нечетное ";

        if (a / 100 >=1)
            r+="трехзначное число";

        if (a / 10 >=1 && a/ 100 <1)
            r+="двузначное число";

        if (a / 10 <1 && a/100 <1)
            r+="однозначное число";


        if (a>=1 && a<=999)
            System.out.println(r);
    }
}
