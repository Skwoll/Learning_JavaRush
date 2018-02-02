package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = new Scanner(new InputStreamReader(System.in)).nextInt();

        if (i<0)
            i+=1;
        else
            if (i>0)
                i*=2;
        System.out.println(i);




    }

}