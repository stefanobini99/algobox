package com.stefano.algobox.algorithms.searching;

/**
 * Imperative implementation of Binary Search.
 *
 * <p>This version:
 * <ul>
 *   <li>Uses an iterative approach with constant space usage</li>
 *   <li>Runs in O(log n) time</li>
 *   <li>Assumes the input array is already sorted</li>
 * </ul>
 */
public final class BinarySearchIterative {

    /**
     * Searches for a value in a sorted array.
     *
     * @param arr    the sorted array
     * @param target the value to search for
     * @return the index of the target, or -1 if not found
     */
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
