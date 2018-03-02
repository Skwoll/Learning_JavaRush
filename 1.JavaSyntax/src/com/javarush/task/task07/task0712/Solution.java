package com.javarush.task.task07.task0712;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Самые-самые
Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
*/

public class Solution {
    static boolean printed = false;
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        ArrayList<String> l = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            l.add(s.nextLine());
        }

        int maxLen = Collections.max(l, (o1, o2) -> o1.length() > o2.length() ? 1 : -1).length();
        int minLen = Collections.min(l, (o1, o2) -> o1.length() > o2.length() ? 1 : -1).length();


        l.forEach(s1 -> {
            if (s1.length() == maxLen && !printed) {
                System.out.println(s1);
                printed = true;
            }
            if (s1.length() == minLen && !printed) {
                System.out.println(s1);
                printed = true;
            }
            return ;});
    }
}
