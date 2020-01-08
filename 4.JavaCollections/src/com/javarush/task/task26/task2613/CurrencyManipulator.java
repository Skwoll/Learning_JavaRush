package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new TreeMap<>(Collections.reverseOrder());

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
    public boolean isAmountAvailable(int expectedAmount){
       return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount)throws NotEnoughMoneyException{
        Map<Integer, Integer> withdraw = new HashMap<>();
        AtomicInteger ammount = new AtomicInteger(expectedAmount);

        denominations.forEach((k, v) -> {
            int cnt=0;
            if (k <= ammount.get()){
                cnt = ammount.get() / k;
                if (cnt <= v){
                    withdraw.put(k,cnt);
                    ammount.addAndGet(-(k * cnt));
                }else{
                    withdraw.put(k,v);
                    ammount.addAndGet(-(k * v));
                }
            }
        });
        if (ammount.get() != 0)
            throw new NotEnoughMoneyException();
        withdraw.forEach((k, v) -> denominations.put(k,denominations.get(k)-v));
        return withdraw;

    }

}
