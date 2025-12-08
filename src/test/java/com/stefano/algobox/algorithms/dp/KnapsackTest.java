package com.stefano.algobox.algorithms.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Test
    void testKnapsack() {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 5;
        int expected = 7;

        assertEquals(expected, Knapsack.knapsack(weights, values, W), "Knapsack problem result is incorrect");
    }

    @Test
    void testKnapsackWithZeroCapacity() {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 0;
        int expected = 0;

        assertEquals(expected, Knapsack.knapsack(weights, values, W), "Knapsack with 0 capacity should have value 0");
    }

    @Test
    void testKnapsackWithSingleItem() {
        int[] weights = {5};
        int[] values = {10};
        int W = 5;
        int expected = 10;

        assertEquals(expected, Knapsack.knapsack(weights, values, W), "Knapsack with a single item should return the correct value");
    }
}
