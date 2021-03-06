package com.javarush.task.task26.task2613;

import java.util.*;

public final class CurrencyManipulatorFactory {
    private static Map<String,CurrencyManipulator> map = new HashMap<>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if (!map.containsKey(currencyCode.toUpperCase()))
            map.put(currencyCode.toUpperCase(),new CurrencyManipulator(currencyCode));

        return map.get(currencyCode.toUpperCase());
    }

    private CurrencyManipulatorFactory() {
        throw new UnsupportedOperationException();
    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }
}
