package ClassWork.utils.test;

import ClassWork.utils.myQueue.MyArrayQueue;
import ClassWork.utils.myQueue.MyLinkedQueue;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyLinkedQueueTest {


    Queue<String> queue =  new MyLinkedQueue<>();

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
    public void testOffer() throws Exception {
        assertEquals(true, queue.offer("D"));
    }

    @Test
    public void testRemove() throws Exception {
        queue.remove();
        assertEquals("B", queue.remove());
    }

    @Test
    public void testRemove2() throws Exception {
        queue.clear();
        assertEquals(null, queue.remove());
    }

    @Test
    public void testPoll() throws Exception {
        assertEquals("A", queue.poll());
        assertEquals(2, queue.size());
    }

    @Test
    public void testElement() throws Exception {
        assertEquals("A", queue.element());
        assertEquals(3, queue.size());
    }

    @Test
    public void testElement2() throws Exception {
        queue.clear();
        assertEquals(null, queue.element());
    }

    @Test
    public void testPeek() throws Exception {
        assertEquals("A", queue.peek());
        assertEquals(3, queue.size());
    }
}