package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самая длинная строка
Требования:
1. Инициализируй поле класса новым ArrayList<>
2. Программа должна считывать 5 строк с клавиатуры и записывать их в список strings.
3. Программа должна выводить самую длинную строку на экран.
4. Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    private static List<String> strings  = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
      //  ArrayList<String> strings;
        //Введм данные с клавиатуры
        for (int i = 0; i < 5; i++) {
            strings.add(s.nextLine());
        }

        //Определим самую длинную строку в списке и сохраним её доину (привет лямбда)
        int len = Collections.max(strings,(o1, o2) -> o1.length() > o2.length()?1:0).length();

        //выведем все строки для которых равна максимальной
        strings.forEach(s1 -> {
            if (s1.length() == len) {
                System.out.println(s1);
            } return; });
    }
}
