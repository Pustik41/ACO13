package ClassWork.utils.test;

import ClassWork.utils.myStack.MyArrayStack;
import ClassWork.utils.myStack.MyStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyArrayStackTest {

    MyStack<String> stack = new MyArrayStack<>(5);


    @Test
    public void testPush() throws Exception {
        String s = null;
        stack.push(s);
        assertEquals(false, stack.empty());
    }

    @Test
    public void testPop() throws Exception {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.pop());
    }

    @Test
    public void testPeek() throws Exception {
        stack.push("G");
        assertEquals("G", stack.peek());
    }

    @Test
    public void testEmpty() throws Exception {
        assertEquals(true, stack.empty());
    }

    @Test
    public void testSearch() throws Exception {
        String s = null;
        stack.push(s);
        assertEquals(0, stack.search(s));
    }

    @Test
    public void testPush2() throws Exception {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("B", stack.peek());
    }

    @Test
    public void testPop2() throws Exception {
        assertEquals(null, stack.pop());
    }

    @Test
    public void testEmpty2() throws Exception {
        stack.push("G");
        assertEquals(false, stack.empty());
    }

    @Test
    public void testSearch2() throws Exception {
        String s = null;
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("B");
        stack.push("C");
        assertEquals(4, stack.search("C"));
    }
}