package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

import java.io.ObjectInputStream;

public class CachingProxyRetriever implements Retriever {
    OriginalRetriever originalRetriever;
    LRUCache lruCache = new LRUCache(10);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new  OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {

        Object o = lruCache.find(id);

        if (o == null) {
            o = originalRetriever.retrieve(id);
            lruCache.set(id,o);
        }

        return o;

    }
}
