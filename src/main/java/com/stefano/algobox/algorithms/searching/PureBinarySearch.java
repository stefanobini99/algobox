package com.stefano.algobox.algorithms.searching;

/**
 * Functional-style recursive implementation of Binary Search.
 *
 * <p>This version:
 * <ul>
 *   <li>Uses pure recursion without mutation</li>
 *   <li>Expresses the algorithm in a declarative manner</li>
 *   <li>Runs in O(log n) time with O(log n) stack usage</li>
 *   <li>Assumes the input array is already sorted</li>
 * </ul>
 */
public final class PureBinarySearch {

    /**
     * Entry point for recursive binary search.
     *
     * @param arr    sorted array
     * @param target value to search for
     * @return index of target, or -1 if not found
     */
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        return searchRecursive(arr, target, 0, arr.length - 1);
    }

    /**
     * Recursive binary search helper.
     */
    private int searchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid;
        if (arr[mid] < target)
            return searchRecursive(arr, target, mid + 1, high);
        else
            return searchRecursive(arr, target, low, mid - 1);
    }
}
