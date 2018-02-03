package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner s = new Scanner(new InputStreamReader(System.in));

        String name = s.next();
        int y = s.nextInt(),m = s.nextInt(),d = s.nextInt();

        System.out.printf("Меня зовут %s.\n" +
                "Я родился %d.%d.%d",name,d,m,y);


    }
}
