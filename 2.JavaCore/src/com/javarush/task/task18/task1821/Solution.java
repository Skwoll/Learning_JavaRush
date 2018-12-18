package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            if (args.length >0){
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(args[0]));

                SortedMap<Integer,Integer> sortedMap = new TreeMap<>();

                while(inputStreamReader.ready()){
                   int tmp = inputStreamReader.read() ;
                   if (sortedMap.containsKey(tmp)){
                       sortedMap.put(tmp,sortedMap.get(tmp)+1);
                   }
                   else {
                       sortedMap.put(tmp,1);
                   }
                }

                inputStreamReader.close();
                sortedMap.forEach((integer, integer2) -> System.out.println((char)integer.byteValue() +" "+integer2 ));
            }
        } catch (Exception e) {
        }
    }
}
