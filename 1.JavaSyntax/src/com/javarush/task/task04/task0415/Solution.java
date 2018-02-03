package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = new Scanner(new InputStreamReader(System.in)).nextInt();
        int b = new Scanner(new InputStreamReader(System.in)).nextInt();
        int c = new Scanner(new InputStreamReader(System.in)).nextInt();

        if (a<(b+c) && b<(a+c)&&c<(a+b))
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");

    }
}