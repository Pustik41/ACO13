package data_structures.my_queue;

import org.junit.*;

import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyLinkedQueueTest {


    Queue<String> queue;

    @Before
    public void setUp() throws Exception {

        queue =  new MyLinkedQueue<>();
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

    @Test
    public void testOffer(){
        assertEquals(true, queue.offer("D"));
    }

    @Test
    public void testRemove() {
        queue.remove();
        assertEquals("B", queue.remove());
    }

    @Test
    public void testRemove2() {
        queue.clear();
        assertEquals(null, queue.remove());
    }

    @Test
    public void testPoll() {
        assertEquals("A", queue.poll());
        assertEquals(2, queue.size());
    }

    @Test
    public void testElement() {
        assertEquals("A", queue.element());
        assertEquals(3, queue.size());
    }

    @Test
    public void testElement2() {
        queue.clear();
        assertEquals(null, queue.element());
    }

    @Test
    public void testPeek() {
        assertEquals("A", queue.peek());
        assertEquals(3, queue.size());
    }
}