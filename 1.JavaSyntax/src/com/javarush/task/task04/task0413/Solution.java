package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String s = "";
        int i = new Scanner(new InputStreamReader(System.in)).nextInt();
        switch(i){
            case 1:  s = "понедельник";
            break;
            case 2: s = "вторник";
            break;
            case 3: s = "среда";
            break;
            case 4: s = "четверг";
            break;
            case 5: s = "пятница";
            break;
            case 6: s = "суббота";
            break;
            case 7: s = "воскресенье";
            break;
            default: s = "такого дня недели не существует";
                    break;
        }
        System.out.println(s);
    }
}