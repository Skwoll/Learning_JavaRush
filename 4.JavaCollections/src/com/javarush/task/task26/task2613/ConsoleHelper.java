package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common");

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException {
        try {
            String value = bis.readLine();
            if (value.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
            return value;
        } catch (IOException e) {
            return "";
        }
    }
    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = readString();
        while (currencyCode.length() !=3){
            writeMessage(res.getString("invalid.data"));
            writeMessage(res.getString("choose.currency.code"));
            currencyCode = readString();

        }
        return currencyCode.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
        String result = readString();
        while (result == null || !result.matches("\\d+\\s\\d+")){
            writeMessage(res.getString("invalid.data"));
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
            result = readString();
        }
        return result.split(" ");

    }
    public static Operation askOperation()throws InterruptOperationException{
        writeMessage(res.getString("choose.operation"));
        writeMessage(String.format("1 - %s, 2 - %s, 3 - %s, 4 - %s", res.getString("operation.INFO")
                ,res.getString("operation.DEPOSIT"),res.getString("operation.WITHDRAW"),res.getString("operation.EXIT")));;

        while (true){
            try{
               int oprNumber = Integer.parseInt(readString());
               return Operation.getAllowableOperationByOrdinal(oprNumber);
            }
            catch (Exception e){
                writeMessage(res.getString("invalid.data"));
                writeMessage(res.getString("choose.operation"));
                writeMessage(String.format("1 - %s, 2 - %s, 3 - %s, 4 - %s",res.getString("operation.INFO")
                        ,res.getString("operation.DEPOSIT"),res.getString("operation.WITHDRAW"),res.getString("operation.EXIT")));
            }
        }

    }
    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
