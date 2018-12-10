package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();

            FileInputStream fileInputStream2 = new FileInputStream(fileName2);
            FileInputStream fileInputStream1 = new FileInputStream(fileName1);

            int cnt;
            byte[] file1 = new byte[fileInputStream1.available()];
            byte[] bytes = new byte[100];

            fileInputStream1.read(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(fileName1);

            while (fileInputStream2.available()>0){
                cnt = fileInputStream2.read(bytes);
                fileOutputStream.write(bytes,0,cnt);
            }
            fileOutputStream.write(file1);
            fileOutputStream.flush();
            fileInputStream2.close();
            fileInputStream1.close();
            fileOutputStream.close();

        } catch (IOException e) {

        }
    }
}
