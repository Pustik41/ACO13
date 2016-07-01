package ClassWork.utils.test;

import ClassWork.utils.myQueue.MyArrayQueue;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyArrayQueueTest {

    Queue<String> queue = new MyArrayQueue<>(5);

    @Before
    public void setUp() throws Exception {
        queue.add("A");
        queue.add("B");
        queue.add("C");
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(3, queue.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        String s = "C";
        assertEquals(true, queue.contains(s));
    }

    @Test
    public void testContains2() throws Exception {
        String s = null;
        queue.add(s);
        assertEquals(true, queue.contains(s));
    }

    @Test
    public void testRemoveObject() throws Exception {
        String s = "C";
        assertEquals(true, queue.remove(s));
    }

    @Test
    public void testRemoveObject2() throws Exception {
        String s = null;
        queue.add(s);
        assertEquals(true, queue.remove(s));
    }

    @Test(expected = IllegalStateException.class)
    public void testAdd() throws Exception {
        queue.add("C");
        queue.add("C");
        queue.add("D");
    }

    @Test
    public void testOffer() throws Exception {
        queue.offer("C");
        queue.offer("C");
        assertEquals(false, queue.offer("D"));
    }

    @Test
    public void testRemove() throws Exception {
        queue.remove();
        assertEquals("B", queue.remove());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove2() throws Exception {
        queue.clear();
        queue.remove();
    }

    @Test
    public void testPoll() throws Exception {
        assertEquals("A", queue.poll());
        assertEquals(2, queue.size());
    }

    @Test
    public void testPoll2() throws Exception {
        queue.clear();
        assertEquals(null, queue.poll());

    }

    @Test
    public void testElement() throws Exception {
        assertEquals("A", queue.element());
        assertEquals(3, queue.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testElement2() throws Exception {
        queue.clear();
        queue.element();
    }

    @Test
    public void testPeek() throws Exception {
        assertEquals("A", queue.peek());
        assertEquals(3, queue.size());
    }

    @Test
    public void testPeek2() throws Exception {
        queue.clear();
        assertEquals(null, queue.peek());
    }
}