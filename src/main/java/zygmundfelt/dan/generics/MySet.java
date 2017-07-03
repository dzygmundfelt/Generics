package zygmundfelt.dan.generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<E> implements Set<E> {

    private Object[] mySet;
    private int size;
    private static final int MINIMUM_CAPACITY = 10;

    MySet() {
        mySet = new Object[MINIMUM_CAPACITY];
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

    private void checkTooMuchCapacity() {
        if(mySet.length > 20 && mySet.length / 3 > size) {
            int newLength = mySet.length / 2;
            Object[] mySetCopy = new Object[newLength];
            int i = 0;
            for(int j = 0; j < mySet.length; j++) {
                if(mySet[j] != null) {
                    mySetCopy[i] = mySet[j];
                    i++;
                }
            }
            mySet = mySetCopy;
        }
    }

    public void clear() {
        mySet = new Object[MINIMUM_CAPACITY];
        size = 0;
    }

    public boolean contains(Object o) {
        if(o == null) {
            return false;
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
        Object[] objects = c.toArray();
        for(int i = 0; i < objects.length; i++) {
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
        if(this == o) {
            return true;
        } else if(o == null) {
            return false;
        } else if(getClass() != o.getClass()) {
            return false;
        }
        MySet<E> other = (MySet<E>) o;
        if(size != other.size) {
            return false;
        }
        for(Object object : mySet) {
            if(!(object == null) && !other.contains(object)) {
                return false;
            }
        }
        return true;
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
                size--;
                checkTooMuchCapacity();
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        Object[] objects = c.toArray();
        int oldSize = size;
        for(Object o : objects) {
            remove(o);
        }
        return size != oldSize;
    }

    public boolean retainAll(Collection<?> c) {
        int oldSize = size;
        for(int i = 0; i < mySet.length; i++) {
            if(mySet[i] != null && !c.contains(mySet[i])) {
                mySet[i] = null;
                size--;
            }
        }
        checkTooMuchCapacity();
        return size != oldSize;
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
                i++;
            }
        }
        return mySetCopy;
    }

    public <T> T[] toArray(T[] a) {
        Object[] arr = new Object[a.length];
        for(int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        return (T[]) arr;
    }

}
