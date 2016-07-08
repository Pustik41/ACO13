package data_structures.binary_tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by zhabenya on 03.07.16.
 */
public class BinarySearchTreeTest {

    private BinarySearchTree<String> set;

    @Before
    public void setUp() throws Exception {
        set = new BinarySearchTree<>();
        set.add("D");
        set.add("B");
        set.add("K");
        set.add("G");
        set.add("C");
        set.add("I");
        set.add("E");
        set.add("F");
        set.add("O");
    }

    @After
    public void clean(){
        set.clear();
        set = null;
    }

    @Test
    public void testSize() {
        assertEquals(9, set.size());
    }

    @Test
    public void testIsEmpty_false() {
        assertFalse(set.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testAdd_null() {
        String s = null;
        System.out.println(set.add(s));
    }

    @Test
    public void testAdd_same_argument() {
        String s = "K";
        System.out.println(set.add(s));
        assertEquals(9, set.size());
    }

    @Test
    public void testContains_false() {
        assertFalse(set.contains("W"));
    }

    @Test
    public void testContains_true() {
        assertTrue(set.contains("K"));
    }

    @Test
    public void testLower_equals_argument() {
        assertEquals("E", set.lower("F"));
    }

    @Test
    public void testLower_argument_not_contains() {
        assertEquals("G", set.lower("H"));
    }

    @Test
    public void testFloor_equals_argument() {
        assertEquals("D", set.floor("D"));
    }

    @Test
    public void testFloor_null() {
        assertEquals(null, set.floor("A"));
    }

    @Test
    public void testCeiling_equals_argument() {
        assertEquals("D", set.ceiling("D"));
    }

    @Test
    public void testCeiling_not_contains() {
        assertEquals("I", set.ceiling("H"));
    }

    @Test
    public void testCeiling_null() {
        assertEquals(null, set.ceiling("Z"));
    }


    @Test
    public void testHigher() {
        assertEquals("K", set.higher("J"));
    }

    @Test
    public void testHigher_equals_argument() {
        assertEquals("E", set.higher("D"));
    }

    @Test
    public void testPollFirst() {
        assertEquals("B", set.pollFirst());
        assertEquals(8, set.size());
    }

    @Test
    public void testPollLast() {
        assertEquals("O", set.pollLast());
        assertEquals(8, set.size());
    }

    @Test
    public void testLast() {
        assertEquals("O", set.last());
        assertEquals(9, set.size());
    }

    @Test
    public void testFirst() {
        assertEquals("B", set.first());
        assertEquals(9, set.size());
    }

    @Test(expected = ArrayStoreException.class)
    public void testToArray_with_argument() {
        Integer[] array = new Integer[20];
        Integer[] array2 = set.toArray(array);
    }

    @Test
    public void testToArra() {
        Object[] array = set.toArray();
        assertEquals(array.length, set.size());
    }

    @Test
    public void testRemove() {
        String s = "K";
        assertTrue(set.remove(s));
    }

    @Test(expected = NullPointerException.class)
    public void testRemove_null() {
        String s = null;
        assertTrue(set.remove(s));
    }

    @Test
    public void testRemove_set_not_contains_this_argument() {
        String s = "W";
        assertFalse(set.remove(s));
    }

    @Test
    public void testContainsAll_true() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "B", "C", "O", "F");
        assertTrue(set.containsAll(list));
    }

    @Test
    public void testContainsAll_false() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "B", "W", "O", "F");
        assertFalse(set.containsAll(list));
    }

    @Test
    public void testContainsAll_null() {
        List<String> list = null;
        assertFalse(set.containsAll(list));
    }

    @Test(expected = ClassCastException.class)
    public void testContainsAll_not_cast() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 4, 5);
        set.containsAll(list);
    }

    @Test
    public void testAddAll_true() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "W", "A", "M", "U");
        set.addAll(list);
        assertTrue(set.containsAll(list));
    }


    @Test
    public void testRemoveAll_true() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "B", "C", "O", "E");
        assertTrue(set.removeAll(list));
        assertEquals(5, set.size());
    }

    @Test(expected = ClassCastException.class)
    public void testRemoveAll_not_cast() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 4, 5);
        assertTrue(set.removeAll(list));
    }

    @Test
    public void testRemoveAll_null() {
        List<String> list = null;
        assertFalse(set.removeAll(list));
        assertEquals(9, set.size());
    }

    @Test
    public void testClear() {
        set.clear();
        assertTrue(set.isEmpty());
    }

}