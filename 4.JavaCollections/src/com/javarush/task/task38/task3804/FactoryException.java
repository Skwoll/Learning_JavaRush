package com.javarush.task.task38.task3804;

public class FactoryException {
    public static Throwable ThrowExciption (Enum e) {
        String message = e!= null?e.toString().substring(0,1).concat(e.toString().substring(1).toLowerCase().replace('_',' ')):null;
        if (e instanceof ApplicationExceptionMessage){
            return new Exception(message);
        }

        if (e instanceof DatabaseExceptionMessage){
            return new RuntimeException(message);
        }

        if (e instanceof UserExceptionMessage){
            return new Error(message);
        }
            return new IllegalArgumentException();
    }
}
