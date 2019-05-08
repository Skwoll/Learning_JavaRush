package com.javarush.task.task35.task3507;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
        System.out.println(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals)
    {

        Set<Animal> set = new HashSet<>();
        MyClassLoader cl = new MyClassLoader(ClassLoader.getSystemClassLoader());
        File[] files;
             files = (new File(pathToAnimals)).listFiles();//Files.find(Paths.get(pathToAnimals),0,(p, bfa) -> bfa.isRegularFile() && p.endsWith(".class")).map(Path::toFile).collect(Collectors.toList());

        try {
            System.out.println(files[0].getAbsolutePath());
            cl.loadClass(files[0].getAbsolutePath());
        } catch (Exception e) {
            System.out.println(e);
        }


        return null;
    }
}
