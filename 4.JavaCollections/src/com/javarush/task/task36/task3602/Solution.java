package com.javarush.task.task36.task3602;

import java.awt.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        try {
            for (Class<?> declaredClass :
                    Arrays.stream(Collections.class.getDeclaredClasses())
                            .filter(c->(List.class.isAssignableFrom(c) || List.class.isAssignableFrom(c.getSuperclass()))
                                    && Modifier.isStatic(c.getModifiers())
                                    && Modifier.isPrivate(c.getModifiers()))
                            .toArray(Class[]::new)
            ){
                try {
                    Constructor constructor = declaredClass.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    Method method = declaredClass.getDeclaredMethod("get",int.class);
                    method.setAccessible(true);
                    method.invoke(constructor.newInstance(),1);
                } catch (InvocationTargetException e) {
                    if (e.getCause().toString().contains("IndexOutOfBoundsException"))
                        return declaredClass;
                } catch (IllegalAccessException| InstantiationException |NoSuchMethodException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
