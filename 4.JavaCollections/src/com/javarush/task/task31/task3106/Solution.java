package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002


Требования:
1. В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов. Файлы приходят аргументами в main, начиная со второго.
2. Создай поток для записи в файл, который приходит первым аргументом в main. Запиши туда содержимое файла из архива.
3. Поток для чтения из архива должен быть закрыт.
4. Поток для записи в файл должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args) throws IOException,FileNotFoundException {
        if(args.length<2){
            return;
        }

        List<String> parts = new ArrayList<>();
        parts.addAll(Arrays.asList(args));
        parts.remove(0);
        Collections.sort(parts);
        File unpakFilePath = new File(args[0]);
        SequenceInputStream sis;
        List<FileInputStream> fileInputStreams = new ArrayList<>();
        try {
            for (String file : parts) {
                fileInputStreams.add(new FileInputStream(file));
            }
        } catch (FileNotFoundException e) {

            for (FileInputStream fileInputStream : fileInputStreams) {
                fileInputStream.close();
            }
            throw e;
        }
        try( FileOutputStream unpakFile = new FileOutputStream(unpakFilePath)) {
            try (ZipInputStream archFile = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)))) {
                byte[] buffer = new byte[8192];
                ZipEntry zip;
                while((zip = archFile.getNextEntry())!=null){
                    int len;
                    while ((len = archFile.read(buffer)) != -1 ){
                        unpakFile.write(buffer,0,len);

                    }
                }

            }
        }


    }
}
