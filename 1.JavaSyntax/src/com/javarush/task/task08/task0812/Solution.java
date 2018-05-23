package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 
Cамая длинная последовательность
Требования:
1. Программа должна выводить число на экран.
2. Программа должна считывать значения с клавиатуры.
3. В методе main объяви переменную типа ArrayList с типом элементов Integer и сразу проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();

        Scanner s = new Scanner(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(s.nextInt());
        }

        int current = 1, max = 1;
        for (int i = 1 ; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i-1))){
                current++;
                max = current > max ? current : max;
            }
            else{
                current=1;
            }
        }

        System.out.println(max);

    }
}