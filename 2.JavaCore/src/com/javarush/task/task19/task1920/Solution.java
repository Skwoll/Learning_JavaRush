package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            TreeMap<String,Double> map = new TreeMap<>();

            while (bufferedReader.ready()){
                String[] bufer = bufferedReader.readLine().split(" ");
                if (map.containsKey(bufer[0])){
                    map.put(bufer[0], map.get(bufer[0]) + Double.valueOf(bufer[1]));
                } else{
                    map.put(bufer[0], Double.valueOf(bufer[1]));
                }
            }
            bufferedReader.close();

            Double maxValue = Collections.max(map.values());

            map.forEach((s, aDouble) -> {if (aDouble.equals(maxValue)) {System.out.println(s);}});
        }
    }
}
