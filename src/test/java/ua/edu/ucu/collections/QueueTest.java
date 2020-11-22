package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testSize() {
        Queue queue = new Queue();

        assertEquals(queue.size(), 0);

        queue = new Queue(new Object[]{1, 2, 4, 5});
        assertEquals(queue.size(), 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmpty() {
        Queue queue = new Queue();
        queue.peek();
    }

    @Test
    public void testPeek() {
        Queue queue = new Queue(new Object[]{1, 2, 3, -4});
        assertEquals(queue.peek(), 1);

        queue.dequeue();
        assertEquals(queue.peek(), 2);
    }

    @Test
    public void testEnqueue() {
        // empty
        Queue queue = new Queue();
        queue.enqueue(12);
        assertEquals(queue.peek(), 12);

        // not empty
        queue.enqueue(13);
        assertEquals(queue.peek(), 12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueEmpty() {
        Queue queue = new Queue();
        queue.dequeue();
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue(new Object[]{1, 2, 3, -4});
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.size(), 3);
        assertEquals(queue.peek(), 2);

        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.size(), 2);
        assertEquals(queue.peek(), 3);
    }

    @Test
    public void testLast() {
        Queue queue = new Queue(new Object[]{1, 2, 3, -4});
        assertEquals(queue.last(), -4);
        queue.enqueue(-12);
        assertEquals(queue.last(), -12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLastEmpty() {
        Queue queue = new Queue();
        queue.last();
    }
    
}
