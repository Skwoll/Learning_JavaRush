package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MyArch {

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
