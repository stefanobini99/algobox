package com.stefano.algobox.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void testNaive() {
        assertEquals(0, Fibonacci.naive(0), "Naive Fibonacci for 0 should be 0");
        assertEquals(1, Fibonacci.naive(1), "Naive Fibonacci for 1 should be 1");
        assertEquals(55, Fibonacci.naive(10), "Naive Fibonacci for 10 should be 55");
    }

    @Test
    void testMemoized() {
        assertEquals(0, Fibonacci.memoized(0), "Memoized Fibonacci for 0 should be 0");
        assertEquals(1, Fibonacci.memoized(1), "Memoized Fibonacci for 1 should be 1");
        assertEquals(55, Fibonacci.memoized(10), "Memoized Fibonacci for 10 should be 55");
    }

    @Test
    void testIterative() {
        assertEquals(0, Fibonacci.iterative(0), "Iterative Fibonacci for 0 should be 0");
        assertEquals(1, Fibonacci.iterative(1), "Iterative Fibonacci for 1 should be 1");
        assertEquals(55, Fibonacci.iterative(10), "Iterative Fibonacci for 10 should be 55");
    }

    @Test
    void testLargeFibonacci() {
        assertEquals(832040, Fibonacci.iterative(30), "Iterative Fibonacci for 30 should be 832040");
    }
}
