package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> files = new ArrayList<>();
        try {
            String fileName = bufferedReader.readLine();
            while (!fileName.toUpperCase().equals("END")){
                files.add(fileName);
                fileName = bufferedReader.readLine();
            }
            Collections.sort(files);
            String outFileName = files.get(0).substring(0,files.get(0).lastIndexOf("."));
            FileWriter outFile = new FileWriter(outFileName);
            files.forEach(s -> {
                try {
                    FileReader fileReader = new FileReader(s);
                    char[] buffer = new char[100];
                    int readCount;
                    while (fileReader.ready()){
                        readCount = fileReader.read(buffer);
                        outFile.write(buffer,0,readCount);
                    }
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            outFile.flush();
            outFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
