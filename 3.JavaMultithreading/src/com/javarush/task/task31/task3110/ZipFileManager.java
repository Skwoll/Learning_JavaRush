package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        Path parentPath = zipFile.getParent();
        if (Files.notExists(parentPath)) {
            Files.createDirectories(parentPath);
        }

        try (ZipOutputStream outputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for (Path file : fileNames) {
                    addNewZipEntry(outputStream, source, file);
                }
            } else if (Files.isRegularFile(source)) {
                addNewZipEntry(outputStream, source.getParent(), source.getFileName());
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream outputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream in = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());
            outputStream.putNextEntry(entry);
            copyData(in, outputStream);
            outputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[2048];
        int readed;
        while (in.available() > 0) {
            readed = in.read(buffer);
            out.write(buffer, 0, readed);
        }
    }
}
