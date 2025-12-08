package com.stefano.algobox.algorithms.searching;

/**
 * Classic iterative implementation of Linear Search.
 *
 * <p>This version:
 * <ul>
 *   <li>Scans the array sequentially</li>
 *   <li>Returns the first index of the target if found</li>
 *   <li>O(n) time complexity and O(1) space</li>
 * </ul>
 */
public final class LinearSearchIterative {

    /**
     * Searches for a value in the array.
     *
     * @param arr the array to search
     * @param target the value to find
     * @return index of target, or -1 if not found
     */
    public int search(int[] arr, int target) {
        if (arr == null) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }

        return -1;
    }
}
