package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class MyClassLoader extends ClassLoader{
    String path;
    private Map classesHash = new java.util.HashMap();
    public MyClassLoader(String Path, ClassLoader Parent){
        super(Parent);
        path = Path;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result= findClass(name);
        if (resolve)
            resolveClass(result);
        return result;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class result = (Class) classesHash.get(name);
        if (result != null) {
            return result;
        }

        File f = findFile(name.replace('.', '/'), ".class");

        if (f == null) {
            return findSystemClass(name);
        }

        try {
            byte[] classBytes= loadFileAsBytes(f);
            result= defineClass(null, classBytes, 0,
                    classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(
                    "Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException(
                    "Format of class file incorrect for class "
                            + name + " : " + e);
        }
        classesHash.put(name,result);
        return result;
    }

    @Override
    protected URL findResource(String name) {
        File f = findFile(name, "");
        if (f==null)
            return null;
        try {
            return f.toURL();
        } catch(java.net.MalformedURLException e) {
            return null;
        }
    }

    private File findFile(String name, String extension){
        File f;
        f = new File((new File(path)).getPath()
                + File.separatorChar
                + name.replace('/',
                File.separatorChar)
                + extension);
        if (f.exists())
            return f;
        return null;
    }

    public static byte[] loadFileAsBytes(File file) throws IOException{
        byte[] result = new byte[(int)file.length()];
        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result,0,result.length);
        } finally {
            try {
                f.close();
            } catch (Exception e) {

            }
        }
        return result;
    }
}
