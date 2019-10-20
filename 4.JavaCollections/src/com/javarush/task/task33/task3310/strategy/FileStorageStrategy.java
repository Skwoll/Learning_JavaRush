package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    void initFileBuckets(FileBucket[] fileBuckets){
        for (int i = 0; i < fileBuckets.length; i++) {
            fileBuckets[i] = new FileBucket();
        }
    }

    public FileStorageStrategy() {
        initFileBuckets(table);
    }

    int hash(Long k){
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    int indexFor(int hash, int length){
        return (length-1) & hash;

    }

    Entry getEntry(Long key){
        int hash = (key == null) ? 0 : hash((long)key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)] == null ? null : table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }
    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        FileBucket[] tab = table;

        if (value == null)
            for (int i = 0; i < tab.length ; i++) {
                if (tab[i] == null) continue;
                for (Entry e = tab[i].getEntry() ; e != null ; e = e.next)
                                    if (e.value == null)
                                        return true;
            }

        for (int i = 0; i < tab.length ; i++) {
            if (tab[i] == null) continue;
            for (Entry e = tab[i].getEntry() ; e != null ; e = e.next)
                            if (value.equals(e.value))
                                return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        if (key == null)
            return ;
        int hash = hash((long)key.hashCode());
        int i = indexFor(hash, table.length);
        Entry headEntry = table[i] == null ? null :  table[i].getEntry();
        for (Entry e = headEntry; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                String oldValue = e.value;
                e.value = value;
                table[i].putEntry(headEntry);
            }
        }
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
        FileBucket[] tab = table;

        if (value == null)
            for (int i = 0; i < tab.length ; i++)
                for (Entry e = tab[i] == null ? null :tab[i].getEntry() ; e != null ; e = e.next)
                    if (e.value == null)
                        return e.key;

        for (int i = 0; i < tab.length ; i++)
            for (Entry e = tab[i] == null ? null : tab[i].getEntry() ; e != null ; e = e.next)
                if (value.equals(e.value))
                    return e.key;
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (key == null)
            return null;
        int hash = hash((long)key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)] == null ? null : table[indexFor(hash, table.length)].getEntry();
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
                return e.value;
        }return null;
    }

    void addEntry(int hash, Long key, String value, int bucketIndex){
        Entry e = table[bucketIndex] == null ? null :table[bucketIndex].getEntry();
        table[bucketIndex].putEntry( new Entry(hash, key, value, e));
        for (FileBucket fileBucket : table) {
            if (fileBucket.getFileSize()> bucketSizeLimit)
                resize(2 * table.length);

        }
    }
    void resize(int newCapacity){

        FileBucket[] oldTable = table;
        int oldCapacity = oldTable.length;
        FileBucket[] newTable = new FileBucket[newCapacity];
        initFileBuckets(newTable);
        transfer(newTable);
        table = newTable;
       // threshold = (int)(newCapacity * loadFactor);
    }
    void transfer(FileBucket[] newTable){
        FileBucket[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry e = src[j] == null ? null : src[j].getEntry();
            if (e != null) {
                src[j] = null;
                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i].getEntry();
                    newTable[i].putEntry(e);
                    e = next;
                } while (e != null);
            }
            src[j].remove();
        }
    }
}
