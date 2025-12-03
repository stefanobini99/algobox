package com.stefano.algobox.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void testMergeSortImperative() {
        int[] unsorted = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        MergeSortImperative sorter = new MergeSortImperative();

        int[] result = sorter.sort(unsorted);
        assertArrayEquals(expected, result, "Imperative MergeSort should sort correctly");

        // Original array must remain unchanged
        assertArrayEquals(new int[]{10, 7, 8, 9, 1, 5}, unsorted);

        // Edge cases
        assertArrayEquals(new int[]{42}, sorter.sort(new int[]{42}));
        assertArrayEquals(new int[]{}, sorter.sort(new int[]{}));
    }

    @Test
    void testPureMergeSort() {
        int[] unsorted = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        PureMergeSort sorter = new PureMergeSort();

        int[] result = sorter.sort(unsorted);
        assertArrayEquals(expected, result, "Pure MergeSort should sort correctly");

        // Original array must remain unchanged
        assertArrayEquals(new int[]{10, 7, 8, 9, 1, 5}, unsorted);

        // Edge cases
        assertArrayEquals(new int[]{42}, sorter.sort(new int[]{42}));
        assertArrayEquals(new int[]{}, sorter.sort(new int[]{}));

        // Duplicate values
        int[] duplicates = {5, 1, 5, 2};
        int[] expectedDup = {1, 2, 5, 5};
        assertArrayEquals(expectedDup, sorter.sort(duplicates));
    }
}
