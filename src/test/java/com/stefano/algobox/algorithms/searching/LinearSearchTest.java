package com.stefano.algobox.algorithms.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @Test
    void testLinearSearchIterative() {
        int[] arr = {5, 3, 7, 1, 9, 3};
        LinearSearchIterative searcher = new LinearSearchIterative();

        assertEquals(0, searcher.search(arr, 5));
        assertEquals(1, searcher.search(arr, 3)); // first occurrence
        assertEquals(4, searcher.search(arr, 9));
        assertEquals(-1, searcher.search(arr, 42));

        int[] single = {42};
        assertEquals(0, searcher.search(single, 42));
        assertEquals(-1, searcher.search(single, 10));

        int[] empty = {};
        assertEquals(-1, searcher.search(empty, 1));

        assertArrayEquals(new int[]{5, 3, 7, 1, 9, 3}, arr); // immutability
    }

    @Test
    void testPureLinearSearch() {
        int[] arr = {5, 3, 7, 1, 9, 3};
        PureLinearSearch searcher = new PureLinearSearch();

        assertEquals(0, searcher.search(arr, 5));
        assertEquals(1, searcher.search(arr, 3));
        assertEquals(4, searcher.search(arr, 9));
        assertEquals(-1, searcher.search(arr, 42));

        int[] single = {42};
        assertEquals(0, searcher.search(single, 42));
        assertEquals(-1, searcher.search(single, 10));

        int[] empty = {};
        assertEquals(-1, searcher.search(empty, 1));

        // Duplicate handling
        int[] duplicates = {5, 1, 5, 2};
        assertEquals(0, searcher.search(duplicates, 5));
    }
}
