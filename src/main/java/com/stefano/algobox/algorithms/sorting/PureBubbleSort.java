package com.stefano.algobox.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Functional-style Bubble Sort implementation using immutable lists.
 * Characteristics:
 * <ul>
 *     <li>No mutation of any data structure</li>
 *     <li>Each bubble pass returns a new list instance</li>
 *     <li>Recursion replaces outer loops</li>
 * </ul>
 * </p>
 * <p>
 * This version is significantly less efficient than the imperative one,
 * but it clearly demonstrates the algorithm expressed in a functional paradigm.
 * </p>
 */
public final class PureBubbleSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] input) {
        List<Integer> list = Arrays.stream(input).boxed().toList();
        List<Integer> sorted = bubbleSort(list, list.size());
        return sorted.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> bubbleSort(List<Integer> list, int passes) {
        if (passes <= 1) return list;
        return bubbleSort(bubblePass(list), passes - 1);
    }

    /**
     * Performs one bubble pass and returns a NEW immutable list.
     */
    private List<Integer> bubblePass(List<Integer> list) {
        if (list.size() <= 1) return list;

        List<Integer> result = new ArrayList<>(list.size());
        int prev = list.getFirst();

        for (int i = 1; i < list.size(); i++) {
            int curr = list.get(i);

            if (prev > curr) {
                result.add(curr);
            } else {
                result.add(prev);
                prev = curr;
            }
        }

        result.add(prev);
        return List.copyOf(result);
    }
}
