package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

/* 
Самые редкие байтыСамые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        HashMap<Integer,Integer> integerHashMap = new HashMap<Integer, Integer>();
        int currentByte;
        while (fileInputStream.available()>0){
            currentByte = fileInputStream.read();
            if(integerHashMap.containsKey(currentByte))
                integerHashMap.put(currentByte,integerHashMap.get(currentByte)+1);
            else
                integerHashMap.put(currentByte,1);
        }
        fileInputStream.close();

        int minByte = Collections.min(integerHashMap.values());

        integerHashMap.forEach((i, integer) -> System.out.print(integer == minByte ? i + " " : ""));

    }
}
