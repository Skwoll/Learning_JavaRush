package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> res = new HashSet<>();
        strings.forEach(s -> res.add(shortener.getId(s)));
        return res;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> res = new HashSet<>();
        keys.forEach(aLong -> res.add(shortener.getString(aLong)));
        return res;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());

        }
        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> keys = getIds(shortener,strings);
        Date end  = new Date();

        System.out.println(end.getTime() - start.getTime());

        start = new Date();
        Set<String> outString = getStrings(shortener,keys);
        end = new Date();

        System.out.println(end.getTime()-start.getTime());

        if (strings.equals(outString))
            System.out.println("Тест пройден.");
        else
            System.out.println("Тест не пройден.");
    }
}
