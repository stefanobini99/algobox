package com.stefano.algobox.algorithms.searching;

@FunctionalInterface
public interface SearchAlgorithm {
    /** Returns index of target, or -1 if not found */
    int search(int[] input, int target);
}