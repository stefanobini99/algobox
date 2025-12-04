package com.stefano.algobox.algorithms.sorting;

/**
 * Imperative, in-place QuickSort implementation.
 *
 * <p>This version:
 * <ul>
 *   <li>Sorts a defensive clone of the input to preserve immutability externally</li>
 *   <li>Uses Lomuto partition scheme</li>
 *   <li>Performs recursive divide-and-conquer sorting</li>
 * </ul>
 *
 * <p>The algorithm runs in O(n log n) on average.</p>
 */
public final class QuickSortIterative implements SortAlgorithm {

    @Override
    public int[] sort(int[] input) {
        int[] copy = input.clone();
        quicksort(copy, 0, copy.length - 1);
        return copy;
    }

    /**
     * Recursive QuickSort helper method.
     */
    private void quicksort(int[] arr, int low, int high) {
        while (low < high) {
            int pivot = partition(arr, low, high);

            // Tail recursion elimination: recurse on smaller side first
            if (pivot - low < high - pivot) {
                quicksort(arr, low, pivot - 1);
                low = pivot + 1;
            } else {
                quicksort(arr, pivot + 1, high);
                high = pivot - 1;
            }
        }
    }

    /**
     * Lomuto partition scheme.
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);
        return i;
    }

    /**
     * Swap elements at given positions.
     */
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
