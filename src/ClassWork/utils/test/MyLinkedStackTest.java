package ClassWork.utils.test;

import ClassWork.utils.myStack.MyLinkedStack;
import ClassWork.utils.myStack.MyStack;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyLinkedStackTest {

    MyStack<String> stack = new MyLinkedStack<>();

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
        assertEquals(0, stack.search("C"));
    }
}