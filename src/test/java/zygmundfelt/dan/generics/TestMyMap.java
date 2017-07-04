package zygmundfelt.dan.generics;

import org.junit.*;

public class TestMyMap {

    MyMap<String,Number> myMap1;
    MyMap<String,Integer> myMap2;
    MyMap<Integer,Integer> myEmptyMap;

    @Before
    public void initialize() {
        myEmptyMap = new MyMap<Integer, Integer>();

        myMap1 = new MyMap<String, Number>();
        myMap1.put("George Gervin", 44);

        myMap2 = new MyMap<String, Integer>(12);
        myMap2.put("Tim Duncan",21);
        myMap2.put("Manu Ginobili",20);
        myMap2.put("Kawhi Leonard",2);
        myMap2.put("Tony Parker",9);
    }

    @Test
    public void testClear() {
        int expected = 0;

        myMap2.clear();
        int actual = myMap2.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsKeyTrueTest() {
        boolean result = myMap2.containsKey("Tim Duncan");

        Assert.assertTrue(result);
    }

    @Test
    public void containsKeyFalseTest() {
        boolean result = myMap2.containsKey("Bruce Bowen");

        Assert.assertFalse(result);
    }

    @Test
    public void containsValueTrueTest() {
        boolean result = myMap2.containsValue(20);

        Assert.assertTrue(result);
    }

    @Test
    public void containsValueFalseTest() {
        boolean result = myMap2.containsValue(0);

        Assert.assertFalse(result);
    }

    @Test
    public void entrySetTest() {
        //TODO
    }

    @Test
    public void getPresentTest() {
        Integer expected = 9;

        Integer actual = myMap2.get("Tony Parker");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNonexistentTest() {
        Integer result = myMap2.get("Rasho Nesterovic");

        Assert.assertTrue(result == null);
    }

    @Test
    public void hashCodeTest() {
        int expected = 1586382501;

        int actual = myMap2.hashCode();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isEmptyTrueTest() {
        boolean result = myEmptyMap.isEmpty();

        Assert.assertTrue(result);
    }

    @Test
    public void isEmptyFalseTest() {
        boolean result = myMap2.isEmpty();

        Assert.assertFalse(result);
    }

    @Test
    public void keySetTest() {
        //TODO
    }

    @Test
    public void putNewEntryTest() {
        int expected = 5;

        myMap2.put("David Robinson",50);
        int actual = myMap2.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void putPreexistingEntryTest() {
        Integer expected = 100;

        myMap2.put("Tim Duncan", 100);
        Integer actual = myMap2.get("Tim Duncan");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void putAllTest() {
        int expected = 5;

        myMap1.putAll(myMap2);
        int actual = myMap1.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeExistingEntryTest() {
        Integer result = myMap2.remove("Tim Duncan");

        Assert.assertTrue(result != null);
    }

    @Test
    public void removeNonexistentEntryTest() {
        Integer result = myMap2.remove("Sean Elliott");

        Assert.assertTrue(result == null);
    }

    @Test
    public void sizeTest() {
        Assert.assertTrue(myMap2.size() == 4);
    }

    @Test
    public void valuesTest() {
        //TODO
    }
}
