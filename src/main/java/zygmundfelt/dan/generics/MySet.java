package zygmundfelt.dan.generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<E> implements Set<E> {

    private Object[] mySet;
    private int size;
    private static final int MINIMUM_SIZE = 10;

    MySet() {
        mySet = new Object[MINIMUM_SIZE];
        size = 0;
    }

    public boolean add(E element) {
        if(contains(element)) {
            return false;
        }
        ensureCapacity(size + 1);
        fillNullIndex(element);
        return true;
    }

    //TODO - the toArray called in all these methods could be the toArray in this class. Ohhhhhh.
    public boolean addAll(Collection<? extends E> c) {
        Object[] objects = c.toArray();
        int oldSize = size;
        ensureCapacity(size + objects.length);
        for(Object o : objects) {
            add((E) o);
        }
        return size != oldSize;
    }

    public void clear() {
        mySet = new Object[MINIMUM_SIZE];
    }

    public boolean contains(Object o) {
        if(o == null) {
            return false; //TODO - what here?
        } else if(mySet.length == 0) {
            return false;
        }

        for(int i = 0; i < mySet.length; i++) {
            if(o.equals(mySet[i])) {
                return true;
            }
        }

        return false;
    }

    public boolean containsAll(Collection<?> c) {
        Object[] objects = new Object[c.size()];
        for(int i = 0; i < c.size(); i++) {
            if(!contains(objects[i])) {
                return false;
            }
        }
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if(minCapacity >= mySet.length) {
            Object[] mySetCopy = new Object[minCapacity * 2];
            for(int i = 0; i < size; i++) {
                mySetCopy[i] = mySet[i];
            }
            mySet = mySetCopy;
        }
    }

    public boolean equals(Object o) {
        return false;
    }

    private void fillNullIndex(E element) {
        for(int i = 0; i < mySet.length; i++) {
            if(mySet[i] == null) {
                mySet[i] = element;
                size++;
                return;
            }
        }
    }

    public int hashCode() {
        int hashCode = 0;
        for(int i = 0; i < mySet.length; i++) {
            if(mySet[i] != null) {
                hashCode += mySet[i].hashCode();
            }
        }
        return hashCode;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public boolean remove(Object o) {
        for(int i = 0; i < mySet.length; i++) {
            if(o.equals(mySet[i])) {
                mySet[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] mySetCopy = new Object[size];
        int i = 0;
        for(int j = 0; j < mySet.length; j++) {
            if(mySet[j] != null) {
                mySetCopy[i] = mySet[j];
            }
        }
        return mySetCopy;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

}