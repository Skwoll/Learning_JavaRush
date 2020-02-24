package com.javarush.task.task22.task2211;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.


Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 1){
            try{
                byte[] inFile = Files.readAllBytes(Paths.get(args[0]));
                try(FileOutputStream fo = new FileOutputStream(new File(args[1]))){
                    fo.write(new String(inFile,"Windows-1251").getBytes("UTF-8"));
                }
            }catch (Exception e){
            }
        }
    }
}
