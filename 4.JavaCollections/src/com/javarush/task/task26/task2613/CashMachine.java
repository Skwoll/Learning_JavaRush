package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] deno = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        try {
            int denom = Integer.parseInt(deno[0]);
            int cnt = Integer.parseInt(deno[1]);
            manipulator.addAmount(denom,cnt);
        } catch (Exception e) {

        }
        ConsoleHelper.readString();

    }
}
