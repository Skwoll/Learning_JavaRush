package com.javarush.task.task35.task3507;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    String path;
    public MyClassLoader(String path,ClassLoader parent) {
        super(parent);
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] b = Files.readAllBytes(Paths.get(path));
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}

