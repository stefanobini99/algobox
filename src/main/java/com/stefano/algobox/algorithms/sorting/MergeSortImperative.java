package com.stefano.algobox.algorithms.sorting;

/**
 * Imperative top-down MergeSort implementation.
 *
 * <p>This version:
 * <ul>
 *   <li>Uses a defensive clone of the input to preserve immutability externally</li>
 *   <li>Uses a reusable temporary buffer during merging for efficiency</li>
 *   <li>Performs recursive divide-and-conquer sorting</li>
 *   <li>Runs in O(n log n) time</li>
 * </ul>
 */
public final class MergeSortImperative implements SortAlgorithm {

    @Override
    public int[] sort(int[] input) {
        int[] arr = input.clone();
        int[] temp = new int[arr.length];
        mergesort(arr, temp, 0, arr.length - 1);
        return arr;
    }

    private void mergesort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergesort(arr, temp, left, mid);
        mergesort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    /**
     * Merge two sorted halves of arr using temp buffer.
     */
    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) arr[k++] = temp[i++];
            else arr[k++] = temp[j++];
        }

        while (i <= mid) arr[k++] = temp[i++];
        // Right half remaining elements already in correct position
    }
}
