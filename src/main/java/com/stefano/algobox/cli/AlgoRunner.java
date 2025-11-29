package com.stefano.algobox.cli;

import com.stefano.algobox.algorithms.sorting.QuickSort;

import java.util.Arrays;

public class AlgoRunner {
    public static void main(String[] args) {
        var sorter = new QuickSort();
        int[] input = {9, 2, 7, 1, 5};
        int[] sorted = sorter.sort(input);
        System.out.println("Input:  " + Arrays.toString(input));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
