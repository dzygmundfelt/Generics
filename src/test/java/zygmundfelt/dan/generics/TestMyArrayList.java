package zygmundfelt.dan.generics;

import org.junit.*;

public class TestMyArrayList {

    MyArrayList<Integer> myArrayList1;
    MyArrayList<String> myArrayList2;
    MyArrayList<String> myArrayList3;

    @Before
    public void initialize() {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<Integer>(0);
        MyArrayList<String> myArrayList2 = new MyArrayList<String>(5);
        MyArrayList<String> myArrayList3 = new MyArrayList<String>(0);
    }

    @Test
    public void ensureCapacityTest() {

    }

    @Test
    public void addIntegerTest() {
        myArrayList1.add(-4);
        Integer expected = -4;

        Integer actual = myArrayList1.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStringTest() {
        myArrayList3.add("Hello there.");
        String expected = "Hello there.";

        String actual = myArrayList3.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeByElementTrueTest() {

    }


}


//    void add() {
//
//    }
//
//    void add(int index) {
//
//    }
//
//    E get(int index) {
//        return null;
//    }
//
//    E remove(int index) {
//        return null;
//    }
//
//    boolean remove(E element) {
//        return false;
//    }
//
//    E set(int index, E element) {
//        return null;
//    }
//
//    void clear() {
//
//    }
//
//    boolean isEmpty() {
//        return false;
//    }
//
//    boolean contains(E element) {
//        return false;
//    }
//
//    void resize() {
//
//    }