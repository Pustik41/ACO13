package data_structures.hash_map;

import java.util.*;

/**
 * Created by dfsdfsddfsdf on 22.07.16.
 */
public class MyHashMap<K, V> {

    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 16;
    private MyEntry<K, V>[] table;
    private double loadFactor;
    private int threshold;
    private int capacity;
    private int size;

    @SuppressWarnings({"rawtypes","unchecked"})
    public MyHashMap() {
        loadFactor = DEFAULT_LOAD_FACTOR;
        capacity = DEFAULT_CAPACITY;
        table = (MyEntry<K, V>[])new MyEntry[capacity];
        threshold = (int)(capacity * loadFactor);
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public MyHashMap(int capacity) {
        this.capacity = capacity;
        loadFactor = DEFAULT_LOAD_FACTOR;

        table = (MyEntry<K, V>[]) new MyEntry[capacity];
        threshold = (int)(capacity * loadFactor);

    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public MyHashMap(double loadFactor, int capacity) {
        this.loadFactor = loadFactor;
        this.capacity = capacity;
        table = (MyEntry<K, V>[])new MyEntry[capacity];
        threshold = (int)(capacity * loadFactor);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        return findByKey(key) != null;
    }

    public boolean containsValue(Object value) {

        for (int i = 0; i < table.length; i++) {

            if(table[i] == null) continue;

            MyEntry<K, V> iterator = table[i];

            if(value == null){

                while (iterator != null) {
                    if(iterator.value == null) return true;
                    iterator = iterator.next;
                }
            } else {

                while (iterator != null) {
                    if(value.equals(iterator.value)) return true;
                    iterator = iterator.next;
                }
            }
        }

        return false;
    }

    public V get(Object key) {

        MyEntry<K, V> forReturn = findByKey(key);

        return forReturn != null ? forReturn.value : null;
    }

    private MyEntry<K, V> findByKey(Object key){

        int position = 0;

        if(key != null){
            position = findPosition((K) key);
        }

        MyEntry<K, V> iterator = table[position];

        if(key == null){

            while (iterator != null) {
                if (iterator.key == null) {
                    return iterator;
                }
                iterator = iterator.next;
            }
        } else {

            while (iterator != null) {
                if (key.equals(iterator.key)) {
                    return iterator;
                }
                iterator = iterator.next;
            }
        }

        return null;
    }

    public V put(K key, V value) {

        int position = 0;

        if(key != null) {
            position = findPosition(key);
        }

        if (table[position] == null) {
            table[position] = new MyEntry<>(key, value);
        } else {

            MyEntry<K, V> iterator = table[position];
            MyEntry<K, V> parent;

            if (key == null) {
                do {
                    parent = iterator;
                    if (iterator.key == null) {
                        return iterator.setValue(value);
                    }
                    iterator = iterator.next;
                } while (iterator != null);
                parent.next = new MyEntry<>(key, value);

            } else {
                do {
                    parent = iterator;
                    if (key.equals(iterator.key)) {
                        return iterator.setValue(value);
                    }
                    iterator = iterator.next;
                } while (iterator != null);
                parent.next = new MyEntry<>(key, value);
            }
        }

        size++;
        if(size >= threshold){
            resize();
        }

        return null;
    }

    private boolean resize() {
        @SuppressWarnings({"rawtypes", "unchecked"})
        MyEntry<K, V>[] resized = (MyEntry<K, V>[])new MyEntry[table.length * 2];
        threshold = (int)(resized.length * loadFactor);
        capacity = resized.length;

        return rehash(resized);
    }

    private boolean rehash(MyEntry<K, V>[] resized) {

        for (int i = 0; i < table.length; i++) {
            if(table[i] == null) continue;
            MyEntry<K, V> iterator = table[i];
            while (iterator != null){
                putInNewTable(resized, iterator);
                iterator = iterator.next;
            }
        }

        table = resized;
        return true;
    }

    private void putInNewTable(MyEntry<K, V>[] resized, MyEntry<K, V> current) {

        MyEntry<K, V> copy = new MyEntry<>(current.getKey(), current.getValue());
        int position = 0;

        if (current.getKey() != null) {
            position = findPosition(current.key);
        }

        if (resized[position] == null) {
            resized[position] = copy;
        } else {

            MyEntry<K, V> iterator = resized[position];
            MyEntry<K, V> parent;

            if (current.key == null) {
                do {
                    parent = iterator;
                    iterator = iterator.next;
                } while (iterator != null);
                parent.next = copy;
            } else{
                do {
                    parent = iterator;
                    iterator = iterator.next;
                } while (iterator != null);
                parent.next = copy;
            }
        }
    }

    private int findPosition(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public V remove(Object key) {

        if(!containsKey(key)) return null;

        int position = 0;

        if(key != null){
            position = findPosition((K) key);
        }

        MyEntry<K, V> iter = table[position];
        MyEntry<K, V> parent = null;
        V forDel = null;

        if(iter.key == key){
            forDel = iter.value;
            table[position] = iter.next;
        } else {

            while (iter.next != null){
                parent = iter;
                iter = iter.next;
                if(iter.key == key){
                    parent.next = iter.next;
                    forDel = iter.value;
                }
            }

        }

        iter.next = null;
        iter = null;
        size--;

        return forDel;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }

    }

    public void clear() {

        for (int i = 0; i < table.length; i++) {
            if(table[i] == null) continue;
            MyEntry<K, V> iterator = table[i];
            MyEntry<K, V> parent;
            while (iterator != null){
                parent = iterator;
                iterator = iterator.next;
                remove(parent.key);
            }
        }
    }

    public Set<K> keySet() {

        Set<K> set = new HashSet<>();

        for (int i = 0; i < table.length; i++) {

            if(table[i] == null) continue;

            MyEntry<K, V> iterator = table[i];
            while (iterator != null) {
                set.add(iterator.key);
                iterator = iterator.next;
            }
        }

        return set;
    }

    public Collection<V> values() {

        Collection<V> collection = new LinkedList<>();

        for (int i = 0; i < table.length; i++) {

            if(table[i] == null) continue;

            MyEntry<K, V> iterator = table[i];
            while (iterator != null) {
                collection.add(iterator.value);
                iterator = iterator.next;
            }
        }

        return collection;
    }

    public Set<MyEntry<K, V>> entrySet() {

        Set<MyEntry<K, V>> set = new HashSet<>();

        for (int i = 0; i < table.length; i++) {

            if(table[i] == null) continue;

            MyEntry<K, V> iterator = table[i];
            while (iterator != null) {
                set.add(iterator);
                iterator = iterator.next;
            }
        }

        return set;
    }

    public static class MyEntry<K, V>{

        public K key;
        public V value;
        public MyEntry<K, V> next;

        public MyEntry() {
        }

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V forReturn = this.value;
            this.value = value;
            return forReturn;
        }
    }
}
