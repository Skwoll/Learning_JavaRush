package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = bufferedReader.readLine();

            FileReader fileReader = new FileReader(fileName);
            BufferedReader inFile = new BufferedReader(fileReader);

            int wordCount = 0;

            while (inFile.ready()){
                String[] tmp = inFile.readLine().split("\\W");
                for (String s : tmp) {
                    wordCount += s.equalsIgnoreCase("world") ? 1 : 0;
                }

            }
            bufferedReader.close();
            fileReader.close();
            inFile.close();

            System.out.println(wordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
