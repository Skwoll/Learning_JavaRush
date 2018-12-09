package com.javarush.task.task18.task1817;

/* 
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
4. Выведенное значение необходимо округлить до 2 знаков после запятой.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int p1=0,p2=0;
            p1 = fileInputStream.available();
            while (fileInputStream.available()>0){
                if (fileInputStream.read() == 32)
                    p2++;
//                else
//                    p1++;
            }

            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println( df.format((double)p2/p1 * 100 ));
            fileInputStream.close();
        } catch (Exception e) {

        }
    }
}
