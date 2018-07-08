package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream f = new FileInputStream(s.readLine());

        ArrayList<Integer> tmp = new ArrayList<Integer>();
        StringBuffer sb = new StringBuffer();
        while (f.available()>0){
            int i = f.read();

            if (i == 13 || i == 10 ){
                Integer t = Integer.parseInt(sb.toString());
                if (t % 2 == 0)
                  tmp.add(t);
                sb.delete(0,sb.length());
            }
            else {
               sb.append((char) i );
            }
        }
        Integer t = Integer.parseInt(sb.toString());
        if (t % 2 == 0)
            tmp.add(t);
        sb.delete(0,sb.length());
        Collections.sort(tmp);

        tmp.forEach(System.out::println);
        f.close();
    }
}
