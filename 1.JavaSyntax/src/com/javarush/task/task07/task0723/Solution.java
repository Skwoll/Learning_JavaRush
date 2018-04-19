package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Программа должна выводить обратный отсчет от 30 до 0. Каждую цифру на новой строке.
3. Программа должна выводить "Бум!" после отсчета.
4. Программа должна использовать метод "Thread.sleep(100);" 31 раз.
*/

import static java.lang.Thread.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        for (int i = 30; i >= 0; i--) {
            System.out.println(i);

            //напишите тут ваш код
            Thread.sleep(100);
        }

        System.out.println("Бум!");

    }
}
