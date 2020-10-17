package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        try (ZipOutputStream outputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            ZipEntry entry = new ZipEntry(source.getFileName().toString());
            outputStream.putNextEntry(entry);

            try (InputStream in = Files.newInputStream(source)) {
                byte[] buffer = new byte[2048];
                int readed;
                while (in.available() > 0) {
                    readed = in.read(buffer);
                    outputStream.write(buffer, 0, readed);
                }
            }
            outputStream.closeEntry();
        }

    }
}
