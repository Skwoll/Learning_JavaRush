package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        String name1 = s.next(),
                name2 = s.next();

        if (name1.equals(name2)) {
            System.out.println("Имена идентичны");
        }
        else
            if (name1.length()==name2.length()) {
                System.out.println("Длины имен равны");
            }

    }
}
