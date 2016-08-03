package data_structures.myList.my_linkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dfsdfsddfsdf on 20.07.16.
 */
public class MyLinkedListTest {

    List<String> list;

    @Before
    public void setUp() throws Exception {
        list = new MyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
    }

    @After
    public void tearDown() throws Exception {
        list.clear();
    }

    @Test
    public void testSize() {
        assertEquals(6, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    public void testContains() {
        assertTrue(list.contains("C"));
    }

    @Test
    public void testContains_null() {
        String s = null;
        assertFalse(list.contains(s));
    }

    @Test
    public void testGet() {
        assertEquals("A", list.get(0));
    }

    @Test(expected = MyIndexOutBoundExeption.class)
    public void testGet_greater_possible_index() {
        list.get(8);
    }

    @Test
    public void testTo_array() {
        assertEquals(6, list.toArray().length);
    }

    @Test
    public void testTo_array_if_list_is_empty() {
        list.clear();
        assertEquals(0, list.toArray().length);
    }

    @Test(expected = MyIndexOutBoundExeption.class)
    public void testRemove_by_greater_possible_index() {
        list.remove(9);
    }

    @Test
    public void testRemove_by_index() {
        assertEquals("D", list.remove(3));
        assertEquals(5, list.size());
        assertFalse(list.contains("D"));
    }

    @Test
    public void testRemove_by_object() {
        assertTrue(list.remove("E"));
    }

    @Test
    public void testRemove_by_object_value_null() {
        assertFalse(list.remove(null));
    }

    @Test
    public void testRemove_by_object_when_list_is_empty() {
        list.clear();
        assertFalse(list.remove("D"));
    }

    @Test
    public void testAdd_all_from_collections() {
        List<String> listAdd = new MyLinkedList<>();
        Collections.addAll(listAdd, "K", "Z", "M");
        list.addAll(listAdd);
        assertEquals(9, list.size());
    }

    @Test
    public void testAdd_by_index_and_element() {
        list.add(4, "Z");
        assertTrue(list.contains("Z"));
        assertEquals("E", list.get(5));
        assertEquals(7, list.size());
    }

    @Test(expected = MyIndexOutBoundExeption.class)
    public void testAdd_by_great_index_and_element() {
        list.add(8, "Z");
    }

    @Test
    public void testAdd_by_index_and_element_if_size_1() {
        list.clear();
        list.add("A");
        list.add(1, "Z");
        assertTrue(list.contains("Z"));
        assertEquals(2, list.size());
    }

    @Test
    public void testAdd_by_index_value_0_and_element_if_size_1() {
        list.clear();
        list.add("A");
        list.add(0, "Z");
        assertEquals(2, list.size());
        assertEquals("A", list.get(1));
    }

    @Test
    public void testAdd_all_by_index_value_0_from_collections() {
        List<String> listAdd = new MyLinkedList<>();
        Collections.addAll(listAdd, "K", "Z", "M");
        list.addAll(0, listAdd);
        assertEquals(9, list.size());
        assertEquals("A", list.get(3));
    }

    @Test
    public void testAdd_all_by_index_value_last_from_collections() {
        List<String> listAdd = new MyLinkedList<>();
        Collections.addAll(listAdd, "K", "Z", "M");
        list.addAll(6, listAdd);
        assertEquals(9, list.size());
        assertEquals("F", list.get(5));
    }

    @Test
    public void testAdd_all_by_index_from_collections() {
        List<String> listAdd = new MyLinkedList<>();
        Collections.addAll(listAdd, "K", "Z", null);
        list.addAll(3, listAdd);
        assertEquals(9, list.size());
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(6));
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(3, list.lastIndexOf("D"));
    }

    @Test
    public void testLastIndexOf_null() {
        list.add(4, null);
        assertEquals(4, list.lastIndexOf(null));
    }

    @Test
    public void testLastIndexOf_not_contain() {
        assertEquals(-1, list.lastIndexOf("Z"));
    }

    @Test
    public void testSubList() {
        System.out.println(list.subList(1, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubList_if_fromIndex_greater_toIndex() {
        list.subList(5, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSubList_if_fromIndex_or_toIndex_out_indexes_interval() {
        list.subList(3, 6);
    }

    @Test
    public void testContainsAll_true() {
        List<String> listContains = new MyLinkedList<>();
        Collections.addAll(listContains, "B", "D", "E");
        assertTrue(list.containsAll(listContains));
    }

    @Test
    public void testContainsAll_false() {
        List<String> listContains = new MyLinkedList<>();
        Collections.addAll(listContains, "B", "D", "Z");
        assertFalse(list.containsAll(listContains));
    }

    @Test
    public void testContainsAll_with_null_in_list() {
        list.add(null);
        List<String> listContains = new MyLinkedList<>();
        Collections.addAll(listContains, "B", null, "E");
        assertTrue(list.containsAll(listContains));
    }

    @Test(expected = ClassCastException.class)
    public void testContainsAll_wrong_type() {
        List<Integer> listContains = new ArrayList<>();
        Collections.addAll(listContains, 1, 2, 3);
        list.containsAll(listContains);
    }

    @Test
    public void testRemoveAll_true() {
        List<String> listToRemove = new MyLinkedList<>();
        Collections.addAll(listToRemove, "B", "D", "E");
        assertTrue(list.removeAll(listToRemove));
    }

    @Test
    public void testRemoveAll_true_with_element_no_contain() {
        List<String> listToRemove = new MyLinkedList<>();
        Collections.addAll(listToRemove, "B", "D", "Z");
        assertTrue(list.removeAll(listToRemove));
    }

    @Test
    public void testRemoveAll_false() {
        List<String> listToRemove = new MyLinkedList<>();
        Collections.addAll(listToRemove, "Z");
        assertFalse(list.removeAll(listToRemove));
    }

    @Test(expected = ClassCastException.class)
    public void testRemoveAll_wrong_type() {
        List<Integer> listToRemove = new ArrayList<>();
        Collections.addAll(listToRemove, 1, 2, 3);
        list.removeAll(listToRemove);
    }

    @Test
    public void testRetainAll() {
        List<String> listNotDel = new MyLinkedList<>();
        Collections.addAll(listNotDel, "D", "B", "Z");
        list.retainAll(listNotDel);
        assertEquals(2, list.size());
    }

    @Test(expected = ClassCastException.class)
    public void testRetainAll_wrong_type() {
        List<Integer> listNotDel = new ArrayList<>();
        Collections.addAll(listNotDel, 1, 2, 3);
        list.retainAll(listNotDel);
    }
}