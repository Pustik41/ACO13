package data_structures.my_stack;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyArrayStackTest {

    MyStack<String> stack;

    @Before
    public void setUp() {

        stack = new MyArrayStack<>(5);
        stack.push("A");
        stack.push("B");
        stack.push("C");
    }

    @Test
    public void testPush() {
        String s = null;
        stack.push(s);
        assertEquals(false, stack.empty());
    }

    @Test
    public void testPop() {
        stack.pop();
        stack.pop();

        assertEquals("A", stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push("G");
        assertEquals("G", stack.peek());
    }

    @Test
    public void testEmpty() {
        assertEquals(false, stack.empty());
    }

    @Test
    public void testSearch() {
        String s = null;
        stack.push(s);
        assertEquals(3, stack.search(s));
    }

    @Test
    public void testPush2() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("B", stack.peek());
    }

    @Test
    public void testEmpty2() {
        stack.push("G");
        assertEquals(false, stack.empty());
    }

    @Test
    public void testSearch2() {
        stack.push("B");
        stack.push("C");
        assertEquals(4, stack.search("C"));
    }
}