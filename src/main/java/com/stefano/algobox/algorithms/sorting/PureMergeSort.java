package com.stefano.algobox.algorithms.sorting;

/**
 * Functional-style MergeSort implementation using immutable arrays.
 *
 * <p>This version:
 * <ul>
 *   <li>Never mutates input or intermediate arrays</li>
 *   <li>Uses pure recursion and immutable merge operations</li>
 *   <li>Is clean, expressive, and showcases a functional paradigm</li>
 * </ul>
 */
public final class PureMergeSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] input) {
        if (input == null) return null;
        if (input.length <= 1) return input.clone();
        return mergesort(input.clone());
    }

    private int[] mergesort(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, right.length);

        int[] sortedLeft = mergesort(left);
        int[] sortedRight = mergesort(right);

        return merge(sortedLeft, sortedRight);
    }

    /**
     * Merge two sorted immutable arrays into a new one.
     */
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            result[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }

        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];

        return result;
    }
}
