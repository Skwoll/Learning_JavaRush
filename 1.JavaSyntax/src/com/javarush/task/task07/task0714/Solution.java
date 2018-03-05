package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Слова в обратном порядке
Требования:
1. Объяви переменную типа ArrayList (список строк) и сразу проинициализируй ee.
2. Считай 5 строк с клавиатуры и добавь их в список.
3. Удали третий элемент массива.
4. Выведи элементы на экран, каждый с новой строки.
5. Порядок вывода должен быть обратный.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));

        ArrayList<String> v = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            v.add(s.nextLine());
        }
        v.remove(2);

        for (int i = v.size()-1; i >=0 ; i--) {
            System.out.println(v.get(i));
        }
    }
}


