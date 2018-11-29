package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputFile = bufferedReader.readLine();
            String outFileLow = bufferedReader.readLine();
            String outFileHight = bufferedReader.readLine();

            FileInputStream fileInputStream = new FileInputStream(inputFile);
            FileOutputStream fileOutputStreamLow = new FileOutputStream(outFileLow);
            FileOutputStream fileOutputStreamHight = new FileOutputStream(outFileHight);
            int terminator = fileInputStream.available()/2;


            while (fileInputStream.available()>0) {
                if (fileInputStream.available()>terminator)
                   fileOutputStreamLow.write(fileInputStream.read());
                else
                    fileOutputStreamHight.write(fileInputStream.read());
            }
            fileInputStream.close();
            fileOutputStreamLow.flush();
            fileOutputStreamLow.close();
            fileOutputStreamHight.flush();
            fileOutputStreamHight.close();


        } catch (Exception e) {
        }



    }
}
