package com.stefano.algobox.algorithms.sorting;

/**
 * Idiomatic, optimized imperative implementation of Bubble Sort.
 * This implementation:
 * - Never mutates the caller’s array (uses defensive cloning)
 * - Stops early when the array becomes sorted
 * - Minimizes unnecessary comparisons
 */
public final class BubbleSortIterative implements SortAlgorithm {

    @Override
    public int[] sort(int[] input) {
        int[] arr = input.clone(); // defensive copy

        for (int pass = 0; pass < arr.length - 1; pass++) {
            boolean swapped = false;

            for (int i = 0; i < arr.length - 1 - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }

            if (!swapped) break; // early-exit optimization
        }

        return arr;
    }
}
