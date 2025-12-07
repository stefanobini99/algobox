package com.stefano.algobox.algorithms.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableQueueTest {

    @Test
    void testEnqueueAndDequeue() {
        ImmutableQueue<Integer> queue = ImmutableQueue.empty();
        queue = queue.enqueue(1).enqueue(2);
        assertEquals(1, queue.peek(), "First element should be 1");

        queue = queue.dequeue();
        assertEquals(2, queue.peek(), "First element should now be 2");
    }

    @Test
    void testIsEmpty() {
        ImmutableQueue<Integer> queue = ImmutableQueue.empty();
        assertTrue(queue.isEmpty(), "Queue should be empty initially");

        queue = queue.enqueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
    }

    @Test
    void testPeekAndDequeueEmptyQueue() {
        ImmutableQueue<Integer> queue = ImmutableQueue.empty();
        assertThrows(IllegalStateException.class, queue::peek, "Should throw exception on peek for empty queue");
        assertThrows(IllegalStateException.class, queue::dequeue, "Should throw exception on dequeue for empty queue");
    }
}
