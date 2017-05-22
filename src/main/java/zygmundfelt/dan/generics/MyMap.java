package zygmundfelt.dan.generics;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyMap<K,V> implements Map<K,V> {

    public class myEntry implements Entry<K,V> {
        private Object key;
        private Object value;

        myEntry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public boolean equals(Object o) {
            return false;
        }

        public K getKey() {
            return (K) key;
        }

        public V getValue() {
            return (V) value;
        }

        public int hashCode() {
            return 13*key.hashCode() + 17*value.hashCode();
        }


        public V setValue(V value) {
            Object oldValue = this.value;
            this.value = value;
            return (V) oldValue;
        }
    }

    private Object[] myMap;
    private int size;
    private static final int MINIMUM_CAPACITY = 10;

    MyMap() {
        this(MINIMUM_CAPACITY);
    }

    MyMap(int initialCapacity) {
        myMap = new Object[initialCapacity];
        size = 0;
    }

    public void clear() {
        myMap = new Object[MINIMUM_CAPACITY];
        size = 0;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public Set<Map.Entry<K,V>> entrySet() {
        return null;
    }

    public boolean equals(Object o) {
        return false;
    }

    public V get(Object key) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Set<K> keySet() {
        return null;
    }

    public V put(K key, V value) {
        return null;
    }

    public void putAll(Map<? extends K,? extends V> map) {

    }

    public V remove(Object key) {
        return null;
    }

    public int size() {
        return 0;
    }

    public Collection<V> values() {
        return null;
    }

}