package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.


Требования:
1. Метод main должен считывать путь к папке с консоли.
2. Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
3. Используй только классы и методы из пакета java.nio.
4. На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и поддиректориях]".
5. На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
6. На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]".
*/
public class Solution {

    static long fileCount = 0;
    static long folderSize = 0;
    static long dirCount =0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String stringPath = bufferedReader.readLine();
        Path dir = Paths.get(stringPath);

        if(!Files.isDirectory(dir)){
            System.out.println(dir.toString()+ " - не папка");
            return;
        }

//        Files.find(dir, Integer.MAX_VALUE,(path, bfa) -> bfa.isRegularFile(), FileVisitOption.FOLLOW_LINKS).forEach(path -> { fileCount++;
//        folderSize+=path.toFile().length();});
//        Files.find(dir, Integer.MAX_VALUE,(path, bfa) -> bfa.isDirectory(), FileVisitOption.FOLLOW_LINKS).forEach(path -> { dirCount++;});


        MyFileVisitor visitor = new MyFileVisitor();

        Files.walkFileTree(dir, visitor);
        fileCount = visitor.getFileCount();
        folderSize = visitor.getFolderSize();
        dirCount = visitor.getFolderCount();

        System.out.println("Всего папок - "+(dirCount-1));
        System.out.println("Всего файлов - "+fileCount);
        System.out.println("Общий размер - "+folderSize);

    }
}
