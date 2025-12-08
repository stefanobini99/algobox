package com.stefano.algobox.algorithms.searching;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Functional-style Linear Search using Java Streams.
 *
 * <p>This version:
 * <ul>
 *   <li>Uses a declarative stream approach</li>
 *   <li>Does not mutate any array</li>
 *   <li>O(n) time complexity and O(1) additional space</li>
 * </ul>
 */
public final class PureLinearSearch {

    /**
     * Searches for a value in the array using streams.
     *
     * @param arr the array to search
     * @param target the value to find
     * @return index of target, or -1 if not found
     */
    public int search(int[] arr, int target) {
        if (arr == null) return -1;

        OptionalInt indexOpt = IntStream.range(0, arr.length)
                .filter(i -> arr[i] == target)
                .findFirst();

        return indexOpt.orElse(-1);
    }
}
