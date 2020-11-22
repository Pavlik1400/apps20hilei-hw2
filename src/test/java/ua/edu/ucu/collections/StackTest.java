package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testSize() {
        Stack stack = new Stack();

        assertEquals(stack.size(), 0);

        stack = new Stack(new Object[]{1, 2, 4, 5});
        assertEquals(stack.size(), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmpty() {
        Stack stack = new Stack();
        stack.peek();
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack(new Object[]{1, 2, 3, -4});
        assertEquals(stack.peek(), -4);

        stack.pop();
        assertEquals(stack.peek(), 3);
    }

    @Test
    public void testPush() {
        // empty
        Stack stack = new Stack();
        stack.push(12);
        assertEquals(stack.peek(), 12);

        // not empty
        stack.push(13);
        assertEquals(stack.peek(), 13);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPushEmpty() {
        Stack stack = new Stack();
        stack.pop();
    }

    @Test
    public void testPop() {
        Stack stack = new Stack(new Object[]{1, 2, 3, -4});
        assertEquals(stack.pop(), -4);
        assertEquals(stack.size(), 3);
        assertEquals(stack.peek(), 3);

        assertEquals(stack.pop(), 3);
        assertEquals(stack.size(), 2);
        assertEquals(stack.peek(), 2);
    }
    
}
