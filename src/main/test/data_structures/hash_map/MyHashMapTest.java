package data_structures.hash_map;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by dfsdfsddfsdf on 22.07.16.
 */
public class MyHashMapTest {

    MyHashMap<Integer, String> map;

    @Before
    public void setUp() {

        map = new MyHashMap<>(3);
        map.put(6, "A");
        map.put(21, "B");
        map.put(null, "Z");
        map.put(18, "C");
        map.put(42, "D");
    }

    @Test
    public void testSize() {
        assertEquals(5, map.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(map.isEmpty());
    }

    @Test
    public void testContainsKey_true() {
        assertTrue(map.containsKey(21));
    }

    @Test
    public void testContainsKey_false() {
        assertFalse(map.containsKey(41));
    }

    @Test
    public void testContainsKey_when_key_null() {
        assertTrue(map.containsKey(null));
    }

    @Test
    public void testContainsValue_true() {
        assertTrue(map.containsValue("C"));
    }

    @Test
    public void testContainsValue_false() {
        assertFalse(map.containsValue("W"));
    }

    @Test
    public void testContainsValue_when_value_null() {
        map.put(13, null);
        assertTrue(map.containsValue(null));
    }

    @Test
    public void testPut_when_same_key() {
        assertEquals("C", map.put(18, "H"));
    }

    @Test
    public void testPut_when_same_key_null() {
        assertEquals("Z", map.put(null, "L"));
    }

    @Test
    public void testGet_by_key() {
        assertEquals("B", map.get(21));
    }

    @Test
    public void testGet_by_key_null() {
        assertEquals("Z", map.get(null));
    }

    @Test
    public void testEntrySet() {
        Set<MyHashMap.MyEntry<Integer, String>> set = map.entrySet();
        assertEquals(map.size(), set.size());
    }

    @Test
    public void testKeySet() {
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            System.out.println(integer);
        }
        assertEquals(map.size(), set.size());
    }

    @Test
    public void testValues() {
        Collection<String> collection = map.values();
        System.out.println(collection);
        assertEquals(map.size(), collection.size());
    }

    @Test
    public void testPutAll() {
        Map<Integer, String> mapTest = new HashMap<>();
        map.put(32, "D");
        map.put(64, "J");
        map.put(71, "Q");
        int size = map.size() + mapTest.size();
        map.putAll(mapTest);
        assertEquals(size, map.size());
    }

    @Test
    public void testPutAll_same_key() {
        Map<Integer, String> mapTest = new HashMap<>();
        map.put(32, "D");
        map.put(18, "J");
        map.put(71, "Q");
        map.putAll(mapTest);
        assertFalse(map.containsValue("C"));
    }

    @Test
    public void testRemove_return_del_value() {
        assertEquals("A", map.remove(6));
        assertFalse(map.containsValue("A"));
        assertEquals("C", map.get(18));
    }

    @Test
    public void testRemove_if_have_collision() {
        assertEquals("C", map.remove(18));
        assertFalse(map.containsValue("C"));
        assertEquals("D", map.get(42));
    }

    @Test
    public void testRemove_if_key_null() {
        assertEquals("Z", map.remove(null));
        assertFalse(map.containsValue("Z"));
    }

    @Test
    public void testRemove_if_key_not_contains() {
        assertEquals(null, map.remove(19));
    }

    @Test
    public void testClear() {
        map.clear();
    }
}