package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Играем в Jолушку
Требования:
1. Объяви и сразу проинициализируй 4 переменных типа ArrayList (список целых чисел). Первый список будет главным, а остальные - дополнительными.
2. Считать 20 чисел с клавиатуры и добавить их в главный список.
3. Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
4. Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
5. Добавить в третий дополнительный список все остальные числа из главного.
6. Метод printList должен выводить на экран все элементы переданного списка, каждый с новой строки.
7. Программа должна вывести три дополнительных списка, используя метод printList.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        ArrayList<Integer> v = new ArrayList<>();
        ArrayList<Integer> v3 = new ArrayList<>();
        ArrayList<Integer> vEven = new ArrayList<>();
        ArrayList<Integer> vOther = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            v.add(s.nextInt());
        }
        for (Integer i :
                v) {
            if (i % 3 == 0){
                v3.add(i);
            }
            if (i % 2 == 0){
                vEven.add(i);
            }
            if (i % 2 != 0 && i % 3 != 0) {
                vOther.add(i);
            }
        }

        printList(v3);
        printList(vEven);
        printList(vOther);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        list.forEach(System.out::println);
    }
}
