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

    private Set<String> set;

    @Before
    public void setUp() throws Exception {

        set = new BinarySearchTree<>();
    }

    @After
    public void clean(){

    }

    @Test
    public void testSize() throws Exception {
        set.add("A");
        assertEquals(1, set.size());
    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testContains_false() throws Exception {
        assertFalse(set.contains("A"));
    }

    @Test
    public void testContains_true() throws Exception {
        set.add("A");
        assertTrue(set.contains("A"));
    }
}