package com.javarush.task.task08.task0823;

import sun.text.resources.cldr.ia.FormatData_ia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать строку с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        StringBuffer out = new StringBuffer();

        if (s.length()>0)
            out.append(Character.toUpperCase(s.charAt(0)));

        for (int i = 1; i < s.length(); i++)
            out.append (s.charAt(i - 1) == ' ' ? Character.toUpperCase(s.charAt(i)) : s.charAt(i));

        System.out.println(out);
    }
}
