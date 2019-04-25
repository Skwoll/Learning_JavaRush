package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final  Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int size = Math.max(16, (int)(collection.size()/.75f)+1);//Math.round(collection.size() / .75f);
        this.map = new HashMap(size);
        addAll(collection);
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet set = new AmigoSet();
            set.map = (HashMap)this.map.clone();
            return set;
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    public boolean add (E e){
        return map.put(e,PRESENT)==null;
    }


    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {

        return map.remove(o) != null ? true : false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public int size() {
        return map.size();
    }
}
