package zygmundfelt.dan.generics;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyMap<K,V> implements Map<K,V> {

    public class MyEntry implements Entry<K,V> {
        private Object key;
        private Object value;

        MyEntry(Object key, Object value) {
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
        for(Object o : myMap) {
            if(o == null) {
                continue;
            }
            MyEntry entry = (MyEntry) o;
            if(entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for(Object o : myMap) {
            if(o == null) {
                continue;
            }
            MyEntry entry = (MyEntry) o;
            if(entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K,V>> entrySet() {
        return null;
    }

    private void ensureCapacity(int minCapacity) {
        if(minCapacity >= myMap.length) {
            Object[] myMapCopy = new Object[minCapacity * 2];
            for(int i = 0; i < size; i++) {
                myMapCopy[i] = myMap[i];
            }
            myMap = myMapCopy;
        }
    }

    public boolean equals(Object o) {
        return false;
    }

    private void fillNullIndex(MyEntry entry) {
        for(int i = 0; i < myMap.length; i++) {
            if(myMap[i] == null) {
                myMap[i] = entry;
                size++;
                return;
            }
        }
    }

    public V get(Object key) {
        for(Object o : myMap) {
            if(o == null) {
                continue;
            }
            MyEntry entry = (MyEntry) o;
            if(entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public int hashCode() {
        int hashCode = 0;
        for(Object o : myMap) {
            hashCode += o.hashCode();
        }
        return hashCode;
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