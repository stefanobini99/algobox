package com.stefano.algobox.benchmarks;

import com.stefano.algobox.algorithms.sorting.MergeSortImperative;
import com.stefano.algobox.algorithms.sorting.QuickSortIterative;
import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)  // Measure average execution time
@OutputTimeUnit(TimeUnit.MILLISECONDS)  // Output in milliseconds
@State(Scope.Thread)  // Use one instance per thread
public class SortingBenchmark {

    private int[] array;

    private QuickSortIterative quickSortIterative = new QuickSortIterative();
    private MergeSortImperative mergeSortImperative = new MergeSortImperative();

    // Initialize the array before each benchmark
    @Setup(Level.Trial)
    public void setUp() {
        int size = 10000;  // Change this size as needed for benchmarking
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
    }

    // Benchmark for QuickSortIterative
    @Benchmark
    public int[] quickSortIterative() {
        int[] arrCopy = Arrays.copyOf(array, array.length);
        return quickSortIterative.sort(arrCopy);  // Instance method call
    }

    // Benchmark for MergeSortImperative
    @Benchmark
    public int[] mergeSortImperative() {
        int[] arrCopy = Arrays.copyOf(array, array.length);
        return mergeSortImperative.sort(arrCopy);  // Instance method call
    }

    // Optional: smaller array setup for additional benchmarking
    //@Setup(Level.Invocation)
    public void setUpSmall() {
        int size = 1000;
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
    }
}
