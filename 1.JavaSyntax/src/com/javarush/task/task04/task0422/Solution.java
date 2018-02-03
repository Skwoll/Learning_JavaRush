package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner s = new Scanner(new InputStreamReader(System.in));
        String name  = s.next();
        int age = s.nextInt();

        if (age < 18 ){
            System.out.println("Подрасти еще");
        }
    }
}
