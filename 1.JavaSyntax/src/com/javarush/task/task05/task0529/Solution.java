package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp;
        int result = 0;

        while (true) {
            tmp = br.readLine();
            if (tmp.equals("сумма")) {
                System.out.println(result);
                break;
            }
            else {
                result += Integer.parseInt(tmp);
            }
        }
    }
}
