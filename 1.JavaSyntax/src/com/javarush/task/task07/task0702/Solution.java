package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Массив из строчек в обратном порядке
Требования:
1. Программа должна создавать массив на 10 строк.
2. Программа должна считывать 8 строк для массива с клавиатуры.
3. Программа должна выводить 10 строк, каждую с новой строки.
4. Все строки массива (10 элементов) должны быть выведены в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        String[] values = new String[10];

        Scanner s = new Scanner(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            values[i] = s.nextLine();
        }
        for (int i = 9; i >= 0; i--) {
            System.out.println(values[i]);
        }
    }
}