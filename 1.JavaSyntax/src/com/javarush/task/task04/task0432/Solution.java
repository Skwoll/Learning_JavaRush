package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));
        String row = s.next();
        int n = s.nextInt();
        int i=0;
        while (i<n){
            System.out.println(row);
            i++;
        }


    }
}
