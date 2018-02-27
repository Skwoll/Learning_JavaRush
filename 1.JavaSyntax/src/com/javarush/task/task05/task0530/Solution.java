package com.javarush.task.task05.task0530;

import java.io.*;

/* 
Шеф, что-то не пашет
Требования:
1. Программа должна считывать числа с клавиатуры.
2. В классе должен быть только один метод main.
3. Программа должна выводить строку, которая начинается на "Sum = ".
4. Программа должна выводить строку, которая заканчивается суммой введенных чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine().toString());
        int b = Integer.parseInt(reader.readLine().toString());

        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
