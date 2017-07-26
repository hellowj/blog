package com.jun.blog;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    static public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

        private int capacity;

        LRULinkedHashMap(int capacity){
            super(16, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<K, V> eldest){
            return size() > capacity;
        }

    }

    public static void main(String[] args) {
        LRULinkedHashMap<String, String> map = new LRULinkedHashMap<>(4);
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        //map.get("k1");
        map.put("key4", "value4");
        map.put("key5", "value5");
        System.out.println(map.get("key1"));
        LinkedHashMap<String, String> map2 = new LinkedHashMap<>(4);
        map2.put("key1", "value1");
        map2.put("key2", "value2");
        map2.put("key3", "value3");
        map2.put("key4", "value4");
        map2.put("key5", "value5");
        System.out.println(map2.get("key1"));
    }



}
