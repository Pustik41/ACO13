package data_structures.my_queue;

import org.junit.*;

import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyArrayQueueTest {

    Queue<String> queue;

    @Before
    public void setUp(){

        queue = new MyArrayQueue<>(5);
        queue.add("A");
        queue.add("B");
        queue.add("C");
    }

    @Test
    public void testSize() {
        assertEquals(3, queue.size());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(false, queue.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testAdd(){
        queue.add("C");
        queue.add("C");
        queue.add("D");
    }

    @Test
    public void testOffer() {
        queue.offer("C");
        queue.offer("C");
        assertEquals(false, queue.offer("D"));
    }

    @Test
    public void testRemove() {
        queue.remove();
        assertEquals("B", queue.remove());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemove2() {
        queue.clear();
        queue.remove();
    }

    @Test
    public void testPoll() {
        assertEquals("A", queue.poll());
        assertEquals(2, queue.size());
    }

    @Test
    public void testPoll2() {
        queue.clear();
        assertEquals(null, queue.poll());

    }

    @Test
    public void testElement()  {
        assertEquals("A", queue.element());
        assertEquals(3, queue.size());
    }

    @Test
    public void testElement2() {
        queue.clear();
        queue.element();
    }

    @Test
    public void testPeek() {
        assertEquals("A", queue.peek());
        assertEquals(3, queue.size());
    }

    @Test
    public void testPeek2() {
        queue.clear();
        assertEquals(null, queue.peek());
    }
}