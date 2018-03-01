package com.javarush.task.task06.task0622;

import sun.swing.BakedArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Числа по возрастанию

Требования:
1. Программа должна считывать 5 чисел с клавиатуры.
2. Программа должна выводить 5 чисел, каждое с новой строки.
3. Выведенные числа должны быть отсортированы по возрастанию.
4. Вывод должен содержать те же числа, что и были введены (порядок не важен).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        String buffer;
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            buffer = reader.readLine();
            values.add( Integer.parseInt(buffer));
        }

        values.sort((o1, o2) -> o1.compareTo(o2));

        values.forEach(System.out::println);

    }
}
