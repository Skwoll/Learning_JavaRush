package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        int currentByte;

        while (fileInputStream.available()>0){
            currentByte = fileInputStream.read();

            if(hashMap.containsKey(currentByte)){
                hashMap.put(currentByte,hashMap.get(currentByte)+1);
            }
            else{
                hashMap.put(currentByte,1);
            }

        }
        fileInputStream.close();

        int maxByte = Collections.max(hashMap.values());

        hashMap.forEach((i, integer) -> System.out.print(integer == maxByte ? i + " ":""));
//        System.out.println("");
//        hashMap.forEach((i, integer) -> System.out.println("symbol: "+(char)i.byteValue()+" key: "+i +" count: "+integer));


    }
}
