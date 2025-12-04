package com.stefano.algobox.algorithms.sorting;

import java.util.Arrays;

/**
 * Functional-style QuickSort implementation that uses immutable arrays.
 *
 * <p>This version:
 * <ul>
 *   <li>Never mutates any data structure</li>
 *   <li>Recursively partitions the input around a pivot</li>
 *   <li>Creates new arrays for "less", "equal", and "greater" partitions</li>
 * </ul>
 *
 * <p>This implementation emphasizes functional programming concepts,
 * clarity, and correctness rather than raw performance.</p>
 */
public final class PureQuickSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input == null) return null;
        if (input.length <= 1) return input.clone();
        return quicksort(input);
    }

    /**
     * Functional QuickSort implementation.
     */
    private int[] quicksort(int[] arr) {
        if (arr.length <= 1) return arr;

        int pivot = arr[arr.length / 2];

        int[] less = Arrays.stream(arr).filter(x -> x < pivot).toArray();
        int[] equal = Arrays.stream(arr).filter(x -> x == pivot).toArray();
        int[] greater = Arrays.stream(arr).filter(x -> x > pivot).toArray();

        int[] left = quicksort(less);
        int[] right = quicksort(greater);

        return concat(left, equal, right);
    }

    /**
     * Concatenates three arrays into a new immutable array.
     */
    private int[] concat(int[] a, int[] b, int[] c) {
        int[] result = new int[a.length + b.length + c.length];
        int pos = 0;

        for (int v : a) result[pos++] = v;
        for (int v : b) result[pos++] = v;
        for (int v : c) result[pos++] = v;

        return result;
    }
}
