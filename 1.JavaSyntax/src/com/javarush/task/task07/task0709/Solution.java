package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Выражаемся покороче

Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры и записывать их в список.
3. Программа должна выводить самую короткую строку на экран.
4. Если есть несколько строк с длиной равной минимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        ArrayList<String> l = new ArrayList<String>();
        //Введм данные с клавиатуры
        for (int i = 0; i < 5; i++) {
            l.add(s.nextLine());
        }

        //Определим самую длинную строку в списке и сохраним её доину (привет лямбда)
        int len = Collections.min(l,(o1, o2) -> o1.length() > o2.length()?1:-1).length();

        //выведем все строки для которых равна максимальной
        l.forEach(s1 -> {
            if (s1.length() == len) {
                System.out.println(s1);
            } return; });
    }
}
