package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int r = 0, a;
        for (int i = 0; i <3 ; i++) {
            a = s.nextInt();
            if (a>0) r+=1;

        }
        System.out.println(r);


    }
}
