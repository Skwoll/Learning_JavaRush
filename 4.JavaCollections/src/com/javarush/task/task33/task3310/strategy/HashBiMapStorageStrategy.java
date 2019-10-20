package com.javarush.task.task33.task3310.strategy;

import com.google.common.collect.HashBiMap;

import java.util.HashMap;

public class HashBiMapStorageStrategy implements StorageStrategy {
    HashBiMap<Long, String> hashBiMap = HashBiMap.create();

    @Override
    public boolean containsKey(Long key) {
        return hashBiMap.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return hashBiMap.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        hashBiMap.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        return hashBiMap.inverse().get(value);
    }

    @Override
    public String getValue(Long key) {
        return hashBiMap.get(key);
    }
}
