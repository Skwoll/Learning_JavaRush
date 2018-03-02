package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
Требования:
1. Программа не должна ничего считывать с клавиатуры.
2. Объяви переменную типа ArrayList (список строк) и сразу проинициализируй ee.
3. Программа должна добавить 5 любых строк в список.
4. Программа должна вывести размер списка на экран.
5. Программа должна вывести содержимое списка на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        ArrayList<String> values = new ArrayList<String>();
        values.add("String1");
        values.add("String2");
        values.add("String3");
        values.add("String4");
        values.add("String5");
        System.out.println(values.size());

        values.forEach(System.out::println);


    }
}
