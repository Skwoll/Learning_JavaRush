package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String inFile = bufferedReader.readLine();
            String outFile = bufferedReader.readLine();
            bufferedReader.close();

            FileReader fileReader = new FileReader(inFile);
            FileWriter fileWriter = new FileWriter(outFile);

            char[] buffer = new char[1000];

            while(fileReader.ready()){
               int cnt =  fileReader.read(buffer);
                for (int i = 1; i < cnt; i+=2) {
                    fileWriter.write(buffer[i]);
                }

            }
            fileReader.close();
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
