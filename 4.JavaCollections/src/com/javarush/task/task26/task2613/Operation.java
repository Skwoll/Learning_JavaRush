package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN, INFO, DEPOSIT, WITHDRAW,EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i){
        if (i<= 0 || i > 4)
            throw new IllegalArgumentException();
        else {
            try{
                return Operation.values()[i];
            }
            catch (Exception e){
                throw new IllegalArgumentException();
            }
        }
    }
}
