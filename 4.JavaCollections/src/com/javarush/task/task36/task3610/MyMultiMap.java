package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        final AtomicInteger Size = new AtomicInteger(0);
        map.forEach( (k, v) -> Size.addAndGet(v.size()));
        //напишите тут ваш код
        return  Size.intValue();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        V retVal = null;
        if (map.containsKey(key)) {
            retVal = map.get(key).get(map.get(key).size() - 1);
            map.get(key).add(value);
        }
        else {
            List<V> values = new ArrayList<V>();
            values.add(value);
            map.put(key, values);
        }
        if (map.get(key).size() > repeatCount){
            map.get(key).remove(0);
        }
        return retVal;
    }

    @Override
    public V remove(Object key) {
        V retVal = null;

        if(map.containsKey(key)){

            retVal = map.get(key).get(0);
            map.get(key).remove(0);

            if (map.get(key).size() == 0)
                map.remove(key);
        }
        //напишите тут ваш код
        return retVal;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> retVal = new ArrayList<V>();
        map.forEach((k, vs) -> retVal.addAll(vs) );
        return  retVal;

    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        final AtomicBoolean retVal = new AtomicBoolean(false);
        map.forEach((k, vs) -> {if(vs.contains(value)) retVal.set(true);});
        return retVal.get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}