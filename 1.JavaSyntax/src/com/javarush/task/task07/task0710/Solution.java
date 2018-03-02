package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
В начало списка

Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна добавлять строки в начало списка.
4. Программа должна выводить список на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> l = new ArrayList<>();
        Scanner s = new Scanner(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            l.add(0, s.nextLine());
        }

        l.forEach(System.out::println);
    }
}
