package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
Требования:
1. Объяви переменную коллекции HashMap с типом элементов String, String и сразу проинициализируй ee.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна добавлять в коллекцию 10 пар строк, согласно условию.
4. Программа должна выводить содержимое коллекции на экран, каждую пару через дефис и с новой строки.
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> hm = new HashMap<>();
        hm.put("арбуз" , "ягода");
        hm.put("банан" , "трава");
        hm.put("вишня" , "ягода");
        hm.put("груша" , "фрукт");
        hm.put("дыня" , "овощ");
        hm.put("ежевика" , "куст");
        hm.put("жень-шень" , "корень");
        hm.put("земляника" , "ягода");
        hm.put("ирис" , "цветок");
        hm.put("картофель" , "клубень");
        hm.forEach((s, s2) -> System.out.println(s.toString()+" - "+s2.toString()));
    }
}
