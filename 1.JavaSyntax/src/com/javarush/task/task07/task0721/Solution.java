package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
Требования:
1. Создай массив целых чисел (int[]) на 20 элементов.
2. Считай с клавиатуры 20 целых чисел и добавь их в массив.
3. Найди и выведи через пробел максимальное и минимальное числа.
4. Используй цикл for.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] v = new int[20];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(reader.readLine());
        }

        maximum = v[0];
        minimum = v[0];

        for (int i = 0; i<v.length;i++) {
            if (v[i] > maximum) maximum = v[i];
            if (v[i] < minimum) minimum = v[i];
        }


        System.out.print(maximum + " " + minimum);
    }
}
