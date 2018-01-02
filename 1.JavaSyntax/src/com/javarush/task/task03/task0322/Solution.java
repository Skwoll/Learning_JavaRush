package com.javarush.task.task03.task0322;


/* 
Большая и чистая
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name1 = br.readLine()
              ,name2 = br.readLine()
              ,name3 = br.readLine();
        System.out.println(name1+" + "+name2+" + " + name3 +" = Чистая любовь, да-да!");
    }
}