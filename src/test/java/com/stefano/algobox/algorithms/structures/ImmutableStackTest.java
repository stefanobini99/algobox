package com.stefano.algobox.algorithms.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableStackTest {

    @Test
    void testPushAndPop() {
        ImmutableStack<Integer> stack = ImmutableStack.empty();
        stack = stack.push(1).push(2);
        assertEquals(2, stack.peek(), "Peek should return 2");

        stack = stack.pop();
        assertEquals(1, stack.peek(), "Peek should return 1 after popping");
    }

    @Test
    void testIsEmpty() {
        ImmutableStack<Integer> stack = ImmutableStack.empty();
        assertTrue(stack.isEmpty(), "Stack should be empty initially");

        stack = stack.push(1);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
    }

    @Test
    void testPopFromEmptyStack() {
        ImmutableStack<Integer> stack = ImmutableStack.empty();
        assertThrows(IllegalStateException.class, stack::pop, "Should throw exception on pop from empty stack");
    }
}
