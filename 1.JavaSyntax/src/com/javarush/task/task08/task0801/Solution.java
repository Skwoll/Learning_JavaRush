package com.javarush.task.task08.task0801;

/* 
HashSet из растений
Требования:
1. Объяви переменную коллекции HashSet с типом элементов String и сразу проинициализируй ee.
2. Программа не должна считывать строки с клавиатуры.
3. Программа должна добавлять в коллекцию 10 строк, согласно условию.
4. Программа должна выводить 10 строк из коллекции на экран, каждую с новой строки.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> hs = new HashSet<>();
        hs.add("арбуз");
        hs.add("груша");
        hs.add("дыня");
        hs.add("вишня");
        hs.add("банан");
        hs.add("ежевика");
        hs.add("женьшень");
        hs.add("земляника");
        hs.add("ирис");
        hs.add("картофель");

        hs.forEach(System.out::println);


    }
}
