package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 0, b =0;

        while (a<10){
            b= 0;
            while (b<9){
                System.out.print("S");
                b++;
            }
            System.out.println("S");
            a++;
        }

    }
}
