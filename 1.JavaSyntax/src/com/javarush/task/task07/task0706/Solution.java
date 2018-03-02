package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/* 
Улицы и дома

Требования:
1. Программа должна создавать массив на 15 целых чисел.
2. Программа должна считывать числа для массива с клавиатуры.
3. Программа должна вывести сообщение "В домах с нечетными номерами проживает больше жителей.", если сумма нечетных элементов массива больше суммы четных.
4. Программа должна вывести сообщение "В домах с четными номерами проживает больше жителей.", если сумма четных элементов массива больше суммы нечетных.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] values = new int[15];
        Random r = new Random();
        Scanner s = new Scanner(new InputStreamReader(System.in));
        int even = 0, odd = 0;

        for (int i = 0; i < values.length; i++) {
            values[i] = s.nextInt();
        }

        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0){
                even += values[i];
            }
            else{
                odd += values[i];
            }
        }

        if (even >= odd){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");

        }

    }
}
