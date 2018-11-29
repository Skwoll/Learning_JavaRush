package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int dot = ',';
        long cnt = 0;
        try {
            String fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
            FileInputStream fileInputStream = new FileInputStream(fileName);

            while (fileInputStream.available()>0){
                cnt += fileInputStream.read() == dot ? 1 : 0;
            }
            fileInputStream.close();
            System.out.println(cnt);
        } catch (Exception e) {
        }
    }
}
