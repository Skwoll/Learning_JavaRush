package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        try {
            Set<? extends Animal> allAnimals = getAllAnimals(URLDecoder.decode(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8") + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
            System.out.println(allAnimals);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();
        try {
            File[] files = new File(pathToAnimals).listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".class");
                }
            });
            for (File file:files) {
                ClassLoader loader = new MyClassLoader(pathToAnimals,Solution.class.getClassLoader());
//                Class clazz = Class.forName(Solution.class.getPackage().getName() + ".data."+file.getName().replace(".class",""), true, loader);
                Class clazz = new ClassFromPath().load(file.toPath());

                if (!Animal.class.isAssignableFrom(clazz)) continue;

                boolean hasConstructor = false;
                for (Constructor c :
                        clazz.getConstructors()) {
                    if (Modifier.isPublic(c.getModifiers()) && c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }
                if(!hasConstructor) continue;
                result.add((Animal)clazz.newInstance());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static class ClassFromPath extends ClassLoader {
        public Class<?> load(Path path) {
            try {
                byte[] b = Files.readAllBytes(path);
                return defineClass(null, b, 0, b.length); //here main magic
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
