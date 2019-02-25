package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MyArch {

    public static HashMap<String, ByteArrayOutputStream> unzip (ZipInputStream in) throws IOException {
        HashMap<String, ByteArrayOutputStream> files = new HashMap<>();

        ZipEntry tmpZip = in.getNextEntry();
        while (in.available()>0){
            ByteArrayOutputStream tmpByte = new ByteArrayOutputStream();
            while (in.available()>0){
                tmpByte.write(in.read());
            }
            if(!tmpZip.isDirectory()) {
                files.put(tmpZip.getName(), tmpByte);
            }
            tmpZip = in.getNextEntry();
        }
        return files;
    }

}
