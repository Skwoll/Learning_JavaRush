package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Удалить и вставить
Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Программа должна выводить список на экран, каждое значение с новой строки.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        ArrayList<String> l = new ArrayList<>();
        String buff;

        for (int i = 0; i < 5; i++) {
            l.add(s.nextLine());
        }

        for (int i = 0; i < 13; i++) {
            buff = l.get(4);
            l.remove(4);
            l.add(0, buff);
        }

        l.forEach(System.out::println);
    }
}
