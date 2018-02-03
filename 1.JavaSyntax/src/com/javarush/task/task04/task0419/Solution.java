package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код


        Scanner sc = new Scanner( new InputStreamReader(System.in));
        Integer[] age = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};

        List list = Arrays.asList(age);

        System.out.println(Collections.max(list));


    }
}
