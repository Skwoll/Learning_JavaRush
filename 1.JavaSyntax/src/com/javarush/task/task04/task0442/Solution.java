package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int i=0,res=0;
        while (true){
            i= s.nextInt();
            res +=i;
            if (i == -1) break;
        }
        System.out.println(res);
    }
}
