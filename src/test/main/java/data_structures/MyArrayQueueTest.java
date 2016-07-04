package data_structures;

import data_structures.myQueue.MyArrayQueue;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyArrayQueueTest {

    Queue<String> queue = new MyArrayQueue<>(5);

    @Before
    public void setUp(){
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
    public void testContains(){
        String s = "C";
        assertEquals(true, queue.contains(s));
    }

    @Test
    public void testContains2(){
        String s = null;
        queue.add(s);
        assertEquals(true, queue.contains(s));
    }

    @Test
    public void testRemoveObject(){
        String s = "C";
        assertEquals(true, queue.remove(s));
    }

    @Test
    public void testRemoveObject2(){
        String s = null;
        queue.add(s);
        assertEquals(true, queue.remove(s));
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
    public void testRemove2() throws Exception {
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

    @Test(expected = NoSuchElementException.class)
    public void testElement2() throws Exception {
        queue.clear();
        queue.element();
    }

    @Test
    public void testPeek()  {
        assertEquals("A", queue.peek());
        assertEquals(3, queue.size());
    }

    @Test
    public void testPeek2() {
        queue.clear();
        assertEquals(null, queue.peek());
    }
}