package zygmundfelt.dan.generics;

import org.junit.*;

import java.util.ArrayList;

public class TestMyArrayList {

    MyArrayList<Integer> myArrayList1;
    MyArrayList<Integer> myArrayList2;
    MyArrayList<String> myArrayList3;

    @Before
    public void initialize() {
        myArrayList1 = new MyArrayList<Integer>(10);
        myArrayList2 = new MyArrayList<Integer>(10);
        myArrayList3 = new MyArrayList<String>(10);


        myArrayList2.add(2);
        myArrayList2.add(9);
        myArrayList2.add(-15);

        myArrayList3.add("hello");
        myArrayList3.add("you");
        myArrayList3.add("guys");
        myArrayList3.add("!");
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
        String expected = "hello";

        String actual = myArrayList3.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addIntegerIntoIndexTest() {
        myArrayList2.add(1, 4);
        Integer expected = 4;

        Integer actual = myArrayList2.get(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAllTest() {
        myArrayList1.add(3);
        myArrayList1.add(4);
        myArrayList1.add(-5);
        Integer[] expected = {2, 9, -15, 3, 4, -5};

        myArrayList2.addAll(myArrayList1);

        for(int i = 0; i < 6; i++) {
            Assert.assertEquals(expected[i], myArrayList2.get(i));
        }
    }

    @Test
    public void addAllIntoIndexTest() {
        myArrayList1.add(3);
        myArrayList1.add(4);
        myArrayList1.add(-5);
        Integer[] expected = {2, 3, 4, -5, 9, -15};

        myArrayList2.addAll(1, myArrayList1);

        for(int i = 0; i < 6; i++) {
            Assert.assertEquals(expected[i], myArrayList2.get(i));
        }
    }

    @Test
    public void clearTest() {
        int expected = 0;

        myArrayList2.clear();
        int actual = myArrayList2.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsTrueTest() {
        boolean result = myArrayList3.contains("you");

        Assert.assertTrue(result);
    }

    @Test
    public void containsFalseTest() {
        boolean result = myArrayList3.contains("oyu");

        Assert.assertFalse(result);
    }

    @Test
    public void containsAllTest() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("you");
        list.add("hello");

        boolean result = myArrayList3.containsAll(list);

        Assert.assertTrue(result);
    }

    @Test
    public void containsAllFalseTest() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("there");

        boolean result = myArrayList3.containsAll(list);

        Assert.assertFalse(result);
    }

    @Test
    public void indexOfPresentTest() {
        int expected = 1;

        int actual = myArrayList3.indexOf("you");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOfNotPresentTest() {
        int result = myArrayList3.indexOf("ello");

        Assert.assertTrue(result == -1);
    }

    @Test
    public void isEmptyTrueTest() {
        Assert.assertTrue(myArrayList1.isEmpty());
    }

    @Test
    public void isEmptyFalseTest() {
        Assert.assertFalse(myArrayList2.isEmpty());
    }

    @Test
    public void lastIndexOfNonexistentTest() {
        int expected = -1;

        int actual = myArrayList3.indexOf("howdy");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lastIndexOfWithOneInstanceTest() {
        int expected = 2;

        int actual = myArrayList3.indexOf("guys");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lastIndexOfWithMultipleInstancesTest() {
        myArrayList3.add("hello");
        int expected = 4;

        int actual = myArrayList3.lastIndexOf("hello");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeByIndexTest() {
        String expected = "!";

        String actual = myArrayList3.remove(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeByObjectTrueTest() {
        boolean result = myArrayList2.remove(new Integer(9));

        Assert.assertTrue(result);
    }

    @Test
    public void removeByObjectFalseTest() {
        boolean result = myArrayList2.remove(new Integer(10));

        Assert.assertFalse(result);
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