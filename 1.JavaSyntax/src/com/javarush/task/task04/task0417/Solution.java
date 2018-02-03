package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner s = new Scanner(new InputStreamReader(System.in));

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        if (a == b || a == c)
            System.out.print(a+" ");

        if (b == a || b==c)
            System.out.print(b+" ");
        if (c==a || c==b)
            System.out.print(c+" ");

    }
}