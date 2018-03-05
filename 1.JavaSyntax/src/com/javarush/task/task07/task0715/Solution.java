package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Объяви переменную типа список строк и сразу проинициализируй ee.
3. Добавь в список слова: «мама», «мыла», «раму».
4. После каждого слова добавь в список строку, содержащую слово «именно».
5. Выведи элементы списка на экран, каждый с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> v = new ArrayList<>();
        Collections.addAll(v, "мама", "мыла", "раму");
        v.add("именно");
        v.add(2,"именно");
        v.add(1,"именно");

        v.forEach(System.out::println);
    }
}
