package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String r ="";
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int a = s.nextInt();
        if (a==0){
            r= "ноль";
        }
        else {
            if (a<0)
                r = "отрицательное ";
            else
                r= "положительное ";

            if (a % 2 == 0)
                r+= "четное число";
            else
                r+= "нечетное число";
        }

        System.out.println(r);
    }
}
