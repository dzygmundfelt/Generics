package zygmundfelt.dan.generics;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private Object[] myArray;
    private int size;
    private static final int MINIMUM_LENGTH = 10;

    MyArrayList() {
        this(MINIMUM_LENGTH);
    }

    MyArrayList(int length) {
        myArray = new Object[length];
        size = 0;
    }

    public boolean add(Object element) {
        //TODO - include rangeCheck
        ensureCapacity(size + 1);
        myArray[size] = element;
        size++;
        return true;
    }

    public void add(int index, E element) {
        //TODO - include rangeCheck
        ensureCapacity(size + 1);
        Object temp1 = myArray[index], temp2;
        for(int i = index + 1; i < size + 1; i++) {
            temp2 = myArray[i];
            myArray[i] = temp1;
            temp1 = myArray[i+1];
            myArray[i+1] = temp2;
        }
        myArray[size] = temp1;
        size++;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] objects = c.toArray();
        int currentSize = size;
        ensureCapacity(size + objects.length);
        for(int i = 0; i < objects.length; i++) {
            myArray[currentSize + i] = objects[i];
        }
        size += objects.length;
        return objects.length > 0;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] objects = c.toArray();
        Object[] myArrayCopy = new Object[myArray.length + objects.length];
        for(int i = 0; i < index; i++) {
            myArrayCopy[i] = myArray[i];
        }
        for(int i = 0; i < objects.length; i++) {
            myArrayCopy[i + index] = objects[i];
        }
        for(int i = 0; i < size - index; i++) {
            myArrayCopy[i + index + objects.length] = myArray[i + index];
        }
        myArray = myArrayCopy;
        size += objects.length;
        return false;
    }

    private void checkTooMuchCapacity() {
        if(myArray.length / 3 > size) {
            int newSize = myArray.length / 2;
            Object[] myArrayCopy = new Object[newSize];
            for(int i = 0; i < size; i++) {
                myArrayCopy[i] = myArray[i];
            }
            myArray = myArrayCopy;
            size = newSize;
        }
    }

    public void clear() {
        myArray = new Object[MINIMUM_LENGTH];
        size = 0;
    }

    public boolean contains(Object element) {
        for(Object o : myArray) {
            if(o.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        Object[] objects = c.toArray();
        for(Object o : objects) {
            if(!contains(o)) {
                return false;
            }
        }
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if(minCapacity >= myArray.length) {
            Object[] myArrayCopy = new Object[minCapacity * 2];
            for(int i = 0; i < size; i++) {
                myArrayCopy[i] = myArray[i];
            }
            myArray = myArrayCopy;
        }
    }

    public boolean equals(Object o) {
        return false;
    }

    public E get(int index) {
        //TODO - rangeCheck
        return (E) myArray[index];
    }

    //TODO - calculate String hashcodes for testing
    public int hashCode() {
        int hashCode = 0;
        for(Object o : myArray) {
            hashCode += o.hashCode();
        }
        return hashCode;
    }

    public int indexOf(Object o) {
        for(int i = 0; i < size; i++) {
            if(myArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for(int i = 0; i < size; i++) {
            if(myArray[i].equals(o)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public E remove(int index) {
        //TODO - rangeCheck
        Object temp1 = null, temp2;
        for(int i = size - 1; i > index; i--) {
            temp2 = myArray[i];
            myArray[i] = temp1;
            temp1 = myArray[i-1];
            myArray[i-1] = temp2;
        }
        size--;
        checkTooMuchCapacity();
        return (E) temp1;
    }

    public boolean remove(Object element) {
        if(element == null) {
            return true;
        }
        if(!contains(element)) {
            return false;
        }
        for(int i = 0; i < size; i++) {
            if(myArray[i].equals(element)) {
                remove(i);
                i--;
            }
        }
        checkTooMuchCapacity();
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        boolean hasRemoval = false;
        Object[] objects = c.toArray();
        for(Object o : objects) {
            hasRemoval = remove(o);
        }
        checkTooMuchCapacity();
        return hasRemoval;
    }

    void resize(int newSize) {

    }

    public boolean retainAll(Collection<?> c) {
        Object[] objects = c.toArray();
        Object[] myArrayCopy = new Object[myArray.length];
        int oldSize = size;
        int i = 0;
        for(Object o : myArray) {
            for(Object obj : objects) {
                if(obj.equals(o)) {
                    myArrayCopy[i] = o;
                    i++;
                }
            }
        }
        myArray = myArrayCopy;
        size = i;
        return oldSize != size;
    }

    public E set(int index, E element) {
        //TODO - rangeCheck
        myArray[index] = element;
        return element;
    }

    public int size() {
        return size;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        //TODO - double rangeChecks
        List<E> list = new ArrayList<E>();
        for(int i = fromIndex; i <= toIndex; i++) {
            list.add((E) myArray[i]);
        }
        return list;
    }

    public Object[] toArray() {
        Object[] myArrayCopy = new Object[size];
        for(int i = 0; i < size; i++) {
            myArrayCopy[i] = myArray[i];
        }
        return myArrayCopy;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }
}
