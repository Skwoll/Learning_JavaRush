package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/* 
Один большой массив и два маленьких
Требования:
1. Программа должна создавать большой массив на 20 целых чисел.
2. Программа должна считывать с клавиатуры 20 чисел для большого массива.
3. Программа должна создавать два маленьких массива на 10 чисел каждый.
4. Программа должна скопировать одну половину большого массива в первый маленький, а вторую - во второй и вывести его на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));

        int bigValues[] = new int[20];
        int smallValues1[] = new int[10];
        int smallValues2[] = new int[10];

        for (int i = 0; i < 20; i++) {
            bigValues[i] = s.nextInt();
        }
        smallValues1 = Arrays.copyOfRange(bigValues, 0, bigValues.length/2 );
        smallValues2 = Arrays.copyOfRange(bigValues, bigValues.length/2, bigValues.length);

        for (int i = 0; i < smallValues2.length; i++) {
            System.out.println(smallValues2[i]);
        }
    }
}
