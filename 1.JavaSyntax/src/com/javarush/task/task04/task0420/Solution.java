package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        List<Integer> list = new ArrayList<Integer>(); //обявление списка
        Scanner s = new Scanner(new InputStreamReader(System.in));
        list.add(s.nextInt());
        list.add(s.nextInt());
        list.add(s.nextInt());
        list.sort((o1, o2) -> o2.compareTo(o1));//сортировка по убыванию

        list.forEach(value -> System.out.print(value+ " "));
    }
}
