package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        try {
            return bis.readLine();
        } catch (Exception e) {
            return "";
        }
    }
    public static String askCurrencyCode(){
        writeMessage("Введите 3-х значный код валюты.");
        String currencyCode = readString();
        while (currencyCode.length() !=3){
            writeMessage("Введен не верный код валюты. Введите 3-х значный код валюты.");
            currencyCode = readString();
        }
        return currencyCode.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode){
        writeMessage("Введите номинал и количество банкнот через пробел (целые положительные числа)");
        String result = readString();
        while (result == null || !result.matches("\\d+\\s\\d+")){
            writeMessage("Введены неверные данные. Введите номинал и количество банкнот через пробел (целые положительные числа)");
            result = readString();
        }
        return result.split(" ");

    }
}
