package com.stefano.algobox.algorithms.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void testBinarySearchIterative() {
        int[] arr = {1, 3, 3, 5, 7, 9};
        BinarySearchIterative searcher = new BinarySearchIterative();

        assertEquals(0, searcher.search(arr, 1));
        assertTrue(searcher.search(arr, 3) == 1 || searcher.search(arr, 3) == 2); // first occurrence or any duplicate index
        assertEquals(5, searcher.search(arr, 9));
        assertEquals(-1, searcher.search(arr, 42));

        int[] single = {42};
        assertEquals(0, searcher.search(single, 42));
        assertEquals(-1, searcher.search(single, 10));

        int[] empty = {};
        assertEquals(-1, searcher.search(empty, 1));

        // Original array must remain unchanged
        assertArrayEquals(new int[]{1, 3, 3, 5, 7, 9}, arr);
    }

    @Test
    void testPureBinarySearch() {
        int[] arr = {1, 3, 3, 5, 7, 9};
        PureBinarySearch searcher = new PureBinarySearch();

        assertEquals(0, searcher.search(arr, 1));
        assertTrue(searcher.search(arr, 3) == 1 || searcher.search(arr, 3) == 2); // first occurrence or any duplicate index
        assertEquals(5, searcher.search(arr, 9));
        assertEquals(-1, searcher.search(arr, 42));

        int[] single = {42};
        assertEquals(0, searcher.search(single, 42));
        assertEquals(-1, searcher.search(single, 10));

        int[] empty = {};
        assertEquals(-1, searcher.search(empty, 1));

        // Duplicate values
        int[] duplicates = {1, 2, 2, 2, 3, 4};
        int index = searcher.search(duplicates, 2);
        assertTrue(index >= 1 && index <= 3, "PureBinarySearch should return index of any duplicate element");

        // Original array check
        assertArrayEquals(new int[]{1, 3, 3, 5, 7, 9}, arr);
    }
}
