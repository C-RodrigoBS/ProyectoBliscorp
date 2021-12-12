package com.example.myapplication;

import java.util.*;

public class LRUCache {
    private int size;
    private Map<String, Data> cache;
    private LinkedList<Data> dataList;
    public LRUCache(int size) {
        super();
        this.size = size;
        this.cache = new HashMap<>();
        this.dataList = new LinkedList<>();

    }

    public Set getKeys(){
        return cache.keySet();
    }
    public Object get(String key) {
        if (cache.containsKey(key)) {
            Data data = cache.get(key);
            // Remove the data from its location
            dataList.remove(data);
            // Add it to the end of the list
            dataList.add(data);
            return data.getValue();
        }
        return "NA";
    }
    public void set(String key, String[] value) {
        if (cache.containsKey(key)) {
            Data oldData = cache.get(key);
            // Remove old data from linkedlist
            dataList.remove(oldData);
            Data newData = new Data(key, value);
            // Update the value
            cache.put(key, newData);
            // Add new data at the end of the linkedlist
            dataList.add(newData);
        } else {
            Data data = new Data(key, value);
            if (cache.size() >= size) {
                // Remove the oldest value from both map and linkedlist
                cache.remove(dataList.pollFirst().getKey());
            }
            cache.put(key, data);
            dataList.add(data);
        }
    }
}