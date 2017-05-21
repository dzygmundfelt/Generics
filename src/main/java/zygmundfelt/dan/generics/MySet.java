package zygmundfelt.dan.generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<E> implements Set<E> {

    public boolean add(E element) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public void clear() {

    }

    public boolean contains(Object o) {
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

    public boolean equals(Object o) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public int size() {
        return 0;
    }

    public Object[] toArray() {
        return null;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

}
