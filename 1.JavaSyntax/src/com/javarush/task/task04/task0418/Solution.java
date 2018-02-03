package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = new Scanner(new InputStreamReader(System.in)).nextInt();
        int b = new Scanner(new InputStreamReader(System.in)).nextInt();

        if (a < b){
            System.out.println(a);
        }
        else {
            System.out.println(b);
        }
    }
}