package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K,V>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        V tmp = cache.get(key);

        if (tmp == null){
//            Class[] params = {key.getClass()};
            tmp = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key,tmp);
        }

        return tmp;
    }

    public boolean put(V obj) {
        //TODO add your code here
        K key;
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            key = (K)method.invoke(obj);
            cache.put(key, obj);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
            return false;
        }
        return true;
    }

    public int size() {
        return cache.size();
    }
}
