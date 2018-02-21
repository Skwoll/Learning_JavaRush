package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner sr = new Scanner(new BufferedInputStream(System.in));

        int current;
        float result =0;
        List<Integer> values = new ArrayList<Integer>();

        while (true){
            current = sr.nextInt();
            if (current == -1) break;

            values.add(current);
        }

        for (int i : values) {
            result+= i;
        }

        System.out.println(result / (float)values.size() );

    }
}

