package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<>();
        Scanner s = new Scanner(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(s.nextLine());
        }

        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        result.forEach(System.out::println);
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        ArrayList<String> result = new ArrayList<>();

        for (String s :
                list) {
            result.add(s);
            result.add(s);
        }
        return result;
    }
}
