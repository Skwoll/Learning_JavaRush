package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));

        String name = s.next();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s любит меня.\n",name);
        }
    }
}
