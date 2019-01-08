package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String inFileName = bufferedReader.readLine();
            String outFileName = bufferedReader.readLine();

            BufferedReader inFile = new BufferedReader(new FileReader(inFileName));
            BufferedWriter outFile = new BufferedWriter(new FileWriter(outFileName));

            while (inFile.ready()){
                String[] buffer = inFile.readLine().split(" ");

                for (String s : buffer) {
                    if(s.matches("\\d+")) {
                        outFile.write(s+" ");
                    }
                }
            }
            bufferedReader.close();
            inFile.close();
            outFile.flush();
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
