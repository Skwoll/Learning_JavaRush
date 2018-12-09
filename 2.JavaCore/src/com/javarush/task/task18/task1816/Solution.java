package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import com.sun.org.apache.bcel.internal.util.ByteSequence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            String pattern = "[a-zA-Z]";
            Pattern p = Pattern.compile(pattern);
            int cnt = 0;
            if (fileInputStream.available()>0) {
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                Matcher m = p.matcher(new String(buffer));
                while (m.find())
                    cnt++;
            }
            fileInputStream.close();
            System.out.println(cnt);
        } catch (FileNotFoundException e) {
        } catch (IOException e){
        }
    }
}
