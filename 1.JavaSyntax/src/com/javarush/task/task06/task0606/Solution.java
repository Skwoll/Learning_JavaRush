package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
Требования:
1. Программа должна считывать данные с клавиатуры.
2. Метод main должен посчитать сколько четных цифр во веденном числе и записать это количество в переменную even.
3. Метод main должен посчитать сколько нечетных цифр во веденном числе и записать это количество в переменную odd.
4. Программа должна выводить текст на экран.
5. Выведенный текст должен соответствовать заданию.
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        String s = new Scanner(new InputStreamReader(System.in)).next();

        for (int i =0; i< s.length();i++) {
            if (Integer.valueOf( s.charAt(i)) % 2 == 0){
                even += 1;
            }
            else {
                odd += 1;
            }
        }


        System.out.printf("Even: %d Odd: %d", even, odd);
    }
}
