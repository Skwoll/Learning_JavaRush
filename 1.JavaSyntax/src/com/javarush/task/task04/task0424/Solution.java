package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int a = s.nextInt(), b = s.nextInt(), c = s.nextInt();
        if (!(a != b && b!=c && a!=c)&&!(a==b && c==b)) {
            if (a==b){
                System.out.println("3");
            }
            else if (a==c){
                System.out.println("2");
            }
            else {
                System.out.println("1");

            }
        }

    }
}
