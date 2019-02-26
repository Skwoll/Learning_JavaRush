package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.


Требования:
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
5. Потоки для работы с архивом должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length<2) {
            return;
        }

        HashMap<String, ByteArrayOutputStream> files;
        try(ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]))) {
             files = unzip(zipIn);
        }
        try(ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]))) {

            Path filename = Paths.get(args[0]);
            files.remove("new/" + filename.toFile().getName());
            zipOut.putNextEntry(new ZipEntry("new/" + filename.toFile().getName()));
            Files.copy(filename, zipOut);
            zipOut.closeEntry();

            for (Map.Entry<String, ByteArrayOutputStream> set : files.entrySet()
            ) {
                zipOut.putNextEntry(new ZipEntry(set.getKey()));
                zipOut.write(set.getValue().toByteArray());
                zipOut.closeEntry();
            }

        }

    }
    public static HashMap<String, ByteArrayOutputStream> unzip (ZipInputStream in) throws IOException {
        HashMap<String, ByteArrayOutputStream> files = new HashMap<>();

        ZipEntry tmpZip ;
        while ((tmpZip = in.getNextEntry()) != null){
            ByteArrayOutputStream tmpByte = new ByteArrayOutputStream();
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer))!= -1){
                tmpByte.write(buffer,0,len);
                if(!tmpZip.isDirectory()) {
                    files.put(tmpZip.getName(), tmpByte);
                }
            }
        }
        return files;
    }
}