package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is the 5 month".
Используйте коллекции.


Требования:
1. Программа должна считывать одно значение с клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна использовать коллекции.
4. Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        String input = s.next();

        HashMap<String,Integer> month = new HashMap<String, Integer>();

        for (int i = 1; i < 13 ; i++) {
            month.put(Month.of(i).toString(),i);
        }

        System.out.println(input+" is the "+month.get(input.toUpperCase())+" month");



    }
}
