package zygmundfelt.dan.generics;

import org.junit.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestMySet {

    private MySet<String> myEmptySet;
    private MySet<String> mySet1;
    private MySet<Number> mySet2;
    private MySet<String> mySet3;
    private MySet<String> mySet4;

    @Before
    public void initialize() {
        myEmptySet = new MySet<String>();

        mySet1 = new MySet<String>();
        mySet1.add("It's");
        mySet1.add("a");
        mySet1.add("test");
        mySet1.add(",");
        mySet1.add("dummy");

        mySet2 = new MySet<Number>();
        mySet2.add(32);
        mySet2.add(-16);
        mySet2.add(8);
        mySet2.add(-4);
        mySet2.add(2);
        mySet2.add(-1);

        mySet3 = new MySet<String>();
        mySet3.add("It's");
        mySet3.add("a");
        mySet3.add("test");
        mySet3.add(",");
        mySet3.add("dummy");

        mySet4 = new MySet<String>();
        mySet4.add("It's");
        mySet4.add("a");
        mySet4.add("test");
        mySet4.add(",");
        mySet4.add("dummie");
    }

    @Test
    public void addTest() {
        myEmptySet.add("a null value");
        int expected = 1;

        int actual = myEmptySet.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAllTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(5);
        mySet2.addAll(list);
        int expected = 8;

        int actual = mySet2.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAllEmptyCollectionTest() {
        List<Integer> list = new ArrayList<Integer>();
        mySet2.addAll(list);
        int expected = 6;

        int actual = mySet2.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearTest() {
        mySet1.clear();

        Assert.assertTrue(mySet1.size() == 0);
    }

    @Test
    public void containsTrueTest() {
        boolean result = mySet1.contains(",");

        Assert.assertTrue(result);
    }

    @Test
    public void containsFalseTest() {
        boolean result = mySet1.contains("dummie");

        Assert.assertFalse(result);
    }

    @Test
    public void containsAllTrueTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(32);
        list.add(8);
        list.add(2);

        boolean result = mySet2.containsAll(list);

        Assert.assertTrue(result);
    }

    @Test
    public void containsAllFalseCollectionContainsSomeTest() {
        List<Number> list = new ArrayList<Number>();
        list.add(32);
        list.add(0);
        list.add(8);

        boolean result = mySet2.containsAll(list);

        Assert.assertFalse(result);
    }

    @Test
    public void containsAllFalseCollectionContainsNoneTest() {
        List<Integer> list = new LinkedList<Integer>();
        list.add(3);
        list.add(-3);

        boolean result = mySet2.containsAll(list);

        Assert.assertFalse(result);
    }

    @Test
    public void equalsTrueTest() {
        boolean result = mySet1.equals(mySet3);

        Assert.assertTrue(result);
    }

    @Test
    public void equalsNullFalseTest() {
        MySet<String> nullSet = null;

        boolean result = mySet1.equals(nullSet);

        Assert.assertFalse(result);
    }

    @Test
    public void equalsDifferentTypeFalseTest() {
        boolean result = mySet1.equals(mySet2);

        Assert.assertFalse(result);
    }

    @Test
    public void equalsSameTypeDifferentSizeFalseTest() {
        boolean result = mySet1.equals(mySet4);

        Assert.assertFalse(result);
    }

    @Test
    public void hashCodeTest() {
        int expected = 101790078;

        int actual = mySet1.hashCode();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTrueTest() {
        boolean result = myEmptySet.isEmpty();

        Assert.assertTrue(result);
    }

    @Test
    public void isEmptyFalseTest() {
        boolean result = mySet2.isEmpty();

        Assert.assertFalse(result);
    }

    @Test
    public void removePresentItemTest() {
        boolean result = mySet2.remove(8);

        Assert.assertTrue(result);
    }

    @Test
    public void removeNonexistentItemTest() {
        boolean result = mySet2.remove(6);

        Assert.assertFalse(result);
    }

    @Test
    public void removeAllWithAllItemsPresentTrueTest() {
        List<String> list = new LinkedList<String>();
        list.add(",");
        list.add("dummy");

        boolean result = mySet1.removeAll(list);

        Assert.assertTrue(result);
    }

    @Test
    public void removeAllWithSomeItemsPresentTrueTest() {
        List<String> list = new LinkedList<String>();
        list.add("?");      //item not present
        list.add(",");
        list.add("dumdum"); //item not present

        boolean result = mySet1.removeAll(list);

        Assert.assertTrue(result);
    }

    @Test
    public void removeAllWithNoItemsPresentFalseTest() {
        List<String> list = new LinkedList<String>();
        list.add("?");
        list.add("dumdum");

        boolean result = mySet1.removeAll(list);

        Assert.assertFalse(result);
    }

    @Test
    public void retainAllTrueTest() {
        List<String> list = new LinkedList<String>();
        list.add(",");
        list.add("dummy");

        boolean result = mySet1.retainAll(list);

        Assert.assertTrue(result);
    }

    @Test
    public void retainAllFalseTest() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(32);
        list.add(-16);
        list.add(8);
        list.add(-4);
        list.add(2);
        list.add(-1);

        boolean result = mySet2.retainAll(list);

        Assert.assertFalse(result);
    }

    @Test
    public void toArrayEmptyTest() {
        Object[] expected = new Object[0];

        Object[] actual = myEmptySet.toArray();

        Assert.assertEquals(expected.length, actual.length);
    }

    @Test
    public void toArrayNonemptyTest() {
        Object[] expected = {"It's", "a", "test", ",", "dummy"};

        Object[] actual = mySet1.toArray();

        for(int i = 0; i < 5; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }

}
