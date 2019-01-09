package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args)throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader file1Reader = new BufferedReader(new FileReader(file1));
        BufferedReader file2Reader = new BufferedReader(new FileReader(file2));

        List<String> file1Lines = new ArrayList<>();
        List<String> file2Lines = new ArrayList<>();

        while (file1Reader.ready()){
            file1Lines.add(file1Reader.readLine());
        }

        while (file2Reader.ready()){
            file2Lines.add(file2Reader.readLine());
        }
        file1Reader.close();
        file2Reader.close();

        int cur1 = 0;
        int cur2 = 0;

        while (cur1 < file1Lines.size() || cur2 < file2Lines.size() ){
            String cur1Line = cur1 < file1Lines.size() ? file1Lines.get(cur1) : "";
            String cur2line = cur2 < file2Lines.size() ? file2Lines.get(cur2) : "";
            String next1Line = cur1 < file1Lines.size()-1 ? file1Lines.get(cur1+1) : "";

            if (cur1Line.equals(cur2line)){
                lines.add(new LineItem(Type.SAME,cur1Line ));
                cur1++;
                cur2++;

            } else if(next1Line.equals(cur2line)/*||(!cur1Line.equals("")&&cur2line.equals(""))*/){
                lines.add(new LineItem(Type.REMOVED,cur1Line));
                cur1++;

            } else{
                lines.add(new LineItem(Type.ADDED,cur2line));
                cur2++;

            }
        }
        lines.forEach(lineItem -> System.out.println(lineItem.type+" "+lineItem.line));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
