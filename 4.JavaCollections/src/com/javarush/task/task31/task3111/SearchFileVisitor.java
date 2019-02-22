package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    //region getter/setter

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }


    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }


    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }


    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    //endregion

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean containtsName = true;
        boolean containtsContent = true;
        boolean lessMaxSize = true;
        boolean moreMinSize = true;

        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            containtsName = false;
        }

        String stringContent = new String(content, Charset.defaultCharset());
        if (partOfContent != null && !stringContent.contains(partOfContent)) {
            containtsContent = false;
        }

        if(minSize != 0 && content.length < minSize){
            moreMinSize = false;
        }

        if (maxSize != 0 && content.length > maxSize) {
            lessMaxSize = false;
        }

        if(containtsContent && containtsName && lessMaxSize && moreMinSize){
            foundFiles.add(file);
        }

        return FileVisitResult.CONTINUE;
    }
}
