package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/* 
Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.


Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        return Files.find(Paths.get(root),Integer.MAX_VALUE,(path, basicFileAttributes) -> basicFileAttributes.isRegularFile())
                .map(Path::toString).collect(Collectors.toList());

    }

    public static void main(String[] args) throws IOException{
        getFileTree("/Users/pavelrybinskij/Documents/test/in").forEach(System.out::println);
    }
}
