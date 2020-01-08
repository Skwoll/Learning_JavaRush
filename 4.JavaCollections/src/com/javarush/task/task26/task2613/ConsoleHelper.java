package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException {
        try {
            String value = bis.readLine();
            if (value.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();
            return value;
        } catch (IOException e) {
            return "";
        }
    }
    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage("Введите 3-х значный код валюты.");
        String currencyCode = readString();
        while (currencyCode.length() !=3){
            writeMessage("Введен не верный код валюты. Введите 3-х значный код валюты.");
            currencyCode = readString();
        }
        return currencyCode.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage("Введите номинал и количество банкнот через пробел (целые положительные числа)");
        String result = readString();
        while (result == null || !result.matches("\\d+\\s\\d+")){
            writeMessage("Введены неверные данные. Введите номинал и количество банкнот через пробел (целые положительные числа)");
            result = readString();
        }
        return result.split(" ");

    }
    public static Operation askOperation()throws InterruptOperationException{
        writeMessage("Выберити действие 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");

        while (true){
            try{
               int oprNumber = Integer.parseInt(readString());
               return Operation.getAllowableOperationByOrdinal(oprNumber);
            }
            catch (Exception e){
               writeMessage("Неверное действие. Выберити действие 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            }
        }

    }
}
