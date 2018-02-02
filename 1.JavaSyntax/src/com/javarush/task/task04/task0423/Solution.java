package com.javarush.task.task04.task0423;

/* 
Фейс-контроль
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));

        String name = s.next();
        int age = s.nextInt();

        if (age >20){
            System.out.println("И 18-ти достаточно");
        }
    }
}
