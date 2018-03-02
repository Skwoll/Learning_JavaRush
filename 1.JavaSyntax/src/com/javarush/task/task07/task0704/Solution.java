package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Переверни массив
Требования:
1. Программа должна создавать массив на 10 целых чисел.
2. Программа должна считывать числа для массива с клавиатуры.
3. Программа должна выводить 10 строчек, каждую с новой строки.
4. Массив должен быть выведен на экран в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner s = new Scanner(new InputStreamReader(System.in));
        int[] values = new int[10];
        for (int i = 0; i < 10; i++) {
            values[i] = s.nextInt();
        }

        for (int i = 9; i >= 0; i--) {
            System.out.println(values[i]);
        }
    }
}

