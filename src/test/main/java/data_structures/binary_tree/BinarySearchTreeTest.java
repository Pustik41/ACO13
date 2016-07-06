package data_structures.binary_tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        set.add("B");
        set.add("A");
        set.add("D");
        set.add("G");
        set.add("C");
        set.add("I");
        set.add("E");
        set.add("F");
    }

    @After
    public void clean(){

    }

    @Test
    public void testSize() {
        assertEquals(8, set.size());
    }

    @Test
    public void testIsEmpty_false() {
        assertFalse(set.isEmpty());
    }

    @Test
    public void testAdd() {

    }

    @Test
    public void testContains_false() {
        assertFalse(set.contains("W"));
    }

    @Test
    public void testContains_true() {
        set.add("A");
        assertTrue(set.contains("A"));
    }

    @Test
    public void testLower_() {
        assertEquals("F", set.lower("G"));
    }

    @Test
    public void testFloor() {
        assertEquals("D", set.floor("D"));
    }

    @Test
    public void testFloor_null() {
        assertEquals(null, set.floor("Z"));
    }
}