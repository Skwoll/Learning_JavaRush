package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args)throws Exception {
        if (args.length==1) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            DateFormat df = new SimpleDateFormat("d M y",Locale.ENGLISH);

            while (bufferedReader.ready()){
                 Matcher m = Pattern.compile("^(.*) (\\d{1,2} \\d{1,2} \\d{4})$").matcher(bufferedReader.readLine());
                 m.find();
                PEOPLE.add(new Person(m.group(1).trim(),df.parse(m.group(2).trim())));
            }
            bufferedReader.close();
            PEOPLE.forEach(person -> System.out.println(person.getName()+" "+ df.format(person.getBirthDate())));
        }

    }
}
