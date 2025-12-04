package com.stefano.algobox.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testQuickSortIterative() {
        int[] unsorted = {8, 3, 7, 4, 9, 2};
        int[] expected = {2, 3, 4, 7, 8, 9};
        QuickSortIterative sorter = new QuickSortIterative();

        int[] result = sorter.sort(unsorted);
        assertArrayEquals(expected, result, "Iterative QuickSort should sort correctly");

        // Original array must remain unchanged
        assertArrayEquals(new int[]{8, 3, 7, 4, 9, 2}, unsorted, "Original array must be immutable");

        // Edge cases
        assertArrayEquals(new int[]{42}, sorter.sort(new int[]{42}));
        assertArrayEquals(new int[]{}, sorter.sort(new int[]{}));
    }

    @Test
    void testPureQuickSort() {
        int[] unsorted = {8, 3, 7, 4, 9, 2};
        int[] expected = {2, 3, 4, 7, 8, 9};
        PureQuickSort sorter = new PureQuickSort();

        int[] result = sorter.sort(unsorted);
        assertArrayEquals(expected, result, "Pure QuickSort should sort correctly");

        // Original array must remain unchanged
        assertArrayEquals(new int[]{8, 3, 7, 4, 9, 2}, unsorted, "Original array must be immutable");

        // Edge cases
        assertArrayEquals(new int[]{42}, sorter.sort(new int[]{42}));
        assertArrayEquals(new int[]{}, sorter.sort(new int[]{}));

        // Duplicate values
        int[] duplicates = {5, 1, 5, 2};
        int[] expectedDup = {1, 2, 5, 5};
        assertArrayEquals(expectedDup, sorter.sort(duplicates));
    }
}
