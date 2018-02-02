package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int a, p = 0, n=0;

        for (int i = 0; i <3 ; i++) {
            a= s.nextInt();
            if (a!=0)
                if (a>0) p+=1;
                else n+=1;
        }
        System.out.printf("количество отрицательных чисел: %d \nколичество положительных чисел: %d",n,p);
    }
}
