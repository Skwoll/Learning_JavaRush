package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Общение одиноких массивов
Требования:
1. Программа должна создавать массив на 10 строк.
2. Программа должна создавать массив на 10 целых чисел.
3. Программа должна считывать строки для массива с клавиатуры.
4. Программа должна в массив чисел записать длины строк из массива строк, а затем их вывести на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] intValues = new int[10];
        String[] stringValues = new String[10];

        Scanner s = new Scanner(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            intValues[i] =(stringValues[i]=s.nextLine()).length();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(intValues[i]);
        }

    }
}
