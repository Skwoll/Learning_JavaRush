package com.javarush.task.task31.task3104;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Поиск скрытых файлов
В классе Solution переопредели логику двух методов:
- visitFile кроме своей логики должен добавлять в archived все пути к zip и rar файлам
- visitFileFailed должен добавлять в failed все пути к недоступным файлам и возвращать SKIP_SUBTREE

Пример вывода:
D:/mydir/BCD.zip

Метод main не участвует в тестировании


Требования:
1. В классе Solution нужно переопределить метод visitFile.
2. Метод visitFile, кроме своей логики, должен добавлять в поле archived все пути к zip и rar файлам.
3. В классе Solution нужно переопределить метод visitFileFailed.
4. Метод visitFileFailed должен добавлять в поле failed все пути к недоступным файлам и возвращать SKIP_SUBTREE.
*/
public class Solution extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();

        try {
//            Files.walkFileTree(Paths.get("D:/"), options, 20, solution);
            Files.walkFileTree(Paths.get("C:/tmp"), options, 20, solution);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String path = file.getFileName().toString();
        if((path.endsWith(".zip") || path.endsWith(".rar"))){
            archived.add(file.toAbsolutePath().toString());
        }

        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(file.toAbsolutePath().toString());
        return FileVisitResult.SKIP_SUBTREE;
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }
}
