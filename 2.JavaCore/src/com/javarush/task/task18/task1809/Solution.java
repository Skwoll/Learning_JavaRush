package com.javarush.task.task18.task1809;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String fileIn = bufferedReader.readLine();
            String fileOut = bufferedReader.readLine();

            FileInputStream fileInputStream = new FileInputStream(fileIn);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);

            byte[] file = new byte[fileInputStream.available()];

            int cnt = fileInputStream.read(file);

            if (cnt > 0){
                for (int i = cnt-1; i >= 0 ; i--) {
                    fileOutputStream.write(file[i]);
                }
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
        }


    }
}
