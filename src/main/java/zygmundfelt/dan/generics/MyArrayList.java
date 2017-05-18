package zygmundfelt.dan.generics;

//TODO - after finishing methods below, add more ArrayList methods
//TODO -

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {

    Object[] myArray;
    private int size;

    MyArrayList() {
        this(0);
        size = 0;
    }

    MyArrayList(int size) {
        myArray = new Object[size];
        this.size = size;
    }

    public boolean add(Object element) {
        return false;
    }

    public void add(int index, E element) {

    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public void clear() {

    }

    public boolean contains(Object element) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public void ensureCapacity(int minCapacity) {

    }

    public boolean equals(Object o) {
        return false;
    }

    public E get(int index) {
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public E remove(int index) {
        return null;
    }

    public boolean remove(Object element) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    void resize() {

    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public E set(int index, E element) {
        return null;
    }

    public int size() {
        return 0;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }
}
