package com.stefano.algobox.cli;

import com.stefano.algobox.algorithms.dp.Fibonacci;
import com.stefano.algobox.algorithms.dp.Knapsack;
import com.stefano.algobox.algorithms.dp.LCS;
import com.stefano.algobox.algorithms.graphs.GraphAlgorithms;
import com.stefano.algobox.algorithms.searching.BinarySearchIterative;
import com.stefano.algobox.algorithms.searching.LinearSearchIterative;
import com.stefano.algobox.algorithms.sorting.BubbleSortIterative;
import com.stefano.algobox.algorithms.sorting.QuickSortIterative;
import com.stefano.algobox.algorithms.sorting.MergeSortImperative;
import com.stefano.algobox.algorithms.sorting.SortAlgorithm;
import com.stefano.algobox.algorithms.structures.GraphNode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlgoRunner {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to AlgoBox – Algorithms & Data Structures Explorer");
        boolean exit = false;

        // Main menu loop
        while (!exit) {
            displayMainMenu();
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1 -> runSorting();
                case 2 -> runSearching();
                case 3 -> runDynamicProgramming();
                case 4 -> runGraphAlgorithms();
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Exiting AlgoBox. Goodbye!");
    }

    // ---------------- Main Menu ----------------

    private static void displayMainMenu() {
        System.out.println("\nSelect a category:");
        System.out.println("1. Sorting");
        System.out.println("2. Searching");
        System.out.println("3. Dynamic Programming");
        System.out.println("4. Graph Algorithms");
        System.out.println("0. Exit");
    }

    // ---------------- Sorting ----------------

    private static void runSorting() {
        System.out.println("\nSelect sorting algorithm:");
        System.out.println("1. QuickSort");
        System.out.println("2. MergeSort");
        System.out.println("3. BubbleSort");

        int choice = readInt("Choice: ");
        SortAlgorithm sorter = selectSortingAlgorithm(choice);

        int[] input = readIntArray("Enter integers separated by spaces: ");
        int[] sorted = sorter.sort(input);

        System.out.println("Input:  " + Arrays.toString(input));
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }

    private static SortAlgorithm selectSortingAlgorithm(int choice) {
        return switch (choice) {
            case 1 -> new QuickSortIterative();
            case 2 -> new MergeSortImperative();
            case 3 -> new BubbleSortIterative();
            default -> {
                System.out.println("Invalid choice, defaulting to QuickSort");
                yield new QuickSortIterative();
            }
        };
    }

    // ---------------- Searching ----------------

    private static void runSearching() {
        System.out.println("\nSelect searching algorithm:");
        System.out.println("1. LinearSearch");
        System.out.println("2. BinarySearch (array must be sorted)");

        int choice = readInt("Choice: ");
        int[] input = readIntArray("Enter integers separated by spaces: ");
        int target = readInt("Enter target value: ");

        int index = search(choice, input, target);

        if (index >= 0)
            System.out.println("Found " + target + " at index " + index);
        else
            System.out.println(target + " not found");
    }

    private static int search(int choice, int[] input, int target) {
        return switch (choice) {
            case 1 -> {
                // LinearSearchIterative is not static, so instantiate it
                LinearSearchIterative linearSearch = new LinearSearchIterative();
                yield linearSearch.search(input, target);
            }
            case 2 -> {
                // BinarySearchIterative is not static, so instantiate it
                BinarySearchIterative binarySearch = new BinarySearchIterative();
                yield binarySearch.search(input, target);
            }
            default -> {
                System.out.println("Invalid choice, defaulting to LinearSearch");
                yield new LinearSearchIterative().search(input, target);
            }
        };
    }

    // ---------------- Dynamic Programming ----------------

    private static void runDynamicProgramming() {
        System.out.println("\nSelect DP problem:");
        System.out.println("1. Fibonacci");
        System.out.println("2. Knapsack");
        System.out.println("3. Longest Common Subsequence (LCS)");

        int choice = readInt("Choice: ");

        switch (choice) {
            case 1 -> {
                int n = readInt("Enter n: ");
                System.out.println("Fibonacci(" + n + ") = " + Fibonacci.memoized(n));
            }
            case 2 -> solveKnapsack();
            case 3 -> solveLCS();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void solveKnapsack() {
        int n = readInt("Number of items: ");
        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = readInt("Weight of item " + (i + 1) + ": ");
            values[i] = readInt("Value of item " + (i + 1) + ": ");
        }

        int W = readInt("Enter maximum capacity W: ");
        System.out.println("Maximum knapsack value: " + Knapsack.knapsack(weights, values, W));
    }

    private static void solveLCS() {
        String a = readLine("Enter first string: ");
        String b = readLine("Enter second string: ");
        System.out.println("LCS length: " + LCS.lcs(a, b));
    }

    // ---------------- Graph Algorithms ----------------

    private static void runGraphAlgorithms() {
        System.out.println("\nGraph algorithms are limited to demo nodes (1-3 nodes)");

        var node3 = new GraphNode<>(3, List.of());
        var node2 = new GraphNode<>(2, List.of(node3));
        var node1 = new GraphNode<>(1, List.of(node2, node3));

        System.out.println("Demo Graph: 1 -> 2 -> 3, 1 -> 3");

        System.out.println("DFS (Iterative): " + GraphAlgorithms.dfsIterative(node1));
        System.out.println("BFS: " + GraphAlgorithms.bfs(node1));
        System.out.println("Dijkstra distances: " + GraphAlgorithms.dijkstra(node1));
    }

    // ---------------- Utility methods ----------------

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input. Try again: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    private static int[] readIntArray(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine();
        return Arrays.stream(line.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
