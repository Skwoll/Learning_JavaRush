package com.javarush.task.task07.task0728;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* 
В убывающем порядке
Требования:
1. Программа должна считывать 20 целых чисел с клавиатуры.
2. Программа должна выводить 20 чисел.
3. В классе Solution должен быть метод public static void sort(int[] array).
4. Метод main должен вызывать метод sort.
5. Метод sort должен сортировать переданный массив по убыванию.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        Arrays.sort(array);
        //int[] tmp = new int[array.length];
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            // swap numbers
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;

            //array[array.length-1-i] ^= array[i] ^= array[array.length-1-i];
        }

    }
}

