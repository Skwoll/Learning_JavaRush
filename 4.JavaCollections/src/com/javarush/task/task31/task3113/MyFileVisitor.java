package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor {
    private long folderSize = 0;
    private long fileCount = 0;
    private long folderCount = 0;

    public long getFolderSize() {
        return folderSize;
    }

    public long getFileCount() {
        return fileCount;
    }

    public long getFolderCount() {
        return folderCount;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        folderCount++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        folderSize+=attrs.size();
        fileCount++;
        return FileVisitResult.CONTINUE;
    }
}
