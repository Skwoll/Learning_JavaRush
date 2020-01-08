package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)){
            denominations.put(denomination,denominations.get(denomination)+count);
        }
        else {
            denominations.put(denomination, count);
        }
    }
    public int getTotalAmount(){
        AtomicInteger amount = new AtomicInteger();
        denominations.forEach((integer, integer2) -> amount.addAndGet(integer * integer2));
        return amount.get();
    }

    public boolean hasMoney(){
        boolean isEmpty = false;

        for (int v:
        denominations.values()){
            isEmpty |= v > 0 ;
        }

        return isEmpty;
    }

}
