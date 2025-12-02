package com.stefano.algobox.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private final int[] unsorted = {5, 2, 9, 1, 5, 6};
    private final int[] sorted = {1, 2, 5, 5, 6, 9};
    private final int[] single = {42};
    private final int[] empty = {};

    @Test
    void testIterativeBubbleSort() {
        BubbleSortIterative sorter = new BubbleSortIterative();
        int[] result = sorter.sort(unsorted);
        assertArrayEquals(sorted, result);
        assertArrayEquals(unsorted, new int[]{5, 2, 9, 1, 5, 6}); // original array unchanged
        assertArrayEquals(single, sorter.sort(single));
        assertArrayEquals(empty, sorter.sort(empty));
    }

    @Test
    void testPureBubbleSort() {
        PureBubbleSort sorter = new PureBubbleSort();
        int[] result = sorter.sort(unsorted);
        assertArrayEquals(sorted, result);
        assertArrayEquals(unsorted, new int[]{5, 2, 9, 1, 5, 6});
        assertArrayEquals(single, sorter.sort(single));
        assertArrayEquals(empty, sorter.sort(empty));
    }
}
