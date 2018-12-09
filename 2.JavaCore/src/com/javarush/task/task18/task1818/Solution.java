package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String file1 = bufferedReader.readLine();
            String file2 = bufferedReader.readLine();
            String file3 = bufferedReader.readLine();

            FileInputStream fileInputStream1 = new FileInputStream(file2);
            FileInputStream fileInputStream2 = new FileInputStream(file3);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);

            byte[] buffer = new byte[100];

            while (fileInputStream1.available()>0) {
                fileInputStream1.read(buffer);
                fileOutputStream.write(buffer);
            }

            while (fileInputStream2.available()>0) {
                fileInputStream2.read(buffer);
                fileOutputStream.write(buffer);
            }

            fileInputStream1.close();
            fileInputStream2.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
