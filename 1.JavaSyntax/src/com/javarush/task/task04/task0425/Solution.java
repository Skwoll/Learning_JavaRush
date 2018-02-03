package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int a = s.nextInt(), b = s.nextInt();
        int r = 1;

        if (a>0 && b>0){
            r= 1;
        }else if (a<0&&b>0){
            r=2;
        }else if (a<0&&b<0){
            r=3;
        }else if (a>0&&b<0){
            r=4;
        }
        System.out.println(r);
    }
}
